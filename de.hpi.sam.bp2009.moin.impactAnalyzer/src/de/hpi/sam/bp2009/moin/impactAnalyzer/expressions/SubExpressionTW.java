package de.hpi.sam.bp2009.moin.impactAnalyzer.expressions;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionRange;
import org.omg.ocl.expressions.EnumLiteralExp;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.LetExp;
import org.omg.ocl.expressions.LoopExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpImpl;
import org.omg.ocl.expressions.__impl.AttributeCallExpImpl;
import org.omg.ocl.expressions.__impl.IfExpImpl;
import org.omg.ocl.expressions.__impl.IterateExpImpl;
import org.omg.ocl.expressions.__impl.IteratorExpImpl;
import org.omg.ocl.expressions.__impl.LetExpImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableExpImpl;
import org.omg.ocl.types.TupleType;

import com.sap.tc.moin.ocl.ia.tag.ExpressionKind;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.treewalker.TreeWalker;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;

/**
 * This class implements a algorithm for finding direct or indirect
 * subexpressions.
 * <p>
 * It uses IndirectSubExpression and DirectSubExpression. Both classes collect
 * the OCL AST node which belong to a sub expression. AST nodes belong to zero
 * or more sub expression.
 * <p>
 * The algorithm walks the OCL AST in depth first manner bottom up. If it
 * encounters a node which starts a sub expression it creates a new
 * DirectSubExpression or IndirectSubExpression object. The SubExpression is
 * attached to that node using the NodeTag#getCurrSubExp().
 * <p>
 * If the algorithm comes to a AST node which ends a sub expressions, all
 * current subexpressions (NodeTag#getCurrSubExpr() are moved the set of
 * accumulated subexpressions (NodeTag#getAccuSubExpr().
 * <p>
 * Each node is added to each of the current subexpression. Current and
 * accumulated subexpressions are copied up the tree. If there is a node with
 * more than one child, the current and accumulated subexpressions are merged
 * and then copied.
 * <p>
 * When coming to a LoopExp the corresponding indirect sub expression is sought
 * for all current sub expressions and connected the their parents. Indirect sub
 * expressions which have found their parents are not propagated up the tree.
 * <p>
 * The result of the algorithm is a set of direct sub expressions. The
 * corresponding indirect sub expressions are connected to the parents.
 */
public class SubExpressionTW extends TreeWalker {

    /**
     * holds the sets of current and accumulated sub expressions for each node
     * in the OCL AST
     */
    protected static final class SubExprTag {

        private Set<SubExpression> accumulatedSubExprs = new HashSet<SubExpression>( );

        private Set<SubExpression> currentSubExprs = new HashSet<SubExpression>( );

        private boolean visited = false;

        /**
         * @return Returns the accumulated sub expressions.
         */
        public Set<SubExpression> getAccumulatedSubExprs( ) {

            return this.accumulatedSubExprs;
        }

        /**
         * @return Returns the current sub expressions.
         */
        public Set<SubExpression> getCurrentSubExprs( ) {

            return this.currentSubExprs;
        }

        /**
         * Adds a sub-expression to the set of current sub-expressions.
         * 
         * @param subExp the sub-expression to add
         */
        public void addToCurrent( SubExpression subExp ) {

            this.currentSubExprs.add( subExp );
        }

        /**
         * Adds a set of sub-expressions to the set of current sub-expressions.
         * 
         * @param subExps the sub-expressions to add
         */
        public void addToCurrent( Set<SubExpression> subExps ) {

            this.currentSubExprs.addAll( subExps );
        }

        /**
         * Adds a sub-expression to the set of accumulated sub-expressions.
         * 
         * @param subExp the sub-expression to add
         */
        public void addToAccumulated( SubExpression subExp ) {

            this.accumulatedSubExprs.add( subExp );
        }

        /**
         * Adds a set of sub-expressions to the set of accumulated
         * sub-expressions.
         * 
         * @param subExps the sub-expressions to add
         */
        public void addToAccumulated( Set<SubExpression> subExps ) {

            this.accumulatedSubExprs.addAll( subExps );
        }

        /**
         * @return Returns <tt>true</tt> iff the node to which this tag is
         * attached to has already been visited.
         */
        public boolean isVisited( ) {

            return this.visited;
        }

        /**
         * Marks this tag as visited.
         */
        public void setVisited( ) {

            this.visited = true;
        }
    }

    private Map<RefObject, SubExprTag> node2Tag = new Hashtable<RefObject, SubExprTag>( );

    protected OclStatement statement;

    protected Set<SubExpression> subExpressions = new HashSet<SubExpression>( );

    protected Stack<Operation> visitedFeatures = new Stack<Operation>( );

    /**
     * @param actConnection the core connection
     */
    public SubExpressionTW( CoreConnection actConnection ) {

        super( actConnection );
    }

    /**
     * Adds <tt>node</tt> to all current sub expressions in <tt>tag</tt>
     * 
     * @param node the node to be added.
     * @param tag the SubExprTag containing the current sub-expressions to which
     * <tt>node</tt> has to be added.
     */
    private void addNodeToCurrSubExprs( OclExpression node, SubExprTag tag ) {

        // add this node to the current sub expressions
        for ( Iterator<SubExpression> i = tag.getCurrentSubExprs( ).iterator( ); i.hasNext( ); ) {
            SubExpression currSubExp = i.next( );
            currSubExp.addExpressionParts( node );
        }
    }

    /**
     * Copies <tt>accumulatedSubExp</tt> and <tt>currentSubExp</tt> from
     * <tt>fromTag</tt> to <tt>toTag</tt>.
     * 
     * @param fromTag
     * @param toTag
     */
    protected void copySubExprs( SubExprTag fromTag, SubExprTag toTag ) {

        toTag.addToAccumulated( fromTag.getAccumulatedSubExprs( ) );
        toTag.addToCurrent( fromTag.getCurrentSubExprs( ) );
    }

    /**
     * starts to determines the set of SubExpressions. Use
     * <tt>getSubExpressions()</tt> to get the set of SubExpressions.
     * 
     * @param stmt the OclStatement to determine the sub expressions for
     * @return the set of sub expression in the OCL AST
     */
    public Set<SubExpression> determineSubExpressions( OclStatement stmt ) {

        // keep the statement around. we will need it several times
        // in the up-methods
        this.statement = stmt;
        // start the algorithm
        super.walk( stmt.getExpression( ) );
        // collect the results
        SubExprTag rootTag = getTag( stmt.getExpression( ) );
        this.subExpressions.addAll( rootTag.getAccumulatedSubExprs( ) );
        this.subExpressions.addAll( rootTag.getCurrentSubExprs( ) );
        // get rid of tags
        this.node2Tag.clear( );
        return this.subExpressions;
    }

    /**
     * Returns the OclExpression defining a user-defined operation's body.
     * 
     * @param op the user-defined operation
     * @return the body of the user-defined operations
     */
    private OclExpression getBodyExpr( Operation op ) {

        // TODO this method has to be adapted to how the parser attaches
        // user-defined operations.
        // this has not been decided yet!
        OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) this.connection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR );
        OclExpression bodyExpr = assoc.getBody( this.connection, op );
        return bodyExpr;
    }

    /**
     * Determines the return type of an operation. If, for some reason, none
     * could be found null is returned.
     * 
     * @param operation
     * @return the return type of the operation or null.
     */
    protected Classifier getReturnType( Operation operation ) {

        if ( operation != null ) {
            JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (OperationImpl) operation ).getContents( this.connection );
            for ( int i = 0, n = contents.size( this.connection.getSession( ) ); i < n; i++ ) {
                Object o = contents.get( this.connection.getSession( ), i );
                if ( o instanceof Parameter ) {
                    ParameterImpl p = (ParameterImpl) o;
                    if ( p.getDirection( ) == DirectionKindEnum.RETURN_DIR ) {
                        return p.getType( this.connection );
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the <tt>SubExprTag</tt> for a node in the AST
     * 
     * @param node the node in the AST
     * @return the <tt>SubExprTag</tt> for <tt>node</tt>
     */
    protected SubExprTag getTag( RefObject node ) {

        SubExprTag tag = this.node2Tag.get( node );
        if ( tag == null ) {
            tag = new SubExprTag( );
            this.node2Tag.put( node, tag );
        }
        return tag;
    }

    /**
     * Checks whether a <tt>Classifier</tt> is a primitiveType
     * 
     * @param c the <tt>Classifier</tt> to check
     * @return true if <tt>c</tt> is a primitive type
     */
    protected boolean isPrimitiveType( Classifier c ) {

        return ( c instanceof PrimitiveType );
    }

    /**
     * Determines whether a OperationCallExp refers to a standard library
     * operation.
     * 
     * @param exp the OperationCallExp to examine
     * @return true if the expression refers to a user standard library
     * operation.
     */
    protected boolean isStdLibOperation( OperationCallExp exp ) {

        Operation referredOperation = ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection );
        OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) this.connection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR );
        OclExpression bodyExpr = assoc.getBody( this.connection, referredOperation );
        return bodyExpr == null;
    }

    /**
     * @param referredAttribute
     * @return true or false
     */
    private boolean isUserDefined( Attribute referredAttribute ) {

        // TODO implement this method accordingly to the behaviour of the OCL
        // parser.
        // At the time of programming the decision about how the parser
        // handles user-defined operations and attributes had not been made.
        return false;
    }

    /**
     * Determines whether a OperationCallExp refers to a user defined operation
     * 
     * @param exp the OperationCallExp to examine
     * @return true if the expression refers to a user defined operation
     */
    protected boolean isUserDefinedOperation( OperationCallExp exp ) {

        Operation referredOperation = ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection );
        OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) this.connection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR );
        OclExpression bodyExpr = assoc.getBody( this.connection, referredOperation );
        return bodyExpr != null;
    }

    /**
     * handles operation calls to "allInstances()"
     * 
     * @param exp the OperationCallExp referring to "allInstances()"
     */
    protected void upAllInstances( OperationCallExp exp ) {

        SubExprTag tag = getTag( exp );
        // this is a allInstances call
        // create direct sub expression
        SubExpression subExp = new DirectSubExpression( this.connection, this.statement );
        subExp.setKind( ExpressionKind.CLASS );
        // add node to current sub expression
        subExp.addExpressionParts( ( (OperationCallExpImpl) exp ).getSource( this.connection ) );
        subExp.addExpressionParts( exp );
        tag.addToCurrent( subExp );
        // mark this node as visited
        tag.setVisited( );
    }

    @Override
    protected void upAssociationEndCallExp( AssociationEndCallExp exp ) {

        SubExprTag tag = getTag( exp );
        SubExprTag sourceTag = getTag( ( (AssociationEndCallExpImpl) exp ).getSource( this.connection ) );
        copySubExprs( sourceTag, tag );
        // add this node to the current sub expressions
        addNodeToCurrSubExprs( exp, tag );
        // mark this node as visited
        tag.setVisited( );
    }

    @Override
    protected void upAttributeCallExp( AttributeCallExp exp ) {

        SubExprTag tag = getTag( exp );
        OclExpression source = ( (AttributeCallExpImpl) exp ).getSource( this.connection );
        SubExprTag sourceTag = getTag( source );
        if ( ( (OclExpressionInternal) source ).getType( this.connection ) instanceof TupleType ) {
            // TODO this is untested
            // the way how to determine the tuple literal depends on the
            // source
            if ( source instanceof VariableExp ) {
                // get the variable declaration
                VariableExpImpl varExp = (VariableExpImpl) source;
                OclExpression initExp = ( (VariableDeclarationImpl) varExp.getReferredVariable( this.connection ) ).getInitExpression( this.connection );
                if ( initExp instanceof TupleLiteralExp ) {
                    TupleLiteralExp tupleLiteral = (TupleLiteralExp) initExp;
                    handleTupleLiteral( exp, tag, tupleLiteral );
                } else {
                    // PANIK!
                    // in lack of any better ideas
                    markAsClassSubExp( tag );
                }
            } else if ( source instanceof TupleLiteralExp ) {
                // we are already there
                TupleLiteralExp tupleLiteral = (TupleLiteralExp) source;
                handleTupleLiteral( exp, tag, tupleLiteral );
            } else if ( source instanceof AttributeCallExp ) {
                // the tuple is actually a structure
                copySubExprs( sourceTag, tag );
                // add this node to the current sub expressions
                addNodeToCurrSubExprs( exp, tag );
            } else {
                // PANIK!
                // in lack of any better ideas
                markAsClassSubExp( tag );
            }
        } else if ( isUserDefined( ( (AttributeCallExpImpl) exp ).getReferredAttribute( this.connection ) ) ) {
            // TODO this is untested
            // this is a user defined attribute
            // or its value can be derived, which is pretty much the same.
            // we expend the attribute like we did with user defined operations
            DerExpressionTW derExprTW = new DerExpressionTW( this.connection );
            // TODO get the derived value expression
            OclExpression derExpr = null;
            Set<SubExpression> currSubExprs = derExprTW.determineSubExpressions( derExpr, this.statement, sourceTag );
            Set<SubExpression> accSubExprs = derExprTW.getAccumulatedSubExprs( );
            tag.getCurrentSubExprs( ).addAll( currSubExprs );
            tag.addToAccumulated( accSubExprs );
        } else {
            copySubExprs( sourceTag, tag );
            // add this node to the current sub expressions
            addNodeToCurrSubExprs( exp, tag );

        } // end if
        // mark this node as visited
        tag.setVisited( );
    }

    /**
     * @param tag
     */
    private void markAsClassSubExp( SubExprTag tag ) {

        // in lack of any better ideas it is
        // mark as CLASS sub expression.
        for ( Iterator<SubExpression> i = tag.getCurrentSubExprs( ).iterator( ); i.hasNext( ); ) {
            SubExpression subExp = i.next( );
            subExp.setKind( ExpressionKind.CLASS );
        }
    }

    /**
     * @param exp
     * @param tag
     * @param tupleLiteral
     */
    private void handleTupleLiteral( AttributeCallExp exp, SubExprTag tag, TupleLiteralExp tupleLiteral ) {

        // Find the right sub-expression for the name of the attribute.
        // Therefore find the variable declaration i.e. tuple part
        // which defines the variable with the name of the attribute
        JmiList<VariableDeclaration> tupleParts = (JmiList<VariableDeclaration>) ( (TupleLiteralExpImpl) tupleLiteral ).getTuplePart( this.connection );
        for ( Iterator<VariableDeclaration> i = tupleParts.iterator( this.connection ); i.hasNext( ); ) {
            VariableDeclaration tuplePart = i.next( );
            SubExprTag partTag = getTag( tuplePart );
            if ( tuplePart.getVarName( ).equals( ( (AttributeCallExpImpl) exp ).getReferredAttribute( this.connection ).getName( ) ) ) {
                // Found the right declaration.
                // Copy all current sub-expression of the tuple part
                // and add them to the current sub-expressions of this node.
                for ( Iterator<SubExpression> i2 = partTag.getCurrentSubExprs( ).iterator( ); i2.hasNext( ); ) {
                    SubExpression subExp = i2.next( );
                    tag.addToCurrent( subExp.copy( ) );
                }
                copySubExprs( partTag, tag );
            } // end if
        } // end for
    }

    @Override
    protected void upCollectionItem( CollectionItem item ) {

        super.upCollectionItem( item );

    }

    @Override
    protected void upCollectionLiteralExp( CollectionLiteralExp exp ) {

        // TODO do something really smart here!!!
        // for now we start a new DirectSubExpression with CLASS relevance
        // so we do nothing wrong!
        SubExprTag tag = getTag( exp );
        SubExpression subExp = new DirectSubExpression( this.connection, this.statement );
        subExp.setKind( ExpressionKind.CLASS );
        tag.addToCurrent( subExp );
        // mark this node as visited
        tag.setVisited( );
    }

    @Override
    protected void upCollectionRange( CollectionRange range ) {

        // applies only to primitive types
    }

    @Override
    protected void upEnumLiteralExp( EnumLiteralExp exp ) {

        super.upEnumLiteralExp( exp );
    }

    @Override
    protected void upIfExp( IfExp exp ) {

        SubExprTag tag = getTag( exp );
        SubExprTag condTag = getTag( ( (IfExpImpl) exp ).getCondition( this.connection ) );
        SubExprTag thenTag = getTag( ( (IfExpImpl) exp ).getThenExpression( this.connection ) );
        SubExprTag elseTag = getTag( ( (IfExpImpl) exp ).getElseExpression( this.connection ) );
        // pass up the union of sub expressions of conditon, then and else
        copySubExprs( condTag, tag );
        copySubExprs( thenTag, tag );
        copySubExprs( elseTag, tag );
        // // add this node to the current sub expressions
        // for (Iterator i = tag.getCurrentSubExprs().iterator(); i.hasNext();)
        // {
        // SubExpression currSubExp = (SubExpression) i.next();
        // currSubExp.getExpressionParts().add(exp);
        // }
        // mark this node as visited
        tag.setVisited( );
    }

    @Override
    protected void upIterateExp( IterateExp exp ) {

        upLoopExp( exp );
    }

    @Override
    protected void upIteratorExp( IteratorExp exp ) {

        upLoopExp( exp );
    }

    @Override
    protected void upLetExp( LetExp exp ) {

        SubExprTag tag = getTag( exp );
        SubExprTag inTag = getTag( ( (LetExpImpl) exp ).getIn( this.connection ) );
        // pass up the sub expression attached to the inExp
        copySubExprs( inTag, tag );
        // mark this node as visited
        tag.setVisited( );
    }

    /**
     * handles a LoopExp
     * 
     * @param exp the LoopExp to handle
     */
    protected void upLoopExp( LoopExp exp ) {

        SubExprTag tag = getTag( exp );
        SubExprTag bodyTag = null;
        SubExprTag sourceTag = null;
        if ( exp instanceof IterateExp ) {
            bodyTag = getTag( ( (IterateExpImpl) exp ).getBody( this.connection ) );
            sourceTag = getTag( ( (IterateExpImpl) exp ).getSource( this.connection ) );
        } else {
            bodyTag = getTag( ( (IteratorExpImpl) exp ).getBody( this.connection ) );
            sourceTag = getTag( ( (IteratorExpImpl) exp ).getSource( this.connection ) );
        }
        Set<SubExpression> accSubExp = new HashSet<SubExpression>( );
        Set<SubExpression> foundAParent = new HashSet<SubExpression>( );
        accSubExp.addAll( bodyTag.getAccumulatedSubExprs( ) );
        accSubExp.addAll( bodyTag.getCurrentSubExprs( ) );
        // copy all accumulated and all current sub expressions form source
        copySubExprs( sourceTag, tag );
        // for all sub expressions attached to body
        for ( Iterator<SubExpression> i = accSubExp.iterator( ); i.hasNext( ); ) {
            SubExpression bodySubExp = i.next( );
            // find out which sub expression is a child of one of
            // the current sub expressions
            if ( bodySubExp instanceof IndirectSubExpression ) {
                IndirectSubExpression isub = (IndirectSubExpression) bodySubExp;
                for ( Iterator<SubExpression> j = tag.getCurrentSubExprs( ).iterator( ); j.hasNext( ); ) {
                    SubExpression currSubExp = j.next( );
                    if ( isub.isChildOf( exp ) ) {
                        // exp is the parent of isub
                        isub.addParentExpression( currSubExp );
                        currSubExp.getChildSubExp( ).add( isub );
                        isub.setKind( currSubExp.getKind( ) );
                        foundAParent.add( isub );
                    } // end if
                } // end for
            } // end if
        } // end for

        // remove all sub expressions which found a parent from the node's sub
        // expressions
        accSubExp.removeAll( foundAParent );
        // add the remaining accumulated sub expressions of the body to the
        // current
        // tag,
        // TODO does this properly handle explicit uses of accumulator in body expression? Wouldn't this have to lead to a recursive backward path definition?
        tag.addToAccumulated( accSubExp );
        // add this node to the current sub expressions
        addNodeToCurrSubExprs( exp, tag );
        // mark this node as visited
        tag.setVisited( );
    }

    @Override
    protected void upOperationCallExp( OperationCallExp exp ) {

        if ( ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ).equals( OclConstants.OP_ALLINSTANCES ) ) {
            upAllInstances( exp );
        } else if ( isStdLibOperation( exp ) ) {
            upStdLibOperation( exp );
        } else if ( isUserDefinedOperation( exp ) ) {
            upUserDefinedOp( exp );
        }
    }

    /**
     * handles a operation resulting in a primitive type
     * 
     * @param exp the OperationCallExp
     */
    protected void upPrimitiveTypeOp( OperationCallExp exp ) {

        SubExprTag tag = getTag( exp );
        SubExprTag sourceTag = getTag( ( (OperationCallExpImpl) exp ).getSource( this.connection ) );
        // the operation call results in a non-object type
        // this ends all current subexpressions
        // pass up the union of sub expressions of arguments and source
        JmiList<OclExpression> args = (JmiList<OclExpression>) ( (OperationCallExpImpl) exp ).getArguments( this.connection );
        for ( int i = 0, n = args.size( this.connection.getSession( ) ); i < n; i++ ) {
            OclExpression argExp = args.get( this.connection.getSession( ), i );
            SubExprTag argTag = getTag( argExp );
            copySubExprs( argTag, tag );
        }
        copySubExprs( sourceTag, tag );
        // end all sub expressions
        tag.addToAccumulated( tag.getCurrentSubExprs( ) );
        // eliminate current sub expressions
        tag.getCurrentSubExprs( ).clear( );
        // mark this node as visited
        tag.setVisited( );
    }

    /**
     * handles a standard library operation
     * 
     * @param exp the OperationCallExp referring to a standard library operation
     */
    protected void upStdLibOperation( OperationCallExp exp ) {

        SubExprTag tag = getTag( exp );
        SubExprTag sourceTag = getTag( ( (OperationCallExpImpl) exp ).getSource( this.connection ) );
        // all current sub expressions are continued.
        // forward sub expressions.
        copySubExprs( sourceTag, tag );
        // 
        JmiList<OclExpression> args = (JmiList<OclExpression>) ( (OperationCallExpImpl) exp ).getArguments( this.connection );
        for ( int i = 0, n = args.size( this.connection.getSession( ) ); i < n; i++ ) {
            OclExpression argExp = args.get( this.connection.getSession( ), i );
            SubExprTag argTag = getTag( argExp );
            copySubExprs( argTag, tag );
        }
        if ( isPrimitiveType( getReturnType( ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ) ) ) ) {
            // this is an operation with a primitive return type
            // end all sub expressions
            tag.addToAccumulated( tag.getCurrentSubExprs( ) );
            tag.getCurrentSubExprs( ).clear( );
        }
        // decide how to classify the subexpression
        if ( ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ).equals( OclConstants.OP_PRODUCT ) ) {
            // this is an ugly operation!
            // in lack of any better ideas it is
            // mark as CLASS sub expression.
            markAsClassSubExp( tag );
        } // end if
        // add this node to the current sub expressions
        addNodeToCurrSubExprs( exp, tag );
        // mark this node as visited
        tag.setVisited( );
    }

    @Override
    protected void upTupleLiteralExp( TupleLiteralExp exp ) {

        SubExprTag tag = getTag( exp );
        JmiList<VariableDeclaration> tupleParts = (JmiList<VariableDeclaration>) ( (TupleLiteralExpImpl) exp ).getTuplePart( this.connection );
        for ( Iterator<VariableDeclaration> i = tupleParts.iterator( this.connection ); i.hasNext( ); ) {
            VariableDeclaration tuplePart = i.next( );
            SubExprTag partTag = getTag( tuplePart );
            copySubExprs( tag, partTag );
        }
        // mark this node as visited
        tag.setVisited( );
    }

    @Override
    protected void upTypeExp( TypeExp exp ) {

        // don't care about TypeExp
    }

    /**
     * handles a user defined operation
     * 
     * @param exp OperationCallExp referring to a user defined operation
     */
    protected void upUserDefinedOp( OperationCallExp exp ) {

        // TODO this method has to be adapted to how the parser attaches
        // user-defined operations.
        // this has not been decided yet!
        // TODO this is untested!

        SubExprTag tag = getTag( exp );
        SubExprTag sourceTag = getTag( ( (OperationCallExpImpl) exp ).getSource( this.connection ) );
        // op is a user-defined operation
        // forward sub expressions
        copySubExprs( sourceTag, tag );

        // The idea is to expand a user defined operation. We do that by
        // applying this algorithm recursively to the body expression.
        // We supply the tags of the arguments. The sub expressions
        // attached to the arguments are then continued and the resulting
        // sub expressions are returned.
        // TODO how does this work for recursive operations?
        Operation op = ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection );
        // get the body definition of the operation
        OclExpression bodyExpr = getBodyExpr( op );
        BodyExpressionTW opBodySubExprTW = new BodyExpressionTW( this.connection, this.visitedFeatures );
        List<SubExprTag> argTags = new Vector<SubExprTag>( );
        // get the tags attached to the arguments
        JmiList<OclExpression> args = (JmiList<OclExpression>) ( (OperationCallExpImpl) exp ).getArguments( this.connection );
        for ( int i = 0, n = args.size( this.connection.getSession( ) ); i < n; i++ ) {
            OclExpression arg = args.get( this.connection.getSession( ), i );
            argTags.add( getTag( arg ) );
        }
        // determine sub expressions
        Set<SubExpression> userDefSubExprs = opBodySubExprTW.determineSubExpressions( op, bodyExpr, this.statement, sourceTag, argTags );
        Set<SubExpression> accuSubExprs = opBodySubExprTW.getAccumulatedSubExprs( );
        // attach the new sub expressions to the node
        tag.addToCurrent( userDefSubExprs );
        tag.addToAccumulated( accuSubExprs );

        if ( isPrimitiveType( getReturnType( ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ) ) ) ) {
            // this is an operation with a primitive return type
            // end all sub expressions
            tag.addToAccumulated( tag.getCurrentSubExprs( ) );
            tag.getCurrentSubExprs( ).clear( );
        }
        // mark this node as visited
        tag.setVisited( );
    }

    @Override
    protected void upVariableDeclaration( VariableDeclaration decl ) {

        SubExprTag tag = getTag( decl );
        OclExpression initExpr = ( (VariableDeclarationImpl) decl ).getInitExpression( this.connection );
        if ( initExpr != null ) {
            SubExprTag initTag = getTag( initExpr );
            copySubExprs( initTag, tag );
        }
        // mark this node as visited
        tag.setVisited( );
    }

    @Override
    protected void upVariableExp( VariableExp exp ) {

        SubExprTag tag = getTag( exp );
        VariableDeclarationImpl varDecl = (VariableDeclarationImpl) ( (VariableExpImpl) exp ).getReferredVariable( this.connection );
        // order of the if statements is crucial! Someone could have defined
        // a iterator variable "self"
        if ( varDecl.getLoopExpr( this.connection ) != null ) {
            // variable is an iterator variable
            // create indirect sub expression
            SubExpression subExp = new IndirectSubExpression( this.connection, this.statement );
            subExp.setKind( ExpressionKind.INSTANCE );
            // TODO (d043530) why is the variable expression added here in the first place? What about the loop's source? Shouldn't its expressions be copied?
            subExp.addExpressionParts( exp );
            // pass sub expression up the tree
            tag.getCurrentSubExprs( ).add( subExp );
        } else if ( varDecl.getVarName( ).equals( OclConstants.VAR_SELF ) && varDecl.getInitExpression( this.connection ) == null ) {
            // variable is self
            // create direct sub expression
            SubExpression subExp = new DirectSubExpression( this.connection, this.statement );
            subExp.setKind( ExpressionKind.INSTANCE );
            subExp.addExpressionParts( exp );
            // pass sub expression up the tree
            tag.addToCurrent( subExp );
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
        // mark this node as visited
        tag.setVisited( );
    }
}