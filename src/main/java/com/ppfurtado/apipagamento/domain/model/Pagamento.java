package com.ppfurtado.apipagamento.domain.model;


import com.ppfurtado.apipagamento.domain.enums.MetodoPagamentoEnum;
import com.ppfurtado.apipagamento.domain.enums.StatusEnum;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    private MetodoPagamentoEnum metodoPagamento;

    private String numeroCartao;

    private double valorPagamento;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public Pagamento() {
    }

    public Pagamento(Long id, String cpfCnpj, MetodoPagamentoEnum metodoPagamento, String numeroCartao, double valorPagamento, StatusEnum status) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.metodoPagamento = metodoPagamento;
        this.numeroCartao = numeroCartao;
        this.valorPagamento = valorPagamento;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public MetodoPagamentoEnum getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamentoEnum metodoPagamentoEnum) {
        this.metodoPagamento = metodoPagamentoEnum;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id) && Objects.equals(cpfCnpj, pagamento.cpfCnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpfCnpj);
    }

    @PrePersist
    public void preStatus() {
        this.setStatus(StatusEnum.PENDENTE);
    }
}
