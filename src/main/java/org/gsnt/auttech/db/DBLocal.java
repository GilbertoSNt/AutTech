package org.gsnt.auttech.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBLocal {

    private static Connection connLc = null;
    private static Properties propertiesLc = new Properties();


    static {
        try(InputStream input = new FileInputStream("db.properties")){

            if(input == null){
                System.out.println("Erro na leitura do db.properties");
            }
            propertiesLc.load(input);

        }catch (IOException e){
            throw new DbException(e.getMessage()+" Erro no loadProperties classe db.properties");
        }

    }


    public static Connection getConnection() {
        if (connLc == null) {
            try {

                Class.forName(propertiesLc.getProperty("db1.driver"));
                return DriverManager.getConnection(
                        propertiesLc.getProperty("db1.url"),
                        propertiesLc.getProperty("db1.username"),
                        propertiesLc.getProperty("db1.password")
                );

            }
            catch (ClassNotFoundException e) {
                throw new DbException(e.getMessage()+" Erro no getConnection db não encontrado o arquivo");
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage()+" Erro no getConnection db");
            }

        }
        return connLc;
    }





    public static void closeConnection(){
        if(connLc != null){
            try{
                connLc.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
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

        Boolean a = false;
        Connection c2 = null;
        try {

            c2 = getConnection();
            if( c2 != null && !c2.isClosed()){
                c2.close();
                a = true;
            }else{
                a = false;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }finally {
            return a;
        }
    }

}
