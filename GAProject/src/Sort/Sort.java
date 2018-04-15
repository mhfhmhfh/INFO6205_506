/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import GA.IndividualNode;
import GA.NatureCondition;
import GA.Population;

/**
 *
 * @author zinanwang
 */
public class Sort {
    
    
    public static int partition(IndividualNode[] list, int low, int high)
	{
		IndividualNode pivot = list[high]; 
		int i = (low-1); // index of smaller element
		for (int j=low; j<high; j++)
		{
			// If current element is smaller than or
			// equal to pivot
			if (list[j].fitness <= pivot.fitness)
			{
				i++;

				// swap arr[i] and arr[j]
				IndividualNode temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		IndividualNode temp = list[i+1];
		list[i+1] = list[high];
		list[high] = temp;

		return i+1;
	}


	/* The main function that implements QuickSort()
	arr[] --> Array to be sorted,
	low --> Starting index,
	high --> Ending index */
	public void sort(IndividualNode[] list, int low, int high)
	{
		if (low < high)
		{
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pi = partition(list, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(list, low, pi-1);
			sort(list, pi+1, high);
		}
                
	}
        
    
}
