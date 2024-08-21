package views;
import java.io.File;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 * [] - class
 * @author Mathaus
 */
    public class FileTableModel extends AbstractTableModel {

        private List<File> files;

        public FileTableModel(List<File> files) {
            this.files = files;
        }

        @Override
        public int getRowCount() {
            return files.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 1;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 1:
                    return File.class;
                default:
                    return String.class;
            }
        }

        @Override
        public Object getValueAt(int row, int col) {
            File file = files.get(row);
            switch (col) {
                case 0:
                    return file.getName();
                case 1:
                    return file;
            }
            return null;
        }

    }
