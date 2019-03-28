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
public class ThCerca extends Thread{
    
    datiCondivisi datiC;
    int vettDaCercare;  //1 --> google, 2 --> cache
    String str;

    public ThCerca(datiCondivisi datiC, int vettDaCercare) {
        this.datiC = datiC;
        this.vettDaCercare = vettDaCercare;
        str = "";
    }

    @Override
    public void run() {
        //aspetto avvenuto input (x2)
        if (vettDaCercare == 1) {
            datiC.aspettaAvvenutoAggiornamento1();
        }
        else
            datiC.aspettaAvvenutoAggiornamento2();
        
        //prelevo la stringa da cercare, cerco nei vettori e aggiorno vettore
        str = datiC.getStr();
        
        if (vettDaCercare == 1) {
            for (int i = 0; i < datiC.getGoogle().length; i++) {
                if (datiC.getGoogle()[i].contains(str)) {
                    datiC.setVect(datiC.getGoogle()[i]);
                }
            }
        }
        else{
            for (int i = 0; i < datiC.getCache().length; i++) {
                if (datiC.getCache()[i].contains(str)) {
                    datiC.setVect(datiC.getCache()[i]);
                }
            }
        }
        
        //segnalo avvenuta ricerca
        datiC.segnalaAvvenutaRicerca();
    }
    
    
    
}
