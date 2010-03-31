package com.sap.junit;

import org.junit.runners.model.Statement;

public class MoinRepetitionStatement extends Statement {

    private final Statement innerStatement;
    private final int repetitions;

    public MoinRepetitionStatement(Statement createMethodRunner, int repetitions) {
        this.innerStatement = createMethodRunner;
        this.repetitions = repetitions;
    }

    @Override
    
    public void evaluate() throws Throwable {
        for(int i = 1; i <= repetitions; i++) {
            innerStatement.evaluate();
        }
        //TODO change description to add: " [" + rep + "]" 
    }

}
