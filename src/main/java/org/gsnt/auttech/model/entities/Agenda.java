package org.gsnt.auttech.model.entities;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.gsnt.auttech.util.Circulos;


import javax.crypto.CipherSpi;
import java.io.Serializable;

public class Agenda implements Serializable {

    //Dados genéricos bando de dados e tela inicial
    private Integer cod;
    private String dataAgenda;
    private String hora;
    private String nome;
    private String veiculo;
    private String placa;
    private String telefone;
    private String obs;

    //Dados tela inicial
    private Circulos eletrico;
    private Circulos injecao;
    private Circulos mecanico;
    private Circulos trocaOleo;
    private Circulos pneus;
    private Circulos revisao;
    private Circulos socEletrico;
    private Circulos guincho;
    private Circulos socMecanico;
    private Circulos buscar;
    private Circulos levar;
    private Circulos status;

    //Dados genéricos banco de dados
    private Boolean sRevisao;
    private Boolean sSuspensao;
    private Boolean sInjecao;
    private Boolean sPneus;
    private Boolean sTrocaOleo;
    private Boolean sFreio;
    private Boolean sEletrico;
    private Boolean sMecanico;
    private Boolean sMotor;
    private Boolean sCaixa;

    private Boolean assSocMecanico;
    private Boolean assSocEletrico;
    private Boolean assLevar;
    private Boolean assGuincho;
    private Boolean assEnvioGuincho;
    private Boolean assBuscar;
    private Boolean assEnvioDeslocamento;
    private Boolean assClienteTraz;



    public Agenda(){}


    //Construtor tela inicital
    public Agenda(String dataAgenda, String hora, String nome, String veiculo, String placa,
                  Circulos socMecanico, Circulos socEletrico, Circulos levar, Circulos guincho, Circulos buscar,
                  Circulos mecanico, Circulos eletrico, Circulos injecao, Circulos revisao,  Circulos pneus,
                  Circulos trocaOleo, Circulos status) {

        this.dataAgenda = dataAgenda;
        this.hora = hora;
        this.nome = nome;
        this.veiculo = veiculo;
        this.placa = placa;
        this.socMecanico = socMecanico;
        this.socEletrico = socEletrico;
        this.levar = levar;
        this.guincho = guincho;
        this.buscar = buscar;
        this.mecanico = mecanico;
        this.eletrico = eletrico;
        this.injecao = injecao;
        this.revisao = revisao;
        this.pneus = pneus;
        this.trocaOleo = trocaOleo;
        this.status = status;


    }


    //Construtor banco dados
    public Agenda(Integer cod, String dataAgenda, String hora, String nome, String veiculo, String placa,
                  String telefone, String obs, Boolean sRevisao, Boolean sSuspensao, Boolean sInjecao,
                  Boolean sPneus, Boolean sTrocaOleo, Boolean sFreio, Boolean sEletrico, Boolean sMecanico,
                  Boolean sMotor, Boolean sCaixa, Boolean assSocMecanico, Boolean assSocEletrico, Boolean assLevar,
                  Boolean assGuincho, Boolean assBuscar, Boolean assClienteTraz, Boolean assEnvioGuincho,
                  Boolean assEnvioDeslocamento) {

        this.cod = cod;
        this.dataAgenda = dataAgenda;
        this.hora = hora;
        this.nome = nome;
        this.veiculo = veiculo;
        this.placa = placa;
        this.telefone = telefone;
        this.obs = obs;
        this.sRevisao = sRevisao;
        this.sSuspensao = sSuspensao;
        this.sInjecao = sInjecao;
        this.sPneus = sPneus;
        this.sTrocaOleo = sTrocaOleo;
        this.sFreio = sFreio;
        this.sEletrico = sEletrico;
        this.sMecanico = sMecanico;
        this.sMotor = sMotor;
        this.sCaixa = sCaixa;
        this.assSocMecanico = assSocMecanico;
        this.assSocEletrico = assSocEletrico;
        this.assLevar = assLevar;
        this.assGuincho = assGuincho;
        this.assBuscar = assBuscar;
        this.assClienteTraz = assClienteTraz;
        this.assEnvioGuincho = assEnvioGuincho;
        this.assEnvioDeslocamento = assEnvioDeslocamento;

    }

    //Construtor inserção banco dados
    public Agenda(String dataAgenda, String hora, String nome, String veiculo, String placa,
                  String telefone, String obs, Boolean sRevisao, Boolean sSuspensao, Boolean sInjecao,
                  Boolean sPneus, Boolean sTrocaOleo, Boolean sFreio, Boolean sEletrico, Boolean sMecanico,
                  Boolean sMotor, Boolean sCaixa, Boolean assSocMecanico, Boolean assSocEletrico, Boolean assLevar,
                  Boolean assGuincho, Boolean assBuscar, Boolean assClienteTraz, Boolean assEnvioGuincho,
                  Boolean assEnvioDeslocamento) {

        this.dataAgenda = dataAgenda;
        this.hora = hora;
        this.nome = nome;
        this.veiculo = veiculo;
        this.placa = placa;
        this.telefone = telefone;
        this.obs = obs;
        this.sRevisao = sRevisao;
        this.sSuspensao = sSuspensao;
        this.sInjecao = sInjecao;
        this.sPneus = sPneus;
        this.sTrocaOleo = sTrocaOleo;
        this.sFreio = sFreio;
        this.sEletrico = sEletrico;
        this.sMecanico = sMecanico;
        this.sMotor = sMotor;
        this.sCaixa = sCaixa;
        this.assSocMecanico = assSocMecanico;
        this.assSocEletrico = assSocEletrico;
        this.assLevar = assLevar;
        this.assGuincho = assGuincho;
        this.assBuscar = assBuscar;
        this.assClienteTraz = assClienteTraz;
        this.assEnvioGuincho = assEnvioGuincho;
        this.assEnvioDeslocamento = assEnvioDeslocamento;

    }

    //Construtor retorno bando dados para tela principal agenda
    public Agenda(String dataAgenda, String hora, String nome, String veiculo, String placa, Boolean sRevisao,
                  Boolean sSuspensao, Boolean sInjecao, Boolean sPneus, Boolean sTrocaOleo, Boolean sFreio,
                  Boolean sEletrico, Boolean sMecanico, Boolean sMotor, Boolean sCaixa, Boolean assSocMecanico,
                  Boolean assSocEletrico, Boolean assLevar, Boolean assGuincho, Boolean assBuscar,
                  Boolean assEnvioGuincho, Boolean assEnvioDeslocamento) {

        this.dataAgenda = dataAgenda;
        this.hora = hora;
        this.nome = nome;
        this.veiculo = veiculo;
        this.placa = placa;
        this.sRevisao = sRevisao;
        this.sSuspensao = sSuspensao;
        this.sInjecao = sInjecao;
        this.sPneus = sPneus;
        this.sTrocaOleo = sTrocaOleo;
        this.sFreio = sFreio;
        this.sEletrico = sEletrico;
        this.sMecanico = sMecanico;
        this.sMotor = sMotor;
        this.sCaixa = sCaixa;
        this.assSocMecanico = assSocMecanico;
        this.assSocEletrico = assSocEletrico;
        this.assLevar = assLevar;
        this.assGuincho = assGuincho;
        this.assBuscar = assBuscar;
        this.assEnvioGuincho = assEnvioGuincho;
        this.assEnvioDeslocamento = assEnvioDeslocamento;

    }

    public Agenda(String placa, Boolean assEnvioGuincho, Boolean assEnvioDeslocamento){

        this.placa = placa;
        this.assEnvioGuincho = assEnvioGuincho;
        this.assEnvioDeslocamento = assEnvioDeslocamento;

    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(String data) {
        this.dataAgenda = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Circulos getSocMecanico() {
        return socMecanico;
    }

    public void setSocMecanico(Circulos socMecanico) {
        this.socMecanico = socMecanico;
    }

    public Circulos getSocEletrico() {
        return socEletrico;
    }

    public void setSocEletrico(Circulos socEletrico) {
        this.socEletrico = socEletrico;
    }

    public Circulos getLevar() {
        return levar;
    }

    public void setLevar(Circulos levar) {
        this.levar = levar;
    }

    public Circulos getGuincho() {
        return guincho;
    }

    public void setGuincho(Circulos guincho) {
        this.guincho = guincho;
    }

    public Circulos getBuscar() {
        return buscar;
    }

    public void setBuscar(Circulos buscar) {
        this.buscar = buscar;
    }

    public Circulos getMecanico() {
        return mecanico;
    }

    public void setMecanico(Circulos mecanico) {
        this.mecanico = mecanico;
    }

    public Circulos getEletrico() {
        return eletrico;
    }

    public void setEletrico(Circulos eletrico) {
        this.eletrico = eletrico;
    }

    public Circulos getInjecao() {
        return injecao;
    }

    public void setInjecao(Circulos injecao) {
        this.injecao = injecao;
    }

    public Circulos getRevisao() {
        return revisao;
    }

    public void setRevisao(Circulos revisão) {
        this.revisao = revisão;
    }

    public Circulos getPneus() {
        return pneus;
    }

    public void setPneus(Circulos pneus) {
        this.pneus = pneus;
    }

    public Circulos getTrocaOleo() {
        return trocaOleo;
    }

    public void setTrocaOleo(Circulos trocaOleo) {
        this.trocaOleo = trocaOleo;
    }

    public Circulos getStatus() {
        return status;
    }

    public void setStatus(Circulos status) {
        this.status = status;
    }

    public Boolean getsRevisao() {
        return sRevisao;
    }

    public void setsRevisao(Boolean sRevisao) {
        this.sRevisao = sRevisao;
    }

    public Boolean getsSuspensao() {
        return sSuspensao;
    }

    public void setsSuspensao(Boolean sSuspensao) {
        this.sSuspensao = sSuspensao;
    }

    public Boolean getsInjecao() {
        return sInjecao;
    }

    public void setsInjecao(Boolean sInjecao) {
        this.sInjecao = sInjecao;
    }

    public Boolean getsPneus() {
        return sPneus;
    }

    public void setsPneus(Boolean sPneus) {
        this.sPneus = sPneus;
    }

    public Boolean getsTrocaOleo() {
        return sTrocaOleo;
    }

    public void setsTrocaOleo(Boolean sTrocaOleo) {
        this.sTrocaOleo = sTrocaOleo;
    }

    public Boolean getsFreio() {
        return sFreio;
    }

    public void setsFreio(Boolean sFreio) {
        this.sFreio = sFreio;
    }

    public Boolean getsEletrico() {
        return sEletrico;
    }

    public void setsEletrico(Boolean sEletrico) {
        this.sEletrico = sEletrico;
    }

    public Boolean getsMecanico() {
        return sMecanico;
    }

    public void setsMecanico(Boolean sMecanico) {
        this.sMecanico = sMecanico;
    }

    public Boolean getsMotor() {
        return sMotor;
    }

    public void setsMotor(Boolean sMotor) {
        this.sMotor = sMotor;
    }

    public Boolean getsCaixa() {
        return sCaixa;
    }

    public void setsCaixa(Boolean sCaixa) {
        this.sCaixa = sCaixa;
    }

    public Boolean getAssSocMecanico() {
        return assSocMecanico;
    }

    public void setAssSocMecanico(Boolean assSocMecanico) {
        this.assSocMecanico = assSocMecanico;
    }

    public Boolean getAssSocEletrico() {
        return assSocEletrico;
    }

    public void setAssSocEletrico(Boolean assSocEletrico) {
        this.assSocEletrico = assSocEletrico;
    }

    public Boolean getAssLevar() {
        return assLevar;
    }

    public void setAssLevar(Boolean assLevar) {
        this.assLevar = assLevar;
    }

    public Boolean getAssGuincho() {
        return assGuincho;
    }

    public void setAssGuincho(Boolean assGuincho) {
        this.assGuincho = assGuincho;
    }

    public Boolean getAssBuscar() {
        return assBuscar;
    }

    public void setAssBuscar(Boolean assBuscar) {
        this.assBuscar = assBuscar;
    }

    public Boolean getAssClienteTraz() {
        return assClienteTraz;
    }

    public void setAssClienteTraz(Boolean assClienteTraz) {
        this.assClienteTraz = assClienteTraz;
    }

    public Boolean getAssEnvioGuincho() {
        return assEnvioGuincho;
    }

    public void setAssEnvioGuincho(Boolean assEnvioGuincho) {
        this.assEnvioGuincho = assEnvioGuincho;
    }

    public Boolean getAssEnvioDeslocamento() {
        return assEnvioDeslocamento;
    }

    public void setAssEnvioDeslocamento(Boolean assEnvioDeslocamento) {
        this.assEnvioDeslocamento = assEnvioDeslocamento;
    }
}
