package com.mistura_boa.mistura_boa.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mistura_boa.mistura_boa.repositories.IProdutoPedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoPedidoService {

    private final IProdutoPedidoRepository produtoPedidoRepository;
    private final ModelMapper modelMapper;


    

}
