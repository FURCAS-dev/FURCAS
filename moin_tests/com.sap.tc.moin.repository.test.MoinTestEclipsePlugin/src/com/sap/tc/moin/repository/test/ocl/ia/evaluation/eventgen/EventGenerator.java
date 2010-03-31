package com.sap.tc.moin.repository.test.ocl.ia.evaluation.eventgen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;

/**
 * This concrete subclasses of this class provide ModelChangeEvents for the
 * IAEvaluation class. Once initialized the EventGenerator makes a set of
 * ModelChangeEvents available via the <tt>getNextEvent()</tt> method.
 */
public abstract class EventGenerator {

    protected ModelPackage mof;



    /**
     * the list of events
     */
    private final List<ModelChangeEvent> events = new ArrayList<ModelChangeEvent>( );

    /**
     * the iterator used to iterate over the list of events
     */
    private Iterator<ModelChangeEvent> eventsIterator;

    /**
     * @param mp
     */
    public EventGenerator( ModelPackage mp ) {

        super( );
        this.mof = mp;
    }

    /**
     * initializes the EventGenerator and calls <tt>generateEvents()</tt>
     * which has to be implemented by subclasses.
     * 
     * @throws Exception
     */
    public void initialize( CoreConnection connection ) throws Exception {

        this.events.addAll( generateEvents( connection ) );
        this.eventsIterator = this.events.iterator( );
    }

    /**
     * @return true iff there are more events
     */
    public boolean hasMoreEvents( ) {

        return this.eventsIterator.hasNext( );
    }

    /**
     * @return the next event
     */
    public ModelChangeEvent getNextEvent( ) {

        return this.eventsIterator.next( );
    }

    /**
     * resets the EventGenerator to point to the first event in its list. the
     * next call to <tt>getNextEvent()</tt> will return the first event in the
     * list.
     */
    public void reset( ) {

        this.eventsIterator = this.events.iterator( );
    }

    /**
     * This method has to be implemented by subclasses.
     * 
     * @return the list of events.
     * @throws Exception
     */
    protected abstract List<ModelChangeEvent> generateEvents( CoreConnection connection ) throws Exception;

    /**
     * @return the number of events
     */
    public int getSize( ) {

        return this.events.size( );
    }
}
