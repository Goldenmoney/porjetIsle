/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils.TypeCarteTresor;

/**
 *
 * @author bassetlu
 */

public abstract class Carte_Tirage_Tresor {
    // Attributs
    protected Aventurier aventurier;
    protected TypeCarteTresor type;
    
    // Constructeur
    public Carte_Tirage_Tresor(TypeCarteTresor type) {
        this.type = type;
    }
    
    // Methodes
    public TypeCarteTresor getType() {
        return type;
    }
    
    public void setAventurier(Aventurier aventurier) {
        this.aventurier = aventurier;
    }
    // Methode a appeler l'orsque l'on clique sur une carte
    public abstract void action();
}
