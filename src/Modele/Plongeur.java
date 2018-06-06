/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils;
import static Util.Utils.EtatTuile.ASSECHEE;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author bassetlu
 */
public class Plongeur extends Aventurier {
        private HashSet AVerifier;
        private HashSet Verifier; 
        
        public Plongeur(String nom, Tuile tuile) {
        super(nom, Utils.Pion.ROUGE, null);
    }
     
        
    /*    @Override
    public HashSet posAutourPossible(HashSet p, Tuile t) {
        
    }    
        
    @Override
    public void seDeplacer() {
        Tuile t = this.getPos();
        posAutourPossible(AVerifier, t){
            Iterator it = posPossible.iterator();
            for(){
                if(.getEtat() != ASSECHEE) {
               AVerifier.add();
                }
            }
            
            
            
       }*/
}
