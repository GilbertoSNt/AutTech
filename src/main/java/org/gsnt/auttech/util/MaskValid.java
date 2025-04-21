package org.gsnt.auttech.util;

import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.InputMismatchException;

public class MaskValid {

    private TextField textField;
    private DatePicker datePicker;

    public MaskValid(){}

    public MaskValid(TextField textField){
        this.textField = textField;
    }

    public MaskValid(DatePicker datePicker){
        this.datePicker = datePicker;
    }

    public void maskTel9Dig(TextField textField) {

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            private int a = 1;
            private int b = 0;
            private String delta1 = "(";
            @Override
            public void handle(KeyEvent event) {

                if ("0123456789".contains(event.getCharacter())&& a<=13){

                    a++;
                    delta1 = delta1+event.getCharacter();

                    switch (a) {
                        case 1:
                            delta1 = delta1+"(";
                            a++;
                            break;
                        case 3:
                            delta1 = delta1+")";
                            a++;
                            break;
                        case 9:
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

    public void maskTel8Dig(TextField textField) {

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            private int a = 1;
            private int b = 0;
            private String delta1 = "(";
            @Override
            public void handle(KeyEvent event) {

                if ("0123456789".contains(event.getCharacter())&& a<=12){

                    a++;
                    delta1 = delta1+event.getCharacter();

                    switch (a) {
                        case 1:
                            delta1 = delta1+"(";
                            a++;
                            break;
                        case 3:
                            delta1 = delta1+")";
                            a++;
                            break;
                        case 9:
                            delta1 = delta1+"-";
                            a++;
                            break;
                        default:
                            break;
                    }

                } else if("\b".contains(event.getCharacter()) && textField.getLength() >= 0){

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

    public void maskCNPJ(TextField textField){

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            private int a = 1;
            private int b = 0;
            private String delta1 = "";
            @Override
            public void handle(KeyEvent event) {

                if ("0123456789".contains(event.getCharacter())&& a<=18){

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

    public void maskkCEP(TextField textField){

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {

            private int a = 1;
            private int b = 0;
            private String delta = "";
            @Override
            public void handle(KeyEvent event) {

                if ("0123456789".contains(event.getCharacter())&& a<=10){

                    a++;
                    delta = delta+event.getCharacter();

                    switch (a) {
                        case 3:
                            delta = delta+".";
                            a++;
                            break;
                        case 7:
                            delta = delta+"-";
                            a++;
                            break;
                        default:
                            break;
                    }
                    //    txtCep.positionCaret(delta.length());
                } else if("\b".contains(event.getCharacter())&& textField.getLength() >= 0){

                    delta = textField.getText();
                    b=delta.length();
                    delta = delta.substring(0,b);
                    a=b+1;

                }else{
                    event.consume();
                }
                textField.setText(delta);
                textField.positionCaret(delta.length());
            }
        });

    }

    public void maskData(DatePicker datePicker){

        datePicker.getEditor().setOnKeyTyped((KeyEvent evento) -> {

            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (datePicker.getEditor().getText().length()) {
                    case 2:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 1));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                    case 5:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 4));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                }
            } else if (datePicker.getEditor().getText().length() == 10) {
                evento.consume();
            }
            switch (datePicker.getEditor().getText().length()) {
                case 2:
                    datePicker.getEditor().setText(datePicker.getEditor().getText() + "/");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
                case 5:
                    datePicker.getEditor().setText(datePicker.getEditor().getText() + "/");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
            }

        });

    }

    public void maskCPF(TextField textField){

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            private int a = 1;
            private int b = 0;
            private String delta1 = "";
            @Override
            public void handle(KeyEvent event) {

                if ("0123456789".contains(event.getCharacter())&& a<=14){

                    a++;
                    delta1 = delta1+event.getCharacter();

                    switch (a) {
                        case 4:
                            delta1 = delta1+".";
                            a++;
                            break;
                        case 8:
                            delta1 = delta1+".";
                            a++;
                            break;
                        case 12:
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


    public void maskHora(TextField textField){

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {

            private int a = 1;
            private int b = 0;
            private String delta = "";
            @Override
            public void handle(KeyEvent event) {

                if ("0123456789".contains(event.getCharacter())&& a<=5){

                    a++;
                    delta = delta+event.getCharacter();

                    switch (a) {
                        case 3:
                            delta = delta+":";
                            a++;
                            break;
                        default:
                            break;
                    }

                } else if("\b".contains(event.getCharacter())&& textField.getLength() >= 0){

                    delta = textField.getText();
                    b=delta.length();
                    delta = delta.substring(0,b);
                    a=b+1;

                }else{
                    event.consume();
                }
                textField.setText(delta);
                textField.positionCaret(delta.length());
            }
        });

    }


    public Boolean isCPF(String CPF){

        CPF = CPF.replaceAll("\\D","");
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try{

        sm = 0;
        peso = 10;

        for(i=0;i<9;i++){
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);

        } catch (InputMismatchException erro) {

            return(false);

        }

    }


    public boolean isCNPJ(String CNPJ){

        CNPJ = CNPJ.replaceAll("\\D","");
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
                CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
                CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
                CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
                CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
                (CNPJ.length() != 14))
            return(false);

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
        }

    }

    public void maskPlaca(TextField textField){

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            private int a = 1;
            private int b = 0;
            private String delta1 = "";
            @Override
            public void handle(KeyEvent event) {

                if ("0123456789".contains(event.getCharacter()) && a <= 3) {
                    event.consume();
                }else if(a <= 2) {
                    a++;
                    delta1 = delta1 + event.getCharacter().toUpperCase();
                }else if(a == 3) {
                    delta1 = delta1 + event.getCharacter().toUpperCase();
                    a++;
                    delta1 = delta1 + "-";
                    a++;
                }else if (a == 4) {
                    delta1 = delta1 + "-";
                    a++;
                }else if (a == 5 && "0123456789".contains(event.getCharacter())) {
                    delta1 = delta1 + event.getCharacter().toUpperCase();
                    a++;
                } else if(a==6  && "0123456789".contains(event.getCharacter())){
                    delta1 = delta1 + event.getCharacter();
                    a++;
                }else if(a==6  && !"0123456789".contains(event.getCharacter())){
                    delta1 = delta1 + event.getCharacter().toUpperCase();
                    a++;
                }else if(a==7  && "0123456789".contains(event.getCharacter())){
                    delta1 = delta1 + event.getCharacter().toUpperCase();
                    a++;
                }else if(a==7  && !"0123456789".contains(event.getCharacter())){
                    event.consume();
                }else if(a==8  && "0123456789".contains(event.getCharacter())){
                    delta1 = delta1 + event.getCharacter().toUpperCase();
                    a++;
                }else if(a==8  && !"0123456789".contains(event.getCharacter())){
                    event.consume();
                }

                if("\b".contains(event.getCharacter()) && textField.getLength() >= 0 && b>=0){

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






