package io.github.pablitohaddad.apipncp.model.dto;

import java.util.List;
import java.util.Objects;

public class ContractSummaryResponse {
    List<ContractResponseDTO> data;

    String valorTotal;

    public ContractSummaryResponse(List<ContractResponseDTO> data, String valorTotal) {
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public ContractSummaryResponse() {
    }

    public List<ContractResponseDTO> getData() {
        return data;
    }

    public void setData(List<ContractResponseDTO> data) {
        this.data = data;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractSummaryResponse that = (ContractSummaryResponse) o;
        return Objects.equals(data, that.data) && Objects.equals(valorTotal, that.valorTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, valorTotal);
    }
}
