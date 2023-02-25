package com.ppfurtado.apipagamento.controller;


import com.ppfurtado.apipagamento.domain.dto.PagamentoRequest;
import com.ppfurtado.apipagamento.domain.dto.PagamentoResponse;
import com.ppfurtado.apipagamento.domain.model.Pagamento;
import com.ppfurtado.apipagamento.domain.service.PagamentoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/pagamento")
public class PagamentoController {

    private final PagamentoService service;


    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @PostMapping("/salvar")
    public PagamentoResponse save(@RequestBody @Validated PagamentoRequest request){
        return service.save(request);
    }

    @GetMapping("/buscar-pagamentos")
    public List<Pagamento> findAll(){
        return service.findAll();
    }

}
