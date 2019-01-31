/*
 *
 */
package Structure;

import LexicalAnalyzer.LexemePosition;
import java.util.ArrayList;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class PilhaLexeme {
    private ArrayList<LexemePosition> pilha;
    private int lenght;

    public PilhaLexeme() {
        pilha = new ArrayList<>();
        lenght = 0; //Vazia.
    }

    public void insere(LexemePosition elemento) {
        pilha.add(elemento);
        lenght ++;
    }

    public LexemePosition remove() {
        LexemePosition elemento = pilha.get(lenght - 1);
        pilha.remove(lenght - 1);
        lenght --;
        return elemento;
    }

    public boolean vazia() {
        return lenght <= 0;
    }
    
    public LexemePosition onTop() {
        return pilha.get(lenght -1);
    }

    public ArrayList<LexemePosition> getPilha() {
        return pilha;
    }

    public void setPilha(ArrayList<LexemePosition> pilha) {
        this.pilha = pilha;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }  

    public void mostraPilha() {
        System.out.println();
        for(LexemePosition l: pilha) {
            System.out.print(" | " + l.getLexeme().getToken());            
        }
        System.out.println();
    }      
}
