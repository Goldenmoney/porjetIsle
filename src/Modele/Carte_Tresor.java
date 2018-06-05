/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Aventurier;

/**
 *
 * @author bassetlu
 */
public class Carte_Tresor extends Cartes {
    
    public enum TypeCarteTresor {
        TRESOR_ROUGE,
        TRESOR_GRIS,
        TRESOR_ORANGE,
        HELICOPTERE,
        SAC_DE_SABLE,
        MONTEE_EAUX
    }

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
    
    
}
