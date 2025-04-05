package com.mistura_boa.mistura_boa.services;

import org.springframework.stereotype.Service;

import com.mistura_boa.mistura_boa.repositories.IUsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public boolean validateSenha(String senha) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
		return !senha.matches(regex);
	}

	public boolean isEmailUnique(String email){
		var usuario = usuarioRepository.findByEmail(email);
		return usuario == null;
	}


}
