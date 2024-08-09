package com.scrollarchivist.simplescrollarchivistrepository.controllers;
import com.scrollarchivist.simplescrollarchivistrepository.views.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * [MainController] - class
 * @author Mathaus
 */
@Controller
public class MainController {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    @Autowired
    private MainView appView;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    public void start() {
        appView.show();
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}