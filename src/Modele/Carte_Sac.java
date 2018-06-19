/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils;
import Util.Utils.TypeCarteTresor;
import static Util.Utils.TypeCarteTresor.SAC_DE_SABLE;

/**
 *
 * @author pontalc
 */
public class Carte_Sac extends Carte_Tirage_Tresor {
    
    public Carte_Sac(TypeCarteTresor type) {
        super(SAC_DE_SABLE);
    }

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
