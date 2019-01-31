/*
 *
 */
package VariableTable;

import java.util.ArrayList;
/*
 * Tabela de variaveis.
 */

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class VariableTable {
    private final ArrayList<Variable> variableTable;

    public VariableTable() {
        variableTable = new ArrayList<>();
    }

    public void addVariable(Variable variable) {
        variableTable.add(variable);
    }

    public boolean containsVariable(String id) {
        for(Variable variable: variableTable) {
            if(variable.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public Variable getVariable(String id) {
        for (Variable variable : variableTable) {
            if (variable.getId().equals(id)) {
                return variable;
            }
        }
        return null;
    }

    public ArrayList<Variable> getVariableTable() {
        return variableTable;
    }
}
