/*
 *
 */
package LexicalAnalyzer;

import VariableTable.VariableTable;

/*
 * Classe responsável por dividir o código fonte em lexemas e categoriza-los.
 */

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class LexicalAnalyzer {
    private final LexemeTable lexemeTable;
    private final VariableTable variableTable;
    private final Token tokenType;
    private long start;
    private long end;

    public LexicalAnalyzer() {
        lexemeTable = new LexemeTable();
        variableTable = new VariableTable();
        tokenType = new Token(variableTable);
    }

    public LexemeTable getLexemeTable() {
        return lexemeTable;
    }

    public VariableTable getVariableTable() {
        return variableTable;
    }

    public void analyzeEntry(String sourceCode) {
        start = System.currentTimeMillis();
        //Percorre o codigo fonte caracter à caracter.
        String buffer = ""; //Buff que armazena o proximo lexema.

        int k = 0;  //Marca a coluna. Incrementa a cada quebra de linha.
        int j = 0;  //Marca a linha. Incrementa no for, e a posição final é dada por i + tamanho do token. 

        //Buffer do novo lexema a ser adicionado a tabela.
        Lexeme lexeme;
        LexemePosition lexemePosition;

        //começando a leitura.
        for (int i = 0; i < sourceCode.length(); i++) {
            switch (String.valueOf(sourceCode.charAt(i))) {
                case "\n":   //quebra de linha.                    
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }
                    j++;    //Incrementa linha.
                    k = 0;  //Volta a coluna zero.

                    //Resetando buffers.
                    buffer = "";
                    break;
                case "\t":  //tabulação.                    
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }

                    k = k + buffer.length() + 1;

                    //Resetando buffers.
                    buffer = "";
                    break;
                case " ":  //tabulação.                    
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }

                    k = k + buffer.length() + 1;

                    //Resetando buffers.
                    buffer = "";
                    break;
                case ",":  //virgula.                    
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }
                    
                    LexemePosition l = new LexemePosition(new Lexeme(",", "SIMBOLO_ESPECIAL_VIRGULA"), j, k + buffer.length()+ 1, k + buffer.length() + 1);
                    lexemeTable.addLexeme(l);

                    k = k + buffer.length() + 1;

                    //Resetando buffers.
                    buffer = "";
                    break;
                case ".":  //virgula.                    
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }
                    
                    LexemePosition l2 = new LexemePosition(new Lexeme(".", "SIMBOLO_ESPECIAL_PONTO"), j, k + buffer.length()+ 1, k + buffer.length() + 1);
                    lexemeTable.addLexeme(l2);

                    k = k + buffer.length() + 1;

                    //Resetando buffers.
                    buffer = "";
                    break;                    
                case "{":  //bloco de comentário.   
                    i++;
                    while ((i < sourceCode.length())&&(sourceCode.charAt(i) != '}')) {
                        //Enquanto não encontrar o fim do comentário, ou o código não terminar.
                        i++;
                    }
                    break;
                case "/":  //bloco de comentário.                                      
                    if(String.valueOf(sourceCode.charAt(i+1)).equals("/")) {
                        i++;
                        while((i < sourceCode.length())&&(sourceCode.charAt(i) != '\n')){ 
                            //Ignora toda a linha.
                            i++;
                        }
                    } else {
                        //Adicionando lexema do operador.
                        lexeme = new Lexeme("/", "SIMBOLO_INVALIDO");
                        //Posição do lexema.
                        lexemePosition = new LexemePosition(lexeme, j, k, k + 1);
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);      
                    }
                    break;                    
                //Operadores Aritimeticos.    
                case "+":
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }

                    k = k + buffer.length() + 1;

                    //Adicionando lexema do operador.
                    lexeme = new Lexeme("+", "OPERADOR_SOMA");
                    //Posição do lexema.
                    lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                    k++;
                    //Adicionando a tabela.
                    lexemeTable.addLexeme(lexemePosition);

                    //Resetando buffers.
                    buffer = "";
                    break;
                case "-":
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }

                    k = k + buffer.length() + 1;

                    //Adicionando lexema do operador.
                    lexeme = new Lexeme("-", "OPERADOR_SUB");
                    //Posição do lexema.
                    lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                    k++;
                    //Adicionando a tabela.
                    lexemeTable.addLexeme(lexemePosition);

                    //Resetando buffers.
                    buffer = "";
                    break;
                case "*":
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }

                    k = k + buffer.length() + 1;

                    //Adicionando lexema do operador.
                    lexeme = new Lexeme("*", "OPERADOR_MULT");
                    //Posição do lexema.
                    lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                    k++;
                    //Adicionando a tabela.
                    lexemeTable.addLexeme(lexemePosition);

                    //Resetando buffers.
                    buffer = "";
                    break;
                case "%":
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }

                    k = k + buffer.length() + 1;

                    //Adicionando lexema do operador.
                    lexeme = new Lexeme("%", "OPERADOR_DIV");
                    //Posição do lexema.
                    lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                    k++;
                    //Adicionando a tabela.
                    lexemeTable.addLexeme(lexemePosition);

                    //Resetando buffers.
                    buffer = "";
                    break;
                case ":":
                    if (String.valueOf(sourceCode.charAt(i + 1)).equals("=")) {
                        //Criando lexema.
                        lexeme = tokenType.tokenType(buffer);
                        //Posição do lexema.
                        if (lexeme != null) {
                            lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                            //Adicionando a tabela.
                            lexemeTable.addLexeme(lexemePosition);
                        }

                        k = k + buffer.length() + 1;

                        //Adicionando lexema do operador.
                        lexeme = new Lexeme(":=", "OPERADOR_ATRIB");
                        //Posição do lexema.
                        lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                        k++;
                        i++;
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);

                        //Resetando buffers.
                        buffer = "";
                    } else {    //dividindo declaração proc.
                        //Criando lexema.
                        lexeme = tokenType.tokenType(buffer);
                        //Posição do lexema.
                        if (lexeme != null) {
                            lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                            //Adicionando a tabela.
                            lexemeTable.addLexeme(lexemePosition);
                        }

                        k = k + buffer.length() + 1;

                        //Adicionando lexema do operador.
                        lexeme = new Lexeme(":", "SIMBOLO_ESPECIAL_PONTO_DUPLO");
                        //Posição do lexema.
                        lexemePosition = new LexemePosition(lexeme, j, k, k);

                        k++;
                        i++;
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);

                        //Resetando buffers.
                        buffer = "";                    
                    }
                    break;

                //Operadores Booleanos.    
                case "=":
                    if (String.valueOf(sourceCode.charAt(i + 1)).equals("=")) {
                        //Criando lexema.
                        lexeme = tokenType.tokenType(buffer);
                        //Posição do lexema.
                        if (lexeme != null) {
                            lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                            //Adicionando a tabela.
                            lexemeTable.addLexeme(lexemePosition);
                        }

                        k = k + buffer.length() + 1;

                        //Adicionando lexema do operador.
                        lexeme = new Lexeme("==", "SIMBOLO_ESPECIAL_IGUAL");
                        //Posição do lexema.
                        lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                        k++;
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);

                        //Resetando buffers.
                        buffer = "";
                    }
                    break;
                case "!":
                    if (String.valueOf(sourceCode.charAt(i + 1)).equals("=")) {
                        //Criando lexema.
                        lexeme = tokenType.tokenType(buffer);
                        //Posição do lexema.
                        if (lexeme != null) {
                            lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                            //Adicionando a tabela.
                            lexemeTable.addLexeme(lexemePosition);
                        }

                        k = k + buffer.length() + 1;

                        //Adicionando lexema do operador.
                        lexeme = new Lexeme("!=", "SIMBOLO_ESPECIAL_DIFERENTE");
                        //Posição do lexema.
                        lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                        k++;
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);

                        //Resetando buffers.
                        buffer = "";
                    }
                    break;
                case ">":
                    if (String.valueOf(sourceCode.charAt(i + 1)).equals("=")) {
                        //Criando lexema.
                        lexeme = tokenType.tokenType(buffer);
                        //Posição do lexema.
                        if (lexeme != null) {
                            lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                            //Adicionando a tabela.
                            lexemeTable.addLexeme(lexemePosition);
                        }

                        k = k + buffer.length() + 1;

                        //Adicionando lexema do operador.
                        lexeme = new Lexeme(">=", "SIMBOLO_ESPECIAL_MAIOR_IGUAL");
                        //Posição do lexema.
                        lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                        k++;
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);

                        //Resetando buffers.
                        buffer = "";
                    } else {
                        //Criando lexema.
                        lexeme = tokenType.tokenType(buffer);
                        //Posição do lexema.
                        if (lexeme != null) {
                            lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                            //Adicionando a tabela.
                            lexemeTable.addLexeme(lexemePosition);
                        }

                        k = k + buffer.length() + 1;

                        //Adicionando lexema do operador.
                        lexeme = new Lexeme(">", "SIMBOLO_ESPECIAL_MAIOR");
                        //Posição do lexema.
                        lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                        k++;
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);

                        //Resetando buffers.
                        buffer = "";
                    }
                    break;
                case "<":
                    if (String.valueOf(sourceCode.charAt(i + 1)).equals("=")) {
                        //Criando lexema.
                        lexeme = tokenType.tokenType(buffer);
                        //Posição do lexema.
                        if (lexeme != null) {
                            lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                            //Adicionando a tabela.
                            lexemeTable.addLexeme(lexemePosition);
                        }

                        k = k + buffer.length() + 1;

                        //Adicionando lexema do operador.
                        lexeme = new Lexeme("<=", "SIMBOLO_ESPECIAL_MENOR_IGUAL");
                        //Posição do lexema.
                        lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                        k++;
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);

                        //Resetando buffers.
                        buffer = "";
                    } else {
                        //Criando lexema.
                        lexeme = tokenType.tokenType(buffer);
                        //Posição do lexema.
                        if (lexeme != null) {
                            lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                            //Adicionando a tabela.
                            lexemeTable.addLexeme(lexemePosition);
                        }

                        k = k + buffer.length() + 1;

                        //Adicionando lexema do operador.
                        lexeme = new Lexeme("<", "SIMBOLO_ESPECIAL_MENOR");
                        //Posição do lexema.
                        lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                        k++;
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);

                        //Resetando buffers.
                        buffer = "";
                    }
                    break;

                //Final de comandos.    
                case ";":
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }

                    k = k + buffer.length() + 1;

                    //Adicionando lexema do operador.
                    lexeme = new Lexeme(";", "SIMBOLO_ESPECIAL_PONTO_VIRGULA");
                    //Posição do lexema.
                    lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                    k++;
                    //Adicionando a tabela.
                    lexemeTable.addLexeme(lexemePosition);

                    //Resetando buffers.
                    buffer = "";
                    break;

                //Parenteses.    
                case "(":
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }

                    k = k + buffer.length() + 1;

                    //Adicionando lexema do operador.
                    lexeme = new Lexeme("(", "SIMBOLO_ESPECIAL_ABRE_PARENTESE");
                    //Posição do lexema.
                    lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                    k++;
                    //Adicionando a tabela.
                    lexemeTable.addLexeme(lexemePosition);

                    //Resetando buffers.
                    buffer = "";
                    break;
                case ")":
                    //Criando lexema.
                    lexeme = tokenType.tokenType(buffer);
                    //Posição do lexema.
                    if (lexeme != null) {
                        lexemePosition = new LexemePosition(lexeme, j, k, k + buffer.length());
                        //Adicionando a tabela.
                        lexemeTable.addLexeme(lexemePosition);
                    }

                    k = k + buffer.length() + 1;

                    //Adicionando lexema do operador.
                    lexeme = new Lexeme(")", "SIMBOLO_ESPECIAL_FECHA_PARENTESE");
                    //Posição do lexema.
                    lexemePosition = new LexemePosition(lexeme, j, k, k + 1);

                    k++;
                    //Adicionando a tabela.
                    lexemeTable.addLexeme(lexemePosition);

                    //Resetando buffers.
                    buffer = "";
                    break;

                default:
                    buffer += String.valueOf(sourceCode.charAt(i));
            }
        }
            end = System.currentTimeMillis();           
    }

    public long getTime() {
        return (end - start);
    }
}
