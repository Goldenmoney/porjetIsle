/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import static Util.Utils.EtatTuile.COULEE;
import Util.Utils.TypeCarteTresor;
import static Util.Utils.TypeCarteTresor.SAC_DE_SABLE;

/**
 *
 * @author pontalc
 */
public class Carte_Sac extends Carte_Tirage_Tresor {
    
    public Carte_Sac() {
        super(SAC_DE_SABLE);
    }

    
    //envoye les positions de déplcament possible pour le joueur
    // sur l'ihm lorsqu'il clique sur la carte sac de sable
    @Override
    public void action() {
        aventurier.posPosibleAll(COULEE);
    }
}
