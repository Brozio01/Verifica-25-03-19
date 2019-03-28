/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author borzi_davide
 */
public class datiCondivisi {

    private Semaphore piattello1, proiettile1;
    private Semaphore piattello2, proiettile2;
    private boolean colpito1, colpito2;

    public datiCondivisi() {
        piattello1 = new Semaphore(0);
        piattello2 = new Semaphore(0);
        proiettile1 = new Semaphore(1);
        proiettile2 = new Semaphore(1);
        colpito1 = false;
        colpito2 = false;
    }

    public boolean isColpito1() {
        return colpito1;
    }

    public void setColpito1(boolean colpito1) {
        this.colpito1 = colpito1;
    }

    public boolean isColpito2() {
        return colpito2;
    }

    public void setColpito2(boolean colpito2) {
        this.colpito2 = colpito2;
    }

    //----METODI PER SINCRONIZZAZIONE----
    public void aspettaSparo1() {
        try {
            proiettile1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(datiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void segnalaLancio1() {
        piattello1.release();
    }

    public void aspettaLancio1() {
        try {
            piattello1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(datiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void segnalaSparo1() {
        proiettile1.release();
    }

    public void aspettaSparo2() {
        try {
            proiettile2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(datiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void segnalaLancio2() {
        piattello2.release();
    }

    public void aspettaLancio2() {
        try {
            piattello2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(datiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void segnalaSparo2() {
        proiettile2.release();
    }
    //----METODI PER SINCRONIZZAZIONE----
}
