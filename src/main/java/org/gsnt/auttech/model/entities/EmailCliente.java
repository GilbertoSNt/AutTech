package org.gsnt.auttech.model.entities;

import java.io.Serializable;

public class EmailCliente implements Serializable {

    public EmailCliente(){};

    private int codCliente;
    private int tipo;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
