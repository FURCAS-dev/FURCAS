package de.hpi.sam.bp2009.moin.impactAnalyzer.expressions;

import org.eclipse.ocl.ecore.Constraint;

/**
 * This class represents direct sub-expressions, i.e., sub-expressions which
 * start with <tt>self</tt> or <tt>allInstances()</tt>.
 */
public class DirectSubExpression extends SubExpression {

    /**
     * @param actconnection {@link CoreConnection}
     * @param statement {@link OclStatement}
     */
    public DirectSubExpression( Constraint statement ) {

        super( statement );
    }

    /**
     * @see com.sap.tc.moin.ocl.ia.expressions.SubExpression#copy()
     */
    @Override
    public SubExpression copy( ) {

        DirectSubExpression subExp = new DirectSubExpression( this.getStatement( ) );
        subExp.getExpressionParts( ).addAll( this.getExpressionParts( ) );
        subExp.setKind( this.getKind( ) );
        subExp.getChildSubExp( ).addAll( this.getChildSubExp( ) );
        return subExp;
    }

}
