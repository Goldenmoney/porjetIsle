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
import Modele.Explorateur;
import Modele.Grille;
import Modele.Tuile;
import static Util.Utils.EtatTuile.ASSECHEE;
import static Util.Utils.EtatTuile.COULEE;
import static Util.Utils.Pion.BLEU;
import static Util.Utils.Pion.ROUGE;
import Vue.VuePlateau;
import java.util.Scanner;

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
    private Aventurier joueur1;
    private Aventurier joueur2;
    private Aventurier joueur3;
    private Aventurier joueur4;
    private Aventurier joueurCourant;
    private Carte_Tresor piocheTresor;
    private Carte_Tresor defausseTresor;
    private Carte_Inond piocheInond;
    private Carte_Inond supprimeInond;

    // constructeur
    public void controleur() {
        this.tuiles = new ArrayList<>();
        //this.joueurs = new ArrayList<>();
        this.grille = getGrille();
    }          
    
    // methodes de la classe

    public void addTresor() {
        ////
    }

    public int getPA() {
        return pa;
    }
    
    
    
    public void initGrille() {
        grille = new Grille(tuiles);
        grille.afficheGrille();
        System.out.println("");
        grille.afficheNomGrille();
    }

    public void initJoueurs() {
        joueur1 = new Aventurier("je sais pas qui avec le nom du joueur 1", ROUGE, grille.getTuileCase(2, 2));
        joueur2 = new Aventurier("quelq'un qui sera le joueur 2", BLEU, grille.getTuileCase(1, 4));
    }
    
   public void initPartie(){
        this.initGrille();
        this.initJoueurs();
        this.joueurCourant = joueur1;
        this.niveauEau = 10;
        System.out.println("c'est a " + joueurCourant.getNom());
        this.debutTour(joueurCourant);
    }

    public Grille getGrille() {
        return grille;
    }

    public int getNiveauEau() {
        return niveauEau;
    }
    
    public void setPA(int pa) {
        this.pa = pa;
    }
    
    public void setPAMoins1(int pa) {
        this.pa = pa-1;
        System.out.println("PA actuel : " + getPA());
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
        if (getNiveauEau()==10){
            return true;
        } else {
            return false;
        }
    }
    
    ///true si la partie est gagné, false si elle est perdue
    public boolean verifPartieGagnee() {
        //if () {
            return true;
        //} else {
            //return false;
        //}
    }

    public void monteeEau(int monte) {
        niveauEau = +monte;
    }

    public void piocherCarte(Aventurier Aventurier) {
        ////
    }

    public void piocherCarteInondation() {
        if (getNiveauEau() <= 2){
            //nb de cartes a piocher = 2
        } else if (getNiveauEau() <= 5) {
            //nb de cartes a piocher = 3
        } else if (getNiveauEau() <= 7) {
            //nb de cartes a piocher = 4
        } else if (getNiveauEau() <= 9){
            //nb de cartes a piocher = 5
        }
    }

    public void piocherCarteTresor() {
        ////
    }

    public Aventurier getJoueurCourant() {
        return joueurCourant;
    }
    
    public void deplacement(Aventurier aventurier) {
            ArrayList<Tuile> posPosi = new ArrayList<>();
            posPosi = aventurier.posAutourPossible(grille);
            for (int i = 0; i < posPosi.size();i ++) {
                System.out.print(i + ". ");
                System.out.println(posPosi.get(i).getNomTuile());
        }
            if (!posPosi.isEmpty()){
                 Scanner sc2 = new Scanner(System.in);
                System.out.print("choisir une des positions proposé : ");
                String str2 = sc2.nextLine();
                int int2 = Integer.parseInt(str2);
                int x = posPosi.get(int2).getPosX();
                int y = posPosi.get(int2).getPosY();
                aventurier.seDeplacer(grille.getTuileCase(x,y));
                setPAMoins1(getPA());
            } else {
                System.out.println("pas de déplacement possible");
            }
            System.out.println("position du joueur actuel : " + aventurier.getTuile().getNomTuile());
    }
    
    public void deplacementGratuit(Aventurier aventurier) {
            System.out.println("Le joueur est sur une case coulée au début de son tour, il peu donc se déplacer sur une tuile adjacente gratuitement");
            ArrayList<Tuile> posPosi = new ArrayList<>();
            posPosi = aventurier.posAutourPossible(grille);
            for (int i = 0; i < posPosi.size();i ++) {
                System.out.print(i + ". ");
                System.out.println(posPosi.get(i).getNomTuile());
        }
            if (!posPosi.isEmpty()){
                 Scanner sc2 = new Scanner(System.in);
                System.out.print("choisir une des positions proposé : ");
                String str2 = sc2.nextLine();
                int int2 = Integer.parseInt(str2);
                int x = posPosi.get(int2).getPosX();
                int y = posPosi.get(int2).getPosY();
                aventurier.seDeplacer(grille.getTuileCase(x,y));
            } else {
                System.out.println("pas de déplacement possible");
            }
            System.out.println("position du joueur actuel : " + aventurier.getTuile().getNomTuile());
    }
    
    public void assechement(Aventurier aventurier) {
            ArrayList<Tuile> asse = new ArrayList<>();
            asse = aventurier.AssechementAutourPossible(grille);
            for (int i = 0; i < asse.size();i ++) {
                System.out.print(i + ". ");
                System.out.println(asse.get(i).getNomTuile());
            }
            if (!asse.isEmpty()){
                Scanner sc4 = new Scanner(System.in);
                System.out.print("choisir une des positions proposé : ");
                String str4 = sc4.nextLine();
                int int4 = Integer.parseInt(str4);
                asse.get(int4).majEtat(ASSECHEE);
                System.out.println("tuile " + asse.get(int4).getNomTuile() + " assechée");
                setPAMoins1(getPA());
            } else {
                System.out.println("pas d'assechement possible");
            }
            /*ArrayList<Tuile> asseAft = new ArrayList<>();
            asseAft = aventurier.AssechementAutourPossible(grille);
             if (!asseAft.isEmpty()){
                 for (int i = 0; i < asseAft.size();i ++) {
                System.out.print(i + ". ");
                System.out.println(asseAft.get(i).getNomTuile());
                }  
             } else {
                 System.out.println("pas d'assechement possible");
             }*/
    }

    public void debutTour(Aventurier aventurier) {
        setPA(3);
        System.out.println("position du joueur actuel : " + aventurier.getTuile().getNomTuile());
        if (aventurier.getTuile().getEtat() == COULEE){
            deplacementGratuit(aventurier);
        }
        System.out.println("PA actuel : " + getPA());
        boolean changementJoueur = false;
        while (getPA()>0 && !changementJoueur){
            Scanner sc = new Scanner(System.in);
            System.out.println("se deplacer? oui ou non?");
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("oui")){
                deplacement(aventurier);
            }
            if (getPA() != 0){
                Scanner sc3 = new Scanner(System.in);
                System.out.println("assecher ? oui ou non ?");
                String str3 = sc3.nextLine();
                if (str3.equalsIgnoreCase("oui")){
                    assechement(aventurier);
                } 
            }
            if (getPA() != 0){
                Scanner sc5 = new Scanner(System.in);
                System.out.println("terminer tour ? oui ou non ?");
                String str5 = sc5.nextLine();
                if (str5.equalsIgnoreCase("oui")){
                    changementJoueur = true;
                }
            }
        }
        if (getPA() == 0){
            System.out.println("Plus de PA dispo");
        }
        terminerTour();
    }

    public void terminerTour() {
        System.out.println("Tour terminer");
        if (verifPartieFinie()){
            if (verifPartieGagnee()){
                System.out.println("partie finit et gagné");
            }else{
                System.out.println("partie finit et perdu");
            }
        } else {
            piocherCarteInondation();
            if (joueurCourant == joueur1){
                joueurCourant = joueur2;
            }else if (joueurCourant == joueur2 && joueur3 != null){
                joueurCourant = joueur3;
            }else if (joueurCourant == joueur3 && joueur4 != null) {
               joueurCourant = joueur4;
            } else {
                joueurCourant = joueur1;
            }
            System.out.println("Joueur Suivant");
            System.out.println("c'est a " + joueurCourant.getNom());
            debutTour(joueurCourant);
        }
    }

    // Traiter message car Controleur=Obervé
    public void traiterMessage(Message msg) {
        switch (msg.type) {
            case SE_DEPLACER:
                ////
                if (getPA()!= 0){
                   deplacement(getJoueurCourant()); 
                }
                break;
            case ASSECHER:
                ////
                if (getPA()!= 0){
                   assechement(getJoueurCourant()); 
                }
                break;
            case ECHANGER:
                ////
                break;
            case RECUP_TRESOR:
                ////
                break;
        }
    }
    

}
