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
        Carte_Inond  Carte_Inond_Le_Pont_des_Abimes = new Carte_Inond(Le_Pont_des_Abimes);
        Le_Pont_des_Abimes.setCarte_Inond(Carte_Inond_Le_Pont_des_Abimes);
        tuiles.add(Le_Pont_des_Abimes);
        
        Tuile La_Porte_de_Bronze = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.La_Porte_de_Bronze);
        Carte_Inond  Carte_Inond_La_Porte_de_Bronze = new Carte_Inond(La_Porte_de_Bronze);
        La_Porte_de_Bronze.setCarte_Inond(Carte_Inond_La_Porte_de_Bronze);
        tuiles.add(La_Porte_de_Bronze);
        
        Tuile La_Caverne_des_Ombres = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Caverne_des_Ombres);
        Carte_Inond  Carte_Inond_La_Caverne_des_Ombres = new Carte_Inond(La_Caverne_des_Ombres);
        La_Caverne_des_Ombres.setTypeTresor(Utils.TypeTresor.LE_CRISTAL_ARDENT);
        La_Caverne_des_Ombres.setCarte_Inond(Carte_Inond_La_Caverne_des_Ombres);
        tuiles.add(La_Caverne_des_Ombres);
        
        Tuile La_Porte_de_Fer = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Porte_de_Fer);
        Carte_Inond  Carte_Inond_La_Porte_de_Fer = new Carte_Inond(La_Porte_de_Fer);
        La_Porte_de_Fer.setCarte_Inond(Carte_Inond_La_Porte_de_Fer);
        tuiles.add(La_Porte_de_Fer);
        
        Tuile La_Porte_dOr = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Porte_dOr);
        Carte_Inond  Carte_Inond_La_Porte_dOr = new Carte_Inond(La_Porte_dOr);
        La_Porte_dOr.setCarte_Inond(Carte_Inond_La_Porte_dOr);
        tuiles.add(La_Porte_dOr);
        
        Tuile Les_Falaises_de_lOubli = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Les_Falaises_de_lOubli);
        Carte_Inond  Carte_Inond_Les_Falaises_de_lOubli = new Carte_Inond(Les_Falaises_de_lOubli);
        Les_Falaises_de_lOubli.setCarte_Inond(Carte_Inond_Les_Falaises_de_lOubli);
        tuiles.add(Les_Falaises_de_lOubli);
        
        Tuile Le_Palais_de_Corail = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Palais_de_Corail);
        Carte_Inond  Carte_Inond_Le_Palais_de_Corail= new Carte_Inond(Le_Palais_de_Corail);
        Le_Palais_de_Corail.setTypeTresor(Utils.TypeTresor.LE_CALICE_DE_LONDE);
        Le_Palais_de_Corail.setCarte_Inond(Carte_Inond_Le_Palais_de_Corail);
        tuiles.add(Le_Palais_de_Corail);
        
        Tuile La_Porte_dArgent = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Porte_dArgent);
        Carte_Inond  Carte_Inond_La_Porte_dArgent= new Carte_Inond(La_Porte_dArgent);
        La_Porte_dArgent.setCarte_Inond(Carte_Inond_La_Porte_dArgent);
        tuiles.add(La_Porte_dArgent);
        
        Tuile Les_Dunes_de_lIllusion = new Tuile(Utils.EtatTuile.COULEE, Utils.NomTuile.Les_Dunes_de_lIllusion);
        Carte_Inond  Carte_Inond_Les_Dunes_de_lIllusion= new Carte_Inond(Les_Dunes_de_lIllusion);
        Les_Dunes_de_lIllusion.setCarte_Inond(Carte_Inond_Les_Dunes_de_lIllusion);
        tuiles.add(Les_Dunes_de_lIllusion);
        
        Tuile Heliport = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Heliport);
        Carte_Inond  Carte_Inond_Heliport= new Carte_Inond(Heliport);
        Heliport.setCarte_Inond(Carte_Inond_Heliport);
        tuiles.add(Heliport);
        
        Tuile La_Porte_de_Cuivre = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Porte_de_Cuivre);
        Carte_Inond  Carte_Inond_La_Porte_de_Cuivre= new Carte_Inond(La_Porte_de_Cuivre);
        La_Porte_de_Cuivre.setCarte_Inond(Carte_Inond_La_Porte_de_Cuivre);
        tuiles.add(La_Porte_de_Cuivre);
        
        Tuile Le_Jardin_des_Hurlements = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Jardin_des_Hurlements);
        Le_Jardin_des_Hurlements.setTypeTresor(Utils.TypeTresor.LA_STATUE_DU_ZEPHYR);
        Carte_Inond  Carte_Inond_Le_Jardin_des_Hurlements= new Carte_Inond(Le_Jardin_des_Hurlements);
        Le_Jardin_des_Hurlements.setCarte_Inond(Carte_Inond_Le_Jardin_des_Hurlements);
        tuiles.add(Le_Jardin_des_Hurlements);
        
        Tuile La_Foret_Pourpre = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Foret_Pourpre);
        Carte_Inond  Carte_Inond_La_Foret_Pourpre= new Carte_Inond(La_Foret_Pourpre);
        La_Foret_Pourpre.setCarte_Inond(Carte_Inond_La_Foret_Pourpre);
        tuiles.add(La_Foret_Pourpre);
        
        Tuile Le_Lagon_Perdu = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.Le_Lagon_Perdu);
        Carte_Inond  Carte_Inond_Le_Lagon_Perdu= new Carte_Inond(Le_Lagon_Perdu);
        Le_Lagon_Perdu.setCarte_Inond(Carte_Inond_Le_Lagon_Perdu);
        tuiles.add(Le_Lagon_Perdu);
        
        Tuile Le_Marais_Brumeux = new Tuile(Utils.EtatTuile.COULEE, Utils.NomTuile.Le_Marais_Brumeux);
        Carte_Inond  Carte_Inond_Le_Marais_Brumeux= new Carte_Inond(Le_Marais_Brumeux);
        Le_Marais_Brumeux.setCarte_Inond(Carte_Inond_Le_Marais_Brumeux);
        tuiles.add(Le_Marais_Brumeux);
        
        Tuile Observatoire = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.Observatoire);
        Carte_Inond  Carte_Inond_Observatoire= new Carte_Inond(Observatoire);
        Observatoire.setCarte_Inond(Carte_Inond_Observatoire);
        tuiles.add(Observatoire);
        
        Tuile Le_Rocher_Fantome = new Tuile(Utils.EtatTuile.COULEE, Utils.NomTuile.Le_Rocher_Fantome);
        Carte_Inond  Carte_Inond_Le_Rocher_Fantome= new Carte_Inond(Le_Rocher_Fantome);
        Le_Rocher_Fantome.setCarte_Inond(Carte_Inond_Le_Rocher_Fantome);
        tuiles.add(Le_Rocher_Fantome);
        
        Tuile La_Caverne_du_Brasier = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.La_Caverne_du_Brasier);
        Carte_Inond  Carte_Inond_La_Caverne_du_Brasier = new Carte_Inond(La_Caverne_du_Brasier);
        La_Caverne_du_Brasier.setTypeTresor(Utils.TypeTresor.LE_CRISTAL_ARDENT);
        La_Caverne_du_Brasier.setCarte_Inond(Carte_Inond_La_Caverne_du_Brasier);
        tuiles.add(La_Caverne_du_Brasier);
        
        Tuile Le_Temple_du_Soleil = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Temple_du_Soleil);
        Carte_Inond  Carte_Inond_Le_Temple_du_Soleil = new Carte_Inond(Le_Temple_du_Soleil);
        Le_Temple_du_Soleil.setCarte_Inond(Carte_Inond_Le_Temple_du_Soleil);
        Le_Temple_du_Soleil.setTypeTresor(Utils.TypeTresor.LA_PIERRE_SACREE);
        tuiles.add(Le_Temple_du_Soleil);
        
        Tuile Le_Temple_de_La_Lune = new Tuile(Utils.EtatTuile.COULEE, Utils.NomTuile.Le_Temple_de_La_Lune);
        Carte_Inond  Carte_Inond_Le_Temple_de_La_Lune = new Carte_Inond(Le_Temple_de_La_Lune);
        Le_Temple_de_La_Lune.setCarte_Inond(Carte_Inond_Le_Temple_de_La_Lune);
        Le_Temple_de_La_Lune.setTypeTresor(Utils.TypeTresor.LA_PIERRE_SACREE);
        tuiles.add(Le_Temple_de_La_Lune);
        
        Tuile Le_Palais_des_Marees = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Palais_des_Marees);
        Carte_Inond  Carte_Inond_Le_Palais_des_Marees = new Carte_Inond(Le_Palais_des_Marees);
        Le_Palais_des_Marees.setTypeTresor(Utils.TypeTresor.LE_CALICE_DE_LONDE);
        Le_Palais_des_Marees.setCarte_Inond(Carte_Inond_Le_Palais_des_Marees);
        tuiles.add(Le_Palais_des_Marees);
        
        Tuile Le_Val_du_Crepuscule = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.Le_Val_du_Crepuscule);
        Carte_Inond  Carte_Inond_Le_Val_du_Crepuscule = new Carte_Inond(Le_Val_du_Crepuscule);
        Le_Val_du_Crepuscule.setCarte_Inond(Carte_Inond_Le_Val_du_Crepuscule);
        tuiles.add(Le_Val_du_Crepuscule);
        
        Tuile La_Tour_du_Guet = new Tuile(Utils.EtatTuile.ASSECHEE, Utils.NomTuile.La_Tour_du_Guet);
        Carte_Inond  Carte_Inond_La_Tour_du_Guet = new Carte_Inond(La_Tour_du_Guet);
        La_Tour_du_Guet.setCarte_Inond(Carte_Inond_La_Tour_du_Guet);
        tuiles.add(La_Tour_du_Guet);
        
        Tuile Le_Jardin_des_Murmures = new Tuile(Utils.EtatTuile.INONDEE, Utils.NomTuile.Le_Jardin_des_Murmures);
        Carte_Inond  Carte_Inond_Le_Jardin_des_Murmures = new Carte_Inond(Le_Jardin_des_Murmures);
        Le_Jardin_des_Murmures.setTypeTresor(Utils.TypeTresor.LA_STATUE_DU_ZEPHYR);
        Le_Jardin_des_Murmures.setCarte_Inond(Carte_Inond_Le_Jardin_des_Murmures);
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
