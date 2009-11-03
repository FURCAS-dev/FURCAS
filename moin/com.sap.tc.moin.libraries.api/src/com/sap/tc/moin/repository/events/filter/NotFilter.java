package com.sap.tc.moin.repository.events.filter;


/**
 * A NOTFilter is used to negate a sub tree which of course can also consist of a single filter. A NOTFilter may contain
 * only one operand. The difference between a <code>NotFilter</code> and the <code>negated</code> flag in all
 * Filters is that a NotFitler negates the whole subtree and the negated-flag affects only the current filter. Note, that
 * the negated flag cannot be set on LogicalOperationFilters. <br>
 * <B>Warning:</B> Using negations may dramatically affect the performance of the EventFramework, so only use them where really needed!

 * 
 * @see com.sap.tc.moin.repository.events.filter.LogicalOperationFilter
 * @author Daniel Vocke (D044825)
 */
public class NotFilter extends LogicalOperationFilter {

    /**
     * creates a NotFilter and sets the parameter as negated operand.
     * @param operand the operand to negate
     */
    public NotFilter( EventFilter operand ) {

        _operands.add( operand );
    }
}