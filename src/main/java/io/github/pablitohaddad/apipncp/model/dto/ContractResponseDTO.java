package io.github.pablitohaddad.apipncp.model.dto;

import io.github.pablitohaddad.apipncp.model.entity.Orgao;

import java.util.Objects;

public class ContractResponseDTO {

    private Orgao orgaoEntidade;

    private String dataVigenciaInicio;
    private String dataVigenciaFim;
    private String objetoContrato;
    private String valorInicial;
    private String nomeRazaoSocialFornecedor;

    public ContractResponseDTO(Orgao orgaoEntidade, String dataVigenciaInicio, String dataVigenciaFim, String objetoContrato, String valorInicial, String nomeRazaoSocialFornecedor) {
        this.orgaoEntidade = orgaoEntidade;
        this.dataVigenciaInicio = dataVigenciaInicio;
        this.dataVigenciaFim = dataVigenciaFim;
        this.objetoContrato = objetoContrato;
        this.valorInicial = valorInicial;
        this.nomeRazaoSocialFornecedor = nomeRazaoSocialFornecedor;
    }

    public Orgao getOrgaoEntidade() {
        return orgaoEntidade;
    }

    public void setOrgaoEntidade(Orgao orgaoEntidade) {
        this.orgaoEntidade = orgaoEntidade;
    }

    public String getDataVigenciaInicio() {
        return dataVigenciaInicio;
    }

    public void setDataVigenciaInicio(String dataVigenciaInicio) {
        this.dataVigenciaInicio = dataVigenciaInicio;
    }

    public String getDataVigenciaFim() {
        return dataVigenciaFim;
    }

    public void setDataVigenciaFim(String dataVigenciaFim) {
        this.dataVigenciaFim = dataVigenciaFim;
    }

    public String getObjetoContrato() {
        return objetoContrato;
    }

    public void setObjetoContrato(String objetoContrato) {
        this.objetoContrato = objetoContrato;
    }

    public String getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(String valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getNomeRazaoSocialFornecedor() {
        return nomeRazaoSocialFornecedor;
    }

    public void setNomeRazaoSocialFornecedor(String nomeRazaoSocialFornecedor) {
        this.nomeRazaoSocialFornecedor = nomeRazaoSocialFornecedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractResponseDTO that = (ContractResponseDTO) o;
        return Objects.equals(orgaoEntidade, that.orgaoEntidade) && Objects.equals(dataVigenciaInicio, that.dataVigenciaInicio) && Objects.equals(dataVigenciaFim, that.dataVigenciaFim) && Objects.equals(objetoContrato, that.objetoContrato) && Objects.equals(valorInicial, that.valorInicial) && Objects.equals(nomeRazaoSocialFornecedor, that.nomeRazaoSocialFornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgaoEntidade, dataVigenciaInicio, dataVigenciaFim, objetoContrato, valorInicial, nomeRazaoSocialFornecedor);
    }
}
