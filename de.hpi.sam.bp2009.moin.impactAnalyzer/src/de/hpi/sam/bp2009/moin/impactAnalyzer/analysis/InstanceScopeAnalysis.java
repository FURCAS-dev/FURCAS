package de.hpi.sam.bp2009.moin.impactAnalyzer.analysis;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;

import com.sap.tc.moin.ocl.ia.cache.EventCache;
import com.sap.tc.moin.ocl.ia.events.DeleteET;
import com.sap.tc.moin.ocl.ia.events.DeleteRT;
import com.sap.tc.moin.ocl.ia.events.InsertET;
import com.sap.tc.moin.ocl.ia.events.InsertRT;
import com.sap.tc.moin.ocl.ia.events.InternalEvent;
import com.sap.tc.moin.ocl.ia.events.UpdateAttribute;
import com.sap.tc.moin.ocl.ia.expressions.DirectSubExpression;
import com.sap.tc.moin.ocl.ia.expressions.SubExpression;
import com.sap.tc.moin.ocl.ia.expressions.SubExpressionTW;
import com.sap.tc.moin.ocl.ia.relevance.Relevance;
import com.sap.tc.moin.ocl.ia.relevance.RelevanceFactory;
import com.sap.tc.moin.ocl.ia.tag.NodeTagFactory;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

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

    private final CoreConnection connection;

    /**
     * Creates a new instance of the InstanceScopeAnalysis algorithm.
     * 
     * @param theTagFactory the NodeTagFactory used to create the nodes which
     * were attached to the OCL AST during the Class Scope Analysis.
     * @param theEventCache the EventCache to store the result of this analysis
     * in
     * @param theJmiCreator the JmiCreator used to create OCL AST node
     */
    public InstanceScopeAnalysis( NodeTagFactory theTagFactory, EventCache theEventCache, MoinJmiCreator theJmiCreator ) {

        this.tagFactory = theTagFactory;
        this.cache = theEventCache;
        this.connection = theJmiCreator.getConnection( );
    }

    /**
     * Starts the instance scope analysis
     * 
     * @param stmt the OclStatement to analyze
     * @param jmiCreator the JmiCreator
     */
    public void analyze( OclStatement stmt, MoinJmiCreator jmiCreator ) {

        this.relFactory.reset( );
        // find sub-expressions in statement
        SubExpressionTW subExpTw = new SubExpressionTW( this.connection );
        this.subExprs = subExpTw.determineSubExpressions( stmt );

        // determine for each tuple (OclStatemnt, InternalEvent) the
        // corresponding navigation path
        for ( SubExpression subExp : this.subExprs ) {
            if ( subExp instanceof DirectSubExpression ) {
                subExp.identifyNavPaths( this.relFactory, this.tagFactory );
            } else {
                // if there is a indirect sub expression it is an orphan
                // i.e. something went wrong!
                throw new MoinLocalizedBaseRuntimeException( OclServiceExceptions.ORPHANSUBEXPRESSION );
            }
        }
        // Turn navigation paths into OCL and add them to the EventCache
        for ( Relevance relevance : this.relFactory.getRelevanceSet( ) ) {
            // get the context for the event
            Classifier context = getContext( relevance.getEvent( ) );
            // get the OclStatement which evaluates to the set instances
            Set<OclStatement> instances = relevance.turnIntoOcl( context, jmiCreator );
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
    private Classifier getContext( InternalEvent event ) {

        if ( event instanceof InsertET ) {
            InsertET iet = (InsertET) event;
            return iet.getMofClass( );
        } else if ( event instanceof DeleteET ) {
            DeleteET det = (DeleteET) event;
            return det.getMofClass( );
        } else if ( event instanceof InsertRT ) {
            InsertRT irt = (InsertRT) event;
            return ( (AssociationEndImpl) ( (AssociationEndImpl) irt.getAssociationEnd( ) ).otherEnd( this.connection ) ).getType( this.connection );
        } else if ( event instanceof DeleteRT ) {
            DeleteRT drt = (DeleteRT) event;
            return ( (AssociationEndImpl) ( (AssociationEndImpl) drt.getAssociationEnd( ) ).otherEnd( this.connection ) ).getType( this.connection );
        } else if ( event instanceof UpdateAttribute ) {
            UpdateAttribute updAttr = (UpdateAttribute) event;
            return updAttr.getClassifier( );
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
