/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula.pkg12.pkg05.pkg21;

/**
 *
 * @author Rafael
 */
public class Aula120521 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Contador meuContador = new Contador();
        
        meuContador.setValor(1);
        meuContador.incrementa();
        meuContador.incrementa();
        meuContador.incrementa();
        System.out.println("Valor atual: "+meuContador.getValor());
        
        Contador segundoCont = new Contador(5);
        segundoCont.incrementa();
        segundoCont.incrementa();
        System.out.println("Segundo valor: "+segundoCont.getValor());
    }
    
}
