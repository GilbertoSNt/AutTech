package org.gsnt.auttech.model.entities.entitiesgenerics;

public class TiposEmail {

    private Integer tipo;
    private String email;

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TiposEmail(){}

    public TiposEmail(Integer tipo, String email) {
        this.tipo = tipo;
        this.email = email;
    }

    @Override
    public String toString() {
        return  email;
    }

}
