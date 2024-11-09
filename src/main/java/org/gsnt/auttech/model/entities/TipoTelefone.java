package org.gsnt.auttech.model.entities;

public class TipoTelefone {


    private Integer id;
    private String tipoTelefone;

    public TipoTelefone(){}

    public TipoTelefone(Integer id, String tipoTelefone) {
        this.id = id;
        this.tipoTelefone = tipoTelefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipotelefone() {
        return tipoTelefone;
    }

    public void setTipotelefone(String tipotelefone) {
        this.tipoTelefone = tipotelefone;
    }

    @Override
    public String toString() {
        return   id+"";// +
               // " "+tipoTelefone ;
    }



}
