package com.ppfurtado.apipagamento.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record PagamentoRequest(
        @NotBlank
        int codigoPagamento,
        @NotBlank
        String cpfCnpj,
        @NotBlank
        String numeroCartao,
        @NotBlank
        double valorPagamento) {

}
