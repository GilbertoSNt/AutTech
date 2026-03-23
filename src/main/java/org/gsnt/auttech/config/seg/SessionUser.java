package org.gsnt.auttech.config.seg;

public class SessionUser {

    private static String id = "";//Nome(id Usuário)
    private static Integer tt = 0;//tentativas

    private CrypService Crip = new CrypService();


    public static boolean verificaSenha(String senha, String hashSalvo, String nome) {

        boolean a = false;
        a =
        if (a) {
            setId(nome);
            return a;
        }else {
            return a;
        }

    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        SessionUser.id = id;
    }





}