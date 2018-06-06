/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.HashSet;
import java.util.Iterator;
import Util.Utils.Pion;

/**
 *
 * @author bassetlu
 */
public abstract class Aventurier {

    /*private String nom;
    HashSet posPossible;
    private Pion couleur;
    private Position pos;
    
    public HashSet posAutourPossible(HashSet p, Position pos) {
        int posX = pos.getX();
        int posY = pos.getY();
        if ((posX == 0 && posY == 2)
                || (posX == 1 && posY == 1)
                || (posX == 2 && posY == 0)
                || (posX == 3 && posY == 0)
                || (posX == 4 && posY == 1)
                || (posX == 5 && posY == 2)) {//postion impossible pour top
            System.out.println("posTop impossible (n'existe pas dans la grille)");
        }else {
            if (!getTuile(posX, posY - 1).verifCoulee()){ // la tuille ne doit pas être coulée
                    Position NewPos = new Position(posX, posY - 1);
                    p.add(NewPos); //ajout de la position possible
            }
        }
        
         if ((posX == 0 && posY == 3)
                || (posX == 1 && posY == 4)
                || (posX == 2 && posY == 5)
                || (posX == 3 && posY == 5)
                || (posX == 4 && posY == 4)
                || (posX == 5 && posY == 3)) {//postion impossible pour bot
            System.out.println("posBot impossible (n'existe pas dans la grille)");
        }else {
            if (!getTuile(posX, posY + 1).verifCoulee()){ // la tuille ne doit pas être coulée
                    Position NewPos = new Position(posX, posY +1);
                    p.add(NewPos); //ajout de la position possible
            }
        }
         
         if ((posX == 2 && posY == 0)
                || (posX == 1 && posY == 1)
                || (posX == 0 && posY == 2 )
                || (posX == 0 && posY == 3)
                || (posX == 1 && posY == 4)
                || (posX == 2 && posY == 5)) {//postion impossible pour left
            System.out.println("posLeft impossible (n'existe pas dans la grille)");
        }else {
            if (!getTuile(posX -1, posY).verifCoulee()){ // la tuille ne doit pas être coulée
                    Position NewPos = new Position(posX-1, posY);
                    p.add(NewPos); //ajout de la position possible
            }
        }
         
          if ((posX == 3 && posY == 0)
                || (posX == 4 && posY == 1)
                || (posX == 5 && posY == 2 )
                || (posX == 5 && posY == 3)
                || (posX == 4 && posY == 4)
                || (posX == 3 && posY == 5)) {//postion impossible pour right
            System.out.println("posRight impossible (n'existe pas dans la grille)");
        }else {
            if (!getTuile(posX + 1, posY).verifCoulee()){ // la tuille ne doit pas être coulée
                    Position NewPos = new Position(posX-1, posY);
                    p.add(NewPos); //ajout de la position possible
            }
        }

        return p;
    }

    public void seDeplacer() {
        Position posJoueur = this.getPosition();
        /*int posX = posTuille.getX();
        int posY = posTuille.getY();*/
        /*posAutourPossible(posPossible, posJoueur);

        //proposer posPossible au joueur, il doit en choisir une, 
        //si il n'y en pas le lui dire
        Iterator it = posPossible.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        this.setPosition(/*position que le joueur à choisie*//*);
    }

    private Position getPosition() {
        return this.pos;
    }

    private void setPosition(Position pos) {
         this.pos=pos;
    }*/
}
