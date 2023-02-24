package com.ppfurtado.apipagamento.domain.dto;

public record PagamentoResponse(
        Long id,
        int codigoPagamento,
        String cpfCnpj,
        String numeroCartao,
        double valorPagamento
) {
}
