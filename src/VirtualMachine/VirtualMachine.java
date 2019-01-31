/*
 *
 */
package VirtualMachine;

import UserUI.ProgramUI;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class VirtualMachine {
    //INTERFACE DA MAQUINA VIRTUAL.
    private ProgramUI window;
    
    private float[] memory;
    private ArrayList<String> objectCode;
    
    private int i;  //Contador de código.    
    private int s;  //Topo da pilha de dados. 
    
    private float parameterBuffer;

    public VirtualMachine() {
        window = new ProgramUI();
        //window.setVisible(true);
    }

    public void inicialize(ArrayList<String> objectCode) {
        this.objectCode = objectCode;
        memory = new float[100];
        this.s = 0;
    }
    
    public void process() {
        ArrayList<String> code = objectCode;
        String comand = "", parameter = "";
        int index;
//------------------------------------------------------------------------------
        //Separa o comando do parametro.
        for (String line : code) {
            if (!line.equals("PARA")) {
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == ' ') {
                        comand = line.substring(0, j);
                        parameter = line.substring(j + 1);
                        break;
                    } else {
                        comand = line;
                        parameter = "";
                    }
                }
//------------------------------------------------------------------------------            
                switch (comand) {
                    case "INPP":
                        i++;
                        break;
                    case "AMEM":
                        i++;
                        s += Integer.valueOf(parameter);
                        break;
                    case "CRCT":
                        i++;
                        s++;
                        memory[s] = Float.valueOf(parameter);
                        break;
                    case "CRVL":
                        i++;
                        s++;
                        index = Integer.valueOf(parameter);
                        memory[s] = memory[index];
                        break;
                    case "ARMZ":
                        i++;
                        index = Integer.valueOf(parameter);
                        memory[index] = memory[s];
                        s--;
                        break;
                    case "LEIT":                        
                        i++;                      
                        parameterBuffer = Float.valueOf(JOptionPane.showInputDialog("Insira o valor de" + ":"));
                        s++;
                        memory[s] = parameterBuffer;
                        break;
                    case "IMPR":
                        parameterBuffer = memory[s];
                        //window.showMessage(String.valueOf(parameterBuffer));
                        JOptionPane.showMessageDialog(null, "Resultado: "+parameterBuffer);
                        s--;
                        break;
                    case "SOMA":
                        i++;
                        memory[s - 1] = memory[s] + memory[s - 1];
                        s--;
                        break;
                    case "SUB":
                        i++;
                        memory[s - 1] = memory[s] - memory[s - 1];
                        s--;                       
                        break;
                    case "MULT":
                        i++;
                        memory[s - 1] = memory[s] * memory[s - 1];
                        s--;                      
                        break;
                    case "DIV":
                        i++;
                        memory[s - 1] = memory[s] / memory[s - 1];
                        s--;                      
                        break;
                }
            }
        }
    }
    
    public void setParameter(float parameterBuffer) {
        this.parameterBuffer = parameterBuffer;
    }
    
    public float getParameter() {
        return parameterBuffer;
    }
}
