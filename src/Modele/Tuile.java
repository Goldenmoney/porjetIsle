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
/**
 *
 * @author bassetlu
 */
public class Tuile {

    private EtatTuile etat;
    private final NomTuile nomTuile;

    // Associations
    private Carte_Inond carte;
    private ArrayList<Aventurier> joueurs;
    private Position posCase;
    private Carte_Tresor tresor;
    // METHODES
  
public Tuile(EtatTuile etat, NomTuile nomTuile) {
        this.etat = etat;
        this.nomTuile = nomTuile;
        this.carte = carte;
        this.joueurs = joueurs;
        this.posCase = posCase;
        this.tresor = null;
    }
    
    public Tuile(EtatTuile etat, NomTuile nomTuile, Carte_Inond carte, ArrayList<Aventurier> joueurs, Position posCase, Carte_Tresor tresor) {
        this.etat = etat;
        this.nomTuile = nomTuile;
        this.carte = carte;
        this.joueurs = joueurs;
        this.posCase = posCase;
        this.tresor = tresor;
    }
    
    

    public void setPosCase(int x, int y) {
        this.posCase.setX(x);
        this.posCase.setY(y);
    }
    
    public void addJoueur(Aventurier aventurier) {
        this.joueurs.add(aventurier);
    }

    public void supprJoueur(Aventurier aventurier) {
       this.joueurs.remove(aventurier);
    }

    public void majEtat(EtatTuile etatTuile) {
        etat=etatTuile;
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

    public Position getPosition() {
        return posCase;
    }

    public boolean verifCoulee() {
        return getEtat()==EtatTuile.COULEE;
    }
}
