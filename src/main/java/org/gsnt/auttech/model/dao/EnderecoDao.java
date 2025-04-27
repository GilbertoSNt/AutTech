package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Endereco;

public interface EnderecoDao {


    Endereco findByCasoCod(int caso, int codRegistro);
    Integer saveEndereco(Endereco endereco);
    void desativaEndereco(int codRegistro);
    void alterEndereco(int codRegistro, Endereco endereco);


}
