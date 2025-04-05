package com.mistura_boa.mistura_boa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.mistura_boa.mistura_boa.models.entities.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    public UserDetails findByEmail(String email);
}
