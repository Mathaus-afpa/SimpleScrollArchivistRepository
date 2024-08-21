package com.scrollarchivist.simplescrollarchivistrepository.views.tools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 * [] - class
 * @author Mathaus
 */
public class SARTableModel extends AbstractTableModel {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    private Object[][] data;
    private String[] columnNames;
    private final String[] predefinedColumnNames = { "A", "B" };
    private final Object[] predefinedValues = { "Default A", "Default B" };
    public SARTableModel(String[] columnNames) {
       this.columnNames = concatArrays(columnNames, predefinedColumnNames);
        //this.data = appendPredefinedColumns(data);
    }
    public SARTableModel(Object[][] data, String[] columnNames) {
       this.columnNames = concatArrays(columnNames, predefinedColumnNames);
        this.data = appendPredefinedColumns(data);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    @Override
    public int getRowCount() {
        return data.length;
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    private Object[][] appendPredefinedColumns(Object[][] data) {
        if (data.length == 0 || data[0].length == 0) {
            // Si data est vide ou a une longueur incorrecte
            return new Object[0][predefinedValues.length];
        }
        // Crée un tableau avec des colonnes supplémentaires pour les valeurs prédéfinies
        Object[][] newData = new Object[data.length][data[0].length + predefinedValues.length];
        for (int i = 0; i < data.length; i++) {
            // Fusionner les données existantes avec les valeurs prédéfinies
            newData[i] = mergeArrays(data[i], predefinedValues);
        }
        return newData;
    }

    private Object[] mergeArrays(Object[] original, Object[] additional) {
        // Concatène les tableaux
        Object[] merged = new Object[original.length + additional.length];
        System.arraycopy(original, 0, merged, 0, original.length);
        System.arraycopy(additional, 0, merged, original.length, additional.length);
        return merged;
    }

    private String[] concatArrays(String[] original, String[] additional) {
        // Concatène les noms de colonnes
        String[] merged = new String[original.length + additional.length];
        System.arraycopy(original, 0, merged, 0, original.length);
        System.arraycopy(additional, 0, merged, original.length, additional.length);
        return merged;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}