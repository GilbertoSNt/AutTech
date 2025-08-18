package org.gsnt.auttech.util;

public class ExceptionGenerics extends RuntimeException {

    private LogTxt log = new LogTxt();

    public ExceptionGenerics(String msg) {

        super(msg);
        log.escreveErro(msg);

    }
}
