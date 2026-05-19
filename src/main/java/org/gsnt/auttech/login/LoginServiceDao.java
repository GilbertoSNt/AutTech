package org.gsnt.auttech.login;

import java.util.List;

public interface LoginServiceDao {

    List<LogUser> listaUsuario(String codigo);
    Boolean ver(String codigo);

}
