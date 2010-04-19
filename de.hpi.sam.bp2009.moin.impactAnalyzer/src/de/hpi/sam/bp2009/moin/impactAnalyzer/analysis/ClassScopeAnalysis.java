package de.hpi.sam.bp2009.moin.impactAnalyzer.analysis;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.impl.CollectionItemImpl;
import org.eclipse.ocl.ecore.impl.CollectionRangeImpl;
import org.eclipse.ocl.ecore.impl.IfExpImpl;
import org.eclipse.ocl.ecore.impl.IterateExpImpl;
import org.eclipse.ocl.ecore.impl.IteratorExpImpl;
import org.eclipse.ocl.ecore.impl.LetExpImpl;
import org.eclipse.ocl.ecore.impl.NavigationCallExpImpl;
import org.eclipse.ocl.ecore.impl.OperationCallExpImpl;
import org.eclipse.ocl.ecore.impl.TypeExpImpl;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.parser.OCLParsersym;

import de.hpi.sam.bp2009.moin.impactAnalyzer.tag.NodeTag;
import de.hpi.sam.bp2009.moin.impactAnalyzer.tag.NodeTagFactory;
import de.hpi.sam.bp2009.moin.impactAnalyzer.treewalker.TreeWalker;
import de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.LinkCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.LinkDeleteEvent;
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
    protected void upAssociationEndCallExp( NavigationCallExp exp ) {

        NodeTag tag = this.tagFactory.createTag( exp );

        //FIXME check correctness
        EReference assoc =  ((EReference)exp.getNavigationSource());
        //AssociationEnd assocEnd = ( (AssociationEndCallExpImpl) exp ).getReferredAssociationEnd( this.connection );
        //tag.getEvents( ).add( this.eventFactory.createInsertRT( assocEnd, exp.getSource().getType() ) );
        //tag.getEvents( ).add( this.eventFactory.createDeleteRT( assocEnd, exp.getSource().getType() ) );
        LinkCreateEvent linkCreate = EventManagerFactory.eINSTANCE.createLinkCreateEvent();
        linkCreate.setChangedClass(exp.getSource().eClass());
        linkCreate.setChangedReference(assoc);
        linkCreate.setCorrespondingObject(assoc.getEReferenceType());
        linkCreate.setSourceObject(exp);
        LinkDeleteEvent linkDelete = EventManagerFactory.eINSTANCE.createLinkDeleteEvent();
        linkDelete.setChangedClass(exp.getSource().eClass());
        linkDelete.setChangedReference(assoc);
        linkDelete.setCorrespondingObject(assoc.getEReferenceType());
        linkDelete.setSourceObject(exp);
        tag.getEvents().add(linkCreate);
        tag.getEvents().add(linkDelete);
        tag.getAccumulatedEvents( ).addAll( tag.getEvents( ) );
        // add the child node's events
        NodeTag sourceTag = getTag( exp.getSource( ) );
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
    protected void upAttributeCallExp( PropertyCallExp exp ) {

        NodeTag tag = this.tagFactory.createTag( exp );
        // add the relevant events for this node
        EClassifier sourceType = exp.getSource().getType(); // may be a tuple / structure type or a class

//        if (sourceType instanceof EClassImpl) {	
//	     upd = this.eventFactory.createUpdateAttribute(this.connection, ((AttributeCallExpImpl) exp)
//		    .getReferredAttribute(this.connection), (MofClassImpl) sourceType);
//	} else {
//	    upd = this.eventFactory.createUpdateAttribute(this.connection, ((AttributeCallExpImpl) exp)
//		    .getReferredAttribute( this.connection ));
//        }
        AttributeValueChangeEvent updateAttrEvent = EventManagerFactory.eINSTANCE.createAttributeValueChangeEvent();
		updateAttrEvent.setChangedAttribute((EAttribute) exp.getReferredProperty());
		updateAttrEvent.setChangedClass(exp.eClass());
		updateAttrEvent.setSourceObject(sourceType);
        tag.getEvents( ).add( updateAttrEvent );
        tag.getAccumulatedEvents( ).addAll( tag.getEvents( ) );
        // add the child node's events
        NodeTag sourceTag = getTag( exp.getSource( ) );
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
        NodeTag itemTag = getTag( ( (CollectionItemImpl) item ).getItem( ) );
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
        EList<CollectionLiteralPart<EClassifier>> parts = exp.getPart( );
        for ( int i = 0, n = parts.size( ); i < n; i++ ) {
            CollectionLiteralPart<EClassifier> ob = parts.get( i );
            NodeTag partTag = getTag( ob );
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
        NodeTag firstTag = getTag( ( (CollectionRangeImpl) range ).getFirst( ) );
        if ( firstTag != null ) {
            tag.getAccumulatedEvents( ).addAll( firstTag.getAccumulatedEvents( ) );
        }
        // get last's attribute
        NodeTag lastTag = getTag( ( (CollectionRangeImpl) range ).getLast( ) );
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
        NodeTag conditionTag = getTag( ( (IfExpImpl) exp ).getCondition( ) );
        if ( conditionTag != null ) {
            tag.getAccumulatedEvents( ).addAll( conditionTag.getAccumulatedEvents( ) );
        }

        // get thenExpression's attribute
        NodeTag thenExpTag = getTag( ( (IfExpImpl) exp ).getThenExpression( ) );
        if ( thenExpTag != null ) {
            tag.getAccumulatedEvents( ).addAll( thenExpTag.getAccumulatedEvents( ) );
        }

        // get elseExpression's attribute
        NodeTag elseExpTag = getTag( ( (IfExpImpl) exp ).getElseExpression( ) );
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
        NodeTag sourceTag = getTag( ( (IterateExpImpl) exp ).getSource( ) );
        if ( sourceTag != null ) {
            tag.getAccumulatedEvents( ).addAll( sourceTag.getAccumulatedEvents( ) );
        }

        // get the body's attribute
        NodeTag bodyTag = getTag( ( (IterateExpImpl) exp ).getBody( ) );
        if ( bodyTag != null ) {
            tag.getAccumulatedEvents( ).addAll( bodyTag.getAccumulatedEvents( ) );
        }

        // get result's attribute
        NodeTag resultTag = getTag( ( (IterateExpImpl) exp ).getResult( ) );
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
        NodeTag sourceTag = getTag( ( (IteratorExpImpl) exp ).getSource( ) );
        if ( sourceTag != null ) {
            tag.getAccumulatedEvents( ).addAll( sourceTag.getAccumulatedEvents( ) );
        }

        // get body's attribute
        NodeTag bodyTag = getTag( ( (IteratorExpImpl) exp ).getBody( ) );
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
        NodeTag inTag = getTag( ( (LetExpImpl) exp ).getIn( ) );
        if ( inTag != null ) {
            tag.getAccumulatedEvents( ).addAll( inTag.getAccumulatedEvents( ) );
        }

        // get the variable's attribute
        NodeTag variableTag = getTag( ( (LetExpImpl) exp ).getVariable( ) );
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
        NodeTag sourceTag = getTag( ( (OperationCallExpImpl) exp ).getSource( ) );
        if ( sourceTag != null ) {
            tag.getAccumulatedEvents( ).addAll( sourceTag.getAccumulatedEvents( ) );
        }

        // if this is an allInstances() call we have to add some events
        if ( ( (OperationCallExpImpl) exp ).getReferredOperation( ).getName( ).equals( "allInstances" ) ) {
            OCLExpression source = (OCLExpression) exp.getSource( );
            EClassifier type = null;
            if ( source instanceof TypeExp ) {
                type = ( (TypeExpImpl) source ).getReferredType( );
            } else {
                type = ( (OCLExpression) source ).getType( );
            }
            //tag.getEvents( ).addAll( this.eventFactory.createAllInsertET( this.connection, (MofClass) type ) );          
            ElementCreateEvent createEvent = EventManagerFactory.eINSTANCE.createElementCreateEvent();
            createEvent.setChangedClass(exp.eClass());
            createEvent.setSourceObject(type);
            createEvent.setContainingElement(type.eContainer());
            tag.getEvents().add(createEvent);
            
            EList<EObject> containedElements = type.eContents();
            for( Iterator<EObject> i = containedElements.iterator(); i.hasNext();){
                ElementCreateEvent crEvent = EventManagerFactory.eINSTANCE.createElementCreateEvent();
                crEvent.setChangedClass(exp.eClass());
                crEvent.setSourceObject(type);
                crEvent.setContainingElement(type.eContainer());
                tag.getEvents().add(crEvent);
            }
            //tag.getEvents( ).addAll( this.eventFactory.createAllDeleteET( this.connection, (MofClass) type ) );
            ElementDeleteEvent deleteEvent = EventManagerFactory.eINSTANCE.createElementDeleteEvent();
            deleteEvent.setChangedClass(exp.eClass());
            deleteEvent.setSourceObject(type);
            deleteEvent.setContainingElement(type.eContainer());
            tag.getEvents().add(deleteEvent);
            
            containedElements = type.eContents();
            for( Iterator<EObject> i = containedElements.iterator(); i.hasNext();){
                ElementDeleteEvent dlEvent = EventManagerFactory.eINSTANCE.createElementDeleteEvent();
                dlEvent.setChangedClass(exp.eClass());
                dlEvent.setSourceObject(type);
                dlEvent.setContainingElement(type.eContainer());
                tag.getEvents().add(dlEvent);
            }
            tag.getAccumulatedEvents( ).addAll( tag.getEvents( ) );
        } else {
            // this will check if it's a user defined operation and analyze the body
            Set<ModelChangeEvent> events = analyzeOperationBody( exp );
            tag.getEvents( ).addAll( events );
            tag.getAccumulatedEvents( ).addAll( events );
        }
        // get the the parameter's attributes
        EList<org.eclipse.ocl.expressions.OCLExpression<EClassifier>> args = exp.getArgument( );
        for ( int i = 0, n = args.size( ); i < n; i++ ) {
            OCLExpression ob = (OCLExpression)args.get( i );
            NodeTag argTag = getTag( ob );
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
        EList<TupleLiteralPart<EClassifier, EStructuralFeature>> tuplePart = exp.getPart( );
        for ( Iterator<TupleLiteralPart<EClassifier, EStructuralFeature>> it = tuplePart.iterator( ); it.hasNext( ); ) {
            TupleLiteralPart<EClassifier, EStructuralFeature> ob = it.next( );
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
        NodeTag initTag = getTag( decl.getInitExpression( ) );
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
    protected void upVariableExp( VariableExp exp ) {

        // we just forward the events

        NodeTag tag = this.tagFactory.createTag( exp );
        // add the child node's events
        NodeTag varDeclTag = getTag( exp.getReferredVariable( ) );
        // if this is a reference to "self"
        // insertET<Type of self> is relevant
        if ( exp.getReferredVariable( ).getName( ).equals( OCLParsersym.orderedTerminalSymbols[OCLParsersym.TK_self] ) ) {
            // the type can be a TupleType if the underlying variable was a StructureField
            // since structures are not relevant for the impact analysis, they can be ignored
            EClassifier type = exp.getReferredVariable( ).getType( );
            if ( type instanceof EClass ) {
                EClass clazz = (EClass) type;
                //tag.getEvents( ).addAll( this.eventFactory.createAllInsertET( this.connection, clazz ) );
                
                ElementCreateEvent createEvent = EventManagerFactory.eINSTANCE.createElementCreateEvent();
                createEvent.setChangedClass(exp.eClass());
                createEvent.setSourceObject(clazz);
                createEvent.setContainingElement(clazz.eContainer());
                tag.getEvents().add(createEvent);
                
                EList<EObject> containedElements = clazz.eContents();
                for( Iterator<EObject> i = containedElements.iterator(); i.hasNext();){
                    ElementCreateEvent crEvent = EventManagerFactory.eINSTANCE.createElementCreateEvent();
                    crEvent.setChangedClass(exp.eClass());
                    crEvent.setSourceObject(clazz);
                    crEvent.setContainingElement(clazz.eContainer());
                    tag.getEvents().add(crEvent);
                }
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
    private Set<ModelChangeEvent> analyzeOperationBody( OperationCallExp exp ) {

        EOperation op = exp.getReferredOperation( );
        OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) this.connection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR );
        OCLExpression bodyExpr = assoc.getBody( op );
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
        ClassScopeAnalysis csa = new ClassScopeAnalysis( this.eventFactory, this.tagFactory, this.analyzedUserOps );
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
    private NodeTag getTag( EObject node ) {

        if ( node == null ) {
            return null;
        }
        return this.tagFactory.getTag( node );
    }
}
