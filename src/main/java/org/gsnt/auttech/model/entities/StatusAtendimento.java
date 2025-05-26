package org.gsnt.auttech.model.entities;

public class StatusAtendimento {

    /*
     * Tipo
     * 1 - orçamento
     * 2 - serviço
     *
     * Status da ordem de serviço
     * 1 - Aberta
     * 2 - Cancelada
     * 3 - Fechada
     * 4 - Paga
     * 5 - Pendente Pagamento
     * 6 - Faturada
     *
     * Status do atendimento
     * Tela serviços a serem iniciados
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
     * */

    private Integer cod;
    private byte tipo;
    private Integer codOs;
    private Integer codOrcamento;
    private Integer codVeiculo;
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

    public StatusAtendimento(Integer cod, byte tipo, Integer codOs, Integer codOrcamento, Integer codVeiculo,
                             byte stGeralAtend, byte eletrico, byte injecao, byte caixa, byte freioDt, byte freioTr,
                             byte motor, byte revisao, byte suspensaoDt, byte suspensaoTr, byte pneus, byte trocaOleo,
                             byte lavacao, byte assLevar) {
        this.cod = cod;
        this.tipo = tipo;
        this.codOs = codOs;
        this.codOrcamento = codOrcamento;
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
    }

    public StatusAtendimento(Integer cod, byte tipo, Integer codOs, Integer codOrcamento, Integer codVeiculo,
                             byte stGeralAtend, byte orMontagem, byte orStCliente, byte orPneu, byte orMecanica,
                             byte orInjecao, byte orFreio, byte orEletrico, byte orCambio) {
        this.cod = cod;
        this.tipo = tipo;
        this.codOs = codOs;
        this.codOrcamento = codOrcamento;
        this.codVeiculo = codVeiculo;
        this.stGeralAtend = stGeralAtend;
        this.orMontagem = orMontagem;
        this.orStCliente = orStCliente;
        this.orPneu = orPneu;
        this.orMecanica = orMecanica;
        this.orInjecao = orInjecao;
        this.orFreio = orFreio;
        this.orEletrico = orEletrico;
        this.orCambio = orCambio;
    }

    public StatusAtendimento(Integer cod, byte tipo, Integer codOs, Integer codOrcamento, Integer codVeiculo,
                             byte stAviso, byte stGeralAtend) {
        this.cod = cod;
        this.tipo = tipo;
        this.codOs = codOs;
        this.codOrcamento = codOrcamento;
        this.codVeiculo = codVeiculo;
        this.stAviso = stAviso;
        this.stGeralAtend = stGeralAtend;
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
}
