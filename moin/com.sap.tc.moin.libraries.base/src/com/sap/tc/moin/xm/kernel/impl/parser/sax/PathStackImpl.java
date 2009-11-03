package com.sap.tc.moin.xm.kernel.impl.parser.sax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.exception.MoinIndexOutOfBoundsException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.parser.ComplexTypeHandler;
import com.sap.tc.moin.repository.xm.parser.NodeType;
import com.sap.tc.moin.repository.xm.parser.PModelElementHandle;
import com.sap.tc.moin.repository.xm.parser.PathStack;



/**
 * Path containing the path to an XML node (without index information). The path
 * is a list containing the namespace prefixes and the local names of the nodes.
 * Additionally, the path has a node type. It is assumed that, if you remove the
 * last added path part, that then you have a path for a node with node type
 * {@link NodeType#Element} (see method {@link #pop()).
 * <p>
 * Each importer instance has exactly one instance of this class.
 */
public final class PathStackImpl extends PathStack {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, PathStackImpl.class );

    private final ArrayList<Entry> stack = new ArrayList<Entry>( 100 );

    private NodeType nodeType = NodeType.Element;

    /*
     * Attention differ between the size of the stack array list and the stack
     * size. The stack array list size can be greater than the stack size,
     * because we reuse entries.
     */
    private int stackSize = 0;

    private final IndexCounters indexCounters = new IndexCounters( );

    /** Creates an XPath with node type "element". */
    public PathStackImpl( ) {

        super( );
    }

    @Override
    public void push( final String lName, final String prefix, final NodeType aNodeType ) {


        if ( aNodeType == null ) {
            throw new MoinNullPointerException( "aNodeType" ); //$NON-NLS-1$
        }
        if ( this.stack.size( ) > stackSize ) {
            // reuse already created entry
            final Entry entry = this.stack.get( stackSize );
            entry.setLocalName( lName );
            entry.setPrefix( prefix );
        } else {
            this.stack.add( new Entry( lName, prefix ) );
        }
        this.stackSize++;
        this.nodeType = aNodeType;
        this.indexCounters.afterPush( prefix, lName, this.nodeType, this.stackSize );
    }

    /**
     * Pops the node. It is assumed that then the node type is
     * {@link NodeType#Element}.
     */
    @Override
    public void pop( ) {

        this.indexCounters.beforePop( this.stackSize );
        stackSize--;
        /// fetch popped entry and reset the entry
        this.stack.get( stackSize ).reset( );
        this.nodeType = NodeType.Element;
    }

    @Override
    public String toString( ) {

        return this.getUniquePath( );
    }


    @Override
    public String getCurrentLocalName( ) {

        return this.getCurrentStackEntry( ).getLocalName( );
    }

    @Override
    public String getCurrentPrefix( ) {

        return this.getCurrentStackEntry( ).getPrefix( );
    }


    @Override
    public int size( ) {

        return this.stackSize;
    }

    @Override
    public String getLocalName( final int depth ) {

        return this.getStackEntry( depth ).getLocalName( );
    }


    @Override
    public String getPrefix( final int depth ) {

        return this.getStackEntry( depth ).getPrefix( );
    }

    @Override
    public int getIndex( final int depth ) {

        this.checkDepth( depth );
        return this.indexCounters.getIndex( stackSize + 1 - depth, this.getLocalName( depth ), this.getPrefix( depth ), nodeType );
    }

    @Override
    public int getCurrentIndex( ) {

        return this.indexCounters.getIndex( stackSize, this.getCurrentLocalName( ), this.getCurrentPrefix( ), this.getNodeType( ) );
    }


    @Override
    public NodeType getNodeType( ) {

        return this.nodeType;
    }


    @Override
    public String getUniquePath( ) {

        final StringBuilder buf = new StringBuilder( "/" ); //$NON-NLS-1$
        for ( int i = 0; i < this.stackSize - 1; i++ ) {
            final String prefix = stack.get( i ).getPrefix( );
            final String lName = stack.get( i ).getLocalName( );
            if ( prefix.length( ) == 0 ) {
                // do nothing
            } else {
                buf.append( prefix );
                buf.append( ':' );
            }
            buf.append( lName );
            final int index = this.indexCounters.getIndex( i + 1, lName, prefix, NodeType.Element );
            if ( index > 0 ) {
                buf.append( '[' ).append( index ).append( ']' );
            }
            buf.append( '/' );
        }
        // last part
        final String prefix = stack.get( stackSize - 1 ).getPrefix( );
        final String lName = stack.get( stackSize - 1 ).getLocalName( );
        if ( prefix.length( ) == 0 ) {
            // do nothing
        } else {
            buf.append( prefix );
            buf.append( ':' );
        }
        if ( NodeType.Attribute.equals( this.nodeType ) ) {
            buf.append( '@' );
        }
        buf.append( lName );
        final int index = this.indexCounters.getIndex( stackSize, lName, prefix, this.nodeType );
        if ( index > 0 ) {
            buf.append( '[' ).append( index ).append( ']' );
        }
        return buf.toString( );
    }


    @Override
    protected void putHandler( final ComplexTypeHandler handler ) {

        this.getCurrentStackEntry( ).setHandler( handler );
    }


    @Override
    protected ComplexTypeHandler getHandler( ) {

        return this.getCurrentStackEntry( ).getHandler( );
    }


    @Override
    protected ComplexTypeHandler getHandler( final int depth ) {

        return this.getStackEntry( depth ).getHandler( );
    }

    @Override
    public void putModelElement( final int currentDepth, final String key, final PModelElementHandle value ) {

        if ( key == null ) {
            throw new MoinNullPointerException( "key" ); //$NON-NLS-1$
        }
        if ( value == null ) {
            throw new MoinNullPointerException( "value" ); //$NON-NLS-1$
        }
        this.getStackEntry( currentDepth ).getKey2ModelElementMap( ).put( key, value );
    }

    private void checkDepth( final int depth ) {

        if ( depth < 1 || depth > stackSize ) {
            LOGGER.trace( MoinSeverity.ERROR, SaxParserMessages.NOTWITHINALLOWEDRANGE, depth, stackSize );
            throw new MoinIndexOutOfBoundsException( SaxParserMessages.NOTWITHINALLOWEDRANGE, depth, stackSize );
        }
    }

    private Entry getStackEntry( final int depth ) {

        this.checkDepth( depth );

        return this.stack.get( stackSize - depth );
    }

    private Entry getCurrentStackEntry( ) {

        return this.getStackEntry( 1 );
    }


    @Override
    public PModelElementHandle getModelElement( final int currentDepth, final String key ) {

        if ( key == null ) {
            throw new MoinNullPointerException( "key" ); //$NON-NLS-1$
        }
        return this.getStackEntry( currentDepth ).getKey2ModelElementMap( ).get( key );
    }



    @Override
    public void putModelElement( final String key, final PModelElementHandle value ) {

        if ( key == null ) {
            throw new MoinNullPointerException( "key" ); //$NON-NLS-1$
        }
        if ( value == null ) {
            throw new MoinNullPointerException( "value" ); //$NON-NLS-1$
        }
        this.getCurrentStackEntry( ).getKey2ModelElementMap( ).put( key, value );
    }

    @Override
    public PModelElementHandle getModelElement( final String key ) {

        if ( key == null ) {
            throw new MoinNullPointerException( "key" ); //$NON-NLS-1$
        }
        return this.getCurrentStackEntry( ).getKey2ModelElementMap( ).get( key );
    }


    @Override
    public void putProperty( final int currentDepth, final String key, final String value ) {

        if ( key == null ) {
            throw new MoinNullPointerException( "key" ); //$NON-NLS-1$
        }
        if ( value == null ) {
            throw new MoinNullPointerException( "value" ); //$NON-NLS-1$
        }
        this.getStackEntry( currentDepth ).getPropertyMap( ).put( key, value );
    }


    @Override
    public String getProperty( final int currentDepth, final String key ) {

        if ( key == null ) {
            throw new MoinNullPointerException( "key" ); //$NON-NLS-1$
        }
        return this.getStackEntry( currentDepth ).getPropertyMap( ).get( key );
    }


    @Override
    public void putProperty( final String key, final String value ) {

        if ( key == null ) {
            throw new MoinNullPointerException( "key" ); //$NON-NLS-1$
        }
        if ( value == null ) {
            throw new MoinNullPointerException( "value" ); //$NON-NLS-1$
        }
        this.getCurrentStackEntry( ).getPropertyMap( ).put( key, value );
    }


    @Override
    public String getProperty( final String key ) {

        if ( key == null ) {
            throw new MoinNullPointerException( "key" ); //$NON-NLS-1$
        }
        return this.getCurrentStackEntry( ).getPropertyMap( ).get( key );

    }



    public void reset( ) {

        for ( final Entry entry : this.stack ) {
            entry.reset( );
        }
        this.stackSize = 0;
        this.indexCounters.reset( );
    }

    private static final class Entry {

        /* Local element name. */
        private String localName;

        /* prefix of the element. */
        private String prefix;

        private final Map<String, String> propertyMap = new HashMap<String, String>( 1 );

        private final Map<String, PModelElementHandle> key2ModelElement = new HashMap<String, PModelElementHandle>( 1 );

        private ComplexTypeHandler handler;



        Entry( final String aLocalName, final String aPrefix ) {

            if ( aLocalName == null ) {
                throw new MoinNullPointerException( "aLocalName" ); //$NON-NLS-1$
            }
            if ( aPrefix == null ) {
                throw new MoinNullPointerException( "aPrefix" ); //$NON-NLS-1$
            }
            this.localName = aLocalName;
            this.prefix = aPrefix;
        }

        void setLocalName( final String aLocalName ) {

            if ( aLocalName == null ) {
                throw new MoinNullPointerException( "aLocalName" ); //$NON-NLS-1$
            }
            this.localName = aLocalName;
        }

        void setPrefix( final String aPrefix ) {

            if ( aPrefix == null ) {
                throw new MoinNullPointerException( "aPrefix" ); //$NON-NLS-1$
            }
            this.prefix = aPrefix;
        }


        /** Returns the local name, cannot be <code>null</code>. */
        String getLocalName( ) {

            return this.localName;
        }

        /** Returns the prefix, cannot be <code>null</code>. */
        String getPrefix( ) {

            return this.prefix;
        }

        /** Returned map cannot be <code>null</code>. */
        Map<String, String> getPropertyMap( ) {

            return this.propertyMap;
        }

        /** Returned map cannot be <code>null</code>. */
        Map<String, PModelElementHandle> getKey2ModelElementMap( ) {

            return this.key2ModelElement;
        }

        /** Returns a handler, can be <code>null</code>. */
        ComplexTypeHandler getHandler( ) {

            return handler;
        }


        void setHandler( final ComplexTypeHandler handler ) {

            this.handler = handler;
        }



        void reset( ) {

            this.localName = null;
            this.prefix = null;
            this.handler = null;
            this.key2ModelElement.clear( );
            this.propertyMap.clear( );
        }

    }
}
