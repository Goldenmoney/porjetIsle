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
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class VueGrille extends Observe {

    private Controleur controleur;
    private JPanel panelGrille;
    private JPanel panelBody;
    private JButton[][] tableauButton = new JButton[6][6];
    private ArrayList<JButton> buttonsGrille;
    private JPanel panelTuile;
    private Grille grille;

    public VueGrille(Controleur controleur) {

        this.controleur = controleur;
        grille = controleur.getGrille();

        panelBody = new JPanel(new BorderLayout());
        panelGrille = new JPanel(new GridLayout(6, 6));

        buttonsGrille = new ArrayList<JButton>();
        this.afficherGrille();

    }

    public void afficherGrille() {
        int i = 0;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {

                buttonsGrille.add(new JButton());

                tableauButton[x][y] = buttonsGrille.get(i);
                tableauButton[x][y].setEnabled(false);

                Tuile tuile = grille.getTuileCase(x, y);

                if (tuile != null) {

                    String str = tuile.getNomTuile().toString();
                    panelTuile = new JPanel(new BorderLayout());
                    JLabel labelnomTuile = new JLabel(str);
                    panelTuile.add(labelnomTuile, BorderLayout.CENTER);

                    panelGrille.add(tableauButton[x][y]);
                    tableauButton[x][y].add(panelTuile);

                    if (tuile.getEtat() == Utils.EtatTuile.COULEE) {
                        Color c = new Color(96, 96, 96);
                        panelTuile.setBackground(c);
                        tableauButton[x][y].setBackground(c);

                    } else if (tuile.getEtat() == Utils.EtatTuile.INONDEE) {

                        Color c = new Color(102, 175, 255);
                        tableauButton[x][y].setBackground(c);
                        panelTuile.setBackground(c);

                    } else if (tuile.getEtat() == Utils.EtatTuile.ASSECHEE) {

                        Color c = new Color(255, 255, 153);
                        panelTuile.setBackground(c);
                        tableauButton[x][y].setBackground(c);

                    }

                    if (tuile.getTypeTresor() == TypeTresor.LA_PIERRE_SACREE) {

                        Label labelTresor = new Label(TypeTresor.LA_PIERRE_SACREE.toString());
                        panelTuile.add(labelTresor, BorderLayout.SOUTH);

                    } else if (tuile.getTypeTresor() == Utils.TypeTresor.LA_STATUE_DU_ZEPHYR) {

                        Label labelTresor = new Label(TypeTresor.LA_STATUE_DU_ZEPHYR.toString());
                        panelTuile.add(labelTresor, BorderLayout.SOUTH);

                    } else if (tuile.getTypeTresor() == Utils.TypeTresor.LE_CALICE_DE_LONDE) {

                        Label labelTresor = new Label(TypeTresor.LE_CALICE_DE_LONDE.toString());
                        panelTuile.add(labelTresor, BorderLayout.SOUTH);

                    } else if (tuile.getTypeTresor() == Utils.TypeTresor.LE_CRISTAL_ARDENT) {

                        Label labelTresor = new Label(TypeTresor.LE_CRISTAL_ARDENT.toString());
                        panelTuile.add(labelTresor, BorderLayout.SOUTH);

                    }
                    this.affichePion(tuile);

                } else {
                    tableauButton[x][y].setVisible(false);
                    panelGrille.add(tableauButton[x][y]);
                }
                final int caseX = x;
                final int caseY = y;

                tableauButton[x][y].addActionListener((ActionEvent e) -> {
                    Message m = new Message();
                    m.type = TypesMessages.SE_DEPLACER_VERS;
                    m.uneCaseX = caseX;
                    m.uneCaseY = caseY;
                    notifierObservateur(m);
                    System.out.println("J'envoie X : " + caseX);
                    System.out.println("J'envoie Y : " + caseY);
                });
                i++;
            }
            panelBody.add(panelGrille, BorderLayout.CENTER);
            panelBody.setVisible(true);
        }
    }

    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setTitle("plateau");
//        frame.setSize(1000, 800);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(new VueGrille(controleur).getPanelBody());
//        frame.setVisible(true);
    }

    public JPanel getPanelBody() {
        return panelBody;
    }

    public void affichePion(Tuile tuile) {
        JPanel pion = new JPanel(new GridLayout(2, 1));
        for (Aventurier joueur : controleur.getAventuriers()) {
            if (joueur.getTuile() == tuile) {

                panelTuile.add(pion, BorderLayout.EAST);

                Graphics g = panelGrille.getGraphics();
                CerclePion cerclePion = new CerclePion();
                cerclePion.setColor(joueur.getCouleur().getCouleur());
                pion.add(cerclePion);

                JLabel filler = new JLabel("         ");
                pion.add(filler);
                filler.setVisible(false);
                pion.setBackground(panelTuile.getBackground());
            }
        }
    }

    public void affichePosPossible(ArrayList<Tuile> tuilesPossibles) {
        // Mets les bouttons pas activés
        for (int i = 0; i < this.buttonsGrille.size(); i++) {
            this.buttonsGrille.get(i).setEnabled(false);
        }

        // Cherche les boutons associés aux tuiles possibles
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {

                for (int i = 0; i < tuilesPossibles.size(); i++) {

                    if (tuilesPossibles.get(i).getPosX() == x
                            && tuilesPossibles.get(i).getPosY() == y) {

                        tableauButton[x][y].setBorder(new LineBorder(Color.red, 5));
                        tableauButton[x][y].setEnabled(true);

                    }
                }

            }
        }
    }

    public class CerclePion extends JPanel {

        Color color;

        public void setColor(Color color) {
            this.color = color;
        }

        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            drawCenteredCircle(g, 20, 20, 27);
            g.setColor(color);
            drawCenteredCircle(g, 20, 20, 25);
        }
    }

    public void drawCenteredCircle(Graphics g, int x, int y, int r) {
        x = x - (r / 2);
        y = y - (r / 2);
        g.fillOval(x, y, r, r);
    }
}
