package org.gsnt.auttech.db;

import org.gsnt.auttech.util.LogTxt;

import java.io.IOException;

public class DbException extends RuntimeException {

    private LogTxt log = new LogTxt();

    public DbException(String msg){

        super(msg);
        log.escreveErro(msg);

    }

}
