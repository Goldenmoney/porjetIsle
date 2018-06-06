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

    private String nom;
    HashSet posPossible;
    private Pion couleur;

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
            if (!/*Tuille de position x, y-1*/.verifCoulee()){ // la tuille ne doit pas être coulée
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
            if (!/*Tuille de position x, y+1*/.verifCoulee()){ // la tuille ne doit pas être coulée
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
            if (!/*Tuille de position x-1, y*/.verifCoulee()){ // la tuille ne doit pas être coulée
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
            if (!/*Tuille de position x+1, y*/.verifCoulee()){ // la tuille ne doit pas être coulée
                    Position NewPos = new Position(posX-1, posY);
                    p.add(NewPos); //ajout de la position possible
            }
        }

        return p;
    }

    public void seDeplacer() {
        Tuile posJoueur = this.getPosition();
        Position posTuille = posJoueur.getPosition();
        /*int posX = posTuille.getX();
        int posY = posTuille.getY();*/
        posAutourPossible(posPossible, posTuille);

        //proposer posPossible au joueur, il doit en choisir une, si il n'y en pas le lui dire
        Iterator it = posPossible.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        this.setPos(/*nouvelle position que le joueur à choisi*/);
        this.setPA(this.getPA() - 1);
    }

    private Tuile getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
