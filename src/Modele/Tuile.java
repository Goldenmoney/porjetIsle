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
    private Pion spawn; //a voir pour adapter aux aventuriers
    private ArrayList<Aventurier> joueurs;
    private Position position;

    // METHODES
    public Tuile(EtatTuile etat, NomTuile nomTuile/*Carte_Inond carte, ArrayList<Aventurier> joueurs*/) {
        this.etat = etat;
        this.nomTuile = nomTuile;
        this.position = position;
        if (nomTuile == NomTuile.La_Porte_de_Bronze) {
            spawn = Utils.Pion.ROUGE; //on les place directement depuis tuiles
        }
    }
    
    public void addJoueur(Joueur joueur) {
        ////
    }

    public void supprJoueur(Joueur joueur) {
        ////
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
        return position;
    }

    public boolean verifCoulee() {
        return getEtat()==EtatTuile.COULEE;
    }
}
