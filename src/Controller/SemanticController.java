/*
 *
 */
package Controller;

import SemanticAnalyzer.SemanticAnalyzer;
import SemanticAnalyzer.SemanticError;
import java.util.ArrayList;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class SemanticController {
    SemanticAnalyzer semanticAnalyzer;
    
    public SemanticController(SemanticAnalyzer analyzer) {
        this.semanticAnalyzer = analyzer;
    }
    
    public ArrayList<SemanticError> getErrors() {
        return semanticAnalyzer.getErrors();
    }
    
    public ArrayList<String> getObjectCode() {
        return semanticAnalyzer.getObjectCode().getObjectCode();
    }
    
    public boolean hasErrors() {
        if(semanticAnalyzer.getErrors().isEmpty()) {
            return false;
        }
        return true;
    }    
    
    public String showExecutionTimeAndSucess() {
        String message;
        if (!semanticAnalyzer.getErrors().isEmpty()) {
            message = "\nFalha na analise semantica! ";
        } else {
            message = "\nAnalise semantica realizada com sucesso! ";
        }

        message += "tempo total: " + semanticAnalyzer.getTime() + " milissegundos. ";
        return message;
    }    
}
