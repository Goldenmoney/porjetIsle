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
    //attributs
    protected Aventurier aventurier;
    protected TypeCarteTresor type;
    
    //constructeur
    public Carte_Tirage_Tresor(TypeCarteTresor type) {
        this.type = type;
    }
    
    //methodes
    public TypeCarteTresor getType() {
        return type;
    }
    
    public void setAventurier(Aventurier aventurier) {
        this.aventurier = aventurier;
    }
    //methode a appeler l'orsque l'on clique sur une carte
    public abstract void action();
}
