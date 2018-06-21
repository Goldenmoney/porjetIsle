/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils;
import java.util.ArrayList;
import Util.Utils.EtatTuile;
import Util.Utils.NomTuile;
import Util.Utils.Pion;
import Util.Utils.*;
/**
 *
 * @author bassetlu
 */
public class Tuile {

    private EtatTuile etat;
    private final NomTuile nomTuile;
    private int posX;
    private int posY;
    private TypeTresor typeTresor;

    // Associations
    private Carte_Inond carte;
    private ArrayList<Aventurier> joueurs;
    private Carte_Tresor tresor;
    
    // METHODES
  
public Tuile(EtatTuile etat, NomTuile nomTuile) {
        this.etat = etat;
        this.nomTuile = nomTuile;
        this.joueurs = new ArrayList<>();
    }
    
//2 constructeurs inutiles
   /* public Tuile(EtatTuile etat, NomTuile nomTuile, Carte_Inond carte, ArrayList<Aventurier> joueurs, Carte_Tresor tresor) {
        this.etat = etat;
        this.nomTuile = nomTuile;
        this.carte = carte;
        this.joueurs = joueurs;
        this.tresor = tresor;
    }
    
     public Tuile(EtatTuile etat, NomTuile nomTuile, Carte_Inond carte) {
        this.etat = etat;
        this.nomTuile = nomTuile;
        this.carte = carte;
    }*/

    public void setTypeTresor(TypeTresor typeTresor) {
        this.typeTresor = typeTresor;
    }

    public TypeTresor getTypeTresor() {
        return typeTresor;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void addJoueur(Aventurier aventurier) {
        this.joueurs.add(aventurier);
    }

    public void supprJoueur(Aventurier aventurier) {
       this.joueurs.remove(aventurier);
    }

    //ou setEtat()
    public void majEtat(EtatTuile etatTuile) {
        this.etat=etatTuile;
    }

    public EtatTuile getEtat() {
        return etat;
    }

    public NomTuile getNomTuile() {
        return nomTuile;
    }

    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }

    public boolean verifCoulee() {
        return getEtat()==EtatTuile.COULEE;
    }
    
    public boolean verifInondee() {
        return getEtat()==EtatTuile.INONDEE;
    }

    public void setCarte_Inond(Carte_Inond carte) {
        this.carte = carte;
    }
    
    
}
