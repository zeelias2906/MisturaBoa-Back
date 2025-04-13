package com.mistura_boa.mistura_boa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mistura_boa.mistura_boa.services.ProdutoCarrinhoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("produto-carrinho")
@RequiredArgsConstructor
public class ProdutoCarrinhoController {
    
    private final ProdutoCarrinhoService produtoCarrinhoService;


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('CLIENTE')")
	public ResponseEntity<?> save(@PathVariable Long id) throws Exception {
		try {
            produtoCarrinhoService.delete(id);
            return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}



}
