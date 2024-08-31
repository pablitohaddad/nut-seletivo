package io.github.pablitohaddad.apipncp.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id gera na ordem: 1... 2... 3... 4...
    private Long id;

    @Column(name = "data_vigilancia_inicio", nullable = false)
    private String dataVigenciaInicio;

    @Column(name = "data_vigilancia_fim", nullable = false)
    private String dataVigenciaFim;

    @Column(name = "objeto_contrato", nullable = false, length = 100000)
    private String objetoContrato;

    @Column(name = "valor_inicial", nullable = false)
    private String valorInicial;

    public Contrato(Long id, String dataVigenciaInicio, String dataVigenciaFim, String objetoContrato, String valorInicial) {
        this.id = id;
        this.dataVigenciaInicio = dataVigenciaInicio;
        this.dataVigenciaFim = dataVigenciaFim;
        this.objetoContrato = objetoContrato;
        this.valorInicial = valorInicial;
    }

    public Contrato() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return Objects.equals(id, contrato.id) && Objects.equals(dataVigenciaInicio, contrato.dataVigenciaInicio) && Objects.equals(dataVigenciaFim, contrato.dataVigenciaFim) && Objects.equals(objetoContrato, contrato.objetoContrato) && Objects.equals(valorInicial, contrato.valorInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataVigenciaInicio, dataVigenciaFim, objetoContrato, valorInicial);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
