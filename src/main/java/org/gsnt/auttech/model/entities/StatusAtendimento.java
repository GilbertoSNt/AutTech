package org.gsnt.auttech.model.entities;

import org.gsnt.auttech.util.Circulos;

public class StatusAtendimento {

    /*
     *
     * Status geral da ordem de serviço
     *
     *  0 - não solicitado
     * 1 - serviço não iniciado
     * 2 - Serviço já iniciado análise
     * 3 - serviço em orçamento
     * 4 - serviço liberado
     * 5 - Cancelada
     * 6 - Fechada
     * 7 - Veículo pronto
     * 8 - Cliente avisado
     * 9 - Faturada
     * 10 - Paga
     * 11 - Pendente Pagamento
     *
     * Status do atendimento
     *
     * Tela serviços a serem iniciados
     *
     * 0 - não solicitado (nulo)
     * 1 - Serviço sem direcionamento -  Vermelho - f50505
     * 2 - Direcionamento sem confirmação - Amarelo - f9d428 / Vermelho - f50505
     * 3 - veículo sendo analisado ou com orçamento pendente - Amarelo - f9d428
     * 4 - Orçamento aguardando liberação  - lilas - 7c2d91
     * 5 - Orçamento liberado aguardando peças - verde - 70c3a7 / lilas - 7c2d91
     * 6 - veículo com cliente aguardando pecas  - verde escuro - 3f676d
     *
     *
     * Tela serviços iniciados
     *
     * 7 - Orçamento liberado peças disponíveis aguardando retorno veículo - Vermelho - f50505
     * 8 - Não iniciado - veículo disponível  - Azul claro - 54d6f0
     * 9 - Em produção - verde - 70c3a7
     * 10 - Serviço pronto sem aviso ao cliente   - verde escuro - 3f676d
     *
     * Veículos em orçamento
     * 11 - Aguardando profissional - Amarelo - f9d428
     * 12 - Em preparação - Amarelo - f9d428 / verde - 70c3a7
     * 13 - Aguardando liberação - lilas - 7c2d91
     * 14 - Liberado para o cliente - verde - 70c3a7
     *
     *      >>>>>>Verificar coluna status cliente<<<<<<<
     *
     * Status orçamento cliente
     * 0 - orçamento não enviado ao cliente
     * 1 - orçamento enviado para cliente
     * 2 - orçamento liberado
     * 3 - orçamento liberado parcial
     * 4 - orçamento recusado
     *
     */

    private Integer cod;
    private byte tipo;
    private Integer codOs;
    private String placa;
    private Integer codOrcamento;
    private Integer codVeiculo;
    private String veiculo;
    private byte eletrico;
    private byte injecao;
    private byte caixa;
    private byte freioDt;
    private byte freioTr;
    private byte motor;
    private byte revisao;
    private byte suspensaoDt;
    private byte suspensaoTr;
    private byte alinBalan;
    private byte pneus;
    private byte trocaOleo;
    private byte lavacao;
    private byte mecanico;
    private byte assLevar;

    private String cliente;
    private String telefone;
    private String statuAviso;

    private byte orCambio;
    private byte orEletrico;
    private byte orMotor;
    private byte orInjecao;
    private byte orMecanica;
    private byte orPneu;
    private byte orStCliente;
    private byte orMontagem;
    private byte stAviso;
    private byte stGeralAtend;

    private Circulos sEletrico;
    private Circulos sInjecao;
    private Circulos sCambio;
    private Circulos sFreioDt;
    private Circulos sFreioTr;
    private Circulos sMotor;
    private Circulos mecanico1;
    private Circulos sRevisao;
    private Circulos sSuspDt;
    private Circulos sSuspTr;
    private Circulos sPneus;
    private Circulos sTrOleo;
    private Circulos lavacao1;
    private Circulos montOrc;
    private Circulos stCliente;

    public StatusAtendimento(){}

    //>>>>>> usado na tela a serem iniciados <<<<<<<

    public StatusAtendimento(Integer cod, String placa, String veiculo, Circulos sEletrico, Circulos sInjecao,
                             Circulos sCambio, Circulos sFreioDt, Circulos sFreioTr, Circulos sMotor,
                             Circulos sRevisao, Circulos sSuspDt, Circulos sSuspTr, Circulos sPneus, Circulos sTrOleo) {

        this.cod = cod;
        this.placa = placa;
        this.veiculo = veiculo;
        this.sEletrico = sEletrico;
        this.sInjecao = sInjecao;
        this.sCambio = sCambio;
        this.sFreioDt = sFreioDt;
        this.sFreioTr = sFreioTr;
        this.sMotor = sMotor;
        this.sRevisao = sRevisao;
        this.sSuspDt = sSuspDt;
        this.sSuspTr = sSuspTr;
        this.sPneus = sPneus;
        this.sTrOleo = sTrOleo;
    }

    public StatusAtendimento(Integer codOs, String placa,  String veiculo, byte eletrico, byte injecao, byte caixa,
                             byte freioDt, byte freioTr, byte motor, byte revisao, byte suspensaoDt, byte suspensaoTr,
                             byte pneus, byte trocaOleo) {
        this.codOs = codOs;
        this.placa = placa;
        this.eletrico = eletrico;
        this.veiculo = veiculo;
        this.injecao = injecao;
        this.caixa = caixa;
        this.freioDt = freioDt;
        this.freioTr = freioTr;
        this.motor = motor;
        this.revisao = revisao;
        this.suspensaoDt = suspensaoDt;
        this.suspensaoTr = suspensaoTr;
        this.pneus = pneus;
        this.trocaOleo = trocaOleo;
    }

    //>>>>>> usado na tela em orçamento <<<<<<<

    public StatusAtendimento(String placa, String veiculo, byte orCambio, byte orEletrico, byte orMotor,
                             byte orInjecao, byte orMecanica, byte orPneu, byte orStCliente, byte orMontagem) {
        this.placa = placa;
        this.veiculo = veiculo;
        this.orCambio = orCambio;
        this.orEletrico = orEletrico;
        this.orMotor = orMotor;
        this.orInjecao = orInjecao;
        this.orMecanica = orMecanica;
        this.orPneu = orPneu;
        this.orStCliente = orStCliente;
        this.orMontagem = orMontagem;
    }

    // Conatrutor de circulos usa o mesmo do status em serviços

    //>>>>>> usado na tela em serviços <<<<<<<

    public StatusAtendimento(String placa, String veiculo, byte caixa, byte eletrico, byte injecao,
                             byte mecanico, byte motor, byte pneus, byte lavacao) {
        this.placa = placa;
        this.veiculo = veiculo;
        this.caixa = caixa;
        this.eletrico = eletrico;
        this.injecao = injecao;
        this.mecanico = mecanico;
        this.motor = motor;
        this.pneus = pneus;
        this.lavacao = lavacao;
    }

    public StatusAtendimento(String placa, String veiculo, Circulos sCambio, Circulos sEletrico, Circulos sInjecao,
                             Circulos mecanico1, Circulos sMotor, Circulos sPneus, Circulos lavacao1) {
        this.placa = placa;
        this.veiculo = veiculo;
        this.sCambio = sCambio;
        this.sEletrico = sEletrico;
        this.sInjecao = sInjecao;
        this.mecanico1 = mecanico1;
        this.sMotor = sMotor;
        this.sPneus = sPneus;
        this.lavacao1 = lavacao1;
    }

    //>>>>>> usado na tela em prontos <<<<<<<

    public StatusAtendimento(String placa, String veiculo, String cliente, String telefone, String statuAviso) {
        this.placa = placa;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.telefone = telefone;
        this.statuAviso = statuAviso;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public byte getTipo() {
        return tipo;
    }

    public void setTipo(byte tipo) {
        this.tipo = tipo;
    }

    public Integer getCodOs() {
        return codOs;
    }

    public void setCodOs(Integer codOs) {
        this.codOs = codOs;
    }

    public Integer getCodOrcamento() {
        return codOrcamento;
    }

    public void setCodOrcamento(Integer codOrcamento) {
        this.codOrcamento = codOrcamento;
    }

    public Integer getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(Integer codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public byte getEletrico() {
        return eletrico;
    }

    public void setEletrico(byte eletrico) {
        this.eletrico = eletrico;
    }

    public byte getInjecao() {
        return injecao;
    }

    public void setInjecao(byte injecao) {
        this.injecao = injecao;
    }

    public byte getCaixa() {
        return caixa;
    }

    public void setCaixa(byte caixa) {
        this.caixa = caixa;
    }

    public byte getFreioDt() {
        return freioDt;
    }

    public void setFreioDt(byte freioDt) {
        this.freioDt = freioDt;
    }

    public byte getFreioTr() {
        return freioTr;
    }

    public void setFreioTr(byte freioTr) {
        this.freioTr = freioTr;
    }

    public byte getMotor() {
        return motor;
    }

    public void setMotor(byte motor) {
        this.motor = motor;
    }

    public byte getRevisao() {
        return revisao;
    }

    public void setRevisao(byte revisao) {
        this.revisao = revisao;
    }

    public byte getSuspensaoDt() {
        return suspensaoDt;
    }

    public void setSuspensaoDt(byte suspensaoDt) {
        this.suspensaoDt = suspensaoDt;
    }

    public byte getSuspensaoTr() {
        return suspensaoTr;
    }

    public void setSuspensaoTr(byte suspensaoTr) {
        this.suspensaoTr = suspensaoTr;
    }

    public byte getPneus() {
        return pneus;
    }

    public void setPneus(byte pneus) {
        this.pneus = pneus;
    }

    public byte getTrocaOleo() {
        return trocaOleo;
    }

    public void setTrocaOleo(byte trocaOleo) {
        this.trocaOleo = trocaOleo;
    }

    public byte getLavacao() {
        return lavacao;
    }

    public void setLavacao(byte lavacao) {
        this.lavacao = lavacao;
    }

    public byte getAssLevar() {
        return assLevar;
    }

    public void setAssLevar(byte assLevar) {
        this.assLevar = assLevar;
    }

    public byte getOrCambio() {
        return orCambio;
    }

    public void setOrCambio(byte orCambio) {
        this.orCambio = orCambio;
    }

    public byte getOrEletrico() {
        return orEletrico;
    }

    public void setOrEletrico(byte orEletrico) {
        this.orEletrico = orEletrico;
    }

    public byte getOrMotor() {
        return orMotor;
    }

    public void setOrMotor(byte orMotor) {
        this.orMotor = orMotor;
    }

    public byte getOrInjecao() {
        return orInjecao;
    }

    public void setOrInjecao(byte orInjecao) {
        this.orInjecao = orInjecao;
    }

    public byte getOrMecanica() {
        return orMecanica;
    }

    public void setOrMecanica(byte orMecanica) {
        this.orMecanica = orMecanica;
    }

    public byte getOrPneu() {
        return orPneu;
    }

    public void setOrPneu(byte orPneu) {
        this.orPneu = orPneu;
    }

    public byte getOrStCliente() {
        return orStCliente;
    }

    public void setOrStCliente(byte orStCliente) {
        this.orStCliente = orStCliente;
    }

    public byte getOrMontagem() {
        return orMontagem;
    }

    public void setOrMontagem(byte orMontagem) {
        this.orMontagem = orMontagem;
    }

    public byte getStAviso() {
        return stAviso;
    }

    public void setStAviso(byte stAviso) {
        this.stAviso = stAviso;
    }

    public byte getStGeralAtend() {
        return stGeralAtend;
    }

    public void setStGeralAtend(byte stGeralAtend) {
        this.stGeralAtend = stGeralAtend;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Circulos getsEletrico() {
        return sEletrico;
    }

    public void setsEletrico(Circulos sEletrico) {
        this.sEletrico = sEletrico;
    }

    public Circulos getsInjecao() {
        return sInjecao;
    }

    public void setsInjecao(Circulos sInjecao) {
        this.sInjecao = sInjecao;
    }

    public Circulos getsCambio() {
        return sCambio;
    }

    public void setsCambio(Circulos sCambio) {
        this.sCambio = sCambio;
    }

    public Circulos getsFreioDt() {
        return sFreioDt;
    }

    public void setsFreioDt(Circulos sFreioDt) {
        this.sFreioDt = sFreioDt;
    }

    public Circulos getsFreioTr() {
        return sFreioTr;
    }

    public void setsFreioTr(Circulos sFreioTr) {
        this.sFreioTr = sFreioTr;
    }

    public Circulos getsMotor() {
        return sMotor;
    }

    public void setsMotor(Circulos sMotor1) {
        this.sMotor = sMotor1;
    }

    public Circulos getMecanico1() {
        return mecanico1;
    }

    public void setMecanico1(Circulos mecanico1) {
        this.mecanico1 = mecanico1;
    }

    public Circulos getsRevisao() {
        return sRevisao;
    }

    public void setsRevisao(Circulos sRevisao) {
        this.sRevisao = sRevisao;
    }

    public Circulos getsSuspDt() {
        return sSuspDt;
    }

    public void setsSuspDt(Circulos sSuspDt) {
        this.sSuspDt = sSuspDt;
    }

    public Circulos getsSuspTr() {
        return sSuspTr;
    }

    public void setsSuspTr(Circulos sSuspTr) {
        this.sSuspTr = sSuspTr;
    }

    public Circulos getsPneus() {
        return sPneus;
    }

    public void setsPneus(Circulos sPneus) {
        this.sPneus = sPneus;
    }

    public Circulos getsTrOleo() {
        return sTrOleo;
    }

    public void setsTrOleo(Circulos sTrOleo) {
        this.sTrOleo = sTrOleo;
    }

    public Circulos getLavacao1() {
        return lavacao1;
    }

    public void setLavacao1(Circulos lavacao1) {
        this.lavacao1 = lavacao1;
    }

    public byte getAlinBalan() {
        return alinBalan;
    }

    public void setAlinBalan(byte alinBalan) {
        this.alinBalan = alinBalan;
    }

    public byte getMecanico() {
        return mecanico;
    }

    public void setMecanico(byte mecanico) {
        this.mecanico = mecanico;
    }

    public Circulos getMontOrc() {
        return montOrc;
    }

    public void setMontOrc(Circulos montOrc) {
        montOrc = montOrc;
    }

    public Circulos getStCliente() {
        return stCliente;
    }

    public void setStCliente(Circulos stCliente) {
        stCliente = stCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatuAviso() {
        return statuAviso;
    }

    public void setStatuAviso(String statuAviso) {
        this.statuAviso = statuAviso;
    }
}
