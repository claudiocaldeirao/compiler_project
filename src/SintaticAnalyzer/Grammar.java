/*
 *
 */
package SintaticAnalyzer;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class Grammar {
    //Todos os elementos não terminais da gramática.
    private final String[] naoTerminais = {"S", "A", "B", "BLOCO", "PARTE_DECLARACAO_VARIAVEIS", "PARTE_DECLARACAO_SUBROTINAS"
    , "DECLARACAO_VARIAVEIS", "DECLARACAO_VARIAVEIS'", "LISTA_IDENTIFICADORES", "LISTA_IDENTIFICADORES'", "TIPO", "DECLARACAO_PROCEDIMENTO", "DECLARACAO_PROCEDIMENTO'"
    , "PARAMETROS_FORMAIS", "PARAMETROS_FORMAIS'", "SECAO_PARAMETROS_FORMAIS", "SECAO_PARAMETROS_FORMAIS'", "COMANDO_COMPOSTO", "COMANDO_COMPOSTO'"
    , "COMANDO", "COMANDO'", "ATRIBUICAO", "CHAMADA_PROCEDIMENTO", "CHAMADA_PROCEDIMENTO'", "COMANDO_CONDICIONAL", "COMANDO_CONDICIONAL'", "COMANDO_CONDICIONAL''", "COMANDO_REPETITIVO", "COMANDO_REPETITIVO'"
    , "EXPRESSAO", "EXPRESSAO'", "EXPRESSAO_SIMPLES", "EXPRESSAO_SIMPLES'", "RELACAO", "TERMO", "TERMO'"
    , "FATOR", "VARIAVEL", "VARIAVEL'", "LISTA_EXPRECOES", "LISTA_EXPRECOES'"};    

    //Todos os elementos terminais (tokens) da gramática.
    private final String[] tokens = {
    //Tipos primitivos.
      "INTEIRO", "FLOAT" 
    //Palavras reservadas.        
    , "PALAVRA_RESERVADA_PROGRAM", "PALAVRA_RESERVADA_PROCEDURE", "PALAVRA_RESERVADA_IF", "PALAVRA_RESERVADA_THEN"    
    , "PALAVRA_RESERVADA_ELSE", "PALAVRA_RESERVADA_BEGIN", "PALAVRA_RESERVADA_END"
    , "PALAVRA_RESERVADA_WHILE", "PALAVRA_RESERVADA_DO", "PALAVRA_RESERVADA_VAR", "PALAVRA_RESERVADA_TRUE"
    , "PALAVRA_RESERVADA_FALSE", "PALAVRA_RESERVADA_PRINT", "PALAVRA_RESERVADA_WRITE", "PALAVRA_RESERVADA_READ"
    , "PALAVRA_RESERVADA_AND", "PALAVRA_RESERVADA_OR", "PALAVRA_RESERVADA_NOT"         
    //Tipos
    , "TIPO_INT", "TIPO_FLOAT", "TIPO_CHAR", "TIPO_STRING", "TIPO_BOOLEAN", "IDENTIFICADOR"
    //Operadores.        
    ,"OPERADOR_SOMA", "OPERADOR_SUB", "OPERADOR_MULT", "OPERADOR_DIV", "OPERADOR_ATRIB"
    //Simbolos especiais.        
    , "SIMBOLO_ESPECIAL_IGUAL", "SIMBOLO_ESPECIAL_DIFERENTE", "SIMBOLO_ESPECIAL_MAIOR_IGUAL"
    , "SIMBOLO_ESPECIAL_MAIOR", "SIMBOLO_ESPECIAL_MENOR_IGUAL", "SIMBOLO_ESPECIAL_MENOR", "SIMBOLO_ESPECIAL_PONTO_VIRGULA"
    , "SIMBOLO_ESPECIAL_ABRE_PARENTESE", "SIMBOLO_ESPECIAL_FECHA_PARENTESE","SIMBOLO_ESPECIAL_VIRGULA", "SIMBOLO_ESPECIAL_PONTO_DUPLO"
    , "SIMBOLO_ESPECIAL_PONTO"
    //Vazio
    , "$"};   
    
    //Tabela ASD.
    // O SIMBOLO "#" SEPARA TERMINAIS À ESQUERDA DE NÃO TERMINAIS À DIREITA.
    private final Map<String, String[]> ASD_Table = new HashMap<>();
    
    public Grammar() {
        /*Inserindo Linhas da tabela.*/
        ASD_Table.put("S", new String[] {
    //Tipos primitivos.  
      "", "" 
    //Palavras reservadas.        
    , "PALAVRA_RESERVADA_PROGRAM#A", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""             
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , ""            
    //Vazio
    , "SINC"});
        ASD_Table.put("A", new String[] {
    //Tipos primitivos.        
      "", "" 
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", "IDENTIFICADOR#B"
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , ""           
    //Vazio
    , "SINC"});
        ASD_Table.put("B", new String[] {
    //Tipos primitivos.
      "", "" 
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""                  
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SIMBOLO_ESPECIAL_PONTO_VIRGULA#BLOCO#SIMBOLO_ESPECIAL_PONTO"
    , "", "", "", "" 
    , ""            
    //Vazio
    , "SINC"});
        ASD_Table.put("BLOCO", new String[] {
    //Tipos primitivos. 
      "", "" 
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "SINC", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""              
    //Tipos
    , "PARTE_DECLARACAO_VARIAVEIS#PARTE_DECLARACAO_SUBROTINAS#COMANDO_COMPOSTO", "PARTE_DECLARACAO_VARIAVEIS#PARTE_DECLARACAO_SUBROTINAS#COMANDO_COMPOSTO", "PARTE_DECLARACAO_VARIAVEIS#PARTE_DECLARACAO_SUBROTINAS#COMANDO_COMPOSTO", "PARTE_DECLARACAO_VARIAVEIS#PARTE_DECLARACAO_SUBROTINAS#COMANDO_COMPOSTO", "PARTE_DECLARACAO_VARIAVEIS#PARTE_DECLARACAO_SUBROTINAS#COMANDO_COMPOSTO", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", "" 
    , ""            
    //Vazio
    , "SINC"});
        ASD_Table.put("PARTE_DECLARACAO_VARIAVEIS", new String[] {
    //Tipos primitivos.        
      "", "" 
    //Palavras reservadas.        
    , "", "SINC", "", ""    
    , "", "SINC", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""               
    //Tipos
    , "DECLARACAO_VARIAVEIS", "DECLARACAO_VARIAVEIS", "DECLARACAO_VARIAVEIS", "DECLARACAO_VARIAVEIS", "DECLARACAO_VARIAVEIS", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , ""               
    //Vazio
    , ""});
        ASD_Table.put("PARTE_DECLARACAO_SUBROTINAS", new String[] {
    //Tipos primitivos.        
      "", ""         
    //Palavras reservadas.        
    , "", "DECLARACAO_PROCEDIMENTO", "", ""    
    , "", "SINC", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""            
    //Vazio
    , "$"});
        ASD_Table.put("DECLARACAO_VARIAVEIS", new String[] {
    //Tipos primitivos.        
      "", "" 
    //Palavras reservadas.        
    , "", "SINC", "", ""    
    , "", "SINC", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "TIPO_INT#LISTA_IDENTIFICADORES#DECLARACAO_VARIAVEIS'", "TIPO_FLOAT#LISTA_IDENTIFICADORES#DECLARACAO_VARIAVEIS'", "TIPO_CHAR#LISTA_IDENTIFICADORES#DECLARACAO_VARIAVEIS'", "TIPO_STRING#LISTA_IDENTIFICADORES#DECLARACAO_VARIAVEIS'", "TIPO_BOOLEAN#LISTA_IDENTIFICADORES#DECLARACAO_VARIAVEIS'", "IDENTIFICADOR#LISTA_IDENTIFICADORES#LISTA_IDENTIFICADORES#DECLARACAO_VARIAVEIS'"
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("DECLARACAO_VARIAVEIS'", new String[] {
    //Tipos primitivos.        
      "", ""             
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""              
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SIMBOLO_ESPECIAL_PONTO_VIRGULA#DECLARACAO_VARIAVEIS"
    , "", "", "", ""
    , ""             
    //Vazio
    , "$"});
        ASD_Table.put("LISTA_IDENTIFICADORES", new String[] {
    //Tipos primitivos.        
      "", ""             
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""           
    //Tipos
    , "", "", "", "", "", "IDENTIFICADOR#LISTA_IDENTIFICADORES'"
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", "SINC"
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("LISTA_IDENTIFICADORES'", new String[] {
    //Tipos primitivos.        
      "", ""             
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", "SIMBOLO_ESPECIAL_VIRGULA#IDENTIFICADOR#LISTA_IDENTIFICADORES'"
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "SIMBOLO_ESPECIAL_VIRGULA#IDENTIFICADOR#LISTA_IDENTIFICADORES'", "SINC"
    , ""            
    //Vazio
    , "$"});
        ASD_Table.put("TIPO", new String[] {
    //Tipos primitivos.        
      "", ""             
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "TIPO_INT", "TIPO_FLOAT", "TIPO_CHAR", "TIPO_STRING", "TIPO_BOOLEAN", "SINC"
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , ""             
    //Vazio
    , ""});        
        ASD_Table.put("DECLARACAO_PROCEDIMENTO", new String[] {
    //Tipos primitivos.        
      "", ""             
    //Palavras reservadas.        
    , "", "PALAVRA_RESERVADA_PROCEDURE#DECLARACAO_PROCEDIMENTO'", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""                 
    //Vazio
    , ""});
        ASD_Table.put("DECLARACAO_PROCEDIMENTO'", new String[] {
    //Tipos primitivos.        
      "", ""             
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", "IDENTIFICADOR#PARAMETROS_FORMAIS#SIMBOLO_ESPECIAL_PONTO_VIRGULA#BLOCO"
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""                    
    //Vazio
    , "$"});             
        ASD_Table.put("PARAMETROS_FORMAIS", new String[] {
    //Tipos primitivos.        
      "", "" 
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""             
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "SIMBOLO_ESPECIAL_ABRE_PARENTESE#SECAO_PARAMETROS_FORMAIS#PARAMETROS_FORMAIS'#SIMBOLO_ESPECIAL_FECHA_PARENTESE", "", "", ""
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("PARAMETROS_FORMAIS'", new String[] {
    //Tipos primitivos.       
      "", ""
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SIMBOLO_ESPECIAL_PONTO_VIRGULA#SECAO_PARAMETROS_FORMAIS"
    , "", "SINC", "", ""
    , ""            
    //Vazio
    , "$"});
        ASD_Table.put("SECAO_PARAMETROS_FORMAIS", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "PALAVRA_RESERVADA_VAR#LISTA_IDENTIFICADORES#SECAO_PARAMETROS_FORMAIS'", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("SECAO_PARAMETROS_FORMAIS'", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", "SIMBOLO_ESPECIAL_PONTO_DUPLO#TIPO"
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("COMANDO_COMPOSTO", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""    
    , "SINC", "PALAVRA_RESERVADA_BEGIN#COMANDO#COMANDO_COMPOSTO'#PALAVRA_RESERVADA_END", "SINC"
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , "SINC"                 
    //Vazio
    , "SINC"});       
        ASD_Table.put("COMANDO_COMPOSTO'", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""  
    , "SINC", "SINC", "SINC"
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SIMBOLO_ESPECIAL_PONTO_VIRGULA#COMANDO"
    , "", "", "", ""
    , ""             
    //Vazio
    , "$"});
        ASD_Table.put("COMANDO", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "COMANDO_CONDICIONAL", ""    
    , "SINC", "COMANDO_COMPOSTO#COMANDO_COMPOSTO'", "SINC"              
    , "COMANDO_REPETITIVO", "", "", ""
    , "", "PALAVRA_RESERVADA_PRINT#CHAMADA_PROCEDIMENTO#COMANDO_COMPOSTO'", "PALAVRA_RESERVADA_WRITE#CHAMADA_PROCEDIMENTO#COMANDO_COMPOSTO'", "PALAVRA_RESERVADA_READ#CHAMADA_PROCEDIMENTO#COMANDO_COMPOSTO'"
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", "VARIAVEL#COMANDO'#COMANDO_COMPOSTO'"
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""             
    //Vazio
    , ""});
        ASD_Table.put("COMANDO'", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""    
    , "SINC", "", "SINC"              
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", "ATRIBUICAO"
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "CHAMADA_PROCEDIMENTO", "", "", ""
    , ""            
    //Vazio
    , ""});        
        ASD_Table.put("ATRIBUICAO", new String[] {
    //Tipos primitivos.       
      "", ""           
    //Palavras reservadas.        
    , "", "", "", ""    
    , "SINC", "", "SINC"
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", "OPERADOR_ATRIB#EXPRESSAO"
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""                    
    //Vazio
    , ""});
        ASD_Table.put("CHAMADA_PROCEDIMENTO", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""  
    , "SINC", "", "SINC"
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""                
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "CHAMADA_PROCEDIMENTO'", "", "", ""
    , ""                 
    //Vazio
    , ""});
        ASD_Table.put("CHAMADA_PROCEDIMENTO'", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""  
    , "SINC", "", "SINC"
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""                
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "SIMBOLO_ESPECIAL_ABRE_PARENTESE#LISTA_EXPRECOES#SIMBOLO_ESPECIAL_FECHA_PARENTESE", "", "", ""
    , ""            
    //Vazio
    , ""});        
        ASD_Table.put("COMANDO_CONDICIONAL", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "PALAVRA_RESERVADA_IF#EXPRESSAO#COMANDO_CONDICIONAL'", ""    
    , "SINC", "", "SINC"
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""                   
    //Vazio
    , ""});
        ASD_Table.put("COMANDO_CONDICIONAL'", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", "PALAVRA_RESERVADA_THEN#COMANDO#COMANDO_CONDICIONAL''"    
    , "SINC", "COMANDO#COMANDO_CONDICIONAL''", "SINC"
    , "COMANDO#COMANDO_CONDICIONAL''", "", "", ""
    , "", "COMANDO#COMANDO_CONDICIONAL''", "COMANDO#COMANDO_CONDICIONAL''", "COMANDO#COMANDO_CONDICIONAL''"
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", "COMANDO#COMANDO_CONDICIONAL''"
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""             
    //Vazio
    , ""}); 
        ASD_Table.put("COMANDO_CONDICIONAL''", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""    
    , "PALAVRA_RESERVADA_ELSE#COMANDO", "", "SINC"
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""            
    //Vazio
    , "$"});            
        ASD_Table.put("COMANDO_REPETITIVO", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""    
    , "SINC", "", "SINC"
    , "PALAVRA_RESERVADA_WHILE#EXPRESSAO#COMANDO_REPETITIVO'", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("COMANDO_REPETITIVO'", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "", ""    
    , "SINC", "COMANDO", "SINC"
    , "COMANDO", "PALAVRA_RESERVADA_DO#COMANDO", "", ""
    , "", "COMANDO", "COMANDO", "COMANDO"
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", "COMANDO"
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", "SINC"
    , "", "", "", ""
    , ""            
    //Vazio
    , ""});        
        ASD_Table.put("EXPRESSAO", new String[] {
    //Tipos primitivos.   
      "EXPRESSAO_SIMPLES#EXPRESSAO'", "EXPRESSAO_SIMPLES#EXPRESSAO'"
    //Palavras reservadas.        
    , "", "", "SINC", "SINC"    
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "", "EXPRESSAO_SIMPLES#EXPRESSAO'"
    , "EXPRESSAO_SIMPLES#EXPRESSAO'", "", "", ""
    , "SINC", "SINC", ""            
    //Tipos
    , "", "", "", "", "", "EXPRESSAO_SIMPLES#EXPRESSAO'"
    //Operadores.        
    ,"EXPRESSAO_SIMPLES#EXPRESSAO'", "EXPRESSAO_SIMPLES#EXPRESSAO'", "SINC", "SINC", "SINC"
    //Simbolos especiais.        
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "SINC"
    , "EXPRESSAO_SIMPLES#EXPRESSAO'", "SINC", "SINC", ""
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("EXPRESSAO'", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "SINC", "SINC"    
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "", ""
    , "", "", "", ""
    , "SINC", "SINC", ""            
    //Tipos
    , "", "", "", "", "", "SINC"
    //Operadores.        
    , "SINC", "SINC", "SINC", "SINC", "SINC"
    //Simbolos especiais.        
    , "RELACAO#EXPRESSAO_SIMPLES", "RELACAO#EXPRESSAO_SIMPLES", "RELACAO#EXPRESSAO_SIMPLES"
    , "RELACAO#EXPRESSAO_SIMPLES", "RELACAO#EXPRESSAO_SIMPLES", "RELACAO#EXPRESSAO_SIMPLES", "SINC"
    , "SINC", "SINC", "SINC", ""
    , ""            
    //Vazio
    , "$"});        
        ASD_Table.put("EXPRESSAO_SIMPLES", new String[] {
    //Tipos primitivos.       
      "TERMO#EXPRESSAO_SIMPLES'", "TERMO#EXPRESSAO_SIMPLES'"            
    //Palavras reservadas.        
    , "", "", "SINC", "SINC"    
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "", "TERMO#EXPRESSAO_SIMPLES'"
    , "TERMO#EXPRESSAO_SIMPLES'", "", "", ""
    , "SINC", "SINC", ""              
    //Tipos
    , "", "", "", "", "", "TERMO#EXPRESSAO_SIMPLES'"
    //Operadores.        
    ,"OPERADOR_SOMA#TERMO#EXPRESSAO_SIMPLES'", "OPERADOR_SUB#TERMO#EXPRESSAO_SIMPLES'", "SINC", "SINC", "SINC"
    //Simbolos especiais.        
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "SINC"
    , "TERMO#EXPRESSAO_SIMPLES'", "SINC", "SINC", "" 
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("EXPRESSAO_SIMPLES'", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "SINC", "SINC"    
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "", ""
    , "", "", "", ""
    , "SINC", "PALAVRA_RESERVADA_OR#TERMO", ""              
    //Tipos
    , "", "", "", "", "", "SINC"
    //Operadores.        
    ,"OPERADOR_SOMA#TERMO", "OPERADOR_SUB#TERMO", "SINC", "SINC", "SINC"
    //Simbolos especiais.        
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "" 
    , ""            
    //Vazio
    , "$"});        
        ASD_Table.put("RELACAO", new String[] {
    //Tipos primitivos.       
      "SINC", "SINC"            
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", "SINC"            
    //Tipos
    , "", "", "", "", "", "SINC"
    //Operadores.        
    ,"SINC", "SINC", "", "", ""
    //Simbolos especiais.        
    , "SIMBOLO_ESPECIAL_IGUAL", "SIMBOLO_ESPECIAL_DIFERENTE", "SIMBOLO_ESPECIAL_MAIOR_IGUAL"
    , "SIMBOLO_ESPECIAL_MAIOR", "SIMBOLO_ESPECIAL_MENOR_IGUAL", "SIMBOLO_ESPECIAL_MENOR", ""
    , "SINC", "", "", ""
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("TERMO", new String[] {
    //Tipos primitivos.      
      "FATOR#TERMO'", "FATOR#TERMO'"
    //Palavras reservadas.        
    , "", "", "SINC", "SINC"    
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "", "FATOR#TERMO'"
    , "FATOR#TERMO'", "", "", ""
    , "FATOR#TERMO'", "SINC", ""            
    //Tipos
    , "", "", "", "", "", "FATOR#TERMO'"
    //Operadores.        
    ,"", "", "FATOR#TERMO'", "FATOR#TERMO'", "SINC"
    //Simbolos especiais.        
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "SINC"
    , "FATOR#TERMO'", "SINC", "SINC", ""
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("TERMO'", new String[] {
    //Tipos primitivos.       
      "", ""            
    //Palavras reservadas.        
    , "", "", "SINC", "SINC"    
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "", ""
    , "", "", "", ""
    , "PALAVRA_RESERVADA_AND#FATOR", "SINC", ""              
    //Tipos
    , "", "", "", "", "", "SINC"
    //Operadores.        
    ,"SINC", "SINC", "OPERADOR_MULT#FATOR", "OPERADOR_DIV#FATOR", "SINC"
    //Simbolos especiais.        
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "" 
    , ""            
    //Vazio
    , "$"});        
        ASD_Table.put("FATOR", new String[] {
    //Tipos primitivos.       
      "INTEIRO", "FLOAT"
    //Palavras reservadas.        
    , "", "", "SINC", "SINC"    
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "", "PALAVRA_RESERVADA_TRUE"
    , "PALAVRA_RESERVADA_FALSE", "", "", ""
    , "SINC", "SINC", "PALAVRA_RESERVADA_NOT#FATOR"            
    //Tipos
    , "", "", "", "", "", "VARIAVEL"
    //Operadores.        
    ,"SINC", "SINC", "SINC", "SINC", "SINC"
    //Simbolos especiais.        
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "SINC"
    , "SIMBOLO_ESPECIAL_ABRE_PARENTESE#EXPRESSAO#SIMBOLO_ESPECIAL_FECHA_PARENTESE", "SINC", "SINC", "" 
    , ""            
    //Vazio
    , ""});
        ASD_Table.put("VARIAVEL", new String[] {
    //Tipos primitivos.       
      "", ""        
    //Palavras reservadas.        
    , "", "", "SINC", "SINC"    
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "", ""
    , "", "", "", ""
    , "SINC", "SINC", ""            
    //Tipos
    , "", "", "", "", "", "IDENTIFICADOR#VARIAVEL'"
    //Operadores.        
    ,"SINC", "SINC", "SINC", "SINC", "SINC"
    //Simbolos especiais.        
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", ""
    , ""              
    //Vazio
    , ""});
        ASD_Table.put("VARIAVEL'", new String[] {
    //Tipos primitivos.       
      "", ""         
    //Palavras reservadas.        
    , "", "", "SINC", "SINC"    
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "", ""
    , "", "", "", ""
    , "SINC", "SINC", ""            
    //Tipos
    , "", "", "", "", "", "EXPRESSAO"
    //Operadores.        
    ,"EXPRESSAO", "EXPRESSAO", "SINC", "SINC", "SINC"
    //Simbolos especiais.        
    , "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", "SINC"
    , "SINC", "SINC", "SINC", ""
    , ""            
    //Vazio
    , "$"});
        ASD_Table.put("LISTA_EXPRECOES", new String[] {
    //Tipos primitivos.       
      "", ""   
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", "EXPRESSAO#LISTA_EXPRECOES'"
    //Operadores.        
    ,"EXPRESSAO#LISTA_EXPRECOES'", "EXPRESSAO#LISTA_EXPRECOES'", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", ""
    , "", "SINC", "", ""
    , ""                    
    //Vazio
    , ""});
        ASD_Table.put("LISTA_EXPRECOES'", new String[] {
    //Tipos primitivos.       
      "", ""     
    //Palavras reservadas.        
    , "", "", "", ""    
    , "", "", ""
    , "", "", "", ""
    , "", "", "", ""
    , "", "", ""            
    //Tipos
    , "", "", "", "", "", ""
    //Operadores.        
    ,"", "", "", "", ""
    //Simbolos especiais.        
    , "", "", ""
    , "", "", "", ""
    , "", "SINC", "SIMBOLO_ESPECIAL_VIRGULA#EXPRESSAO", ""
    , ""            
    //Vazio
    , "$"});
    } 

    public String[] getTokens() {
        return tokens;
    }

    public String[] getNaoTerminais() {
        return naoTerminais;
    }
    
    public boolean containsToken(String element) {
        for (String t : tokens) {
            if (t.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Map<String, String[]> getASD_Table() {
        return ASD_Table;
    } 
}
