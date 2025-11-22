package org.gsnt.auttech.db;

import org.gsnt.auttech.util.Circulos;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

public class TesteConexao {


    public Boolean testeInternet(){

            try {
                URL url = new URL("http://www.google.com");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(60);
                conn.connect();
                return conn.getResponseCode() == 200;
            } catch (Exception e) {
                return false;
            }

    }


    public Boolean testeDbOn() {
        try {
            return DBOn.testBdRemoto();
        }catch (SQLException e){
            throw new DbException(e.getMessage()+"Erro teste de conexão Banco DBOn");
        }
    }

    public Boolean testeDbSttOn() {
        try {
            return DBSttOn.testBdRemoto();
        }catch (SQLException e){
            throw new DbException(e.getMessage()+"Erro teste de conexão Banco DBSttOn");
        }
    }

    public Boolean testeDbLocal() {
        try {
            return DBLocal.testBdRemoto();
        }catch (SQLException e){
            throw new DbException(e.getMessage()+"Erro teste de conexão Banco DBLocal");
        }
    }

}
