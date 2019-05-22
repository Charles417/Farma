package com.example.joaopbsousa.cadastro1.Modelo;

public class FarmaProduto {

    private String uidfarmacia;
    private String uidproduto;
    private Double preco;
    private String farmacia;

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public String getUidfarmacia() {
        return uidfarmacia;
    }

    public void setUidfarmacia(String uidfarmacia) {
        this.uidfarmacia = uidfarmacia;
    }

    public String getUidproduto() {
        return uidproduto;
    }

    public void setUidproduto(String uidproduto) {
        this.uidproduto = uidproduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public FarmaProduto() {

    }

    @Override
    public String toString() {
        return "FarmaProduto{" +
                "uidfarmacia='" + uidfarmacia + '\'' +
                ", uidproduto='" + uidproduto + '\'' +
                ", preco=" + preco +
                ", farmacia='" + farmacia + '\'' +
                '}';
    }
}
