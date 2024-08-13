package com.scrollarchivist.simplescrollarchivistrepository.views;
import com.scrollarchivist.simplescrollarchivistrepository.models.MainModel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
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
            JPanel body = newBody();
        });
    }
    private JFrame newWindow() {
        JFrame window = new JFrame(MainModel.APP_TITLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension appSize = new Dimension(MainModel.APP_MIN_HEIGHT, MainModel.APP_MIN_WIDTH); //Mode portrait
        window.setSize(appSize);
        window.setMinimumSize(appSize);
        window.setVisible(true);
        return window;
    }
    private JPanel newBody() {
        JFrame window = newWindow();
        JPanel body = new JPanel(new SpringLayout());
        body.setBackground(Color.BLACK);
        window.setContentPane(body);
        return body;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}