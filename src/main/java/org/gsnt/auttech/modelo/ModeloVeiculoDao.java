package org.gsnt.auttech.modelo;

import java.util.List;

public interface ModeloVeiculoDao {

    ModeloVeiculo findById(int id);
    List<ModeloVeiculo> findByIdMarca(int id);
    Integer findIdByModelo(String modelo);
    String findModeloById(Integer cod);
}
