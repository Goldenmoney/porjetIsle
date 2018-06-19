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
    private Aventurier joueur;
    private TypeCarteTresor type;
    
    public Carte_Tirage_Tresor(TypeCarteTresor type) {
        this.type = type;
    }
}
