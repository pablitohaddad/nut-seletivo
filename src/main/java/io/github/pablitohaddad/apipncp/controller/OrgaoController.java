package io.github.pablitohaddad.apipncp.controller;

import io.github.pablitohaddad.apipncp.exception.ExceptionResponse;
import io.github.pablitohaddad.apipncp.model.dto.ContractSummaryResponse;
import io.github.pablitohaddad.apipncp.service.OrgaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/consulta/v1")
public class OrgaoController {

    @Autowired
    private OrgaoService orgaoService;

    @Operation(summary = "Pega os dados do contrato",
            responses = {
                    @ApiResponse(responseCode = "200", description = "O recurso foi encontrado com sucesso",
                            content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ContractSummaryResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Recurso não encontrado",
                            content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Houve algum erro na sua requisição",
                            content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class)))
            })
    @GetMapping("/contracts")
    public ResponseEntity<ContractSummaryResponse> retrieveContracts(String dataInicial, String dataFinal, String cnpjOrgao, Integer pagina){
        ContractSummaryResponse response = orgaoService.retrieveContracts(dataInicial, dataFinal, cnpjOrgao, pagina);
        return ResponseEntity.status(HttpStatus.OK).body(response); // Retorna com status 200 e o corpo da resposta
    }

}
