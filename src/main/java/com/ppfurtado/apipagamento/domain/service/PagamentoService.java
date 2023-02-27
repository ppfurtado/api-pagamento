package com.ppfurtado.apipagamento.domain.service;

import com.ppfurtado.apipagamento.domain.dto.PagamentoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoResponse;
import com.ppfurtado.apipagamento.domain.mapper.PagamentoMapper;
import com.ppfurtado.apipagamento.domain.model.Pagamento;
import com.ppfurtado.apipagamento.domain.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public List<Pagamento> findAll(){
        return repository.findAll();
    }


    public PagamentoResponse update(Long id, AtualizacaoRequest request) {

        Pagamento pagamento = findById(id);
        String statusPagamento = pagamento.getStatus().getValue();
        String statusRequest = request.status().getValue();

        if (StatusEnum.SUCESSO.getValue().equals(statusPagamento)){
            throw new NegocioException("O Pagamento está Processado com SUCESSO, por isso não pode ter seu status alterado");
        } else if(StatusEnum.FALHA.getValue().equals(statusPagamento) && !(StatusEnum.PENDENTE.getValue().equals(statusRequest))) {
            throw new NegocioException("O Pagamento está Processado com Falha, por isso ele só pode ter seu status alterado para PENDENTE");
        }

        pagamento.setStatus(request.status());

        return mapper.pagamentoToResponse(repository.save(pagamento));

    }

    public PagamentoResponse delete(Long id) {
        Pagamento pagamento = findById(id);
        if (!StatusEnum.PENDENTE.getValue().equals(pagamento.getStatus().getValue())){
            throw new NegocioException("Apenas os pagamentos em status Pendente podem ser deletados");
        }
        repository.delete(pagamento);

        return mapper.pagamentoToResponse(pagamento);
    }
}
