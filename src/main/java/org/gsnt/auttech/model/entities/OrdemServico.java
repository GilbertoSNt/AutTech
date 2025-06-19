package org.gsnt.auttech.model.entities;

import org.gsnt.auttech.util.Circulos;

import java.sql.Time;
import java.util.Date;

public class OrdemServico {

    /*
     * Status da ordem de serviço
     * 0 - não solicitado
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
    private Integer orcAssociado;
    private String dataAbertura;
    private String horaAbertura;
    private String horafechamento;
    private String dataFechamento;
    private Integer vtPecas;
    private Integer vtServicos;
    private Integer vtOs;
    private String obsOs;
    private Byte statusOs;
    private String telefone;
    private String placa;
    private String veiculo;
    private String nomeCliente;
    private Boolean necOrcamento;
    private Boolean assLevarVeiculo;


    public OrdemServico(){}
// Construtor tela a serem iniciados


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

    public Integer getOrcAssociado() {
        return orcAssociado;
    }

    public void setOrcAssociado(Integer orcAssociado) {
        this.orcAssociado = orcAssociado;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getHorafechamento() {
        return horafechamento;
    }

    public void setHorafechamento(String horafechamento) {
        this.horafechamento = horafechamento;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Boolean getNecOrcamento() {
        return necOrcamento;
    }

    public void setNecOrcamento(Boolean necOrcamento) {
        this.necOrcamento = necOrcamento;
    }

    public Boolean getAssLevarVeiculo() {
        return assLevarVeiculo;
    }

    public void setAssLevarVeiculo(Boolean assLevarVeiculo) {
        this.assLevarVeiculo = assLevarVeiculo;
    }
}
