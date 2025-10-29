package org.gsnt.auttech.model.entities;

public class Orcamento {

    private Integer cod;
    private Integer codVeiculo;
    private Integer codCliente;
    private Integer vtPecas;
    private Integer vtServicos;
    private Integer vtOr;
    private Integer stGeralOrc;
    private Integer respCliente;
    private String dataRespCliente;
    private String horaRespCliente;
    private String formaRespCliente;
    private Integer respTecMecanico;
    private Integer respTecEletrico;
    private Integer respTecInjecao;
    private Integer respTecPneu;
    private Integer respTecCambio;
    private Integer respTecMotor;
    private String dataAbertura;
    private String dataFechamento;
    private String horaFechamento;
    private String placa;
    private String modelo;
    private Integer ordemServico;
    private Byte digitoOr;

    public Orcamento(String dataAbertura, Integer codVeiculo, Integer codCliente,Integer ordemServico) {
        this.dataAbertura = dataAbertura;
        this.codVeiculo = codVeiculo;
        this.codCliente = codCliente;
        this.ordemServico = ordemServico;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(Integer codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
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

    public Integer getVtOr() {
        return vtOr;
    }

    public void setVtOr(Integer vtOr) {
        this.vtOr = vtOr;
    }

    public Integer getStGeralOrc() {
        return stGeralOrc;
    }

    public void setStGeralOrc(Integer stGeralOrc) {
        this.stGeralOrc = stGeralOrc;
    }

    public Integer getRespCliente() {
        return respCliente;
    }

    public void setRespCliente(Integer respCliente) {
        this.respCliente = respCliente;
    }

    public String getDataRespCliente() {
        return dataRespCliente;
    }

    public void setDataRespCliente(String dataRespCliente) {
        this.dataRespCliente = dataRespCliente;
    }

    public String getHoraRespCliente() {
        return horaRespCliente;
    }

    public void setHoraRespCliente(String horaRespCliente) {
        this.horaRespCliente = horaRespCliente;
    }

    public String getFormaRespCliente() {
        return formaRespCliente;
    }

    public void setFormaRespCliente(String formaRespCliente) {
        this.formaRespCliente = formaRespCliente;
    }

    public Integer getRespTecMecanico() {
        return respTecMecanico;
    }

    public void setRespTecMecanico(Integer respTecMecanico) {
        this.respTecMecanico = respTecMecanico;
    }

    public Integer getRespTecEletrico() {
        return respTecEletrico;
    }

    public void setRespTecEletrico(Integer respTecEletrico) {
        this.respTecEletrico = respTecEletrico;
    }

    public Integer getRespTecInjecao() {
        return respTecInjecao;
    }

    public void setRespTecInjecao(Integer respTecInjecao) {
        this.respTecInjecao = respTecInjecao;
    }

    public Integer getRespTecPneu() {
        return respTecPneu;
    }

    public void setRespTecPneu(Integer respTecPneu) {
        this.respTecPneu = respTecPneu;
    }

    public Integer getRespTecCambio() {
        return respTecCambio;
    }

    public void setRespTecCambio(Integer respTecCambio) {
        this.respTecCambio = respTecCambio;
    }

    public Integer getRespTecMotor() {
        return respTecMotor;
    }

    public void setRespTecMotor(Integer respTecMotor) {
        this.respTecMotor = respTecMotor;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
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

    public Integer getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(Integer ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Byte getDigitoOr() {
        return digitoOr;
    }

    public void setDigitoOr(Byte digitoOr) {
        this.digitoOr = digitoOr;
    }

    /*
  //>>>>> refatorar a partir daqui <<<<<
    private Integer orcCambio;
    private Integer orcEletrico;
    private Integer orcMotor;
    private Integer orcInjecao;
    private Integer orcMecanico;
    private Integer orcPneu;
    private Integer statusOrc;
    private Integer statusCliente;

    private Circulos orcCambio2;
    private Circulos orcEletrico2;
    private Circulos orcMotor2;
    private Circulos orcInjecao2;
    private Circulos orcMecanico2;
    private Circulos orcPneu2;
    private Circulos statusOrc2;
    private String statusCliente2;

    public Orcamento(Integer cod, String placa, String modelo, Integer statusCliente, Integer statusOrc,
                     Integer orcPneu, Integer orcMecanico, Integer orcInjecao, Integer orcMotor, Integer
                     orcEletrico, Integer orcCambio) {

        this.cod = cod;
        this.placa = placa;
        this.modelo = modelo;
        this.statusCliente = statusCliente;
        this.statusOrc = statusOrc;
        this.orcPneu = orcPneu;
        this.orcMecanico = orcMecanico;
        this.orcInjecao = orcInjecao;
        this.orcMotor = orcMotor;
        this.orcEletrico = orcEletrico;
        this.orcCambio = orcCambio;

    }

    public Orcamento(Integer cod, String placa, String modelo, String statusCliente2, Circulos orcCambio2,
                     Circulos orcEletrico2, Circulos orcFreio2, Circulos orcInjecao2, Circulos orcMecanico2,
                     Circulos orcPneu2, Circulos statusOrc2) {

        this.cod = cod;
        this.placa = placa;
        this.modelo = modelo;
        this.statusCliente2 = statusCliente2;
        this.orcCambio2 = orcCambio2;
        this.orcEletrico2 = orcEletrico2;
        this.orcMotor2 = orcMotor2;
        this.orcInjecao2 = orcInjecao2;
        this.orcMecanico2 = orcMecanico2;
        this.orcPneu2 = orcPneu2;
        this.statusOrc2 = statusOrc2;

    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
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

    public Integer getOrcCambio() {
        return orcCambio;
    }

    public void setOrcCambio(Integer orcCambio) {
        this.orcCambio = orcCambio;
    }

    public Integer getOrcEletrico() {
        return orcEletrico;
    }

    public void setOrcEletrico(Integer orcEletrico) {
        this.orcEletrico = orcEletrico;
    }

    public Integer getOrcMotor() {
        return orcMotor;
    }

    public void setOrcMotor(Integer orcMotor) {
        this.orcMotor = orcMotor;
    }

    public Integer getOrcInjecao() {
        return orcInjecao;
    }

    public void setOrcInjecao(Integer orcInjecao) {
        this.orcInjecao = orcInjecao;
    }

    public Integer getOrcMecanico() {
        return orcMecanico;
    }

    public void setOrcMecanico(Integer orcMecanico) {
        this.orcMecanico = orcMecanico;
    }

    public Integer getOrcPneu() {
        return orcPneu;
    }

    public void setOrcPneu(Integer orcPneu) {
        this.orcPneu = orcPneu;
    }

    public Integer getStatusOrc() {
        return statusOrc;
    }

    public void setStatusOrc(Integer statusOrc) {
        this.statusOrc = statusOrc;
    }

    public Integer getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(Integer statusCliente) {
        this.statusCliente = statusCliente;
    }

    public Circulos getOrcCambio2() {
        return orcCambio2;
    }

    public void setOrcCambio2(Circulos orcCambio2) {
        this.orcCambio2 = orcCambio2;
    }

    public Circulos getOrcEletrico2() {
        return orcEletrico2;
    }

    public void setOrcEletrico2(Circulos orcEletrico2) {
        this.orcEletrico2 = orcEletrico2;
    }

    public Circulos getOrcMotor2() {
        return orcMotor2;
    }

    public void setOrcMotor2(Circulos orcFreio2) {
        this.orcMotor2 = orcFreio2;
    }

    public Circulos getOrcInjecao2() {
        return orcInjecao2;
    }

    public void setOrcInjecao2(Circulos orcInjecao2) {
        this.orcInjecao2 = orcInjecao2;
    }

    public Circulos getOrcMecanico2() {
        return orcMecanico2;
    }

    public void setOrcMecanico2(Circulos orcMecanico2) {
        this.orcMecanico2 = orcMecanico2;
    }

    public Circulos getOrcPneu2() {
        return orcPneu2;
    }

    public void setOrcPneu2(Circulos orcPneu2) {
        this.orcPneu2 = orcPneu2;
    }

    public Circulos getStatusOrc2() {
        return statusOrc2;
    }

    public void setStatusOrc2(Circulos statusOrc2) {
        this.statusOrc2 = statusOrc2;
    }

    public String getStatusCliente2() {
        return statusCliente2;
    }

    public void setStatusCliente2(String statusCliente2) {
        this.statusCliente2 = statusCliente2;
    }
*/
}

