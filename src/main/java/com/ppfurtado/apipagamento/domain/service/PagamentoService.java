package com.ppfurtado.apipagamento.domain.service;

import com.ppfurtado.apipagamento.domain.dto.PagamentoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoResponse;
import com.ppfurtado.apipagamento.domain.mapper.PagamentoMapper;
import com.ppfurtado.apipagamento.domain.model.Pagamento;
import com.ppfurtado.apipagamento.domain.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

public class PagamentoService {


    private final PagamentoMapper mapper;
    private final PagamentoRepository repository;

    public PagamentoService(PagamentoMapper mapper, PagamentoRepository pagamentoRepository) {
        this.mapper = mapper;
        this.repository = pagamentoRepository;
    }

    public PagamentoResponse save(PagamentoRequest request){
        Pagamento pagamento = mapper.requestToPagamento(request);
        return mapper.pagamentoToResponse(repository.save(pagamento));
    }


}
