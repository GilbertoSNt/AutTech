package org.gsnt.auttech.model.entities.entitiesgenerics;

public class TipoEndereco {

    private Integer id;
    private String tipo;

    public TipoEndereco(){};

    public TipoEndereco(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

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

    @Override
    public String toString() {
        return  "id=" + id +
                ", tipo='" + tipo ;
    }

}
