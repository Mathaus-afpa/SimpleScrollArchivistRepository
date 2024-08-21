package views.tools;
import com.scrollarchivist.simplescrollarchivistrepository.views.tools.Colors;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
/**
 * [] - class
 * @author Mathaus
 */
public class SARCellEditor extends AbstractCellEditor implements TableCellEditor {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private final JTextField editorComponent = new JTextField();
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    @Override
    public Object getCellEditorValue() {
        return editorComponent.getText();
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editorComponent.setText(value != null ? value.toString() : "");
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