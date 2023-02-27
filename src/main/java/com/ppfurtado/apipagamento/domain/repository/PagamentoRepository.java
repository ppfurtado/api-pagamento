package com.ppfurtado.apipagamento.domain.repository;


import com.ppfurtado.apipagamento.domain.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> filtroPagamento(Long id, String cpfCnpj, String status);
}
