package de.hpi.sam.bp2009.moin.impactAnalyzer.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.ecore.Constraint;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

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
    private final Map<ModelChangeEvent, Map<Constraint, EventCacheEntry>> ht = new HashMap<ModelChangeEvent, Map<Constraint, EventCacheEntry>>( );

    private final Map<EventFilter, Set<ModelChangeEvent>> classifierEventmapping = new HashMap<EventFilter, Set<ModelChangeEvent>>( );

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
    public void add( Constraint stmt, ModelChangeEvent ev, Set<Constraint> inst ) {

        if ( !this.ht.containsKey( ev ) ) {
            this.ht.put( ev, new Hashtable<Constraint, EventCacheEntry>( ) );
        }
        this.ht.get( ev ).put( stmt, new EventCacheEntry( stmt, inst ) );
        if ( !this.classifierEventmapping.isEmpty( ) ) {
             Set<ModelChangeEvent> events = this.classifierEventmapping.get( ev.getFilter() );
            if ( events == null ) {
                events = new HashSet<ModelChangeEvent>( );
                this.classifierEventmapping.put( ev.getFilter(), events );
            }
            events.add( ev );
        }
    }

    /**
     * @return the set of InternalEvents stored in the cache.
     */
    public Set<ModelChangeEvent> events( ) {

        return this.ht.keySet( );
    }

    /**
     * @param classFilter class filter
     * @return the events relevant for one of the classifiers
     */
    public Set<ModelChangeEvent> events( Set<EventFilter> classFilter ) {

        Set<ModelChangeEvent> result = new HashSet<ModelChangeEvent>( );
        if ( this.classifierEventmapping.isEmpty( ) ) {
            // build the index
            for ( ModelChangeEvent event : this.events( ) ) {
            	EventFilter classifier = event.getFilter();
                if ( classFilter.contains( classifier ) ) {
                    result.add( event );
                }
                if ( this.classifierEventmapping.containsKey( event.getFilter() ) ) {
                    this.classifierEventmapping.get( classifier ).add( event );
                } else {
                    Set<ModelChangeEvent> events = new HashSet<ModelChangeEvent>( );
                    events.add( event );
                    this.classifierEventmapping.put( classifier, events );
                }
            }
        } else {
            for ( EventFilter classifier : classFilter ) {
                Set<ModelChangeEvent> events = this.classifierEventmapping.get( classifier );
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
    public Collection<EventCacheEntry> lookup( ModelChangeEvent ev ) {

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
