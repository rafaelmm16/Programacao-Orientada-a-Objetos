/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e07;

import java.util.Scanner;
/**
 *
 * @author Rafael
 */
public class L01E07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        float nota1, nota2, nota3;
        float media, i, contAluno = 0;
        
        for(i = 0; i < 3; i++){
            
            contAluno++;
            // recebe a 1º nota
            System.out.println("Aluno " + contAluno + ", 1ª nota");
            nota1 = ent.nextInt();
            
            // recebe a 2º nota
            System.out.println("Aluno " + contAluno + ", 2ª nota");
            nota2 = ent.nextInt();
            
            // recebe a 3º nota
            System.out.println("Aluno " + contAluno + ", 3ª nota");
            nota3 = ent.nextInt();
            
            // calcula a média
            media = (nota1 + nota2 + nota3) / 3;
            System.out.println("A média do aluno " + contAluno + " é " + media);
            
            // mostra a nota do aluno
            if( (media >= 0) && (media <4) ){
                System.out.println("Reprovado");
            } else if((media >= 4) && (media<7)) {
                System.out.println("De final");
            } else if(media >= 7){
                System.out.println("Aprovado");
            }
        }       
    }
    
}
