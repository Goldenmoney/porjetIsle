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
import Modele.Tuile;
import Util.Parameters;
import static Util.Utils.*;
import static Util.Utils.EtatTuile.ASSECHEE;
import static Util.Utils.EtatTuile.COULEE;
import Vue.IHM1;
import Vue.VueDebut;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author bassetlu
 */
public class Controleur implements Observateur {

    private int niveauEau;
    private boolean tresorsRecup;
    private int numTour;
    private int actionChoisie;
    private boolean aventurierMort;
    private int pa;
    private ArrayList<Tuile> tuiles;

    private VueDebut vueDebut;
    private IHM1 jeuPrincipal;//

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
    public Controleur() {
        vueDebut = new VueDebut();
        vueDebut.setVisible(true);
        vueDebut.addObservateur(this);
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

    public void initJoueurs(int nbJoueurs, String j1, String j2, String j3, String j4) {

        ArrayList<Pion> pionsRandom = new ArrayList<Pion>();
        pionsRandom.add(Pion.ROUGE);
        pionsRandom.add(Pion.VERT);
        pionsRandom.add(Pion.BLEU);
        pionsRandom.add(Pion.ORANGE);
        pionsRandom.add(Pion.VIOLET);
        pionsRandom.add(Pion.JAUNE);

        if (Parameters.ALEAS) {
            Collections.shuffle(pionsRandom);
        }
        
        //ArrayList<Pion> pionsRandom = pion.getListePionsRandom();
        Tuile spawn = null;

        for (int i = 0; i < 6; i++) {
            // AFFECTATION COULEUR/TUILE
            if (pionsRandom.get(i) == Pion.ROUGE) {
                spawn = grille.getTuileNom("La_Porte_de_Bronze");
            } else if (pionsRandom.get(i) == Pion.BLEU) {
                spawn = grille.getTuileNom("Heliport");
            } else if (pionsRandom.get(i) == Pion.JAUNE) {
                spawn = grille.getTuileNom("La_Porte_dOr");
            } else if (pionsRandom.get(i) == Pion.VERT) {
                spawn = grille.getTuileNom("La_Porte_de_Cuivre");
            } else if (pionsRandom.get(i) == Pion.VIOLET) {
                spawn = grille.getTuileNom("La_Porte_de_Fer");
            } else if (pionsRandom.get(i) == Pion.ORANGE) {
                spawn = grille.getTuileNom("La_Porte_dArgent");
            }

            // CREATION DES JOUEURS
            if (nbJoueurs == 2) {
                joueur1 = new Aventurier(j1, pionsRandom.get(0), spawn);//spawn associé à la couleur);   
                joueur2 = new Aventurier(j2, pionsRandom.get(1), spawn);
            } else if (nbJoueurs == 3) {
                joueur1 = new Aventurier(j1, pionsRandom.get(0), spawn);
                joueur2 = new Aventurier(j2, pionsRandom.get(1), spawn);
                joueur3 = new Aventurier(j3, pionsRandom.get(2), spawn);
            } else {
                joueur1 = new Aventurier(j1, pionsRandom.get(0), spawn);
                joueur2 = new Aventurier(j2, pionsRandom.get(1), spawn);
                joueur3 = new Aventurier(j3, pionsRandom.get(2), spawn);
                joueur4 = new Aventurier(j4, pionsRandom.get(3), spawn);
            }
        }
    }

    public void initJoueurs() {
    }

    public void initPartie(int nbJoueurs, String j1, String j2, String j3, String j4, int difficulte) {
        this.initGrille();
        this.initJoueurs(nbJoueurs, j1, j2, j3, j4);
        this.joueurCourant = joueur1;
        this.niveauEau = difficulte;
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
        this.pa = pa - 1;
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
        if (getNiveauEau() == 10) {
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
        if (getNiveauEau() <= 2) {
            //nb de cartes a piocher = 2
        } else if (getNiveauEau() <= 5) {
            //nb de cartes a piocher = 3
        } else if (getNiveauEau() <= 7) {
            //nb de cartes a piocher = 4
        } else if (getNiveauEau() <= 9) {
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
        for (int i = 0; i < posPosi.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(posPosi.get(i).getNomTuile());
        }
        if (!posPosi.isEmpty()) {
            Scanner sc2 = new Scanner(System.in);
            System.out.print("choisir une des positions proposé : ");
            String str2 = sc2.nextLine();
            int int2 = Integer.parseInt(str2);
            int x = posPosi.get(int2).getPosX();
            int y = posPosi.get(int2).getPosY();
            aventurier.seDeplacer(grille.getTuileCase(x, y));
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
        for (int i = 0; i < posPosi.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(posPosi.get(i).getNomTuile());
        }
        if (!posPosi.isEmpty()) {
            Scanner sc2 = new Scanner(System.in);
            System.out.print("choisir une des positions proposé : ");
            String str2 = sc2.nextLine();
            int int2 = Integer.parseInt(str2);
            int x = posPosi.get(int2).getPosX();
            int y = posPosi.get(int2).getPosY();
            aventurier.seDeplacer(grille.getTuileCase(x, y));
        } else {
            System.out.println("pas de déplacement possible");
        }
        System.out.println("position du joueur actuel : " + aventurier.getTuile().getNomTuile());
    }

    public void assechement(Aventurier aventurier) {
        ArrayList<Tuile> asse = new ArrayList<>();
        asse = aventurier.AssechementAutourPossible(grille);
        for (int i = 0; i < asse.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(asse.get(i).getNomTuile());
        }
        if (!asse.isEmpty()) {
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
        if (aventurier.getTuile().getEtat() == COULEE) {
            deplacementGratuit(aventurier);
        }
        System.out.println("PA actuel : " + getPA());
        boolean changementJoueur = false;
        while (getPA() > 0 && !changementJoueur) {
            Scanner sc = new Scanner(System.in);
            System.out.println("se deplacer? oui ou non?");
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("oui")) {
                deplacement(aventurier);
            }
            if (getPA() != 0) {
                Scanner sc3 = new Scanner(System.in);
                System.out.println("assecher ? oui ou non ?");
                String str3 = sc3.nextLine();
                if (str3.equalsIgnoreCase("oui")) {
                    assechement(aventurier);
                }
            }
            if (getPA() != 0) {
                Scanner sc5 = new Scanner(System.in);
                System.out.println("terminer tour ? oui ou non ?");
                String str5 = sc5.nextLine();
                if (str5.equalsIgnoreCase("oui")) {
                    changementJoueur = true;
                }
            }
        }
        if (getPA() == 0) {
            System.out.println("Plus de PA dispo");
        }
        terminerTour();
    }

    public void terminerTour() {
        System.out.println("Tour terminer");
        if (verifPartieFinie()) {
            if (verifPartieGagnee()) {
                System.out.println("partie finit et gagné");
            } else {
                System.out.println("partie finit et perdu");
            }
        } else {
            piocherCarteInondation();
            if (joueurCourant == joueur1) {
                joueurCourant = joueur2;
            } else if (joueurCourant == joueur2 && joueur3 != null) {
                joueurCourant = joueur3;
            } else if (joueurCourant == joueur3 && joueur4 != null) {
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
            case JOUER:
                jeuPrincipal = new IHM1(this);
                jeuPrincipal.setVisible(true);
                jeuPrincipal.addObservateur(this);
                initPartie(msg.nbJoueurs, msg.joueur1, msg.joueur2, msg.joueur3, msg.joueur4, msg.difficulte);
                break;

            case SE_DEPLACER:
                ////
                if (getPA() != 0) {
                    deplacement(getJoueurCourant());
                }
                break;

            case ASSECHER:
                ////
                if (getPA() != 0) {
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
