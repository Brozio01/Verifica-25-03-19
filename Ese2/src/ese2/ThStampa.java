/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese2;

/**
 *
 * @author borzi_davide
 */
public class ThStampa extends Thread{
    
    datiCondivisi datiC;

    public ThStampa(datiCondivisi datiC) {
        this.datiC = datiC;
    }

    @Override
    public void run() {
        //aspetto avvenuta ricerca (x2)
        datiC.aspettaAvvenutaRicerca();
        
        //prelevo vettore condiviso e visualizzo contenuto
        for (int i = 0; i < datiC.getVect().size(); i++) {
            System.out.println(datiC.getVect().elementAt(i).toString());
        }
        
        //svuoto vettore
        datiC.getVect().clear();
        
        //segnalo avvenuta stampa
        datiC.segnalaAvvenutaStampa();
    }
    
    
}
