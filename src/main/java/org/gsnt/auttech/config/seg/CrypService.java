package org.gsnt.auttech.config.seg;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class CrypService implements CrypDao {

    private static final Argon2 argon2 = Argon2Factory.create(
            Argon2Factory.Argon2Types.ARGON2id);
    private static final int ITERATIONS = 3;
    private static final int MEMORI = 65536;
    private static final int PARALLELISM = 1;

    public static String hashSenha(String senha) {
        return argon2.hash(ITERATIONS, MEMORI, PARALLELISM, senha.toCharArray() + "gs");
    }

    @Override
    public boolean verifica(String senhaSalva) {
        return false;
    }
}
