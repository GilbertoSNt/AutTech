package org.gsnt.auttech.util;

import javafx.scene.control.Button;

public class Botoes extends Button {

    public Botoes(String cor){
        setStyle(    "-fx-background-color:" +cor+";"+
                "-fx-background-radius:15;");
        setPrefSize(45,14);
        setMinSize(45,14);
        setMaxSize(45,14);


    }
/*
    public Button botoesAgenda(String cor){
        Button t = new Button(cor);
        t.setStyle(    "-fx-background-color:" +cor+";"+
                "-fx-background-radius:15;");
        t.setPrefSize(14,14);
        t.setMinSize(14,14);
        t.setMaxSize(15,14);
        return t;
    }
*/
}
