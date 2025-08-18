package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.model.dao.LoginDAO;
import org.gsnt.auttech.model.entities.Funcionario;

import java.util.List;

public class LoginService implements LoginDAO {

    @Override
    public List<Funcionario> findAllLog() {
        return List.of();
    }

    @Override
    public String nomeEmpresa() {
        return "";
    }

    @Override
    public void verLog(String nome, String senha) {

    }
}
