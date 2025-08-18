package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Funcionario;

import java.util.List;

public interface LoginDAO {

    List<Funcionario> findAllLog();
    String nomeEmpresa();
    void verLog(String nome, String senha);

}
