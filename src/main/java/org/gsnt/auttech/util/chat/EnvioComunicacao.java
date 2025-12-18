package org.gsnt.auttech.util.chat;

import org.gsnt.auttech.model.entities.Envio;

import java.util.List;

public interface EnvioComunicacao {

    void registroSMS(List<Envio> envio);

}
