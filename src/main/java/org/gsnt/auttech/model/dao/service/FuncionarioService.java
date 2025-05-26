package org.gsnt.auttech.model.dao.service;
import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.FuncionarioDao;
import org.gsnt.auttech.model.entities.Endereco;
import org.gsnt.auttech.model.entities.Funcionario;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioService implements FuncionarioDao {

	private Connection conn;

	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public FuncionarioService(Connection conn){
		this.conn = conn;
	}




    @Override
    public int saveFuncionario(Funcionario funcionario) {

		Funcionario f = funcionario;

		PreparedStatement st = null;

		try{
			st = conn.prepareStatement("INSERT INTO tabfuncionario(cpf, rg, nome, datanasc, " +
					"genero, status, tipo, telefone, telefoneconjuge, mae, pai, conjuge, qtdfilhos,dataadm, " +
					"datadesl, obs, cartprofissional, dataemissao,cargo, funcao, comissaopecas, comissaoservicos," +
					"salario, comissao, obsprof, caixamec, caixaaut, eletrica, freio, injdiesel, injflex, motordiesel," +
					"motorflex, pneus, suspensao, socorro, veiceletrico, motleva, motguincho)VALUES (" +
					"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
					"?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

				st.setString(1, f.getCpf());
				st.setString(2, f.getRg());
				st.setString(3, f.getNome());
				st.setString(4,f.getDataNasc());
				st.setBoolean(5,f.getGenero());
				st.setBoolean(6,f.getStatus());
				st.setInt(7, f.getTipoFunc());
				st.setString(8, f.getTelefone());
				st.setString(9, f.getTelConjuge());
				st.setString(10, f.getMae());
				st.setString(11, f.getPai());
				st.setString(12, f.getConjuge());
				st.setInt(13, f.getQtdFilhos());
				st.setString(14, f.getDataAdm());
				st.setString(15, f.getDataDesl());
				st.setString(16, f.getObs());
				st.setString(17, f.getCartProfissional());
				st.setString(18, f.getDataemissao());
				st.setString(19, f.getCargo());
				st.setString(20,f.getFuncao());
				st.setString(21,f.getComissaoPecas());
				st.setString(22,f.getComissaoServicos());
				st.setString(23,f.getSalario());
				st.setBoolean(24,f.getComissao());
				st.setString(25, f.getObsProf());
				st.setBoolean(26, f.getCaixaMec());
				st.setBoolean(27, f.getCaixaAut());
				st.setBoolean(28, f.getEletrica());
				st.setBoolean(29,f.getFreio());
				st.setBoolean(30, f.getInjDiesel());
				st.setBoolean(31, f.getInjFlex());
				st.setBoolean(32, f.getMotorDiesel());
				st.setBoolean(33, f.getMotorFlex());
				st.setBoolean(34, f.getPneus());
				st.setBoolean(35, f.getSuspensao());
				st.setBoolean(36, f.getSocorro());
				st.setBoolean(37, f.getVeicEletricos());
				st.setBoolean(38, f.getMotLeva());
				st.setBoolean(39, f.getMotguincho());

				int resultado = 0;
				int rowsaffected = st.executeUpdate();
				if(rowsaffected > 0){
					ResultSet rs = st.getGeneratedKeys();
					if(rs.next()){
					resultado = rs.getInt(1);
				}
					DB2.closeResultSet(rs);
				}

				return resultado;

		}catch(SQLException e){
			throw new DbException(e.getMessage()+" insert funcionarios");
        } finally {
			DB2.closeStatement(st);
		}

    }

	@Override
	public List<Funcionario> findByEspecializacao() {

		Funcionario retorno;
		List<Funcionario> retornoFunc = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement(
                    "SELECT nome, caixamec, caixaaut, eletrica, freio, injdiesel, injflex, motordiesel," +
							" motorflex, pneus, suspensao, socorro, veiceletrico, motleva,motguincho " +
							"FROM tabfuncionario WHERE datadesl=''");

            rs = st.executeQuery();

			while (rs.next()) {
				retorno = new Funcionario();
				retorno.setNome(rs.getString("nome"));
				retorno.setCaixaMec(rs.getBoolean("caixamec"));
				retorno.setCaixaAut(rs.getBoolean("caixaaut"));
				retorno.setEletrica(rs.getBoolean("eletrica"));
				retorno.setFreio(rs.getBoolean("freio"));
				retorno.setInjDiesel(rs.getBoolean("injdiesel"));
				retorno.setInjFlex(rs.getBoolean("injflex"));
				retorno.setMotorDiesel(rs.getBoolean("motordiesel"));
				retorno.setMotorFlex(rs.getBoolean("motorflex"));
				retorno.setPneus(rs.getBoolean("pneus"));
				retorno.setSuspensao(rs.getBoolean("suspensao"));
				retorno.setSocorro(rs.getBoolean("socorro"));
				retorno.setVeicEletricos(rs.getBoolean("veiceletrico"));
				retorno.setMotLeva(rs.getBoolean("motleva"));
				retorno.setMotguincho(rs.getBoolean("motguincho"));

				retornoFunc.add(retorno);
			}
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" findByEspecialização");
        }
        finally {
			DB2.closeResultSet(rs);
			DB2.closeStatement(st);
        }

		return retornoFunc;
	}

	@Override
	public Funcionario findByCod(Integer cod) {
		return null;
	}

	@Override
	public void alterFuncionario(Funcionario funcionario, int cod) {

		Funcionario f = funcionario;

		PreparedStatement st = null;

		try{
			st = conn.prepareStatement("UPDATE tabfuncionario SET cpf=?, rg=?, nome=?, datanasc=?, genero=?," +
							" status=?, tipo=?, telefone=?, telefoneconjuge=?, mae=?, pai=?, conjuge=?, qtdfilhos=?, " +
							"dataadm=?, datadesl=?, obs=?, cartprofissional=?, dataamissao=?, cargo=?, funcao=?, " +
							"comissaopecas=?, comissaoservicos=?, salario=?, comissao=?, obsprof=?, caixamec=?, " +
							"caixaaut=?, eletrica=?, freio=?, injdiesel=?, injflex=?, motordiesel=?, motorflex=?, " +
							"pneus=?, suspensao=?, socorro=?, veiceletrico=?, motleva=?, motguincho=?" +
							"WHERE cod = ?");

			st.setString(1, f.getCpf());
			st.setString(2, f.getRg());
			st.setString(3, f.getNome());
			st.setString(4,f.getDataNasc());
			st.setBoolean(5,f.getGenero());
			st.setBoolean(6,f.getStatus());
			st.setInt(7, f.getTipoFunc());
			st.setString(8, f.getTelefone());
			st.setString(9, f.getTelConjuge());
			st.setString(10, f.getMae());
			st.setString(11, f.getPai());
			st.setString(12, f.getConjuge());
			st.setInt(13, f.getQtdFilhos());
			st.setString(14, f.getDataAdm());
			st.setString(15, f.getDataDesl());
			st.setString(16, f.getObs());
			st.setString(17, f.getCartProfissional());
			st.setString(18, f.getDataemissao());
			st.setString(19, f.getCargo());
			st.setString(20,f.getFuncao());
			st.setString(21,f.getComissaoPecas());
			st.setString(22,f.getComissaoServicos());
			st.setString(23,f.getSalario());
			st.setBoolean(24,f.getComissao());
			st.setString(25, f.getObsProf());
			st.setBoolean(26, f.getCaixaMec());
			st.setBoolean(27, f.getCaixaAut());
			st.setBoolean(28, f.getEletrica());
			st.setBoolean(29,f.getFreio());
			st.setBoolean(30, f.getInjDiesel());
			st.setBoolean(31, f.getInjFlex());
			st.setBoolean(32, f.getMotorDiesel());
			st.setBoolean(33, f.getMotorFlex());
			st.setBoolean(34, f.getPneus());
			st.setBoolean(35, f.getSuspensao());
			st.setBoolean(36, f.getSocorro());
			st.setBoolean(37, f.getVeicEletricos());
			st.setBoolean(38, f.getMotLeva());
			st.setBoolean(39, f.getMotguincho());
			st.setInt(40,cod);
			st.executeUpdate();

		}catch(SQLException e){
			throw new DbException(e.getMessage()+" alter funcionarios");
		}finally {
			DB2.closeStatement(st);
		}

	}
}
