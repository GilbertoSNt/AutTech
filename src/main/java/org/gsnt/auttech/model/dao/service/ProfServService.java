package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DBLocal;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.ProfServDao;
import org.gsnt.auttech.model.entities.Direcionados;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfServService implements ProfServDao {

    private final Connection conn;

    private final String SQLlistaServPorFuncionarios = "SELECT * from public.cpcprfssnl(?)";
    private final String SQLSaveDirecionados = "CALL public.ins_tabosprfssnl(?,?,?,?,?,?)";
    private final String SQLEditDirecionados = "";
    private final String SQLExcluiDirecionados = "";
    private final String SQLListaServicos = "SELECT * FROM nmsrvcprfssnl";

    public ProfServService(Connection conn){
        this.conn = conn;
    }


    /**
     * Salva o primeiro direcionamento
     *
     * @param dir
     * @return boolean
     */
    @Override
    public Boolean saveDirecionadosInterno(List<Direcionados> dir, Integer codOS, char tipo,
                                           Integer movimento) {

        int troleo = Integer.parseInt(null);
        try{
            conn.setAutoCommit(false);

            CallableStatement cs = conn.prepareCall(SQLSaveDirecionados);

            for(int a=0; a<dir.size(); a++) {
            cs.setInt(1, codOS);
            cs.setInt(2,dir.get(a).getTpSrvc());
            cs.setInt(3,dir.get(a).getFuncionario());
            cs.setBigDecimal(4, BigDecimal.valueOf(0.0));
            cs.setString(5, String.valueOf(tipo));
            cs.setInt(6,movimento);

            cs.execute();

            switch (dir.get(a).getTpSrvc()){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
            }




            }
            conn.commit();
            return true;
        }
        catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage()+" erro em ProfServService rollback - saveDirecionamentosInternos");
            }
            throw new DbException(e.getMessage()+" erro em ProfServService - saveDirecionamentosInternos");
        }
        finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException ea) {
                throw new DbException(ea.getMessage() + " erro em ProfServService rollback - saveDirecionamentosInternos");
            }
        }

    }

    @Override
    public Boolean excluiDirecionados(Integer cod) {
        return null;
    }

    @Override
    public Boolean editDirecionados(Integer cod) {
        return null;
    }

    /***
     * listaServico - Lista de quantidade de serviços por técnico
     *
     * @return List = Lista de serviços em que todos os  profissionais estão envolvidos.
     * @author Gilberto da S. Neto
     * @version 1.0
     */

    @Override
    public List<Direcionados> listaServico() {

        List<Direcionados> drc = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(SQLListaServicos);
            rs = st.executeQuery();
            while(rs.next()){
                drc.add(new Direcionados(rs.getString("apelido"), rs.getInt("total")));
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" DirecionadosService - listaServiço");
        }
        finally {
            DBLocal.closeResultSet(rs);
            DBLocal.closeStatement(st);
        }
        return drc;
    }

    /***
     * listaServPorFuncionarios Lista detalhada dos serviços enviados para técnico que é carregada na tela
     * ListaAtendFuncController e tambem na tela principal
     *
     * @param cod = número do técnico
     * @return List = Lista de serviços em que o profissional está envolvido.
     * @author Gilberto da S. Neto
     * @version 1.0
     */

    @Override
    public List<Direcionados> listaServPorFuncionarios(Integer cod) {

        List<Direcionados> drc = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(SQLlistaServPorFuncionarios);
            st.setInt(1,cod);
            rs = st.executeQuery();

            while(rs.next()){
                drc.add(new Direcionados(rs.getString("placa"), rs.getString("tempo"),
                        rs.getInt("ordem"), rs.getBoolean("aceito")));
            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" DirecionadosService - listaServPorFuncionarios");
        }
        finally {
            DBLocal.closeResultSet(rs);
            DBLocal.closeStatement(st);
        }

        return drc;

    }

    @Override
    public List<String> envio(List<String> enviados) {

        return List.of();
    }


}
