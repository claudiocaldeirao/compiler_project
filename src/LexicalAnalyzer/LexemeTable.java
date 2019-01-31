/*
 *
 */
package LexicalAnalyzer;

import java.util.ArrayList;
/*
 * Tabela de lexemas. LexemePosition contém um objeto do tipo Lexeme.
 */

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class LexemeTable implements Cloneable{

    private ArrayList<LexemePosition> lexemeTable;

    public LexemeTable() {
        lexemeTable = new ArrayList<>();
    }

    public void addLexeme(LexemePosition lexeme) {
        lexemeTable.add(lexeme);
    }

    public ArrayList<LexemePosition> getLexemeTable() {
        return lexemeTable;
    }

    public void setLexemeTable(ArrayList<LexemePosition> lexemeTable) {
        this.lexemeTable = lexemeTable;
    }
    
    // This method calls Object's clone().
    public LexemeTable getClone() {
        try {
            // call clone in Object.
            return (LexemeTable) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println (" Cloning not allowed. " );
            return this;
        }
    }
    
    public boolean hasInvalidTokens() {
        for(LexemePosition lp : lexemeTable) {
            if(lp.getLexeme().getToken().equals("SIMBOLO_INVALIDO")) {
                return true;
            }
        }
        return false;
    }

}
