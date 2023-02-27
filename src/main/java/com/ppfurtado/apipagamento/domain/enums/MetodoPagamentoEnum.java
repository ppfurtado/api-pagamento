package com.ppfurtado.apipagamento.domain.enums;


public enum MetodoPagamentoEnum {
    BOLETO("BOLETO"), PIX("PIX"), CARTAO_CREDITO("CARTAO_CREDITO"), CARTAO_DEBITO("CARTAO_DEBITO");

    private final String value;

    MetodoPagamentoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
