/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils;
import Util.Utils.TypeCarteTresor;

/**
 *
 * @author bassetlu
 */

public abstract class Carte_Tirage_Tresor {
    protected Aventurier aventurier;
    protected TypeCarteTresor type;
    
    public Carte_Tirage_Tresor(TypeCarteTresor type) {
        this.type = type;
    }
    
    public void setAventurier(Aventurier aventurier) {
        this.aventurier = aventurier;
    }

    public TypeCarteTresor getType() {
        return type;
    }
    
    //methode a appeler l'orsque l'on clique sur une carte
    public abstract void action();
}
