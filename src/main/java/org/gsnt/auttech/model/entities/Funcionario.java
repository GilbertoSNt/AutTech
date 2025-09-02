package org.gsnt.auttech.model.entities;

import java.util.Date;

public class Funcionario {

    /*
    * Tipo funcionário
    *
    * 1 - Administrativo
    * 2 - Administrativo(auxiliar)
    * 3 - produtivo
    * 4 - Proditivo(Auxiliar)
    * 5 - Aprendiz
    *
    * TipoCaso
    *
    * 3 - Funcionário
    *
    * */

    private Integer cod;
    private String nome;
    private String apelido;
    private String cpf;
    private String rg;
    private String dataNasc;
    private Boolean status;
    private Boolean genero;
    private Integer tipoFunc;
    private String telefone;
    private String telConjuge;
    private String mae;
    private String pai;
    private String conjuge;
    private Integer qtdFilhos;
    private String obs;
    private String dataAdm;
    private String dataDesl;
    private String cartProfissional;
    private String dataemissao;
    private String cargo;
    private String funcao;
    private String comissaoPecas;
    private String comissaoServicos;
    private String salario;
    private Boolean comissao;
    private String obsProf;
    private Boolean caixaMec;
    private Boolean caixaAut;
    private Boolean eletrica;
    private Boolean trocaOleo;
    private Boolean freio;
    private Boolean injDiesel;
    private Boolean injFlex;
    private Boolean motorDiesel;
    private Boolean motorFlex;
    private Boolean pneus;
    private Boolean suspensao;
    private Boolean socorro;
    private Boolean veicEletricos;
    private Boolean motLeva;
    private Boolean motguincho;

    public Funcionario(){}

    public Funcionario(Integer cod, String apelido){
        this.cod = cod;
        this.apelido = apelido;
    }

    public Funcionario(Integer cod, String apelido, Boolean caixaMec, Boolean caixaAut, Boolean eletrica,
                       Boolean freio, Boolean injDiesel, Boolean injFlex, Boolean motorDiesel, Boolean motorFlex,
                       Boolean pneus, Boolean suspensao, Boolean socorro, Boolean veicEletricos, Boolean motLeva,
                       Boolean motguincho, Boolean trocaOleo) {
        this.cod = cod;
        this.apelido = apelido;
        this.caixaMec = caixaMec;
        this.caixaAut = caixaAut;
        this.eletrica = eletrica;
        this.freio = freio;
        this.injDiesel = injDiesel;
        this.injFlex = injFlex;
        this.motorDiesel = motorDiesel;
        this.motorFlex = motorFlex;
        this.pneus = pneus;
        this.suspensao = suspensao;
        this.socorro = socorro;
        this.veicEletricos = veicEletricos;
        this.motLeva = motLeva;
        this.motguincho = motguincho;
        this.trocaOleo = trocaOleo;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Boolean getGenero() {
        return genero;
    }

    public void setGenero(Boolean genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public int getQtdFilhos() {
        return qtdFilhos;
    }

    public void setQtdFilhos(int qtdFilhos) {
        this.qtdFilhos = qtdFilhos;
    }

    public String getTelConjuge() {
        return telConjuge;
    }

    public void setTelConjuge(String telConjuge) {
        this.telConjuge = telConjuge;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getDataAdm() {
        return dataAdm;
    }

    public void setDataAdm(String dataAdm) {
        this.dataAdm = dataAdm;
    }

    public String getDataDesl() {
        return dataDesl;
    }

    public void setDataDesl(String dataDesl) {
        this.dataDesl = dataDesl;
    }

    public int getTipoFunc() {
        return tipoFunc;
    }

    public void setTipoFunc(int tipoFunc) {
        this.tipoFunc = tipoFunc;
    }

    public String getCartProfissional() {
        return cartProfissional;
    }

    public void setCartProfissional(String cartProfissional) {
        this.cartProfissional = cartProfissional;
    }

    public String getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(String dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getComissaoPecas() {
        return comissaoPecas;
    }

    public void setComissaoPecas(String comissaoPecas) {
        this.comissaoPecas = comissaoPecas;
    }

    public String getComissaoServicos() {
        return comissaoServicos;
    }

    public void setComissaoServicos(String comissaoServicos) {
        this.comissaoServicos = comissaoServicos;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Boolean getComissao() {
        return comissao;
    }

    public void setComissao(Boolean comissao) {
        this.comissao = comissao;
    }

    public String getObsProf() {
        return obsProf;
    }

    public void setObsProf(String obsProf) {
        this.obsProf = obsProf;
    }

    public Boolean getCaixaMec() {
        return caixaMec;
    }

    public void setCaixaMec(Boolean caixaMec) {
        this.caixaMec = caixaMec;
    }

    public Boolean getCaixaAut() {
        return caixaAut;
    }

    public void setCaixaAut(Boolean caixaAut) {
        this.caixaAut = caixaAut;
    }

    public Boolean getEletrica() {
        return eletrica;
    }

    public void setEletrica(Boolean eletrica) {
        this.eletrica = eletrica;
    }

    public Boolean getFreio() {
        return freio;
    }

    public void setFreio(Boolean freio) {
        this.freio = freio;
    }

    public Boolean getInjDiesel() {
        return injDiesel;
    }

    public void setInjDiesel(Boolean injDiesel) {
        this.injDiesel = injDiesel;
    }

    public Boolean getInjFlex() {
        return injFlex;
    }

    public void setInjFlex(Boolean injFlex) {
        this.injFlex = injFlex;
    }

    public Boolean getMotorDiesel() {
        return motorDiesel;
    }

    public void setMotorDiesel(Boolean motorDiesel) {
        this.motorDiesel = motorDiesel;
    }

    public Boolean getMotorFlex() {
        return motorFlex;
    }

    public void setMotorFlex(Boolean motorFlex) {
        this.motorFlex = motorFlex;
    }

    public Boolean getPneus() {
        return pneus;
    }

    public void setPneus(Boolean pneus) {
        this.pneus = pneus;
    }

    public Boolean getSuspensao() {
        return suspensao;
    }

    public void setSuspensao(Boolean suspensao) {
        this.suspensao = suspensao;
    }

    public Boolean getSocorro() {
        return socorro;
    }

    public void setSocorro(Boolean socorro) {
        this.socorro = socorro;
    }

    public Boolean getVeicEletricos() {
        return veicEletricos;
    }

    public void setVeicEletricos(Boolean veicEletricos) {
        this.veicEletricos = veicEletricos;
    }

    public Boolean getMotLeva() {
        return motLeva;
    }

    public void setMotLeva(Boolean motLeva) {
        this.motLeva = motLeva;
    }

    public Boolean getMotguincho() {
        return motguincho;
    }

    public void setMotguincho(Boolean motguincho) {
        this.motguincho = motguincho;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getTrocaOleo() {
        return trocaOleo;
    }

    public void setTrocaOleo(Boolean trocaOleo) {
        this.trocaOleo = trocaOleo;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
