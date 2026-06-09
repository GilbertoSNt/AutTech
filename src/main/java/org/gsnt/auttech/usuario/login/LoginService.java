package org.gsnt.auttech.usuario.login;

import java.sql.Connection;
import java.util.List;

public class LoginService implements LoginServiceDao{

    private Connection conn;

    public LoginService(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<LogUser> listaUsuario(String codigo) {




        return null;
    }

    @Override
    public Boolean ver(String codigo) {
        return null;
    }
}
