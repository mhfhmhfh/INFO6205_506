/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GA.GeneAlgorithm;
import GA.IndividualNode;
import GA.Population;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zinanwang
 */
public class GATest { 
    
    public GATest() {
    }
    
    @Test
    public void initTest(){
    
        GeneAlgorithm ga = new GeneAlgorithm();
        Population list = new Population();
        ga.createBeginningSpecies(list);
        int count =0;
        IndividualNode point = list.head;
        while (point.next!=null) {            
            count++;
            point = point.next;
            assertEquals(point.genes.length, 31);
        }
        
        assertEquals(count, 200);
    }
    
    @Test
    public void selectTest(){
    
        GeneAlgorithm ga = new GeneAlgorithm();
        Population list = new Population();
        ga.createBeginningSpecies(list);
        float before = list.avgDistance();
        ga.select(list);
        float after = list.avgDistance();
        
        assert(before>after);
    }
    
    @Test
    public void crossoverTest(){
        GeneAlgorithm ga = new GeneAlgorithm();
        Population list = new Population();
        Population list2 = new Population();
        
        float before = list.avgDistance();
        ga.createBeginningSpecies(list);
        
        ga.crossover(list);
        
        float after = list.avgDistance();
        
        assert(before != after);
        
    }
    
    
}
