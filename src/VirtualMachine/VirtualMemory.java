/*
 *
 */
package VirtualMachine;

import java.util.ArrayList;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class VirtualMemory {    
    private ArrayList memory;
    private final int absoluteAddress = 0;
    private int nextAddress;
    
    public VirtualMemory() {
        memory = new ArrayList<>();
        this.nextAddress = 0;
    }
    
    public void storeInMemory(Object valor) {
        memory.add(valor);
        this.nextAddress++;
    }

    public ArrayList getMemory() {
        return memory;
    }

    public int getAbsoluteAddress() {
        return absoluteAddress;
    }  

    public int getNextAddress() {
        return nextAddress;
    }
}
