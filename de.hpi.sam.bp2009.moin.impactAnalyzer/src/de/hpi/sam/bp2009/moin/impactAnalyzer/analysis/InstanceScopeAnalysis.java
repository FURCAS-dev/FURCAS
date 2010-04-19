package de.hpi.sam.bp2009.moin.impactAnalyzer.analysis;

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.Constraint;

import de.hpi.sam.bp2009.moin.impactAnalyzer.cache.EventCache;
import de.hpi.sam.bp2009.moin.impactAnalyzer.expressions.DirectSubExpression;
import de.hpi.sam.bp2009.moin.impactAnalyzer.expressions.SubExpression;
import de.hpi.sam.bp2009.moin.impactAnalyzer.expressions.SubExpressionTW;
import de.hpi.sam.bp2009.moin.impactAnalyzer.relevance.Relevance;
import de.hpi.sam.bp2009.moin.impactAnalyzer.relevance.RelevanceFactory;
import de.hpi.sam.bp2009.moin.impactAnalyzer.tag.NodeTagFactory;
import de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.LinkCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.LinkDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

/**
 * This is the second stage of the analysis. It takes an attributed AST from the
 * Instance Scope Analysis. First all sub-expression of a statement are
 * determined, then navigation paths are identified and at last the EventCache
 * is updated.
 */
public class InstanceScopeAnalysis {

    private final NodeTagFactory tagFactory;

    private final RelevanceFactory relFactory = new RelevanceFactory( );

    private final EventCache cache;

    private Set<SubExpression> subExprs;

    /**
     * Creates a new instance of the InstanceScopeAnalysis algorithm.
     * 
     * @param theTagFactory the NodeTagFactory used to create the nodes which
     * were attached to the OCL AST during the Class Scope Analysis.
     * @param theEventCache the EventCache to store the result of this analysis
     * in
     * @param theJmiCreator the JmiCreator used to create OCL AST node
     */
    public InstanceScopeAnalysis( NodeTagFactory theTagFactory, EventCache theEventCache ) {

        this.tagFactory = theTagFactory;
        this.cache = theEventCache;
    }

    /**
     * Starts the instance scope analysis
     * 
     * @param stmt the OclStatement to analyze
     */
    public void analyze( Constraint stmt ) {

        this.relFactory.reset( );
        // find sub-expressions in statement
        SubExpressionTW subExpTw = new SubExpressionTW( );
        this.subExprs = subExpTw.determineSubExpressions( stmt );

        // determine for each tuple (OclStatemnt, InternalEvent) the
        // corresponding navigation path
        for ( SubExpression subExp : this.subExprs ) {
            if ( subExp instanceof DirectSubExpression ) {
                subExp.identifyNavPaths( this.relFactory, this.tagFactory );
            } else {
                // if there is a indirect sub expression it is an orphan
                // i.e. something went wrong!
                //throw new MoinLocalizedBaseRuntimeException( OclServiceExceptions.ORPHANSUBEXPRESSION );
            	// TODO think of meaningful error message
            	throw new RuntimeException();
            }
        }
        // Turn navigation paths into OCL and add them to the EventCache
        for ( Relevance relevance : this.relFactory.getRelevanceSet( ) ) {
            // get the context for the event
            EClassifier context = getContext( relevance.getEvent( ) );
            // get the OclStatement which evaluates to the set instances
            Set<Constraint> instances = relevance.turnIntoOcl( context );
            // update the cache
            this.cache.add( relevance.getStmt( ), relevance.getEvent( ), instances );
        }
    }

    /**
     * Returns the context classifier for an event which is used as context for
     * computing the reverse navigation path to get the affected instances.
     * 
     * @param event the InternalEvent to get a suiable context classifier for.
     * @return the context or null
     */
    private EClassifier getContext( ModelChangeEvent event ) {

        if ( event instanceof ElementCreateEvent ) {
        	ElementCreateEvent iet = (ElementCreateEvent) event;
            return iet.eClass();
        } else if ( event instanceof ElementDeleteEvent ) {
        	ElementDeleteEvent det = (ElementDeleteEvent) event;
            return det.eClass( );
        } else if ( event instanceof LinkCreateEvent ) {
        	LinkCreateEvent irt = (LinkCreateEvent) event;
            return irt.getChangedReference().getEType( );
        } else if ( event instanceof LinkDeleteEvent ) {
        	LinkDeleteEvent drt = (LinkDeleteEvent) event;
            return drt.getChangedReference().getEType();
        } else if ( event instanceof AttributeValueChangeEvent ) {
        	AttributeValueChangeEvent updAttr = (AttributeValueChangeEvent) event;
            return updAttr.getChangedAttribute().getEType();
        } else {
            return null;
        }
    }

    /**
     * for testing only!
     * 
     * @return The set of Relevances
     */
    public Set<Relevance> testingGetRelevances( ) {

        return this.relFactory.getRelevanceSet( );
    }

    /**
     * for testing only!
     * 
     * @return The set of sub expressions
     */
    public Set<SubExpression> testingGetSubExpressions( ) {

        return this.subExprs;
    }

}
