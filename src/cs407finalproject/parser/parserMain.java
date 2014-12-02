/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.parser;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan 
 */
public class parserMain {
    
    public static void main(String[] args) {
        
        try {
            Thread loader = new Thread(new AnimalLoader("config/animals.xml"));
            loader.start();
            loader.join();
            System.out.println("Done Loading");
            
        } catch (InterruptedException ex) {
            Logger.getLogger(parserMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
