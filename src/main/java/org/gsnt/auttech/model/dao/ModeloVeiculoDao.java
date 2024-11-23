package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.ModeloVeiculo;

import java.util.List;

public interface ModeloVeiculoDao {

    ModeloVeiculo findById(Integer id);
    List<ModeloVeiculo> findAll();
    List<ModeloVeiculo> findByIdMarca(Integer id);

}
