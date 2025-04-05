package com.mistura_boa.mistura_boa.models.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDTO {

	private Long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String telefone;
	@JsonIgnore
	private UsuarioDTO usuario;

}
