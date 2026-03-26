/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e14;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class L01E14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       float num;
       float med = 0;
       float maior = -1;
       float menor = 100;
       
       Scanner entrada;
       entrada = new Scanner(System.in);
        System.out.print("Digite quantos alunos tem:");
       int n = entrada.nextInt();
       for(int i=0; i<n; i++){
           
           System.out.print("Digite a nota:");
           num = entrada.nextFloat();
           
           if(num>maior)
               maior = num;
           if(num<menor)
               menor = num;
           med+=num;
           
       }
       med=med/n;
       
        System.out.println("Media "+med);
        System.out.println("Maior "+maior);
        System.out.println("Menor "+menor);
    }
    
}
