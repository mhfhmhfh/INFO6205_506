/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import GA.GeneAlgorithm;
import GA.IndividualNode;
import GA.NatureCondition;
import GA.Population;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author zinanwang
 */
public class MyPanel extends JPanel {

    public void paintComponent(Graphics g) {

        GeneAlgorithm GA = new GeneAlgorithm();

        Population speciesList = new Population();

        IndividualNode bestRate = GA.run(speciesList);

        bestRate.printRate();

        super.paintComponent(g);

        int x[] = new int[NatureCondition.CITY_NUM];
        int y[] = new int[NatureCondition.CITY_NUM];

        for (int i = 0; i < NatureCondition.CITY_NUM; i++) {
            x[i] = NatureCondition.cityPosition[i][0];
            y[i] = NatureCondition.cityPosition[i][1];
            g.fillOval(x[i] / 10, y[i] / 10, 5, 5);
            g.drawString(String.valueOf(i), x[i] / 10, y[i] / 10);
        }

        for(int i=0;i<NatureCondition.CITY_NUM-1;i++){
            int index = Integer.parseInt(bestRate.genes[i])-1;
            int index2 = Integer.parseInt(bestRate.genes[i+1])-1;
            
            g.drawLine(x[index]/10, y[index]/10, x[index2]/10, y[index2]/10);
        }
    }

}
