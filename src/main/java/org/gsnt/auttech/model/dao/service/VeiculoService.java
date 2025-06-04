package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.VeiculoDao;
import org.gsnt.auttech.model.entities.Veiculo;

import java.sql.*;
import java.util.List;

public class VeiculoService implements VeiculoDao {

    private Connection conn;

    public VeiculoService(){}

    public VeiculoService(Connection conn){
        this.conn = conn;
    }


    @Override
    public List<Veiculo> findAll() {
        return List.of();
    }

    @Override
    public Veiculo findById(String placa) {

        Veiculo veiculo = new Veiculo();
        ResultSet rs = null;
        PreparedStatement st = null;
            try{
            st = conn.prepareStatement("SELECT * FROM tabveiculo WHERE placa = ?");
            st.setString(1, placa);
            rs = st.executeQuery();
            rs.next();

            veiculo.setCod(rs.getInt("cod"));
            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setMarca(rs.getInt("marca"));
            veiculo.setModelo(rs.getInt("modelo"));
            veiculo.setChassi(rs.getString("chassi"));
            veiculo.setMotor(rs.getString("motor"));
            veiculo.setCv(rs.getString("cv"));
            veiculo.setTurbo(rs.getBoolean("turbo"));
            veiculo.setEmLinha(rs.getBoolean("emlinha"));
            veiculo.setEmV(rs.getBoolean("emv"));
            veiculo.setAnof(rs.getString("anof"));
            veiculo.setAnom(rs.getString("anom"));
            veiculo.setRenavan(rs.getString("renavam"));
            veiculo.setArQuente(rs.getBoolean("arquente"));
            veiculo.setAirBag(rs.getBoolean("airbag"));
            veiculo.setFreioABS(rs.getBoolean("freioabs"));
            veiculo.setAlarme(rs.getBoolean("alarme"));
            veiculo.setArCond(rs.getBoolean("arcond"));
            veiculo.setDirHid(rs.getBoolean("dirhid"));
            veiculo.setDirElet(rs.getBoolean("direlet"));
            veiculo.setVidroElet(rs.getBoolean("vidroelet"));
            veiculo.setTravaElet(rs.getBoolean("travaelet"));
            veiculo.setTracao(rs.getBoolean("tracao4"));
            veiculo.setTeto(rs.getBoolean("teto"));
            veiculo.setControleTracao(rs.getBoolean("controletracao"));
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" findbyid Veiculo");
        }
        finally {
            DB2.closeStatement(st);
        }
        return veiculo;

    }

    @Override
    public Integer saveVeiculo(Veiculo veiculo) {

        Veiculo a = veiculo;

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO tabveiculo(placa, marca, modelo, chassi, motor, cv, turbo, emlinha, emv, anof, " +
                            "anom, renavam, arquente, airbag, freioabs, alarme, arcond, dirhid, direlet, vidroelet," +
                            "travaelet, tracao4, teto, controletracao)"+
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1,a.getPlaca());
            st.setInt(2,a.getMarca());
            st.setInt(3,a.getModelo());
            st.setString(4,a.getChassi());
            st.setString(5,a.getMotor());
            st.setString(6,a.getCv());
            st.setBoolean(7,a.isTurbo());
            st.setBoolean(8,a.isEmLinha());
            st.setBoolean(9,a.isEmV());
            st.setString(10,a.getAnof());
            st.setString(11,a.getAnom());
            st.setString(12,a.getRenavan());
            st.setBoolean(13,a.isArQuente());
            st.setBoolean(14,a.isAirBag());
            st.setBoolean(15,a.isFreioABS());
            st.setBoolean(16,a.isAlarme());
            st.setBoolean(17,a.isArCond());
            st.setBoolean(18,a.isDirHid());
            st.setBoolean(19,a.isDirElet());
            st.setBoolean(20,a.isVidroElet());
            st.setBoolean(21,a.isTravaElet());
            st.setBoolean(22,a.isTracao());
            st.setBoolean(23,a.isTeto());
            st.setBoolean(24,a.isControleTracao());

            return st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage()+" insert Veiculo");
        }
        finally {
            DB2.closeStatement(st);
        }

    }

    @Override
    public Boolean desativaPLaca(String placa) {
        return null;
    }

    @Override
    public Boolean editPLaca(Veiculo veiculo) {
        return null;
    }

    @Override
    public Boolean desassociaPLaca(String placa) {
        return null;
    }

    @Override
    public Integer verificaPlaca(String placa) {

        Veiculo veiculo = new Veiculo();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("select count(placa) FROM tabveiculo WHERE placa = ?");
            st.setString(1, placa);
            rs = st.executeQuery();
            rs.next();
            return rs.getInt("count");
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" Verifica placa veiculoService");
        }
        finally {
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
    }

    @Override
    public Veiculo findByCod(int cod) {

        Veiculo veiculo = new Veiculo();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("SELECT * FROM tabveiculo WHERE cod = ?");
            st.setInt(1, cod);
            rs = st.executeQuery();
            rs.next();

            veiculo.setCod(rs.getInt("cod"));
            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setMarca(rs.getInt("marca"));
            veiculo.setModelo(rs.getInt("modelo"));
            veiculo.setChassi(rs.getString("chassi"));
            veiculo.setMotor(rs.getString("motor"));
            veiculo.setCv(rs.getString("cv"));
            veiculo.setTurbo(rs.getBoolean("turbo"));
            veiculo.setEmLinha(rs.getBoolean("emlinha"));
            veiculo.setEmV(rs.getBoolean("emv"));
            veiculo.setAnof(rs.getString("anof"));
            veiculo.setAnom(rs.getString("anom"));
            veiculo.setRenavan(rs.getString("renavam"));
            veiculo.setArQuente(rs.getBoolean("arquente"));
            veiculo.setAirBag(rs.getBoolean("airbag"));
            veiculo.setFreioABS(rs.getBoolean("freioabs"));
            veiculo.setAlarme(rs.getBoolean("alarme"));
            veiculo.setArCond(rs.getBoolean("arcond"));
            veiculo.setDirHid(rs.getBoolean("dirhid"));
            veiculo.setDirElet(rs.getBoolean("direlet"));
            veiculo.setVidroElet(rs.getBoolean("vidroelet"));
            veiculo.setTravaElet(rs.getBoolean("travaelet"));
            veiculo.setTracao(rs.getBoolean("tracao4"));
            veiculo.setTeto(rs.getBoolean("teto"));
            veiculo.setControleTracao(rs.getBoolean("controletracao"));
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" findbycod Veiculo");
        }
        finally {
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
        return veiculo;
    }

    @Override
    public Veiculo verPlacaModelo(Integer cod) {

        Veiculo veiculo = new Veiculo();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("SELECT placa,modelo FROM tabveiculo WHERE cod = ?");
            st.setInt(1, cod);
            rs = st.executeQuery();
            rs.next();

            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setModelo(rs.getInt("modelo"));
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" ver placa - VeiculoService");
        }
        finally {
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
        return veiculo;

    }
}
