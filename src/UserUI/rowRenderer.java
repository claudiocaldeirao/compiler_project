/*
 *
 */
package UserUI;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Claudio
 */
public class rowRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent( JTable aTable, Object aNumberValue, boolean aIsSelected, boolean aHasFocus, int aRow, int aColumn) {  
    if (aNumberValue == null) return this;
    Component renderer = super.getTableCellRendererComponent(
      aTable, aNumberValue, aIsSelected, aHasFocus, aRow, aColumn
    );
    
    //Lexical.
    if (String.valueOf(aNumberValue).equals("SIMBOLO_INVALIDO")||
            String.valueOf(aNumberValue).equals("INTEIRO_MUITO_GRANDE")||
            String.valueOf(aNumberValue).equals("FLOAT_MUITO_GRANDE")||
            String.valueOf(aNumberValue).equals("IDENTIFICADOR_MUITO_GRANDE")) {
      renderer.setForeground(Color.white);
      renderer.setBackground(Color.red);
    } else {
      renderer.setForeground(Color.black);
      renderer.setBackground(Color.white);  
    }  
   
    return this;
  }
}   

