package com.sap.tc.moin.repository.events.filter;

import java.util.Collection;


/**
 * This type of {@link com.sap.tc.moin.repository.events.filter.LogicalOperationFilter} connects at least 2 operands using the
 * Boolean AND relation. Due to the commutativity of the Boolean AND relation, more than 2 operands are supported. The
 * filters to connect can be passed in the constructor.
 * 
 * @author Daniel Vocke (D044825)
 */
public class AndFilter extends LogicalOperationFilter {

    /**
     * creates a new <code>AndFilter</code> and adds the passed operands to its operands-list.
     * @param operands the operands to be connected by a logical AND
     */
    public AndFilter( EventFilter... operands ) {

        super( operands );
    }

    /**
     * creates a new <code>AndFilter</code> and adds the passed operands to its operands-list.
     * 
     * @param operands the operands to be connected by a logical OR
     */
    public AndFilter( Collection<EventFilter> operands ) {

        super( operands );
    }

    /**
     * Creates an empty AndFilter. Operands can be added via {@link #getOperands()} 
     */
    public AndFilter( ) {

    }
}