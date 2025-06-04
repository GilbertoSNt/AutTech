package org.gsnt.auttech.model.entities;

import org.gsnt.auttech.util.Circulos;

import java.sql.Time;
import java.util.Date;

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
/*INSERT INTO public.tabos(
	cod, codcliente, codveiculo, dataabertura, datafechamento,
	vtpecas, vtservicos, vtos, revisao, suspensao, injecao, pneus, trocaoleo, freio, eletrico, mecanico, motor, caixa, socmecanico,
	soceletrico, asslevar, assguincho, assbuscar, assclientetraz, assenvioguincho, assenviodeslocamento,
	obsos, statusos)
	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);*/

    private Integer numero;
    private Integer codCliente;
    private Integer CodVeiculo;
    private Date dataAbertura;
    private Time horaAbertura;
    private Time horafechamento;
    private Date dataFechamento;
    private Integer vtPecas;
    private Integer vtServicos;
    private Integer vtOs;
    private Byte revisao;
    private Byte suspensaoDt;
    private Byte suspensaoTr;
    private Byte injecao;
    private Byte pneus;
    private Byte trocaOleo;
    private Byte freioDt;
    private Byte freioTr;
    private Byte eletrico;
    private Byte mecanico;
    private Byte motor;
    private Byte caixa;
    private Byte socMecanico;
    private Byte socEletrico;
    private Byte assLevar;
    private Byte assGuincho;
    private Byte assBuscar;
    private Byte assClienteTraz;
    private Byte assEnvioGuincho;
    private Byte assEnvioDeslocamento;
    private String obsOs;
    private Byte statusOs;
    private String telefone;
    private String placa;
    private String veiculo;
    private Byte lavacao;
    private String nomeCliente;

    private Byte fCaixa;
    private Byte fFreio;
    private Byte fMotor;
    private Byte fSuspensao;
    private Byte fEletrico;
    private Byte finjecao;
    private Byte fPneus;
    private Byte fAlinhamento;
    private Byte fBalanceamento;


    public OrdemServico(){}
// Construtor tela a serem iniciados

    public OrdemServico(Integer numero, String placa, String veiculo, Byte revisao, Byte suspensaoDt,
                        Byte suspensaoTr, Byte injecao, Byte pneus, Byte trocaOleo, Byte freioDt,
                        Byte freioTr, Byte eletrico, Byte motor, Byte caixa) {
        this.numero = numero;
        this.placa = placa;
        this.veiculo = veiculo;
        this.revisao = revisao;
        this.suspensaoDt = suspensaoDt;
        this.suspensaoTr = suspensaoTr;
        this.injecao = injecao;
        this.pneus = pneus;
        this.trocaOleo = trocaOleo;
        this.freioDt = freioDt;
        this.freioTr = freioTr;
        this.eletrico = eletrico;
        this.motor = motor;
        this.caixa = caixa;
    }

// Construtor da tela em serviços

    public OrdemServico(String veiculo, String placa, Byte caixa, Byte eletrico, Byte injecao, Byte mecanico, Byte motor, Byte pneus, Byte lavacao) {
        this.veiculo = veiculo;
        this.placa = placa;
        this.caixa = caixa;
        this.eletrico = eletrico;
        this.injecao = injecao;
        this.mecanico = mecanico;
        this.motor = motor;
        this.pneus = pneus;
        this.lavacao = lavacao;
    }

    //Construtor veículos prontos

    public OrdemServico(String placa, String veiculo, String nomeCliente, String telefone, Byte statusOs) {
        this.placa = placa;
        this.veiculo = veiculo;
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.statusOs = statusOs;
    }

    //Construtor da gravação da tela

    public OrdemServico(Integer codCliente, Integer codVeiculo, Date dataAbertura, Time horaAbertura, Byte revisao,
                        Byte suspensaoDt, Byte suspensaoTr, Byte injecao, Byte pneus, Byte trocaOleo, Byte freioDt,
                        Byte freioTr, Byte eletrico, Byte motor, Byte mecanico, Byte caixa, Byte socMecanico,
                        Byte assBuscar, Byte socEletrico, Byte assLevar, Byte assGuincho, Byte assClienteTraz,
                        String obsOs) {
        this.codCliente = codCliente;
        this.CodVeiculo = codVeiculo;
        this.dataAbertura = dataAbertura;
        this.horaAbertura = horaAbertura;
        this.revisao = revisao;
        this.suspensaoDt = suspensaoDt;
        this.suspensaoTr = suspensaoTr;
        this.injecao = injecao;
        this.pneus = pneus;
        this.trocaOleo = trocaOleo;
        this.freioDt = freioDt;
        this.freioTr = freioTr;
        this.eletrico = eletrico;
        this.motor = motor;
        this.mecanico = mecanico;
        this.caixa = caixa;
        this.socMecanico = socMecanico;
        this.assBuscar = assBuscar;
        this.socEletrico = socEletrico;
        this.assLevar = assLevar;
        this.assGuincho = assGuincho;
        this.assClienteTraz = assClienteTraz;
        this.obsOs = obsOs;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodVeiculo() {
        return CodVeiculo;
    }

    public void setCodVeiculo(Integer codVeiculo) {
        CodVeiculo = codVeiculo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Integer getVtPecas() {
        return vtPecas;
    }

    public void setVtPecas(Integer vtPecas) {
        this.vtPecas = vtPecas;
    }

    public Integer getVtServicos() {
        return vtServicos;
    }

    public void setVtServicos(Integer vtServicos) {
        this.vtServicos = vtServicos;
    }

    public Integer getVtOs() {
        return vtOs;
    }

    public void setVtOs(Integer vtOs) {
        this.vtOs = vtOs;
    }

    public Byte getRevisao() {
        return revisao;
    }

    public void setRevisao(Byte revisao) {
        this.revisao = revisao;
    }

    public Byte getInjecao() {
        return injecao;
    }

    public void setInjecao(Byte injecao) {
        this.injecao = injecao;
    }

    public Byte getPneus() {
        return pneus;
    }

    public void setPneus(Byte pneus) {
        this.pneus = pneus;
    }

    public Byte getTrocaOleo() {
        return trocaOleo;
    }

    public void setTrocaOleo(Byte trocaOleo) {
        this.trocaOleo = trocaOleo;
    }

    public Byte getEletrico() {
        return eletrico;
    }

    public void setEletrico(Byte eletrico) {
        this.eletrico = eletrico;
    }

    public Byte getMecanico() {
        return mecanico;
    }

    public void setMecanico(Byte mecanico) {
        this.mecanico = mecanico;
    }

    public Byte getMotor() {
        return motor;
    }

    public void setMotor(Byte motor) {
        this.motor = motor;
    }

    public Byte getCaixa() {
        return caixa;
    }

    public void setCaixa(Byte caixa) {
        this.caixa = caixa;
    }

    public Byte getSocMecanico() {
        return socMecanico;
    }

    public void setSocMecanico(Byte socMecanico) {
        this.socMecanico = socMecanico;
    }

    public Byte getSocEletrico() {
        return socEletrico;
    }

    public void setSocEletrico(Byte socEletrico) {
        this.socEletrico = socEletrico;
    }

    public Byte getAssLevar() {
        return assLevar;
    }

    public void setAssLevar(Byte assLevar) {
        this.assLevar = assLevar;
    }

    public Byte getAssGuincho() {
        return assGuincho;
    }

    public void setAssGuincho(Byte assGuincho) {
        this.assGuincho = assGuincho;
    }

    public Byte getAssBuscar() {
        return assBuscar;
    }

    public void setAssBuscar(Byte assBuscar) {
        this.assBuscar = assBuscar;
    }

    public Byte getAssClienteTraz() {
        return assClienteTraz;
    }

    public void setAssClienteTraz(Byte assClienteTraz) {
        this.assClienteTraz = assClienteTraz;
    }

    public Byte getAssEnvioGuincho() {
        return assEnvioGuincho;
    }

    public void setAssEnvioGuincho(Byte assEnvioGuincho) {
        this.assEnvioGuincho = assEnvioGuincho;
    }

    public Byte getAssEnvioDeslocamento() {
        return assEnvioDeslocamento;
    }

    public void setAssEnvioDeslocamento(Byte assEnvioDeslocamento) {
        this.assEnvioDeslocamento = assEnvioDeslocamento;
    }

    public String getObsOs() {
        return obsOs;
    }

    public void setObsOs(String obsOs) {
        this.obsOs = obsOs;
    }

    public Byte getStatusOs() {
        return statusOs;
    }

    public void setStatusOs(Byte statusOs) {
        this.statusOs = statusOs;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Byte getSuspensaoDt() {
        return suspensaoDt;
    }

    public void setSuspensaoDt(Byte suspensaoDt) {
        this.suspensaoDt = suspensaoDt;
    }

    public Byte getSuspensaoTr() {
        return suspensaoTr;
    }

    public void setSuspensaoTr(Byte suspensaoTr) {
        this.suspensaoTr = suspensaoTr;
    }

    public Byte getFreioDt() {
        return freioDt;
    }

    public void setFreioDt(Byte freioDt) {
        this.freioDt = freioDt;
    }

    public Byte getFreioTr() {
        return freioTr;
    }

    public void setFreioTr(Byte freioTr) {
        this.freioTr = freioTr;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Byte getLavacao() {
        return lavacao;
    }

    public void setLavacao(Byte lavacao) {
        this.lavacao = lavacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Time getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Time horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Time getHorafechamento() {
        return horafechamento;
    }

    public void setHorafechamento(Time horafechamento) {
        this.horafechamento = horafechamento;
    }
}
