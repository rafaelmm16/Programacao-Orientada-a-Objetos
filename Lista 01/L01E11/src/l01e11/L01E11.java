/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e11;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class L01E11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int valor = 0;
        int x = teclado.nextInt();

        for (int j = 1; j < x; j++) {

        if (x % j == 0) 
                valor += j;

        }
        if (valor == x) 
                System.out.println("Numero perfeito");
         else 
                System.out.println("Não é numero perfeito");
    }
    
}
