package com.ppfurtado.apipagamento.domain.dto;


import com.ppfurtado.apipagamento.domain.enums.MetodoPagamentoEnum;
import com.ppfurtado.apipagamento.domain.enums.StatusEnum;

public record PagamentoResponse(
        Long id,
        String cpfCnpj,
        MetodoPagamentoEnum metodoPagamento,
        String numeroCartao,
        double valorPagamento,
        StatusEnum status
) {
}
