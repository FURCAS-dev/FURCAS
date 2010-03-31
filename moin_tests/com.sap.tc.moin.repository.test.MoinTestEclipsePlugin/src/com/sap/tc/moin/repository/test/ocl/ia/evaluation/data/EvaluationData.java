package com.sap.tc.moin.repository.test.ocl.ia.evaluation.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.EventPrinter;

/**
 * @author d039141
 */
public class EvaluationData {

    /**
     * 
     */
    private long evaluationTime = 0;

    /**
     * 
     */
    private ModelChangeEvent event = null;

    /**
     * 
     */
    private long filterTime = 0;

    /**
     * 
     */
    private long instanceComputationTime = 0;

    /**
     * 
     */
    private long numberOfAffectedStmts = 0;

    /**
     * 
     */
    private long numberOfInstances = 0;

    /**
     * @return Returns the evaluationTime.
     */
    public long getEvaluationTime( ) {

        return this.evaluationTime;
    }

    /**
     * @return Returns the event.
     */
    public ModelChangeEvent getEvent( ) {

        return this.event;
    }

    /**
     * @return Returns the filterTime.
     */
    public long getFilterTime( ) {

        return this.filterTime;
    }

    /**
     * @return Returns the instanceComputationTime.
     */
    public long getInstanceComputationTime( ) {

        return this.instanceComputationTime;
    }

    /**
     * @return Returns the numberOfAffectedStmts.
     */
    public long getNumberOfAffectedStmts( ) {

        return this.numberOfAffectedStmts;
    }

    /**
     * @return Returns the numberOfInstances.
     */
    public long getNumberOfInstances( ) {

        return this.numberOfInstances;
    }

    /**
     * @param evaluationTime The evaluationTime to set.
     */
    public void setEvaluationTime( long evaluationTime ) {

        this.evaluationTime = evaluationTime;
    }

    /**
     * @param event The event to set.
     */
    public void setEvent( ModelChangeEvent event ) {

        this.event = event;
    }

    /**
     * @param filterTime The filterTime to set.
     */
    public void setFilterTime( long filterTime ) {

        this.filterTime = filterTime;
    }

    /**
     * @param instanceComputationTime The instanceComputationTime to set.
     */
    public void setInstanceComputationTime( long instanceComputationTime ) {

        this.instanceComputationTime = instanceComputationTime;
    }

    /**
     * @param numberOfAffectedStmts The numberOfAffectedStmts to set.
     */
    public void setNumberOfAffectedStmts( long numberOfAffectedStmts ) {

        this.numberOfAffectedStmts = numberOfAffectedStmts;
    }

    /**
     * @param numberOfInstances The numberOfInstances to set.
     */
    public void setNumberOfInstances( long numberOfInstances ) {

        this.numberOfInstances = numberOfInstances;
    }

    /**
     * @return the time
     */
    public long getTotalTime( ) {

        return this.filterTime + this.instanceComputationTime + this.evaluationTime;
    }

    /**
     * @param out
     * @throws IOException
     */
    public void printAsCSL( OutputStream out ) throws IOException {

        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( out ) );
        writer.write( EventPrinter.printEvent( this.event ) + ";" );
        writer.write( this.numberOfInstances + ";" );
        writer.write( this.numberOfAffectedStmts + ";" );
        writer.write( this.filterTime + ";" );
        writer.write( this.instanceComputationTime + ";" );
        writer.write( this.evaluationTime + ";" );
        writer.write( this.getTotalTime( ) + "\n" );
        writer.flush( );
    }
}