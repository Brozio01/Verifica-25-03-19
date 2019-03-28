/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese1;

import java.util.Scanner;

/**
 *
 * @author borzi_davide
 */
public class Ese1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String c = "";
        
        do {            
            System.out.println("Inserisci P per lanciare i piattelli");
            c = sc.nextLine().toUpperCase();
            
            if (c != "P") {
                System.out.println("Errore di input!");
            }
        } while (c != "P");
        c = "";
        //lancio piattelli
        
        do {            
            System.out.println("Inserisci S per sparare il primo proiettile");
            c = sc.nextLine().toUpperCase();
            
            if (c != "S") {
                System.out.println("Errore di input!");
            }
        } while (c != "S");
        c = "";
        //sparo primo primo proiettile
        
        do {            
            System.out.println("Inserisci S per sparare il primo proiettile");
            c = sc.nextLine().toUpperCase();
            
            if (c != "S") {
                System.out.println("Errore di input!");
            }
        } while (c != "S");
        c = "";
        
        //sparo secondo proiettile
        
    }
    
}
