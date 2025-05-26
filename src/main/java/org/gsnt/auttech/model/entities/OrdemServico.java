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
    *
    * */


    private Integer numero;
    private String placa;
    private String modelo;

    private Circulos sEletrico1;
    private Circulos sInjecao1;
    private Circulos sCambio1;
    private Circulos sFreioDt1;
    private Circulos sFreioTr1;
    private Circulos sMotor1;
    private Circulos mecanico1;
    private Circulos sRevisao1;
    private Circulos sSuspDt1;
    private Circulos sSuspTr1;
    private Circulos sPneus1;
    private Circulos sTrOleo1;
    private Circulos lavacao1;

    private String telefone;
    private String status;

    private Integer sEletrico;
    private Integer sInjecao;
    private Integer sCambio;
    private Integer sFreioDt;
    private Integer sFreioTr;
    private Integer sMotor;
    private Integer sSuspDt;
    private Integer sSuspTr;
    private Integer sPneus;
    private Integer sTrOleo;
    private Integer lavacao;
    private Integer sRevisao;



    public OrdemServico(Integer numero, String placa, String modelo, Circulos sEletrico1, Circulos sInjecao1,
    Circulos sCambio1, Circulos sFreioDt1, Circulos sFreioTr1, Circulos sMotor1, Circulos sRevisao1,
    Circulos sSuspDt1, Circulos sSuspTr1, Circulos sPneus1, Circulos sTrOleo1){

        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.sEletrico1 = sEletrico1;
        this.sInjecao1 = sInjecao1;
        this.sCambio1 = sCambio1;
        this.sFreioDt1 = sFreioDt1;
        this.sFreioTr1 = sFreioTr1;
        this.sMotor1 = sMotor1;
        this.sRevisao1 = sRevisao1;
        this.sSuspDt1 = sSuspDt1;
        this.sSuspTr1 = sSuspTr1;
        this.sPneus1 = sPneus1;
        this.sTrOleo1 = sTrOleo1;

    }

/////   modificado aqui implementar integer;

    //
    /////Construtor tela veículo em serviços
    //
    public OrdemServico(Integer numero, String placa, String modelo, Integer sEletrico, Integer sInjecao,
                        Integer sCambio, Integer sFreioDt, Integer sFreioTr, Integer sMotor,
                        Integer sSuspDt, Integer sSuspTr, Integer sPneus, Integer sTrOleo, Integer lavacao) {

        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.sCambio = sCambio;
        this.sEletrico = sEletrico;
        this.sFreioDt = sFreioDt;
        this.sFreioTr = sFreioTr;
        this.sInjecao = sInjecao;
        this.sMotor = sMotor;
        this.sSuspDt = sSuspDt;
        this.sSuspTr = sSuspTr;
        this.sPneus = sPneus;
        this.sTrOleo = sTrOleo;
        this.lavacao = lavacao;

    }

    public OrdemServico(Integer numero, String placa, String modelo, Circulos sEletrico1, Circulos sInjecao1,
                        Circulos sMotor1, Circulos sMecanico1, Circulos sCambio1, Circulos sPneus1, Circulos lavacao1){

        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.sCambio1 = sCambio1;
        this.sEletrico1 = sEletrico1;
        this.sInjecao1 = sInjecao1;
        this.lavacao1 = lavacao1;
        this.sMotor1 = sMotor1;
        this.mecanico1 = sMecanico1;
        this.sPneus1 = sPneus1;

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

    public Circulos getsEletrico1() {
        return sEletrico1;
    }

    public void setsEletrico1(Circulos sEletrico1) {
        this.sEletrico1 = sEletrico1;
    }

    public Circulos getsInjecao1() {
        return sInjecao1;
    }

    public void setsInjecao1(Circulos sInjecao1) {
        this.sInjecao1 = sInjecao1;
    }

    public Circulos getsCambio1() {
        return sCambio1;
    }

    public void setsCambio1(Circulos sCambio1) {
        this.sCambio1 = sCambio1;
    }

    public Circulos getsFreioDt1() {
        return sFreioDt1;
    }

    public void setsFreioDt1(Circulos sFreioDt1) {
        this.sFreioDt1 = sFreioDt1;
    }

    public Circulos getsFreioTr1() {
        return sFreioTr1;
    }

    public void setsFreioTr1(Circulos sFreioTr1) {
        this.sFreioTr1 = sFreioTr1;
    }

    public Circulos getsMotor1() {
        return sMotor1;
    }

    public void setsMotor1(Circulos sMotor1) {
        this.sMotor1 = sMotor1;
    }

    public Circulos getMecanico1() {
        return mecanico1;
    }

    public void setMecanico1(Circulos mecanico1) {
        this.mecanico1 = mecanico1;
    }

    public Circulos getsRevisao1() {
        return sRevisao1;
    }

    public void setsRevisao1(Circulos sRevisao1) {
        this.sRevisao1 = sRevisao1;
    }

    public Circulos getsSuspDt1() {
        return sSuspDt1;
    }

    public void setsSuspDt1(Circulos sSuspDt1) {
        this.sSuspDt1 = sSuspDt1;
    }

    public Circulos getsSuspTr1() {
        return sSuspTr1;
    }

    public void setsSuspTr1(Circulos sSuspTr1) {
        this.sSuspTr1 = sSuspTr1;
    }

    public Circulos getsPneus1() {
        return sPneus1;
    }

    public void setsPneus1(Circulos sPneus1) {
        this.sPneus1 = sPneus1;
    }

    public Circulos getsTrOleo1() {
        return sTrOleo1;
    }

    public void setsTrOleo1(Circulos sTrOleo1) {
        this.sTrOleo1 = sTrOleo1;
    }

    public Circulos getLavacao1() {
        return lavacao1;
    }

    public void setLavacao1(Circulos lavacao1) {
        this.lavacao1 = lavacao1;
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

    public Integer getsEletrico() {
        return sEletrico;
    }

    public void setsEletrico(Integer sEletrico) {
        this.sEletrico = sEletrico;
    }

    public Integer getsInjecao() {
        return sInjecao;
    }

    public void setsInjecao(Integer sInjecao) {
        this.sInjecao = sInjecao;
    }

    public Integer getsCambio() {
        return sCambio;
    }

    public void setsCambio(Integer sCambio) {
        this.sCambio = sCambio;
    }

    public Integer getsFreioDt() {
        return sFreioDt;
    }

    public void setsFreioDt(Integer sFreioDt) {
        this.sFreioDt = sFreioDt;
    }

    public Integer getsFreioTr() {
        return sFreioTr;
    }

    public void setsFreioTr(Integer sFreioTr) {
        this.sFreioTr = sFreioTr;
    }

    public Integer getsMotor() {
        return sMotor;
    }

    public void setsMotor(Integer sMotor) {
        this.sMotor = sMotor;
    }

    public Integer getsSuspDt() {
        return sSuspDt;
    }

    public void setsSuspDt(Integer sSuspDt) {
        this.sSuspDt = sSuspDt;
    }

    public Integer getsSuspTr() {
        return sSuspTr;
    }

    public void setsSuspTr(Integer sSuspTr) {
        this.sSuspTr = sSuspTr;
    }

    public Integer getsPneus() {
        return sPneus;
    }

    public void setsPneus(Integer sPneus) {
        this.sPneus = sPneus;
    }

    public Integer getsTrOleo() {
        return sTrOleo;
    }

    public void setsTrOleo(Integer sTrOleo) {
        this.sTrOleo = sTrOleo;
    }

    public Integer getLavacao() {
        return lavacao;
    }

    public void setLavacao(Integer lavacao) {
        this.lavacao = lavacao;
    }

    public Integer getsRevisao() {
        return sRevisao;
    }

    public void setsRevisao(Integer sRevisao) {
        this.sRevisao = sRevisao;
    }
}
