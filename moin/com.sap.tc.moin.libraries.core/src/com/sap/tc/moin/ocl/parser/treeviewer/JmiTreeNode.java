package com.sap.tc.moin.ocl.parser.treeviewer;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.swing.tree.TreeNode;

import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * This class implements TreeNode so it can be used with JTree. Since we are
 * trying to view a JMI-graph the children are only created on demand so we
 * cannot run into cycles. It also saves time and memory.
 * 
 * @author Thomas Hettel
 */
public class JmiTreeNode implements TreeNode, Comparable<JmiTreeNode> {

    // use a vector because we need to enumeration in childen()
    private Vector<TreeNode> children = new Vector<TreeNode>( );

    private boolean initialized = false;

    private String name;

    private RefObject refObj;

    private TreeNode parent;

    private String text;

    private CoreConnection myConnection;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        if ( this.refObj == null ) {
            return this.name + ": " + this.text; //$NON-NLS-1$
        }
        String typeName = this.refObj.getClass( ).getName( );
        // we are not intereseted in the fully qualified name
        typeName = typeName.substring( typeName.lastIndexOf( '.' ) + 1 );
        return this.name + " [" + typeName + "]" + OclConstants.BRACKETLEFT + this.refObj.refMofId( ) + OclConstants.BRACKETRIGHT; //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * This constructor is used to create inner (i.e. non-leaf) nodes.
     * 
     * @param theRefObject the JMI-object which is represented by this node
     * @param attrName the name of the attribute of which this node represents
     * the value
     * @param theParent the parent node
     * @param theConnection the connection
     */
    public JmiTreeNode( RefObject theRefObject, String attrName, TreeNode theParent, CoreConnection theConnection ) {

        this.refObj = theRefObject;
        this.name = attrName;
        this.parent = theParent;
        this.myConnection = theConnection;
    }

    /**
     * This constuctor is used to create leaf nodes which represent "simple"
     * objects i.e. non-JMI-objects
     * 
     * @param theText text that should be shown
     * @param theName the name of the property this tree node represents
     * @param theParent the parent node
     * @param theConnection the connection
     */
    public JmiTreeNode( String theText, String theName, TreeNode theParent, CoreConnection theConnection ) {

        this.refObj = null;
        this.text = theText;
        this.name = theName;
        this.parent = theParent;
        this.myConnection = theConnection;
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.tree.TreeNode#children()
     */
    public Enumeration<TreeNode> children( ) {

        initialize( );
        return this.children.elements( );
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.tree.TreeNode#getAllowsChildren()
     */
    public boolean getAllowsChildren( ) {

        return false;
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.tree.TreeNode#getChildAt(int)
     */
    public TreeNode getChildAt( int childIndex ) {

        initialize( );
        return this.children.get( childIndex );
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.tree.TreeNode#getChildCount()
     */
    public int getChildCount( ) {

        initialize( );
        return this.children.size( );
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.tree.TreeNode#getIndex(javax.swing.tree.TreeNode)
     */
    public int getIndex( TreeNode node ) {

        initialize( );
        return this.children.indexOf( node );
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.tree.TreeNode#getParent()
     */
    public TreeNode getParent( ) {

        return this.parent;
    }

    /**
     * 
     */
    private void initialize( ) {

        // graphs can have cycles we are lazy and create children only on demand
        TreeSet<TreeNode> sortedChildren = new TreeSet<TreeNode>( );
        if ( this.initialized ) {
            return;
        }
        this.initialized = true;
        if ( this.refObj == null ) {
            return;
        }

        Class<? extends RefObject> refClass = this.refObj.getClass( );
        Method[] methods = refClass.getMethods( );
        /*
         * we are only interested in methods starting with 'get'
         */
        for ( int i = 0; i < methods.length; i++ ) {
            Method m = methods[i];
            if ( m.getName( ).startsWith( "get" ) && !m.getName( ).startsWith( "get_" ) && m.getParameterTypes( ).length == 0 ) { //$NON-NLS-1$ //$NON-NLS-2$

                if ( Collection.class.isAssignableFrom( m.getReturnType( ) ) ) {
                    // the method returns a collection
                    // add each element of the collection as a child
                    try {
                        Collection<Object> res = (Collection) m.invoke( this.refObj, new Object[] {} );
                        if ( res.isEmpty( ) ) {
                            sortedChildren.add( new JmiTreeNode( "[EMPTY]", m.getName( ).substring( 3 ), this, this.myConnection ) ); //$NON-NLS-1$
                        }
                        int count = 1;
                        for ( Iterator<Object> j = res.iterator( ); j.hasNext( ); count++ ) {
                            Object o = j.next( );
                            if ( o instanceof RefObject ) {
                                sortedChildren.add( new JmiTreeNode( (RefObject) o, m.getName( ).substring( 3 ) + OclConstants.BRACKETLEFT + count + OclConstants.BRACKETRIGHT, this, this.myConnection ) );
                            } else {
                                sortedChildren.add( new JmiTreeNode( o.toString( ), m.getName( ).substring( 3 ) + OclConstants.BRACKETLEFT + count + OclConstants.BRACKETRIGHT, this, this.myConnection ) );
                            }
                        }
                    } catch ( Exception e ) {
                        sortedChildren.add( new JmiTreeNode( "ERROR: " + e.getLocalizedMessage( ), m.getName( ).substring( 3 ), this, this.myConnection ) ); //$NON-NLS-1$
                    }
                } else if ( RefObject.class.isAssignableFrom( m.getReturnType( ) ) ) {
                    // the method returns a JMI class
                    try {
                        sortedChildren.add( new JmiTreeNode( (RefObject) m.invoke( this.refObj, new Object[] {} ), m.getName( ).substring( 3 ), this, this.myConnection ) );
                    } catch ( Exception e ) {
                        sortedChildren.add( new JmiTreeNode( "ERROR: " + e.getLocalizedMessage( ), m.getName( ).substring( 3 ), this, this.myConnection ) ); //$NON-NLS-1$
                        e.printStackTrace( );
                    }
                } else if ( Object[].class.isAssignableFrom( m.getReturnType( ) ) ) {
                    // the method returns an array of objects
                    try {
                        Object[] res = (Object[]) m.invoke( this.refObj, new Object[] {} );
                        sortedChildren.add( new JmiTreeNode( makeStringFromObjectArray( res ), m.getName( ).substring( 3 ), this, this.myConnection ) );
                    } catch ( Exception e ) {
                        sortedChildren.add( new JmiTreeNode( "ERROR: " + e.getLocalizedMessage( ), m.getName( ).substring( 3 ), this, this.myConnection ) ); //$NON-NLS-1$
                    }
                } else {
                    // the mehtod returns something else
                    // use the toString method to get information
                    try {
                        Object res = m.invoke( this.refObj, new Object[] {} );
                        if ( res == null ) {
                            res = OclConstants.EMPTY;
                        }
                        sortedChildren.add( new JmiTreeNode( res.toString( ), m.getName( ).substring( 3 ), this, this.myConnection ) );
                    } catch ( Exception e ) {
                        sortedChildren.add( new JmiTreeNode( "ERROR: " + e.getLocalizedMessage( ), m.getName( ).substring( 3 ), this, this.myConnection ) ); //$NON-NLS-1$
                    }
                }
            }
        }
        this.children.addAll( sortedChildren );
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.tree.TreeNode#isLeaf()
     */
    public boolean isLeaf( ) {

        initialize( );
        return this.children.size( ) == 0;
    }

    private String makeStringFromObjectArray( Object[] oa ) {

        StringBuffer buf = new StringBuffer( );
        if ( oa != null ) {
            for ( int i = 0; i < oa.length - 1; i++ ) {
                buf.append( oa[i].toString( ) );
                buf.append( OclConstants.PATHSEP );
            }
            buf.append( oa[oa.length - 1].toString( ) );
        }
        return buf.toString( );
    }

    /**
     * Return the name of the attribute for this subgraph. this method is used
     * for sorting.
     * 
     * @return the name of the attribute for this subgraph
     */
    public String getAttrName( ) {

        return this.name;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo( JmiTreeNode node ) {

        return this.name.compareTo( node.getAttrName( ) );
    }
}
