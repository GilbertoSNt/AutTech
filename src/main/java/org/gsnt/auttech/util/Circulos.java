package org.gsnt.auttech.util;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.awt.*;

public class Circulos extends Circle{

    public Circulos(){}

    public Circulos(String cor, String cor1){

    //    setCenterX(5);
    //    setCenterY(25);
        setRadius(5);
        setFill(Paint.valueOf(cor));
        setStrokeWidth(3);
        setStroke(Paint.valueOf(cor1));

    }

    public Circulos(String cor){

        //    setCenterX(5);
        //    setCenterY(25);
        setRadius(5);
        setFill(Paint.valueOf(cor));
        setStrokeWidth(3);
        setStroke(Paint.valueOf(cor));

    }

    public Circulos stItemOrcamento(byte a){

        Circulos c = null;

        switch (a){
            case 0:
                break;
            case 1:
                c = new Circulos("f9d428");
                break;
            case 2:
                c = new Circulos("f9d428","70c3a7");
                break;
            case 3:
                c = new Circulos("70c3a7","f9d428");
                break;
        }

        return c;
    }

    public Circulos stGeralAtendimento(byte a){

        Circulos status = null;

        switch (a){
            case 0:
                break;
            case 1:
                status = new Circulos("f50505");//amarelo total
                break;
            case 2:
                status = new Circulos("f9d428","f50505");// inteno amarelo - externo verde
                break;
            case 3:
                status = new Circulos("f9d428","f9d428");
                break;
            case 4:
                status = new Circulos("7c2d91");
                break;
            case 5:
                status = new Circulos("70c3a7","7c2d9");
                break;
            case 6:
                status = new Circulos("3f676d");
                break;
            case 7:
                status = new Circulos("f50505");
                break;
            case 8:
                status = new Circulos("54d6f0");
                break;
            case 9:
                status = new Circulos("70c3a7");
                break;
            case 10:
                status = new Circulos("3f676d");
                break;
            case 11:
                status = new Circulos("f9d428");
                break;
            case 12:
                status = new Circulos("f9d428","70c3a7");
                break;
            case 13:
                status = new Circulos("7c2d91");
                break;
            case 14:
                status = new Circulos("70c3a7");
                break;
        }

        return status;

    }
}
