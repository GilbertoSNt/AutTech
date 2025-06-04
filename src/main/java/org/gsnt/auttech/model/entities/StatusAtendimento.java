package org.gsnt.auttech.model.entities;

import org.gsnt.auttech.util.Circulos;

public class StatusAtendimento {

    /*
     * Tipo
     * 1 - orçamento
     * 2 - serviço
     *
     * Status da ordem de serviço
     * 1 - serviço não iniciado
     * 2 - Serviço já iniciado análise
     * 3 - serviço em orçamento
     * 4 - serviço liberado
     * 5 - Cancelada
     * 6 - Fechada
     * 7 - Paga
     * 8 - Pendente Pagamento
     * 9 - Faturada
     *
     * Status do atendimento
     * Tela serviços a serem iniciados
     *
     * 1 - Serviço sem direcionamento
     * 2 - Direcionamento sem confirmação
     * 3 - OS com orçamento pendente
     * 4 - Orçamento aguardando liberação
     * 5 - Orçamento liberado aguardandor peças
     * 6 - Orçamento liberado aguardando o inicio do serviço
     *
     * Tela serviços iniciados
     * 7 - Não iniciado
     * 8 - Em produção
     * 9 - Servciço pronto sem aviso ao cliente
     *
     * Veículos em orçamento
     * 10 - Aguardando profissional
     * 11 - Em preparação
     * 12 - Liberado para o cliente
     *
     * Status geral do atendimento
     * 1 - Aberta
     * 2 - Cancelada
     * 3 - Fechada
     * 4 - Paga
     * 5 - Pendente Pagamento
     * 6 - Faturada
     * */

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
    private byte pneus;
    private byte trocaOleo;
    private byte lavacao;
    private byte assLevar;
    private byte orCambio;
    private byte orEletrico;
    private byte orFreio;
    private byte orInjecao;
    private byte orMecanica;
    private byte orPneu;
    private byte orStCliente;
    private byte orMontagem;
    private byte stAviso;
    private byte stGeralAtend;

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

   // public StatusAtendimento(){}

    public StatusAtendimento(Integer cod, byte tipo, Integer codOs, String placa, String veiculo, Integer codOrcamento,
                             Integer codVeiculo, byte stGeralAtend, byte eletrico, byte injecao, byte caixa,
                             byte freioDt, byte freioTr, byte motor, byte revisao, byte suspensaoDt, byte suspensaoTr,
                             byte pneus, byte trocaOleo, byte lavacao, byte assLevar) {
        this.cod = cod;
        this.tipo = tipo;
        this.codOs = codOs;
        this.codOrcamento = codOrcamento;
        this.placa = placa;
        this.codVeiculo = codVeiculo;
        this.stGeralAtend = stGeralAtend;
        this.eletrico = eletrico;
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
        this.lavacao = lavacao;
        this.assLevar = assLevar;
        this.veiculo = veiculo;
    }

    public StatusAtendimento(Integer codOs, String placa, String veiculo, byte eletrico, byte injecao,
                             byte caixa, byte freioDt, byte freioTr, byte motor, byte revisao, byte suspensaoDt,
                            byte suspensaoTr, byte pneus, byte trocaOleo) {
        //Verificado
        this.codOs = codOs;
        this.placa = placa;
        this.veiculo = veiculo;
        this.eletrico = eletrico;
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

    public StatusAtendimento(Integer cod, byte tipo, Integer codOs, String placa, Integer codOrcamento, Integer codVeiculo,
                             String veiculo, byte stAviso, byte stGeralAtend) {
        this.cod = cod;
        this.tipo = tipo;
        this.codOs = codOs;
        this.placa = placa;
        this.codOrcamento = codOrcamento;
        this.codVeiculo = codVeiculo;
        this.stAviso = stAviso;
        this.stGeralAtend = stGeralAtend;
        this.veiculo = veiculo;
    }


    public StatusAtendimento(Integer codOs, String placa, String veiculo, Circulos sEletrico1, Circulos sInjecao1,
                             Circulos sCambio1, Circulos sFreioDt1, Circulos sFreioTr1, Circulos sMotor1,
                             Circulos sRevisao1, Circulos sSuspDt1, Circulos sSuspTr1, Circulos sPneus1,
                             Circulos sTrOleo1){
        //Verificado
        this.codOs = codOs;
        this.placa = placa;
        this.veiculo = veiculo;
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

    public byte getOrFreio() {
        return orFreio;
    }

    public void setOrFreio(byte orFreio) {
        this.orFreio = orFreio;
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
}
