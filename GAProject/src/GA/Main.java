/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

import Sort.Sort;
import Visual.MyPanel;
import javax.swing.JFrame;

/**
 *
 * @author zinanwang
 */
public class Main {

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setTitle("");
        f.getContentPane().add(new MyPanel());
        f.setSize(1000, 640);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
