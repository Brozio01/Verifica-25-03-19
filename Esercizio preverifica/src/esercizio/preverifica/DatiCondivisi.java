/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio.preverifica;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davide
 */
public class DatiCondivisi {
    private Vector<Integer> buffer;
    
    private int firstInserite, secondInserite, thirdInserite;
    private int firstLette, secondLette, thirdLette;
    private int numGen;
    
    private Semaphore stampa, ricerca;
    private Semaphore genPrimo, genSecondo, genTerzo;

    public DatiCondivisi(int numGen) {
        this.numGen = numGen;
        buffer = new Vector();
        firstInserite = 0; firstLette = 0;
        secondInserite = 0; secondLette = 0;
        thirdInserite = 0; thirdLette = 0;
        stampa = new Semaphore(1);
        genPrimo = new Semaphore(0);
        genSecondo = new Semaphore(0);
        genTerzo = new Semaphore(0);
        ricerca = new Semaphore(0);
    }
    
    //=====GET E SET=====
    public synchronized Vector<Integer> getBuffer() {
        return buffer;
    }

    public int getFirstInserite() {
        return firstInserite;
    }

    public void incFirstInserite() {
        this.firstInserite++;
    }

    public int getSecondInserite() {
        return secondInserite;
    }

    public void incSecondInserite() {
        this.secondInserite++;
    }

    public int getThirdInserite() {
        return thirdInserite;
    }

    public void incThirdInserite() {
        this.thirdInserite++;
    }

    public int getFirstLette() {
        return firstLette;
    }

    public void incFirstLette() {
        this.firstLette++;
    }

    public int getSecondLette() {
        return secondLette;
    }

    public void incSecondLette() {
        this.secondLette++;
    }

    public int getThirdLette() {
        return thirdLette;
    }

    public void incThirdLette() {
        this.thirdLette++;
    }

    public int getNumGen() {
        return numGen;
    }

    public void setNumGen(int numGen) {
        this.numGen = numGen;
    }
    //=====GET E SET=====
    
    
    //======SEMAFORI====== (sono in ordine di chiamata)
    public void aspettaStampa(){
        try {
            stampa.acquire();
        } catch (InterruptedException ex) {
        }
    }
    
    public void segnalaGenerazioneNumeroPrimo(){
        genPrimo.release();
    }
    
    public void segnalaGenerazioneNumeroSecondo(){
        genSecondo.release();
    }
    
    public void segnalaGenerazioneNumeroTerzo(){
        genTerzo.release();
    }
    
    public void aspettaGenerazioneNumeroPrimo(){
        try {
            genPrimo.acquire();
        } catch (InterruptedException ex) {
        }
    }
    
    public void aspettaGenerazioneNumeroSecondo(){
        try {
            genSecondo.acquire();
        } catch (InterruptedException ex) {
        }
    }
    
    public void aspettaGenerazioneNumeroTerzo(){
        try {
            genTerzo.acquire();
        } catch (InterruptedException ex) {
        }
    }
    
    public void segnalaRicerca(){
        ricerca.release();
    }
    
    public void aspettaRicerca(){
        try {
            ricerca.acquire();
        } catch (InterruptedException ex) {
        }
    }
    
    public void segnalaStampa(){
        stampa.release();
    }
    //====SEMAFORI====== (sono in ordine di chiamata)
}
