/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

import Sort.QuickSort;

/**
 *
 * @author zinanwang
 */
public class Main {

    public static void main(String[] args) {
        GeneAlgorithm GA = new GeneAlgorithm();

//		Population speciesList=new Population();
//
//		IndividualNode bestRate=GA.run(speciesList);
//
//		bestRate.printRate();
        Population test = new Population();
        GA.createBeginningSpecies(test);
        GA.calRate(test);
        test.traverse();

        IndividualNode head = test.head;
        IndividualNode p = test.head;

        while (p.next != null) {
            System.out.print(p.fitness+"    ");
            p = p.next;
        }
        System.out.print(p.fitness);
        System.out.println();

        IndividualNode begin = head, end = p;
        QuickSort.quickSort(head, p);

        p = head;
        while (p != null) {
            System.out.print(p.fitness+"    ");
            p = p.next;
        }

    }

}
