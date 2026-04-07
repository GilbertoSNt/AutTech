package org.gsnt.auttech.telefone;

public enum TpTelefonePf {

    CELULAR(0),
    RESIDÊNCIAL(1),
    TRABALHO(2),
    ESPOSA(3),
    FILHO(4),
    PARENTE(5);

    private final int codigo;

    TpTelefonePf(int i) {
        this.codigo = i;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        // Capitaliza só a primeira letra
        String nome = this.name();
        return nome.charAt(0) + nome.substring(1).toLowerCase();
    }

}
