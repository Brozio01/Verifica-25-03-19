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
        datiCondivisi datiC = new datiCondivisi();
        ThPiattello piattello1 = new ThPiattello(1);
        ThPiattello piattello2 = new ThPiattello(2);
        ThProiettile proiettile1 = new ThProiettile(1, datiC);
        ThProiettile proiettile2 = new ThProiettile(2, datiC);
                
        do {            
            System.out.println("Inserisci P per lanciare i piattelli");
            c = sc.nextLine().toUpperCase();
            
            if (c != "P") {
                System.out.println("Errore di input!");
            }
        } while (c != "P");
        c = "";
        
        //lancio piattelli
        piattello1.run();
        piattello2.run();
        
        do {            
            System.out.println("Inserisci S per sparare il primo proiettile");
            c = sc.nextLine().toUpperCase();
            
            if (c != "S") {
                System.out.println("Errore di input!");
            }
        } while (c != "S");
        c = "";
        
        //sparo primo primo proiettile
        proiettile1.run();
        if (datiC.isColpito1()) {
            System.out.println("Proiettile1 colpisce piattello1");
            System.out.println("Piattello1 si disintegra");
        }
        
        do {            
            System.out.println("Inserisci S per sparare il primo proiettile");
            c = sc.nextLine().toUpperCase();
            
            if (c != "S") {
                System.out.println("Errore di input!");
            }
        } while (c != "S");
        c = "";
        
        //sparo secondo proiettile
        proiettile2.run();
        if (datiC.isColpito2()) {
            System.out.println("Proiettile2 colpisce piattello2");
            System.out.println("Piattello2 si disintegra");
        }
        
        if (datiC.isColpito1() && datiC.isColpito2()) {
            System.out.println("Tutti i piattello disintegrati");
        }
    }
}
