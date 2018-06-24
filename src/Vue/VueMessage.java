/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class VueMessage extends Observe {

    private Controleur controleur;
    private JFrame fenetre;

    public VueMessage(Controleur controleur) {
        JOptionPane jop1;
        jop1 = new JOptionPane();
        ImageIcon img = new ImageIcon("images/information-icon.png");
        jop1.showMessageDialog(null, "Vous avez pioché une carte inondation \n LE NIVEAU DE L'EAU MONTE !", "Information", JOptionPane.INFORMATION_MESSAGE, img);
    }

    public static void main(String[] args) {

    }

}
