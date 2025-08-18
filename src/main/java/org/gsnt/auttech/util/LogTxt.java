package org.gsnt.auttech.util;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;


public class LogTxt {

    private final String comando = "C:\\pen\\OfProg\\AutTech\\logcomando.txt";
    private final String erro = "C:\\pen\\OfProg\\AutTech\\logerro.txt";

    public void escreveLog(String user, String txtLog){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(comando, true))){
            bw.newLine();
            bw.write(LocalDate.now() +" - "+ LocalTime.now() +" - "+user+" - "+txtLog);
        } catch (IOException e) {
            throw new ExceptionGenerics("Erro no LogTXT - escreveLog "+e.getMessage());
        }
    }

    public void escreveErro(String txtErro){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(erro, true))){
            bw.newLine();
            bw.write(LocalDate.now() +" - "+ LocalTime.now() +" - "+txtErro);
        } catch (IOException e) {
            throw new ExceptionGenerics("Erro no LogTXT - escreveErro "+e.getMessage());
        }
    }
}
