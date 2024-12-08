package org.gsnt.auttech.model.entities;

import java.io.Serializable;

public class Cliente implements Serializable {

    public Cliente(){};

    public Cliente(Boolean pj, int cod, String nome, String apelido){

        this.pj = pj;
        this.cod = cod;
        this.nome = nome;
        this.apelido = apelido;

    };

    public Cliente(int cod, String cpf, String rg, String nome, String apelido, String dataCad, String dataNasc, Boolean perfil, Boolean status){
        this.cod = cod;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.apelido = apelido;
        this.dataCad = dataCad;
        this.dataNasc = dataNasc;
        this.perfil = perfil;
        this.status = status;
    };

    public Cliente(int cod, String cnpj, String inscr, String inscrMun, String nome, String apelido, String dataCad, String dataNasc, Boolean perfil, Boolean status){
        this.cod = cod;
        this.cnpj = cnpj;
        this.inscr = inscr;
        this.inscrMun = inscrMun;
        this.nome = nome;
        this.apelido = apelido;
        this.dataCad = dataCad;
        this.dataNasc = dataNasc;
        this.perfil = perfil;
        this.status = status;
    };

    private boolean pj;
    private int cod;
    private String cnpj;
    private String cpf;
    private String rg;
    private String inscr;
    private String inscrMun;
    private String nome;
    private String apelido;
    private String dataNasc;
    private String dataCad;
    private Boolean perfil;
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public boolean isPj() {
        return pj;
    }

    public void setPj(boolean pj) {
        this.pj = pj;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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
