/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import Util.Utils.EtatTuile;
/**
 *
 * @author bassetlu
 */
public class Tuile {

    public enum NomTuile {
        Le_Pont_des_Abimes,
        La_Porte_de_Bronze,
        La_Caverne_des_Ombres,
        La_Porte_de_Fer,
        La_Porte_dOr,
        Les_Falaises_de_lOubli,
        Le_Palais_de_Corail,
        La_Porte_dArgent,
        Les_Dunes_de_lIllusion,
        Heliport,
        La_Porte_de_Cuivre,
        Le_Jardin_des_Hurlements,
        La_Foret_Pourpre,
        Le_Lagon_Perdu,
        Le_Marais_Brumeux,
        Observatoire,
        Le_Rocher_Fantome,
        La_Caverne_du_Brasier,
        Le_Temple_du_Soleil,
        Le_Temple_de_La_Lune,
        Le_Palais_des_Marees,
        Le_Val_du_Crepuscule,
        La_Tour_du_Guet,
        Le_Jardin_des_Murmures
    }

    private EtatTuile etat;
    private final NomTuile nomTuile;

    // Associations
    private Carte_Inond carte;
    private ArrayList<Aventurier> joueurs;
    private Position position;

    // METHODES
    public Tuile(EtatTuile etat, NomTuile nomTuile, Carte_Inond carte, ArrayList<Aventurier> joueurs, Position position) {
        this.etat = etat;
        this.nomTuile = nomTuile;
        this.position = position;
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
