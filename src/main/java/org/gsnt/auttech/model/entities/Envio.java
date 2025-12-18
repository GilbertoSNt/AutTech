package org.gsnt.auttech.model.entities;

public class Envio {

    private String user;
    private String telefone;
    private String mensagem;
    private String placa;
    private String veiculo;
    private String obs;
    private Boolean confirmacao;

    public Envio(String obs, String veiculo, String placa, String mensagem, String telefone, String user) {
        this.obs = obs;
        this.veiculo = veiculo;
        this.placa = placa;
        this.mensagem = mensagem;
        this.telefone = telefone;
        this.user = user;
    }

    public Envio(String user, String placa, Boolean confirmacao) {
        this.user = user;
        this.placa = placa;
        this.confirmacao = confirmacao;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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

    public Boolean getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(Boolean confirmacao) {
        this.confirmacao = confirmacao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
