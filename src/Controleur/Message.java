/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Carte_Tirage_Tresor;

/**
 *
 * @author bassetlu
 */
public class Message {
    public TypesMessages type;  // type de message
    public String joueur1, joueur2, joueur3, joueur4;
    public int uneCaseX;
    public int uneCaseY;
    public int difficulte;
    public int nbJoueurs;
    public int casJeu; // 0: Deplacement 1: Assechement
    public Carte_Tirage_Tresor carte;
}

