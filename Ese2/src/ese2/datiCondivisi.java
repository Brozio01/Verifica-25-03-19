/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese2;

import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author borzi_davide
 */
public class datiCondivisi {

    private Semaphore stampa, ricerca1, ricerca2, input;
    private String[] Google, Cache;
    private String str;
    private int numEl;
    private Vector vect;

    public datiCondivisi() {
        stampa = new Semaphore(1);
        ricerca1 = new Semaphore(0);
        ricerca2 = new Semaphore(0);
        input = new Semaphore(0);

        String[] Google = {"agora.ismonnet.it", "www.google.com", "github.com",
            "www.ismonnet.gov.it", "github.com/giodabg", "github.com/test"};
        String[] Cache = {"https://www.html.it/pag/50430/gli-array-injava", "www.html.it", "https://www.ismonnet.gov.it",
            "github.com/giodabg/EseThread", "https://www.ismonnet.gov.it/circolari.asp?bld=doc"};
        
        vect = new Vector();
        numEl = 0;
    }
    
    public String getStr(){
        return str;
    }
    
    public void setStr(String s){
        str = s;
    }

    public String[] getGoogle() {
        return Google;
    }

    public String[] getCache() {
        return Cache;
    }

    public synchronized void setVect(String s) {
        vect.add(s);
    }    
    
    public Vector getVect(){
        return vect;
    }
    
    //----METODI PER LA SINCRONIZZAZIONE----
    public void aspettaAvvenutoInput(){
        try {
            input.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(datiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void segnalaAvvenutoInput(){
        input.release();
    }
    
    public void aspettaAvvenutaStampa(){
        try {
            stampa.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(datiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void segnalaAvvenutoAggiornamento(){
        ricerca1.release();
        ricerca2.release();
    }
    
    public void aspettaAvvenutoAggiornamento1(){
        try {
            ricerca1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(datiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void aspettaAvvenutoAggiornamento2(){
        try {
            ricerca2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(datiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void segnalaAvvenutaRicerca(){
        stampa.release();
    }
    
    public void aspettaAvvenutaRicerca(){
        try {
            stampa.acquire();
            stampa.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(datiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void segnalaAvvenutaStampa(){
        stampa.release();
    }
    //----METODI PER LA SINCRONIZZAZIONE----
}
