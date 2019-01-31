/*
 *
 */
package ObjectCode;

import java.util.ArrayList;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class ObjectCode {
    private ArrayList<String> objectCode;
    private int cont;
    
    public ObjectCode() {
        this.objectCode = new ArrayList<>();
        this.cont = 0;
    }
    
    public void concat(String code) {
        this.objectCode.add(code);
        cont++;
    }
    
    public void concatOperation(String code) {
        //Insere a operação primeiro, antes da variavel mais a esquerda.
        String buffer = objectCode.get(cont - 1);
        objectCode.set(cont - 1, code);
        objectCode.add(buffer);
    }

    public ArrayList<String> getObjectCode() {
        return objectCode;
    } 
}
