/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils;
import java.util.ArrayList;

/**
 *
 * @author bassetlu
 */
public class Grille {
    // Associations
//je fais la grille (jules)

    private final int nbTuiles = 36;
    private Tuile tableauTuiles[][] = new Tuile[6][6];

    //Getters
    public int getNbTuiles() {
        return nbTuiles;
    }

    // METHODES
    public Grille(ArrayList<Tuile> tuiles) {

        /*tuiles :  Le_Pont_des_Abimes,
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
        Le_Jardin_des_Murmures*/
        Tuile tuileTest = new Tuile(Utils.EtatTuile.ASSECHEE,Utils.NomTuile.La_Caverne_des_Ombres);
        tuiles.add(tuileTest);
        
        
        /*ASSECHEE("Asséchée"), 
        INONDEE("Inondée"),
        COULEE("Coulée");*/
        
        
        for (int i = 0; i < tuiles.size(); i++) {

            for (int j = 0; j < 6; j++) {

                if (j == 0) {
                    tableauTuiles[j][0] = null;
                    tableauTuiles[j][1] = null;
                    for (int k = 2; k <= 3; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                        i++;
                    }
                    tableauTuiles[j][4] = null;
                    tableauTuiles[j][5] = null;
                } else if (j == 1) {
                    tableauTuiles[j][0] = null;
                    for (int k = 1; k <= 4; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                        i++;
                    }
                    tableauTuiles[j][5] = null;
                } else if (j == 2 || j == 3) {
                    for (int k = 0; k <= 5; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                        i++;
                    }
                } else if (j == 4) {
                    tableauTuiles[j][0] = null;
                    for (int k = 1; k <= 4; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                        i++;
                    }
                    tableauTuiles[j][5] = null;
                } else if (j == 5) {
                    tableauTuiles[j][0] = null;
                    tableauTuiles[j][1] = null;
                    for (int k = 2; k <= 3; k++) {
                        tableauTuiles[j][k] = tuiles.get(i);
                        i++;
                    }
                    tableauTuiles[j][4] = null;
                    tableauTuiles[j][5] = null;
                }
            }
        }
    }
}
//arraylist ou hashmap, getTuile assechées, coulées... ou ?? 
