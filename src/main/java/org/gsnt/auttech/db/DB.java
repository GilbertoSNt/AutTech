package org.gsnt.auttech.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = "jdbc:postgresql://192.168.0.180:5432/bancoempresaon";
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

    public static boolean testBd() throws SQLException {

        Connection c1 = null;

        try {
            Properties props = loadProperties();
            String url = "jdbc:postgresql://192.168.0.180:5432/bancoempresaon";
            c1 = DriverManager.getConnection(url, props);
            if( c1 != null && !c1.isClosed()){
                c1.close();
                return true;
            }else{
                return false;
            }

        } catch (SQLException e) {
            return false;
        }

    }

}
