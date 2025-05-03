package org.gsnt.auttech.model.entities;

import java.io.Serializable;

public class Email implements Serializable {

    /*
     * Tipo caso
     * 1 - Cliente
     * 2 - Fornecedor
     * 3 - Funcionarios
     *
     * Tipo email
     * 0 - geral
     */

    public Email(){};

    private int cod;
    private int codExterno;
    private int codCaso;
    private int tipo;
    private String email;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodCaso() {
        return codCaso;
    }

    public void setTipoCaso(int codCaso) {
        this.codCaso = codCaso;
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

    public int getCodExterno() {
        return codExterno;
    }

    public void setCodExterno(int codExterno) {
        this.codExterno = codExterno;
    }

    public void setCodCaso(int codCaso) {
        this.codCaso = codCaso;
    }
}
