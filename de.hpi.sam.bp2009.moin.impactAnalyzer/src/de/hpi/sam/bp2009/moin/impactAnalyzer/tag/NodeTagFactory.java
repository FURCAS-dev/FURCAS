package de.hpi.sam.bp2009.moin.impactAnalyzer.tag;

import java.util.Hashtable;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * The NodeTagFactory keeps track of all NodeTags created and that there is at
 * most one NodeTag per OCL AST node.
 */
public class NodeTagFactory {

    private static final class NodeTagImpl extends NodeTag {

        /**
         * @param attachedTo the object to attach this
         */
        public NodeTagImpl( RefObject attachedTo ) {

            super( attachedTo );
        }

    }

    /**
     * This hash contains the mapping form nodes to tags
     */
    private Map<String, NodeTag> nodeToTagMapping = new Hashtable<String, NodeTag>( );

    /**
     * Creates a tag for an node or returns an existing tag.
     * 
     * @param node the node
     * @return the node tag
     */
    public NodeTag createTag( RefObject node ) {

        if ( this.nodeToTagMapping.containsKey( node.refMofId( ) ) ) {
            return this.nodeToTagMapping.get( node.refMofId( ) );
        }
        NodeTag tag = new NodeTagImpl( node );
        this.nodeToTagMapping.put( node.refMofId( ), tag );
        return tag;
    }

    /**
     * Returns the tag attached to node <tt>node</tt>, or <tt>null</tt> if there
     * is no tag attached.
     * 
     * @param node the node
     * @return the tag, or null
     */
    public NodeTag getTag( RefObject node ) {

        return this.nodeToTagMapping.get( node.refMofId( ) );
    }

    /**
     * @return Returns the expToTagMapping.
     */
    public Map<String, NodeTag> getNodeToTagMapping( ) {

        return this.nodeToTagMapping;
    }

    /**
     * resets the NodeTagFactory
     */
    public void reset( ) {

        this.nodeToTagMapping.clear( );
    }
}
