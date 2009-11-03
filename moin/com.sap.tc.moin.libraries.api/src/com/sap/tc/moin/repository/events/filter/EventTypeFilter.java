package com.sap.tc.moin.repository.events.filter;

import java.util.Arrays;
import java.util.Set;

import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * The EventTypeFilter allows filtering by types of events. This mechanism
 * enables clients to listen for selected events only. The type of the filter
 * criterion is {@link java.lang.Class}. Subtypes are included implicitly.
 * 
 * @see com.sap.tc.moin.repository.events.filter.EventFilter
 * @author Daniel Vocke (D044825)
 */
public class EventTypeFilter extends EventFilter {

    /**
     * @param filterCriterion defines the event class that shall be filtered.
     * other events (excluding its subtypes) will not be received.
     */
    public EventTypeFilter( Class<? extends ChangeEvent>... filterCriterion ) {

        super( filterCriterion );
    }

    /**
     * @param filterCriterion defines the event class that shall be filtered.
     * other events (excluding its subtypes) will not be received.
     */
    public EventTypeFilter( Class<? extends ChangeEvent> filterCriterion ) {

        super( filterCriterion );
    }

    /**
     * @param filterCriteria defines the event class that shall be filtered.
     * other events (excluding its subtypes) will not be received.
     */
    public EventTypeFilter( Set<Class<? extends ChangeEvent>> filterCriteria ) {

        super( filterCriteria.toArray( ) );
    }

    /**
     * this is only an internally needed helper method which simplifies
     * debugging
     * 
     * @param depth the current depth of the current element in the tree
     * @return a (multi-line)string which represents a graphical representation
     * of the FilterTree
     */
    @Override
    String printSubTree( int depth ) {

        StringBuffer result = new StringBuffer( );
        // fill with spaces
        char[] indentFill = new char[indent * depth];
        Arrays.fill( indentFill, ' ' );
        result.append( indentFill );

        result.append( "<" ); //$NON-NLS-1$
        result.append( getFilterName( ) );

        if ( this.isNegated( ) ) {
            result.append( " negated='true'" ); //$NON-NLS-1$
        }

        if ( _filterCriterion instanceof Class ) {
            result.append( " type='" ).append( ( (Class) getFilterCriterion( ) ).getSimpleName( ) ).append( "'/>\n" ); //$NON-NLS-1$ //$NON-NLS-2$
        } else {
            Object[] criteria = (Object[]) _filterCriterion;

            result.append( " criteria='" + criteria.length + "'" ); //$NON-NLS-1$ //$NON-NLS-2$
            result.append( ">\n" ); //$NON-NLS-1$

            for ( Object criterion : criteria ) {
                result.append( indentFill );
                result.append( "    " ); //$NON-NLS-1$
                result.append( "<" ).append( ( (Class<?>) criterion ).getSimpleName( ) ).append( "/>\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            result.append( indentFill );
            result.append( "</" ); //$NON-NLS-1$
            result.append( getFilterName( ) );
            result.append( ">\n" ); //$NON-NLS-1$
        }

        return result.toString( );
    }
}