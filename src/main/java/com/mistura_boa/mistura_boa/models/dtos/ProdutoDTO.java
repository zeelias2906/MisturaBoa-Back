package com.mistura_boa.mistura_boa.models.dtos;

import java.time.LocalDateTime;


import com.mistura_boa.mistura_boa.models.entities.Categoria;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO {

	private Long id;
    @NotBlank(message = "Descrição não pode ser vazia")
    private String descricao;
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;
    @NotBlank(message = "Número não pode ser vazio")
    private String numero;
    private LocalDateTime dataExclusao;
    @NotBlank(message = "Produto precisa ter uma imagem")
    private String imgProduto;
    private Float valor;
    private CategoriaDTO categoria;

}
