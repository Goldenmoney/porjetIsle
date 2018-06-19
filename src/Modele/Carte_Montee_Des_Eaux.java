/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils;
import Util.Utils.TypeCarteTresor;
import static Util.Utils.TypeCarteTresor.MONTEE_DES_EAUX;

/**
 *
 * @author pontalc
 */
public class Carte_Montee_Des_Eaux extends Carte_Tirage_Tresor {
    
    public Carte_Montee_Des_Eaux(TypeCarteTresor type) {
        super(MONTEE_DES_EAUX);
    }

    @Override
    public void action() {
        aventurier.getControleur().monteeEau(1);
        aventurier.getControleur().piocherCarteInondation();
        aventurier.defausserCarte(this);
    }
    
}
