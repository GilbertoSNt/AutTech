package org.gsnt.auttech.entitiesgenerics;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class CNPJ{

    public Boolean CNPJ(String cod){
        return isCNPJ(cod);
    }

    // Letras proibidas pela Receita Federal (confusão visual com números)
    private static final String LETRAS_PROIBIDAS = "IOFQ";

    private boolean isCNPJ(String CNPJ) {

        //CNPJ = CNPJ.replaceAll("\\D","");
        CNPJ = CNPJ.replaceAll("[^A-Z0-9]", "").toUpperCase();

        if (CNPJ.length() != 14) return false;

        // Rejeita letras proibidas nas 12 primeiras posições
        for (int i = 0; i < 12; i++) {
            if (LETRAS_PROIBIDAS.indexOf(CNPJ.charAt(i)) >= 0) return false;
        }

        // Rejeita sequências repetidas (ex: 00000000000000, AAAAAAAAAAAAAA)
        if (CNPJ.matches("(.)\\1{13}")) return false;

        // Os 2 últimos dígitos verificadores DEVEM ser numéricos
        if (!Character.isDigit(CNPJ.charAt(12)) || !Character.isDigit(CNPJ.charAt(13))) return false;

        try {
            char dig13 = calcularDigito(CNPJ, 11);
            char dig14 = calcularDigito(CNPJ, 12);
            return (dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13));
        } catch (Exception e) {
            return false;
        }
    }

        /**
         * Calculo do DV usando Módulo 11 com conversão ASCII.
         * Funciona para CNPJ numérico (atual) e alfanumérico (novo).
         * Regra: valor = (char ASCII) - 48
         *   → '0'=0, '1'=1 ... '9'=9 (igual ao cálculo atual)
         *   → 'A'=17, 'B'=18, 'C'=19 ... (novo)
         */
        private char calcularDigito(String cnpj, int limite) {
            int sm = 0, peso = 2;
            for (int i = limite; i >= 0; i--) {
                int valor = cnpj.charAt(i) - 48; // conversão ASCII - 48
                sm += valor * peso;
                peso = (peso == 9) ? 2 : peso + 1;
            }
            int r = sm % 11;
            return (r < 2) ? '0' : (char) ((11 - r) + 48);
        }

        /*
        char dig13, dig14;
        int sm, i, r, num, peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = (int)(CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char)((11-r) + 48);

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(CNPJ.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char)((11-r) + 48);

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }*/



    public void maskCNPJ(TextField textField){

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            private int a = 1;
            private int b = 0;
            private String delta1 = "";
            @Override
            public void handle(KeyEvent event) {
                if ("(.)\\1{13}".contains(event.getCharacter())&& a<=18){
//                if ("0123456789".contains(event.getCharacter())&& a<=18){
//"(.)\\1{13}"
                    a++;
                    delta1 = delta1+event.getCharacter();

                    switch (a) {
                        case 3:
                            delta1 = delta1+".";
                            a++;
                            break;
                        case 7:
                            delta1 = delta1+".";
                            a++;
                            break;
                        case 11:
                            delta1 = delta1+"/";
                            a++;
                            break;
                        case 16:
                            delta1 = delta1+"-";
                            a++;
                            break;
                        default:
                            break;
                    }

                } else if("\b".contains(event.getCharacter())&& textField.getLength() >= 0){

                    delta1 = textField.getText();
                    b=delta1.length();
                    delta1 = delta1.substring(0,b);
                    a=b+1;

                }else{
                    event.consume();
                }
                textField.setText(delta1);
                textField.positionCaret(delta1.length());

            }
        });
    }

}
