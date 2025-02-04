package org.gsnt.auttech.model.entities;

import java.util.Objects;

public class DadosGenericos {

    private int id;
    private String dado;

    public DadosGenericos(){}

    public DadosGenericos(int id, String dado) {
        this.id = id;
        this.dado = dado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDado() {
        return dado;
    }

    public void setDado(String dado) {
        this.dado = dado;
    }

    @Override
    public String toString() {
        return  id+" "+dado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DadosGenericos that)) return false;
        return getId() == that.getId() && Objects.equals(getDado(), that.getDado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDado());
    }
}
