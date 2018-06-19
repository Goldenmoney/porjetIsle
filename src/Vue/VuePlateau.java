/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.*;
import Modele.*;
import Util.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class VuePlateau extends JPanel {

    private ArrayList<JButton> buttons;
    private Controleur controleur;
    private ArrayList<Tuile> tuiles;

    public VuePlateau() {
        this.setLayout(new BorderLayout());
        buttons = new ArrayList<>();
        tuiles = new ArrayList<>();
        controleur = new Controleur();
        Grille g = new Grille(tuiles);

        JPanel panelBody = new JPanel(new BorderLayout());

        JPanel panelJeu = new JPanel(new GridLayout(6, 6));
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (g.getTuileCase(x, y) != null && g.getTuileCase(x, y).getEtat() == Utils.EtatTuile.COULEE) {
                    String str = g.getTuileCase(x, y).getNomTuile().toString();
                    JButton button = new JButton(str);
                    Color c=new Color(96,96,96);
                    button.setBackground(c);
                    panelJeu.add(button);
                } else if (g.getTuileCase(x, y) != null && g.getTuileCase(x, y).getEtat() == Utils.EtatTuile.INONDEE) {
                    String str = g.getTuileCase(x, y).getNomTuile().toString();
                    JButton button = new JButton(str);
                    Color c=new Color(102,175,255);
                    button.setBackground(c);
                    panelJeu.add(button);
                } else if (g.getTuileCase(x, y) != null && g.getTuileCase(x, y).getEtat() == Utils.EtatTuile.ASSECHEE) {
                    String str = g.getTuileCase(x, y).getNomTuile().toString();
                    JButton button = new JButton(str);
                    Color c=new Color(255,255,153);
                    button.setBackground(c);
                    panelJeu.add(button);
                } else {
                    JButton button = new JButton();
                    button.setVisible(false);
                    panelJeu.add(button);
                }

            }

//        for (int i = 0; i < 36; i++) {
//            JButton button = new JButton();
//
//            
//            
//            if (i == 0) {
//                button.setVisible(false);
//
//            } else if (i == 1) {
//                button.setVisible(false);
//            } else if (i == 4) {
//               button.setVisible(false);
//            } else if (i == 5) {
//                button.setVisible(false);
//            } else if (i == 6) {
//               button.setVisible(false);
//            } else if (i == 11) {
//                button.setVisible(false);
//            } else if (i == 24) {
//                button.setVisible(false);
//            } else if (i == 29) {
//                button.setVisible(false);
//            } else if (i == 30) {
//                button.setVisible(false);
//            } else if (i == 31) {
//                button.setVisible(false);
//            } else if (i == 34) {
//               button.setVisible(false);
//            } else if (i == 35) {
//               button.setVisible(false);
//            }
//            buttons[i] = button;
            // final int numCase = i;
//            button.addActionListener((ActionEvent e) -> {
//                Message m = new Message();
//                m.type = TypesMessages.JOUER_COUP;
//                m.no_case = numCase;
//                
//                notifierObservateur(m);
            //}};
            //panelJeu.add(button);
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

    public void afficher() {
        JFrame frame = new JFrame();
        frame.setTitle("plateau");
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new VuePlateau());
        frame.setVisible(true);
    }
}
