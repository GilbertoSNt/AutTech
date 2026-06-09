package org.gsnt.auttech.usuario.login;

public class LogUser {

    private Boolean aceito;
    private String user;
    private String unidade;

    public LogUser(String unidade){
        this.unidade = unidade;
    }

    public LogUser(Boolean aceito, String user){
        this.aceito = aceito;
        this.user = user;
    }


    public Boolean getAceito() {
        return aceito;
    }

    public void setAceito(Boolean aceito) {
        this.aceito = aceito;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
