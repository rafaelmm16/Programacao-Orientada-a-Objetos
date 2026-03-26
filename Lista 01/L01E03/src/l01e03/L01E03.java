/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e03;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class L01E03 {
    
    public static boolean eprimo(int num) {
        int primos = 0;
        int i;
        
        if(num<1)
            return false;
        
        for(i=1; i<=num; i++){
            if(num%i==0)
                primos++;
        }
        if(primos>2)
            return false;
        else
            return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int tam = 4;
        int i;
        int[] vet = new int[tam];
        
        for(i=0; i<tam; i++){
            System.out.print("Digite aqui: ");
            vet[i] = entrada.nextInt();
        }
        for(i=0; i<tam; i++){
            if(eprimo(vet[i]))
                System.out.println(vet[i]+" É primo");
        }
    }
    
}
