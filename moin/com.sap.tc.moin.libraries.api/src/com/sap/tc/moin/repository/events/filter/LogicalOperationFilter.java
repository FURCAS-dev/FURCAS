package com.sap.tc.moin.repository.events.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * LogicalOperationFilters are used to connect MoinEventFilters using Boolean
 * operations. The depth or size of the resulting tree is not limited, but it
 * might affect the performance while registering dramatically. The more the
 * tree resembles the DNF, the faster the transformation will be.
 * 
 * @author Daniel Vocke (D044825)
 */
public abstract class LogicalOperationFilter extends EventFilter {

    /**
     * @return the operands which are connected by the logic operation
     */
    public List<EventFilter> getOperands( ) {

        return _operands;
    }

    /**
     * creates a (deep) clone of the current element.
     */
    public LogicalOperationFilter clone( ) {

        LogicalOperationFilter result;
        try {
            result = (LogicalOperationFilter) this.getClass( ).newInstance( );
        } catch ( Exception e ) {
            result = null;
        }
        // perform a deep clone => clone the contained filters and add them to
        // the result
        for ( EventFilter operand : _operands ) {
            EventFilter clonedFilter = (EventFilter) operand.clone( );
            result._operands.add( clonedFilter );
        }
        return result;
    }

    /*
     * @see java.lang.Object#equals(java.lang.Object) a Filter is equal to
     * another, if they are of the same type and if they contain equal operands.
     */
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof LogicalOperationFilter ) {
            LogicalOperationFilter other = (LogicalOperationFilter) obj;
            if ( other._operands.size( ) != _operands.size( ) )
                return false;
            // uses the class' own OperandsList which ignores the ordering at comparision time
            return _operands.equals( other._operands );
        }
        return false;
    }

    /*
     * it is not prevented that doubles might be added
     */
    LogicalOperationFilter( EventFilter... filters ) {

        if ( filters != null ) {
            for ( EventFilter filter : filters ) {
                _operands.add( filter );
            }
        }
    }

    /*
     * it is not prevented that doubles might be added
     */
    LogicalOperationFilter( Collection<EventFilter> filters ) {

        if ( filters != null ) {
            for ( EventFilter filter : filters ) {
                _operands.add( filter );
            }
        }
    }

    /**
     * internal method in order to simplify debugging
     */
    String printSubTree( int depth ) {

        StringBuffer result = new StringBuffer( );

        char[] indentFill = new char[indent * depth];
        Arrays.fill( indentFill, ' ' );
        result.append( indentFill );
        result.append( "<" ); //$NON-NLS-1$
        result.append( getFilterName( ) );
        result.append( " operands='" + _operands.size( ) + "'" ); //$NON-NLS-1$ //$NON-NLS-2$
        result.append( ">\n" ); //$NON-NLS-1$

        for ( EventFilter operand : _operands ) {
            result.append( operand.printSubTree( depth + 1 ) );
        }

        result.append( indentFill );
        result.append( "</" ); //$NON-NLS-1$
        result.append( getFilterName( ) );
        result.append( ">\n" ); //$NON-NLS-1$

        return result.toString( );
    }

    List<EventFilter> _operands = new ArrayList<EventFilter>( 2 );

}