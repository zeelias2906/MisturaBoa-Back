package com.mistura_boa.mistura_boa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistura_boa.mistura_boa.models.entities.Pessoa;

public interface IPessoaRepository  extends JpaRepository<Pessoa, Long> {

    public Pessoa findByCpf(String cpf);

}
