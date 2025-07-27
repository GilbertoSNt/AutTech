package org.gsnt.auttech.model.entities.entitiesgenerics;

public class PerfilFiscal {

    private Integer id;
    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PerfilFiscal(){}

    public PerfilFiscal(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }

}
