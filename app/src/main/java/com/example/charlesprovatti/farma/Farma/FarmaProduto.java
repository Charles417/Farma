package com.example.charlesprovatti.farma.Farma;

public class FarmaProduto {

    private String uidfarmaproduto;
    private String uidproduto;
    private String uidfarmacia;
    private String farmacia;
    private Double preco;

    public String getUidfarmaproduto() {
        return uidfarmaproduto;
    }

    public void setUidfarmaproduto(String uidfarmaproduto) {
        this.uidfarmaproduto = uidfarmaproduto;
    }

    public String getUidproduto() {
        return uidproduto;
    }

    public void setUidproduto(String uidproduto) {
        this.uidproduto = uidproduto;
    }

    public String getUidfarmacia() {
        return uidfarmacia;
    }

    public void setUidfarmacia(String uidfarmacia) {
        this.uidfarmacia = uidfarmacia;
    }

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public FarmaProduto() {

    }
}