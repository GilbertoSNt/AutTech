package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.ModeloVeiculo;

import java.util.List;

public interface ModeloVeiculoDao {

    ModeloVeiculo findById(int id);
    List<ModeloVeiculo> findByIdMarca(int id);

}
