package de.hpi.sam.bp2009.moin.impactAnalyzer.analysis;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.ocl.ecore.OCLExpression;
import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.BooleanLiteralExp;
import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.CollectionRange;
import org.omg.ocl.expressions.EnumLiteralExp;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.LetExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.RealLiteralExp;
import org.omg.ocl.expressions.StringLiteralExp;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpImpl;
import org.omg.ocl.expressions.__impl.AttributeCallExpImpl;
import org.omg.ocl.expressions.__impl.CollectionItemImpl;
import org.omg.ocl.expressions.__impl.CollectionLiteralExpImpl;
import org.omg.ocl.expressions.__impl.CollectionRangeImpl;
import org.omg.ocl.expressions.__impl.IfExpImpl;
import org.omg.ocl.expressions.__impl.IterateExpImpl;
import org.omg.ocl.expressions.__impl.IteratorExpImpl;
import org.omg.ocl.expressions.__impl.LetExpImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;
import org.omg.ocl.expressions.__impl.VariableExpInternal;

import de.hpi.sam.bp2009.moin.impactAnalyzer.tag.NodeTag;
import de.hpi.sam.bp2009.moin.impactAnalyzer.tag.NodeTagFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

/**
 * ClassScopeAnalysis identifies the kind of events (InternalEvents) for which
 * an OclStatement has to be reevaluated.
 * <p>
 * To do so, it walks the tree in depth-first bottom-up manner and attaches
 * InternalEvents to some of the AST-nodes. For attaching events to the AST
 * NodeTags are used.
 */
public class ClassScopeAnalysis extends TreeWalker {

    /**
     * The set of accumulated events
     */
    private final Set<ModelChangeEvent> accumulatedEvents = new HashSet<ModelChangeEvent>( );

    /**
     * The event factory
     */
    private final EventManagerFactory eventFactory;

    /**
     * The tag factory
     */
    private final NodeTagFactory tagFactory;

    /**
     * Set of analyzed user defined operation bodies to protect IA to run into
     * infinite recursion when operations are defined recursively
     */
    private Set<OCLExpression> analyzedUserOps;

    /**
     * Creates an new instance of the class scope analysis
     * 
     * @param actConnection the core connection
     * @param theEventFactory the factory to create InternalEvents
     * @param theTagFactory the factory to create NodeTags
     * @param theAnalyzedUserOps used by recursive calls
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#TreeWalker(CoreConnection)
     */
    public ClassScopeAnalysis( EventManagerFactory theEventFactory, NodeTagFactory theTagFactory, Set<OCLExpression> theAnalyzedUserOps ) {

        super( );
        this.eventFactory = theEventFactory;
        this.tagFactory = theTagFactory;
        this.analyzedUserOps = theAnalyzedUserOps;
    }

    /**
     * Starts walking the tree and collecting relevant events. use
     * <tt>getAccumulatedEvents()</tt> to get the collected events.
     * 
     * @param root the root of the OCL AST to walk
     * @return the set of relevant Internal Events
     */
    public Set<ModelChangeEvent> analyze( OCLExpression root ) {

        // to avoid getting into cycles (e.g. by recursively defined operations)
        // check whether this subtree has already been visited
        NodeTag tag = getTag( root );
        if ( tag == null || !tag.isVisited( ) ) {
            // sub tree has not been visited yet
            super.walk( root );
        }
        tag = getTag( root );
        return tag.getAccumulatedEvents( );
    }

    /**
     * @return Returns the result.
     */
    public Set<ModelChangeEvent> getAccumulatedEvents( ) {

        return this.accumulatedEvents;
    }

    /**
     * Visits a AssociationEndCallExp and determines the relevant Events for
     * this node. Relevant Events are:
     * <ul>
     * <li>InsertRT</li>
     * <li>DeleteRT</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upAssociationEndCallExp(org.omg.ocl.expressions.AssociationEndCallExp)
     */
    @Override
    protected void upAssociationEndCallExp( AssociationEndCallExp exp ) {

        NodeTag tag = this.tagFactory.createTag( exp );

        AssociationEnd assocEnd = ( (AssociationEndCallExpImpl) exp ).getReferredAssociationEnd( this.connection );
        tag.getEvents( ).add( this.eventFactory.createInsertRT( this.connection, assocEnd, (MofClassImpl) ((OclExpressionInternal) ( (AssociationEndCallExpImpl) exp ).getSource(this.connection)).getType(this.connection) ) );
        tag.getEvents( ).add( this.eventFactory.createDeleteRT( this.connection, assocEnd, (MofClassImpl) ((OclExpressionInternal) ( (AssociationEndCallExpImpl) exp ).getSource(this.connection)).getType(this.connection) ) );
        tag.getAccumulatedEvents( ).addAll( tag.getEvents( ) );
        // add the child node's events
        NodeTag sourceTag = getTag( ( (AssociationEndCallExpImpl) exp ).getSource( this.connection ) );
        if ( sourceTag != null ) {
            tag.getAccumulatedEvents( ).addAll( sourceTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a AssociationEndCallExp and determines the relevant Events for
     * this node. Relevant Events are:
     * <ul>
     * <li>UpdateAttribute</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upAttributeCallExp(org.omg.ocl.expressions.AttributeCallExp)
     */
    @Override
    protected void upAttributeCallExp( AttributeCallExp exp ) {

        NodeTag tag = this.tagFactory.createTag( exp );
        // add the relevant events for this node
        Classifier sourceType = ((AttributeCallExpImpl) exp).getSource(this.connection).getType(); // may be a tuple / structure type or a class
        UpdateAttribute upd;
	if (sourceType instanceof MofClassImpl) {
	    upd = this.eventFactory.createUpdateAttribute(this.connection, ((AttributeCallExpImpl) exp)
		    .getReferredAttribute(this.connection), (MofClassImpl) sourceType);
	} else {
	    upd = this.eventFactory.createUpdateAttribute(this.connection, ((AttributeCallExpImpl) exp)
		    .getReferredAttribute( this.connection ));
        }
        tag.getEvents( ).add( upd );
        tag.getAccumulatedEvents( ).addAll( tag.getEvents( ) );
        // add the child node's events
        NodeTag sourceTag = getTag( ( (AttributeCallExpImpl) exp ).getSource( this.connection ) );
        if ( sourceTag != null ) {
            tag.getAccumulatedEvents( ).addAll( sourceTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>BooleanLiteralExp</tt> and determines the relevant events
     * for this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upBooleanLiteralExp(org.omg.ocl.expressions.BooleanLiteralExp)
     */
    @Override
    protected void upBooleanLiteralExp( BooleanLiteralExp exp ) {

        this.tagFactory.createTag( exp );
        // nothing to be done here!

    }

    /**
     * Visits a <tt>CollectionItem</tt> and determines the relevant events for
     * this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upCollectionItem(org.omg.ocl.expressions.CollectionItem)
     */
    @Override
    protected void upCollectionItem( CollectionItem item ) {

        // forward attributes
        NodeTag tag = this.tagFactory.createTag( item );
        // add the child node's events
        NodeTag itemTag = getTag( ( (CollectionItemImpl) item ).getItem( this.connection ) );
        if ( itemTag != null ) {
            tag.getAccumulatedEvents( ).addAll( itemTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>CollectionLiteralExp</tt> and determines the relevant events
     * for this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upCollectionLiteralExp(org.omg.ocl.expressions.CollectionLiteralExp)
     */
    @Override
    protected void upCollectionLiteralExp( CollectionLiteralExp exp ) {

        // forward attributes
        NodeTag tag = this.tagFactory.createTag( exp );
        // add the child node's events
        JmiList<CollectionLiteralPart> parts = (JmiList<CollectionLiteralPart>) ( (CollectionLiteralExpImpl) exp ).getParts( this.connection );
        for ( int i = 0, n = parts.size( this.connection.getSession( ) ); i < n; i++ ) {
            Object ob = parts.get( this.connection.getSession( ), i );
            NodeTag partTag = getTag( (RefObject) ob );
            if ( partTag != null ) {
                tag.getAccumulatedEvents( ).addAll( partTag.getAccumulatedEvents( ) );
            }
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>CollectionRange</tt> and determines the relevant events for
     * this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upCollectionRange(org.omg.ocl.expressions.CollectionRange)
     */
    @Override
    protected void upCollectionRange( CollectionRange range ) {

        // forward attributes
        NodeTag tag = this.tagFactory.createTag( range );
        // add the child node's events
        // get first's attribute
        NodeTag firstTag = getTag( ( (CollectionRangeImpl) range ).getFirst( this.connection ) );
        if ( firstTag != null ) {
            tag.getAccumulatedEvents( ).addAll( firstTag.getAccumulatedEvents( ) );
        }
        // get last's attribute
        NodeTag lastTag = getTag( ( (CollectionRangeImpl) range ).getLast( this.connection ) );
        if ( lastTag != null ) {
            tag.getAccumulatedEvents( ).addAll( lastTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>EnumLiteralExp</tt> and determines the relevant events for
     * this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upEnumLiteralExp(org.omg.ocl.expressions.EnumLiteralExp)
     */
    @Override
    protected void upEnumLiteralExp( EnumLiteralExp exp ) {

        this.tagFactory.createTag( exp );
        // nothing to be done
    }

    /**
     * Visits a <tt>IfExp</tt> and determines the relevant events for this node.
     * Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upIfExp(org.omg.ocl.expressions.IfExp)
     */
    @Override
    protected void upIfExp( IfExp exp ) {

        // we just forward the events

        NodeTag tag = this.tagFactory.createTag( exp );
        // add the child node's events
        // get condition's attribute
        NodeTag conditionTag = getTag( ( (IfExpImpl) exp ).getCondition( this.connection ) );
        if ( conditionTag != null ) {
            tag.getAccumulatedEvents( ).addAll( conditionTag.getAccumulatedEvents( ) );
        }

        // get thenExpression's attribute
        NodeTag thenExpTag = getTag( ( (IfExpImpl) exp ).getThenExpression( this.connection ) );
        if ( thenExpTag != null ) {
            tag.getAccumulatedEvents( ).addAll( thenExpTag.getAccumulatedEvents( ) );
        }

        // get elseExpression's attribute
        NodeTag elseExpTag = getTag( ( (IfExpImpl) exp ).getElseExpression( this.connection ) );
        if ( elseExpTag != null ) {
            tag.getAccumulatedEvents( ).addAll( elseExpTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>IntegerLiteralExp</tt> and determines the relevant events
     * for this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upIntegerLiteralExp(org.omg.ocl.expressions.IntegerLiteralExp)
     */
    @Override
    protected void upIntegerLiteralExp( IntegerLiteralExp exp ) {

        this.tagFactory.createTag( exp );
        // nothing to do here
    }

    /**
     * Visits a <tt>IntegerLiteralExp</tt> and determines the relevant events
     * for this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upIterateExp(org.omg.ocl.expressions.IterateExp)
     */
    @Override
    protected void upIterateExp( IterateExp exp ) {

        // we just forward the events

        NodeTag tag = this.tagFactory.createTag( exp );
        // add the child node's events
        // get the source's attribute
        NodeTag sourceTag = getTag( ( (IterateExpImpl) exp ).getSource( this.connection ) );
        if ( sourceTag != null ) {
            tag.getAccumulatedEvents( ).addAll( sourceTag.getAccumulatedEvents( ) );
        }

        // get the body's attribute
        NodeTag bodyTag = getTag( ( (IterateExpImpl) exp ).getBody( this.connection ) );
        if ( bodyTag != null ) {
            tag.getAccumulatedEvents( ).addAll( bodyTag.getAccumulatedEvents( ) );
        }

        // get result's attribute
        NodeTag resultTag = getTag( ( (IterateExpImpl) exp ).getResult( this.connection ) );
        if ( resultTag != null ) {
            tag.getAccumulatedEvents( ).addAll( resultTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>IteratorExp</tt> and determines the relevant events for this
     * node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upIteratorExp(org.omg.ocl.expressions.IteratorExp)
     */
    @Override
    protected void upIteratorExp( IteratorExp exp ) {

        // we just forward the events

        NodeTag tag = this.tagFactory.createTag( exp );
        // add the child node's events
        // get the source's attribute
        NodeTag sourceTag = getTag( ( (IteratorExpImpl) exp ).getSource( this.connection ) );
        if ( sourceTag != null ) {
            tag.getAccumulatedEvents( ).addAll( sourceTag.getAccumulatedEvents( ) );
        }

        // get body's attribute
        NodeTag bodyTag = getTag( ( (IteratorExpImpl) exp ).getBody( this.connection ) );
        if ( bodyTag != null ) {
            tag.getAccumulatedEvents( ).addAll( bodyTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>LetExp</tt> and determines the relevant events for this
     * node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upLetExp(org.omg.ocl.expressions.LetExp)
     */
    @Override
    protected void upLetExp( LetExp exp ) {

        // we just forward the events

        NodeTag tag = this.tagFactory.createTag( exp );
        // add the child node's events
        // get in's attribute
        NodeTag inTag = getTag( ( (LetExpImpl) exp ).getIn( this.connection ) );
        if ( inTag != null ) {
            tag.getAccumulatedEvents( ).addAll( inTag.getAccumulatedEvents( ) );
        }

        // get the variable's attribute
        NodeTag variableTag = getTag( ( (LetExpImpl) exp ).getVariable( this.connection ) );
        if ( variableTag != null ) {
            tag.getAccumulatedEvents( ).addAll( variableTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>OperationCallExp</tt> and determines the relevant events for
     * this node. Relevant Events are:
     * <ul>
     * <li>InsertET if this is an <code>allInstances()</code> call.</li>
     * <li>DeleteET if this is an <code>allInstances()</code> call.</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upOperationCallExp(org.omg.ocl.expressions.OperationCallExp)
     */
    @Override
    protected void upOperationCallExp( OperationCallExp exp ) {

        // we just forward the events

        NodeTag tag = this.tagFactory.createTag( exp );
        // add the child node's events
        // get source's attribute
        NodeTag sourceTag = getTag( ( (OperationCallExpImpl) exp ).getSource( this.connection ) );
        if ( sourceTag != null ) {
            tag.getAccumulatedEvents( ).addAll( sourceTag.getAccumulatedEvents( ) );
        }

        // if this is an allInstances() call we have to add some events
        if ( ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ).equals( OclConstants.OP_ALLINSTANCES ) ) {
            OclExpression source = ( (OperationCallExpImpl) exp ).getSource( this.connection );
            Classifier type = null;
            if ( source instanceof TypeExp ) {
                type = ( (TypeExpImpl) source ).getReferredType( this.connection );
            } else {
                type = ( (OclExpressionInternal) source ).getType( this.connection );
            }
            tag.getEvents( ).addAll( this.eventFactory.createAllInsertET( this.connection, (MofClass) type ) );
            tag.getEvents( ).addAll( this.eventFactory.createAllDeleteET( this.connection, (MofClass) type ) );
            tag.getAccumulatedEvents( ).addAll( tag.getEvents( ) );
        } else {
            // this will check if it's a user defined operation and analyze the
            // body
            Set<InternalEvent> events = analyzeOperationBody( exp );
            tag.getEvents( ).addAll( events );
            tag.getAccumulatedEvents( ).addAll( events );
        }
        // get the the parameter's attributes
        JmiList<OclExpression> args = (JmiList<OclExpression>) ( (OperationCallExpImpl) exp ).getArguments( this.connection );
        for ( int i = 0, n = args.size( this.connection.getSession( ) ); i < n; i++ ) {
            Object ob = args.get( this.connection.getSession( ), i );
            NodeTag argTag = getTag( (RefObject) ob );
            if ( argTag != null ) {
                tag.getAccumulatedEvents( ).addAll( argTag.getAccumulatedEvents( ) );
            }
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>RealLiteralExp</tt> and determines the relevant events for
     * this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upRealLiteralExp(org.omg.ocl.expressions.RealLiteralExp)
     */
    @Override
    protected void upRealLiteralExp( RealLiteralExp exp ) {

        this.tagFactory.createTag( exp );
        // nothing to be done
    }

    /**
     * Visits a <tt>StringLiteralExp</tt> and determines the relevant events for
     * this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upStringLiteralExp(org.omg.ocl.expressions.StringLiteralExp)
     */
    @Override
    protected void upStringLiteralExp( StringLiteralExp exp ) {

        this.tagFactory.createTag( exp );
        // nothing to be done
    }

    /**
     * Visits a <tt>TupleLiteralExp</tt> and determines the relevant events for
     * this node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upTupleLiteralExp(org.omg.ocl.expressions.TupleLiteralExp)
     */
    @Override
    protected void upTupleLiteralExp( TupleLiteralExp exp ) {

        // forward attributes
        NodeTag tag = this.tagFactory.createTag( exp );
        // add the tupleParts' events
        JmiList<VariableDeclaration> tuplePart = (JmiList<VariableDeclaration>) ( (TupleLiteralExpImpl) exp ).getTuplePart( this.connection );
        for ( Iterator<VariableDeclaration> it = tuplePart.iterator( this.connection ); it.hasNext( ); ) {
            VariableDeclaration ob = it.next( );
            NodeTag tuplePartTag = getTag( ob );
            if ( tuplePartTag != null ) {
                tag.getAccumulatedEvents( ).addAll( tuplePartTag.getAccumulatedEvents( ) );
            }
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>TypeExp</tt> and determines the relevant events for this
     * node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upTypeExp(org.omg.ocl.expressions.TypeExp)
     */
    @Override
    protected void upTypeExp( TypeExp exp ) {

        this.tagFactory.createTag( exp );
        // nothing to be done
    }

    /**
     * Visits a <tt>VariableDeclaration</tt> and determines the relevant events
     * for this node. Relevant Events are:
     * <ul>
     * <li>InsertET if this is <code>self</code></li>
     * <li>DeleteET if this is <code>self</code></li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upVariableDeclaration(org.omg.ocl.expressions.VariableDeclaration)
     */
    @Override
    protected void upVariableDeclaration( VariableDeclaration decl ) {

        // we just forward the events

        NodeTag tag = this.tagFactory.createTag( decl );
        // add the child node's events
        // get initExpression's attribute
        NodeTag initTag = getTag( ( (VariableDeclarationImpl) decl ).getInitExpression( this.connection ) );
        if ( initTag != null ) {
            tag.getAccumulatedEvents( ).addAll( initTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Visits a <tt>VariableExp</tt> and determines the relevant events for this
     * node. Relevant Events are:
     * <ul>
     * <li>None</li>
     * </ul>
     * 
     * @see com.sap.tc.moin.ocl.utils.treewalker.TreeWalker#upVariableExp(org.omg.ocl.expressions.VariableExp)
     */
    @Override
    protected void upVariableExp( VariableExp _exp ) {

        // we just forward the events
        VariableExpInternal exp = (VariableExpInternal) _exp;

        NodeTag tag = this.tagFactory.createTag( exp );
        // add the child node's events
        NodeTag varDeclTag = getTag( exp.getReferredVariable( this.connection ) );
        // if this is a reference to "self"
        // insertET<Type of self> is relevant
        if ( exp.getReferredVariable( this.connection ).getVarName( ).equals( OclConstants.VAR_SELF ) ) {
            // the type can be a TupleType if the underlying variable was a StructureField
            // since structures are not relevant for the impact analysis, they can be ignored
            Classifier type = ( (VariableDeclarationInternal) exp.getReferredVariable( this.connection ) ).getType( this.connection );
            if ( type instanceof MofClass ) {
                MofClass clazz = (MofClass) type;
                tag.getEvents( ).addAll( this.eventFactory.createAllInsertET( this.connection, clazz ) );
                tag.getAccumulatedEvents( ).addAll( tag.getEvents( ) );
            }
        }
        if ( varDeclTag != null ) {
            tag.getAccumulatedEvents( ).addAll( varDeclTag.getAccumulatedEvents( ) );
        }
        // mark node as visited
        tag.setVisited( );
    }

    /**
     * Checks if the expression refers to a user defined operation and analyzes
     * its body to find the relevant <tt>InternalEvents</tt>.
     * 
     * @param exp The OperationCallExp to check
     * @return the set of relevant InternalEvents or an empty <code>Set</code>
     */
    private Set<InternalEvent> analyzeOperationBody( OperationCallExp exp ) {

        Operation op = ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection );
        OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) this.connection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR );
        OclExpression bodyExpr = assoc.getBody( this.connection, op );
        if ( bodyExpr == null ) {
            return Collections.emptySet( );
        }
        if ( this.analyzedUserOps.contains( bodyExpr ) ) {
            // this operation is defined recursively
            // we don't analyze it again
            return Collections.emptySet( );
        }
        // add this operation's body to the set of analyzed operations
        // to prevent endless recursion.
        this.analyzedUserOps.add( bodyExpr );
        ClassScopeAnalysis csa = new ClassScopeAnalysis( this.connection, this.eventFactory, this.tagFactory, this.analyzedUserOps );
        // apply ClassScopeAnalysis to the body
        return csa.analyze( bodyExpr );
    }

    /**
     * Returns the UpAttribute which is attached to node <tt>node</tt>.
     * 
     * @param node a node in the tree
     * @return the UpAttribute of node <tt>node</tt> or <tt>null</tt> if no
     * attribute has been attached.
     */
    private NodeTag getTag( RefObject node ) {

        if ( node == null ) {
            return null;
        }
        return this.tagFactory.getTag( node );
    }
}
