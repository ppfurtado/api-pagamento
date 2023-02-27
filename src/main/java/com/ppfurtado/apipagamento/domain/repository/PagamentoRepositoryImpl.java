package com.ppfurtado.apipagamento.domain.repository;

import com.ppfurtado.apipagamento.domain.enums.StatusEnum;
import com.ppfurtado.apipagamento.domain.model.Pagamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;


@Repository
public class PagamentoRepositoryImpl {

    @PersistenceContext
    EntityManager manager;

    public List<Pagamento> filtroPagamento(Long id, String cpfCnpj, String status){

        StringBuilder jpql = new StringBuilder();
        jpql.append("from PAGAMENTO where 0 = 0");
        HashMap<String, Object> pagamentos = new HashMap<>();

        if(id != null){
            jpql.append(" and id = : id");
            pagamentos.put("id", id);
        }
        if(StringUtils.hasLength(cpfCnpj)) {
            jpql.append(" and cpfCnpj = :cpfCnpj");
            pagamentos.put("cpfCnpj", cpfCnpj);
        }
        if(StringUtils.hasLength(status)) {
            jpql.append(" and status = :status");
            pagamentos.put("status", StatusEnum.valueOf(status));
        }


        TypedQuery<Pagamento> query = manager.createQuery(jpql.toString(), Pagamento.class);
        pagamentos.forEach(query::setParameter);

        return query.getResultList();
    }

}
