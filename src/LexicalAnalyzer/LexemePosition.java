/*
 *
 */
package LexicalAnalyzer;
/*
 * Esta classe apenas indica a posição do lexema no código fonte, afim de ajudar na correção
 * de erros.
 */

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class LexemePosition {
    private final Lexeme lexeme;
    private final int line;
    private final int initialColumn;
    private final int finalColumn;

    public LexemePosition(Lexeme lexeme, int linha, int colunaInicial, int colunaFinal) {
        this.lexeme = lexeme;
        this.line = linha;
        this.initialColumn = colunaInicial;
        this.finalColumn = colunaFinal;
    }

    public Lexeme getLexeme() {
        return lexeme;
    }

    public int getLine() {
        return line;
    }

    public int getInitialColumn() {
        return initialColumn;
    }

    public int getFinalColumn() {
        return finalColumn;
    }
}
