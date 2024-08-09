package com.scrollarchivist.simplescrollarchivistrepository.views;
import com.scrollarchivist.simplescrollarchivistrepository.models.MainModel;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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
            // Création de la fenêtre (JFrame)
            JFrame frame = new JFrame(MainModel.APP_TITLE);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Dimension appSize = new Dimension(MainModel.APP_MIN_WIDTH, MainModel.APP_MIN_HEIGHT);
            frame.setSize(appSize);
            frame.setMinimumSize(appSize);
            frame.setVisible(true);
        });
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}