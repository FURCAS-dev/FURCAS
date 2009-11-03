package com.sap.tc.moin.repository.spi.facility.basicquery;

import java.util.Iterator;
import java.util.List;

/**
 * Abstract class for multinary expressions
 */
@Deprecated
public abstract class SpiMultinaryExpression implements SpiAttributeExpression {

    protected List operands;

    /**
     * Constructor takes a list of operands
     * 
     * @param operands list of AttributeExpression instances
     */
    public SpiMultinaryExpression( List operands ) {

        this.operands = operands;
    }

    /**
     * Introspection
     */
    public Iterator getOperands( ) {

        return this.operands.iterator( );
    }
}
