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
public class ThInput extends Thread {
    
    datiCondivisi datiC;
    String str;
    
    public ThInput(datiCondivisi datiC) {
        this.datiC = datiC;
        str = "";
    }

    @Override
    public void run() {
        //aspetto avvenuta stampa
        datiC.aspettaAvvenutaStampa();
        
        //aspetto input da utente
        datiC.aspettaAvvenutoInput();
        
        //aggiorno str condiviso
        datiC.setStr(str);
        
        //segnalo avvenuto aggiornamento (x2)
        datiC.segnalaAvvenutoAggiornamento();
    }
    
    public void setString(String s){
        str += s;
    }
    
}
