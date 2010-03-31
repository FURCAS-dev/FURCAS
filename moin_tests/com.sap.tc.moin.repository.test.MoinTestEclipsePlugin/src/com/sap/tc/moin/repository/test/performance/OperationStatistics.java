package com.sap.tc.moin.repository.test.performance;

import java.io.PrintStream;
import java.util.Collection;

/**
 * Helper class to create statistics information on any operation in Java. This
 * class offers also a readable printout of the data
 * 
 * @author d024227
 */
public class OperationStatistics {

    private String operation;

    private int executionCount;

    private long time;

    private long memory;

    /**
     * Empty constructor. In order to have proper information, the individual
     * values have to e set by setter calls
     */
    public OperationStatistics( ) {

        this.operation = null;
        this.executionCount = 0;
        this.time = 0;
        this.memory = Long.MIN_VALUE;
    }

    /**
     * Constructor to create statistics info on a certain operation. The
     * operation might have been called multiple times which is to be specified
     * by executionCount. The total amount of time needed is to be specified by
     * time [ms].
     * 
     * @param operation the name or id to identify an operation. Can be anything
     * @param executionCount the number of executions
     * @param time total amount of time [ms] needed to execute the operation
     * "executionCount" number of times
     */
    public OperationStatistics( String operation, int executionCount, long time ) {

        this.operation = operation;
        this.executionCount = executionCount;
        this.time = time;
        this.memory = Long.MIN_VALUE;
    }

    /**
     * Constructor to create statistics info on a certain operation. The
     * operation might have been called multiple times which is to be specified
     * by executionCount. The total amount of time needed is to be specified by
     * time [ms]. The total amount of memory consumed is to be specified in
     * memory
     * 
     * @param operation the name or id to identify an operation. Can be anything
     * @param executionCount the number of executions
     * @param time total amount of time [ms] needed to execute the operation
     * "executionCount" number of times
     * @param memory total amount of memory consumed
     */
    public OperationStatistics( String operation, int executionCount, long time, long memory ) {

        this.operation = operation;
        this.executionCount = executionCount;
        this.time = time;
        this.memory = memory;
    }

    @Override
    public String toString( ) {

        StringBuilder sb = new StringBuilder( );
        sb.append( this.operation != null ? this.operation : "<operation?>" );
        sb.append( " (" );
        sb.append( "# " + this.executionCount );
        sb.append( ", " + this.time + " ms" );
        if ( this.memory > Long.MIN_VALUE ) {
            sb.append( ", " + this.memory + " byte" );
        }
        sb.append( ")" );
        sb.append( " " + (double) this.time / (double) this.executionCount + " ms" );
        if ( this.memory > Long.MIN_VALUE ) {
            sb.append( ", " + (double) this.memory / (double) this.executionCount + " byte" );
        }
        return sb.toString( );
    }

    /**
     * @return the execution count
     */
    public int getExecutionCount( ) {

        return this.executionCount;
    }

    /**
     * @param executionCount the execution count
     */
    public void setExecutionCount( int executionCount ) {

        this.executionCount = executionCount;
    }

    /**
     * @return the memory
     */
    public long getMemory( ) {

        return this.memory;
    }

    /**
     * @param memory the memory
     */
    public void setMemory( long memory ) {

        this.memory = memory;
    }

    /**
     * @return the operation
     */
    public String getOperation( ) {

        return this.operation;
    }

    /**
     * @param operation the operation
     */
    public void setOperation( String operation ) {

        this.operation = operation;
    }

    /**
     * @return the execution time
     */
    public long getTime( ) {

        return this.time;
    }

    /**
     * @param time the execution time
     */
    public void setTime( long time ) {

        this.time = time;
    }

    /**
     * @param statistics the statistics to print
     * @param printStream the stream to print to
     */
    public static void print( Collection<OperationStatistics> statistics, PrintStream printStream ) {

        for ( OperationStatistics statistic : statistics ) {
            String output = statistic.toString( );
            printStream.println( output );
            printStream.flush( );
        }
    }

}
