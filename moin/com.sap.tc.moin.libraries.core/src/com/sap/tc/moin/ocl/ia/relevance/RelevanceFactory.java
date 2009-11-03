package com.sap.tc.moin.ocl.ia.relevance;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.ocl.ia.events.InternalEvent;
import com.sap.tc.moin.ocl.utils.OclStatement;

/**
 * @author Thomas Hettel (D039141) This class keeps track of relevances.
 */
public class RelevanceFactory {

    private static final class RelevanceImpl extends Relevance {

        /**
         * @param stmt {@link OclStatement}
         * @param event {@link InternalEvent}
         */
        public RelevanceImpl( OclStatement stmt, InternalEvent event ) {

            super( stmt, event );
        }

    }

    private Map<OclStatement, Map<InternalEvent, Relevance>> stmt2Events = new Hashtable<OclStatement, Map<InternalEvent, Relevance>>( );

    private final Set<Relevance> relevances = new HashSet<Relevance>( );

    /**
     * Returns the Relevance instance for a <tt>OclStatement</tt> and a
     * <tt>InternalEvent</tt>.
     * 
     * @param stmt The OclStatement
     * @param event the InternalEvent
     * @return the Relevance instance for <tt>stmt</tt> and <tt>event</tt>
     */
    public Relevance getRelevance( OclStatement stmt, InternalEvent event ) {

        Map<InternalEvent, Relevance> relevantEvents = this.stmt2Events.get( stmt );
        if ( relevantEvents == null ) {
            relevantEvents = new Hashtable<InternalEvent, Relevance>( );
            this.stmt2Events.put( stmt, relevantEvents );
        }
        Relevance r = relevantEvents.get( event );
        if ( r == null ) {
            r = new RelevanceImpl( stmt, event );
            this.relevances.add( r );
            relevantEvents.put( event, r );
        }
        return r;
    }

    /**
     * @return the set of Relevance instances
     */
    public Set<Relevance> getRelevanceSet( ) {

        return this.relevances;
    }

    /**
     * resets the factory
     */
    public void reset( ) {

        this.relevances.clear( );
        this.stmt2Events.clear( );
    }
}
