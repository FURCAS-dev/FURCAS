package de.hpi.sam.bp2009.moin.impactAnalyzer.tag;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;


/**
 * NodeTags are used to attribute OCL AST with further information gathered in the ClassScopeAnalysis and the
 * InstanceScopeAnalysis. Each NodeTag can only be attached to exactly one OCL AST node. And each OCL AST node is only
 * allowed have at most one NodeTag.
 * <p>
 * Instances of this class can only be optained by using the NodeTagFactory.
 * 
 * @author Thomas Hettel (D039141)
 */
public abstract class NodeTag {

    private final Set<ModelChangeEvent> accumulatedEvents = new HashSet<ModelChangeEvent>( );

    private final EObject attachedTo;

    private final Set<ModelChangeEvent> relevantEvents = new HashSet<ModelChangeEvent>( );

    private boolean visited = false;

    /**
     * Creates a new NodeTag.
     * 
     * @param theObject the OCL AST node to which this tag is to be attached to
     */
    public NodeTag( EObject theObject ) {

        this.attachedTo = theObject;
    }

    /**
     * @return Returns the set of accumulated InternalEvents.
     */
    public Set<ModelChangeEvent> getAccumulatedEvents( ) {

        return this.accumulatedEvents;
    }

    /**
     * @return Returns the OCL AST node to which this tag is attached to.
     */
    public EObject getAttachedTo( ) {

        return this.attachedTo;
    }

    /**
     * @return Returns the set of relevant InternalEvents for the node to which this tag is attached to.
     */
    public Set<ModelChangeEvent> getEvents( ) {

        return this.relevantEvents;
    }

    /**
     * @return Returns <tt>true</tt> iff the node to which this tag is attached to has already been visited.
     */
    public boolean isVisited( ) {

        return this.visited;
    }

    /**
     * marks this tag as visited
     */
    public void setVisited( ) {

        this.visited = true;
    }
}