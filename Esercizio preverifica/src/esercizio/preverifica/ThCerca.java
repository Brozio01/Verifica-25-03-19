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
        for (int i = 0; i < datiC.getNumGen(); i++) {
            datiC.aspettaGenerazioneNumero();
            switch (toSearch) {
                case 1:
                    datiC.incFirstLette();
                    break;
                case 2:
                    datiC.incSecondLette();
                    break;
                case 3:
                    datiC.incThirdLette();
                    break;
            }
            datiC.segnalaRicercaNumero();
        }
    }

}
