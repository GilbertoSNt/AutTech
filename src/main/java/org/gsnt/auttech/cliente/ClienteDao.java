package org.gsnt.auttech.cliente;

import org.gsnt.auttech.email.Email;
import org.gsnt.auttech.endereco.Endereco;
import org.gsnt.auttech.telefone.Telefone;

import java.util.List;

public interface ClienteDao {

    //Select
    List<Cliente> findAll();//implementado mas não testado
    List<Cliente> findAllTest();
    List<Cliente> findAllPart(String part);//implementado mas não testado
    Cliente findByCPF(String CPF);
    Cliente findByCNPJ(String CNPJ);
    Cliente findById(int id);
    List<Email> findEmailById(int id);
    Endereco findEndById(int id);
    List<Telefone> findTelById(int id);

    //Insert
    int saveCliente(Cliente cliente);//implementado mas não testado
    Boolean emailCliente(List<Email> email, int cod);
    Boolean endCliente(Endereco endereco, int cod);
    Boolean telCliente(List<Telefone> telefone, int cod);

    //Save
    Boolean saveAlterCliente(String CPF);
    Boolean emailAlterCliente(List<Email> email);
    Boolean endAlterCliente(Endereco endereco);
    Boolean telAlterCliente(List<Telefone> telefone);

    //Desativação, exclusão
    Boolean DesativaCliente(String CPF);
    Boolean excluiEmailCliente(Email email);
    Boolean excluirTelCliente(Telefone telefone);

    //Associações
    void associacaoVeicCliente(int codVeic, int codCliente);
    int findIdClienteByIdVeiculo(int codVeic);

}
