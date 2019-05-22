package com.example.charlesprovatti.farma.Farma;

public class Produto
{

    private String imagem;
    private String uidproduto;
    private String nome;
    private String fabricante;
    private String descricao;

    public Produto() {
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getUidproduto() {
        return uidproduto;
    }

    public void setUidproduto(String uidproduto) {
        this.uidproduto = uidproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
