package com.scrollarchivist.simplescrollarchivistrepository.views.tools;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import views.tools.SARTableButtonEnum;
import views.tools.SARTableButtons;
/**
 * [] - class
 * @author Mathaus
 */
public class SARCellRenderer extends DefaultTableCellRenderer {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        JPanel tableSubMenu = new JPanel();
        tableSubMenu.setBackground(Colors.IVORY);
        tableSubMenu.setPreferredSize(new Dimension(0, 26));
        tableSubMenu.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        JButton button = new SARTableButtons(SARTableButtonEnum.SAVE);
        JButton button2 = new SARTableButtons(SARTableButtonEnum.CANCEL);
        JButton button3 = new SARTableButtons(SARTableButtonEnum.EDIT);
        tableSubMenu.add(button);
        tableSubMenu.add(button2);
        tableSubMenu.add(button3);
        return tableSubMenu;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}