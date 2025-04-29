package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.model.dao.EnderecoDao;
import org.gsnt.auttech.model.entities.Endereco;

public class EnderecoService implements EnderecoDao {


    //procura endereço pelo tipo de caso(Cliente, fornecedor, funcionário) e código registro
    @Override
    public Endereco findByCasoCod(int caso, int codRegistro) {
        return null;
    }

    //salva o endereço
    @Override
    public Integer saveEndereco(Endereco endereco) {
        return 0;
    }

    //desatia o cadastro
    @Override
    public void desativaEndereco(int codRegistro) {

    }

    //altera o endereço
    @Override
    public void alterEndereco(int codRegistro, Endereco endereco) {

    }
}
