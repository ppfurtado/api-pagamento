package com.ppfurtado.apipagamento.controller;

import com.ppfurtado.apipagamento.domain.dto.AtualizacaoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoResponse;
import com.ppfurtado.apipagamento.domain.enums.StatusEnum;
import com.ppfurtado.apipagamento.utils.ResponseRest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PagamentoControllerWeb {

    @Operation(summary = "Fazer um Pagamento.", description = "Fazer um Pgamento", tags = {"Pagamento"})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Inclusão Realizada com Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PagamentoResponse.class))) }),
            @ApiResponse(responseCode = "400", description = "Pagamento Inválida", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pagamento não foi salvo", content = @Content) })
    ResponseEntity<ResponseRest<PagamentoResponse>> save(
            @Parameter(in = ParameterIn.DEFAULT, required = true, schema = @Schema())
            @RequestBody @Validated PagamentoRequest request);

    @Operation(summary = "Buscar Pagamentos.", description = "Buscar todos os Pgamentos", tags = {"Pagamento"})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Busca Realizada com Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PagamentoResponse.class))) }),
            @ApiResponse(responseCode = "400", description = "Busca Inválida", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pagamentos não foram encontrados", content = @Content) })
    @GetMapping("/buscar-pagamentos")
    ResponseEntity<ResponseRest<List<PagamentoResponse>>> find(
            @Parameter(in = ParameterIn.DEFAULT, schema = @Schema())
            @RequestParam(required = false) Long id,
            @Parameter(in = ParameterIn.DEFAULT, schema = @Schema())
            @RequestParam(required = false) String cpfCnpj,
            @Parameter(in = ParameterIn.DEFAULT, schema = @Schema())
            @RequestParam(required = false) StatusEnum statusEnum);

    @Operation(summary = "Atualizar Pagamento", description = "Atualizar Paga,emtp", tags = {"Pagamento"})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Atualização Realizada com Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PagamentoResponse.class))) }),
            @ApiResponse(responseCode = "400", description = "Atualização Inválida", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pagamento não foi atualizado", content = @Content) })
    ResponseEntity<ResponseRest<PagamentoResponse>> update(
            @Parameter(in = ParameterIn.DEFAULT, required = true, schema = @Schema())
            @PathVariable Long id,
            @Parameter(in = ParameterIn.DEFAULT, required = true, schema = @Schema())
            @RequestBody AtualizacaoRequest request);

    @Operation(summary = "Deletar Pagamento", description = "Apenas os pagamentos com status pendentes podem ser deletados", tags = {"Pagamento"})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Pagamento deletado com Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PagamentoResponse.class))) }),
            @ApiResponse(responseCode = "400", description = "Exclusão Inválida", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pagamento não foi deletado", content = @Content) })
    ResponseEntity<ResponseRest<PagamentoResponse>> delete(
            @Parameter(in = ParameterIn.DEFAULT, required = true, schema = @Schema())
            @PathVariable Long id);
}
