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
        for (int i = 0; i < datiC.getNumGen(); i++) {
            //aspetta avvenuta stampa
            datiC.aspettaStampa();
            Random rn = new Random();
            int n = 1 + rn.nextInt(36);

            for (int j = 0; j < datiC.getBuffer().size(); j++) {
                if (datiC.getBuffer().elementAt(j) == n) {
                    n = 1 + rn.nextInt(36);
                }
            }

            int temp = n % 3;
            datiC.getBuffer().add(n);
            switch (temp) {
                case 0:
                    datiC.incThirdInserite();
                    break;

                case 1:
                    datiC.incFirstInserite();
                    break;

                case 2:
                    datiC.incSecondInserite();
                    break;
            }
            datiC.segnalaGenerazioneNumero();
        }
    }
}
