package br.edu.ifto.aula05.model.entity;

import jakarta.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String razaoSocial;

    // Getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getNomeOuRazaoSicial() {
        return this.razaoSocial;
    }
}
