package com.ppfurtado.apipagamento.domain.service;

import com.ppfurtado.apipagamento.domain.dto.AtualizacaoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoResponse;
import com.ppfurtado.apipagamento.domain.dto.mapper.PagamentoMapper;
import com.ppfurtado.apipagamento.domain.enums.MetodoPagamentoEnum;
import com.ppfurtado.apipagamento.domain.enums.StatusEnum;
import com.ppfurtado.apipagamento.domain.model.Pagamento;
import com.ppfurtado.apipagamento.domain.repository.PagamentoRepository;
import com.ppfurtado.apipagamento.exception.NegocioException;
import com.ppfurtado.apipagamento.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        String metodoPagamento = request.metodoPagamento();
        boolean usandoCartao =(metodoPagamento.equals(MetodoPagamentoEnum.CARTAO_CREDITO.getValue())) ||
                (metodoPagamento.equals(MetodoPagamentoEnum.CARTAO_DEBITO.getValue()));

        if (!usandoCartao){
            pagamento.setNumeroCartao(null);
        } else {
            if (request.numeroCartao() == null || request.numeroCartao().isEmpty()){
                throw new NegocioException("Para os métodos de pagamento cartão credito e cartão debito, é necessário " +
                        "informar um número de cartão");
            }
        }

        return mapper.pagamentoToResponse(repository.save(pagamento));
    }

    public List<PagamentoResponse> findAll(Long id, String cpfCnpj, StatusEnum statusEnum){
        List<Pagamento> pagamentos = repository.filtroPagamento(id, cpfCnpj, Objects.toString(statusEnum, null));
        return pagamentos.stream().map(mapper::pagamentoToResponse).toList();
    }

    public Pagamento findById(Long id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Pagamento Não encotrado"));
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
