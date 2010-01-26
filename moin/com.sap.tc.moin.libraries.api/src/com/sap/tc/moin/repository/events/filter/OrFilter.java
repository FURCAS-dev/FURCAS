package com.sap.tc.moin.repository.events.filter;

import java.util.Collection;

// import com.sap.tc.moin.repository.exception.wrapped.IllegalStateException;

/**
 * This type of {@link com.sap.tc.moin.repository.events.filter.LogicalOperationFilter} connects at least 2 operands using the
 * Boolean OR relation. Due to the commutativity of the Boolean OR relation, more than 2 operands are supported. The
 * filters to connect can be passed in the constructor.
 * 
 * @see com.sap.tc.moin.repository.events.filter.LogicalOperationFilter
 * @author Daniel Vocke (D044825)
 */
public class OrFilter extends LogicalOperationFilter {

    /**
     * creates a new <code>OrFilter</code> and adds the passed operands to its operands-list.
     * 
     * @param operands the operands to be connected by a logical OR
     */
    public OrFilter( EventFilter... operands ) {

        super( operands );
    }

    /**
     * creates a new <code>OrFilter</code> and adds the passed operands to its operands-list.
     * 
     * @param operands the operands to be connected by a logical OR
     */
    public OrFilter( Collection<EventFilter> operands ) {

        super( operands );
    }

    /**
     * Creates an empty OrFilter. Operands can be added via {@link #getOperands()} 
     */
    public OrFilter( ) {
    }
    
    /**
     * Appends <tt>otherFilter</tt> to this filter's operands.
     */
    @Override
    public void merge(EventFilter otherFilter) {
	if (!this.equals(otherFilter) && !_operands.contains(otherFilter)) {
	    _operands.add(otherFilter);
	}
    }
}