package com.scrollarchivist.simplescrollarchivistrepository.views;
import com.scrollarchivist.simplescrollarchivistrepository.models.MainModel;
import com.scrollarchivist.simplescrollarchivistrepository.views.tools.Colors;
import com.scrollarchivist.simplescrollarchivistrepository.views.tools.CustomBasicTabbedPaneUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import views.FileTableModel;
import views.TableDeleteButtonEditor;
import views.tools.SARTableButtonEnum;
import views.tools.SARTableButtons;
/**
 * [MainView] - class
 * @author Mathaus
 */
public class MainView {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainView.
     */
    private MainView(){}
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private static final JFrame mainFrame = new JFrame(MainModel.APP_TITLE);
    private static final JLayeredPane mainLayers = mainFrame.getLayeredPane();
    private static JPanel mainBody = null;
    private static JTabbedPane mainView = null;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    /**
     * Creer et affiche la fenetre principale.
     */
    public static void show() {
        SwingUtilities.invokeLater(() -> {
            configMainContentPane();
            showMainFrame();
        });
    }
    /**
     * Fixe les Insets par défaut.
     */
    public static void setUpInsets() {
        Insets insets = new Insets(0, 0, 0, 0);
        UIManager.put("TabbedPane.contentBorderInsets", insets);
    }
    /**
     * Configure la JFrame, puis creer les composants avec les donnees du MainModel.
     */
    private static void configMainContentPane() {
        Dimension frameSize = new Dimension(MainModel.APP_MIN_HEIGHT, MainModel.APP_MIN_WIDTH); //Mode portrait
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(frameSize);
        mainFrame.setMinimumSize(frameSize);
        createBody();
        createBackGround();
        fillMainView();
    }
    /**
     * Affiche la fenetre principale.
     */
    private static void showMainFrame() {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    /**
     * Creation d'une marge via les contraintes du SpringLayout
     * @param parent avec un SpringLayout
     * @param child enfant à parametrer la marge
     * @param margin taille des marges
     */
    private static void setSpringLayout(JComponent parent, JComponent child, int[] margin) {
        int northMargin = 0;
        int eastMargin = 0;
        int southMargin = 0;
        int westMargin = 0;
        //
        LayoutManager parentLayout = parent.getLayout();
        SpringLayout layout;
        if (!(parentLayout instanceof SpringLayout)) {
            layout = new SpringLayout();
            parent.setLayout(layout);
        } else {
            layout = (SpringLayout) parent.getLayout();
        }
        if (margin != null && margin.length > 0) {
            switch (margin.length) {
                case 1:
                    northMargin = eastMargin = southMargin = westMargin = Math.abs(margin[0]);
                    break;
                case 2:
                    northMargin = southMargin = Math.abs(margin[0]);
                    eastMargin = westMargin = Math.abs(margin[1]);
                    break;
                case 3: break; //do nothing
                default:
                    northMargin = Math.abs(margin[0]);
                    eastMargin = Math.abs(margin[1]);
                    southMargin = Math.abs(margin[2]);
                    westMargin = Math.abs(margin[3]);
                    break;
            }
        }
        layout.putConstraint(SpringLayout.NORTH, child, northMargin, SpringLayout.NORTH, parent);
        layout.putConstraint(SpringLayout.EAST, child, -eastMargin, SpringLayout.EAST, parent);
        layout.putConstraint(SpringLayout.SOUTH, child, -southMargin, SpringLayout.SOUTH, parent);
        layout.putConstraint(SpringLayout.WEST, child, westMargin, SpringLayout.WEST, parent);
    }
    // <editor-fold defaultstate="collapsed" desc="createBody...">
    /**
     * Creation du JPanel mainBody avec son titre et son classeur de contenu.
     * Ajoute body au contentPane de la JFrame.
     */
    private static void createBody() {
        mainBody = new JPanel();
        mainBody.setBackground(Colors.IVORY);
        mainFrame.setContentPane(mainBody);
        setSpringLayout(mainLayers, mainBody, new int[]{4});
        mainLayers.setLayer(mainBody, JLayeredPane.DEFAULT_LAYER);
        addMainTitle();
        createTabbedPane();
    }
    /**
     * Creer un panel avec le titre de l'application.
     */
    private static void addMainTitle() {
        JPanel headerPanel = new JPanel();
        setSpringLayout(mainBody, headerPanel, null);
        headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,24,0));
        headerPanel.setOpaque(false);
        JLabel appNameLabel = new JLabel(MainModel.APP_TITLE);
        appNameLabel.setFont(new Font("Brush Script MT", Font.ITALIC, 28));
        appNameLabel.setForeground(Color.BLACK);
        headerPanel.add(appNameLabel);
        mainBody.add(headerPanel);
    }
    /**
     * Creation du classeur personnalise mainView (JTabbedPane).
     */
    private static void createTabbedPane() {
        mainView = new JTabbedPane();
        setSpringLayout(mainBody, mainView, new int[]{4});
        mainBody.add(mainView);
        customizeTabbedPane(mainView);
    }
    /**
     * Permet de personnaliser l'apparence des onglets.
     * Fixe également la couleur du texte par defaut.
     * @param tabbedPane 
     */
    private static void customizeTabbedPane(JTabbedPane tabbedPane) {
        tabbedPane.setUI(new CustomBasicTabbedPaneUI());
        tabbedPane.setForeground(Color.BLACK);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="createBackGround...">
    /**
     * Creer les JPanel correspondant au Background Rose et Bleu.
     */
    private static void createBackGround() {
        JPanel background = new JPanel();
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        JPanel blue = new JPanel();
        JPanel pink = new JPanel();
        blue.setBackground(Colors.BLUE);
        pink.setBackground(Colors.PINK);
        background.add(blue);
        background.add(pink);
        mainLayers.add(background);
        setSpringLayout(mainLayers, background, null);
        mainLayers.setLayer(background, Integer.MIN_VALUE);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="fillMainView...">
    /**
     * Creer chaque page du classeur avec les donnees du MainModel.
     * Contient une liste et un menu en bas de page.
     * Ajoute les pages au classeur (mainView).
     */
    private static void fillMainView() {
        for (String text : MainModel.getAppMenuTabs()) {
            JPanel newtab = new JPanel(){{ setBackground(Colors.IVORY);}};
            newtab.setLayout(new BorderLayout());
            JComponent[] tableViewComponents = formatTableView(text);
            newtab.add(tableViewComponents[0], BorderLayout.CENTER);
            newtab.add(tableViewComponents[1], BorderLayout.SOUTH);
            mainView.addTab(text, newtab);
        }
    }
    /**
     * Creer les deux composants d'une page de classeur a partir des donnees du MainModel.
     * [0] JScrollPane, [1] JPanel
     * @param tableName Nom de la table du dataset.
     * @return Un tableau de 2 JComponents.
     */
    private static JComponent[] formatTableView(String tableName) {
        JComponent[] tableViewComponents = new JComponent[2];
        tableViewComponents[0] = createTableView(tableName);
        tableViewComponents[1] = createTableSubMenu();
        return tableViewComponents;
    }
    /**
     * Creer la liste (JTable) contenant les donnees d'une table du dataset.
     * @param tableName Nom de la table du dataset.
     * @return Un JScrollPane avec les donnees formattees pour l'affichage.
     */
    private static JScrollPane createTableView(String tableName) {
            List<File> files = Arrays.asList(new File(".").listFiles());
            FileTableModel model = new FileTableModel(files);
            JTable table = new JTable(model);
            //table.setDefaultEditor(File.class, new TableDeleteButtonEditor());
            //table.setDefaultRenderer(File.class, new TableDeleteButtonEditor());
            table.getColumnModel().getColumn(1).setCellRenderer(new TableDeleteButtonEditor());
            table.getColumnModel().getColumn(1).setCellEditor(new TableDeleteButtonEditor());
        JScrollPane tableView = new JScrollPane(table);
        tableView.getViewport().setBackground(Colors.IVORY);
        return tableView;
    }
    /**
     * Creer le sous-menu de la page du classeur.
     * @return 
     */
    private static JPanel createTableSubMenu() {
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
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}