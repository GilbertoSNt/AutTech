package org.gsnt.auttech.config.seg;

public interface CrypDao {

    String hashSenha(String senha);
    boolean verifica (String senhaSalva);
}
