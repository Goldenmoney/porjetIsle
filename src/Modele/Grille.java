/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

//ca marche ?
import Util.Utils;
import java.util.ArrayList;

/** tuiles;
 *
 * @author bassetlu
 */
public class Grille {
    // Associations
//je fais la grille (jules)

    private final int nbTuiles = 36;
    private Tuile tableauTuiles[][] = new Tuile[6][6];

    // construction
    public Grille(ArrayList<Tuile> tuiles) {
        tuiles = new ArrayList<>();

        //remplissage arraylist tuiles
        Tuile Le_Pont_des_Abimes = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Pont_des_Abimes);
        tuiles.add(Le_Pont_des_Abimes);
        Tuile La_Porte_de_Bronze = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.La_Porte_de_Bronze);
        tuiles.add(La_Porte_de_Bronze);
        Tuile La_Caverne_des_Ombres = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Caverne_des_Ombres);
        tuiles.add(La_Caverne_des_Ombres);
        Tuile La_Porte_de_Fer = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Porte_de_Fer);
        tuiles.add(La_Porte_de_Fer);
        Tuile La_Porte_dOr = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Porte_dOr);
        tuiles.add(La_Porte_dOr);
        Tuile Les_Falaises_de_lOubli = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Les_Falaises_de_lOubli);
        tuiles.add(Les_Falaises_de_lOubli);
        Tuile Le_Palais_de_Corail = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Palais_de_Corail);
        tuiles.add(Le_Palais_de_Corail);
        Tuile La_Porte_dArgent = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Porte_dArgent);
        tuiles.add(La_Porte_dArgent);
        Tuile Les_Dunes_de_lIllusion = new Tuile(Utils.EtatTuile.COULEE, Utils.NomTuile.Les_Dunes_de_lIllusion);
        tuiles.add(Les_Dunes_de_lIllusion);
        Tuile Heliport = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Heliport);
        tuiles.add(Heliport);
        Tuile La_Porte_de_Cuivre = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Porte_de_Cuivre);
        tuiles.add(La_Porte_de_Cuivre);
        Tuile Le_Jardin_des_Hurlements = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Jardin_des_Hurlements);
        tuiles.add(Le_Jardin_des_Hurlements);
        Tuile La_Foret_Pourpre = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Foret_Pourpre);
        tuiles.add(La_Foret_Pourpre);
        Tuile Le_Lagon_Perdu = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.Le_Lagon_Perdu);
        tuiles.add(Le_Lagon_Perdu);
        Tuile Le_Marais_Brumeux = new Tuile(Utils.EtatTuile.COULEE, Utils.NomTuile.Le_Marais_Brumeux);
        tuiles.add(Le_Marais_Brumeux);
        Tuile Observatoire = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.Observatoire);
        tuiles.add(Observatoire);
        Tuile Le_Rocher_Fantome = new Tuile(Utils.EtatTuile.COULEE, Utils.NomTuile.Le_Rocher_Fantome);
        tuiles.add(Le_Rocher_Fantome);
        Tuile La_Caverne_du_Brasier = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.La_Caverne_du_Brasier);
        tuiles.add(La_Caverne_du_Brasier);
        Tuile Le_Temple_du_Soleil = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Temple_du_Soleil);
        tuiles.add(Le_Temple_du_Soleil);
        Tuile Le_Temple_de_La_Lune = new Tuile(Utils.EtatTuile.COULEE, Utils.NomTuile.Le_Temple_de_La_Lune);
        tuiles.add(Le_Temple_de_La_Lune);
        Tuile Le_Palais_des_Marees = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Palais_des_Marees);
        tuiles.add(Le_Palais_des_Marees);
        Tuile Le_Val_du_Crepuscule = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Val_du_Crepuscule);
        tuiles.add(Le_Val_du_Crepuscule);
        Tuile La_Tour_du_Guet = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Tour_du_Guet);
        tuiles.add(La_Tour_du_Guet);
        Tuile Le_Jardin_des_Murmures = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.Le_Jardin_des_Murmures);
        tuiles.add(Le_Jardin_des_Murmures);

        for (int i = 0; i < tuiles.size(); i++) {

            for (int j = 0; j < 6; j++) {

                if (j == 0) {
                    tableauTuiles[j][0] = null;
                    tableauTuiles[j][1] = null;
                    for (int k = 2; k <= 3; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                        tuiles.get(i).setPosX(j);
                        tuiles.get(i).setPosY(k);
                        i++;
                    }
                    tableauTuiles[j][4] = null;
                    tableauTuiles[j][5] = null;
                } else if (j == 1) {
                    tableauTuiles[j][0] = null;
                    for (int k = 1; k <= 4; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                       tuiles.get(i).setPosX(j);
                        tuiles.get(i).setPosY(k);
                        i++;
                    }
                    tableauTuiles[j][5] = null;
                } else if (j == 2 || j == 3) {
                    for (int k = 0; k <= 5; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                        tuiles.get(i).setPosX(j);
                        tuiles.get(i).setPosY(k);
                        i++;
                    }
                } else if (j == 4) {
                    tableauTuiles[j][0] = null;
                    for (int k = 1; k <= 4; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                       tuiles.get(i).setPosX(j);
                        tuiles.get(i).setPosY(k);
                        i++;
                    }
                    tableauTuiles[j][5] = null;
                } else if (j == 5) {
                    tableauTuiles[j][0] = null;
                    tableauTuiles[j][1] = null;
                    for (int k = 2; k <= 3; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                       tuiles.get(i).setPosX(j);
                        tuiles.get(i).setPosY(k);
                        i++;
                    }
                    tableauTuiles[j][4] = null;
                    tableauTuiles[j][5] = null;
                }
            }
        }
    }

     //Getters
    public int getNbTuiles() {
        return nbTuiles;
    }
    
    public Tuile getTuileCase(int x, int y) {
        return this.tableauTuiles[x][y];
    }
 
  public void afficheGrille() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (getTuileCase(x, y) == null) {
                    System.out.print("| VIDE  \t");
                } else {
                    System.out.print("|  "+getTuileCase(x, y).getEtat() + "      ");
                }
            }
            System.out.println("");
        }
    }
    public void afficheNomGrille() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (getTuileCase(x, y) == null) {
                    System.out.print("VIDE \t\t");
                } else {
                    System.out.print(getTuileCase(x, y).getNomTuile()+ "\t");
                }
            }
            System.out.println("");
        }
    }
    
    
}
//arraylist ou hashmap, getTuile assechées, coulées... ou ?? 
