package org.gsnt.auttech.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB2 {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = "jdbc:postgresql://192.168.0.180:5432/bancoempresa";
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
        return conn;
    }

    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e){
            throw new DbException(e.getMessage());
        }

    }

    public static void closeStatement(PreparedStatement st){
        if (st != null){
            try{
                st.close();
            }
            catch (SQLException a){
                throw new DbException(a.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            }
            catch (SQLException a){
                throw new DbException(a.getMessage());
            }
        }
    }

    public static boolean testBdRemoto() throws SQLException {
        Connection c2 = null;
        try {
            Properties props = loadProperties();
            String url = "jdbc:postgresql://192.168.0.180:5432/bancoempresabase";
            c2 = DriverManager.getConnection(url, props);
            if( c2 != null && !c2.isClosed()){
                c2.close();
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

}
