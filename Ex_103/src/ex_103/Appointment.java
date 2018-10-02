/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_103;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author oskar
 */
public class Appointment {
    private String text;
    private LocalDateTime time;

    public Appointment(String text, LocalDateTime time) {
        this.text = text;
        this.time = time;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.M.yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("hh.mm");
        return String.format("%s - %s --> %s", dtf.format(time),dtf2.format(time),text);
    }
    
    
}
