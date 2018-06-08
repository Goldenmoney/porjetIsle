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
public abstract class Aventurier {

    private String nom;
    private ArrayList<Tuile> posPossible;
    private Pion couleur;
    private Tuile tuile;
    protected NomTuile spawnPos;
    
    public Aventurier(String nom, Pion couleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.tuile = tuile;
        this.spawnPos=null;
    }
   
    
    public ArrayList<Tuile> posAutourPossible( Tuile tuile, Grille g) {
        int posX = tuile.getPosition().getX();
        int posY = tuile.getPosition().getY();
        
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

    public void seDeplacer(Grille grille) {
        Tuile tuile = this.getPosition();
        tuile.getPosition().getX();
       // int posX = posJoueur.getX();
        //int posY = posJoueur.getY();
        posAutourPossible(posPossible, tuile, grille);

        //proposer posPossible au joueur, il doit en choisir une, 
        //si il n'y en pas le lui dire
        if (posPossible.isEmpty()){
            System.out.println("déplacement impossible (pas de cases adjacente)");
        } else {
            for (int i = 0; i < posPossible.size(); i++) {
                System.out.print(i+". ");
                System.out.print("x = "+posPossible.get(i).getPosition().getX());
                System.out.println("y = "+posPossible.get(i).getPosition().getY());
            }
                Scanner sc = new Scanner(System.in);
                System.out.println("Veuillez saisir un chiffre entre 0 et" + (posPossible.size()-1) + " :");
                String str = sc.nextLine();
                System.out.println("Vous avez saisi : " + str);
                int choix = Integer.parseInt(str);
                System.out.print(choix+". ");
                System.out.print("x = "+posPossible.get(choix).getPosition().getX());
                System.out.println("y = "+posPossible.get(choix).getPosition().getY());
                this.setPosition(posPossible.get(choix));
        }
        
        
        
    }

    private Tuile getPosition() {
        return this.tuile;
    }

    private void setPosition(Tuile tuileChoisie) {
         this.tuile=tuileChoisie;
    }

    public Pion getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    public NomTuile getSpawnPos() {
        return spawnPos;
    }

    public ArrayList<Tuile> getPosPossible() {
        return posPossible;
    }

    public Tuile getTuile() {
        return tuile;
    }
    
    
}
