package org.gsnt.auttech.usuario.login;

import java.util.List;

public interface LoginServiceDao {

    List<LogUser> listaUsuario(String codigo);
    Boolean ver(String codigo);

}
