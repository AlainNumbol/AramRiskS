/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moteur;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author alain
 */

    
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
 
/**
 * Définir l'affichage dans un JTable
 * @author Fobec 2010
 */
public class ColorRenderer extends DefaultTableCellRenderer {
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        /**
         * Fixer la couleur de fond de la première colonne en jaune
         */
        if (column == 0) {
            Color clr = new Color(255, 255, 240);
            component.setBackground(clr);
        } else {
            Color clr = new Color(255, 255, 255);
            component.setBackground(clr);
        }
        /**
         * Colorier les cellules en orange si le montant est négatif
         */
        Object o = table.getValueAt(row, 8);
        if (o != null && component instanceof JLabel) {
            JLabel label = (JLabel) component;
            if (label.getText().contains("-")) {
                Color clr = new Color(255, 226, 198);
                component.setBackground(clr);
            }
            /**
             * Center le texte pour la colonne 0 et aligner le texte à droite pour les autres colonnes
             */
            if (column == 0) {
                label.setHorizontalAlignment(CENTER);
            } else {
                label.setHorizontalAlignment(RIGHT);
            }
        }
        return component;
    }
}