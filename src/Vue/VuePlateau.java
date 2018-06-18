/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class VuePlateau extends JPanel {

    private JButton buttons[] = new JButton[36];

    public VuePlateau() {
        this.setLayout(new BorderLayout());
        JPanel panelBody = new JPanel(new BorderLayout());

        JPanel panelJeu = new JPanel(new GridLayout(6, 6));

        for (int i = 0; i < 36; i++) {
            JButton button = new JButton();

           
            if (i == 0) {
                button.setVisible(false);

            } else if (i == 1) {
                button.setVisible(false);
            } else if (i == 4) {
               button.setVisible(false);
            } else if (i == 5) {
                button.setVisible(false);
            } else if (i == 6) {
               button.setVisible(false);
            } else if (i == 11) {
                button.setVisible(false);
            } else if (i == 24) {
                button.setVisible(false);
            } else if (i == 29) {
                button.setVisible(false);
            } else if (i == 30) {
                button.setVisible(false);
            } else if (i == 31) {
                button.setVisible(false);
            } else if (i == 34) {
               button.setVisible(false);
            } else if (i == 35) {
               button.setVisible(false);
            }

            buttons[i] = button;
            // final int numCase = i;
//            button.addActionListener((ActionEvent e) -> {
//                Message m = new Message();
//                m.type = TypesMessages.JOUER_COUP;
//                m.no_case = numCase;
//                
//                notifierObservateur(m);
            //}};

            panelJeu.add(button);
        }

        panelBody.add(panelJeu, BorderLayout.CENTER);
        this.add(panelBody);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("plateau");
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new VuePlateau());
        frame.setVisible(true);
    }
}
