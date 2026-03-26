/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e09;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class L01E09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       double quilowatt;
	double valor;
	double salario;
	double desconto;
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("Valor de gasto em quilowatt");
	quilowatt = input.nextDouble();
	
	System.out.println("Valor do salario minimo");
	salario = input.nextDouble();
	
		if (salario<=400){
			System.out.println("Valor do salario errado, insira novamente.");
		return;
	}
	//calcula o kilowatt hora
	salario = (salario/8)*1;
	salario = salario/100;
	
	//calcula o valor total a ser pago
	valor = quilowatt*salario/1;
	
	//calcula o valor com desconto de 15%
	desconto = (0.15*valor);
	
	System.out.println("Valor a ser pago de cada kilowatt :"+salario);
	System.out.println("Valor a ser pago :"+valor);
	System.out.println("Valor a ser pago com desconto :"+(valor-desconto));
    }
    
}
