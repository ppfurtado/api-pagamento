package com.ppfurtado.apipagamento.domain.dto;

import jakarta.validation.constraints.*;

public record PagamentoRequest(

        @NotBlank
        @Size(min = 9, max = 14, message = "O campo cpf_cnpj é entre 11 and 14")
        String cpfCnpj,

        @NotBlank
        String metodoPagamento,

        String numeroCartao,

        @NotNull
        double valorPagamento) {

}
