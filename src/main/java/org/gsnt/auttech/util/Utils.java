package org.gsnt.auttech.util;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public String returnDateSystemTela()  {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formaData.format(agora);
    }

    public String returnDateSystemBanco(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formaData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formaData.format(agora);
    }

    public String returnTimeSystem(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formaHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        return formaHora.format(agora);
    }

    public Date returnSystemDateBanco(){
        return Date.valueOf(LocalDate.now());
    }

    public Time returnSystemTimeBanco(){
        return Time.valueOf(LocalTime.now());
    }



}
