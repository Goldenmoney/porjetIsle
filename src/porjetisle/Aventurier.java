/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porjetisle;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author bassetlu
 */
abstract class Aventurier {
    private String nom;
    
    
    public void seDeplacer() {
        HashSet posPossible = new HashSet();
        Tuille posAct = this.getPosition();
        
        if(/*à remplir, mettre les 2 if en 1 avec un ou*/){ //valeur impossible pour top [0][2], [1][1], [2][0], [3][0], [4][1], [5][2]
            if(){//tuile(x, y-1).etat = innondé
            }
        }else {
                posPossible.add(/*x, y-1*/);
         }
        
        ///////////////////////////////////////////////////////////////
        
        if(/*à remplir, mettre les 2 if en 1 avec un ou*/){ //valeur impossible pour bot [0][3], [1][4], [2][5], [3][5], [4][4], [5][3]
            if(){//tuile(x, y+1).etat = innondé
            }
        }else {
                posPossible.add(/*x, y+1*/);
         }
        
        ///////////////////////////////////////////////////////////////
        
        if(/*à remplir, mettre les 2 if en 1 avec un ou(||)*/){ //valeur impossible pour left [2][0], [1][1], [0][2], [0][3], [1][4], [2][5]
            if(){//tuile(x-1, y).etat = innondé
            }
        }else {
                posPossible.add(/*x-1, y*/);
         }

         ///////////////////////////////////////////////////////////////
        
        if(/*à remplir, mettre les 2 if en 1 avec un ou(||)*/){ //valeur impossible pour right [3][0], [4][1], [5][2], [5][3], [4][4], [3][5]
            if(){//tuile(x+1, y).etat = innondé
            }
        }else {
                posPossible.add(/*x+1, y*/);
         } //pas sur que mes boolens soit utiles
        //proposer posPossible au joueur, il doit en choisir une, si il n'y en pas le lui dire
         Iterator it = posPosible.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
         this.setPos(/*nouvelle position que le joueur à choisi*/);
         //PA = PA-1;        
    }
}