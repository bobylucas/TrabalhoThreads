/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processo;

/**
 *
 * @author lucas
 */
public class Gerador {
    
    public static void main(String[] args) {
        int max, min, tmax, tmin, count, port;
        
        min = tmin = 1000;
        max = tmax = 2000;
        port = 2006;
        
        System.out.println("Inicia a geração de daddos.");
        for (count = 0; count <= 5; count++) {
            System.out.println("Geração: " + count);
            GeradorThread geraThread = new GeradorThread(min, max, tmin, tmax, count, port);
            new Thread(geraThread).start();
        }
    }
}
