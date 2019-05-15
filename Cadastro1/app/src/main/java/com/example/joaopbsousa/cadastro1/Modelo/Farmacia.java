package com.example.joaopbsousa.cadastro1.Modelo;

public class Farmacia {

    private Double cnpj;
    private String nome;
    private String endereco;
    private Double telefone;
    private Double cep;

    public Farmacia() {
    }

    public Double getCnpj() {
        return cnpj;
    }

    public void setCnpj(Double cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getTelefone() {
        return telefone;
    }

    public void setTelefone(Double telefone) {
        this.telefone = telefone;
    }

    public Double getCep() {
        return cep;
    }

    public void setCep(Double cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Farmacia{" +
                "cnpj=" + cnpj +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone=" + telefone +
                ", cep=" + cep +
                '}';
    }
}
