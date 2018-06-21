/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import static Util.Utils.EtatTuile.INONDEE;
import Util.Utils.TypeCarteTresor;
import static Util.Utils.TypeCarteTresor.HELICOPTERE;

/**
 *
 * @author pontalc
 */
public class Carte_Helico extends Carte_Tirage_Tresor {
    // Constructeur
    public Carte_Helico() {
        super(HELICOPTERE);
    }

    // Envoye les positions de déplcament possible pour le joueur
    // Sur l'ihm lorsqu'il clique sur la carte helico
    @Override
    public void action() {
        aventurier.posPossibleAll(INONDEE);
    }
    
}
