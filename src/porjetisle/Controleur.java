/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porjetisle;

import java.util.ArrayList;

/**
 *
 * @author bassetlu
 */
public class Controleur {
    
    private int niveauEau;
    private boolean tresorsRecup;
    private int numTour;
    private int actionChoisie;
    private boolean aventurierMort;
    private int pa;

    // Associations
    private Grille grille;
    private Aventurier joueur;
    private ArrayList<Aventurier> joueurs;
    private Carte_Tresor piocheTresor;
    private Carte_Tresor defausseTresor;
    private Carte_Inond piocheInond;
    private Carte_Inond supprimeInond;
    
    
    // METHODES
    public void controleur() {
        ////
    }

    public void addTresor() {
        ////
    }

    public int getPA() {
        return pa;
    }

    public Grille getGrille() {
        return grille;
    }

    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public void initPiocheInondation() {
        ////
    }

    public void initPiocheTresor() {
        ////
    }

    public void initPositionAventurier() {
        ////
    }

    public void verifPartieFinie() {
        ////
    }

    public void verifPartieGagnee() {
        ////
    }

    public void verifPartiePerdue() {
        ////
    }

    public void monteeEau() {
        ////
    }

    public void piocherCarte(Aventurier Aventurier) {
        ////
    }
    
    public void piocherCarteInondation(int niveauEau) {
        ////
    }
    
    public void piocherCarteTresor() {
        ////
    }
    
    public void debutTour() {
        ////
    }
    
    public void terminerTour() {
        ////
    }
    
    public void initJeu() {
        ////
    }
}
