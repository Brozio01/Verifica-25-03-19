/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio.preverifica;

import java.util.Random;

/**
 *
 * @author Davide
 */
public class ThGenera extends Thread {

    DatiCondivisi datiC;

    public ThGenera(DatiCondivisi datiC) {
        this.datiC = datiC;
    }

    @Override
    public void run() {
        System.out.println("esercizio.preverifica.ThGenera.run()");
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            
            while(i < datiC.getNumGen()) {
                //aspetta avvenuta stampa
                datiC.aspettaStampa();

                Random rn = new Random();
                int n = 1 + rn.nextInt(36);
                int temp = n % 3;
                datiC.getBuffer().add(n);

                switch (temp) {
                    case 0:
                        //segnala estrazione numero terzo
                        datiC.segnalaGenerazioneNumeroTerzo();
                        datiC.incThirdInserite();
                        break;

                    case 1:
                        //segnala estrazione numero primo
                        datiC.segnalaGenerazioneNumeroPrimo();
                        datiC.incFirstInserite();
                        break;

                    case 2:
                        //segnala estrazione numero secondo
                        datiC.segnalaGenerazioneNumeroSecondo();
                        datiC.incSecondInserite();
                        break;
                }
                i++;
            }
            if (Thread.currentThread().isInterrupted()) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
