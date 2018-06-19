/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Controleur.Observateur;
import Controleur.Message;

/**
 *
 * @author bassetlu
 */
public class Observe extends javax.swing.JFrame {
    private Observateur observateur;
    
    public void addObservateur(Observateur o) {
        this.observateur = o;
    }
    
    public void notifierObservateur(Message m) {
        if (observateur != null) {
            observateur.traiterMessage(m);
        }
        System.out.println("LOOOOOOOOOOOOL");
    }
}
