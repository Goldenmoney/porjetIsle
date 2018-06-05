/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author bassetlu
 */
public class Grille {
    // Associations
//je fais la grille (jules)
    private ArrayList<Tuile> tuiles;
    
    private final int nbTuiles=36;
    private Tuile tableauTuiles[] = new Tuile[36];
    private Tuile uneCase;
    
    
    //Getters
    public int getNbTuiles() {
        return nbTuiles;
    }
    public Tuile[] getTableauTuiles() {
        return tableauTuiles;
    }
    public Tuile getUneCase() {
        return uneCase;
    }
    
    
    //Setters
    public void setTableauTuiles(Tuile[] tableauTuiles) {
        this.tableauTuiles = tableauTuiles;
    }
    public void setTuiles(ArrayList<Tuile> tuiles) {
        this.tuiles = tuiles;
    }

    public void setUneCase(Tuile uneCase) {
        this.uneCase = uneCase;
    }
    
    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }
    
    // METHODES
    public Grille(ArrayList<Tuile> tuiles) {
        this.tuiles = tuiles;
    }
    
    public void initGrille(int tableauTuiles) {
        ////
        for (int i=1; i<=36; i++){
            tableauTuiles=i;
            System.out.println(tableauTuiles);
        }
    }

    
}
//arraylist ou hashmap, getTuile assechées, coulées... ou ?? 