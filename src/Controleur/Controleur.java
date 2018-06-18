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
import static Util.Utils.Pion.ROUGE;
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
    private ArrayList<Aventurier> joueurs;
    private Carte_Tresor piocheTresor;
    private Carte_Tresor defausseTresor;
    private Carte_Inond piocheInond;
    private Carte_Inond supprimeInond;

    // constructeur
    public void controleur() {
        this.pa = pa;
        this.tuiles = new ArrayList<>();
        this.joueurs = new ArrayList<>();
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
        joueur1 = new Aventurier("je sais pas qui", ROUGE, grille.getTuileCase(4, 3));
    }
    
   public void initPartie(){
        this.initGrille();
        this.initJoueurs();
        this.debutTour(joueur1);
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
        return TypesMessages.SE_DEPLACER; ////
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
            } else {
                System.out.println("pas de déplacement possible");
            }
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
            } else {
                System.out.println("pas d'assechement possible");
            }
              ArrayList<Tuile> asseAft = new ArrayList<>();
             asseAft = aventurier.AssechementAutourPossible(grille);
             if (!asseAft.isEmpty()){
                 for (int i = 0; i < asseAft.size();i ++) {
                System.out.print(i + ". ");
                System.out.println(asseAft.get(i).getNomTuile());
                }  
             } else {
                 System.out.println("pas d'assechement possible");
             }
    }

    public void debutTour(Aventurier aventurier) {
        ////
        /*getMainAventurier();
        if (verifCarteSpe()){
            ////
        }*/
        System.out.print("position du joueur actuel : ");
        System.out.println(aventurier.getTuile().getNomTuile());
        

        Scanner sc = new Scanner(System.in);
        System.out.println("se deplacer? oui ou non?");
        String str = sc.nextLine();
        if (str.equalsIgnoreCase("oui")){
             deplacement(aventurier);
        }

        
        
        
        Scanner sc3 = new Scanner(System.in);
        System.out.println("assecher ? oui ou non ?");
        String str3 = sc3.nextLine();
        if (str3.equalsIgnoreCase("oui")){
            assechement(aventurier);
        }
        
        
        System.out.print("position du joueur actuel : ");
        System.out.println(aventurier.getTuile().getNomTuile());
        
        
        
        
    }

    public void terminerTour() {
        setPa(0);
        System.out.println("Tour terminer");
    }


    // Traiter message car Controleur=Obervé
    public void traiterMessage(Message msg) {
        switch (msg.type) {
            case SE_DEPLACER:
                ////
                break;
            case ASSECHER:
                ////
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
