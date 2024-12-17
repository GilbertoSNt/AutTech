package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.model.entities.EmailCliente;
import org.gsnt.auttech.model.entities.EndCliente;
import org.gsnt.auttech.model.entities.TelCliente;

import java.util.List;

public interface ClienteDao {

    //Select
    List<Cliente> findAll();//implementado mas não testado
    List<Cliente> findAllPart(String part);//implementado mas não testado
    Cliente findByCPF(String CPF);
    Cliente findByCNPJ(String CNPJ);
    List<EmailCliente> findEmailById(int id);
    EndCliente findEndById(int id);
    List<TelCliente> findTelById(int id);

    //Insert
    int saveCliente(Cliente cliente);//implementado mas não testado
    Boolean emailCliente(List<EmailCliente> email, int cod);
    Boolean endCliente(EndCliente endereco, int cod);
    Boolean telCliente(List<TelCliente> telefone, int cod);

    //Save
    Boolean saveAlterCliente(String CPF);
    Boolean emailAlterCliente(List<EmailCliente> email);
    Boolean endAlterCliente(EndCliente endereco);
    Boolean telAlterCliente(List<TelCliente> telefone);

    //Desativação, exclusão
    Boolean DesativaCliente(String CPF);
    Boolean excluiEmailCliente(EmailCliente email);
    Boolean excluirTelCliente(TelCliente telefone);

}
