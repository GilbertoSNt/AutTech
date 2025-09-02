package org.gsnt.auttech.util;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.awt.*;

public class Circulos extends Circle{

    public Circulos(){}

    public Circulos(String cor, String cor1){

        setRadius(5);
        setFill(Paint.valueOf(cor));
        setStrokeWidth(3);
        setStroke(Paint.valueOf(cor1));

    }

    public Circulos(String cor){

        setRadius(5);
        setFill(Paint.valueOf(cor));
        setStrokeWidth(3);
        setStroke(Paint.valueOf(cor));

    }

    //veículos a serem iniciados

    public Circulos circ1() {

        //Total vermelho
        //veículos a serem iniciados - Serviço sem direcionameto
        //Veículos em serviço - Tudo disp. veículo com cliente
        return new Circulos("f50505");
    }

    public Circulos circ2() {
        //inteno amarelo / externo vermelho - Direcionamento sem confirmação
        return new Circulos("f9d428", "f50505");
    }

    public Circulos circ3() {
        //Total amarelo - OS aceita com  orç. pendente
        //Veículo em orçamento - Aguardando profissional
        return new Circulos("f9d428");
    }

    public Circulos circ4() {
        //Total purpura - Orçamento aguardando liberação
        return new Circulos("7c2d91");
    }

    public Circulos circ5() {
        //int. purpura / ext. verde - Orç. liberado aguardando peças
        return new Circulos("7c2d91","70c3a7");
    }

    public Circulos circ6() {
        //total verde escuro - Orçamento lib. aguard. cliente
        return new Circulos("3f676d");
    }

    //Veículos em serviço

    // caso 7 - circ1 - Tudo disp. veículo com cliente

    public Circulos circ8() {
        //Total azul claro - Não iniciado
        return new Circulos("54d6f0");
    }

    public Circulos circ9() {
        //Total verde claro - Em produção - iniciado
        return new Circulos("70c3a7");
    }

    public Circulos circ10() {
        //Total verde escuro - pronto
        return new Circulos("3f676d");
    }

    // em orçamento

    // caso 11 - totalmente amarelo circ3 - Aguardando profissional

    public Circulos circ12() {
        //int. amarelo / est. verde - Orçamento em preparação
        return new Circulos("f9d428", "70c3a7");
    }

    public Circulos circ13() {
        //total verde padrão - Montagem do orçamento encerrada
        return new Circulos("70c3a7");
    }

    public Circulos circ14() {
        //total rosa - Não enviado ao cliente
        return new Circulos("f59097");
    }

    //caso 15 - circ4 - total purpura - Aguardando liberação do orçamento

    public Circulos circ16() {
        //total bege - liberação parcial
        return new Circulos("e3c9a2");
    }

    public Circulos circ17() {
        //total ciano - Liberado total
        return new Circulos("86fdff");
    }

    public Circulos circ18() {
        //total preto - recusado
        return new Circulos("86fdff");
    }


}
