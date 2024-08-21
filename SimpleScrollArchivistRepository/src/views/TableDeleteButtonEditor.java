package views;
import com.scrollarchivist.simplescrollarchivistrepository.views.tools.Colors;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import views.tools.SARTableButtonEnum;
import views.tools.SARTableButtons;
/**
 * [] - class
 * @author Mathaus
 */
    public class TableDeleteButtonEditor extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

        private File source;
        private JButton button;

        public TableDeleteButtonEditor() {
            button = new JButton();
            button.addActionListener(new LoadActionListener());
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        protected JButton prepare(JTable table, Object value, boolean isSelected, int row, int column) {
            if (!(value instanceof File)) {
                source = null;
                button.setEnabled(false);
                return null;
            }
            source = (File) value;
            button.setEnabled(true);
            button.setText(source.getName());
            button.setToolTipText(source.getPath());
            return button;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
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

        @Override
        public Object getCellEditorValue() {
            return source;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
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

        public class LoadActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent evt) {
                // Here, you need to make some decisions about what to do...
                // You have a reference to the File instance
                System.out.println("You clicked " + source);
                stopCellEditing();
            }

        }
    }
    