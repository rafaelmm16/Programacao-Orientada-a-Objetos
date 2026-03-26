/*
 *Desenvolver em Java um método que simule jogos da mega sena com seis dezenas de 1 a 60 em cada aposta.
O programa deverá usar esse método após solicitar ao usuário quantas apostas deseja realizar. 
Ficar atento para que caso sejam sorteadas dezenas repetidas deve-se refazer os sorteios de novas dezenas
até que as seis dezenas sejam diferentes dentro de cada aposta.  
Guardar em um vetor a última aposta produzida e em uma matriz todas as apostas solicitadas pelos usuário.
Imprimir as apostas.
Dicas:
Utilizar os comandos Random gerador = new Random();
gerador.nextInt(61);
em um método para gerar em um vetor as seis dezenas.
 */
package atividade.pkg05_07_2021;

import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

/**
 *
 * @author Rafael
 */
public class atividade05_07_2021 {

    public static void MegaSena(int n){
        Scanner teclado= new Scanner(System.in);
        int Menor=1, Maior=60;
        int sorteados[]= new int[6];
        int apostas[][];
        int i,j;
        String res;
        apostas=new int[n][6];
        for(i=0; i<6; i++){
            int ale=(int) (Menor+Math.random()*(Maior-Menor));
            for(j=0; j<i; j++){
                if(ale==sorteados[j]){
                    break;
                }
            }
            if(j==i)
                sorteados[i]=ale;
        }
        
        for(i=0; i<n; i++){
            System.out.printf("Digite a %d° aposta:\n",i+1);
            for(j=0; j<6; j++){
               apostas[i][j]= teclado.nextInt(); 
            }
        }
        System.out.println("----------------------------------------");
        System.out.print("Numeros sorteados: [ ");
        for(i=0; i<6; i++){
            System.out.printf("%d ",sorteados[i]);
        }
        System.out.println("]");
        System.out.println("----------------------------------------");
        System.out.println("\t\tApostas \n");
        for(i=0; i<n; i++){
            System.out.printf("Aposta %d: [ ",i+1);
            for(j=0; j<6; j++){
                System.out.printf("%d ",apostas[i][j]);
            }
            System.out.println("]");
        }
    
    }
    
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        int n;
        
        //System.out.print("Digite a quantidade de apostas: ");
        //int n=teclado.nextInt();
        String q= JOptionPane.showInputDialog(null,
                 "Digite a quantidade de apostas: ", 
                 "Serie Fibonacci",QUESTION_MESSAGE);
       n = Integer.parseInt(q);
       MegaSena(n);
        
   }    
    
}
