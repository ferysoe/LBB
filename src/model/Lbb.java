package model;
import java.sql.SQLException;
import view.main;
import controller.getData;
import javax.swing.*;

/**
 *
 * @author ferysoe
 */
public class Lbb {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        main gui = new main();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        new getData();
        // TODO code application logic here
    }
    
}
