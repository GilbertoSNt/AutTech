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
}
