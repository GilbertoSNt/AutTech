package org.gsnt.auttech.usuario.user;

import org.gsnt.auttech.funcionario.Funcionario;

import java.util.List;

public interface SessionUserDao {

    List<Funcionario> findAllLog();
    String nomeEmpresa();
    Boolean loginSistema(String nome, String senha);
    void logoffSistema(String nome);
    Boolean verificaEmpresa(String empresa);
}
