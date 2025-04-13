package com.mistura_boa.mistura_boa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistura_boa.mistura_boa.models.entities.ProdutoCarrinho;

public interface IProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Long> {

}
