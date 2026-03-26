/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e06;

/**
 *
 * @author Rafael
 */
public class L01E06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        int aux = 0;
        int tam = 10;
        int[] vet = new int[tam];
        
        for(i=0; i<10; i++){
           vet[i] = (int) (Math.random() * 100); // valor aleatório entre 0 e 100
           System.out.println(vet[i]);
      
        }
        
        for(i = 0; i<10; i++){
		for(int j = 0; j<9; j++){
			if(vet[j] > vet[j + 1]){
				aux = vet[j];
				vet[j] = vet[j+1];
				vet[j+1] = aux;
			}
		}
	}
	System.out.println("Organizado:");
	for(i = 0; i<10; i++){
		System.out.println(" "+vet[i]);
	}
    }
    
}
