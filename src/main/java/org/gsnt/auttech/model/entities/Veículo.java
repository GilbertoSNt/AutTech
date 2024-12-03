package org.gsnt.auttech.model.entities;

import java.io.Serializable;

public class Veículo implements Serializable {

    public Veículo(){};

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
}
