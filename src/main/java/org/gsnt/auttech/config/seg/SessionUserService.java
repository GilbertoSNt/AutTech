package org.gsnt.auttech.config.seg;

import org.gsnt.auttech.funcionario.Funcionario;
import org.gsnt.auttech.util.LogTxt;

import java.sql.Connection;
import java.util.List;

public class SessionUserService implements SessionUserDao {

    private final Connection conn;
    private final LogTxt lg = new LogTxt();


    public SessionUserService(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Funcionario> findAllLog() {
        return List.of();
    }

    private void verLog(String nome, String senha){



    }


    @Override
    public Boolean loginSistema(String nome, String senha) {
        CrypDao cry = new CrypService();
        /*
    if (verLog(nome, cry.hashSenha(senha))) {
        lg.escreveLog(nome, "Fez login");
        SessionUser.setId(nome);
        return true;
    }else{
       return false;
          }*/
        return true;
    }


    @Override
    public void logoffSistema(String nome){
        lg.escreveLog(nome,"Fez logoff");
        SessionUser.setId("");
    }

    @Override
    public String nomeEmpresa() {
        return "";
    }

    @Override
    public Boolean verificaEmpresa(String empresa) {

        // aqui
        // aqui - implementar verificação
        // aqui

        return true;
    }
}
