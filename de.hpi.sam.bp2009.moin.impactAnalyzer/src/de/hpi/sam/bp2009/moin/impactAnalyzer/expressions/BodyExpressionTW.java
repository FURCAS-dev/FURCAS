package de.hpi.sam.bp2009.moin.impactAnalyzer.expressions;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.impl.VariableExpImpl;
import org.eclipse.ocl.expressions.Variable;

import de.hpi.sam.bp2009.moin.impactAnalyzer.tag.ExpressionKind;

/**
 * Determines sub expressions in user defined operations. The user-defined
 * operation is virtually expanded in the calling OCL expression. To do so, the
 * sub-expressions of the arguments and the source are continued.
 */
class BodyExpressionTW extends SubExpressionTW {

    private Map<String, SubExprTag> parName2Tag = new Hashtable<String, SubExprTag>( );

    private Set<SubExpression> accumulatedSubExprs = new HashSet<SubExpression>( );

    private SubExprTag sourceTag = null;

    /**
     * @param actConnection {@link CoreConnection}
     * @param x the Stack of recursively analyzed operations and attributes
     */
    public BodyExpressionTW( Stack<EOperation> x ) {

        super( );
        this.visitedFeatures = x;
    }

    @Override
    protected void upVariableExp( VariableExp exp ) {

        SubExprTag tag = getTag( exp );
         Variable<EClassifier, EParameter> varDecl = ( (VariableExpImpl) exp ).getReferredVariable( );
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
            // // create direct sub expression
            // SubExpression subExp = new DirectSubExpression(statement);
            // subExp.setKind(ExpressionKind.INSTANCE);
            // subExp.addExpressionParts(exp);
            // // pass sub expression up the tree
            for ( SubExpression se : this.sourceTag.getCurrentSubExprs( ) ) {
                tag.addToCurrent( se.copy( ) );
            }
            // fix: more than one self in operation body
            // tag.addToCurrent(this.sourceTag.getCurrentSubExprs());
        } else if ( varDecl.getInitExpression( ) == null ) {

            // TODO there were NPEs without this when the expression contains
            // a "null" reference; this is a pragmatic workaround but should
            // be checked more deeply (the argTag in the next line would be null)
            if ( varDecl.getName( ).equals( "null" ) ) {
                return;
            }

            // variable is a parameter
            // get the sub expressions attached to the arguments
            SubExprTag argTag = this.parName2Tag.get( varDecl.getName( ) );
            // copy all current subexpressions
            for ( Iterator<SubExpression> i = argTag.getCurrentSubExprs( ).iterator( ); i.hasNext( ); ) {
                SubExpression subExp = i.next( );
                tag.getCurrentSubExprs( ).add( subExp.copy( ) );
            }
            // just add accumulated sub expressions
            tag.addToAccumulated( argTag.getAccumulatedSubExprs( ) );
        } else {
            // pass sub expressions attached to variable declaration up the tree
            // we have to actually copy each current subexpression since
            // they can be part of several other subexpressions
            SubExprTag varDeclTag = getTag( varDecl );
            for ( Iterator<SubExpression> i = varDeclTag.getCurrentSubExprs( ).iterator( ); i.hasNext( ); ) {
                SubExpression subExpr = i.next( );
                tag.getCurrentSubExprs( ).add( subExpr.copy( ) );
            }
            tag.addToAccumulated( varDeclTag.getAccumulatedSubExprs( ) );
        } // end if
    }

    /**
     * Determines the set of current sub expressions for a user defined
     * operation.
     * 
     * @param op the user defined operation
     * @param bodyExp the body expression of <code>op</code>
     * @param stmt the OclStatement in which this user defined operation is used
     * @param actSourceTag source expression tag
     * @param argTags the list of tag attached to the arguments
     * @return the set of current sub expressions. to get the accumulated sub
     * expression call <tt>getAccumulatedSubExprs()</tt>
     */
    public Set<SubExpression> determineSubExpressions( EOperation op, OCLExpression bodyExp, Constraint stmt, SubExprTag actSourceTag, List<SubExprTag> argTags ) {

        this.statement = stmt;
        this.accumulatedSubExprs.clear( );
        // keep the sourceTag. I'll be needed in upVariableExp()
        this.sourceTag = actSourceTag;

        if ( this.visitedFeatures.contains( op ) ) {
            // TODO: this has not been tested!
            // we are in a cycle!
            // don't expand this operation yet again
            // panic and mark all subexpressions as class
            for ( Iterator<SubExprTag> i = argTags.iterator( ); i.hasNext( ); ) {
                SubExprTag tag = i.next( );
                for ( Iterator<SubExpression> i2 = tag.getCurrentSubExprs( ).iterator( ); i2.hasNext( ); ) {
                    SubExpression exp = i2.next( );
                    exp.setKind( ExpressionKind.CLASS );
                    // all sub expressions end here!
                    this.accumulatedSubExprs.add( exp );
                }
            }
            // mark all sub-expressions attached to the source as CLASS
            for ( Iterator<SubExpression> i = this.sourceTag.getCurrentSubExprs( ).iterator( ); i.hasNext( ); ) {
                SubExpression exp = i.next( );
                exp.setKind( ExpressionKind.CLASS );
            }
            return new HashSet<SubExpression>( );

        }
        // add this operation to the stack of visited features
        this.visitedFeatures.add( op );
        List<Parameter> parameters = new Vector<Parameter>( );
        int index = 0;
        // build up hashtable to map from parameter name to
        JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (OperationImpl) op ).getContents( this.connection );
        for ( int i = 0, n = contents.size( this.connection.getSession( ) ); i < n; i++ ) {
            Object ob = contents.get( this.connection.getSession( ), i );
            if ( ob instanceof Parameter ) {
                Parameter p = (Parameter) ob;
                if ( p.getDirection( ) == DirectionKindEnum.IN_DIR ) {
                    parameters.add( p );
                    this.parName2Tag.put( p.getName( ), argTags.get( index ) );
                    index++;
                }
            }
        }
        // start the algorithm
        super.walk( bodyExp );
        // remove the operation form the stack of visited features.
        this.visitedFeatures.pop( );
        // collect the results
        SubExprTag rootTag = getTag( bodyExp );
        this.accumulatedSubExprs = rootTag.getAccumulatedSubExprs( );
        return rootTag.getCurrentSubExprs( );
    }

    /**
     * @return the set of accumulated sub expressions.
     */
    public Set<SubExpression> getAccumulatedSubExprs( ) {

        return this.accumulatedSubExprs;
    }
}
