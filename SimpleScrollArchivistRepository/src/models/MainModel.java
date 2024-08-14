package com.scrollarchivist.simplescrollarchivistrepository.models;
import com.scrollarchivist.scrollarchivistdao.ScrollArchivistDAO;
import java.util.HashMap;
import java.util.Map;
/**
 * [MainModel] - class
 * @author Mathaus
 */
public class MainModel {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainModel.
     */
    private MainModel() {}
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    public final static String APP_TITLE = "Scroll Archivist Repository ~";
    public final static int APP_MIN_WIDTH = 800;
    public final static int APP_MIN_HEIGHT = 600;
    private static String[] appMenuTabs;
    private final static Map<String, String[]> APP_TAB_COLUMNS = new HashMap<>();
    private final static Map<String, Object[][]> APP_TAB_LINES = new HashMap<>();
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    /**
     * Recuperer toutes les donnees a partir de la couche DAO.
     */
    public final static void fetchAllDatas() {
        appMenuTabs = ScrollArchivistDAO.getTablesName();
        for (String table : appMenuTabs) {
            MainModel.fetchTableDatas(table);
        }
    }
    /**
     * Recuperer les donnees d'une table a partir de son nom.
     * @param tableName Nom de la table du dataset.
     */
    private static void fetchTableDatas(String tableName) {
        MainModel.setTableColumnName(tableName, ScrollArchivistDAO.getTableColumnsName(tableName));
        MainModel.setTableLines(tableName, ScrollArchivistDAO.getTableDatas(tableName));
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    /**
     * Retourne la liste des pages (tabs) du classeur de donnees. 
     * @return (String[])
     */
    public final static String[] getAppMenuTabs() {
        return appMenuTabs;
    }
    /**
     * Retourne la liste des colonnes d'une table du dataset.
     * @param tableName Nom de la table du dataset.
     * @return (String[])
     */
    public final static String[] getTableColumnsName(String tableName) {
        return MainModel.APP_TAB_COLUMNS.get(tableName);
    }
    /**
     * Retourne la liste des donnees d'une table du dataset.
     * @param tableName Nom de la table du dataset.
     * @return (Object[][])
     */
    public final static Object[][] getTableLines(String tableName) {
        return MainModel.APP_TAB_LINES.get(tableName);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    /**
     * Setter
     * @param tableName
     * @param columnsName 
     */
    private static void setTableColumnName(String tableName, String[] columnsName) {
        MainModel.APP_TAB_COLUMNS.put(tableName, columnsName);
    }
    /**
     * Setter
     * @param tableName
     * @param lines 
     */
    private static void setTableLines(String tableName, Object[][] lines) {
        MainModel.APP_TAB_LINES.put(tableName, lines);
    }
    // </editor-fold>
}