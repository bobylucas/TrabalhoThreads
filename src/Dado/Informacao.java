/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dado;

import java.util.Arrays;

/**
 *
 * @author lucas
 */
public class Informacao {
    private int seq;
    private int tipo;
    private int valor;
    
    public Informacao(int seq, int tipo, int valor) {
        this.seq   = seq;
        this.tipo  = tipo;
        this.valor = valor;
    }

    private Informacao() {
        
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
  
    /* método para empacotar os atributos do objeto para comunicação */
    public String empacotar() {       
        
        int[] msg = new int[3];
        msg[0] = seq;
        msg[1] = tipo;
        msg[2] = valor;
        
        System.out.println(Arrays.toString(msg));
        
        return Arrays.toString(msg);
    }
    
    /* método para desempacotar atributos e retornar uma Informacao (String msg)*/
    public static Informacao desempacotar(String pacote) {
        System.out.println("Desenpacotar: " + pacote);
        pacote = pacote.replace("[", "");                
        pacote = pacote.replace("]", "");
        String[] msg = pacote.split(",");
        if (msg.length > 0) {
            return new Informacao(Integer.valueOf(msg[0]),
                                             Integer.valueOf(msg[1]),
                                             Integer.valueOf(msg[2]));
        } else
            return null;
    }
}
