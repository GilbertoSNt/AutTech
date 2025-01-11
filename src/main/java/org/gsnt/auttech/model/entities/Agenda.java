package org.gsnt.auttech.model.entities;

import java.util.Date;

public class Agenda {

    private Date data;
    private Date hora;
    private String nome;
    private String Veiculo;
    private String placa;
    private Boolean serMecanico;
    private Boolean serEletrivo;
    private Boolean guincho;
    private Boolean buscar;
    private Boolean socorro;
    private String status;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVeiculo() {
        return Veiculo;
    }

    public void setVeiculo(String veiculo) {
        Veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Boolean getSerMecanico() {
        return serMecanico;
    }

    public void setSerMecanico(Boolean serMecanico) {
        this.serMecanico = serMecanico;
    }

    public Boolean getSerEletrivo() {
        return serEletrivo;
    }

    public void setSerEletrivo(Boolean serEletrivo) {
        this.serEletrivo = serEletrivo;
    }

    public Boolean getGuincho() {
        return guincho;
    }

    public void setGuincho(Boolean guincho) {
        this.guincho = guincho;
    }

    public Boolean getBuscar() {
        return buscar;
    }

    public void setBuscar(Boolean buscar) {
        this.buscar = buscar;
    }

    public Boolean getSocorro() {
        return socorro;
    }

    public void setSocorro(Boolean socorro) {
        this.socorro = socorro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
