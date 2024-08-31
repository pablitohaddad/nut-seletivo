package io.github.pablitohaddad.apipncp.consumer;

import io.github.pablitohaddad.apipncp.model.dto.ContractSummaryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "pncp-api", url = "https://pncp.gov.br/api/consulta/v1/contratos") // Url que eu vou consumir
public interface ContractApiClient {

    @GetMapping()
    ContractSummaryResponse retrieveContracts(@RequestParam(value = "dataInicial") String dataInicial, // parametros utilizados para completar
                                         @RequestParam(value = "dataFinal") String dataFinal,
                                         @RequestParam(value = "cnpjOrgao") String cnpjOrgao,
                                         @RequestParam(value = "pagina") Integer pagina);

}
