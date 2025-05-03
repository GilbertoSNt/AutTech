package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Email;

import java.util.List;

public interface EmailDao {

    void saveEmail(Email email);
    void alterEmail(Email email);
    Email findEmailCod(int codExterno);
    List<Email> findListEmailCod(int codExterno);


}
