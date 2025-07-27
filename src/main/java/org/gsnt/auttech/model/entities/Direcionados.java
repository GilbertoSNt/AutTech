package org.gsnt.auttech.model.entities;

public class Direcionados {

    private Integer cod;
    private Integer funcionario;
    private String apelido;
    private String placa;
    private String tmpPrvst; //tempo Previsto
    private Integer rdmTndmnt; //ordem atendimento
    private Integer qtdtndmnt; //quantidade atendimento


    public Direcionados(String apelido, Integer qtdtndmnt) {

        this.apelido = apelido;
        this.qtdtndmnt = qtdtndmnt;

    }

    public Direcionados(String placa, String tmpPrvst, Integer rdmTndmnt) {

        this.placa = placa;
        this.tmpPrvst = tmpPrvst;
        this.rdmTndmnt = rdmTndmnt;

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

    public String getTmpPrvst() {
        return tmpPrvst;
    }

    public void setTmpPrvst(String tmpPrvst) {
        this.tmpPrvst = tmpPrvst;
    }

    public Integer getRdmTndmnt() {
        return rdmTndmnt;
    }

    public void setRdmTndmnt(Integer rdmTndmnt) {
        this.rdmTndmnt = rdmTndmnt;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Integer getQtdtndmnt() {
        return qtdtndmnt;
    }

    public void setQtdtndmnt(Integer qtdtndmnt) {
        this.qtdtndmnt = qtdtndmnt;
    }
}
