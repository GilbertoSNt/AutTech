package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.entitiesgenerics.Endereco;

public interface EnderecoDao {


    Endereco findByCasoCod(int caso, int codRegistro);
    void saveEndereco(Endereco endereco);
    void alterEndereco(int codRegistro, Endereco endereco);


}
