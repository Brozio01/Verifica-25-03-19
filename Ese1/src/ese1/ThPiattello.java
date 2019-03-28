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

    public ThPiattello(int n) {
        nPiattello = n;
    }

    @Override
    public void run() {
        System.out.println("Piattello" + nPiattello.toString() + " partito");
    }

}
