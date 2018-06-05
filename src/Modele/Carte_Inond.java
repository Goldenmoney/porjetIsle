/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Tuile;

/**
 *
 * @author bassetlu
 */
public class Carte_Inond extends Cartes {
    
    // Associations
    private Tuile tuile;
    
    // METHODES

    public Carte_Inond(Tuile tuile) {
        this.tuile = tuile;
    }

    public Tuile getTuile() {
        return tuile;
    }
}
