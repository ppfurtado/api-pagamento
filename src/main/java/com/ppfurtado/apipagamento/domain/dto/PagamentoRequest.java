package com.ppfurtado.apipagamento.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;

public record PagamentoRequest(
        @NotNull
        int codigoPagamento,

        @NotBlank
        @Max(14)
        @Min(11)
        String cpfCnpj,

        @NotBlank
        @Max(19)
        @Min(13)
        String numeroCartao,

        @NotNull
        double valorPagamento) {

}
