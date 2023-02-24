package com.ppfurtado.apipagamento.domain.dto.mapper;

import com.ppfurtado.apipagamento.domain.dto.PagamentoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoResponse;
import com.ppfurtado.apipagamento.domain.model.Pagamento;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PagamentoMapper {

    Pagamento requestToPagamento(PagamentoRequest request);

    PagamentoResponse pagamentoToResponse(Pagamento pagamento);
}
