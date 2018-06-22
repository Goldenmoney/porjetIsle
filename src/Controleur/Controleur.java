/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.util.ArrayList;
import Modele.*;
import Util.*;
import static Util.Utils.*;
import static Util.Utils.EtatTuile.*;
import static Util.Utils.TypeCarteTresor.*;
import Vue.*;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author bassetlu
 */
public class Controleur implements Observateur {

    // Attributs
    private int niveauEau;
    private boolean tresorsRecup;
    private int numTour;
    private int actionChoisie;
    private boolean aventurierMort;
    private int pa;
    private Aventurier joueurCourant;

    // Vues
    private VueInscription vueDebut;
    private VuePlateauJoueur jeuPrincipal;
    private VueGrille plateau;
    private int casJeu;

    // Associations
    private Grille grille;
    private Aventurier joueur1;
    private Aventurier joueur2;
    private Aventurier joueur3;
    private Aventurier joueur4;
    private int nbJoueurs;
    private ArrayList<Aventurier> aventuriers;
    private ArrayList<Tuile> tuiles;
    private ArrayList<Carte_Tirage_Tresor> piocheTresor;
    private ArrayList<Carte_Tirage_Tresor> defausseTresor;
    private ArrayList<Carte_Inond> piocheInond;
    private ArrayList<Carte_Inond> supprimeInond;

    // constructeur
    public Controleur() {
        vueDebut = new VueInscription(this);
        vueDebut.addObservateur(this);
        this.piocheTresor = new ArrayList<>();
        this.defausseTresor = new ArrayList<>();
        this.piocheInond = new ArrayList<>();
        this.supprimeInond = new ArrayList<>();
        setGrille(grille);
    }

    // methodes de la classe
    //getter
    public int getPA() {
        return pa;
    }

    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    public Grille getGrille() {
        return grille;
    }

    public int getNiveauEau() {
        return niveauEau;
    }

    public Aventurier getJoueurCourant() {
        return joueurCourant;
    }

    public ArrayList<Carte_Tirage_Tresor> getPiocheTresor() {
        return piocheTresor;
    }

    // Setter 
    public void setGrille(Grille grille) {
        this.grille = grille; // this.joueurCourant = joueur1;grille;
    }

    public void setJoueurCourant(Aventurier joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public void setPA(int pa) {
        this.pa = pa;
    }

    public void setPAMoins1(int pa) {
        this.pa = pa - 1;
        System.out.println("PA actuel : " + getPA());
    }

    public void setPlateau(VueGrille plateau) {
        this.plateau = plateau;
    }

    // Initialisation
    public void initGrille() {
        grille = new Grille(tuiles, piocheInond);
        grille.afficheGrille();
        System.out.println("");
        grille.afficheNomGrille();
    }

    //vérifie que les tuiles coulée ne sont pas présente dans la pioche des cartes innondation
    //peu aussi fonctionner si on boucle sur la pioche et que l'on utilise getTuile()
    public void initPiocheInondation() {
        for (int i = 0; i < piocheInond.size(); i++) {
            if (piocheInond.get(i).getTuile().getEtat() == COULEE) {
                supprimeInond.add(piocheInond.get(i));
                piocheInond.remove(i);
            }
        }
    }

    public void initJoueurs(String j1, String j2, String j3, String j4) {

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

        aventuriers = new ArrayList<>();

        //ArrayList<Pion> pionsRandom = pion.getListePionsRandom();
        // CREATION DES JOUEURS
        if (this.nbJoueurs == 2) {
            joueur1 = new Aventurier(j1, pionsRandom.get(0), this);
            joueur2 = new Aventurier(j2, pionsRandom.get(1), this);
            aventuriers.add(joueur1);
            aventuriers.add(joueur2);
        } else if (this.nbJoueurs == 3) {
            joueur1 = new Aventurier(j1, pionsRandom.get(0), this);
            joueur2 = new Aventurier(j2, pionsRandom.get(1), this);
            joueur3 = new Aventurier(j3, pionsRandom.get(2), this);
            aventuriers.add(joueur1);
            aventuriers.add(joueur2);
            aventuriers.add(joueur3);
        } else {
            joueur1 = new Aventurier(j1, pionsRandom.get(0), this);
            joueur2 = new Aventurier(j2, pionsRandom.get(1), this);
            joueur3 = new Aventurier(j3, pionsRandom.get(2), this);
            joueur4 = new Aventurier(j4, pionsRandom.get(3), this);
            aventuriers.add(joueur1);
            aventuriers.add(joueur2);
            aventuriers.add(joueur3);
            aventuriers.add(joueur4);
        }

        for (int i = 0; i < nbJoueurs; i++) {
            if (aventuriers.get(i).getCouleur() == Pion.ROUGE) {
                aventuriers.get(i).setTuile(grille.getTuileNom("La_Porte_de_Bronze"));

            } else if (aventuriers.get(i).getCouleur() == Pion.BLEU) {
                aventuriers.get(i).setTuile(grille.getTuileNom("Heliport"));

            } else if (aventuriers.get(i).getCouleur() == Pion.JAUNE) {
                aventuriers.get(i).setTuile(grille.getTuileNom("La_Porte_dOr"));

            } else if (aventuriers.get(i).getCouleur() == Pion.VERT) {
                aventuriers.get(i).setTuile(grille.getTuileNom("La_Porte_de_Cuivre"));

            } else if (aventuriers.get(i).getCouleur() == Pion.VIOLET) {
                aventuriers.get(i).setTuile(grille.getTuileNom("La_Porte_de_Fer"));

            } else if (aventuriers.get(i).getCouleur() == Pion.ORANGE) {
                aventuriers.get(i).setTuile(grille.getTuileNom("La_Porte_dArgent"));
            }
        }

        System.out.println("Joueurs initalisés");
        setJoueurCourant(joueur1);
        this.pa = 3;
    }

    public void initPartie(int nbJoueurs, String j1, String j2, String j3, String j4, int difficulte) {
        this.nbJoueurs = nbJoueurs;
        this.initGrille();

        initPiocheInondation();
        initPiocheTresor();

        this.initJoueurs(j1, j2, j3, j4);
        this.niveauEau = difficulte;

        jeuPrincipal = new VuePlateauJoueur(this);
        jeuPrincipal.addObservateur(this);
        jeuPrincipal.setNomJoueur(joueurCourant.getNom());
        plateau.addObservateur(this);

        System.out.println("aled1");
        // System.out.println("c'est a " + joueurCourant.getNom());
        //this.debutTour(joueurCourant);
        System.out.println("aled2");
    }

    /* public void initJoueurs() {
    }*/
    //creation de la pioche de carte trésor
    public void initPiocheTresor() {
        Carte_Tirage_Tresor le_Cristal_ardent_1 = new Carte_Tresor(LE_CRISTAL_ARDENT);
        piocheTresor.add(le_Cristal_ardent_1);
        Carte_Tirage_Tresor le_Cristal_ardent_2 = new Carte_Tresor(LE_CRISTAL_ARDENT);
        piocheTresor.add(le_Cristal_ardent_2);
        Carte_Tirage_Tresor le_Cristal_ardent_3 = new Carte_Tresor(LE_CRISTAL_ARDENT);
        piocheTresor.add(le_Cristal_ardent_3);
        Carte_Tirage_Tresor le_Cristal_ardent_4 = new Carte_Tresor(LE_CRISTAL_ARDENT);
        piocheTresor.add(le_Cristal_ardent_4);
        Carte_Tirage_Tresor le_Cristal_ardent_5 = new Carte_Tresor(LE_CRISTAL_ARDENT);
        piocheTresor.add(le_Cristal_ardent_5);
        Carte_Tirage_Tresor la_Statue_du_zephyr_1 = new Carte_Tresor(LA_STATUE_DU_ZEPHYR);
        piocheTresor.add(la_Statue_du_zephyr_1);
        Carte_Tirage_Tresor la_Statue_du_zephyr_2 = new Carte_Tresor(LA_STATUE_DU_ZEPHYR);
        piocheTresor.add(la_Statue_du_zephyr_2);
        Carte_Tirage_Tresor la_Statue_du_zephyr_3 = new Carte_Tresor(LA_STATUE_DU_ZEPHYR);
        piocheTresor.add(la_Statue_du_zephyr_3);
        Carte_Tirage_Tresor la_Statue_du_zephyr_4 = new Carte_Tresor(LA_STATUE_DU_ZEPHYR);
        piocheTresor.add(la_Statue_du_zephyr_4);
        Carte_Tirage_Tresor la_Statue_du_zephyr_5 = new Carte_Tresor(LA_STATUE_DU_ZEPHYR);
        piocheTresor.add(la_Statue_du_zephyr_5);
        Carte_Tirage_Tresor le_Calice_de_londe_1 = new Carte_Tresor(LE_CALICE_DE_LONDE);
        piocheTresor.add(le_Calice_de_londe_1);
        Carte_Tirage_Tresor le_Calice_de_londe_2 = new Carte_Tresor(LE_CALICE_DE_LONDE);
        piocheTresor.add(le_Calice_de_londe_2);
        Carte_Tirage_Tresor le_Calice_de_londe_3 = new Carte_Tresor(LE_CALICE_DE_LONDE);
        piocheTresor.add(le_Calice_de_londe_3);
        Carte_Tirage_Tresor le_Calice_de_londe_4 = new Carte_Tresor(LE_CALICE_DE_LONDE);
        piocheTresor.add(le_Calice_de_londe_4);
        Carte_Tirage_Tresor le_Calice_de_londe_5 = new Carte_Tresor(LE_CALICE_DE_LONDE);
        piocheTresor.add(le_Calice_de_londe_5);
        Carte_Tirage_Tresor la_Pierre_sacree_1 = new Carte_Tresor(LA_PIERRE_SACREE);
        piocheTresor.add(la_Pierre_sacree_1);
        Carte_Tirage_Tresor la_Pierre_sacree_2 = new Carte_Tresor(LA_PIERRE_SACREE);
        piocheTresor.add(la_Pierre_sacree_2);
        Carte_Tirage_Tresor la_Pierre_sacree_3 = new Carte_Tresor(LA_PIERRE_SACREE);
        piocheTresor.add(la_Pierre_sacree_3);
        Carte_Tirage_Tresor la_Pierre_sacree_4 = new Carte_Tresor(LA_PIERRE_SACREE);
        piocheTresor.add(la_Pierre_sacree_4);
        Carte_Tirage_Tresor la_Pierre_sacree_5 = new Carte_Tresor(LA_PIERRE_SACREE);
        piocheTresor.add(la_Pierre_sacree_5);
        Carte_Tirage_Tresor montee_des_eaux_1 = new Carte_Montee_Des_Eaux();
        piocheTresor.add(montee_des_eaux_1);
        Carte_Tirage_Tresor montee_des_eaux_2 = new Carte_Montee_Des_Eaux();
        piocheTresor.add(montee_des_eaux_2);
        Carte_Tirage_Tresor montee_des_eaux_3 = new Carte_Montee_Des_Eaux();
        piocheTresor.add(montee_des_eaux_3);
        Carte_Tirage_Tresor helicoptere_1 = new Carte_Helico();
        piocheTresor.add(helicoptere_1);
        Carte_Tirage_Tresor helicoptere_2 = new Carte_Helico();
        piocheTresor.add(helicoptere_2);
        Carte_Tirage_Tresor helicoptere_3 = new Carte_Helico();
        piocheTresor.add(helicoptere_3);
        Carte_Tirage_Tresor sac_1 = new Carte_Sac();
        piocheTresor.add(sac_1);
        Carte_Tirage_Tresor sac_2 = new Carte_Sac();
        piocheTresor.add(sac_2);
    }

    public void initPositionAventurier() {
        ////
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
        setPA(0);
        System.out.println("Tour terminé");
//        if (verifPartieFinie()) {
//            if (verifPartieGagnee()) {
//                System.out.println("partie finie et gagnée");
//            } else {
//                System.out.println("partie finie et perdue");
//            }
//        } else {
        // piocherCarteInondation();
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
        this.setPA(3);
        //debutTour(joueurCourant);
//        }
    }

    // Verification
    // True si la parti est finie
    public boolean verifPartieFinie() {
        if (getNiveauEau() == 10) {
            return true;
        } else {
            return false;
        }
    }

    //true si la partie est gagné, false si elle est perdue
    public boolean verifPartieGagnee() {
        //if () {
        return true;
        //} else {
        //return false;
        //}
    }

    // Actions
    public void addTresor() {
        ////
    }

    public void piocherCarteInondation() {
        if (getNiveauEau() <= 2) {
            //nb de cartes a piocher = 2
            for (int i = 0; i <= 1; i++) {
                if (piocheInond.get(i).getTuile().getEtat() == ASSECHEE) {
                    piocheInond.get(i).getTuile().majEtat(INONDEE);
                } else if (piocheInond.get(i).getTuile().getEtat() == INONDEE) {
                    piocheInond.get(i).getTuile().majEtat(COULEE);
                    supprimeInond.add(piocheInond.get(i));
                    piocheInond.remove(i);
                } else {
                    System.err.println("on ne peut pas piocher une carte coulee");
                }
            }
        } else if (getNiveauEau() <= 5) {
            //nb de cartes a piocher = 3
            for (int i = 0; i <= 2; i++) {
                if (piocheInond.get(i).getTuile().getEtat() == ASSECHEE) {
                    piocheInond.get(i).getTuile().majEtat(INONDEE);
                } else if (piocheInond.get(i).getTuile().getEtat() == INONDEE) {
                    piocheInond.get(i).getTuile().majEtat(COULEE);
                    supprimeInond.add(piocheInond.get(i));
                    piocheInond.remove(i);
                } else {
                    System.err.println("on ne peut pas piocher une carte coulee");
                }
            }
        } else if (getNiveauEau() <= 7) {
            //nb de cartes a piocher = 4
            for (int i = 0; i <= 3; i++) {
                if (piocheInond.get(i).getTuile().getEtat() == ASSECHEE) {
                    piocheInond.get(i).getTuile().majEtat(INONDEE);
                } else if (piocheInond.get(i).getTuile().getEtat() == INONDEE) {
                    piocheInond.get(i).getTuile().majEtat(COULEE);
                    supprimeInond.add(piocheInond.get(i));
                    piocheInond.remove(i);
                } else {
                    System.err.println("on ne peut pas piocher une carte coulée");
                }
            }
        } else if (getNiveauEau() <= 9) {
            //nb de cartes a piocher = 5
            for (int i = 0; i <= 4; i++) {
                if (piocheInond.get(i).getTuile().getEtat() == ASSECHEE) {
                    piocheInond.get(i).getTuile().majEtat(INONDEE);
                } else if (piocheInond.get(i).getTuile().getEtat() == INONDEE) {
                    piocheInond.get(i).getTuile().majEtat(COULEE);
                    supprimeInond.add(piocheInond.get(i));
                    piocheInond.remove(i);
                } else {
                    System.err.println("on ne peut pas piocher une carte coulée");
                }
            }
        }
    }

    public void piocherCarte(Aventurier aventurier) {
        aventurier.getInventaire().add((Carte_Tirage_Tresor) (getPiocheTresor().get(0)));
        getPiocheTresor().remove(0);
    }

    //pour l'instant defause les premières cartes
    public void defausserCarteTresor(Aventurier aventurier) {
        if (aventurier.getNbCartes() > 5) {
            while (aventurier.getNbCartes() > 5) {
                defausseTresor.add(aventurier.getInventaire().get(0));
                aventurier.getInventaire().remove(0);
            }
        }
    }

    public void deplacement(Aventurier aventurier) {
        ArrayList<Tuile> posPosi = new ArrayList<>();
        posPosi = aventurier.posAutourPossible();
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
            aventurier.setTuile(grille.getTuileCase(x, y));
            setPAMoins1(getPA());
        } else {
            System.out.println("pas de déplacement possible");
        }
        System.out.println("position du joueur actuel : " + aventurier.getTuile().getNomTuile());
    }

    public void deplacementGratuit(Aventurier aventurier) {
        System.out.println("Le joueur est sur une case coulée au début de son tour, il peu donc se déplacer sur une tuile adjacente gratuitement");
        ArrayList<Tuile> posPosi = new ArrayList<>();
        posPosi = aventurier.posAutourPossible();
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
            aventurier.setTuile(grille.getTuileCase(x, y));
        } else {
            System.out.println("pas de déplacement possible");
        }
        System.out.println("position du joueur actuel : " + aventurier.getTuile().getNomTuile());
    }

    public void assechement(Aventurier aventurier) {
        ArrayList<Tuile> asse = new ArrayList<>();
        asse = aventurier.AssechementAutourPossible();
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

    public void monteeEau(int monte) {
        niveauEau = +monte;
    }

    // Traiter message car Controleur=Obervé
    public void traiterMessage(Message msg) {

        switch (msg.type) {
            case JOUER:
                initPartie(msg.nbJoueurs, msg.joueur1, msg.joueur2, msg.joueur3, msg.joueur4, msg.difficulte);
                break;

            case CHOISIR_SE_DEPLACER:
                //quand le joueur choisie de ce déplacer, l'ihm lui propose les cases sur lesuqels le déplacement est possible
                if (getPA() != 0) {
                    casJeu = msg.casJeu;
                    plateau.affichePosPossible(getJoueurCourant().posAutourPossible());
                    jeuPrincipal.setBtn5Etat();
                    jeuPrincipal.quandSeDeplacer();

                } else {
                    System.out.println("PLUS DE PA");
                }
                break;

            case SE_DEPLACER_VERS:
                //le joueur choisie une case parmi celle proposée précdement
                System.out.println("test recoit dans deplacer vers (reception) " + msg.type);
                if (getPA() != 0) {
                    setPA(pa - 1);
                    int x = msg.uneCaseX;
                    int y = msg.uneCaseY;
                    System.out.println("Je reçois X : " + msg.uneCaseX);
                    System.out.println("Je reçois Y : " + msg.uneCaseY);
                    if (casJeu == 0) {
                        joueurCourant.setTuile(getGrille().getTuileCase(x, y));
                        jeuPrincipal.setBtn5Etat();

                        jeuPrincipal.updatePlateauJoueur();
                        plateau.addObservateur(this);
                    } else if (casJeu == 1) {
                        getGrille().getTuileCase(x, y).majEtat(ASSECHEE);
                        jeuPrincipal.setBtn5Etat();

                        jeuPrincipal.updatePlateauJoueur();
                        plateau.addObservateur(this);
                    }
                    if (getPA() == 0) {
                        jeuPrincipal.tourTerminé();
                    }
                }
                break;

            case CHOISIR_ASSECHER:
                ////
                System.out.println("test recoit dans assecher vers (reception) " + msg.type);
                if (getPA() != 0) {
                    plateau.affichePosPossible(getJoueurCourant().AssechementAutourPossible());
                    jeuPrincipal.setBtn5Etat();

                    jeuPrincipal.quandSeDeplacer();
                    casJeu = msg.casJeu;

                    if (getPA() == 0) {
                        jeuPrincipal.setBtn5Etat();

                        jeuPrincipal.tourTerminé();
                    }
                }
                break;

            case ECHANGER:
                ////
                break;

            case RECUP_TRESOR:
                ////
                break;

            case TERMINER_TOUR:

                System.out.println("test recoit terminé tour ) " + msg.type);
                this.terminerTour();
                jeuPrincipal.updatePlateauJoueur();
                plateau.addObservateur(this);
                break;

            case ANNULER_ACTION:
                System.out.println("J'ai reçu annuler !");
                jeuPrincipal.setBtn5Etat();
                jeuPrincipal.updatePlateauJoueur();
                // CONTINUE METHODE MEME SI ANNULER OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
                break;
        }
    }
}
