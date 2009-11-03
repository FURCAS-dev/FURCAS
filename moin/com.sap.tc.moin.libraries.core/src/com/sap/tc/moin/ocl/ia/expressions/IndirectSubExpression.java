package com.sap.tc.moin.ocl.ia.expressions;

import java.util.HashSet;
import java.util.Set;

import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.LoopExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.IterateExpInternal;
import org.omg.ocl.expressions.__impl.LoopExpInternal;
import org.omg.ocl.expressions.__impl.VariableExpInternal;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;

/**
 * This class represents indirect sub-expressions, i.e., sub-expressions which
 * start with an iterator variable. Indirect sub-expression do always have a
 * parent sub-expression.
 */
public class IndirectSubExpression extends SubExpression {

    @Override
    protected Object clone( ) throws CloneNotSupportedException {

        return super.clone( );
    }

    /**
     * The set of parent sub expressions. One indirect sub can have more than
     * one parent sub expression.
     */
    private Set<SubExpression> parentExpressions = new HashSet<SubExpression>( );

    /**
     * @param actconnection {@link CoreConnection}
     * @param statement {@link OclStatement}
     */
    public IndirectSubExpression( CoreConnection actconnection, OclStatement statement ) {

        super( actconnection, statement );
    }

    /**
     * @return Returns the parentExpression.
     */
    public Set<SubExpression> getParentExpressions( ) {

        return this.parentExpressions;
    }

    /**
     * @param parentExpression The parentExpression to set.
     */
    public void addParentExpression( SubExpression parentExpression ) {

        this.parentExpressions.add( parentExpression );
    }

    /**
     * @param loop {@link LoopExp}
     * @return true or false
     */
    public boolean isChildOf( LoopExp loop ) {

        try {
            VariableExp start = (VariableExp) this.getExpressionParts( ).get( 0 );
            VariableDeclaration varDecl = ( (VariableExpInternal) start ).getReferredVariable( this.connection );
            if ( ( (JmiList<VariableDeclaration>) ( (LoopExpInternal) loop ).getIterators( this.connection ) ).contains( this.connection, varDecl ) ) {
                return true;
            }
            if ( loop instanceof IterateExp ) {
                if ( ( (IterateExpInternal) loop ).getResult( this.connection ).equals( varDecl ) ) {
                    return true;
                }
            }
        } catch ( Exception e ) {
            // $JL-EXC$ TODO log this?
        }
        return false;
    }

    /**
     * @return the copied expression
     */
    @Override
    public SubExpression copy( ) {

        IndirectSubExpression subExp = new IndirectSubExpression( this.connection, this.getStatement( ) );
        subExp.getExpressionParts( ).addAll( this.getExpressionParts( ) );
        subExp.setKind( this.getKind( ) );
        subExp.getChildSubExp( ).addAll( this.getChildSubExp( ) );
        // subExp.setContinuedAt(this.continuedAt);
        subExp.getParentExpressions( ).addAll( this.parentExpressions );
        return subExp;
    }

}