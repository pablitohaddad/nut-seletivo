package io.github.pablitohaddad.apipncp.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orgao")
public class Orgao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    @Column(name = "esfera_id", nullable = false)
    private String esferaId;
    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;
    @Column(name = "poder_id", nullable = false)
    private String poderId;

    public Orgao(Long id, String cnpj, String esferaId, String razaoSocial, String poderId) {
        this.id = id;
        this.cnpj = cnpj;
        this.esferaId = esferaId;
        this.razaoSocial = razaoSocial;
        this.poderId = poderId;
    }

    public Orgao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEsferaId() {
        return esferaId;
    }

    public void setEsferaId(String esferaId) {
        this.esferaId = esferaId;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getPoderId() {
        return poderId;
    }

    public void setPoderId(String poderId) {
        this.poderId = poderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orgao orgao = (Orgao) o;
        return Objects.equals(id, orgao.id) && Objects.equals(cnpj, orgao.cnpj) && Objects.equals(esferaId, orgao.esferaId) && Objects.equals(razaoSocial, orgao.razaoSocial) && Objects.equals(poderId, orgao.poderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj, esferaId, razaoSocial, poderId);
    }
}
