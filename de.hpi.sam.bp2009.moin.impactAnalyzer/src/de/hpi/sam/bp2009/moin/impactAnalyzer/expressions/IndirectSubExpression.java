package de.hpi.sam.bp2009.moin.impactAnalyzer.expressions;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.Variable;

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
     * @param statement {@link Constraint}
     */
    public IndirectSubExpression( Constraint statement ) {

        super( statement );
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
     * Decides if this subexpression belongs to the <tt>loop</tt> expression. It does so by extracting the
     * first {@link #getExpressionParts()} element which is assumed to be a {@link VariableExp}-typed expression.
     * If the variable declaration to which the variable expression refers is an iterator or result variable of
     * <tt>loop</tt>, <tt>true</tt> is returned; otherwise, <tt>false</tt> is returned.
     */
    public boolean isChildOf( LoopExp loop ) {

        try {
            VariableExp start = (VariableExp) this.getExpressionParts( ).get( 0 );
            Variable<EClassifier, EParameter> varDecl = ( start ).getReferredVariable( );
            if ( loop.getIterator( ).contains( varDecl ) ) {
                return true;
            }
            if ( loop instanceof IterateExp ) {
                if ( ( (IterateExp) loop ).getResult( ).equals( varDecl ) ) {
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

        IndirectSubExpression subExp = new IndirectSubExpression( this.getStatement( ) );
        subExp.getExpressionParts( ).addAll( this.getExpressionParts( ) );
        subExp.setKind( this.getKind( ) );
        subExp.getChildSubExp( ).addAll( this.getChildSubExp( ) );
        // subExp.setContinuedAt(this.continuedAt);
        subExp.getParentExpressions( ).addAll( this.parentExpressions );
        return subExp;
    }

}