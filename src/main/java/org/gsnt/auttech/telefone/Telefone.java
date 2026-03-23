package org.gsnt.auttech.telefone;

import java.io.Serializable;
/**
    Classe responsável pelos telefones
    campo gerador é a confirmaçao do tipo de pessoa que é dona do telefone cliente, funcionario
 */
public class Telefone implements Serializable {

    public Telefone(){};

    private int codigo;
    private int gerador;
    private int tipo;
    private String numeroTel;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getGerador() {
        return gerador;
    }

    public void setGerador(int gerador) {
        this.gerador = gerador;
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
