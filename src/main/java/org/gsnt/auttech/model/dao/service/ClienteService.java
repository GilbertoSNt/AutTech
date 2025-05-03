package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.ClienteDao;
import org.gsnt.auttech.model.entities.*;
import org.gsnt.auttech.util.Moka;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClienteService implements ClienteDao {

    public ClienteService(){

    }

    private Connection conn;

    public ClienteService(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Cliente> findAllTest(){
        Moka mok = new Moka();
        return mok.dadosListaClientes();
    }

    @Override
    public List<Cliente> findAll() {

        PreparedStatement st = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<>();
        try{
            st = conn.prepareStatement("Select cod, tipo, nome, apelido from tabcliente");
            rs = st.executeQuery();

            while(rs.next()){
                list.add(new Cliente(rs.getBoolean("tipo"), rs.getInt("cod"),rs.getString("nome"), rs.getString("apelido")));
            }

        }
        catch (SQLException a){
            throw new DbException(a.getMessage()+" Cliente - findAll");
        }
        finally{
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
        return list;

    }

    @Override
    public List<Cliente> findAllPart(String part) {

        PreparedStatement st = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<>();
        try{
            st = conn.prepareStatement("Select cod, tipo, nome, apelido from tabcliente where UPPER nome LIKE %"+part+"%");
            rs = st.executeQuery();

            while(rs.next()){
                list.add(new Cliente(rs.getBoolean("tipo"), rs.getInt("cod"),rs.getString("nome"), rs.getString("apelido")));
            }

        }
        catch (SQLException a){
            throw new DbException(a.getMessage()+" Cliente - findAllPart");
        }
        finally{
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
        return list;
    }

    @Override
    public Cliente findByCPF(String CPF) {

        Cliente cli = new Cliente();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("Select cod, cpf, rg, nome, apelido, dataini, Status, tipo, perfil from tabcliente where cpf = "+CPF);
            cli.setCod(rs.getInt("cod"));
            cli.setCpf(rs.getString("cpf"));
            cli.setRg(rs.getString("rg"));
            cli.setNome(rs.getString("nome"));
            cli.setApelido(rs.getString("apelido"));
            cli.setDataCad(rs.getString("datacad"));
            cli.setDataNasc(rs.getString("dataini"));
            cli.setPj(rs.getBoolean("tipo"));
            cli.setApelido(rs.getString("apelido"));

        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" Cliente - findByCPF");
        }
        finally {
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
        return cli;
    }

    @Override
    public Cliente findByCNPJ(String CNPJ) {

        Cliente cli = new Cliente();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("Select cod,  cnpj, nome, apelido, status, dataini, inscr, inscrMun, perfil, datacad from tabcliente where cnpj = "+CNPJ);
            cli.setCod(rs.getInt("cod"));
            cli.setCnpj(rs.getString("cnpj"));
            cli.setNome(rs.getString("nome"));
            cli.setApelido(rs.getString("apelido"));
            cli.setStatus(rs.getBoolean("status"));
            cli.setDataNasc(rs.getString("dataini"));
            cli.setApelido(rs.getString("inscr"));
            cli.setApelido(rs.getString("inscrMun"));
            cli.setPj(rs.getBoolean("perfil"));
            cli.setDataCad(rs.getString("datacad"));
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" Cliente - findByCNPJ");
        }
        finally {
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
        return cli;
    }

    @Override
    public Cliente findById(int id) {

        Cliente cli = new Cliente();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{

            st = conn.prepareStatement("Select cod, nome, apelido from tabcliente where cod = "+id);
            rs = st.executeQuery();
            rs.next();
            cli.setCod(rs.getInt("cod"));
            cli.setNome(rs.getString("nome"));
            cli.setApelido(rs.getString("apelido"));

        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" Cliente - findById");
        }
        finally {
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
        return cli;

    }

    @Override
    public List<Email> findEmailById(int id) {
        return List.of();
    }

    @Override
    public Endereco findEndById(int id) {
        return null;
    }

    @Override
    public List<TelCliente> findTelById(int id) {
        return List.of();
    }

    @Override
    public int saveCliente(Cliente cliente) {
        PreparedStatement st = null;
        Cliente cli = cliente;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int resultado = 0;
        try {
            st = conn.prepareStatement("insert into tabcliente (cpf, rg,"
                                            +" nome, apelido, dataini, status,"
                                            + "tipo, perfil, datacad) values ?,"
                                            +"?,?,?,?,?,?,?,? ",
                                            Statement.RETURN_GENERATED_KEYS);
            st.setString(1,cli.getCpf());
            st.setString(2,cli.getRg());
            st.setString(3,cli.getNome());
            st.setString(4,cli.getApelido());
            st.setDate(5,(Date)formatter.parse(cli.getDataNasc()));
            st.setBoolean(6,cli.getStatus());
            st.setBoolean(7,cli.isPj());
            st.setBoolean(8,cli.getPerfil());
            st.setDate(9, (Date)formatter.parse(cli.getDataCad()));
            int rowsaffected = st.executeUpdate();
            if(rowsaffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    resultado = rs.getInt(1);
                }
                DB2.closeResultSet(rs);
            }

        }
        catch (SQLException a){
            throw new DbException(a.getMessage()+" Cliente - saveCliente");
        }
        catch (ParseException b){
            throw new DbException(b.getMessage());
        }
        finally {
            DB2.closeStatement(st);
        }
        return resultado;

        //falta implementar telefones, emails, endereço


    }

    @Override
    public Boolean emailCliente(List<Email> email, int codCliente) {

        return null;
    }

    @Override
    public Boolean endCliente(Endereco endereco, int cod) {
        return null;
    }

    @Override
    public Boolean telCliente(List<TelCliente> telefone, int cod) {
        return null;
    }

    @Override
    public Boolean saveAlterCliente(String CPF) {
        return null;
    }

    @Override
    public Boolean emailAlterCliente(List<Email> email) {
        return null;
    }

    @Override
    public Boolean endAlterCliente(Endereco endereco) {
        return null;
    }

    @Override
    public Boolean telAlterCliente(List<TelCliente> telefone) {
        return null;
    }

    @Override
    public Boolean DesativaCliente(String CPF) {
        return null;
    }

    @Override
    public Boolean excluiEmailCliente(Email email) {
        return null;
    }

    @Override
    public Boolean excluirTelCliente(TelCliente telefone) {
        return null;
    }

    @Override
    public void associacaoVeicCliente(int codVeic, int codCliente) {

        PreparedStatement st = null;
        //int resultado = 0;
        try {
            st = conn.prepareStatement("INSERT INTO public.tabveiccliente(" +
                            "codcliente, codveiculo)" +
                            "VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, codVeic);
            st.setInt(2, codCliente);

            int rowsaffected = st.executeUpdate();
            if (rowsaffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
          //          resultado = rs.getInt(1);
                }
                DB2.closeResultSet(rs);
            }
        }
        catch (SQLException a){
            throw new DbException(a.getMessage()+" Cliente - associacaoVeicCliente");
        } finally {
            DB2.closeStatement(st);
        }

    }

    @Override
    public int findIdClienteByIdVeiculo(int codVeic) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("Select codcliente from tabveiccliente where codveiculo = "+codVeic);
            rs = st.executeQuery();
            rs.next();
            return rs.getInt("codcliente");

        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" Cliente - findIdClienteByIdVeiculo");
        }
        finally {
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
    }
}
