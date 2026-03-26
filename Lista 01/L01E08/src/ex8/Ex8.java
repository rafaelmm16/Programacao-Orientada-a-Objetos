package ex8;
import java.util.Scanner;
/**
 *
 * @author Rafael
 */
public class Ex8 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float saldoAtual = 0, lido;
        int opcao;        
        while(true){
            System.out.printf("Bem vindo ao banco!\nOperações disponíveis:\n"
                + "[0] Débito\n[1] Crédito\n[2] Sair\nSelecione uma opção: ");
            opcao = ler.nextInt();
            if(opcao==0){
                System.out.printf("Digite quanto deseja debitar de seu saldo: ");
                lido = ler.nextFloat();
                saldoAtual-=lido;
            }
            else if(opcao==1){
                System.out.printf("Digite quanto deseja creditar em seu saldo: ");
                lido = ler.nextFloat();
                saldoAtual+=lido;
            }
            else if(opcao==2) break;
            else System.out.println("Opção inválida! Tente novamente.");
        }
        System.out.printf("Saldo final: %.2f\n", saldoAtual);
    }
    
}
