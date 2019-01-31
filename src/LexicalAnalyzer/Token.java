/*
 *
 */
package LexicalAnalyzer;

import VariableTable.VariableTable;

/*
 * Classe que contém as expressões regulares que definem os Tokens da linguagem.
 */

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class Token {

    private VariableTable variableTable;
    //Tipos primitivos.
    private final String INTEIRO = "[0-9]+";
    private final String REAL = "[0-9]+.[0-9]+";
    private final String IDENTIFICADOR = "[a-zA-Z]([a-zA-Z]|[0-9]|_)*";
    //Palavra reservada.
    private final String PALAVRA_RESERVADA_PROGRAM = "program";
    private final String PALAVRA_RESERVADA_PROCEDURE = "procedure";
    private final String PALAVRA_RESERVADA_IF = "if";
    private final String PALAVRA_RESERVADA_THEN = "then";
    private final String PALAVRA_RESERVADA_ELSE = "else";
    private final String PALAVRA_RESERVADA_BEGIN = "begin";
    private final String PALAVRA_RESERVADA_END = "end";
    private final String PALAVRA_RESERVADA_WHILE = "while";
    private final String PALAVRA_RESERVADA_DO = "do";
    private final String PALAVRA_RESERVADA_VAR = "var";
    private final String PALAVRA_RESERVADA_TRUE = "true";
    private final String PALAVRA_RESERVADA_FALSE = "false";
    private final String PALAVRA_RESERVADA_PRINT = "print";
    private final String PALAVRA_RESERVADA_WRITE = "write";
    private final String PALAVRA_RESERVADA_READ = "read";
    private final String PALAVRA_RESERVADA_AND = "and";
    private final String PALAVRA_RESERVADA_OR = "or";
    private final String PALAVRA_RESERVADA_NOT = "not";
    //Tipo.
    private final String TIPO_INT = "int";
    private final String TIPO_FLOAT = "float";
    private final String TIPO_CHAR = "char";
    private final String TIPO_STRING = "String";
    private final String TIPO_BOOLEAN = "boolean";
    //Tokens a seguir são capturados durante a separação de lexemas na classe LexicalAnalyzer.
    //private final String OPERADOR_SOMA = "+";
    //private final String OPERADOR_SUB = "-";
    //private final String OPERADOR_MULT = "*";
    //private final String OPERADOR_DIV = "%";
    //private final String OPERADOR_ATRIB = ":=";
    //private final String SIMBOLO_ESPECIAL = ">|<|<=|>=|;|(|)";

    public Token() {
    }

    public Token(VariableTable variableTable) {
        this.variableTable = variableTable; //Unico propósito de verificar se a variavel existe.
    }

    public Lexeme tokenType(String lexeme) {
        //Tamanho máximo de ints e floats é de 10 digitos.
        if (lexeme.matches(INTEIRO)) {
            if (lexeme.length() < 10) {
                return new Lexeme(lexeme, "INTEIRO");
            } else {
                return new Lexeme(lexeme, "INTEIRO_MUITO_GRANDE");
            }
        } else if (lexeme.matches(REAL)) {
            if (lexeme.length() < 10) {
                return new Lexeme(lexeme, "FLOAT");
            } else {
                return new Lexeme(lexeme, "FLOAT_MUITO_GRANDE");
            }
        } else if (lexeme.matches(PALAVRA_RESERVADA_PROGRAM)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_PROGRAM");
        } else if (lexeme.matches(PALAVRA_RESERVADA_PROCEDURE)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_PROCEDURE");
        } else if (lexeme.matches(PALAVRA_RESERVADA_IF)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_IF");
        } else if (lexeme.matches(PALAVRA_RESERVADA_THEN)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_THEN");
        } else if (lexeme.matches(PALAVRA_RESERVADA_ELSE)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_ELSE");
        } else if (lexeme.matches(PALAVRA_RESERVADA_BEGIN)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_BEGIN");
        } else if (lexeme.matches(PALAVRA_RESERVADA_END)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_END");
        } else if (lexeme.matches(PALAVRA_RESERVADA_WHILE)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_WHILE");
        } else if (lexeme.matches(PALAVRA_RESERVADA_DO)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_DO");
        } else if (lexeme.matches(PALAVRA_RESERVADA_VAR)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_VAR");
        } else if (lexeme.matches(PALAVRA_RESERVADA_TRUE)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_TRUE");
        } else if (lexeme.matches(PALAVRA_RESERVADA_FALSE)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_FALSE");
        } else if (lexeme.matches(PALAVRA_RESERVADA_PRINT)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_PRINT");
        } else if (lexeme.matches(PALAVRA_RESERVADA_WRITE)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_WRITE");
        } else if (lexeme.matches(PALAVRA_RESERVADA_READ)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_READ");
        } else if (lexeme.matches(PALAVRA_RESERVADA_AND)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_AND");
        } else if (lexeme.matches(PALAVRA_RESERVADA_OR)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_OR");
        } else if (lexeme.matches(PALAVRA_RESERVADA_NOT)) {
            return new Lexeme(lexeme, "PALAVRA_RESERVADA_NOT");
        } else if (lexeme.matches(TIPO_INT)) {
            return new Lexeme(lexeme, "TIPO_INT");
        } else if (lexeme.matches(TIPO_FLOAT)) {
            return new Lexeme(lexeme, "TIPO_FLOAT");
        } else if (lexeme.matches(TIPO_CHAR)) {
            return new Lexeme(lexeme, "TIPO_CHAR");
        } else if (lexeme.matches(TIPO_STRING)) {
            return new Lexeme(lexeme, "TIPO_STRING");
        } else if (lexeme.matches(TIPO_BOOLEAN)) {
            return new Lexeme(lexeme, "TIPO_BOOLEAN");
        } else if (lexeme.matches(IDENTIFICADOR)) {
            //Se a variavel n existe na table, adiciona.
            if (!variableTable.containsVariable(lexeme)) {
                //Tamanho máx de um identificador é 30 chars.
                if (lexeme.length() < 30) {
                    return new Lexeme(lexeme, "IDENTIFICADOR");
                } else {
                    return new Lexeme(lexeme, "IDENTIFICADOR_MUITO_GRANDE");
                }
            } else {
                if (lexeme.length() < 30) {
                    return new Lexeme(lexeme, "IDENTIFICADOR");
                } else {
                    return new Lexeme(lexeme, "IDENTIFICADOR_MUITO_GRANDE");
                }
            }
        } else if (lexeme.matches("")) {    //Vazio.
            return null;
        } else {    //Inválidos.
            return new Lexeme(lexeme, "SIMBOLO_INVALIDO");
        }
    }
}
