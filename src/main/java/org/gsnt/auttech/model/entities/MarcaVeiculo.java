package org.gsnt.auttech.model.entities;

public class MarcaVeiculo {

    private int cod;

    private String MarcaVeiculo;

    private Boolean ativo;

    public MarcaVeiculo(int cod, String marcaVeiculo, Boolean ativo) {
        this.cod = cod;
        MarcaVeiculo = marcaVeiculo;
        this.ativo = ativo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMarcaVeiculo() {
        return MarcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        MarcaVeiculo = marcaVeiculo;
    }

    @Override
    public String toString() {
        return MarcaVeiculo;
    }

}
