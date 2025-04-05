package com.mistura_boa.mistura_boa.models.dtos;


import com.mistura_boa.mistura_boa.models.enums.RoleUsuarioEnum;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

	private Long id;
	private String email;
	private String senha;
	private RoleUsuarioEnum roleUsuario;
	private PessoaDTO pessoa;
}
