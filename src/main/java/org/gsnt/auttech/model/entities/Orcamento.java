package org.gsnt.auttech.model.entities;

import org.gsnt.auttech.util.Circulos;

public class Orcamento {

    private Integer cod;
    private String placa;
    private String modelo;

    private Integer orcCambio;
    private Integer orcEletrico;
    private Integer orcFreio;
    private Integer orcInjecao;
    private Integer orcMecanico;
    private Integer orcPneu;
    private Integer statusOrc;
    private Integer statusCliente;

    private Circulos orcCambio2;
    private Circulos orcEletrico2;
    private Circulos orcFreio2;
    private Circulos orcInjecao2;
    private Circulos orcMecanico2;
    private Circulos orcPneu2;
    private Circulos statusOrc2;
    private String statusCliente2;

    public Orcamento(Integer cod, String placa, String modelo, Integer statusCliente, Integer statusOrc,
                     Integer orcPneu, Integer orcMecanico, Integer orcInjecao, Integer orcFreio, Integer
                     orcEletrico, Integer orcCambio) {

        this.cod = cod;
        this.placa = placa;
        this.modelo = modelo;
        this.statusCliente = statusCliente;
        this.statusOrc = statusOrc;
        this.orcPneu = orcPneu;
        this.orcMecanico = orcMecanico;
        this.orcInjecao = orcInjecao;
        this.orcFreio = orcFreio;
        this.orcEletrico = orcEletrico;
        this.orcCambio = orcCambio;

    }

    public Orcamento(Integer cod, String placa, String modelo, String statusCliente2, Circulos orcCambio2,
                     Circulos orcEletrico2, Circulos orcFreio2, Circulos orcInjecao2, Circulos orcMecanico2,
                     Circulos orcPneu2, Circulos statusOrc2) {

        this.cod = cod;
        this.placa = placa;
        this.modelo = modelo;
        this.statusCliente2 = statusCliente2;
        this.orcCambio2 = orcCambio2;
        this.orcEletrico2 = orcEletrico2;
        this.orcFreio2 = orcFreio2;
        this.orcInjecao2 = orcInjecao2;
        this.orcMecanico2 = orcMecanico2;
        this.orcPneu2 = orcPneu2;
        this.statusOrc2 = statusOrc2;

    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getOrcCambio() {
        return orcCambio;
    }

    public void setOrcCambio(Integer orcCambio) {
        this.orcCambio = orcCambio;
    }

    public Integer getOrcEletrico() {
        return orcEletrico;
    }

    public void setOrcEletrico(Integer orcEletrico) {
        this.orcEletrico = orcEletrico;
    }

    public Integer getOrcFreio() {
        return orcFreio;
    }

    public void setOrcFreio(Integer orcFreio) {
        this.orcFreio = orcFreio;
    }

    public Integer getOrcInjecao() {
        return orcInjecao;
    }

    public void setOrcInjecao(Integer orcInjecao) {
        this.orcInjecao = orcInjecao;
    }

    public Integer getOrcMecanico() {
        return orcMecanico;
    }

    public void setOrcMecanico(Integer orcMecanico) {
        this.orcMecanico = orcMecanico;
    }

    public Integer getOrcPneu() {
        return orcPneu;
    }

    public void setOrcPneu(Integer orcPneu) {
        this.orcPneu = orcPneu;
    }

    public Integer getStatusOrc() {
        return statusOrc;
    }

    public void setStatusOrc(Integer statusOrc) {
        this.statusOrc = statusOrc;
    }

    public Integer getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(Integer statusCliente) {
        this.statusCliente = statusCliente;
    }

    public Circulos getOrcCambio2() {
        return orcCambio2;
    }

    public void setOrcCambio2(Circulos orcCambio2) {
        this.orcCambio2 = orcCambio2;
    }

    public Circulos getOrcEletrico2() {
        return orcEletrico2;
    }

    public void setOrcEletrico2(Circulos orcEletrico2) {
        this.orcEletrico2 = orcEletrico2;
    }

    public Circulos getOrcFreio2() {
        return orcFreio2;
    }

    public void setOrcFreio2(Circulos orcFreio2) {
        this.orcFreio2 = orcFreio2;
    }

    public Circulos getOrcInjecao2() {
        return orcInjecao2;
    }

    public void setOrcInjecao2(Circulos orcInjecao2) {
        this.orcInjecao2 = orcInjecao2;
    }

    public Circulos getOrcMecanico2() {
        return orcMecanico2;
    }

    public void setOrcMecanico2(Circulos orcMecanico2) {
        this.orcMecanico2 = orcMecanico2;
    }

    public Circulos getOrcPneu2() {
        return orcPneu2;
    }

    public void setOrcPneu2(Circulos orcPneu2) {
        this.orcPneu2 = orcPneu2;
    }

    public Circulos getStatusOrc2() {
        return statusOrc2;
    }

    public void setStatusOrc2(Circulos statusOrc2) {
        this.statusOrc2 = statusOrc2;
    }

    public String getStatusCliente2() {
        return statusCliente2;
    }

    public void setStatusCliente2(String statusCliente2) {
        this.statusCliente2 = statusCliente2;
    }
}
