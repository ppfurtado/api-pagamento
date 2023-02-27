package com.ppfurtado.apipagamento.domain.dto;

import com.ppfurtado.apipagamento.domain.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;

public record AtualizacaoRequest(
        @NotBlank
        StatusEnum status
) {
}
