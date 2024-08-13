package com.scrollarchivist.simplescrollarchivistrepository.views.tools;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
/**
 * [] - class
 * @author Mathaus
 */
public class CustomBasicTabbedPaneUI extends BasicTabbedPaneUI {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
                g.setColor(Colors.IVORY);
                g.fillRect(x, y, width, height);
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x, y, width - 1, height - 1);
            }
            @Override
            protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
                // Ne pas dessiner de bordure autour des onglets
            }
            @Override
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
                // Supprimer la bordure entre les onglets et le contenu
            }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}