/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.Controleur;
import Util.Utils.*;
import static Util.Utils.Pion.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bassetlu
 */
public class Aventurier {

    private String nom;
    private Pion couleur;
    private ArrayList<Carte_Tresor> inventaire;
    private  int nb_cartes;
    private Tuile tuile;
    private Controleur controleur;
    
    //constructeur  
    public Aventurier(String nom, Pion couleur, Tuile spawnPos, Controleur controleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.tuile = spawnPos;
        this.tuile.addJoueur(this);
        this.inventaire = new ArrayList<>();
        this.nb_cartes = inventaire.size();
        this.controleur = controleur;
    }
   
    //methodes
    public ArrayList<Tuile> posAutourPossible() {
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
            if (!controleur.getGrille().getTuileCase(posX, posY - 1).verifCoulee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX, posY - 1)); //ajout de la position possible
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
            if (!controleur.getGrille().getTuileCase(posX, posY + 1).verifCoulee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX, posY + 1)); //ajout de la position possible
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
            if (!controleur.getGrille().getTuileCase(posX -1, posY).verifCoulee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX -1, posY)); //ajout de la position possible
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
            if (!controleur.getGrille().getTuileCase(posX + 1, posY).verifCoulee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX + 1, posY)); //ajout de la position possible
            }
          }
        return p;
    }
    
    public ArrayList<Tuile> AssechementAutourPossible() {
        ArrayList<Tuile> p = new ArrayList<>();
        int posX = this.tuile.getPosX();
        int posY = this.tuile.getPosY();
        if ((posX == 0 && posY == 2)
                || (posX == 1 && posY == 1)
                || (posX == 2 && posY == 0)
                || (posX == 3 && posY == 0)
                || (posX == 4 && posY == 1)
                || (posX == 5 && posY == 2)) {//postion impossible pour top
            System.out.println("posTop impossible (n'existe pas dans la grille)");
        }else {
            if (controleur.getGrille().getTuileCase(posX, posY - 1).verifInondee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX, posY - 1)); //ajout de la position possible
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
            if (controleur.getGrille().getTuileCase(posX, posY + 1).verifInondee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX, posY + 1)); //ajout de la position possible
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
            if (controleur.getGrille().getTuileCase(posX -1, posY).verifInondee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX -1, posY)); //ajout de la position possible
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
            if (controleur.getGrille().getTuileCase(posX + 1, posY).verifInondee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX + 1, posY)); //ajout de la position possible
            }
          }
        return p;
    }

    public void seDeplacer(Tuile tuile) {
       this.tuile.supprJoueur(this);
       this.tuile=tuile;
       this.tuile.addJoueur(this);
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

    public void updateNbCartes(){
        this.nb_cartes = inventaire.size();
    }
    
    public int getNbCartes(){
        updateNbCartes();
        return this.nb_cartes;
    }
}
