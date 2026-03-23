package org.gsnt.auttech.endereco;

public interface EnderecoDao {


    Endereco findByCasoCod(int caso, int codRegistro);
    void saveEndereco(Endereco endereco);
    void alterEndereco(int codRegistro, Endereco endereco);


}
