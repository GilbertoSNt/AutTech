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

}
