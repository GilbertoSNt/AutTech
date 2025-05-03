package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.model.dao.EmailDao;
import org.gsnt.auttech.model.entities.Email;

import java.sql.Connection;

public class EmailService implements EmailDao {

    private Connection conn;

    public EmailService(Connection conn){
        this.conn = conn;
    }

    @Override
    public void saveEmail(Email email) {

    }
}
