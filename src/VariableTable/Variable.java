/*
 *
 */
package VariableTable;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class Variable {
    private String id;   
    private String type;    
    private String category;
    private float valor;
    //Semantica sem procedimentos implementada (desnecessário por enquanto).
    private int escope;
    private boolean used;
    //Endereço relativo.
    private int Adress;
    private int pileID;  

    public Variable() {
        this.used = false;            
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getEscope() {
        return escope;
    }

    public void setEscope(int escope) {
        this.escope = escope;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getAdress() {
        return Adress;
    }

    public void setAdress(int Adress) {
        this.Adress = Adress;
    }

    public int getPileID() {
        return pileID;
    }

    public void setPileID(int pileID) {
        this.pileID = pileID;
    }
}
