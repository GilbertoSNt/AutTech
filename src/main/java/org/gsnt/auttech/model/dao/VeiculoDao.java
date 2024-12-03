package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Veículo;

import java.util.List;

public interface VeiculoDao {

    List<Veículo> findAll();
    Veículo findById(String placa);

    Boolean saveVeiculo(Veículo veiculo);

    Boolean desativaPLaca(String placa);

    Boolean editPLaca(Veículo veiculo);

    Boolean desassociaPLaca(String placa);

}
