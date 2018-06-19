/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Aventurier;
import Util.Utils.*;

/**
 *
 * @author bassetlu
 */
public class Carte_Tresor{

    // Association
    private TypeCarteTresor type;
    private Aventurier aventurier;
    
    // METHODES
    public Carte_Tresor(TypeCarteTresor type, Aventurier aventurier) {
        this.type = type;
        this.aventurier = aventurier;
    }
    
    public TypeCarteTresor getType() {
        return type;
    }
    
    public void action(){
    }
    
    
}
