package com.mistura_boa.mistura_boa.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mistura_boa.mistura_boa.models.dtos.ProdutoCarrinhoDTO;
import com.mistura_boa.mistura_boa.models.entities.ProdutoCarrinho;
import com.mistura_boa.mistura_boa.repositories.IProdutoCarrinhoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoCarrinhoService {

    private final IProdutoCarrinhoRepository produtoCarrinhoRepository;
    private final ModelMapper modelMapper;

    public ProdutoCarrinhoDTO save(ProdutoCarrinhoDTO dto){
        var produtoCarrinho = this.produtoCarrinhoRepository.save(modelMapper.map(dto, ProdutoCarrinho.class));
        return modelMapper.map(produtoCarrinho, ProdutoCarrinhoDTO.class);
    }

    public void delete(Long id){
        this.produtoCarrinhoRepository.deleteById(id);
    }

}
