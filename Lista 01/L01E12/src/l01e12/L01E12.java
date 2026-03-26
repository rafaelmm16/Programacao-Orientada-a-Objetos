/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e12;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class L01E12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean achou = false;
        int i = 1;
        int num1;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("DIgite um numero:");
        num1 = entrada.nextInt();
        for (i = 1; i * (i + 1) * (i + 2) <= num1; i++) {
            if (i * (i + 1) * (i + 2) == num1) {
                achou = true;
                System.out.print("É triangular");
            }
        }
        if(!achou)
            System.out.println("Não é triangular");
    }
    
}
