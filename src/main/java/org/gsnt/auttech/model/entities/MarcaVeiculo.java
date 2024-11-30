package org.gsnt.auttech.model.entities;

public class MarcaVeiculo {

    private Integer cod;

    private String MarcaVeiculo;

    public MarcaVeiculo(int cod, String marcaVeiculo) {
        this.cod = cod;
        this.MarcaVeiculo = marcaVeiculo;
    }

    public int getCod() {
        return cod;
    }

    public String getMarcaVeiculo() {
        return MarcaVeiculo;
    }

    @Override
    public String toString() {
        return MarcaVeiculo;
    }

}
