/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porjetisle;

import java.util.ArrayList;

/**
 *
 * @author bassetlu
 */
public class Grille {
    // Associations
    private ArrayList<Tuile> tuiles;
    
    // METHODES

    public Grille(ArrayList<Tuile> tuiles) {
        this.tuiles = tuiles;
    }
    
    public void initGrille() {
        ////
    }

    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }  
}
