/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processo;

import Dado.Informacao;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class GeradorThread implements Runnable{
    int max, min, tmin, tmax;
    
    String host = "localhost";
    int porta;
    
    Random nrRandom = new Random();
    byte[] arrByte;
    String msg;
    int tipo;
    
    public GeradorThread(int min, int max, int tmin, int tmax, int tipo, int porta) {
        this.max   = max;
        this.min   = min;
        this.tmax  = tmax;
        this.tmin  = tmin;
        this.tipo  = tipo;
        this.porta = porta;
    }
    
    @Override
    public void run() {
        try {
            DatagramSocket cliSocket = new DatagramSocket();
            InetAddress    ipAdress  = InetAddress.getByName(host);
            do {
                Informacao info = new Informacao(0, tipo, nrRandom.nextInt(max - min) + min);
                System.out.println("Empacotar...");
                msg     = info.empacotar();
                arrByte = msg.getBytes();
                
                DatagramPacket pacote = new DatagramPacket(arrByte, arrByte.length, ipAdress, porta);
                
                System.out.println("Enviar pacote (tipo "+ tipo +")..." + new String(pacote.getData()));
                cliSocket.send(pacote);
                Thread.sleep(nrRandom.nextInt(tmax - tmin) + tmin);
            } while (true);
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(GeradorThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
