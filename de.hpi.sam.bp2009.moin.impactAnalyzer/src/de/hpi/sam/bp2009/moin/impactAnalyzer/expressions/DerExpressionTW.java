package de.hpi.sam.bp2009.moin.impactAnalyzer.expressions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.Variable;

import de.hpi.sam.bp2009.moin.impactAnalyzer.tag.ExpressionKind;

/**
 * This class determines sub-expressions in user-defined and derived attributes.
 * This is done by virtually expanding the attribute's definition.
 * 
 * @see de.hpi.sam.bp2009.moin.impactAnalyzer.expressions.sap.tc.moin.ocl.ia.expressions.SubExpressionTW
 */
public class DerExpressionTW extends SubExpressionTW {

    private SubExprTag initialTag = null;

    private Set<SubExpression> accumulatedSubExprs = new HashSet<SubExpression>( );

    /**
     * @param actConnection the core connection
     */
    public DerExpressionTW( ) {

        super( );
    }

    /**
     * Determines the set of current sub expressions for a user defined
     * attribute or derived attibute value expression.
     * 
     * @param derExpr the expression which defines the attribute or the
     * attriubtes derived value
     * @param stmt the OclStatement in whicht this user defined opeation is used
     * @param tag the tag attached to the source of the attribute call
     * @return the set of current sub expressions. To get the accumulated sub
     * expression call <tt>getAccumulatedSubExprs()</tt>
     */
    public Set<SubExpression> determineSubExpressions( OCLExpression derExpr, Constraint stmt, SubExprTag tag ) {

        this.initialTag = tag;
        // keep the statement arround. we will need it several times
        // in the up-methods
        this.statement = stmt;
        // start the algorithm
        super.walk( derExpr );
        // collect the results
        SubExprTag rootTag = getTag( stmt.getSpecification().getBodyExpression() );
        return rootTag.getCurrentSubExprs( );
    }

    /**
     * @return Accumulated sub expressions identified during execution of
     * determineSubExpressions(OclExpression,OclStatement,SubExpTag)
     */
    public Set<SubExpression> getAccumulatedSubExprs( ) {

        return this.accumulatedSubExprs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upVariableExp(org.omg.ocl.expressions.VariableExp)
     */
    @Override
    protected void upVariableExp( VariableExp exp ) {

        SubExprTag tag = getTag( exp );
         Variable<EClassifier, EParameter> varDecl = exp.getReferredVariable( );
        // order of the if statements is crucial! Someone could have defined
        // a iterator variable "self"
        if ( varDecl.getLoopExpr( ) != null ) {
            // variable is an iterator variable
            // create indirect sub expression
            SubExpression subExp = new IndirectSubExpression( this.statement );
            subExp.setKind( ExpressionKind.INSTANCE );
            subExp.addExpressionParts( exp );
            // pass sub expression up the tree
            tag.addToCurrent( subExp );
        } else if ( varDecl.getName( ).equals( "self" ) && varDecl.getInitExpression( ) == null ) {
            // variable is self
            // continue subexpressions passed to DerExpressionTW
            // pass sub expression up the tree
            for ( Iterator<SubExpression> i = this.initialTag.getCurrentSubExprs( ).iterator( ); i.hasNext( ); ) {
                SubExpression subExp = i.next( );
                tag.addToCurrent( subExp.copy( ) );
            }
            tag.addToAccumulated( this.initialTag.getAccumulatedSubExprs( ) );
        } else {
            // pass sub expressions attached to variable declaration up the tree
            // we have to actually copy each current subexpression since
            // they can be part of several other subexpressions
            SubExprTag varDeclTag = getTag( varDecl );
            for ( Iterator<SubExpression> i = varDeclTag.getCurrentSubExprs( ).iterator( ); i.hasNext( ); ) {
                SubExpression subExpr = i.next( );
                tag.addToCurrent( subExpr.copy( ) );
            }
            tag.addToAccumulated( varDeclTag.getAccumulatedSubExprs( ) );
        }
    }
}