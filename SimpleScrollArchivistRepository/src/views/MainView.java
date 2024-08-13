package com.scrollarchivist.simplescrollarchivistrepository.views;
import com.scrollarchivist.simplescrollarchivistrepository.models.MainModel;
import com.scrollarchivist.simplescrollarchivistrepository.views.tools.Colors;
import com.scrollarchivist.simplescrollarchivistrepository.views.tools.CustomBasicTabbedPaneUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.springframework.stereotype.Component;
/**
 * [MainView] - class
 * @author Mathaus
 */
@Component
public class MainView {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    public void show() {
        SwingUtilities.invokeLater(() -> {
            JPanel body = newBody();
            addMainTitle(body);
            JTabbedPane mainMenu = createTabbedPane(body);
            fillMainMenu(mainMenu);
            setBackGround(body);
        });
    }
    /**
     * Creation de la JFrame window
     * @return window (JFrame)
     */
    private JFrame newWindow() {
        JFrame window = new JFrame(MainModel.APP_TITLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension appSize = new Dimension(MainModel.APP_MIN_HEIGHT, MainModel.APP_MIN_WIDTH); //Mode portrait
        window.setSize(appSize);
        window.setMinimumSize(appSize);
        window.setVisible(true);
        return window;
    }
    /**
     * Creation du JPanel body
     * @return body (JPanel)
     */
    private JPanel newBody() {
        JFrame window = newWindow();
        JPanel body = new JPanel(new SpringLayout());
        body.setBackground(Color.BLACK);
        window.setContentPane(body);
        return body;
    }
    /**
     * Creation d'une marge via les contraintes du SpringLayout
     * @param parent avec un SpringLayout
     * @param child enfant parametrer la marge
     * @param margin taille de la marge
     */
    private void setSpringLayout(JComponent parent, JComponent child, int margin) {
        SpringLayout layout = (SpringLayout) parent.getLayout();
        layout.putConstraint(SpringLayout.WEST, child, margin, SpringLayout.WEST,  parent);
        layout.putConstraint(SpringLayout.EAST, child, -margin, SpringLayout.EAST, parent);
        layout.putConstraint(SpringLayout.NORTH, child, margin, SpringLayout.NORTH, parent);
        layout.putConstraint(SpringLayout.SOUTH, child, -margin, SpringLayout.SOUTH, parent);
    }
    /**
     * Creer les JPanel correspondant au Background Rose et Bleu
     * @param parent
     */
    private void setBackGround(JComponent parent) {
        JPanel background = new JPanel();
        setSpringLayout(parent, background, 0);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        JPanel blue = new JPanel();
        JPanel pink = new JPanel();
        blue.setBackground(Colors.BLUE);
        pink.setBackground(Colors.PINK);
        background.add(blue);
        background.add(pink);
        parent.add(background);
    }
    /**
     * Creer un JTabbedPane avec une marge
     * @param parent
     * @return (JTabbedPane)
     */
    private JTabbedPane createTabbedPane(JComponent parent) {
        JTabbedPane tabbedPane = new JTabbedPane();
        setSpringLayout(parent, tabbedPane, 4);
        parent.add(tabbedPane);
        customizeTabbedPane(tabbedPane);
        return tabbedPane;
    }
    /**
     * Permet de personnaliser l'apparence des onglets.
     * Fixe également la couleur du texte par defaut.
     * @param tabbedPane 
     */
    private void customizeTabbedPane(JTabbedPane tabbedPane) {
        tabbedPane.setUI(new CustomBasicTabbedPaneUI());
        tabbedPane.setForeground(Color.BLACK);
    }
    /**
     * Affiche dans un JTabbedPane les onglets principaux:
     * Livres, Abonnés et Emprunts.
     * @param tabbedPaneMenu 
     */
    private void fillMainMenu(JTabbedPane tabbedPaneMenu) {
        for (String text : MainModel.APP_MENU_TAB) {
            tabbedPaneMenu.addTab(text, new JPanel(){{ setBackground(Colors.IVORY);}});
        } 
    }
    /**
     * Creer un panel avec le titre de l'application.
     * @param parent
     * @return title (JPanel)
     */
    private JPanel addMainTitle(JComponent parent) {
        JPanel headerPanel = new JPanel();
        setSpringLayout(parent, headerPanel, 0);
        headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,24,0));
        headerPanel.setOpaque(false);
        JLabel appNameLabel = new JLabel(MainModel.APP_TITLE);
        appNameLabel.setFont(new Font("Brush Script MT", Font.ITALIC, 28));
        appNameLabel.setForeground(Color.BLACK);
        headerPanel.add(appNameLabel);
        parent.add(headerPanel);
        return headerPanel;
    }
    /**
     * Fixe les Insets par défaut.
     */
    public static void setUpInsets() {
        Insets insets = new Insets(0, 0, 0, 0);
        UIManager.put("TabbedPane.contentBorderInsets", insets);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}