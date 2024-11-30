package org.gsnt.auttech.model.entities;

public class ModeloVeiculo {

    public ModeloVeiculo(int cod, String modelo) {
        this.cod = cod;
        this.modelo = modelo;
    }

    private Integer cod;

    private String modelo;

    public int getCod() {
        return cod;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return modelo;
    }

}
