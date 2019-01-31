/*
 *
 */
package SemanticAnalyzer;

import LexicalAnalyzer.LexemePosition;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class SemanticError {
    private final LexemePosition error;   //Lexema capturado.
    private final String message; //Mensagem de erro.
    
    
    public SemanticError(LexemePosition error, String message) {
        this.error = error;
        this.message = message;
    }

    public LexemePosition getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }    
}
