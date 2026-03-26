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
public class Contador {
    private int valorAtual;
    
    public Contador (){
        this.valorAtual = 0;
    }
    public Contador(int valorAtual){
        this.valorAtual = valorAtual;
    }
    public void setValor(int valor){
        this.valorAtual = valor;
    }
    public void incrementa(){
        this.valorAtual = this.valorAtual+1;
    }
    public int getValor(){
        return this.valorAtual;
    }
}
