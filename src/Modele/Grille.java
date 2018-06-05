/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

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
}
//arraylist ou hashmap, getTuile assechées, coulées... ou ?? 
