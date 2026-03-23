package org.gsnt.auttech.inicio;

import org.gsnt.auttech.config.db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IniService implements IniDAO {

    private Connection conn;

    public IniService(Connection conn){
        this.conn = conn;
    }
    @Override
    public String verifica(String cnpj) {

        try {
            PreparedStatement st = null;
            ResultSet rs = null;
            st = conn.prepareStatement("select concat(a, b, c) AS retorno from empresa where cnpj = ?");
            st.setString(1, cnpj);
            rs = st.executeQuery();
            rs.next();

            System.out.println(rs.getString("retorno"));

            if(rs.getRow() != 0) {

                return rs.getString("retorno");
            }else{
                return "0";
            }
        }
        catch (SQLException e){
            throw new DbException("IniService - Inicio");
        }
    }



}
