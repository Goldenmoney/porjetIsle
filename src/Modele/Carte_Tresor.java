/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils.*;

/**
 *
 * @author bassetlu
 */
public class Carte_Tresor extends Carte_Tirage_Tresor {

    // Association
    
    // constructeur
    public Carte_Tresor(TypeCarteTresor type) {
       super(type);
    }
    
    //méthodes
    @Override
    public void action() {
        //rien carte les cartes des trésors n'ont pas d'action elle même
    }
}
