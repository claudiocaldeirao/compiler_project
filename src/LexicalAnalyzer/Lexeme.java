/*
 *
 */
package LexicalAnalyzer;
/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class Lexeme {
    private final String lexeme;
    /* Tokens podem assumir os seguintes valores:
     * INTEIROS ,REAIS, TIPOS ,OPERADORES, IDENTIFICADORES,
     * PALAVRAS_RESERVADAS, SIMBOLOS_ESPECIAIS, SIMBOLOS_INVÁLIDOS        
     */
    private final String token;
    //Atributos semanticos.
    //private String type;    //Para variaveis ou constantes.
    //private String category;
    //private Object valor;   //Pode assumir valores diferentes de acordo com o tipo.
    //private int escope;  //Semantica sem procedimentos implementada (desnecessário por enquanto).
    //private boolean used;   //Para variaveis.
    //Geração de código.
    //private int Adress;
    //private int pileID;

    public Lexeme(String lexeme, String token) {
        this.lexeme = lexeme;
        this.token = token;
        //valores padrões
//        this.type = "";
//        this.category = "";
//        this.valor = null;
//        this.escope = 0;
//        this.used = false;        
    }

    public String getLexeme() {
        return lexeme;
    }

    public String getToken() {
        return token;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//    
//    public Object getValor() {
//        return valor;
//    }
//
//    public void setValor(Object valor) {
//        this.valor = valor;
//    }
//
//    public int getEscope() {
//        return escope;
//    }
//
//    public void setEscope(int escope) {
//        this.escope = escope;
//    }
//
//    public boolean isUsed() {
//        return used;
//    }
//
//    public void setUsed(boolean used) {
//        this.used = used;
//    }
//
//    public int getAdress() {
//        return Adress;
//    }
//
//    public void setAdress(int Adress) {
//        this.Adress = Adress;
//    }
//
//    public int getPileID() {
//        return pileID;
//    }
//
//    public void setPileID(int pileID) {
//        this.pileID = pileID;
//    } 
}
