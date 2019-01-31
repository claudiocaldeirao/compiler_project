/*
 *
 */
package Controller;

import LexicalAnalyzer.LexemeTable;
import SemanticAnalyzer.SemanticAnalyzer;
import SintaticAnalyzer.SintaticAnalyzer;
import SintaticAnalyzer.SintaticError;
import java.util.ArrayList;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class SintaticController {
    private SintaticAnalyzer sintaticAnalyzer;
    
    public void loadTokens(LexemeTable lexemeTable) {
        sintaticAnalyzer = new SintaticAnalyzer(lexemeTable);
    }
    
    public void analyzeEntry() {
        sintaticAnalyzer.analyzeEntry();
    }
    
    public ArrayList<SintaticError> getErrors() {
        return sintaticAnalyzer.getErrors();
    }
    
    public boolean getValidGrammar() {
        return sintaticAnalyzer.isGramaticaValida();
    }
    
    public String showExecutionTimeAndSucess() {
        String message;
        if (sintaticAnalyzer.isGramaticaValida()) {
            message = "\nAnalise sintática realizada com sucesso! ";
        } else {
            message = "\nFalha na analise sintática! ";
        }

        message += "tempo total: " + sintaticAnalyzer.getTime() + " milissegundos. ";
        return message;
    }  
    
    public boolean hasErrors() {
        if(sintaticAnalyzer.getErrors().isEmpty()) {
            return false;
        }
        return true;
    }
    
    //RETORNA DA SEMANTICA.
    public SemanticAnalyzer getSemanticAnalyzer() {
        return sintaticAnalyzer.getSemanticAnalyzer();
    }    
}
