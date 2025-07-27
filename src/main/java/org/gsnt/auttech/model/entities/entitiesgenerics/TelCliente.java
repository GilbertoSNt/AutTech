package org.gsnt.auttech.model.entities.entitiesgenerics;

import java.io.Serializable;

public class TelCliente implements Serializable {

    public TelCliente(){};

    private int codCliente;
    private int tipo;
    private String numeroTel;

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
}
