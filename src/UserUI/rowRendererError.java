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
 * @author Claudio Caldeirão RA:131255061
 */
public class rowRendererError extends DefaultTableCellRenderer {
    private boolean lineGreen;
    
  @Override
  public Component getTableCellRendererComponent( JTable aTable, Object aNumberValue, boolean aIsSelected, boolean aHasFocus, int aRow, int aColumn) {  
    if (aNumberValue == null) return this;
    Component renderer = super.getTableCellRendererComponent(
      aTable, aNumberValue, aIsSelected, aHasFocus, aRow, aColumn
    );
    renderer.setForeground(Color.white);
    renderer.setBackground(Color.red);

    if (String.valueOf(aNumberValue).equals("ACEITO!")) {
      renderer.setForeground(Color.white);
      renderer.setBackground(Color.green);
      lineGreen = true;
    }     
    return this;
  } 

    public boolean isLineGreen() {
        return lineGreen;
    }
}
