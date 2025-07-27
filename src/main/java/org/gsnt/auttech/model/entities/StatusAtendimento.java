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
     * 4 - serviço liberado(Não iniciado)
     * 5 - serviço iniciado
     * 6 - Cancelada
     * 7 - Fechada
     * 8 - Veículo pronto
     * 9 - Cliente avisado
     * 10 - Faturada
     * 11 - Paga
     * 12 - Pendente Pagamento
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
     * Tela serviços iniciados
     *
     * 7 - Orçamento liberado peças disponíveis aguardando retorno veículo - Vermelho - f50505
     * 8 - Não iniciado - veículo disponível  - Azul claro - 54d6f0
     * 9 - Em produção - verde - 70c3a7
     * 10 - Serviço pronto sem aviso ao cliente   - verde escuro - 3f676d
     *
     * Veículos em orçamento do item 13 em diante coluna status cliente
     * 11 - Aguardando profissional - Amarelo - f9d428
     * 12 - Em preparação - Amarelo - f9d428 / verde - 70c3a7
     * 13 - Liberado para o cliente - verde - 70c3a7
     * 14 - Aguardando liberação - lilas - 7c2d91
     * 15 - orçamento liberado parcial - #e3c9a2
     * 16 - orçamento recusado - 000000
     * 17 - orçamento não enviado ao cliente - f59097
     * 18 - Orçamento liberado total - 86fdff
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

    private Circulos cirEletrico;
    private Circulos cirInjecao;
    private Circulos cirCambio;
    private Circulos cirFreioDt;
    private Circulos cirFreioTr;
    private Circulos cirMotor;
    private Circulos mecanico1;
    private Circulos cirRevisao;
    private Circulos cirSuspDt;
    private Circulos cirSuspTr;
    private Circulos cirPneus;
    private Circulos cirTrOleo;
    private Circulos lavacao1;
    private Circulos montOrc;
    private Circulos stCliente;

    public StatusAtendimento(){}

    //>>>>>> usado na tela a serem iniciados <<<<<<<

    public StatusAtendimento(Integer cod, String placa, String veiculo, Circulos sEletrico, Circulos sInjecao,
                             Circulos cirCambio, Circulos cirFreioDt, Circulos cirFreioTr, Circulos cirMotor,
                             Circulos cirRevisao, Circulos cirSuspDt, Circulos cirSuspTr, Circulos cirPneus, Circulos cirTrOleo) {

        this.cod = cod;
        this.placa = placa;
        this.veiculo = veiculo;
        this.cirEletrico = sEletrico;
        this.cirInjecao = sInjecao;
        this.cirCambio = cirCambio;
        this.cirFreioDt = cirFreioDt;
        this.cirFreioTr = cirFreioTr;
        this.cirMotor = cirMotor;
        this.cirRevisao = cirRevisao;
        this.cirSuspDt = cirSuspDt;
        this.cirSuspTr = cirSuspTr;
        this.cirPneus = cirPneus;
        this.cirTrOleo = cirTrOleo;
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

    public StatusAtendimento(String placa, String veiculo, Circulos cirCambio, Circulos sEletrico, Circulos sInjecao,
                             Circulos mecanico1, Circulos cirMotor, Circulos cirPneus, Circulos montOrc, Circulos stCliente) {
        this.placa = placa;
        this.veiculo = veiculo;
        this.cirCambio = cirCambio;
        this.cirEletrico = sEletrico;
        this.cirInjecao = sInjecao;
        this.mecanico1 = mecanico1;
        this.cirMotor = cirMotor;
        this.cirPneus = cirPneus;
        this.montOrc = montOrc;
        this.stCliente = stCliente;

    }



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

    public StatusAtendimento(String placa, String veiculo, Circulos cirCambio, Circulos sEletrico, Circulos sInjecao,
                             Circulos mecanico1, Circulos cirMotor, Circulos cirPneus, Circulos lavacao1) {
        this.placa = placa;
        this.veiculo = veiculo;
        this.cirCambio = cirCambio;
        this.cirEletrico = sEletrico;
        this.cirInjecao = sInjecao;
        this.mecanico1 = mecanico1;
        this.cirMotor = cirMotor;
        this.cirPneus = cirPneus;
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

    public Circulos getCirEletrico() {
        return cirEletrico;
    }

    public void setCirEletrico(Circulos cirEletrico) {
        this.cirEletrico = cirEletrico;
    }

    public Circulos getCirInjecao() {
        return cirInjecao;
    }

    public void setCirInjecao(Circulos cirInjecao) {
        this.cirInjecao = cirInjecao;
    }

    public Circulos getCirCambio() {
        return cirCambio;
    }

    public void setCirCambio(Circulos cirCambio) {
        this.cirCambio = cirCambio;
    }

    public Circulos getCirFreioDt() {
        return cirFreioDt;
    }

    public void setCirFreioDt(Circulos cirFreioDt) {
        this.cirFreioDt = cirFreioDt;
    }

    public Circulos getCirFreioTr() {
        return cirFreioTr;
    }

    public void setCirFreioTr(Circulos cirFreioTr) {
        this.cirFreioTr = cirFreioTr;
    }

    public Circulos getCirMotor() {
        return cirMotor;
    }

    public void setCirMotor(Circulos sMotor1) {
        this.cirMotor = sMotor1;
    }

    public Circulos getMecanico1() {
        return mecanico1;
    }

    public void setMecanico1(Circulos mecanico1) {
        this.mecanico1 = mecanico1;
    }

    public Circulos getCirRevisao() {
        return cirRevisao;
    }

    public void setCirRevisao(Circulos cirRevisao) {
        this.cirRevisao = cirRevisao;
    }

    public Circulos getCirSuspDt() {
        return cirSuspDt;
    }

    public void setCirSuspDt(Circulos cirSuspDt) {
        this.cirSuspDt = cirSuspDt;
    }

    public Circulos getCirSuspTr() {
        return cirSuspTr;
    }

    public void setCirSuspTr(Circulos cirSuspTr) {
        this.cirSuspTr = cirSuspTr;
    }

    public Circulos getCirPneus() {
        return cirPneus;
    }

    public void setCirPneus(Circulos cirPneus) {
        this.cirPneus = cirPneus;
    }

    public Circulos getCirTrOleo() {
        return cirTrOleo;
    }

    public void setCirTrOleo(Circulos cirTrOleo) {
        this.cirTrOleo = cirTrOleo;
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
