package org.gsnt.auttech.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class EnvioSMS {

    private String comando = "C:\\pen\\OfProg\\AutTech\\logSMS.txt";

    public void envioSMS(String user, String telefone,String txt){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(comando, true))){
            bw.newLine();
            bw.write(LocalDate.now() +" - "+ LocalTime.now() +" - "+user+" - "+telefone+" - "+txt);
        } catch (IOException e) {
            System.out.println(e.getMessage()+" - EnvioSMS");
            throw new RuntimeException(e);
        }
    }

}
