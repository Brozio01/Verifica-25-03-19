/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese2;

import java.util.Scanner;

/**
 *
 * @author borzi_davide
 */
public class Ese2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String s = "";
        datiCondivisi datiC = new datiCondivisi();
        ThInput input = new ThInput(datiC);
        ThCerca cerca1 = new ThCerca(datiC, 1);
        ThCerca cerca2 = new ThCerca(datiC, 2);
        ThStampa stampa = new ThStampa(datiC);
        
        do {
            s += sc.nextLine();
            //setStr
            
            //segnalo avvnuto input
            s = "";
        } while (s.equals("\n"));
        
        
    }
    
}
