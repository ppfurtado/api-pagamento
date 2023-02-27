package com.ppfurtado.apipagamento.controller;


import com.ppfurtado.apipagamento.domain.dto.AtualizacaoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoResponse;
import com.ppfurtado.apipagamento.domain.enums.StatusEnum;
import com.ppfurtado.apipagamento.domain.service.PagamentoService;
import com.ppfurtado.apipagamento.utils.Properties;
import com.ppfurtado.apipagamento.utils.ResponseRest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/pagamento")
@Tag(name = "Pagamento", description = "Crud API Pagamento")
public class PagamentoController implements PagamentoControllerWeb {

    private final PagamentoService service;


    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/salvar")
    public ResponseEntity<ResponseRest<PagamentoResponse>> save(@RequestBody @Validated PagamentoRequest request){
        PagamentoResponse pagamentoResponse = service.save(request);
        Properties properties = new Properties(0, HttpStatus.OK, "Pagamento criado com Sucesso");
        return ResponseEntity.ok(new ResponseRest<>(pagamentoResponse, properties, null));
    }

    @Override
    @GetMapping("/buscar-pagamentos")
    public ResponseEntity<ResponseRest<List<PagamentoResponse>>> find(@RequestParam(required = false) Long id,
                                           @RequestParam(required = false) String cpfCnpj,
                                           @RequestParam(required = false) StatusEnum statusEnum){
        List<PagamentoResponse> pagamentoResponses = service.findAll(id, cpfCnpj, statusEnum);
        Properties properties = new Properties(0, HttpStatus.OK, "Busca atualizada com Sucesso");
        return ResponseEntity.ok(new ResponseRest<>(pagamentoResponses, properties, null));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ResponseRest<PagamentoResponse>> update(@PathVariable Long id, @RequestBody AtualizacaoRequest request){
        PagamentoResponse pagamentoResponse = service.update(id, request);
        Properties properties = new Properties(0, HttpStatus.OK, "Pagamento atualizado com Sucesso");
        return ResponseEntity.ok(new ResponseRest<>(pagamentoResponse, properties, null));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseRest<PagamentoResponse>> delete(@PathVariable Long id){
        PagamentoResponse pagamentoResponse = service.delete(id);

        Properties properties = new Properties(0, HttpStatus.OK, "Pagamento deletado com Sucesso");
        return ResponseEntity.ok(new ResponseRest<>(pagamentoResponse, properties, null));
    }

}
