package de.hp.sam.bp2009.eventManagerEvaluation;

import java.io.IOException;

import de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.EmbedQEOperatorImpl;

public class Operator extends EmbedQEOperatorImpl implements de.hpi.sam.bp2009.benchframework.Operator {
    public Operator() {

    }

    @Override
    public void execute() {
        try {
            EventManagerRuntimeTest.main(null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public String getDescription() {
        return "No and Never";
    }

    @Override
    public String getName() {
        return "EventManagerMeasurement";
    }

}
