/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.util.ArrayList;
import Modele.Aventurier;
import Modele.Carte_Inond;
import Modele.Carte_Tresor;
import Modele.Grille;
import Controleur.TypesMessages;
import Modele.Tuile;

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
    private ArrayList<Tuile> tuiles;

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
    
    public void initGrille() {
        Grille grilleTest = new Grille(tuiles);
        grilleTest.afficheGrille();
        System.out.println("");
        grilleTest.afficheNomGrille();
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

    public boolean verifPartieFinie() {
        return true; ////
    }

    public boolean verifPartieGagnee() {
        return true; ////
    }

    public boolean verifPartiePerdue() {
        return true; ////
    }

    public void monteeEau(int monte) {
        niveauEau = +monte;
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

    public TypesMessages getChoixActionJoueur() {
        return TypesMessages.BOUGER; ////
    }

    public void debutTour(Aventurier aventurier) {
        ////
        /*getMainAventurier();
        if (verifCarteSpe()){
            ////
        }*/

    }

    public void terminerTour() {
        ////
    }

    public void initJeu() {
        ////
    }

    // Traiter message car Controleur=Obervé
    public void traiterMessage(Message msg) {
        switch (msg.type) {
            case BOUGER:
                
                ////
                break;
            case ASSECHER:
                ////
                break;
            case AUTRE_ACTION:
                ////
                break;
        }
    }
}
