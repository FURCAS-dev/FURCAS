package com.sap.tc.moin.xm.kernel.impl.parser.sax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinIndexOutOfBoundsException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.parser.NodeType;


/**
 * Counter of the occurence of equal XML elements in a hierarchy level of an XML
 * document.
 * <p>
 * This implementation can treat the following XML document <br/>
 * &lt;root&gt; <br/>
 * &nbsp; &lt;a/&gt;<br/>
 * &nbsp; &lt;b/&gt; <br/>
 * &nbsp; &lt;a/&gt; <br/>
 * &lt;/root&gt;.<br>
 * For the second element <a/> the correct index 1 is calculated.
 */
final class IndexCounters {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, IndexCounters.class );

    /**
     * Each level contains a list of elements/attributes. Starts to count from
     * level 2. Level 1 is not contained! This does mean levels.get(0) delivers
     * the level 2.
     */
    private final List<Map<Counter, Counter>> levels = new ArrayList<Map<Counter, Counter>>( 100 );

    IndexCounters( ) {

    }

    /**
     * Called after an element/attribute is pushed.
     * 
     * @param prefix
     * @param localName
     * @param nodeType
     * @param level hierarchy level of the element/attribute, starts from 1
     */
    void afterPush( final String prefix, final String localName, final NodeType nodeType, final int level ) {

        if ( level > 1 ) {
            Map<Counter, Counter> counterList;
            final Counter newCounter = new Counter( localName, prefix, nodeType );
            if ( this.levels.size( ) < level - 1 ) {
                // For the requested level a map does not yet exist
                counterList = new HashMap<Counter, Counter>( );
                this.levels.add( counterList );
                counterList.put( newCounter, newCounter );
            } else {
                counterList = this.levels.get( level - 2 );
                final Counter counter = counterList.get( newCounter );
                if ( counter == null ) {
                    // not yet exiting--> add
                    counterList.put( newCounter, newCounter );
                } else {
                    // otherwise count
                    counter.count( );
                }
            }
        } else {
            // first level contains always only one object
        }
    }

    int getIndex( final int level, final String localName, final String prefix, final NodeType nodeType ) {

        if ( level > 1 ) {
            final Map<Counter, Counter> ac = this.levels.get( level - 2 );
            final Counter oldCounter = ac.get( new Counter( localName, prefix, nodeType ) );
            if ( oldCounter == null ) {
                LOGGER.trace( MoinSeverity.ERROR, SaxParserMessages.NODENOTEXISTINGINLEVEL, new Object[] { localName, prefix, level } );
                throw new MoinIllegalStateException( SaxParserMessages.NODENOTEXISTINGINLEVEL, new Object[] { localName, prefix, level } );
            }
            return oldCounter.index;
        } else if ( level == 1 ) {
            return 0;
        } else {
            LOGGER.trace( MoinSeverity.ERROR, SaxParserMessages.LEVELSMALLERTHANONE );
            throw new MoinIndexOutOfBoundsException( SaxParserMessages.LEVELSMALLERTHANONE );
        }
    }

    /**
     * Called before an element/attribute is popped.
     * 
     * @param prefix
     * @param localName
     * @param nodeType
     * @param level hierarchy level to which the element/attribute to be popped
     * belongs, starts from 1
     */
    void beforePop( final int level ) {

        if ( this.levels.size( ) > level - 1 ) {
            // fetch the element/attribute list of the level+1
            final Map<Counter, Counter> m = this.levels.get( level - 1 );
            // clear this map
            m.clear( );
        }
    }

    void reset( ) {

        this.levels.clear( );
    }

    /**
     * Counts the occurence of a XML element with a certain name and prefix in a
     * certain hierarchy level.
     */
    private static final class Counter {

        /** Index starts from 0. */
        private int index;

        private final String localName;

        private final String prefix;

        private final int hashCode;

        private final NodeType nodeType;

        Counter( final String lname, final String aPrefix, final NodeType aNodeType ) {

            this.localName = lname;
            this.prefix = aPrefix;
            this.nodeType = aNodeType;
            final int prime = 31;
            int result = 1;
            result = prime * result + localName.hashCode( );
            result = prime * result + nodeType.hashCode( );
            this.hashCode = prime * result + prefix.hashCode( );
        }

        @Override
        public int hashCode( ) {

            return this.hashCode;
        }

        @Override
        public boolean equals( final Object obj ) {

            if ( this == obj ) {
                return true;
            }
            if ( obj == null ) {
                return false;
            }
            if ( getClass( ) != obj.getClass( ) ) {
                return false;
            }
            final Counter other = (Counter) obj;
            if ( localName == null ) {
                if ( other.localName != null ) {
                    return false;
                }
            } else if ( !localName.equals( other.localName ) ) {
                return false;
            }
            if ( nodeType == null ) {
                if ( other.nodeType != null ) {
                    return false;
                }
            } else if ( !nodeType.equals( other.nodeType ) ) {
                return false;
            }
            if ( prefix == null ) {
                if ( other.prefix != null ) {
                    return false;
                }
            } else if ( !prefix.equals( other.prefix ) ) {
                return false;
            }
            return true;
        }

        void count( ) {

            index++;
        }
    }



}
