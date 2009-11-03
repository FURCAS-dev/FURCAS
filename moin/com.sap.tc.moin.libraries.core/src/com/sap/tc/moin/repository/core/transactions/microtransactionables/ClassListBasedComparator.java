package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.Comparator;
import java.util.List;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * This comparator compares two objects based on their classes.
 * <p>
 * The order is determined by the index of the class in the given list of the
 * constructor.
 * <p>
 * If the objects to compare are equal, the <code>compare</code> method returns
 * 0. If the class for at least one of the objects to compare is not present in
 * the list, the <code>compare</code> method compares their hash codes. If the
 * objects to compare are instances of the same class, the <code>compare</code>
 * method returns 0.
 */
public class ClassListBasedComparator<T> implements Comparator<T> {

    private List<Class<?>> comparisonList = null;

    public ClassListBasedComparator( List<Class<?>> aComparisonList ) {

        comparisonList = aComparisonList;
    }

    public int compare( T o1, T o2 ) {

        if ( o1.equals( o2 ) ) {
            return 0;
        }
        if ( comparisonList.contains( o1.getClass( ) ) && comparisonList.contains( o2.getClass( ) ) ) {
            return Integer.valueOf( comparisonList.indexOf( o1.getClass( ) ) ).compareTo( Integer.valueOf( comparisonList.indexOf( o2.getClass( ) ) ) );
        }
        throw new MoinLocalizedBaseRuntimeException( MicroTransactionablesMessages.CANNOTCOMPAREINSTANCESCOMPARISONLISTOUTDATED, o1.getClass( ).getSimpleName( ), o2.getClass( ).getSimpleName( ) );
    }
}
