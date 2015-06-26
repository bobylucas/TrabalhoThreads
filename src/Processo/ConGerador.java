/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processo;

import Dado.Informacao;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class ConGerador implements Runnable{
    int porta;
    String msg;    
    ArrayList arrLista;
    int seqControl = 0;
    byte[] arrByte = new byte[100];
    
    public ConGerador(int porta, ArrayList arrLista){
        this.porta    = porta;
        this.arrLista = arrLista;
    }
    
    @Override
    public void run() {
        System.out.println("Conecta com a geração: ");
        try {
            DatagramSocket servidor = new DatagramSocket(porta);
            System.out.println("Servidor");
            do {
                DatagramPacket pacote = new DatagramPacket(arrByte, arrByte.length);
                servidor.receive(pacote);
                msg = new String(pacote.getData());
                Informacao noticia = new Informacao(0, 0, 0);
                System.out.println(msg);
                Informacao info = Informacao.desempacotar(msg);
//                
//                info.setSeq(seqControl);
//                seqControl++;
//                
//                List<Informacao> arrInformacao = (List<Informacao>) arrLista.get(info.getTipo());
//                arrInformacao.add(info);
//                
//                arrByte = new byte[100];
            } while (true);
            
        } catch (Exception ex) {
            Logger.getLogger(ConGerador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
