package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

public class ValueNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -7891419750697209233L;
    private final String variableName;

    public ValueNotFoundException(String variableName) {
        super("Trying to access variable " + variableName + " which has not been set before.");
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }
}