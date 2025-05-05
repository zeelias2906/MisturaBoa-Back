package com.mistura_boa.mistura_boa.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mistura_boa.mistura_boa.models.dtos.UsuarioDTO;
import com.mistura_boa.mistura_boa.models.entities.Usuario;
import com.mistura_boa.mistura_boa.repositories.IUsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;
	private final PessoaService pessoaService;
	private final ModelMapper modelMapper;

	public UsuarioDTO update(UsuarioDTO dto) throws Exception{
		var usuario = this.usuarioRepository.findById(dto.getId()).orElseThrow(() -> new Exception("Usuário não encontrado"));
		dto.setSenha(usuario.getSenha());
		dto.setRoleUsuario(usuario.getRoleUsuario());

		if(isEmailUnique(dto.getEmail(), dto.getId())){
			throw new Exception("E-mail já cadastrado no sistema");
		}

		pessoaService.update(dto.getPessoa());
	
		usuarioRepository.save(modelMapper.map(dto, Usuario.class));
		dto.setSenha(null);
		dto.setRoleUsuario(null);
        return dto;
    }

    public UsuarioDTO findById(Long id) throws Exception {
        var usuario = this.usuarioRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));

        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public boolean validateSenha(String senha) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
		return !senha.matches(regex);
	}

	public boolean isEmailUnique(String email, Long id){
		return  usuarioRepository.isEmailUnique(email, id);
	}

}
