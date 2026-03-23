package org.gsnt.auttech.marca;

import java.util.List;

public interface MarcaVeiculoDao {

    List<MarcaVeiculo> findAll();
    Integer findIdByMarca(String nomemarca);
    String findMarcaById(Integer cod);

}
