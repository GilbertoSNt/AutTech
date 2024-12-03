package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.model.entities.EmailCliente;
import org.gsnt.auttech.model.entities.EndCliente;
import org.gsnt.auttech.model.entities.TelCliente;

import java.util.List;

public interface ClienteDao {

    List<Cliente> findAll();
    Cliente findByCPF(String CPF);
    List<EmailCliente> findEmailById(int id);
    EndCliente findEndById(int id);
    List<TelCliente> findTelById(int id);

    Boolean saveCliente(Cliente cliente);
    Boolean emailCliente(List<EmailCliente> email);
    Boolean endCliente(EndCliente endereco);
    Boolean telCliente(List<TelCliente> telefone);

    Boolean saveAlterCliente(String CPF);
    Boolean emailAlterCliente(List<EmailCliente> email);
    Boolean endAlterCliente(EndCliente endereco);
    Boolean telAlterCliente(List<TelCliente> telefone);

    Boolean DesativaCliente(String CPF);
    Boolean excluiEmailCliente(EmailCliente email);
    Boolean excluirTelCliente(TelCliente telefone);

}
