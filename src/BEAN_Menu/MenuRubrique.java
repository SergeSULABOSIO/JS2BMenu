/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN_Menu;

import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class MenuRubrique {
    
    private String nom;
    private ImageIcon icone;
    private MenuRubriqueListener ecouteur;

    public MenuRubrique(String nom, ImageIcon icone, MenuRubriqueListener ecouteur) {
        this.nom = nom;
        this.icone = icone;
        this.ecouteur = ecouteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    public void ecouterSelection(){
        ecouteur.OnEcouterLaSelection();
    }
    
    

    @Override
    public String toString() {
        return "Rubrique{" + "nom=" + nom + ", icone=" + icone + '}';
    }
    
    
}
