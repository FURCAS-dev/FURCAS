package de.hpi.sam.bp2009.moin.impactAnalyzer.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;

import com.sap.tc.moin.ocl.ia.events.InternalEvent;
import com.sap.tc.moin.ocl.utils.OclStatement;

/**
 * This is the internal data structure of the ImpactAnalyzer. It stores triples of OclStatement, InternalEvent and an
 * OCL description of how to compute instances. The first two parts of the triple uniquely identify the last part.
 * <p>
 * Internally it keeps a Hashtable of Hashetables so information can be accessed quickly.
 * 
 * @author Harald Fuchs
 */
public class EventCache {

    /**
     * Maps InternalEvent to Set<EventCacheEntry>
     */
    private final Map<InternalEvent, Map<OclStatement, EventCacheEntry>> ht = new HashMap<InternalEvent, Map<OclStatement, EventCacheEntry>>( );

    private final Map<Classifier, Set<InternalEvent>> classifierEventmapping = new HashMap<Classifier, Set<InternalEvent>>( );

    /**
     * creates a new EventCache
     */
    public EventCache( ) {

        // nothing in particular
    }

    /**
     * Adds a new triple to the cache.
     * 
     * @param stmt the OclStatement
     * @param ev the InternalEvent relevant to stmt
     * @param inst a Collection of OclStatements which evaluate to the set of
     * instances for which stmt has to be re-evaluated.
     */
    public void add( OclStatement stmt, InternalEvent ev, Set<OclStatement> inst ) {

        if ( !this.ht.containsKey( ev ) ) {
            this.ht.put( ev, new Hashtable<OclStatement, EventCacheEntry>( ) );
        }
        this.ht.get( ev ).put( stmt, new EventCacheEntry( stmt, inst ) );
        if ( !this.classifierEventmapping.isEmpty( ) ) {
            Set<InternalEvent> events = this.classifierEventmapping.get( ev.getClassifier( ) );
            if ( events == null ) {
                events = new HashSet<InternalEvent>( );
                this.classifierEventmapping.put( ev.getClassifier( ), events );
            }
            events.add( ev );
        }
    }

    /**
     * @return the set of InternalEvents stored in the cache.
     */
    public Set<InternalEvent> events( ) {

        return this.ht.keySet( );
    }

    /**
     * @param classFilter class filter
     * @return the events relevant for one of the classifiers
     */
    public Set<InternalEvent> events( Set<Classifier> classFilter ) {

        Set<InternalEvent> result = new HashSet<InternalEvent>( );
        if ( this.classifierEventmapping.isEmpty( ) ) {
            // build the index
            for ( InternalEvent event : this.events( ) ) {
                Classifier classifier = event.getClassifier( );
                if ( classFilter.contains( classifier ) ) {
                    result.add( event );
                }
                if ( this.classifierEventmapping.containsKey( event.getClassifier( ) ) ) {
                    this.classifierEventmapping.get( classifier ).add( event );
                } else {
                    Set<InternalEvent> events = new HashSet<InternalEvent>( );
                    events.add( event );
                    this.classifierEventmapping.put( classifier, events );
                }
            }
        } else {
            for ( Classifier classifier : classFilter ) {
                Set<InternalEvent> events = this.classifierEventmapping.get( classifier );
                if ( events != null ) {
                    result.addAll( events );
                }
            }
        }
        return result;
    }

    /**
     * Returns the Set of CacheEntries for an InternalEvent <tt>ev</tt>
     * 
     * @param ev the InternalEvent to lookup
     * @return the Set of CacheEntries for an InternalEvent <tt>ev</tt>
     */
    public Collection<EventCacheEntry> lookup( InternalEvent ev ) {

        if ( this.ht.containsKey( ev ) ) {
            return this.ht.get( ev ).values( );
        }
        return new HashSet<EventCacheEntry>( );
    }

    /**
     * Clears the cache
     */
    public void reset( ) {

        this.ht.clear( );
        this.classifierEventmapping.clear( );
    }
}
