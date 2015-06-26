/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processo;

import Dado.Informacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Difusor {
    public static void main(String[] args) {
        
        List<Informacao> lista0 = new  ArrayList();
        List<Informacao> lista1 = new  ArrayList();
        List<Informacao> lista2 = new  ArrayList();
        List<Informacao> lista3 = new  ArrayList();
        List<Informacao> lista4 = new  ArrayList();
        List<Informacao> lista5 = new  ArrayList();
        
        ArrayList arrInformacao = new ArrayList();
        arrInformacao.add(lista0);
        arrInformacao.add(lista1);
        arrInformacao.add(lista2);
        arrInformacao.add(lista3);
        arrInformacao.add(lista4);
        arrInformacao.add(lista5);
        
        System.out.println("Inicia a Difusao: ");
        ConGerador conGerador = new ConGerador(2006, arrInformacao);
        new Thread(conGerador).start();
    }
}
