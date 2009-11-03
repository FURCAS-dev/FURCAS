package com.sap.tc.moin.ocl.ia.expressions;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * This class represents direct sub-expressions, i.e., sub-expressions which
 * start with <tt>self</tt> or <tt>allInstances()</tt>.
 */
public class DirectSubExpression extends SubExpression {

    /**
     * @param actconnection {@link CoreConnection}
     * @param statement {@link OclStatement}
     */
    public DirectSubExpression( CoreConnection actconnection, OclStatement statement ) {

        super( actconnection, statement );
    }

    /**
     * @see com.sap.tc.moin.ocl.ia.expressions.SubExpression#copy()
     */
    @Override
    public SubExpression copy( ) {

        DirectSubExpression subExp = new DirectSubExpression( this.connection, this.getStatement( ) );
        subExp.getExpressionParts( ).addAll( this.getExpressionParts( ) );
        subExp.setKind( this.getKind( ) );
        subExp.getChildSubExp( ).addAll( this.getChildSubExp( ) );
        return subExp;
    }

}
