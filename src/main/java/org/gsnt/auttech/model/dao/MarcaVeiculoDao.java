package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.entitiesgenerics.MarcaVeiculo;

import java.util.List;

public interface MarcaVeiculoDao {

    List<MarcaVeiculo> findAll();
    Integer findIdByMarca(String nomemarca);
    String findMarcaById(Integer cod);

}
