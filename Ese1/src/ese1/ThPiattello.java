/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese1;

/**
 *
 * @author borzi_davide
 */
public class ThPiattello extends Thread {

    private Integer nPiattello;
    private datiCondivisi datiC;

    public ThPiattello(int n, datiCondivisi datiC) {
        nPiattello = n;
        this.datiC = datiC;
    }

    @Override
    public void run() {
        if (nPiattello == 1) {
            datiC.aspettaSparo1();
        } else {
            datiC.aspettaLancio2();
        }
        System.out.println("Piattello" + nPiattello.toString() + " partito");
        
        if (nPiattello == 1) {
            datiC.segnalaLancio1();
        }
        else
            datiC.segnalaLancio2();
    }

}
