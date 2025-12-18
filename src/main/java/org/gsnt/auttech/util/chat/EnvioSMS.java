package org.gsnt.auttech.util.chat;

import org.gsnt.auttech.model.entities.Envio;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EnvioSMS implements EnvioComunicacao {

    private String comando = "C:\\pen\\OfProg\\AutTech\\logSMS.txt";

    @Override
    public void registroSMS(List<Envio> envio) {
        Integer a = 0;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(comando, true))){
            bw.newLine();
            bw.write(LocalDate.now() +" - "+ LocalTime.now() +" - "+envio.get(a).getUser()+" - "+
                    envio.get(a).getTelefone()+" - "+envio.get(a).getMensagem()+" - "+envio.get(a).getObs());
        } catch (IOException e) {
            System.out.println(e.getMessage()+" - EnvioSMS");
            throw new RuntimeException(e);
        }
    }

}
