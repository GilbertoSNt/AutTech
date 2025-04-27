package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.model.dao.EnderecoDao;
import org.gsnt.auttech.model.entities.Endereco;

public class EnderecoService implements EnderecoDao {

    @Override
    public Endereco findByCasoCod(int caso, int codRegistro) {
        return null;
    }

    @Override
    public Integer saveEndereco(Endereco endereco) {
        return 0;
    }

    @Override
    public void desativaEndereco(int codRegistro) {

    }

    @Override
    public void alterEndereco(int codRegistro, Endereco endereco) {

    }
}
