package com.scrollarchivist.simplescrollarchivistrepository.controllers;
import com.scrollarchivist.simplescrollarchivistrepository.models.MainModel;
import com.scrollarchivist.simplescrollarchivistrepository.views.MainView;
/**
 * [MainController] - class
 * @author Mathaus
 */
public class MainController {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainController.
     */
    private MainController(){}
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private static boolean isFirstCall = true;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    /**
     * Configure MainModel et MainView lors du premier appel.
     */
    public static final void config() {
        if (isFirstCall) {
            isFirstCall = false;
            MainView.setUpInsets();
            MainModel.fetchAllDatas();
        }
    }
    /**
     * Affiche la vue.
     */
    public static final void start() {
        MainView.show();
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}