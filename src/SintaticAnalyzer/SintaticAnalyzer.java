/*
 *
 */
package SintaticAnalyzer;

import LexicalAnalyzer.Lexeme;
import LexicalAnalyzer.LexemePosition;
import LexicalAnalyzer.LexemeTable;
import SemanticAnalyzer.SemanticAnalyzer;
import Structure.Pilha;
import Structure.PilhaLexeme;
import java.util.ArrayList;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class SintaticAnalyzer {
    //Tabela com regras da gramatica.
    private final Grammar ASD;
    //Onde empilharemos os NTs.
    private Pilha pilhaNT;
    //Cadeia que será analisada.
    private PilhaLexeme pileEntry;
    private final ArrayList<LexemePosition> lexemeTable;
    //ARRAY DE ERROS!
    private ArrayList<SintaticError> errors;
    private boolean gramaticaValida;
    private long start;
    private long end;
    //Analisador Semantico (opera em conjunto com o sintático em tempo de compilação)
    SemanticAnalyzer semanticAnalyzer;
    
    
    public SintaticAnalyzer(LexemeTable lexemeTable) {
        this.lexemeTable = lexemeTable.getLexemeTable();
        ASD = new Grammar();
        pilhaNT = new Pilha();
        pileEntry = new PilhaLexeme();
        errors = new ArrayList<>();
        gramaticaValida = false;
        semanticAnalyzer = new SemanticAnalyzer(lexemeTable);
    }  
    
    public void analyzeEntry() {
        start = System.currentTimeMillis();
        String [] indices = ASD.getTokens();
        String RHS, RHS2;
        fillPile(lexemeTable);
        
        //Iniciando a analise.
        pilhaNT.insere("$");    //Elemento vazio. 
        pilhaNT.insere("S");    //Elemento inicial. 
        
        //Buffers p/ consulta na tabela.
        String bufferNT;    //Não terminal.
        String bufferT;     //terminal.
        
        while((!pileEntry.onTop().getLexeme().getLexeme().equals("$")) && (!pilhaNT.onTop().equals("$"))) {
            int i = 0;
            bufferT = pileEntry.onTop().getLexeme().getToken();
            String[] lineTable = ASD.getASD_Table().get(pilhaNT.onTop());
            if (lineTable == null) {    //onTop era terminal.                
                if(pilhaNT.onTop().equals(bufferT)) {   //CASA!
                    /*SEMANTICA*/
                    LexemePosition symbol = pileEntry.onTop();                    
                    /*SINTATICA*/                    
                    pilhaNT.remove();
                    pileEntry.remove();
                    /*SEMANTICA*/
                    semanticAnalyzer.analyzeEntry(symbol, pileEntry);
                } 
                else { //ERRO! DOIS TERMINAIS NÃO COMPATIVEIS.                         
                    //adiciona erro no vetor.
                    errors.add(new SintaticError(pileEntry.onTop(), "ERRO: "+ pileEntry.onTop().getLexeme().getLexeme() +" ESPERADO: " + pilhaNT.onTop()));
                    pilhaNT.remove(); //remove caractere p/ tentar retomar analise.
                }
            } else {                
                for (; i < indices.length; i++) {
                    if (indices[i].equals(bufferT)) { //Achando a coluna na table.
                        break;
                    }
                }
                //Elemento contido na célula(NT, T) da tabela.
                bufferNT = lineTable[i];

                if (lineTable[i].equals("")) {   //Vazia                
                    //adiciona erro no vetor.
                    errors.add(new SintaticError(pileEntry.onTop(), "ERRO: SIMBOLO (" + pileEntry.onTop().getLexeme().getLexeme() + ") NÃO ESPERADO!"));    
                    pileEntry.remove(); //remove caractere p/ tentar retomar analise.
                } else if (lineTable[i].equals("SINC")) {    //Token de sincronização.
                    pilhaNT.remove();
                } else {
                    //Dividiremos a string em todas as "#" e empilharemos devidamente em pilhaNT.
                    int k = bufferNT.length();
                    
                    if (!bufferNT.contains("#")) {    //Contem apenas um  único elemento
                            pilhaNT.remove();
                            pilhaNT.insere(bufferNT);                                                               
                    } else {    //Teremos que dividir os elementos em '#' para empilhar.
                        pilhaNT.remove();
                        for (int j = bufferNT.length() - 1; j >= 0; j--) {
                            if (bufferNT.charAt(j) == '#') { //elemento separador.                        
                                RHS = bufferNT.substring(j + 1, k);
                                k = j;
                                pilhaNT.insere(RHS);
                            }
                        }
                        //Ultimo token vaza no looping.
                        RHS2 = bufferNT.substring(0, k);
                        pilhaNT.insere(RHS2);
                    }
                }                    
            }         
        }
               
        if ((pilhaNT.onTop().equals("$")) && (pileEntry.onTop().getLexeme().getToken().equals("$"))) {
            gramaticaValida = true;
        }        
        end = System.currentTimeMillis();
        //Mesma duração pois executam em conjunto.
        semanticAnalyzer.finalEntry();  //Adiciona o comando PARA.
        semanticAnalyzer.setTime(this.getTime());
    }
    
    public ArrayList<SintaticError> getErrors() {
        return errors;
    }

    public boolean isGramaticaValida() {
        return gramaticaValida;
    }  
    
    private void fillPile(ArrayList<LexemePosition> lexemes) {
        Lexeme l = new Lexeme("$", "$");
        pileEntry.insere(new LexemePosition(l, 0, 0, 0));
        for(int i = lexemes.size() - 1; i >= 0; i--) {        
            pileEntry.insere(lexemes.get(i));
        }
    }

    public long getTime() {
        return (end - start);
    }

    public SemanticAnalyzer getSemanticAnalyzer() {
        return semanticAnalyzer;
    }  
}
