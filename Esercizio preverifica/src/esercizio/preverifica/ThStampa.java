/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio.preverifica;

/**
 *
 * @author Davide
 */
public class ThStampa extends Thread {

    DatiCondivisi datiC;

    public ThStampa(DatiCondivisi datiC) {
        this.datiC = datiC;
    }

    @Override
    public void run() {
        int i = 0;

        while (i < datiC.getNumGen()) {
            //aspetto ricerca numeri
            datiC.aspettaRicerca();

            System.out.println("\nValori buffer: ");
            for (int j = 0; j < datiC.getBuffer().size(); j++) {
                System.out.print(datiC.getBuffer().elementAt(j) + "\t");
            }
            System.out.println("\nValore firstInserite: " + datiC.getFirstInserite());
            System.out.println("Valore secondInserite: " + datiC.getSecondInserite());
            System.out.println("Valore thirdInserite: " + datiC.getThirdInserite());
            System.out.println("Valore firstLette: " + datiC.getFirstLette());
            System.out.println("Valore secondLette: " + datiC.getSecondLette());
            System.out.println("Valore thirdLette: " + datiC.getThirdLette() + "\n\n");

            //segnalazione stampa
            datiC.segnalaStampa();
            i++;
        }
        if (Thread.currentThread().isInterrupted())
            return;
    }
}
