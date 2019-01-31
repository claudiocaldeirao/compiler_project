/*
 *
 */
package Structure;

import java.util.ArrayList;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class Pilha {
    private ArrayList<String> pilha;
    private int lenght;

    public Pilha() {
        pilha = new ArrayList<>();
        lenght = 0; //Vazia.
    }

    public void insere(String elemento) {
        pilha.add(elemento);
        lenght ++;
    }

    public String remove() {
        String elemento = pilha.get(lenght - 1);
        pilha.remove(lenght - 1);
        lenght --;
        return elemento;
    }

    public boolean vazia() {
        return lenght <= 0;
    }
    
    public String onTop() {
        return pilha.get(lenght -1);
    }

    public ArrayList<String> getPilha() {
        return pilha;
    }

    public void setPilha(ArrayList<String> pilha) {
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
        for(String l: pilha) {
            System.out.print(" | " + l);            
        }
        System.out.println();
    }    
}
