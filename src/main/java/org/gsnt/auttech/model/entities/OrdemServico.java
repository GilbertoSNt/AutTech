package org.gsnt.auttech.model.entities;

import org.gsnt.auttech.util.Circulos;

public class OrdemServico {

    /*
    * Status da ordem de serviço
    * 1 - Aberta
    * 2 - Cancelada
    * 3 - Fechada
    * 4 - Paga
    * 5 - Pendente Pagamento
    * 6 - Faturada
    * */


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
    private Circulos mecanico1;
    private Circulos sRevisao2;
    private Circulos sSuspDt2;
    private Circulos sSuspTr2;
    private Circulos sPneus2;
    private Circulos sTrOleo2;
    private Circulos lavacao1;

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

    private Integer sEletrico3;
    private Integer sInjecao3;
    private Integer sCamAut3;
    private Integer sCamMec3;
    private Integer sFreioDt3;
    private Integer sFreioTr3;
    private Integer sMotor3;
    private Integer sSuspDt3;
    private Integer sSuspTr3;
    private Integer sPneus3;
    private Integer sTrOleo3;
    private Integer lavacao;





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
    public OrdemServico(Integer numero, String placa, String modelo, Integer sEletrico3, Integer sInjecao3,
                        Integer sCamAut3, Integer sCamMec3, Integer sFreioDt3, Integer sFreioTr3, Integer sMotor3,
                        Integer sSuspDt3, Integer sSuspTr3, Integer sPneus3, Integer sTrOleo3, Integer lavacao) {

        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.sCamAut3 = sCamAut3;
        this.sCamMec3 = sCamMec3;
        this.sEletrico3 = sEletrico3;
        this.sFreioDt3 = sFreioDt3;
        this.sFreioTr3 = sFreioTr3;
        this.sInjecao3 = sInjecao3;
        this.sMotor3 = sMotor3;
        this.sSuspDt3 = sSuspDt3;
        this.sSuspTr3 = sSuspTr3;
        this.sPneus3 = sPneus3;
        this.sTrOleo3 = sTrOleo3;
        this.lavacao = lavacao;

    }

    public OrdemServico(Integer numero, String placa, String modelo, Circulos sEletrico2, Circulos sInjecao2,
                        Circulos sMotor2, Circulos sMecanico, Circulos sCamMec2, Circulos sPneus2, Circulos lavacao1){

        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.sCamMec2 = sCamMec2;
        this.sEletrico2 = sEletrico2;
        this.sInjecao2 = sInjecao2;
        this.lavacao1 = lavacao1;
        this.sMotor2 = sMotor2;
        this.mecanico1 = sMecanico;
        this.sPneus2 = sPneus2;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getsEletrico3() {
        return sEletrico3;
    }

    public void setsEletrico3(Integer sEletrico3) {
        this.sEletrico3 = sEletrico3;
    }

    public Integer getsInjecao3() {
        return sInjecao3;
    }

    public void setsInjecao3(Integer sInjecao3) {
        this.sInjecao3 = sInjecao3;
    }

    public Integer getsCamAut3() {
        return sCamAut3;
    }

    public void setsCamAut3(Integer sCamAut3) {
        this.sCamAut3 = sCamAut3;
    }

    public Integer getsCamMec3() {
        return sCamMec3;
    }

    public void setsCamMec3(Integer sCamMec3) {
        this.sCamMec3 = sCamMec3;
    }

    public Integer getsFreioDt3() {
        return sFreioDt3;
    }

    public void setsFreioDt3(Integer sFreioDt3) {
        this.sFreioDt3 = sFreioDt3;
    }

    public Integer getsFreioTr3() {
        return sFreioTr3;
    }

    public void setsFreioTr3(Integer sFreioTr3) {
        this.sFreioTr3 = sFreioTr3;
    }

    public Integer getsMotor3() {
        return sMotor3;
    }

    public void setsMotor3(Integer sMotor3) {
        this.sMotor3 = sMotor3;
    }

    public Integer getsSuspDt3() {
        return sSuspDt3;
    }

    public void setsSuspDt3(Integer sSuspDt3) {
        this.sSuspDt3 = sSuspDt3;
    }

    public Integer getsSuspTr3() {
        return sSuspTr3;
    }

    public void setsSuspTr3(Integer sSuspTr3) {
        this.sSuspTr3 = sSuspTr3;
    }

    public Integer getsPneus3() {
        return sPneus3;
    }

    public void setsPneus3(Integer sPneus3) {
        this.sPneus3 = sPneus3;
    }

    public Integer getsTrOleo3() {
        return sTrOleo3;
    }

    public void setsTrOleo3(Integer sTrOleo3) {
        this.sTrOleo3 = sTrOleo3;
    }

    public Integer getLavacao() {
        return lavacao;
    }

    public void setLavacao(Integer lavacao) {
        this.lavacao = lavacao;
    }

    public Circulos getsEletrico2() {
        return sEletrico2;
    }

    public void setsEletrico2(Circulos sEletrico2) {
        this.sEletrico2 = sEletrico2;
    }

    public Circulos getsInjecao2() {
        return sInjecao2;
    }

    public void setsInjecao2(Circulos sInjecao2) {
        this.sInjecao2 = sInjecao2;
    }

    public Circulos getsCamAut2() {
        return sCamAut2;
    }

    public void setsCamAut2(Circulos sCamAut2) {
        this.sCamAut2 = sCamAut2;
    }

    public Circulos getsCamMec2() {
        return sCamMec2;
    }

    public void setsCamMec2(Circulos sCamMec2) {
        this.sCamMec2 = sCamMec2;
    }

    public Circulos getsFreioDt2() {
        return sFreioDt2;
    }

    public void setsFreioDt2(Circulos sFreioDt2) {
        this.sFreioDt2 = sFreioDt2;
    }

    public Circulos getsFreioTr2() {
        return sFreioTr2;
    }

    public void setsFreioTr2(Circulos sFreioTr2) {
        this.sFreioTr2 = sFreioTr2;
    }

    public Circulos getsMotor2() {
        return sMotor2;
    }

    public void setsMotor2(Circulos sMotor2) {
        this.sMotor2 = sMotor2;
    }

    public Circulos getMecanico1() {
        return mecanico1;
    }

    public void setMecanico1(Circulos mecanico1) {
        this.mecanico1 = mecanico1;
    }

    public Circulos getsRevisao2() {
        return sRevisao2;
    }

    public void setsRevisao2(Circulos sRevisao2) {
        this.sRevisao2 = sRevisao2;
    }

    public Circulos getsSuspDt2() {
        return sSuspDt2;
    }

    public void setsSuspDt2(Circulos sSuspDt2) {
        this.sSuspDt2 = sSuspDt2;
    }

    public Circulos getsSuspTr2() {
        return sSuspTr2;
    }

    public void setsSuspTr2(Circulos sSuspTr2) {
        this.sSuspTr2 = sSuspTr2;
    }

    public Circulos getsPneus2() {
        return sPneus2;
    }

    public void setsPneus2(Circulos sPneus2) {
        this.sPneus2 = sPneus2;
    }

    public Circulos getsTrOleo2() {
        return sTrOleo2;
    }

    public void setsTrOleo2(Circulos sTrOleo2) {
        this.sTrOleo2 = sTrOleo2;
    }

    public Circulos getLavacao1() {
        return lavacao1;
    }

    public void setsLavacao(Circulos lavacao1) {
        this.lavacao1 = lavacao1;
    }
}
