package org.gsnt.auttech.model.entities;

import java.io.Serializable;

public class Estados implements Serializable {

    private Integer id;
    private String sigla;

    public Estados(){};

    public Estados(Integer id, String sigla){
        this.id = id;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String toString(){
        return ""+id+
               " "+sigla;
    }

}
