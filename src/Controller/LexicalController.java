/*
 *
 */
package Controller;

import LexicalAnalyzer.LexemePosition;
import LexicalAnalyzer.LexemeTable;
import LexicalAnalyzer.LexicalAnalyzer;
/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class LexicalController {
    private final LexicalAnalyzer lexicalAnalyzer;
    private String sourceCode;

    public LexicalController() {
        lexicalAnalyzer = new LexicalAnalyzer();
    }
    
    public void loadSourceCode(String sourceCode) {
        this.sourceCode = sourceCode + "\n";    //Adiciona quebra de linha pra garantir o ultimo token.
    }
    
    public void analyzeSourceCode() {
        //Zerando a tabela.
        //Em caso de reexecução.
        lexicalAnalyzer.getLexemeTable().getLexemeTable().clear();
        lexicalAnalyzer.getVariableTable().getVariableTable().clear();
        //analiza o codigo fonte e separa os tokens/lexemas.
        lexicalAnalyzer.analyzeEntry(sourceCode);
    } 
    
    //Retorna a tabela de lexemas (para preencher a tabela).
    public LexemeTable getTable() {
        return this.lexicalAnalyzer.getLexemeTable();
    }  
    
    public String showExecutionTimeAndSucess() {
        String message;
        if (lexicalAnalyzer.getLexemeTable().hasInvalidTokens()) {
            message = "Falha na analise léxica! ";
        } else {
            message = "Analise léxica realizada com sucesso! ";
        }

        message += "tempo total: " + lexicalAnalyzer.getTime() + " milissegundos. ";
        return message;
    }
    
    public boolean hasErrors() {
        for(LexemePosition p: lexicalAnalyzer.getLexemeTable().getLexemeTable()) {
            if(p.getLexeme().getToken().equals("SIMBOLO_INVALIDO")) {
                return true;
            }
        }
        return false;
    }
}
