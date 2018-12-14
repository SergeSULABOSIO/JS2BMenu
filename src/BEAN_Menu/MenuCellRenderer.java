/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN_Menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author user
 */
public class MenuCellRenderer implements TreeCellRenderer {

    private JLabel label = null;

    public MenuCellRenderer(int tailleTexte) {
        this.label = new JLabel();
        this.label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, tailleTexte));
        this.label.setForeground(Color.darkGray);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Object objTree = ((DefaultMutableTreeNode) value).getUserObject();
        if (objTree instanceof MenuRubrique) {
            MenuRubrique rubrique = (MenuRubrique) objTree;
            label.setIcon(rubrique.getIcone());
            label.setText(rubrique.getNom());
        } else {
            label.setIcon(null);
            label.setText("" + value);
        }
        
        if(selected == true){
            this.label.setForeground(Color.WHITE);
            this.label.setBackground(Color.darkGray);
        }else{
            this.label.setForeground(Color.darkGray);
            this.label.setBackground(Color.white);
        }
        return label;
    }

}
