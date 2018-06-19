/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils.*;

/**
 *
 * @author bassetlu
 */
public class Carte_Tresor extends Carte_Tirage_Tresor {

    // Association
    
    // constructeur
    public Carte_Tresor(TypeCarteTresor type) {
       super(type);
    }
    
    //méthodes

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
