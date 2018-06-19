/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Aventurier;
import Util.Utils.*;
import static Util.Utils.TypeCarteTresor.*;

/**
 *
 * @author bassetlu
 */
public class Carte_Tresor{

    // Association
    private TypeCarteTresor type;
    private Aventurier aventurier;
    
    // constructeur
    public Carte_Tresor(TypeCarteTresor type) {
        this.type = type;
    }
    
    //méthodes
    public TypeCarteTresor getType() {
        return type;
    }

    public void setAventurier(Aventurier aventurier) {
        this.aventurier = aventurier;
    }
    
    public void action(){
        if (getType()== HELICOPTERE){
            //un truc de déplacement
        } else if (getType()== SAC_DE_SABLE){
            //un truc d'assechement
        } else if (getType()== MONTEE_DES_EAUX) {
            //un truc pour faire monter l'eau
        }
    }
    
    
}
