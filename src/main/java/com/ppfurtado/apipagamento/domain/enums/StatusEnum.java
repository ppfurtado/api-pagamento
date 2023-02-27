package com.ppfurtado.apipagamento.domain.enums;

public enum StatusEnum {

    PENDENTE("PENDENTE"), SUCESSO("SUCESSO"), FALHA("FALHA");

    private final String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
