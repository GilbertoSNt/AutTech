package org.gsnt.auttech.model.entities;


import java.io.Serializable;

public class Endereco implements Serializable {

    /*
    * Tipo caso
    * 1 - Cliente
    * 2 - Fornecedor
    * 3 - Funcionarios
    */

    public Endereco(){};

    private int cod;
    private int tipoCaso;
    private int tipoEnd;
    private String endereco;
    private String numero;
    private String bairro;
    private String Cidade;
    private int estado;
    private String complemento;
    private String cep;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getTipoEnd() {
        return tipoEnd;
    }

    public void setTipoEnd(int tipoEnd) {
        this.tipoEnd = tipoEnd;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getTipoCaso() {
        return tipoCaso;
    }

    public void setTipoCaso(int tipoCaso) {
        this.tipoCaso = tipoCaso;
    }
}
