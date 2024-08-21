package views.tools;
import com.scrollarchivist.simplescrollarchivistrepository.views.tools.Colors;
import java.awt.Dimension;
import javax.swing.JButton;
/**
 * [] - class
 * @author Mathaus
 */
public class SARTableButtons extends JButton {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    public SARTableButtons(SARTableButtonEnum buttonType) {
        super();
        Dimension dim = new Dimension(50, 26);
        switch (buttonType) {
            case SARTableButtonEnum.SAVE:
                super.setText("✔");
                super.setBackground(Colors.BLUE);
                break;
            case SARTableButtonEnum.CANCEL:
                super.setText("✖");
                super.setBackground(Colors.PINK);
                break;
            case SARTableButtonEnum.EDIT:
                super.setText("⚒");
                super.setBackground(Colors.IVORY);
                break;
        }
        
        super.setPreferredSize(dim);
        super.setMinimumSize(dim);
        super.setMaximumSize(dim);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    // </editor-fold>
}