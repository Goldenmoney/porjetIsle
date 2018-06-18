/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bassetlu
 */
public class Aventurier {

    private String nom;
    private Pion couleur;
    private Tuile tuile;
    protected Tuile spawnPos;
    
    //constructeur
    //pas sur que le premier soit utile, puisque avoir un aventurier sans possition sa n'a pas de sens
    public Aventurier(String nom, Pion couleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.tuile = null;
        this.spawnPos= null;
    }
    
    public Aventurier(String nom, Pion couleur, Tuile spawnPos) {
        this.nom = nom;
        this.couleur = couleur;
        this.tuile = spawnPos;
        this.spawnPos=spawnPos;
    }
   
    //methodes
    
    //demande depalcement : pospossible(liste cases dispo)-->choix puis deplacement
    
    public ArrayList<Tuile> posAutourPossible(Grille g) {
        int posX = this.tuile.getPosX();
        int posY = this.tuile.getPosY();
        ArrayList<Tuile> p = new ArrayList<>();
        
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

    public void seDeplacer(Tuile tuile) {
       this.tuile=tuile;
    }

    public Tuile getTuile() {
        return this.tuile;
    }

    public Pion getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

   /* public NomTuile getSpawnPos() {
        return spawnPos;
    }

    public ArrayList<Tuile> getPosPossible() {
        return posPossible;
    }

    public Tuile getTuile() {
        return tuile;
    }*/
    
    
}
