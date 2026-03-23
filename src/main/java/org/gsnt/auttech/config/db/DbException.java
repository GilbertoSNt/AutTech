package org.gsnt.auttech.config.db;

import org.gsnt.auttech.util.LogTxt;

public class DbException extends RuntimeException {

    private LogTxt log = new LogTxt();

    public DbException(String msg){

        super(msg);
        log.escreveErro(msg);

    }

}
