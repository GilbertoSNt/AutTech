package org.gsnt.auttech.model.entities;

import java.io.Serializable;

public class Veiculo implements Serializable {

    public Veiculo(){};

    private int cod;
    private String placa;
    private int marca;
    private int modelo;
    private String chassi;
    private String motor;
    private String cv;
    private String anof;
    private String anom;
    private String renavan;
    private boolean turbo;
    private boolean emLinha;
    private boolean emV;
    private boolean arQuente;
    private boolean airBag;
    private boolean freioABS;
    private boolean alarme;
    private boolean arCond;
    private boolean dirHid;
    private boolean dirElet;
    private boolean vidroElet;
    private boolean travaElet;
    private boolean tracao;
    private boolean teto;
    private boolean controleTracao;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo(String placa, int marca, int modelo, String anof, String anom, String motor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anof = anof;
        this.anom = anom;
        this.motor = motor;
    }

    public Veiculo(String placa, int marca, int modelo, String chassi, String motor, String cv, String anof,
                   String anom, String renavan, boolean turbo, boolean emLinha, boolean emV, boolean arQuente,
                   boolean airBag, boolean freioABS, boolean alarme, boolean arCond, boolean dirHid, boolean dirElet,
                   boolean vidroElet, boolean travaElet, boolean tracao, boolean teto, boolean controleTracao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
        this.motor = motor;
        this.cv = cv;
        this.anof = anof;
        this.anom = anom;
        this.renavan = renavan;
        this.turbo = turbo;
        this.emLinha = emLinha;
        this.emV = emV;
        this.arQuente = arQuente;
        this.airBag = airBag;
        this.freioABS = freioABS;
        this.alarme = alarme;
        this.arCond = arCond;
        this.dirHid = dirHid;
        this.dirElet = dirElet;
        this.vidroElet = vidroElet;
        this.travaElet = travaElet;
        this.tracao = tracao;
        this.teto = teto;
        this.controleTracao = controleTracao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getAnof() {
        return anof;
    }

    public void setAnof(String anof) {
        this.anof = anof;
    }

    public String getAnom() {
        return anom;
    }

    public void setAnom(String anom) {
        this.anom = anom;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public boolean isTurbo() {
        return turbo;
    }

    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
    }

    public boolean isEmLinha() {
        return emLinha;
    }

    public void setEmLinha(boolean emLinha) {
        this.emLinha = emLinha;
    }

    public boolean isEmV() {
        return emV;
    }

    public void setEmV(boolean emV) {
        this.emV = emV;
    }

    public boolean isArQuente() {
        return arQuente;
    }

    public void setArQuente(boolean arQuente) {
        this.arQuente = arQuente;
    }

    public boolean isAirBag() {
        return airBag;
    }

    public void setAirBag(boolean airBag) {
        this.airBag = airBag;
    }

    public boolean isFreioABS() {
        return freioABS;
    }

    public void setFreioABS(boolean freioABS) {
        this.freioABS = freioABS;
    }

    public boolean isAlarme() {
        return alarme;
    }

    public void setAlarme(boolean alarme) {
        this.alarme = alarme;
    }

    public boolean isArCond() {
        return arCond;
    }

    public void setArCond(boolean arCond) {
        this.arCond = arCond;
    }

    public boolean isDirHid() {
        return dirHid;
    }

    public void setDirHid(boolean dirHid) {
        this.dirHid = dirHid;
    }

    public boolean isDirElet() {
        return dirElet;
    }

    public void setDirElet(boolean dirElet) {
        this.dirElet = dirElet;
    }

    public boolean isVidroElet() {
        return vidroElet;
    }

    public void setVidroElet(boolean vidroElet) {
        this.vidroElet = vidroElet;
    }

    public boolean isTravaElet() {
        return travaElet;
    }

    public void setTravaElet(boolean travaElet) {
        this.travaElet = travaElet;
    }

    public boolean isTracao() {
        return tracao;
    }

    public void setTracao(boolean tracao) {
        this.tracao = tracao;
    }

    public boolean isTeto() {
        return teto;
    }

    public void setTeto(boolean teto) {
        this.teto = teto;
    }

    public boolean isControleTracao() {
        return controleTracao;
    }

    public void setControleTracao(boolean controleTracao) {
        this.controleTracao = controleTracao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
