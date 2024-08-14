package com.scrollarchivist.scrollarchivistdao;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * [ScrollArchivistDAO] - class
 * @author Mathaus
 */
@Service
public class ScrollArchivistDAO {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    public ScrollArchivistDAO() {
        //
        dataset_mock_tablesColumnsName.put(dataset_mock_tablesName[0], new String[]{"Title", "Author", "Genre", "Publication Date"});
        dataset_mock_tablesDatas.put(dataset_mock_tablesName[0], new Object[][]{ {"The Bad Twin", "Gary Troup", "Thriller", "May 2006"}, {"Another Book", "Author Name", "Mystery", "June 2022"}});
        //
        dataset_mock_tablesColumnsName.put(dataset_mock_tablesName[1], new String[]{"Nom", "Prenom", "Mail"});
        dataset_mock_tablesDatas.put(dataset_mock_tablesName[1], new Object[][]{});
        //
        dataset_mock_tablesColumnsName.put(dataset_mock_tablesName[2], new String[]{"Disponibilité", "Date"});
        dataset_mock_tablesDatas.put(dataset_mock_tablesName[2], new Object[][]{});
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private final static String[] dataset_mock_tablesName = new String[]{"Livres", "Abonnés", "Emprunts"};
    private final static Map<String, String[]> dataset_mock_tablesColumnsName = new HashMap<>();
    private final static Map<String, Object[][]> dataset_mock_tablesDatas = new HashMap<>();
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    public static String[] getTablesName() {
        return dataset_mock_tablesName;
    }
    public static String[] getTableColumnsName(String tableName) {
        return dataset_mock_tablesColumnsName.get(tableName);
    }
    public static Object[][] getTableDatas(String tableName) {
        return dataset_mock_tablesDatas.get(tableName);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}