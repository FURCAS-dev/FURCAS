package com.sap.tc.moin.repository.events.filter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;

/**
 * EventFilters are used by clients to specify the subset of events they would
 * like to receive. They are passed to the <code>EventRegistry</code> at
 * registration time and cannot be modified afterwards. <br>
 * An event filter can be interpreted as boolean expression like
 * <code>property == value</code>, where the property is specified by the
 * subtype of <code>MoinEventFilter</code> (E.g. <code>EventTypeFilter</code>
 * ,...) and the value is specified by its filter criterion that can be obtained
 * using the {@link EventFilter#getFilterCriterion()} operation. <br>
 * Note, that a negated filter includes the complement of all event types, not
 * only the types the filter normally affects. For example an "expression" like
 * <code>AttributeFilter==myAttr</code> results in AttributeChangeEvents
 * affecting <code>myAttr</code>. If the same filter is negated, e.g.
 * <code>LinkChangedEvents</code> also are included. <br>
 * Some <code>MoinEventFilter</code> cover multiple atomic filters. (E.g.
 * ClassFilter with a true <code>includeSubClasses</code> flag results in a set
 * of filters which describe its subclasses) There are 2 types of those filters: <br>
 * <ul>
 * <li>filters which result in a static set of atomic filters (like ClassFilter
 * including subclasses).</li> those filters are split into their atomic
 * equivalent which then is registered (better performance).
 * <li>filters which result in a dynamic set of atomic filters (like
 * InstanceFilter including composite children)</li> those filters get their own
 * instance of <code>EventFilterTable</code> which returns a Set of affected
 * objects of an event. this solution is more dynamic but therefore slower.
 * </ul>
 * 
 * @author Daniel Vocke (D044825)
 */
public abstract class EventFilter implements Cloneable {

    private FilterMatcher filterMatcher;

    /**
     * @param filterCriterion the criterion that specifies the filtered events
     */
    protected EventFilter( RefObject filterCriterion ) {

        MRI mri = ( (Partitionable) filterCriterion ).get___Mri( );
        if ( mri == null ) {
            throw new IllegalArgumentException( );
        }
        _filterCriterion = mri.getLri( );
    }

    /**
     * @param filterCriterion the criterion that specifies the filtered events
     */
    protected EventFilter( MRI filterCriterion ) {

        _filterCriterion = filterCriterion.getLri( );
    }

    /**
     * @param filterCriterion the criterion that specifies the filtered events
     */
    protected EventFilter( Object filterCriterion ) {

        if ( filterCriterion instanceof Partitionable ) {
            MRI mri = ( (Partitionable) filterCriterion ).get___Mri( );
            if ( mri == null ) {
                throw new IllegalArgumentException( );
            }
            _filterCriterion = mri.getLri( );
        } else if ( filterCriterion instanceof MRI ) {
            _filterCriterion = ( (MRI) filterCriterion ).getLri( );
        } else {
            _filterCriterion = filterCriterion;
        }
    }

    /**
     * @return the filterCriterion that was set at creation time
     */
    public final Object getFilterCriterion( ) {

        return _filterCriterion;
    }

    /**
     * determines whether the filter expresses an interest on the filter
     * criterion (negated==false) or all other filter critera (negated==true)
     * 
     * @return whether the events that the filterCriterion specifies shall be
     * received or all other events.
     */
    public final boolean isNegated( ) {

        return _negated;
    }

    /**
     * Changes the negation flag.
     * 
     * @param negated the negation flag to be set in the EventFilter
     */
    public final void setNegated( boolean negated ) {

        _negated = negated;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public EventFilter clone( ) {

        try {
            return (EventFilter) super.clone( );
        } catch ( CloneNotSupportedException e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString( ) {

        return printSubTree( 0 );
    }

    /*
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof EventFilter ) {
            EventFilter other = (EventFilter) obj;
            return _filterCriterion.equals( other._filterCriterion ) && _negated == other._negated;
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        int hashCode = 0;
        hashCode = 17;
        hashCode = 37 * hashCode + ( this._filterCriterion != null ? this._filterCriterion.hashCode( ) : 0 );
        hashCode = 37 * hashCode + ( this._negated ? 1 : 0 );
        return hashCode;
    }

    /**
     * this is only an internally needed helper method which simplifies
     * debugging
     * 
     * @param depth the current depth of the current element in the tree
     * @return a (multi-line)string which represents a graphical representation
     * of the FilterTree
     */
    String printSubTree( int depth ) {

        StringBuffer result = new StringBuffer( );
        // fill with spaces
        char[] indentFill = new char[indent * depth];
        Arrays.fill( indentFill, ' ' );
        result.append( indentFill );

        result.append( "<" ); //$NON-NLS-1$
        result.append( getFilterName( ) );

        if ( _negated ) {
            result.append( " negated='true'" ); //$NON-NLS-1$
        }

        if ( _filterCriterion instanceof Collection ) {
            Collection<Object> criteria = (Collection<Object>) _filterCriterion;

            result.append( " criteria='" + criteria.size( ) + "'" ); //$NON-NLS-1$ //$NON-NLS-2$
            result.append( ">\n" ); //$NON-NLS-1$

            for ( Object criterion : criteria ) {
                result.append( indentFill );
                result.append( "    " ); //$NON-NLS-1$
                result.append( "<FilterCriterion value='" ).append( criterion.toString( ) ).append( "'/>\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            result.append( indentFill );
            result.append( "</" ); //$NON-NLS-1$
            result.append( getFilterName( ) );
            result.append( ">\n" ); //$NON-NLS-1$
        } else {
            result.append( " criterion='" ).append( getFilterCriterion( ).toString( ) ).append( "'/>\n" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        return result.toString( );
    }

    /**
     * needed for {@link #printSubTree(int)}
     * 
     * @return
     */
    final String getFilterName( ) {

        String result = getClass( ).getName( );
        return result.substring( result.lastIndexOf( '.' ) + 1 );
    }

    /**
     * Merges the content of the given filter into the current filter. Not all
     * filter types support this operation. Those which do not support it will
     * throw an {@link UnsupportedOperationException}. Only filters that have
     * the same type, will support merging. If an incompatible type is passed to
     * this method, it will throw an {@link IllegalArgumentException}.
     * 
     * @param otherFilter with the content to be merges into this filter
     */
    public final void merge( EventFilter otherFilter ) {

        if ( !otherFilter.getClass( ).equals( this.getClass( ) ) ) {
            throw new MoinIllegalArgumentException( RepositoryEventsFilterMessages.FILTERCANNOTMERGEWITH, otherFilter.toString( ) );
        }

        Object otherFilterCriterion = otherFilter.getFilterCriterion( );
        if ( otherFilterCriterion instanceof Collection ) {
            Collection otherLris = (Collection) otherFilterCriterion;
            if ( this._filterCriterion instanceof Collection ) {
                Collection lris = (Collection) _filterCriterion;
                lris.addAll( otherLris );
            } else {
                otherLris.add( _filterCriterion );
                _filterCriterion = otherLris;
            }
        } else {
            if ( this._filterCriterion instanceof Collection ) {
                Collection lris = (Collection) _filterCriterion;
                lris.add( otherFilterCriterion );
            } else {
                Set lris = new HashSet( );
                lris.add( _filterCriterion );
                lris.add( otherFilterCriterion );
                _filterCriterion = lris;
            }
        }
    }

    /**
     * Returns the {@link FilterMatcher} object which is used during event
     * processing for this filter. If the value is <code>null</code>, then the
     * default matcher for this filter is used.
     * 
     * @return the {@link FilterMatcher} for this filter object
     */
    public final FilterMatcher getFilterMatcher( ) {

        return filterMatcher;
    }

    /**
     * Provides the ability to set a custom {@link FilterMatcher} for this
     * filter. If no {@link FilterMatcher} is set, then the default matcher for
     * this filter is used.
     * 
     * @param filterMatcher
     */
    public final void setFilterMatcher( FilterMatcher filterMatcher ) {

        this.filterMatcher = filterMatcher;
    }

    /**
     * For internal use
     */
    EventFilter( ) {

    }

    static final int indent = 4;

    /*
     * Private Data
     */
    private boolean _negated = false;

    protected Object _filterCriterion = null;
}