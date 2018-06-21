/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.Controleur;
import Util.Utils.*;
import static Util.Utils.EtatTuile.COULEE;
import static Util.Utils.EtatTuile.INONDEE;
import java.util.ArrayList;

/**
 *
 * @author bassetlu
 */
public class Aventurier {
    //attributs
    private String nom;
    private Pion couleur;
    private  int nb_cartes;
    //associations
    private Controleur controleur;
    private Tuile tuile;
    private ArrayList<Carte_Tirage_Tresor> inventaire;
    
    //constructeur  
    public Aventurier(String nom, Pion couleur, Controleur controleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.inventaire = new ArrayList<>();
        updateNbCartes();
        this.controleur = controleur;
        //pioche 2 cartes pour chaque joueurs
        this.controleur.piocherCarte(this);
        this.controleur.piocherCarte(this);
    }
    
    //methodes
    //getter
    public Tuile getTuile() {
        return this.tuile;
    }

    public Pion getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    public Controleur getControleur() {
        return controleur;
    }
    
    public int getNbCartes(){
        updateNbCartes();
        return this.nb_cartes;
    }
    
    public ArrayList<Carte_Tirage_Tresor> getInventaire() {
        return inventaire;
    }
    
    // True si le joueur possede 4 cartes ou plus du type de trésor choisie en paramètre
    public boolean getNbCartesTresorEgale4(TypeCarteTresor tresor){
        int compteur = 0;
        for (int i = 0; i < getNbCartes(); i++){
            if (getInventaire().get(i).getType() == tresor){
                compteur =+ 1;
            }
        }
        return (compteur >= 4);
    }
    
    // Setter
    public void setTuile(Tuile tuile) {
        if (this.tuile != null){
            this.tuile.supprJoueur(this);
        }
        this.tuile=tuile;
        tuile.addJoueur(this);
    }
    
    public void defausserCarte(Carte_Tirage_Tresor carte){
        this.inventaire.remove(carte);
    }
    
    public void updateNbCartes(){
        this.nb_cartes = inventaire.size();
        if (nb_cartes >9){
            System.err.println("nombres de cartes maximun du joueur dépassé(+ de 9)");
        }
    }
    
    // Return un arrayList des positions sur laquel l'aventurier peu se déplacer autour de lui
    public ArrayList<Tuile> posAutourPossible() {
        int posX = this.tuile.getPosX(); // récupération de la position actuel du joueur en x
        int posY = this.tuile.getPosY(); // récupération de la position actuel du joueur en y
        ArrayList<Tuile> p = new ArrayList<>();
        if ((posX == 0 && posY == 2)
                || (posX == 1 && posY == 1)
                || (posX == 2 && posY == 0)
                || (posX == 3 && posY == 0)
                || (posX == 4 && posY == 1)
                || (posX == 5 && posY == 2)) {// tuile inexistante au nord de la position actuel
            System.out.println("Tuile au nord inexistante (déplacement)");//trace
        }else {
            if (!controleur.getGrille().getTuileCase(posX, posY - 1).verifCoulee()){ // la tuile ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX, posY - 1)); // ajout de la position possible
            }
        }
        
         if ((posX == 0 && posY == 3)
                || (posX == 1 && posY == 4)
                || (posX == 2 && posY == 5)
                || (posX == 3 && posY == 5)
                || (posX == 4 && posY == 4)
                || (posX == 5 && posY == 3)) {// tuile inexistante au sud de la position actuel
            System.out.println("Tuile au sud inexistante (déplacement)");// trace
        }else {
            if (!controleur.getGrille().getTuileCase(posX, posY + 1).verifCoulee()){ // la tuile ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX, posY + 1)); // ajout de la tuile possible
            }
        }
         
         if ((posX == 2 && posY == 0)
                || (posX == 1 && posY == 1)
                || (posX == 0 && posY == 2 )
                || (posX == 0 && posY == 3)
                || (posX == 1 && posY == 4)
                || (posX == 2 && posY == 5)) {//tuile inexistante a l'ouest de la position actuel
            System.out.println("Tuile à l'ouest inexistante (déplacement)");// trace
        }else {
            if (!controleur.getGrille().getTuileCase(posX -1, posY).verifCoulee()){ // la tuile ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX -1, posY)); // ajout de la tuile possible
            }
        }
         
          if ((posX == 3 && posY == 0)
                || (posX == 4 && posY == 1)
                || (posX == 5 && posY == 2 )
                || (posX == 5 && posY == 3)
                || (posX == 4 && posY == 4)
                || (posX == 3 && posY == 5)) {//tuile inexistante a l'est de la position actuel
            System.out.println("Tuile à l'est inexistante (déplacement)");//trace
        }else {
            if (!controleur.getGrille().getTuileCase(posX + 1, posY).verifCoulee()){ // la tuile ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX + 1, posY)); //ajout de la tuile possible
            }
          }
        return p;
    }
    
    // Return un arrayList des tuiles que l'aventurier peu se assècher autour de lui
    public ArrayList<Tuile> AssechementAutourPossible() {
        ArrayList<Tuile> p = new ArrayList<>();
        int posX = this.tuile.getPosX();
        int posY = this.tuile.getPosY();
        if ((posX == 0 && posY == 2)
                || (posX == 1 && posY == 1)
                || (posX == 2 && posY == 0)
                || (posX == 3 && posY == 0)
                || (posX == 4 && posY == 1)
                || (posX == 5 && posY == 2)) {// tuile inexistante au nord de la position actuel
            System.out.println("Tuile au nord inexistante (assèchement)"); // trace
        }else {
            if (controleur.getGrille().getTuileCase(posX, posY - 1).verifInondee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX, posY - 1)); // ajout de la position possible
            }
        }
        
         if ((posX == 0 && posY == 3)
                || (posX == 1 && posY == 4)
                || (posX == 2 && posY == 5)
                || (posX == 3 && posY == 5)
                || (posX == 4 && posY == 4)
                || (posX == 5 && posY == 3)) {// tuile inexistante au sud de la position actuel
            System.out.println("Tuile au sud inexistante (assèchement)"); // trace
        }else {
            if (controleur.getGrille().getTuileCase(posX, posY + 1).verifInondee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX, posY + 1)); // ajout de la position possible
            }
        }
         
         if ((posX == 2 && posY == 0)
                || (posX == 1 && posY == 1)
                || (posX == 0 && posY == 2 )
                || (posX == 0 && posY == 3)
                || (posX == 1 && posY == 4)
                || (posX == 2 && posY == 5)) {// tuile inexistante a l'ouest de la position actuel
            System.out.println("Tuile à l'ouest inexistante (assèchement)"); // trace
        }else {
            if (controleur.getGrille().getTuileCase(posX -1, posY).verifInondee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX -1, posY)); // ajout de la position possible
            }
        }
         
          if ((posX == 3 && posY == 0)
                || (posX == 4 && posY == 1)
                || (posX == 5 && posY == 2 )
                || (posX == 5 && posY == 3)
                || (posX == 4 && posY == 4)
                || (posX == 3 && posY == 5)) {// tuile inexistante a l'est de la position actuel
            System.out.println("Tuile à l'est inexistante (assèchement)"); // trace
        }else {
            if (controleur.getGrille().getTuileCase(posX + 1, posY).verifInondee()){ // la tuille ne doit pas être coulée
                    p.add(controleur.getGrille().getTuileCase(posX + 1, posY)); // ajout de la position possible
            }
          }
        return p;
    }

    // Methode pour parcourir toute la grille
    // Etat  = INONDEE pour déplacement et etat = COULEE pour l'assèchement
    public ArrayList<Tuile> posPossibleAll(EtatTuile etat){
        ArrayList<Tuile> p = new ArrayList<>();
        for(int i = 0; i<=5; i++){
            if(i == 0 || i == 5){
                for(int j = 2; i <= 3; i++){
                    if (etat == INONDEE){ // pour le déplacement
                        if (controleur.getGrille().getTuileCase(i, j).getEtat() != etat){
                            p.add(controleur.getGrille().getTuileCase(i, j));
                        }
                    } else if (etat == COULEE){ // pour l'assèchement
                        if (controleur.getGrille().getTuileCase(i, j).getEtat() == etat){
                            p.add(controleur.getGrille().getTuileCase(i, j));
                        }  
                    }
                }
            }else if (i == 1 || i == 4){
                for(int j = 1; i <= 4; i++){
                    if (etat == INONDEE){ // pour le déplacement
                        if (controleur.getGrille().getTuileCase(i, j).getEtat() != etat){
                            p.add(controleur.getGrille().getTuileCase(i, j));
                        }
                    } else if (etat == COULEE){ // pour l'assèchement
                        if (controleur.getGrille().getTuileCase(i, j).getEtat() == etat){
                            p.add(controleur.getGrille().getTuileCase(i, j));
                        }  
                    }
                }
            }else {
                for(int j = 0; i <= 5; i++){
                    if (etat == INONDEE){ // pour le déplacement
                        if (controleur.getGrille().getTuileCase(i, j).getEtat() != etat){
                            p.add(controleur.getGrille().getTuileCase(i, j));
                        }
                    } else if (etat == COULEE){ // pour l'assèchement
                        if (controleur.getGrille().getTuileCase(i, j).getEtat() == etat){
                            p.add(controleur.getGrille().getTuileCase(i, j));
                        }  
                    }
                }
            }
        }
        return p;
    }
}
