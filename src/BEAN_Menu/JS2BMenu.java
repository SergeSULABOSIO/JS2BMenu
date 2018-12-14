/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN_Menu;

import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author user
 */
public class JS2BMenu {

    private JTree tree = null;
    private final JScrollPane scrollPaneMenu;
    private DefaultMutableTreeNode tree_racine = null;
    private DefaultMutableTreeNode tree_utilisateur = null;
    private final String nomUtilisateur;
    private final String nomApplication;
    private final Vector<MenuRubrique> ListeRubriques = new Vector<>();
    private int tailleTexte;

    public JS2BMenu(JScrollPane scrollPaneMenu, String nomUtilisateur, String nomApplication, int tailleTexte) {
        this.scrollPaneMenu = scrollPaneMenu;
        this.tailleTexte = tailleTexte;
        this.nomUtilisateur = nomUtilisateur;
        this.nomApplication = nomApplication;

        this.tree_racine = new DefaultMutableTreeNode(this.nomApplication);
        this.tree_utilisateur = new DefaultMutableTreeNode(this.nomUtilisateur);
    }

    public void AjouterRubrique(MenuRubrique rubrique) {
        if (!ListeRubriques.contains(rubrique)) {
            ListeRubriques.add(rubrique);
        }
        if (tree_utilisateur != null) {
            tree_utilisateur.removeAllChildren();
            ListeRubriques.forEach((rub) -> {
                tree_utilisateur.add(new DefaultMutableTreeNode(rub));
            });
            dessinerMenu();
        }
    }

    private void dessinerMenu() {
        tree_racine.add(tree_utilisateur);
        tree = new JTree(tree_racine);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        ecouterSelectionRubrique();
        tree.setCellRenderer(new MenuCellRenderer(tailleTexte));
        tree.expandPath(new TreePath(tree_utilisateur.getPath()));
        scrollPaneMenu.setViewportView(tree);
    }

    private void ecouterSelectionRubrique() {
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                /* if nothing is selected */
                if (node == null) {
                    return;
                }
                if (node.getUserObject() instanceof MenuRubrique) {
                    MenuRubrique rubrique = (MenuRubrique) node.getUserObject();
                    if (rubrique != null) {
                        rubrique.ecouterSelection();
                    }
                }
            }
        });
    }

}
