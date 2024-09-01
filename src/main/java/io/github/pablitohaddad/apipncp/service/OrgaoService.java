package io.github.pablitohaddad.apipncp.service;

import io.github.pablitohaddad.apipncp.consumer.ContractApiClient;
import io.github.pablitohaddad.apipncp.exception.ResourceBadRequestException;
import io.github.pablitohaddad.apipncp.exception.ResourceNotFoundException;
import io.github.pablitohaddad.apipncp.model.dto.*;
import io.github.pablitohaddad.apipncp.model.dto.mapper.ApiMapper;
import io.github.pablitohaddad.apipncp.model.entity.Contrato;
import io.github.pablitohaddad.apipncp.model.entity.Orgao;
import io.github.pablitohaddad.apipncp.repository.ContratoRepository;
import io.github.pablitohaddad.apipncp.repository.OrgaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrgaoService {

    private final ContratoRepository contratoRepository;
    private final ContractApiClient pncpConsumerFeign;
    private final OrgaoRepository orgaoRepository;

    public ContractSummaryResponse retrieveContracts(String dataInicial, String dataFinal, String cnpjOrgao, Integer pagina) {
        if (dataInicial == null || dataFinal == null || pagina == null || pagina < 1) {
            throw new ResourceBadRequestException("Verifique os parâmetros, houve algum erro");
        }
        // Consumo os dados Da API
        ContractSummaryResponse response = pncpConsumerFeign.retrieveContracts(dataInicial, dataFinal, cnpjOrgao, pagina);
        if (response == null || response.getData().isEmpty() || response.getData() == null){
            throw new ResourceNotFoundException("Esse cnpj não tem nenhum contrato em nosso sistema");
        }
        // Filtro de contratos
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate inicio = LocalDate.parse(dataInicial, formatter);
        List<ContractResponseDTO> contratosFiltrados = response.getData().stream()
                .filter(contrato -> {
                    LocalDate inicioContrato = LocalDate.parse(contrato.getDataVigenciaInicio(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    // Verifica se o contrato está dentro do intervalo
                    return inicioContrato.isAfter(inicio);
                })
                .peek(contrato -> { // Com o peek posso fazer operações sem mudar a stream. Nesse caso estou salvando minhas entidades no banco de dados.
                    Orgao orgaoEntidade = ApiMapper.parseObject(contrato.getOrgaoEntidade(), Orgao.class);
                    orgaoRepository.save(orgaoEntidade);

                    Contrato novoContrato = ApiMapper.parseObject(contrato, Contrato.class);
                    contratoRepository.save(novoContrato);
                })
                .collect(Collectors.toList());// transformo em lista.

        response.setData(contratosFiltrados);
        response.setTotalRegistros(contratosFiltrados.size());
        response.setValorTotal(String.valueOf(calculateTotalValue(contratosFiltrados))); // setando o valor total como String.
        return response;
    }

    // Método de calculo do valor total
    private double calculateTotalValue(List<ContractResponseDTO> contratosFiltrados) {
        double totalValor = 0.0;
        for (ContractResponseDTO contrato : contratosFiltrados) {
            String valorInicialString = contrato.getValorInicial();
            if (valorInicialString == null || valorInicialString.isEmpty()) {
                throw new ResourceNotFoundException("Nenhum valor em nenhum contrato");
            }
            double valor = Double.parseDouble(valorInicialString.replaceAll(",", "."));
            totalValor += valor;
        }
        return totalValor;
    }

}
