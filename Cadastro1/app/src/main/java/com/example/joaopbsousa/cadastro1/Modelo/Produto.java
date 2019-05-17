package com.example.joaopbsousa.cadastro1.Modelo;

public class Produto {

    private String nome;
    private Double preco;
    private String descricao;
    private String fabricante;
    private String uidproduto;
    private String imagem;
    private String Farmacia;

    public String getUidproduto() {
        return uidproduto;
    }

    public void setUidproduto(String uidproduto) {
        this.uidproduto = uidproduto;
    }

    public String getFarmacia() {
        return Farmacia;

    }

    public void setFarmacia(String farmacia) {
        Farmacia = farmacia;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Produto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", uidproduto='" + uidproduto + '\'' +
                ", imagem='" + imagem + '\'' +
                ", Farmacia='" + Farmacia + '\'' +
                '}';
    }
}
