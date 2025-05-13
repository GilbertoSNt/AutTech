package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.EmailDao;
import org.gsnt.auttech.model.entities.Email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmailService implements EmailDao {

    private Connection conn;

    public EmailService(Connection conn){
        this.conn = conn;
    }

    @Override
    public void saveEmail(Email email) {

        Email em = email;

        PreparedStatement st = null;
       try{
           st = conn.prepareStatement("INSERT INTO tabemail(codexterno, tipo, email, " +
                   "                    codcaso) VALUES (?, ?, ?, ?)");

           st.setInt(1,em.getCodExterno());
           st.setInt(2,em.getTipo());
           st.setString(3, em.getEmail());
           st.setInt(4, em.getCodCaso());

           st.executeUpdate();
       }catch (SQLException e1){
           throw new DbException(e1.getMessage()+" EmailService - save ");
       }
       finally {
           DB2.closeStatement(st);
       }

    }

    @Override
    public void alterEmail(Email email) {

    }

    @Override
    public Email findEmailCod(int codExterno) {
        return null;
    }

    @Override
    public List<Email> findListEmailCod(int codExterno) {
        return List.of();
    }
}
