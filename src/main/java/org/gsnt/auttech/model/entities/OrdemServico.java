package org.gsnt.auttech.model.entities;

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
    private Integer codVeiculo;
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
    private Boolean revisao;
    private Boolean eletrica;
    private Boolean injecao;
    private Boolean mecanico;
    private Boolean freioDt;
    private Boolean freioTr;
    private Boolean suspDt;
    private Boolean suspTr;
    private Boolean caixa;
    private Boolean motor;
    private Boolean trocaoleo;
    private Boolean alin;
    private Boolean pneu;
    private Boolean lavacao;


    public OrdemServico(){}

    public OrdemServico(Integer codVeiculo, String dataAbertura, String horaAbertura, Boolean revisao,
                        Boolean eletrica, Boolean injecao, Boolean mecanico, Boolean freioDt,  Boolean freioTr,
                        Boolean suspDt, Boolean suspTr, Boolean caixa, Boolean motor, Boolean trocaoleo, Boolean alin,
                        Boolean pneu, Boolean lavacao, Integer numero){

        this.codVeiculo = codVeiculo;
        this.dataAbertura = dataAbertura;
        this.horaAbertura = horaAbertura;
        this.revisao = revisao;
        this.eletrica = eletrica;
        this.injecao = injecao;
        this.mecanico = mecanico;
        this.freioDt = freioDt;
        this.freioTr = freioTr;
        this.suspDt = suspDt;
        this.suspTr = suspTr;
        this.caixa = caixa;
        this.motor = motor;
        this.trocaoleo = trocaoleo;
        this.alin = alin;
        this.pneu = pneu;
        this.lavacao = lavacao;
        this.numero = numero;

    }

    public OrdemServico(Integer codVeiculo, Integer codCliente, String dataAbertura, String horaAbertura,
                        Boolean necOrcamento, Boolean assLevarVeiculo, Byte statusOs,String obsOs){

        this.codVeiculo = codVeiculo;
        this.codCliente = codCliente;
        this.dataAbertura = dataAbertura;
        this.horaAbertura = horaAbertura;
        this.necOrcamento = necOrcamento;
        this.assLevarVeiculo = assLevarVeiculo;
        this.statusOs = statusOs;
        this.obsOs = obsOs;

    }


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
        return codVeiculo;
    }

    public void setCodVeiculo(Integer codVeiculo) {
        codVeiculo = codVeiculo;
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

    public Boolean getRevisao() {
        return revisao;
    }

    public void setRevisao(Boolean revisao) {
        this.revisao = revisao;
    }

    public Boolean getEletrica() {
        return eletrica;
    }

    public void setEletrica(Boolean eletrica) {
        this.eletrica = eletrica;
    }

    public Boolean getInjecao() {
        return injecao;
    }

    public void setInjecao(Boolean injecao) {
        this.injecao = injecao;
    }

    public Boolean getMecanico() {
        return mecanico;
    }

    public void setMecanico(Boolean mecanico) {
        this.mecanico = mecanico;
    }

    public Boolean getFreioDt() {
        return freioDt;
    }

    public void setFreioDt(Boolean freioDt) {
        this.freioDt = freioDt;
    }

    public Boolean getSuspDt() {
        return suspDt;
    }

    public void setSuspDt(Boolean suspDt) {
        this.suspDt = suspDt;
    }

    public Boolean getCaixa() {
        return caixa;
    }

    public void setCaixa(Boolean caixa) {
        this.caixa = caixa;
    }

    public Boolean getMotor() {
        return motor;
    }

    public void setMotor(Boolean motor) {
        this.motor = motor;
    }

    public Boolean getTrocaoleo() {
        return trocaoleo;
    }

    public void setTrocaoleo(Boolean trocaoleo) {
        this.trocaoleo = trocaoleo;
    }

    public Boolean getAlin() {
        return alin;
    }

    public void setAlin(Boolean alin) {
        this.alin = alin;
    }

    public Boolean getPneu() {
        return pneu;
    }

    public void setPneu(Boolean pneu) {
        this.pneu = pneu;
    }

    public Boolean getLavacao() {
        return lavacao;
    }

    public void setLavacao(Boolean lavacao) {
        this.lavacao = lavacao;
    }

    public Boolean getFreioTr() {
        return freioTr;
    }

    public void setFreioTr(Boolean freioTr) {
        this.freioTr = freioTr;
    }

    public Boolean getSuspTr() {
        return suspTr;
    }

    public void setSuspTr(Boolean suspTr) {
        this.suspTr = suspTr;
    }
}
