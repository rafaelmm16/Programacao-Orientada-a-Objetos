/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l01e04;

/**
 *
 * @author Rafael
 */
public class L01E04 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        int tam =10;
        int[][] mat = new int[10][10];
        
        for(int j=0; j<10; j++){
            for(int k=0; k<10; k++){
                if(j==k)
                    mat[j][k]=1;
                else
                    mat[j][k]=0;
        }
    }
        for(int j=0; j<10; j++){
            for(int k=0; k<10; k++){
                System.out.print(mat[j][k]);
        }
            System.out.println("");
    }
    
}
}