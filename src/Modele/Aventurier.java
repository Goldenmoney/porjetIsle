/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.HashSet;
import java.util.Iterator;
import Util.Utils.Pion;
import java.util.ArrayList;

/**
 *
 * @author bassetlu
 */
public abstract class Aventurier {

    private String nom;
    private ArrayList<Tuile> posPossible;
    private Pion couleur;
    private Tuile tuile;

    public Aventurier(String nom, Pion couleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.tuile = tuile;
    }
   
    
    public ArrayList<Tuile> posAutourPossible(ArrayList<Tuile> p, Tuile pos, Grille g) {
        int posX = pos.getPosition().getX();
        int posY = pos.getPosition().getY();
        
        if ((posX == 0 && posY == 2)
                || (posX == 1 && posY == 1)
                || (posX == 2 && posY == 0)
                || (posX == 3 && posY == 0)
                || (posX == 4 && posY == 1)
                || (posX == 5 && posY == 2)) {//postion impossible pour top
            System.out.println("posTop impossible (n'existe pas dans la grille)");
        }else {
            if (!g.getTuileCase(posX, posY - 1).verifCoulee()){ // la tuille ne doit pas être coulée
                    p.add(g.getTuileCase(posX, posY - 1)); //ajout de la position possible
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
            if (!g.getTuileCase(posX, posY + 1).verifCoulee()){ // la tuille ne doit pas être coulée
                    p.add(g.getTuileCase(posX, posY + 1)); //ajout de la position possible
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
            if (!g.getTuileCase(posX -1, posY).verifCoulee()){ // la tuille ne doit pas être coulée
                    p.add(g.getTuileCase(posX -1, posY)); //ajout de la position possible
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
            if (!g.getTuileCase(posX + 1, posY).verifCoulee()){ // la tuille ne doit pas être coulée
                    p.add(g.getTuileCase(posX + 1, posY)); //ajout de la position possible
            }
        }

        return p;
    }

    public void seDeplacer() {
        Position posJoueur = this.getPosition();
        int posX = posTuille.getX();
        int posY = posTuille.getY();*/
        posAutourPossible(posPossible, posJoueur);

        //proposer posPossible au joueur, il doit en choisir une, 
        //si il n'y en pas le lui dire
        Iterator it = posPossible.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        this.setPosition(/*position que le joueur à choisie*/);
    }

    private Position getPosition() {
        return this.pos;
    }

    private void setPosition(Position pos) {
         this.pos=pos;
    }*/
}
