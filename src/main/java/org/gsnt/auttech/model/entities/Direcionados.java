package org.gsnt.auttech.model.entities;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class Direcionados {

    private Integer cod;
    private Integer funcionario;
    private String placa;
    private Date dataPrevista;
    private Time horaPrevista;

    public Direcionados(Integer cod, Integer funcionario, String placa, Date dataPrevista, Time horaPrevista) {
        this.cod = cod;
        this.funcionario = funcionario;
        this.placa = placa;
        this.dataPrevista = dataPrevista;
        this.horaPrevista = horaPrevista;
    }

    public Direcionados(Integer funcionario, String placa, Date dataPrevista, Time horaPrevista) {
        this.funcionario = funcionario;
        this.placa = placa;
        this.dataPrevista = dataPrevista;
        this.horaPrevista = horaPrevista;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Integer funcionario) {
        this.funcionario = funcionario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Time getHoraPrevista() {
        return horaPrevista;
    }

    public void setHoraPrevista(Time horaPrevista) {
        this.horaPrevista = horaPrevista;
    }
}
