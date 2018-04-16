/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

/**
 *
 * @author zinanwang
 */
public class Gene {
    
    public static String encode(int city){
        int a = city % 4;
        int a1 = city/4;
        int b = a1 % 4;
        int b1 = a1/4;
        int c = b1 % 4;
        
        String aa = DNA.getKey(a);
        String bb = DNA.getKey(b);
        String cc = DNA.getKey(c);
             
        String genecode = "A"+cc+bb+aa;
        
        return genecode;
    }
    
}
