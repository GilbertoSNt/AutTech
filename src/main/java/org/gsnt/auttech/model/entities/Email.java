package org.gsnt.auttech.model.entities;

import java.io.Serializable;

public class Email implements Serializable {

    /*
     * Tipo caso
     * 1 - Cliente
     * 2 - Fornecedor
     * 3 - Funcionarios
     */

    public Email(){};

    private int cod;
    private int tipoCaso;
    private int tipo;
    private String email;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getTipoCaso() {
        return tipoCaso;
    }

    public void setTipoCaso(int tipoCaso) {
        this.tipoCaso = tipoCaso;
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
