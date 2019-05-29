/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio.preverifica;

import java.util.Scanner;

/**
 *
 * @author Davide
 */
public class EsercizioPreverifica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numGen = 0;
        Scanner sc = new Scanner(System.in);
        boolean giusto = false;
        System.out.println("Quanti numeri vuoi generare?");
        numGen = sc.nextInt();

        DatiCondivisi datiC = new DatiCondivisi(numGen);
        ThGenera gen = new ThGenera(datiC);
        ThCerca searchFirst = new ThCerca(datiC, 1);
        ThCerca searchSec = new ThCerca(datiC, 2);
        ThCerca searchThird = new ThCerca(datiC, 3);
        ThStampa stampa = new ThStampa(datiC);

        gen.start();
        searchFirst.start();
        searchSec.start();
        searchThird.start();
        stampa.start();

        try {
            gen.join();
            searchFirst.join();
            searchSec.join();
            searchThird.join();
            stampa.join();

            gen.interrupt();
            searchFirst.interrupt();
            searchSec.interrupt();
            searchThird.interrupt();
            stampa.interrupt();
        } catch (InterruptedException e) {
        }
    }
}
