package com.mistura_boa.mistura_boa.services;

import org.springframework.stereotype.Service;

import com.mistura_boa.mistura_boa.repositories.IPessoaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final IPessoaRepository pessoaRepository;

    public boolean isCpfUnique(String cpf){
        var pessoa = pessoaRepository.findByCpf(cpf);
        return pessoa == null;
    }

}
