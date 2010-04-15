package de.hpi.sam.bp2009.moin.impactAnalyzer.tag;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.ia.events.InternalEvent;

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

    private final Set<InternalEvent> accumulatedEvents = new HashSet<InternalEvent>( );

    private final RefObject attachedTo;

    private final Set<InternalEvent> relevantEvents = new HashSet<InternalEvent>( );

    private boolean visited = false;

    /**
     * Creates a new NodeTag.
     * 
     * @param theObject the OCL AST node to which this tag is to be attached to
     */
    public NodeTag( RefObject theObject ) {

        this.attachedTo = theObject;
    }

    /**
     * @return Returns the set of accumulated InternalEvents.
     */
    public Set<InternalEvent> getAccumulatedEvents( ) {

        return this.accumulatedEvents;
    }

    /**
     * @return Returns the OCL AST node to which this tag is attached to.
     */
    public RefObject getAttachedTo( ) {

        return this.attachedTo;
    }

    /**
     * @return Returns the set of relevant InternalEvents for the node to which this tag is attached to.
     */
    public Set<InternalEvent> getEvents( ) {

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