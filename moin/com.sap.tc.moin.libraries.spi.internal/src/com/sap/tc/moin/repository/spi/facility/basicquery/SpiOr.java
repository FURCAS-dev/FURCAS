package com.sap.tc.moin.repository.spi.facility.basicquery;

import java.util.Iterator;
import java.util.List;

/**
 * Implements the Or operator.
 */
@Deprecated
public final class SpiOr extends SpiMultinaryExpression {

    /**
     * Constructor takes a list of operands
     */
    public SpiOr( List anExpressionList ) {

        super( anExpressionList );
    }

    /**
     *
     */
    public void toString( StringBuffer sb, int ident, boolean newline ) {

        if ( newline ) {
            SpiUtils.toStringNewLine( sb, ident );
        }
        sb.append( SpiUtils.OPENING_PARENTHESES );
        sb.append( SpiUtils.OR );
        for ( Iterator it = this.getOperands( ); it.hasNext( ); ) {
            ( (SpiAttributeExpression) it.next( ) ).toString( sb, ident + 1, true );
        }
        sb.append( SpiUtils.CLOSING_PARENTHESES );
    }


}