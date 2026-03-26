/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e13;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class L01E13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int num;
       Scanner entrada;
       while(true){
           entrada = new Scanner(System.in);
           System.out.print("Digite aqui:");
           num = entrada.nextInt();
           if(num==0)
               break;
           System.out.println(num*num);
       }
    }
    
}
