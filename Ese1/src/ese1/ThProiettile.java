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

    private Integer nProittile;
    private Random rn;
    private int attesa;
    private datiCondivisi datiC;

    public ThProiettile(int nProittile, datiCondivisi datiC) {
        this.nProittile = nProittile;
        this.datiC = datiC;
        rn = new Random();
        attesa = 1;
    }

    @Override
    public void run() {
        try {
            attesa += rn.nextInt(1);
            this.join(attesa);
            System.out.println("Proiettile" + nProittile.toString() + " sparato");

            if (nProittile == 1) {
                datiC.setColpito1(true);
            } else {
                datiC.setColpito2(true);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThProiettile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
