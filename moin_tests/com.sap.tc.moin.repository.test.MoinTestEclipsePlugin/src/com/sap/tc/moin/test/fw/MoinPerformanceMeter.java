package com.sap.tc.moin.test.fw;

/**
 * Internal wrapper for the EclipsePerformanceMeter. A PerformanceMeter monitors
 * performance counters across a single piece of code. Piece of code identified
 * by 'scenario name'. Performance counters are called 'dimensions'. Default
 * dimensions provided by OS: Elapsed time, kernel/user time, memory
 * consumption, VM characteristics, I/O (bytes read, written). Multiple calls to
 * start()/stop() are averaged, commit() prints collected data.
 * 
 * @author D036732
 */
public interface MoinPerformanceMeter {

    public void start( );

    public void stop( );

    public void commit( );

    public void dispose( );

    public void assertPerformance( );

    public void tagAsGlobalSummaryForMemoryConsumption( String header );

    public void tagAsGlobalSummaryForCPUTime( String header );

    public void tagAsGlobalSummaryForElapsedTime( String header );
}
