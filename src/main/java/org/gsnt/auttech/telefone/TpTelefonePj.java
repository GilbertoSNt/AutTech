package org.gsnt.auttech.telefone;

public enum TpTelefonePj {

    EMPRESA(0),
    GERENTE(1),
    ORÇAMENTO(2),
    CONDUTOR(3),
    RESPONSÁVEL(4),
    FINANCEIRO(5);

    private final int codigo;

    TpTelefonePj(int i) {
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
