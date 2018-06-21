/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author bassetlu
 */
public class Carte_Inond {
    
    // Association
    private Tuile tuile;
    
    // Constructeur
    public Carte_Inond(Tuile tuile) {
        this.tuile = tuile;
    }
    
    // Methode
    public Tuile getTuile() {
        return tuile;
    }
}
