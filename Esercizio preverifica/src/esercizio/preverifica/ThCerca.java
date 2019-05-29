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
public class ThCerca extends Thread {

    private DatiCondivisi datiC;
    private int toSearch;

    public ThCerca(DatiCondivisi datiC, int toSearch) {
        this.datiC = datiC;
        this.toSearch = toSearch;
    }

    @Override
    public void run() {
        System.out.println("esercizio.preverifica.ThCerca.run()");
        int i = 0;
        
        while (!Thread.currentThread().isInterrupted()) {
            while(i < datiC.getNumGen()) {

                switch (toSearch) {
                    case 1:
                        //aspetta la segnalazione dell'estrazione di un numero primo
                        datiC.aspettaGenerazioneNumeroPrimo();
                        datiC.incFirstLette();
                        break;

                    case 2:
                        //aspetta la segnalazione dell'estrazione di un numero secondo
                        datiC.aspettaGenerazioneNumeroSecondo();
                        datiC.incSecondLette();
                        break;

                    case 3:
                        //aspetta la segnalazione dell'estrazione di un numero terzo
                        datiC.aspettaGenerazioneNumeroTerzo();
                        datiC.incThirdLette();
                        break;
                }

                //segnala al thread stampa che la ricerca è avvenuta
                datiC.segnalaRicerca();
                i++;
            }
            if (Thread.currentThread().isInterrupted()) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
