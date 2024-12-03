package org.gsnt.auttech.model.entities;

import java.io.Serializable;

public class Cliente implements Serializable {

    public Cliente(){};

    private boolean pj;
    private String cnpj;
    private String cpf;
    private String rg;
    private String inscr;
    private String inscrMun;
    private String nome;
    private String apelido;
    private String dataCad;
    private Boolean perfil;

    public boolean isPj() {
        return pj;
    }

    public void setPj(boolean pj) {
        this.pj = pj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getInscr() {
        return inscr;
    }

    public void setInscr(String inscr) {
        this.inscr = inscr;
    }

    public String getInscrMun() {
        return inscrMun;
    }

    public void setInscrMun(String inscrEst) {
        this.inscrMun = inscrEst;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }

    public Boolean getPerfil() {
        return perfil;
    }

    public void setPerfil(Boolean perfil) {
        this.perfil = perfil;
    }


}
