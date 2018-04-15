/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import GA.IndividualNode;

/**
 *
 * @author zinanwang
 */
public class QuickSort {
    
    public static void quickSort(IndividualNode begin, IndividualNode end){
        if(begin == null || begin == end)
            return;
        
        IndividualNode index = paration(begin, end);
        quickSort(begin, index);
        quickSort(index.next, end);
    }
    
    /**
     * @param begin
     * @param end
     * @return
     */
    public static IndividualNode paration(IndividualNode begin, IndividualNode end){
        if(begin == null || begin == end)
            return begin;
        
        float val = begin.fitness;  
        IndividualNode index = begin, cur = begin.next;
        
        while(cur != end){
            if(cur.fitness < val){ 
                index = index.next;
                float tmp = cur.fitness;
                cur.fitness = index.fitness;
                index.fitness = tmp;
            }
            cur = cur.next;
        }
        
        
        begin.fitness = index.fitness;
        index.fitness = val;
        
        return index;
    }
    
}
