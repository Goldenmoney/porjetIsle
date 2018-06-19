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
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.*;
import Util.Utils.*;

public class VuePlateau extends JPanel {

    private ArrayList<JButton> buttons;
   // private ArrayList<Tuile> tuiles;
    private Controleur controleur;//passer parametres

    public VuePlateau() {
        this.setLayout(new BorderLayout());
        buttons = new ArrayList<>();
     //   tuiles = new ArrayList<>();
        controleur=new Controleur();//suppr
        controleur.initGrille(); // suppr 
        Grille g= controleur.getGrille();

        JPanel panelBody = new JPanel(new BorderLayout());

        JPanel panelGrille = new JPanel(new GridLayout(6, 6));
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                Tuile tuile = g.getTuileCase(x, y);

                JButton button = new JButton();

                if (tuile != null) {
                    
                    String str = tuile.getNomTuile().toString();
                    JPanel paneltuile = new JPanel(new BorderLayout());
                    JLabel labelnomTuile = new JLabel(str);
                    paneltuile.add(labelnomTuile, BorderLayout.CENTER);

                    if (tuile.getEtat() == Utils.EtatTuile.COULEE) {
                        Color c = new Color(96, 96, 96);
                        paneltuile.setBackground(c);
                        button.setBackground(c);
                        button.add(paneltuile);
                        panelGrille.add(button);
                    } else if (tuile.getEtat() == Utils.EtatTuile.INONDEE) {

                        Color c = new Color(102, 175, 255);
                        button.setBackground(c);
                        paneltuile.setBackground(c);
                        button.add(paneltuile);
                        panelGrille.add(button);

                    } else if (tuile.getEtat() == Utils.EtatTuile.ASSECHEE) {

                        Color c = new Color(255, 255, 153);
                        paneltuile.setBackground(c);
                        button.setBackground(c);
                        button.add(paneltuile);
                        panelGrille.add(button);

                    }

                    if (tuile.getTypeTresor() == TypeTresor.LA_PIERRE_SACREE) {
                        Label labelTresor = new Label(TypeTresor.LA_PIERRE_SACREE.toString());

                        paneltuile.add(labelTresor, BorderLayout.SOUTH);
                        button.add(paneltuile);
                    } else if (tuile.getTypeTresor() == Utils.TypeTresor.LA_STATUE_DU_ZEPHYR) {
                        Label labelTresor = new Label(TypeTresor.LA_STATUE_DU_ZEPHYR.toString());

                        paneltuile.add(labelTresor, BorderLayout.SOUTH);
                        button.add(paneltuile);
                    } else if (tuile.getTypeTresor() == Utils.TypeTresor.LE_CALICE_DE_LONDE) {
                        Label labelTresor = new Label(TypeTresor.LE_CALICE_DE_LONDE.toString());

                        paneltuile.add(labelTresor, BorderLayout.SOUTH);
                        button.add(paneltuile);
                    } else if (tuile.getTypeTresor() == Utils.TypeTresor.LE_CRISTAL_ARDENT) {
                        Label labelTresor = new Label(TypeTresor.LE_CRISTAL_ARDENT.toString());
                        paneltuile.add(labelTresor, BorderLayout.SOUTH);
                        button.add(paneltuile);
                    }

                } else {
                    button.setVisible(false);
                    panelGrille.add(button);
                }

            }
//            button.addActionListener((ActionEvent e) -> {
//                Message m = new Message();
//                m.type = TypesMessages.JOUER_COUP;
//                m.no_case = numCase;
//                
//                notifierObservateur(m);

            panelBody.add(panelGrille, BorderLayout.CENTER);
            this.add(panelBody);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("plateau");
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new VuePlateau());
        frame.setVisible(true);
    }

    /*public void afficher() {
        JFrame frame = new JFrame();
        frame.setTitle("plateau");
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new VuePlateau());
        frame.setVisible(true);
    }*/
}
