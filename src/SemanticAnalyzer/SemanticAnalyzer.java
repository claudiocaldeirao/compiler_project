/*
 *
 */
package SemanticAnalyzer;

import VariableTable.VariableTable;
import LexicalAnalyzer.Lexeme;
import LexicalAnalyzer.LexemePosition;
import LexicalAnalyzer.LexemeTable;
import ObjectCode.ObjectCode;
import Structure.PilhaLexeme;
import VariableTable.Variable;
import java.util.ArrayList;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class SemanticAnalyzer {
    //Tabelas de lexemas obtida na analise lexica.
    private LexemeTable lexemeTable;
    //Tabela de variaveis para identificar se a variavel ja foi declarada.
    private VariableTable variableTable;
    //Vetor que armazena o código objeto uma expressão até encontrar um token de finalização.
    ArrayList<String> expressionBuffer = new ArrayList<>();
    //Tipo usado na expressão.
    //Cada vez que uma expressão é iniciada, sinaliza qual o tipo da variavel que ira armazenar o resultado.
    //Para sinalizar possiveis erros.
    private String type;
    //Armazena o ultimo lexema de importancia que poderá interferir na semantica dos próximos simbolos.
    private Lexeme symbolOfInterest; 
    //Contador de endereços relativos que estão sendo alocados p/ as variaveis.
    private int relativeAdress;    
    //Armazena código objeto (executavel pela maquina virtual)
    ObjectCode objectCode;
    //Criar vetor de erros.
    ArrayList<SemanticError> errors;
    private long time;
    
    public SemanticAnalyzer(LexemeTable lexemeTable) {
        this.lexemeTable = lexemeTable;
        this.variableTable = new VariableTable();
        this.objectCode = new ObjectCode();
        this.errors = new ArrayList<>();
        this.relativeAdress = 0;
    }
    
    //Parametros
    //symbol -> simbolo que está sendo consumido pelo analisador sintático.
    //pile -> look ahead do método. Iremos tomar apelas um simbolo de look ahead por chamada.
    public void analyzeEntry(LexemePosition lexeme, PilhaLexeme pile) { 
        Lexeme symbol = lexeme.getLexeme();
        Variable variable;           
        
        switch(symbol.getToken()) {
            case "IDENTIFICADOR":
                if (symbolOfInterest != null) {
                    //Inicializando variavel.
                    if (!variableTable.containsVariable(symbol.getLexeme())) {
                        variable = new Variable();
                        switch (symbolOfInterest.getToken()) {                            
                            case "PALAVRA_RESERVADA_PROGRAM": 
                                variable.setId(symbol.getLexeme());
                                variable.setCategory("PROGRAM");
                                variable.setUsed(true);
                                variable.setAdress(relativeAdress);
                                relativeAdress++;
                                variableTable.addVariable(variable);
                                break;
                            case "TIPO_INT":
                                variable.setId(symbol.getLexeme());
                                variable.setCategory("VARIAVEL");
                                variable.setType("INT");
                                variable.setValor(0);  //default                                 
                                variable.setAdress(relativeAdress);
                                relativeAdress++;                                
                                objectCode.concat("AMEM 1");  
                                variableTable.addVariable(variable);
                                break;
                            case "TIPO_FLOAT":
                                variable.setId(symbol.getLexeme());
                                variable.setCategory("VARIAVEL");
                                variable.setType("FLOAT");
                                variable.setValor(Float.valueOf(0));  //default
                                variable.setAdress(relativeAdress);
                                relativeAdress++;                                
                                objectCode.concat("AMEM 1");
                                variableTable.addVariable(variable);
                                break;
                            case "TIPO_CHAR":
                                variable.setId(symbol.getLexeme());
                                variable.setCategory("VARIAVEL");
                                variable.setType("CHAR");
                                variable.setAdress(relativeAdress);
                                relativeAdress++;                                
                                objectCode.concat("AMEM 1");
                                variableTable.addVariable(variable);
                                break;
                            case "TIPO_STRING":
                                variable.setId(symbol.getLexeme());
                                variable.setCategory("VARIAVEL");
                                variable.setType("STRING");
                                variable.setAdress(relativeAdress);
                                relativeAdress++;                                
                                objectCode.concat("AMEM 1");
                                variableTable.addVariable(variable);
                                break;
                            case "TIPO_BOOLEAN":
                                variable.setId(symbol.getLexeme());
                                variable.setCategory("VARIAVEL");
                                variable.setType("BOOLEAN");
                                variable.setAdress(relativeAdress);
                                relativeAdress++;                                
                                objectCode.concat("AMEM 1");
                                variableTable.addVariable(variable);
                                break;
                            default:    //Erro.
                                SemanticError error = new SemanticError(lexeme, "ERRO: VARIAVEL NÃO DECLARADA!");
                                errors.add(error);  
                                break;
                        }
                    } else {    //Variavel ja existe.
                        variable = variableTable.getVariable(symbol.getLexeme());
                        if (variable != null) {  

                            if (!variable.isUsed()) {  //Variavel sendo usada pela primeira vez.
                                variable.setUsed(true);
                            }
//------------------------------------------------------------------------------                        
                            //Declarando uma variavel já declarada. ERRO!
                            if ((symbolOfInterest.getToken().equals("TIPO_INT")) || (symbolOfInterest.getToken().equals("TIPO_FLOAT"))) {
                                SemanticError error = new SemanticError(lexeme, "ERRO: VARIAVEL JÁ DECLARADA!");
                                errors.add(error);
                                //Inicio de uma nova expressão.    
                            } else if (pile.onTop().getLexeme().getToken().equals("OPERADOR_ATRIB")) {
                                //objectCode.concat("ARMZ " + variable.getAdress());
                                expressionBuffer.add("ARMZ " + variable.getAdress());
                                type = variable.getType();  //Tipo da expressão;
                            } else if (expressionBuffer.get(0).equals("LEIT")) {
                                expressionBuffer.add("ARMZ " + variable.getAdress());
                            } else //Verificação de tipos.
                            if (type != null) {
                                    if (variable.getType().equals(type)) {
                                        expressionBuffer.add("CRVL " + variable.getAdress());
                                    } else {
                                        SemanticError error = new SemanticError(lexeme, "ERRO: OPERAÇÃO COM TIPOS DIFERENTES!");
                                        errors.add(error);
                                    }
                                } else {
                                expressionBuffer.add("CRVL " + variable.getAdress());
                            }   

                        } else { //Usada mais não declarada!
                                SemanticError error = new SemanticError(lexeme, "ERRO: VARIAVEL NÃO DECLARADA!");
                                errors.add(error);                        
                        }
                    }
                } else {                    
                    SemanticError error = new SemanticError(lexeme, "ERRO: TIPO NÃO ESPECIFÍCADO!");
                    errors.add(error);
                }   
                break;
//------------------------------------------------------------------------------
//PROCEDIMENTOS PRIMITIVOS.
            //READ
            case "PALAVRA_RESERVADA_READ":
                expressionBuffer.add("LEIT");
                break;
            //PRINT
            case "PALAVRA_RESERVADA_WRITE":
                expressionBuffer.add("IMPR");                
                break; 
//------------------------------------------------------------------------------
//Serão implementados posteriormente.                
            //IF
                
            //ELSE
                
            //WHILE   
//------------------------------------------------------------------------------
//leitura de números diretamente.                
            case "INTEIRO":              
                int intBuffer = Integer.valueOf(symbol.getLexeme());
                expressionBuffer.add("CRCT " + intBuffer);
                break;
            case "FLOAT":
                float floatBuffer = Float.valueOf(symbol.getLexeme());              
                expressionBuffer.add("CRCT " + floatBuffer);
                break;
//------------------------------------------------------------------------------                
            //ATRIBUIÇÃO
            case "OPERADOR_ATRIB":
                //pode haver alguma operação (ainda n identificada).
                break;
//------------------------------------------------------------------------------                
            //OPERADORES ARITMÉTICOS.               
            case "OPERADOR_SOMA":
                insertOperation("SOMA");
                //expressionBuffer.add("SOMA");                
                break;
            case "OPERADOR_SUB":
                insertOperation("SUB");
                //expressionBuffer.add("SUB");
                break;
            case "OPERADOR_MULT":
                insertOperation("MULT");
                //expressionBuffer.add("MULT");
                break;
            case "OPERADOR_DIV":
                insertOperation("DIV");
                //expressionBuffer.add("DIV");
                break;
//------------------------------------------------------------------------------                
            //OPERADORES BOOLEANOS. 
            case "SIMBOLO_ESPECIAL_MAIOR":
                insertOperation("CMMA");
                break;
            case "SIMBOLO_ESPECIAL_MENOR":
                insertOperation("CMME");
                break;
            case "SIMBOLO_ESPECIAL_MAIOR_IGUAL":
                insertOperation("CMAG");
                break;
            case "SIMBOLO_ESPECIAL_MENOR_IGUAL":
                insertOperation("CMEG");
                break;
            case "SIMBOLO_ESPECIAL_IGUAL":
                insertOperation("CMIG");
                break;
            case "SIMBOLO_ESPECIAL_DIFERENTE":
                insertOperation("CMDG");
                break;                
//------------------------------------------------------------------------------
//Inicia o programa.                
            //PALAVRAS_RESERVADAS.    
            case "PALAVRA_RESERVADA_PROGRAM":
                symbolOfInterest = symbol;
                objectCode.concat("INPP");
                break; 
            //NÃO IMPLEMENTADO NA PRIMEIRA VERSÃO DO COMPILADOR.    
            case "PALAVRA_RESERVADA_PROCEDURE":
                symbolOfInterest = symbol;
                break;
//------------------------------------------------------------------------------
//Utilizados durante a inicialização de variáveis. (sinalisa o tipo das variaveis detectadas a seguir)                
            //TIPOS.    
            case "TIPO_INT":
                symbolOfInterest = symbol;
                break;
            case "TIPO_FLOAT":
                symbolOfInterest = symbol;
                break; 
//------------------------------------------------------------------------------
            //TIPOS NÃO UTILIZADOS NA PRIMEIRA VERSÃO DO COMPILADOR.
            case "TIPO_CHAR": 
                symbolOfInterest = symbol;
                break;
            case "TIPO_STRING":
                symbolOfInterest = symbol;
                break; 
            case "TIPO_BOOLEAN":
                symbolOfInterest = symbol;
                break;
//------------------------------------------------------------------------------
//Ponto chave para sinalizar o inicio de uma nove expressão.                
            //PONTO VIRGULA.    
            case "SIMBOLO_ESPECIAL_PONTO_VIRGULA":
                //FIM DE UMA EXPRESSÃO.
                //Inverte a expressão pra adicionar no código objeto. 
                symbolOfInterest = symbol;
                if (!expressionBuffer.isEmpty()) {  
                    this.insertExpression(expressionBuffer);    //GERA O CÓDIGO.
                    //RESETA VARIAVEIS.
                    type = null;
                    expressionBuffer.clear();
                }                
                break;
            case "PALAVRA_RESERVADA_BEGIN":
                symbolOfInterest = symbol;  
                break;
            case "PALAVRA_RESERVADA_END":
                //FIM DE UMA EXPRESSÃO.
                //Inverte a expressão pra adicionar no código objeto.
                symbolOfInterest = symbol;
                if (!expressionBuffer.isEmpty()) {                      
                    this.insertExpression(expressionBuffer);    //GERA O CÓDIGO.
                    //RESETA VARIAVEIS.
                    type = null;
                    expressionBuffer.clear();
                }                
                break; 
//------------------------------------------------------------------------------
            case "SIMBOLO_ESPECIAL_ABRE_PARENTESE":
                expressionBuffer.add("(");
                break;
            case "SIMBOLO_ESPECIAL_FECHA_PARENTESE":
                expressionBuffer.add(")");
                break;
            default:
                //Proavelmenta alterará o symbolOfInterest.
                break;
        }
    }

    public ObjectCode getObjectCode() {
        return objectCode;
    }

    public ArrayList<SemanticError> getErrors() {
        return errors;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    public long getTime() {
        return time;
    }

//------------------------------------------------------------------------------
//Métodos que trabalham sobre o buffer de expressão.    
    //MÉTODO QUE INVERTE A ORDEM DA EXPRESSÃO.
    public void insertExpression(ArrayList<String> expression) {
        if (expression.get(0).equals("LEIT")) {
            for(String line: expression) {
                objectCode.concat(line);
            }
        } else if (expression.get(0).equals("IMPR")) {
            for(String line: expression) {
                objectCode.concat(line);
            }        
        } else {
            int i = expression.size();
            for (; i > 0; i--) {
                objectCode.concat(expression.get(i - 1));
            }
        }
    }
    
    //MÉTODO DE INSERÇÃO DE OPERAÇÃO
    public void insertOperation(String comand) {
        int cont = expressionBuffer.size();
        expressionBuffer.add(cont - 1, comand);
    }
    
//------------------------------------------------------------------------------    
    //MÉTODO CHAMADO AO FINAL DA ANALISE SINTATICA PARA INSERIR O ULTIMO COMANDO DO CÓDIGO OBJETO.
    public void finalEntry() {        
        objectCode.concat("PARA");
    }
}
