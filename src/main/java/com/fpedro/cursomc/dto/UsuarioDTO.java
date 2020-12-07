package com.fpedro.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fpedro.cursomc.domain.Usuario;

import org.hibernate.validator.constraints.Length;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 a 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email Invalido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 3, message = "O tamanho deve ser entre 1 a 3 caracteres")
    private Integer idade;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 11, message = "O cpf deve conter 11 caracteres")
    private String cpfOuCnpj;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 3, message = "O tipo deve conter no máximo 2 caracteres")
    private Integer tipo;

    public UsuarioDTO() {

    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public UsuarioDTO(Usuario obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
     }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioDTO(Integer id,
            @NotEmpty(message = "Preenchimento obrigatório") @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 a 120 caracteres") String nome,
            @NotEmpty(message = "Preenchimento obrigatório") @Email(message = "Email Invalido") String email,
            Integer idade, String cpfOuCnpj, Integer tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
    }


}