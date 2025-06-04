package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Veiculo;

import java.util.List;

public interface VeiculoDao {

    List<Veiculo> findAll();

    Veiculo findById(String placa);

    Veiculo findByCod(int cod);

    Integer saveVeiculo(Veiculo veiculo);

    Boolean desativaPLaca(String placa);

    Boolean editPLaca(Veiculo veiculo);

    Boolean desassociaPLaca(String placa);

    Integer verificaPlaca(String placa);

    Veiculo verPlacaModelo(Integer cod);
}
