package de.hpi.sam.bp2009.moin.impactAnalyzer;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;


import de.hpi.sam.bp2009.moin.impactAnalyzer.analysis.ClassScopeAnalysis;
import de.hpi.sam.bp2009.moin.impactAnalyzer.analysis.InstanceScopeAnalysis;
import de.hpi.sam.bp2009.moin.impactAnalyzer.cache.EventCache;
import de.hpi.sam.bp2009.moin.impactAnalyzer.cache.EventCacheEntry;
import de.hpi.sam.bp2009.moin.impactAnalyzer.relevance.Relevance;
import de.hpi.sam.bp2009.moin.impactAnalyzer.result.EvaluationUnit;
import de.hpi.sam.bp2009.moin.impactAnalyzer.result.InstanceSet;
import de.hpi.sam.bp2009.moin.impactAnalyzer.result.impl.EvaluationUnitImpl;
import de.hpi.sam.bp2009.moin.impactAnalyzer.result.impl.InstanceSetImpl;
import de.hpi.sam.bp2009.moin.impactAnalyzer.tag.NodeTagFactory;
import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.LinkCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.LinkDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.NotFilter;
import de.hpi.sam.bp2009.solution.eventManager.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl;



/**
 * The Impact Analyzer (IA) analyzes the impact of {@link ModelChangeEvent}s on
 * a set of {@link OclStatement}s.
 * <p>
 * The interaction with IA happens in two steps. First call
 * {@link #analyze(Set, MoinJmiCreator)} with a set of {@link OclStatement}s.
 * This returns a {@link EventFilter} which can be used to register a listener
 * in the MOIN event framework. The subscriber will then be supplied with all
 * relevant {@link ModelChangeEvent}s relevant to the supplied set of
 * {@link OclStatement}s.
 * <p>
 * Once a relevant <code>ModelChangeEvent</code> occurs it can be passed to IA
 * by calling {@link #filter(CoreConnection, ModelChangeEvent)} which returns a
 * set of {@link EvaluationUnit}s These can be used to instruct the evaluator to
 * evaluate affected <code>OclStatements</code> for a certain set of instances.
 * <p>
 * The call to {@link #analyze(Set, MoinJmiCreator)} can take some time until it
 * returns. The time used depends on the number of <tt>OclStatements</tt>
 * supplied and on the complexity of each <code>OclStatements</code>, but this
 * method will typically be called only once.
 * <p>
 * Calling {@link #filter(CoreConnection, ModelChangeEvent)} or
 * {@link #filter(CoreConnection, Set)} is much faster and does not depend on
 * the number of <code>OclStatements</code> supplied to IA.
 */

public class ImpactAnalyzer {

//    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL_IA, ImpactAnalyzer.class );
    private final EventManagerFactory eventFactory;

    private final NodeTagFactory tagFactory = new NodeTagFactory( );

    private final EventCache eventCache = new EventCache( );

    /**
     * for testing only!
     */
    private final HashSet<Relevance> testingRevelanceSet = new HashSet<Relevance>( );

    /**
     * if set to true instance scope analysis is skipped
     */
    private final boolean doClassScopeOnly;

    /**
     * Creates a new Impact Analyzer instance.
     * 
     * @param classScopeOnly skips instance scope analysis if set to true
     */
    public ImpactAnalyzer( boolean classScopeOnly ) {

        this.doClassScopeOnly = classScopeOnly;
        this.eventFactory = EventManagerFactory.eINSTANCE;
    }

    /**
     * Analyzes a Set of <code>OclStatemtent</code>s and returns a
     * <code>MoinEventFilter</code> which can be used to register with the MOIN
     * Event Framework. The filter will match all events relevant to the
     * OclStatements passed to the ImpactAnalyzer.
     * <p>
     * The semantic of analyze is additive, that means that each call of
     * analyze() will add the passed <code>OclStatemtent</code> s to the
     * internal data structure. The returned filter will match all events
     * relevant to <b>all</b> <code>OclStatemtent</code>s in the internal data
     * structure. Use {@link #reset()} to reset the internal data structures.
     * 
     * @param oclStatements a Set of <code>OclStatemtent</code>s
     * @return a filter matching all events relevant to the
     * <code>OclStatemtent</code>s passed to the ImplactAnalyzer
     */
    public EventFilter createFilterForQuery(EList<Constraint> oclStatements) {

//        long cstime = 0l;
//        long istime = 0l;
//        long fctime = 0l;

        // analyze each OclStatement
        for ( Constraint stmt : oclStatements ) {
            // execute the Class Scope Analysis
          //  long start = System.nanoTime( );
            applyClassScopeAnalysis( stmt);
          //  cstime = cstime + System.nanoTime( ) - start;
            if ( !this.doClassScopeOnly ) {
                // execute the Instance Scope Analysis
              //  start = System.nanoTime( );
                applyInstanceScopeAnalysis( stmt);
              //  istime = istime + System.nanoTime( ) - start;
            }
        }
        // create the MoinEventFilter for the set of relevant InternalEvents
        Set<ModelChangeEvent> accumulatedEvents = this.eventCache.events( );

     //   long start = System.nanoTime( );
        EventFilter filter = this.createFilter( accumulatedEvents );
      //  fctime = System.nanoTime( ) - start;
        // milliseconds from nanoseconds
//
//        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
//
//            cstime = cstime / 1000000;
//            istime = istime / 1000000;
//            fctime = fctime / 1000000;
//
//            LOGGER.trace( MoinSeverity.DEBUG, ImpactAnalyzerTraces.ANALYZEOUTPUT, oclStatements.size( ), accumulatedEvents.size( ), cstime, istime, fctime );
//
//        }
        return filter;

    }

    /**
     * for testing only!
     * 
     * @return the set of InternalEvents
     */
    public Set<ModelChangeEvent> testingGetInternalEvents( ) {

        return this.eventCache.events( );
    }

    /**
     * for testing only!
     * 
     * @return the set of relevances identified by rintheim2
     */
    public HashSet<Relevance> testingGetRelevances( ) {

        return this.testingRevelanceSet;
    }

    /**
     * Returns the <code>EvaluationUnit</code>s for a given
     * {@link ModelChangeEvent}.
     * 
     * @param connection {@link CoreConnection}
     * @param event {@link ModelChangeEvent}
     * @return the {@link EvaluationUnit}s for this event
     */
    public Set<EvaluationUnit> filter( ModelChangeEvent event ) {

//        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
//            LOGGER.trace( MoinSeverity.DEBUG, ImpactAnalyzerTraces.FILTERSTART, event );
//        }

        Set<EvaluationUnit> evalSet = new HashSet<EvaluationUnit>( );
//        long starttime = System.nanoTime( );

            // map from MoinEvents to InternalEvents
        /*
         *  events don't have to be mapped any more
         */
        //     InternalEvent[] intEvents = this.eventFactory.createEvents( connection, event );
            // get the affected OclStatements
            // the cache stores tuple of (affectedStatement,
            // navigationStatement)
            // which are associated to an InternalEvent.
            // we have to bring that into the result structure

           
                // there is only one unit for each affected statement
                // we bring them together in a hash
                Map<Constraint, EvaluationUnitImpl> stmt2EvalUnit = new HashMap<Constraint, EvaluationUnitImpl>( );
                // go through all cache entries
                for ( EventCacheEntry cacheEntry : this.eventCache.lookup( event ) ) {
                    Constraint cacheStatement = cacheEntry.getStatement( );
                    EvaluationUnitImpl unit;
                    // create a new Unit or get an existing one
                    if ( stmt2EvalUnit.containsKey( cacheStatement ) ) {
                        unit = stmt2EvalUnit.get( cacheStatement );
                    } else {
                        unit = new EvaluationUnitImpl( cacheStatement );
                        stmt2EvalUnit.put( cacheStatement, unit );
                    }
                    // add a new instance set to it; the affected elements are determined from the element
                    for ( Constraint revPath : cacheEntry.getInstances( ) ) {
                        Set<EObject> startingPoints = this.eventFactory.getAffectedElements( event, (EClassifier) revPath.getConstrainedElements() );
                        if ( startingPoints != null ) {
                            InstanceSet is = new InstanceSetImpl( revPath, startingPoints );
                            unit.addInstanceSet( is );
                        }
                    }
                
                // return the set of EvaluationUnits with non-empty instance
                // sets
                for ( EvaluationUnit evalUnit : stmt2EvalUnit.values( ) ) {
                    if ( evalUnit.getInstanceSets( ).isEmpty( ) ) {
                        continue;
                    }
                    evalSet.add( evalUnit );
                }

            }
            return evalSet;
        
//          finally {
//            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
//                long duration = ( starttime - System.nanoTime( ) ) / 1000000;
//                LOGGER.trace( MoinSeverity.INFO, ImpactAnalyzerTraces.FILTEREND, duration, evalSet.size( ) );
//            }
//        }
    }

    /**
     * @param classFilter class filter
     * @return the Set of EvaluationUnits
     */
    public Set<EvaluationUnit> filterForClasses( Set<EventFilter> classFilter ) {

//        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
//            if ( classFilter != null ) {
//                LOGGER.trace( MoinSeverity.DEBUG, ImpactAnalyzerTraces.FILTERFORCLASSSTART, classFilter.size( ) );
//            } else {
//                LOGGER.trace( MoinSeverity.DEBUG, ImpactAnalyzerTraces.FILTERFORCLASSSTART, 0 );
//            }
//        }

//        long starttime = System.nanoTime( );
        // map from MoinEvents to InternalEvents
        Set<ModelChangeEvent> intEvents;
        if ( classFilter == null || classFilter.isEmpty( ) ) {
            intEvents = this.eventCache.events( );
        } else {
            intEvents = this.eventCache.events( classFilter );
        }

//        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
//            LOGGER.trace( MoinSeverity.DEBUG, ImpactAnalyzerTraces.FILTERFORCLASSEVENTS, intEvents.size( ) );
//        }
        // since we will not fill the starting points here, we have only one 
        // EvaluationUnit per affected statement
        Set<EvaluationUnit> units = new HashSet<EvaluationUnit>( );

        Map<Constraint, EvaluationUnitImpl> stmt2EvalUnit = new HashMap<Constraint, EvaluationUnitImpl>( );
        for ( ModelChangeEvent event : intEvents ) {
            // go through all cache entries
            for ( EventCacheEntry cacheEntry : this.eventCache.lookup( event ) ) {
                Constraint cacheStatement = cacheEntry.getStatement( );
                EvaluationUnitImpl unit;
                // create a new Unit or get an existing one
                if ( stmt2EvalUnit.containsKey( cacheStatement ) ) {
                    unit = stmt2EvalUnit.get( cacheStatement );
                } else {
                    unit = new EvaluationUnitImpl( cacheStatement );
                    stmt2EvalUnit.put( cacheStatement, unit );
                }
                // add a new instance sets to it
                for ( Constraint revPath : cacheEntry.getInstances( ) ) {
                    // we can't do instance scope here
                    Set<EObject> startingPoints = Collections.emptySet( );
                    InstanceSet is = new InstanceSetImpl( revPath, startingPoints );
                    unit.addInstanceSet( is );
                }
            }
        }
        units.addAll( stmt2EvalUnit.values( ) );

//        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
//            long duration = ( starttime - System.nanoTime( ) ) / 1000000;
//            if ( classFilter != null ) {
//                LOGGER.trace( MoinSeverity.INFO, ImpactAnalyzerTraces.FILTERFORCLASSEND, classFilter.size( ), duration, units.size( ) );
//            } else {
//                LOGGER.trace( MoinSeverity.INFO, ImpactAnalyzerTraces.FILTERFORCLASSEND, 0, duration, units.size( ) );
//            }
//        }
        return units;
    }

    /**
     * Returns the <code>EvaluationUnit</code>s affected by one of the events
     * provided.
     * 
     * @param modelChangeEvents the set of <code>ModelChangeEvent</code>s to
     * filter.
     * @return the <code>EvaluationUnit</code>s
     */
    public Set<EvaluationUnit> filter( Set<ModelChangeEvent> modelChangeEvents ) {

        if ( modelChangeEvents.size( ) == 1 ) {
            // we can save some overhead here
            return this.filter( modelChangeEvents.iterator( ).next( ) );
        }

//        long starttime = System.nanoTime( );
//
//        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
//            LOGGER.trace( MoinSeverity.DEBUG, ImpactAnalyzerTraces.FILTERMULTSTART, modelChangeEvents.size( ) );
//        }
        // condense the internal events (only one lookup in the event cache)
        // the ModelChangeEvents are needed later for getting the affected
        // instances
        Map<ModelChangeEvent, Set<ModelChangeEvent>> im = new HashMap<ModelChangeEvent, Set<ModelChangeEvent>>( );
        for ( ModelChangeEvent modelChangeEvent : modelChangeEvents ) {
        	ModelChangeEvent[] internalEvents = this.eventFactory.createEvents( modelChangeEvent );
            for ( int eventIndex = 0; eventIndex < internalEvents.length; eventIndex++ ) {
            	ModelChangeEvent internalEvent = internalEvents[eventIndex];
                if ( im.containsKey( internalEvent ) ) {
                    im.get( internalEvent ).add( modelChangeEvent );
                } else {
                    Set<ModelChangeEvent> s = new HashSet<ModelChangeEvent>( );
                    s.add( modelChangeEvent );
                    im.put( internalEvent, s );
                }
            }
        }
        // we need to have the mapping between the reverse navigation path and
        // the starting points per affected statement
        Map<Constraint, Map<Constraint, Set<EObject>>> expr = new HashMap<Constraint, Map<Constraint, Set<EObject>>>( );
        // For each internal event: get affected expressions
        for ( Map.Entry<ModelChangeEvent, Set<ModelChangeEvent>> me : im.entrySet( ) ) {
            for ( EventCacheEntry ece : this.eventCache.lookup( me.getKey( ) ) ) {
                Constraint cacheStatement = ece.getStatement( );
                Map<Constraint, Set<EObject>> elementsPerRevPath = expr.get( cacheStatement );
                if ( elementsPerRevPath == null ) {
                    elementsPerRevPath = new HashMap<Constraint, Set<EObject>>( );
                    expr.put( cacheStatement, elementsPerRevPath );
                }
                // For each affected expression: get event instances, collect
                // them in inst
                for ( Constraint revPath : ece.getInstances( ) ) {
                    Set<EObject> elements = elementsPerRevPath.get( revPath );
                    if ( elements == null ) {
                        elements = new HashSet<EObject>( );
                        elementsPerRevPath.put( revPath, elements );
                    }
                    for ( ModelChangeEvent mce : me.getValue( ) ) {
                        Set<EObject> s = this.eventFactory.getAffectedElements( mce, (EClassifier) revPath.getConstrainedElements() );
                        if ( s != null ) {
                            elements.addAll( s );
                        }
                    }
                }
            }
        }
        // Convert the structure we just built to an EvaluationSet
        Set<EvaluationUnit> result = new HashSet<EvaluationUnit>( );
        for ( Map.Entry<Constraint, Map<Constraint, Set<EObject>>> me : expr.entrySet( ) ) {
            EvaluationUnitImpl eu = new EvaluationUnitImpl( me.getKey( ) );
            for ( Map.Entry<Constraint, Set<EObject>> revPathEntry : me.getValue( ).entrySet( ) ) {
                InstanceSet newset = new InstanceSetImpl( revPathEntry.getKey( ), revPathEntry.getValue( ) );
                eu.addInstanceSet( newset );
            }
            result.add( eu );
        }

//        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
//            long duration = ( starttime - System.nanoTime( ) ) / 1000000;
//            LOGGER.trace( MoinSeverity.INFO, ImpactAnalyzerTraces.FILTERMULTEND, modelChangeEvents.size( ), duration, result.size( ) );
//        }
        return result;
    }

    /**
     * resets the internal state of the Impact Analysis
     */
    public void reset( ) {

        this.eventCache.reset( );
        this.eventFactory.reset( );
        this.tagFactory.reset( );
    }

    private void applyClassScopeAnalysis( Constraint stmt ) {

        ClassScopeAnalysis csa = new ClassScopeAnalysis( this.eventFactory, this.tagFactory, new HashSet<OCLExpression>( ) );
        // start the algorithm and get the relevant events
        //TODO check if cast is appropriate
        csa.analyze( (OCLExpression) stmt.getSpecification().getBodyExpression() );
    }

    private void applyInstanceScopeAnalysis( Constraint stmt ) {

        InstanceScopeAnalysis analysis = new InstanceScopeAnalysis( this.tagFactory, this.eventCache );
        analysis.analyze( stmt );
        // for testing we keep track of all relevances i.e. navigation paths
       // this.testingRevelanceSet.addAll( analysis.testingGetRelevances( ) );
    }

    /**
     * For a non-empty filter set <tt>ev</tt> merges those filters (combining them with a logical "or" operator)
     * and adds an {@link EventTypeFilter} for class <tt>filterClass</tt> using a logical "and" operator. The
     * resulting single combined event filter is added to <tt>mfs</tt>. Those filters from <tt>ev</tt> that
     * cannot be merged into the first element returned from <tt>ev</tt>'s iterator are added separately to
     * <tt>mfs</tt>, each <tt>and</tt>-ed with an {@link EventTypeFilter} for <tt>filterClass</tt>. This assumes
     * that <tt>mfs</tt> has "or" semantics.<p>
     * 
     * For an empty set <tt>ev</tt> this operation does nothing.
     */
    private void addTo( Set<EventFilter> mfs, Set<EventFilter> ev, EClass filterClass ) {

        if ( ev.isEmpty( ) ) {
            return;
        }

        Iterator<EventFilter> it = ev.iterator( );
        EventFilter firstFilter = it.next( );
        while ( it.hasNext( ) ) {
            EventFilter nextFilter = it.next( );
            if (!(nextFilter instanceof AndFilter) && !(nextFilter instanceof NotFilter)
		    && nextFilter.getClass().equals(firstFilter.getClass())) {
            	//TODO originally a merge
            	AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilter();
            	andFilter.getFilters().add(firstFilter);
            	andFilter.getFilters().add(nextFilter);
            	firstFilter = andFilter;
            } else {
        	// add instead of merge if filter types are different
            	EventTypeFilter eventFilter = EventManagerFactory.eINSTANCE.createEventTypeFilter();
            	eventFilter.setEventEClass(filterClass);
        	mfs.add(x_and(eventFilter, nextFilter));
            }
        }
        EventTypeFilter eventFilter = EventManagerFactory.eINSTANCE.createEventTypeFilter();
    	eventFilter.setEventEClass(filterClass);
        mfs.add( x_and( eventFilter , firstFilter ) );
    }

    /**
     * Creates a MoinEventFilter for a set of InternalEvents
     * 
     * @param coreConnection
     * @param internalEvents the InternalEvents to create the filter for
     * @return the <tt>MoinEventFilter</tt> corresponding to the set of
     * InternalEvents
     */
    private EventFilter createFilter( Set<ModelChangeEvent> internalEvents ) {

        if ( internalEvents == null || internalEvents.size( ) == 0 ) {
            /**
             * there's no way to return an "empty" filter, so return null if we
             * don't have to filter.
             */
            return null;
        }

        // Collect instance filters in various Sets, depending on event type

        Map<Class<? extends ModelChangeEvent>, Set<EventFilter>> filters = new HashMap<Class<? extends ModelChangeEvent>, Set<EventFilter>>( );
        filters.put( ElementCreateEvent.class, new HashSet<EventFilter>( ) );
        filters.put( ElementDeleteEvent.class, new HashSet<EventFilter>( ) );
        filters.put( LinkCreateEvent.class, new HashSet<EventFilter>( ) );
        filters.put( LinkDeleteEvent.class, new HashSet<EventFilter>( ) );
        filters.put( AttributeValueChangeEvent.class, new HashSet<EventFilter>( ) );

        for ( Iterator<ModelChangeEvent> it = internalEvents.iterator( ); it.hasNext( ); ) {
        	ModelChangeEvent ev = it.next( );
            Set<EventFilter> filter = filters.get( ev.getFilter() );
            filter.add( ev.getFilter( ) );
        }
        // Invariant: each filter from internalEvents is contained only in the set for *one* key in filters because each one has a single type

        // new we merge element deleted and element added where possible
        Set<EventFilter> elementCreatedFilters = filters.get( ElementCreateEvent.class );
        Set<EventFilter> elementDeletedFilters = filters.get( ElementDeleteEvent.class );

        // Add event type filters
        Set<EventFilter> mfs = new HashSet<EventFilter>( );
        addTo( mfs, elementCreatedFilters, EventManagerFactory.eINSTANCE.createElementCreateEvent().eClass() );
        addTo( mfs, elementDeletedFilters, EventManagerFactory.eINSTANCE.createElementDeleteEvent().eClass() );

        // now we merge link deleted and element added where possible
        Set<EventFilter> linkCreatedFilters = filters.get( LinkCreateEvent.class );
        Set<EventFilter> linkDeletedFilters = filters.get( LinkDeleteEvent.class );

        addTo( mfs, linkCreatedFilters, EventManagerFactory.eINSTANCE.createLinkCreateEvent().eClass() );
        addTo( mfs, linkDeletedFilters, EventManagerFactory.eINSTANCE.createLinkDeleteEvent().eClass() );
        addTo( mfs, filters.get( AttributeValueChangeEvent.class ), EventManagerFactory.eINSTANCE.createAttributeValueChangeEvent().eClass() );
        // Join them
        EventFilter flt = x_or( mfs );
        return flt;
    }

    private EventFilter x_and( EventFilter f1, EventFilter f2 ) {

    	AndFilter res = EventManagerFactory.eINSTANCE.createAndFilter();
    	res.getFilters().add(f1);
    	res.getFilters().add(f2);
        return res;
    }

    private EventFilter x_or( Set<EventFilter> f1 ) {

        if ( f1.size( ) == 1 ) {
            return f1.iterator( ).next( );
        }
        OrFilter res = EventManagerFactory.eINSTANCE.createOrFilter();
        res.getFilters().addAll(f1);
        return res;
    }

}