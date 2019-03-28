/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author borzi_davide
 */
public class ThProiettile extends Thread {
    
    Integer nProittile;
    Random rn;
    long attesa;

    public ThProiettile(int nProittile) {
        this.nProittile = nProittile;
        rn = new Random();
        attesa = 1000;
    }

    @Override
    public void run() {
        try {
            attesa += rn.nextLong();
            this.join(attesa);
            System.out.println("Proiettile " + nProittile.toString() + " sparato");
        } catch (InterruptedException ex) {
            Logger.getLogger(ThProiettile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
