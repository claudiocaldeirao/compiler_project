/*
 * COMPILADORES
 * LUIZ CLAUDIO MORAIS CALDEIRÃO
 * RA: 131255061
 *
 * DATA: 27/02/2018
 */
package Main;

import UserUI.UserUI;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("Error setting native LAF: " + e);
        }         
        UserUI window = new UserUI();
        window.setVisible(true);
    }          
}
