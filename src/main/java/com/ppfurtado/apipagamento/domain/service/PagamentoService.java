package com.ppfurtado.apipagamento.domain.service;

import com.ppfurtado.apipagamento.domain.dto.PagamentoRequest;
import com.ppfurtado.apipagamento.domain.dto.mapper.PagamentoMapper;
import com.ppfurtado.apipagamento.domain.model.Pagamento;
import com.ppfurtado.apipagamento.domain.repository.PagamentoRepository;

public class PagamentoService {

    private final PagamentoRepository repository;
    private final PagamentoMapper mapper;

    public PagamentoService(PagamentoRepository pagamentoRepository, PagamentoMapper mapper) {
        this.repository = pagamentoRepository;
        this.mapper = mapper;
    }

    public Pagamento save(PagamentoRequest request){
        Pagamento pagamento = mapper.requestToPagamento(request);
        return repository.save(pagamento);
    }


}
