/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import Util.Utils.*;
/**
 *
 * @author bassetlu
 */
public class Tuile {
    //attributs
    private EtatTuile etat;
    private final NomTuile nomTuile;
    private int posX;
    private int posY;
    private TypeTresor typeTresor;
    // Associations
    private Carte_Inond carte;
    private ArrayList<Aventurier> joueurs;
    private Carte_Tresor tresor;
    
    // Constructeur
    public Tuile(EtatTuile etat, NomTuile nomTuile) {
        this.etat = etat;
        this.nomTuile = nomTuile;
        this.joueurs = new ArrayList<>();
    }
    
    //methodes
    //getter
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
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
    
    public TypeTresor getTypeTresor() {
        return typeTresor;
    }
    
    //setter
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    //ou setEtat()
    public void majEtat(EtatTuile etatTuile) {
        this.etat=etatTuile;
    }
    
    public void setTypeTresor(TypeTresor typeTresor) {
        this.typeTresor = typeTresor;
    }

    public void setCarte_Inond(Carte_Inond carte) {
        this.carte = carte;
    }
    
    public void addJoueur(Aventurier aventurier) {
        this.joueurs.add(aventurier);
    }

    public void supprJoueur(Aventurier aventurier) {
       this.joueurs.remove(aventurier);
    }
    
    public boolean verifCoulee() {
        return getEtat()==EtatTuile.COULEE;
    }
    
    public boolean verifInondee() {
        return getEtat()==EtatTuile.INONDEE;
    }
}
