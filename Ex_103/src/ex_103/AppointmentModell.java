/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_103;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;

/**
 *
 * @author oskar
 */
public class AppointmentModell extends AbstractListModel{

    private ArrayList<Appointment> termine= new ArrayList<>();
    private ArrayList<Appointment> filtered= new ArrayList<>();
    
    public void add(Appointment app){
        filtered.add(app);
        termine.add(app);
        Collections.sort(filtered);
        fireContentsChanged(this, 0, filtered.size()-1);
    }
    @Override
    public int getSize() {
        return filtered.size();
    }

    @Override
    public Object getElementAt(int index) {
        return filtered.get(index);
    }
    
    public void delete(int idx){
        termine.remove(filtered.get(idx));
        filtered.remove(idx);
        fireContentsChanged(this, 0, filtered.size()-1);
    }
    
    public Appointment get(int idx){
        
        return filtered.get(idx);
    }
    
    public void change(int idx,Appointment app){
        filtered.set(idx, app);
        fireContentsChanged(this, 0, filtered.size()-1);
    }
    
    public void save(File f){
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (Appointment app : filtered) {
                bw.write(app.toString());
            }
            
            bw.flush();
            bw.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(AppointmentModell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
