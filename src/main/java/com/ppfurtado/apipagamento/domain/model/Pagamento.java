package com.ppfurtado.apipagamento.domain.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int codigoPagamento;

    private String cpfCnpj;

    private String numeroCartao;

    private double valorPagamento;

    public Pagamento() {
    }

    public Pagamento(int codigoPagamento, String cpfCnpj, String numeroCartao, double valorPagamento) {
        this.codigoPagamento = codigoPagamento;
        this.cpfCnpj = cpfCnpj;
        this.numeroCartao = numeroCartao;
        this.valorPagamento = valorPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(int codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return codigoPagamento == pagamento.codigoPagamento && Objects.equals(id, pagamento.id) && Objects.equals(cpfCnpj, pagamento.cpfCnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoPagamento, cpfCnpj);
    }
}
