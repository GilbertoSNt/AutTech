package org.gsnt.auttech.entitiesgenerics;

import java.sql.Date;

public class Empresa {


    public Empresa(String cnpj) {
        this.cnpj = cnpj;
    }

    public Empresa(String razaoSocial, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public Empresa(String razaoSocial, String cnpj, String unidade) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.unidade = unidade;
    }

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String inscrEstadual;
    private String inscrMunicipal;
    private Date dataAbertura;
    private Date dataIniContrato; //Data inicio do atendimento
    private Date dataFimContrato; //Data fim atendimento
    private char tipoEmpresa; //C centro automotivo, O Oficina, F funilaria, p pintura
    private String unidade;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscrEstadual() {
        return inscrEstadual;
    }

    public void setInscrEstadual(String inscrEstadual) {
        this.inscrEstadual = inscrEstadual;
    }

    public String getInscrMunicipal() {
        return inscrMunicipal;
    }

    public void setInscrMunicipal(String inscrMunicipal) {
        this.inscrMunicipal = inscrMunicipal;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataIniContrato() {
        return dataIniContrato;
    }

    public void setDataIniContrato(Date dataIniContrato) {
        this.dataIniContrato = dataIniContrato;
    }

    public Date getDataFimContrato() {
        return dataFimContrato;
    }

    public void setDataFimContrato(Date dataFimContrato) {
        this.dataFimContrato = dataFimContrato;
    }

    public char getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(char tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
