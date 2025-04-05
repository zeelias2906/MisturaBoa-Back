package com.mistura_boa.mistura_boa.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mistura_boa.mistura_boa.models.entities.Produto;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ImplProdutoRepository {

    private final EntityManager entityManager;

    public List<Produto> search(String nome){
        var hql = new StringBuilder();
        hql.append("SELECT distinct p ");
        hql.append("FROM Produto p ");

        if(nome != null && !nome.isEmpty() && !nome.isBlank()){
            hql.append("WHERE lower(p.nome) LIKE lower(concat('%',:nome, '%')) ");
        }

        var query = entityManager.createQuery(hql.toString(), Produto.class);
        if(nome != null && !nome.isEmpty() && !nome.isBlank()){
            query.setParameter("nome", nome);
        }

        return query.getResultList();
    }

}
