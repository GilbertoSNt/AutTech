package org.gsnt.auttech.model.dao.service;


import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.AgendaDao;
import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.util.Circulos;


import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AgendaService implements AgendaDao {

    private Connection conn;

    public AgendaService(){}

    public AgendaService(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Agenda> findTelaPrincipal() {

        /* construtor do banco de dados
                    Integer cod, String data, String hora, String nome, String veiculo, String placa,
                  String telefone, String obs, Boolean sRevisao, Boolean sSuspensao, Boolean sInjecao,
                  Boolean sPneus, Boolean sTrocaOleo, Boolean sFreio, Boolean sEletrico, Boolean sMecanico,
                  Boolean sMotor, Boolean sCaixa, Boolean assSocMecanico, Boolean assSocEletrico, Boolean assLevar,
                  Boolean assGuincho, Boolean assBuscar, Boolean assClienteTraz, Boolean assEnvioGuincho,
                  Boolean assEnvioDeslocamento
        */
        Agenda b = new Agenda();
        List<Agenda> correta = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                    "select * from tabagenda order by dataagenda, hora"
            );
            rs = st.executeQuery();

            while(rs.next()){

                b.setCod(rs.getInt("cod"));
                b.setHora(rs.getString("hora"));
                b.setNome(rs.getString("nome"));
                b.setVeiculo(rs.getString("veiculo"));
                b.setPlaca(rs.getString("placa"));
                b.setTelefone(rs.getString("telefone"));
                b.setObs(rs.getString("obs"));
                b.setsRevisao(rs.getBoolean("revisao"));
                b.setsSuspensao(rs.getBoolean("suspensao"));
                b.setsInjecao(rs.getBoolean("injecao"));
                b.setsPneus(rs.getBoolean("pneus"));
                b.setsTrocaOleo(rs.getBoolean("trocaoleo"));
                b.setsFreio(rs.getBoolean("freio"));
                b.setsEletrico(rs.getBoolean("eletrico"));
                b.setsMecanico(rs.getBoolean("mecanico"));
                b.setsMotor(rs.getBoolean("motor"));
                b.setsCaixa(rs.getBoolean("caixa"));
                b.setAssSocMecanico(rs.getBoolean("socmecanico"));
                b.setAssSocEletrico(rs.getBoolean("soceletrico"));
                b.setAssLevar(rs.getBoolean("asslevar"));
                b.setAssGuincho(rs.getBoolean("assguincho"));
                b.setAssBuscar(rs.getBoolean("assbuscar"));
                b.setAssClienteTraz(rs.getBoolean("assclientetraz"));
                b.setAssEnvioGuincho(rs.getBoolean("assenvioguincho"));
                b.setAssEnvioDeslocamento(rs.getBoolean("assenviodeslocamento"));
                b.setDataAgenda(rs.getString("dataagenda"));

                Circulos socMecanico = null;

                if (b.getAssSocMecanico() && b.getAssEnvioGuincho()){
                    socMecanico = new Circulos("#0047ab");
                }else if (b.getAssSocMecanico()){
                    socMecanico = new Circulos("#70c3a7");
                }

                Circulos socEletrico = null;
                if (b.getAssSocEletrico() && b.getAssEnvioGuincho()){
                    socEletrico = new Circulos("#0047ab");
                }else if(b.getAssSocEletrico()){
                    socEletrico = new Circulos("#70c3a7");
                }

                Circulos levar = null;
                if(b.getAssLevar()){
                    levar = new Circulos("#70c3a7");
                }

                Circulos guincho = null;
                if(b.getAssGuincho() && b.getAssEnvioGuincho()) {
                    guincho = new Circulos("#0047ab");
                }else if(b.getAssGuincho()){
                    guincho= new Circulos("#70c3a7");
                }

                Circulos buscar = null;
                if(b.getAssBuscar() && b.getAssEnvioDeslocamento()){
                    buscar = new Circulos("#0047ab");
                }else if(b.getAssBuscar()){
                    buscar = new Circulos("#70c3a7");
                }

                Circulos sMecanico = null;
                if (b.getsMecanico() || b.getsCaixa() || b.getsFreio() || b.getsSuspensao() || b.getsMotor()) {
                    sMecanico = new Circulos("#70c3a7");
                }

                Circulos sEletrico = null;
                if(b.getsEletrico()){
                    sEletrico= new Circulos("#70c3a7");
                }

                Circulos sInjecao = null;
                if(b.getsInjecao()){
                    sInjecao = new Circulos("#70c3a7");
                }

                Circulos  sRevisao = null;
                if(b.getsRevisao()){
                    sRevisao = new Circulos("#70c3a7");
                }

                Circulos  pneus = null;
                if(b.getsPneus()){
                    pneus = new Circulos("#70c3a7");
                }

                Circulos  sTrocaOleo = null;
                if(b.getsTrocaOleo()){
                    sTrocaOleo = new Circulos("#70c3a7");
                }

                //DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("HH:mm");
                DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MM");

                LocalDate data = LocalDate.parse(b.getDataAgenda());
                LocalTime hora = LocalTime.parse(b.getHora());
                LocalDate data1 = LocalDate.now();
                LocalTime hora1 = LocalTime.now();

                Circulos status = null;

                if (data.compareTo(data1)>0){
                    status = new Circulos("#70c3a7");
                }else if (data.compareTo(data1)>=0 && hora.compareTo(hora1)>=0){
                    status = new Circulos("#70c3a7");
                }else if(data.compareTo(data1)<=0 && hora.compareTo(hora1)<=0){
                    status = new Circulos("#cd5c5c");
                }

                correta.add(new Agenda(""+data.format(formato3), ""+hora.format(formato2), b.getNome(), b.getVeiculo(),
                        b.getPlaca(),socMecanico, socEletrico, levar, guincho, buscar, sMecanico, sEletrico, sInjecao,
                        sRevisao, pneus, sTrocaOleo,status));
            }
        }
        catch (SQLException e){
                throw new DbException(e.getMessage()+" findTelaPrincipal");
        }
        finally {
            DB2.closeStatement(st);
        }

        return correta;

    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public List<Agenda> findLista() {




        return List.of();
    }

    @Override
    public Boolean insertAgenda(Agenda item) {

        /* construtor do banco de dados
                  Integer cod, String data, String hora, String nome, String veiculo, String placa,
                  String telefone, String obs, Boolean sRevisao, Boolean sSuspensao, Boolean sInjecao,
                  Boolean sPneus, Boolean sTrocaOleo, Boolean sFreio, Boolean sEletrico, Boolean sMecanico,
                  Boolean sMotor, Boolean sCaixa, Boolean assSocMecanico, Boolean assSocEletrico, Boolean assLevar,
                  Boolean assGuincho, Boolean assBuscar, Boolean assClienteTraz, Boolean assEnvioGuincho,
                  Boolean assEnvioDeslocamento
        */

        Agenda a = item;

        PreparedStatement st = null;
        try{

            st = conn.prepareStatement(
            "INSERT INTO tabagenda(hora, nome, veiculo, placa, telefone, obs, revisao, suspensao,"+
                " injecao, pneus, trocaoleo, freio, eletrico, mecanico, motor, caixa, socmecanico,"+
                " soceletrico, asslevar, assguincho, assbuscar, assclientetraz, assenvioguincho,"+
                " assenviodeslocamento, dataagenda)"+
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

            st.setString(1,a.getHora());
            st.setString(2,a.getNome());
            st.setString(3,a.getVeiculo());
            st.setString(4,a.getPlaca());
            st.setString(5,a.getTelefone());
            st.setString(6,a.getObs());
            st.setBoolean(7,a.getsRevisao());
            st.setBoolean(8,a.getsSuspensao());
            st.setBoolean(9,a.getsInjecao());
            st.setBoolean(10,a.getsPneus());
            st.setBoolean(11,a.getsTrocaOleo());
            st.setBoolean(12,a.getsFreio());
            st.setBoolean(13,a.getsEletrico());
            st.setBoolean(14,a.getsMecanico());
            st.setBoolean(15,a.getsMotor());
            st.setBoolean(16,a.getsCaixa());
            st.setBoolean(17,a.getAssSocMecanico());
            st.setBoolean(18,a.getAssSocEletrico());
            st.setBoolean(19,a.getAssLevar());
            st.setBoolean(20,a.getAssGuincho());
            st.setBoolean(21,a.getAssBuscar());
            st.setBoolean(22,a.getAssClienteTraz());
            st.setBoolean(23,a.getAssEnvioGuincho());
            st.setBoolean(24,a.getAssEnvioDeslocamento());
            st.setString(25,a.getDataAgenda());

            int rowsEffected = st.executeUpdate();

            if (rowsEffected > 0) {
				/*ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);*/
                return true;

            }
			else {
                return false;
				//throw new DbException("Unexpected error! No rows affected!");
			}

        }catch (SQLException e){
            throw new DbException(e.getMessage()+" insertAgenda");
        }
        finally {
            DB2.closeStatement(st);
        }


    }

    @Override
    public Boolean excluiAgenda(Agenda item) {

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("DELETE FROM tabagenda WHERE placa = ?");
            st.setString(1, item.getPlaca());

            st.executeUpdate();

            return true;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB2.closeStatement(st);
        }

    }

    @Override
    public Boolean saveAlterAgenda(Agenda item) {
        return null;
    }

    @Override
    public Agenda findByPlacaData(String placa) {

        /* construtor do banco de dados
                  Integer cod, String data, String hora, String nome, String veiculo, String placa,
                  String telefone, String obs, Boolean sRevisao, Boolean sSuspensao, Boolean sInjecao,
                  Boolean sPneus, Boolean sTrocaOleo, Boolean sFreio, Boolean sEletrico, Boolean sMecanico,
                  Boolean sMotor, Boolean sCaixa, Boolean assSocMecanico, Boolean assSocEletrico, Boolean assLevar,
                  Boolean assGuincho, Boolean assBuscar, Boolean assClienteTraz, Boolean assEnvioGuincho,
                  Boolean assEnvioDeslocamento
        */
        Agenda agenda = new Agenda();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("SELECT tabagenda " +
                                        "WHERE placa = ?");
            st.setString(1, placa);

            rs = st.executeQuery();

            agenda.setCod(rs.getInt("cod"));
            agenda.setDataAgenda(rs.getString("dataagenda"));
            agenda.setHora(rs.getString("hora"));
            agenda.setNome(rs.getString("nome"));
            agenda.setVeiculo(rs.getString("veiculo"));
            agenda.setPlaca(rs.getString("placa"));
            agenda.setTelefone(rs.getString("telefone"));
            agenda.setObs(rs.getString("obs"));
            agenda.setsRevisao(rs.getBoolean("revisao"));
            agenda.setsSuspensao(rs.getBoolean("suspensao"));
            agenda.setsInjecao(rs.getBoolean("injecao"));
            agenda.setsPneus(rs.getBoolean("pneus"));
            agenda.setsTrocaOleo(rs.getBoolean("trocaoleo"));
            agenda.setsFreio(rs.getBoolean("freio"));
            agenda.setsEletrico(rs.getBoolean("eletrico"));
            agenda.setsMecanico(rs.getBoolean("mecanico"));
            agenda.setsMotor(rs.getBoolean("motor"));
            agenda.setsCaixa(rs.getBoolean("caixa"));
            agenda.setAssSocMecanico(rs.getBoolean("socmecanico"));
            agenda.setAssSocEletrico(rs.getBoolean("soceletrico"));
            agenda.setAssLevar(rs.getBoolean("asslevar"));
            agenda.setAssGuincho(rs.getBoolean("assguincho"));
            agenda.setAssBuscar(rs.getBoolean("assbuscar"));
            agenda.setAssClienteTraz(rs.getBoolean("assclientetraz"));
            agenda.setAssEnvioGuincho(rs.getBoolean("assenvioguincho"));
            agenda.setAssEnvioDeslocamento(rs.getBoolean("assenviodeslocamento"));

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB2.closeStatement(st);
        }

        return agenda;
    }

    @Override
    public void saveEnvioRecolhimento(Agenda item) {

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("UPDATE tabagenda " +
                                           "SET assenviodeslocamento=true " +
                                           "WHERE placa = ?");
            st.setString(1, item.getPlaca());

            st.executeUpdate();

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB2.closeStatement(st);
        }

    }

    @Override
    public void saveEnvioGuincho(Agenda item) {

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("UPDATE tabagenda " +
                    "SET assenvioguincho=true " +
                    "WHERE placa = ?");
            st.setString(1, item.getPlaca());

            st.executeUpdate();

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB2.closeStatement(st);
        }

    }



}
