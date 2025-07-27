package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.entitiesgenerics.ModeloVeiculo;

import java.util.List;

public interface ModeloVeiculoDao {

    ModeloVeiculo findById(int id);
    List<ModeloVeiculo> findByIdMarca(int id);
    Integer findIdByModelo(String modelo);
    String findModeloById(Integer cod);
}
