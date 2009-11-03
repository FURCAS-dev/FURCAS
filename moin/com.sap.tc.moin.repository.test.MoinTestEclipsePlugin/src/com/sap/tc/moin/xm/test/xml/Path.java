package com.sap.tc.moin.xm.test.xml;

import java.util.ArrayList;
import java.util.Map;

import com.sap.tc.moin.repository.xm.parser.NodeType;



/**
 * Path containing the path to a XML node (without index information). The path
 * is a list containing the namespace prefixes and the local names of the nodes.
 * Further, the path has a node type. It is assumed that, if you remove the last
 * added path part, that then you have a path for a node with node type
 * {@link NodeType#Element} (see method {@link #pop()).
 * <p>
 * The maximal allowed hierarchical depth is restricted.
 * <p>
 * Each importer instance has exactly one instance of this class.
 */
final class Path {

    private static final int MAX_DEPTH = 200;

    ArrayList<String> path;


    NodeType nodeType = NodeType.Element;

    /** Contains the current index of the n-th level. */
    int[] ndepth = new int[MAX_DEPTH];

    private String lastClosedName;

    private String lastClosedPrefix;

    private NodeType lastClosedNodeType;

    private Map<String, XmlAttribute> currentAttributes;


    /** Creates an XPath with node type "element". */
    Path( ) {

        path = new ArrayList<String>( 100 );
    }


    void push( String prefix, String lName, NodeType aNodeType ) {

        if ( ( this.getLevel( ) < MAX_DEPTH ) ) {
            if ( lName.equals( lastClosedName ) && prefix.equals( lastClosedPrefix ) && aNodeType.equals( lastClosedNodeType ) ) {
                ndepth[this.getLevel( )]++;
            } else if ( this.getLevel( ) != 0 ) {
                ndepth[this.getLevel( )] = 0;
            }
        }
        lastClosedName = null;
        lastClosedPrefix = null;
        lastClosedNodeType = null;

        path.add( prefix );
        path.add( lName );
        this.nodeType = aNodeType;
    }

    /** Sets the current attributes. */
    void setCurrentAttributes( Map<String, XmlAttribute> attrs ) {

        this.currentAttributes = attrs;
    }

    /** Returns the current attributes. */
    Map<String, XmlAttribute> getCurrentAttributes( ) {

        return this.currentAttributes;
    }

    /**
     * Pops the node. It is assumed that then the node type is
     * {@link NodeType#Element}.
     */
    void pop( ) {

        this.lastClosedName = path.remove( path.size( ) - 1 );
        this.lastClosedPrefix = path.remove( path.size( ) - 1 );
        this.lastClosedNodeType = this.nodeType;
        this.nodeType = NodeType.Element;
    }



    @Override
    public String toString( ) {

        return path.toString( );
    }



    public int getLevel( ) {

        return path.size( ) / 2;
    }


    public String getLastLocalName( ) {

        return this.path.get( path.size( ) - 1 );
    }

    public String getLastPrefix( ) {

        return this.get( this.path.size( ) - 2 );
    }

    public String get( int i ) {

        return (String) path.get( i );
    }

    public int size( ) {

        return path.size( );
    }

    public int getIndex( int level ) {

        if ( level < 1 || level > this.getLevel( ) ) {
            throw new IndexOutOfBoundsException( "The specified level " + level + " is not within the allowed range [1," + this.getLevel( ) + "]" );
        }
        return this.ndepth[level];
    }

    public int getLastIndex( ) {

        return ndepth[this.getLevel( )];
    }


    public NodeType getNodeType( ) {

        return this.nodeType;
    }
}
