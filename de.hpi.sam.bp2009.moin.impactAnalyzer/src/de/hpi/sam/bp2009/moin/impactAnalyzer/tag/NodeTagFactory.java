package de.hpi.sam.bp2009.moin.impactAnalyzer.tag;

import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;

/**
 * The NodeTagFactory keeps track of all NodeTags created and that there is at
 * most one NodeTag per OCL AST node.
 */
public class NodeTagFactory {

    private static final class NodeTagImpl extends NodeTag {

        /**
         * @param attachedTo the object to attach this
         */
        public NodeTagImpl( EObject attachedTo ) {

            super( attachedTo );
        }

    }

    /**
     * This hash contains the mapping form nodes to tags
     */
    private Map<EObject, NodeTag> nodeToTagMapping = new Hashtable<EObject, NodeTag>( );

    /**
     * Creates a tag for an node or returns an existing tag.
     * 
     * @param node the node
     * @return the node tag
     */
    public NodeTag createTag( EObject node ) {
    	
        if ( this.nodeToTagMapping.containsKey( node ) ) {
            return this.nodeToTagMapping.get( node );
        }
        NodeTag tag = new NodeTagImpl( node );
        this.nodeToTagMapping.put( node , tag );
        return tag;
    }

    /**
     * Returns the tag attached to node <tt>node</tt>, or <tt>null</tt> if there
     * is no tag attached.
     * 
     * @param node the node
     * @return the tag, or null
     */
    public NodeTag getTag( EObject node ) {

        return this.nodeToTagMapping.get( node );
    }

    /**
     * @return Returns the expToTagMapping.
     */
    public Map<EObject, NodeTag> getNodeToTagMapping( ) {

        return this.nodeToTagMapping;
    }

    /**
     * resets the NodeTagFactory
     */
    public void reset( ) {

        this.nodeToTagMapping.clear( );
    }
}
