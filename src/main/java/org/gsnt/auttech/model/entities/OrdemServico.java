package org.gsnt.auttech.model.entities;

import org.gsnt.auttech.util.Circulos;

public class OrdemServico {

    private Integer numero;
    private String placa;
    private String modelo;

    private Circulos sEletrico2;
    private Circulos sInjecao2;
    private Circulos sCamAut2;
    private Circulos sCamMec2;
    private Circulos sFreioDt2;
    private Circulos sFreioTr2;
    private Circulos sMotor2;
    private Circulos sRevisao2;
    private Circulos sSuspDt2;
    private Circulos sSuspTr2;
    private Circulos sPneus2;
    private Circulos sTrOleo2;

    private Boolean sEletrico;
    private Boolean sInjecao;
    private Boolean sCamAut;
    private Boolean sCamMec;
    private Boolean sFreioDt;
    private Boolean sFreioTr;
    private Boolean sMotor;
    private Boolean sRevisao;
    private Boolean sSuspDt;
    private Boolean sSuspTr;
    private Boolean sPneus;
    private Boolean sTrOleo;

    private String telefone;
    private String status;


    public OrdemServico(Integer numero, String placa, String modelo, Circulos sEletrico2, Circulos sInjecao2,
    Circulos sCamAut2, Circulos sCamMec2, Circulos sFreioDt2, Circulos sFreioTr2, Circulos sMotor2, Circulos sRevisao2,
    Circulos sSuspDt2, Circulos sSuspTr2, Circulos sPneus2, Circulos sTrOleo2){

        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.sEletrico2 = sEletrico2;
        this.sInjecao2 = sInjecao2;
        this.sCamAut2 = sCamAut2;
        this.sCamMec2 = sCamMec2;
        this.sFreioDt2 = sFreioDt2;
        this.sFreioTr2 = sFreioTr2;
        this.sMotor2 = sMotor2;
        this.sRevisao2 = sRevisao2;
        this.sSuspDt2 = sSuspDt2;
        this.sSuspTr2 = sSuspTr2;
        this.sPneus2 = sPneus2;
        this.sTrOleo2 = sTrOleo2;

    }

    public OrdemServico(Integer numero, String placa, String modelo, Boolean sEletrico, Boolean sInjecao,
                        Boolean sCamAut, Boolean sCamMec, Boolean sFreioDt, Boolean sFreioTr, Boolean sMotor,
                        Boolean sRevisao, Boolean sSuspDt, Boolean sSuspTr, Boolean sPneus, Boolean sTrOleo) {

        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.sEletrico = sEletrico;
        this.sInjecao = sInjecao;
        this.sCamAut = sCamAut;
        this.sCamMec = sCamMec;
        this.sFreioDt = sFreioDt;
        this.sFreioTr = sFreioTr;
        this.sMotor = sMotor;
        this.sRevisao = sRevisao;
        this.sSuspDt = sSuspDt;
        this.sSuspTr = sSuspTr;
        this.sPneus = sPneus;
        this.sTrOleo = sTrOleo;

    }

    //
    /////Construtor tela veículo em serviços
    //
    public OrdemServico(Integer numero, String placa, String modelo, Boolean sEletrico, Boolean sInjecao,
                        Boolean sCamAut, Boolean sCamMec, Boolean sFreioDt, Boolean sFreioTr, Boolean sMotor,
                        Boolean sSuspDt, Boolean sSuspTr, Boolean sPneus, Boolean sTrOleo) {

        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.sCamAut = sCamAut;
        this.sCamMec = sCamMec;
        this.sEletrico = sEletrico;
        this.sFreioDt = sFreioDt;
        this.sFreioTr = sFreioTr;
        this.sInjecao = sInjecao;
        this.sMotor = sMotor;
        this.sSuspDt = sSuspDt;
        this.sSuspTr = sSuspTr;
        this.sPneus = sPneus;
        this.sTrOleo = sTrOleo;

    }

    //
    /////Tela de veículos prontos
    //
    public OrdemServico(Integer numero, String placa, String modelo, String telefone, String status) {

        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.telefone = telefone;
        this.status = status;


    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public Circulos getSEletrico2() {
        return sEletrico2;
    }

    public void setSEletrico2(Circulos sEletrico2) {
        this.sEletrico2 = sEletrico2;
    }

    public Circulos getSInjecao2() {
        return sInjecao2;
    }

    public void setSInjecao2(Circulos sInjecao2) {
        this.sInjecao2 = sInjecao2;
    }

    public Circulos getSCamAut2() {
        return sCamAut2;
    }

    public void setSCamAut2(Circulos sCamAut2) {
        this.sCamAut2 = sCamAut2;
    }

    public Circulos getSCamMec2() {
        return sCamMec2;
    }

    public void setSCamMec2(Circulos sCamMec2) {
        this.sCamMec2 = sCamMec2;
    }

    public Circulos getSFreioDt2() {
        return sFreioDt2;
    }

    public void setSFreioDt2(Circulos sFreioDt2) {
        this.sFreioDt2 = sFreioDt2;
    }

    public Circulos getSFreioTr2() {
        return sFreioTr2;
    }

    public void setSFreioTr2(Circulos sFreioTr2) {
        this.sFreioTr2 = sFreioTr2;
    }

    public Circulos getSMotor2() {
        return sMotor2;
    }

    public void setSMotor2(Circulos sMotor2) {
        this.sMotor2 = sMotor2;
    }

    public Circulos getSRevisao2() {
        return sRevisao2;
    }

    public void setSRevisao2(Circulos sRevisao2) {
        this.sRevisao2 = sRevisao2;
    }

    public Circulos getSSuspDt2() {
        return sSuspDt2;
    }

    public void setSSuspDt2(Circulos sSuspDt2) {
        this.sSuspDt2 = sSuspDt2;
    }

    public Circulos getSSuspTr2() {
        return sSuspTr2;
    }

    public void setSSuspTr2(Circulos sSuspTr2) {
        this.sSuspTr2 = sSuspTr2;
    }

    public Circulos getSPneus2() {
        return sPneus2;
    }

    public void setSPneus2(Circulos sPneus2) {
        this.sPneus2 = sPneus2;
    }

    public Circulos getSTrOleo2() {
        return sTrOleo2;
    }

    public void setSTrOleo2(Circulos sTrOleo2) {
        this.sTrOleo2 = sTrOleo2;
    }

    public Boolean getsEletrico() {
        return sEletrico;
    }

    public void setsEletrico(Boolean sEletrico) {
        this.sEletrico = sEletrico;
    }

    public Boolean getsInjecao() {
        return sInjecao;
    }

    public void setsInjecao(Boolean sInjecao) {
        this.sInjecao = sInjecao;
    }

    public Boolean getsCamAut() {
        return sCamAut;
    }

    public void setsCamAut(Boolean sCamAut) {
        this.sCamAut = sCamAut;
    }

    public Boolean getsCamMec() {
        return sCamMec;
    }

    public void setsCamMec(Boolean sCamMec) {
        this.sCamMec = sCamMec;
    }

    public Boolean getsFreioDt() {
        return sFreioDt;
    }

    public void setsFreioDt(Boolean sFreioDt) {
        this.sFreioDt = sFreioDt;
    }

    public Boolean getsFreioTr() {
        return sFreioTr;
    }

    public void setsFreioTr(Boolean sFreioTr) {
        this.sFreioTr = sFreioTr;
    }

    public Boolean getsMotor() {
        return sMotor;
    }

    public void setsMotor(Boolean sMotor) {
        this.sMotor = sMotor;
    }

    public Boolean getsRevisao() {
        return sRevisao;
    }

    public void setsRevisao(Boolean sRevisao) {
        this.sRevisao = sRevisao;
    }

    public Boolean getsSuspDt() {
        return sSuspDt;
    }

    public void setsSuspDt(Boolean sSuspDt) {
        this.sSuspDt = sSuspDt;
    }

    public Boolean getsSuspTr() {
        return sSuspTr;
    }

    public void setsSuspTr(Boolean sSuspTr) {
        this.sSuspTr = sSuspTr;
    }

    public Boolean getsPneus() {
        return sPneus;
    }

    public void setsPneus(Boolean sPneus) {
        this.sPneus = sPneus;
    }

    public Boolean getsTrOleo() {
        return sTrOleo;
    }

    public void setsTrOleo(Boolean sTrOleo) {
        this.sTrOleo = sTrOleo;
    }
}
