/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

import Sort.Sort;

/**
 *
 * @author zinanwang
 */
public class Main {

    public static void main(String[] args) {
        
        GeneAlgorithm GA = new GeneAlgorithm();
        
        Population speciesList = new Population();

        IndividualNode bestRate = GA.run(speciesList);

        bestRate.printRate();
    }

}
