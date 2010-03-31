package com.sap.tc.moin.repository.test.ocl.ia.evaluation.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Vector;

/**
 * @author d039141
 */
public class EvaluationDataSet {

    private List<EvaluationData> data = new Vector<EvaluationData>( );

    private String name = "";

    long initTime = 0;

    /**
     * @param d
     */
    public void addData( EvaluationData d ) {

        this.data.add( d );
    }

    /**
     * @return Returns the data.
     */
    public List<EvaluationData> getData( ) {

        return this.data;
    }

    /**
     * @return Returns the name.
     */
    public String getName( ) {

        return this.name;
    }

    /**
     * @param out
     * @param detailedView
     * @throws IOException
     */
    public void printAsCSL( OutputStream out, boolean detailedView ) throws IOException {

        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( out ) );
        writer.write( "Evaluation of: " + this.name + "\n" );
        writer.write( "Initialization time: " + this.formatTime( this.initTime ) + "\n" );
        if ( detailedView ) {
            writer.write( "Event;NumInstances;NumStatements;Filter time;Instance computation time;Evaluation time;Total time\n" );
        }
        writer.flush( );
        long totalInstances = 0;
        long totalStatements = 0;
        long totalInstanceTime = 0;
        long totalFilterTime = 0;
        long totalEvalTime = 0;
        long grandTotalTime = 0;
        for ( EvaluationData d : this.data ) {
            if ( detailedView ) {
                d.printAsCSL( out );
            }
            totalInstances += d.getNumberOfInstances( );
            totalStatements += d.getNumberOfAffectedStmts( );
            totalInstanceTime += d.getInstanceComputationTime( );
            totalFilterTime += d.getFilterTime( );
            totalEvalTime += d.getEvaluationTime( );
            grandTotalTime += d.getTotalTime( );
        }
        writer.write( "Total number of instances: " + totalInstances + "\n" );
        writer.write( "Total number of statements: " + totalStatements + "\n" );
        writer.write( "Total instance computation time: " + this.formatTime( totalInstanceTime ) + "\n" );
        writer.write( "Total filter time: " + this.formatTime( totalFilterTime ) + "\n" );
        writer.write( "Total evaluation time: " + this.formatTime( totalEvalTime ) + "\n" );
        writer.write( "Grand total time: " + this.formatTime( grandTotalTime ) + "\n" );
        writer.flush( );
    }

    /**
     * @param name The name to set.
     */
    public void setName( String name ) {

        this.name = name;
    }

    /**
     * @return Returns the initTime.
     */
    public long getInitTime( ) {

        return this.initTime;
    }

    /**
     * @param initTime The initTime to set.
     */
    public void setInitTime( long initTime ) {

        this.initTime = initTime;
    }

    private String formatTime( long timeInNanoSeconds ) {

        long seconds = timeInNanoSeconds / 1000000000;
        if ( seconds > 10 ) {
            return "" + seconds + " seconds";
        }
        long milli = timeInNanoSeconds / 1000000;
        if ( milli > 10 ) {
            return "" + milli + " milliseconds";
        }
        long micro = timeInNanoSeconds / 1000;
        if ( micro > 10 ) {
            return "" + micro + " microseconds";
        }
        return "" + timeInNanoSeconds + " nanoseconds";
    }
}