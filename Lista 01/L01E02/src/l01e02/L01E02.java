/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e02;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class L01E02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    int lado1, lado2, lado3;
    int opcao = 1;

    while (opcao == 1) {
        Scanner s = new Scanner(System.in);

        System.out.println("Entre com o lado 1:");
        lado1 = s.nextInt();
        System.out.println("Entre com lado 2:");
        lado2 = s.nextInt();
        System.out.println("Entre com lado 3:");
        lado3 = s.nextInt();

        if ((lado1 < lado2 + lado3) && (lado2 < lado1 + lado3) && (lado3 < lado1 + lado2)) {
            if (lado1 == lado2 && lado1 == lado3) {
                System.out.println("Triangulo Equilatero");
            } else if ((lado1 == lado2) || (lado1 == lado3)) {
                System.out.println("Triangulo Isosceles");
            } else
                System.out.println("Triângulo Escaleno");
        } else {
            System.out.println("Não é um triangulo!");
        }
        System.out.println("Deseja continuar? 1 = sim, 2 = não");
        opcao = s.nextInt();
    }
} 
}
