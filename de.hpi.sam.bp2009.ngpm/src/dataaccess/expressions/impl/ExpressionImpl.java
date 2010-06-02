/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.ExpressionStatement;
import behavioral.actions.Iterator;

import behavioral.actions.NamedValueWithOptionalInitExpression;
import data.classes.ActualObjectParameter;
import data.classes.ClassesPackage;
import data.classes.NamedValue;
import data.classes.SapClass;

import data.classes.impl.TypedElementImpl;

import dataaccess.expressions.Conditional;
import dataaccess.expressions.Equals;
import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;

import dataaccess.expressions.WithArgument;
import dataaccess.expressions.collectionexpressions.CollectionExpression;
import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;
import dataaccess.expressions.collectionexpressions.Iterate;

import dataaccess.query.FromClause;
import dataaccess.query.OqlQuery;
import dataaccess.query.QueryPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import persistence.expressions.All;
import ui.templates.StringTemplate;
import ui.templates.TemplatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getExpressionStatement <em>Expression Statement</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getInitExpressionFor <em>Init Expression For</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getActualObjectParameter <em>Actual Object Parameter</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getArgumentOf <em>Argument Of</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getLeftOfEquals <em>Left Of Equals</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getRightOfEquals <em>Right Of Equals</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getConditional <em>Conditional</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getCollectionExpression <em>Collection Expression</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getInIterator <em>In Iterator</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getConditionOfOqlQuery <em>Condition Of Oql Query</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getFromClause <em>From Clause</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getAll <em>All</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExpressionImpl extends TypedElementImpl implements Expression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatement getExpressionStatement() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT) return null;
		return (ExpressionStatement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpressionStatement(ExpressionStatement newExpressionStatement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExpressionStatement, ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionStatement(ExpressionStatement newExpressionStatement) {
		if (newExpressionStatement != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT && newExpressionStatement != null)) {
			if (EcoreUtil.isAncestor(this, newExpressionStatement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExpressionStatement != null)
				msgs = ((InternalEObject)newExpressionStatement).eInverseAdd(this, ActionsPackage.EXPRESSION_STATEMENT__EXPRESSION, ExpressionStatement.class, msgs);
			msgs = basicSetExpressionStatement(newExpressionStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT, newExpressionStatement, newExpressionStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedValueWithOptionalInitExpression getInitExpressionFor() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR) return null;
		return (NamedValueWithOptionalInitExpression)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpressionFor(NamedValueWithOptionalInitExpression newInitExpressionFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInitExpressionFor, ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpressionFor(NamedValueWithOptionalInitExpression newInitExpressionFor) {
		if (newInitExpressionFor != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR && newInitExpressionFor != null)) {
			if (EcoreUtil.isAncestor(this, newInitExpressionFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInitExpressionFor != null)
				msgs = ((InternalEObject)newInitExpressionFor).eInverseAdd(this, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION, NamedValueWithOptionalInitExpression.class, msgs);
			msgs = basicSetInitExpressionFor(newInitExpressionFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR, newInitExpressionFor, newInitExpressionFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualObjectParameter getActualObjectParameter() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER) return null;
		return (ActualObjectParameter)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActualObjectParameter(ActualObjectParameter newActualObjectParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newActualObjectParameter, ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualObjectParameter(ActualObjectParameter newActualObjectParameter) {
		if (newActualObjectParameter != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER && newActualObjectParameter != null)) {
			if (EcoreUtil.isAncestor(this, newActualObjectParameter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newActualObjectParameter != null)
				msgs = ((InternalEObject)newActualObjectParameter).eInverseAdd(this, ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE, ActualObjectParameter.class, msgs);
			msgs = basicSetActualObjectParameter(newActualObjectParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER, newActualObjectParameter, newActualObjectParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WithArgument getArgumentOf() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__ARGUMENT_OF) return null;
		return (WithArgument)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArgumentOf(WithArgument newArgumentOf, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newArgumentOf, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgumentOf(WithArgument newArgumentOf) {
		if (newArgumentOf != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__ARGUMENT_OF && newArgumentOf != null)) {
			if (EcoreUtil.isAncestor(this, newArgumentOf))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newArgumentOf != null)
				msgs = ((InternalEObject)newArgumentOf).eInverseAdd(this, ExpressionsPackage.WITH_ARGUMENT__ARGUMENT, WithArgument.class, msgs);
			msgs = basicSetArgumentOf(newArgumentOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, newArgumentOf, newArgumentOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equals getLeftOfEquals() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS) return null;
		return (Equals)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftOfEquals(Equals newLeftOfEquals, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLeftOfEquals, ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftOfEquals(Equals newLeftOfEquals) {
		if (newLeftOfEquals != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS && newLeftOfEquals != null)) {
			if (EcoreUtil.isAncestor(this, newLeftOfEquals))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLeftOfEquals != null)
				msgs = ((InternalEObject)newLeftOfEquals).eInverseAdd(this, ExpressionsPackage.EQUALS__LEFT, Equals.class, msgs);
			msgs = basicSetLeftOfEquals(newLeftOfEquals, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS, newLeftOfEquals, newLeftOfEquals));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equals getRightOfEquals() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS) return null;
		return (Equals)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightOfEquals(Equals newRightOfEquals, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRightOfEquals, ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightOfEquals(Equals newRightOfEquals) {
		if (newRightOfEquals != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS && newRightOfEquals != null)) {
			if (EcoreUtil.isAncestor(this, newRightOfEquals))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRightOfEquals != null)
				msgs = ((InternalEObject)newRightOfEquals).eInverseAdd(this, ExpressionsPackage.EQUALS__RIGHT, Equals.class, msgs);
			msgs = basicSetRightOfEquals(newRightOfEquals, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS, newRightOfEquals, newRightOfEquals));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conditional getConditional() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__CONDITIONAL) return null;
		return (Conditional)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConditional(Conditional newConditional, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConditional, ExpressionsPackage.EXPRESSION__CONDITIONAL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditional(Conditional newConditional) {
		if (newConditional != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__CONDITIONAL && newConditional != null)) {
			if (EcoreUtil.isAncestor(this, newConditional))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConditional != null)
				msgs = ((InternalEObject)newConditional).eInverseAdd(this, ExpressionsPackage.CONDITIONAL__CONDITION, Conditional.class, msgs);
			msgs = basicSetConditional(newConditional, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__CONDITIONAL, newConditional, newConditional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionExpression getCollectionExpression() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION) return null;
		return (CollectionExpression)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCollectionExpression(CollectionExpression newCollectionExpression, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCollectionExpression, ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionExpression(CollectionExpression newCollectionExpression) {
		if (newCollectionExpression != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION && newCollectionExpression != null)) {
			if (EcoreUtil.isAncestor(this, newCollectionExpression))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCollectionExpression != null)
				msgs = ((InternalEObject)newCollectionExpression).eInverseAdd(this, CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE, CollectionExpression.class, msgs);
			msgs = basicSetCollectionExpression(newCollectionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION, newCollectionExpression, newCollectionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterate getInIterator() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__IN_ITERATOR) return null;
		return (Iterate)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInIterator(Iterate newInIterator, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInIterator, ExpressionsPackage.EXPRESSION__IN_ITERATOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInIterator(Iterate newInIterator) {
		if (newInIterator != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__IN_ITERATOR && newInIterator != null)) {
			if (EcoreUtil.isAncestor(this, newInIterator))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInIterator != null)
				msgs = ((InternalEObject)newInIterator).eInverseAdd(this, CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION, Iterate.class, msgs);
			msgs = basicSetInIterator(newInIterator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__IN_ITERATOR, newInIterator, newInIterator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OqlQuery getConditionOfOqlQuery() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY) return null;
		return (OqlQuery)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConditionOfOqlQuery(OqlQuery newConditionOfOqlQuery, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConditionOfOqlQuery, ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionOfOqlQuery(OqlQuery newConditionOfOqlQuery) {
		if (newConditionOfOqlQuery != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY && newConditionOfOqlQuery != null)) {
			if (EcoreUtil.isAncestor(this, newConditionOfOqlQuery))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConditionOfOqlQuery != null)
				msgs = ((InternalEObject)newConditionOfOqlQuery).eInverseAdd(this, QueryPackage.OQL_QUERY__CONDITION, OqlQuery.class, msgs);
			msgs = basicSetConditionOfOqlQuery(newConditionOfOqlQuery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY, newConditionOfOqlQuery, newConditionOfOqlQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromClause getFromClause() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__FROM_CLAUSE) return null;
		return (FromClause)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromClause(FromClause newFromClause, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFromClause, ExpressionsPackage.EXPRESSION__FROM_CLAUSE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromClause(FromClause newFromClause) {
		if (newFromClause != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__FROM_CLAUSE && newFromClause != null)) {
			if (EcoreUtil.isAncestor(this, newFromClause))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFromClause != null)
				msgs = ((InternalEObject)newFromClause).eInverseAdd(this, QueryPackage.FROM_CLAUSE__FROM_EXPRESSION, FromClause.class, msgs);
			msgs = basicSetFromClause(newFromClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__FROM_CLAUSE, newFromClause, newFromClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringTemplate getTemplate() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__TEMPLATE) return null;
		return (StringTemplate)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplate(StringTemplate newTemplate, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTemplate, ExpressionsPackage.EXPRESSION__TEMPLATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(StringTemplate newTemplate) {
		if (newTemplate != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__TEMPLATE && newTemplate != null)) {
			if (EcoreUtil.isAncestor(this, newTemplate))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTemplate != null)
				msgs = ((InternalEObject)newTemplate).eInverseAdd(this, TemplatesPackage.STRING_TEMPLATE__EXPRESSIONS, StringTemplate.class, msgs);
			msgs = basicSetTemplate(newTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__TEMPLATE, newTemplate, newTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public All getAll() {
		if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__ALL) return null;
		return (All)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAll(All newAll, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAll, ExpressionsPackage.EXPRESSION__ALL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAll(All newAll) {
		if (newAll != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__ALL && newAll != null)) {
			if (EcoreUtil.isAncestor(this, newAll))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAll != null)
				msgs = ((InternalEObject)newAll).eInverseAdd(this, persistence.expressions.ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER, All.class, msgs);
			msgs = basicSetAll(newAll, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__ALL, newAll, newAll));
	}

	/**
	 * The cached invocation delegate for the '{@link #isSideEffectFree() <em>Is Side Effect Free</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSideEffectFree()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(0)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSideEffectFree() {
		try {
			return (Boolean)IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #evaluatesToEqualAs(dataaccess.expressions.Expression) <em>Evaluates To Equal As</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #evaluatesToEqualAs(dataaccess.expressions.Expression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate EVALUATES_TO_EQUAL_AS_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(1)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean evaluatesToEqualAs(Expression e) {
		try {
			return (Boolean)EVALUATES_TO_EQUAL_AS_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{e}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getUsedAliases() <em>Get Used Aliases</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedAliases()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_USED_ALIASES__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(2)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Iterator> getUsedAliases() {
		try {
			return (EList<Iterator>)GET_USED_ALIASES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getNamedValuesInScope() <em>Get Named Values In Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedValuesInScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(3)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedValue> getNamedValuesInScope() {
		try {
			return (EList<NamedValue>)GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getOwningExpression() <em>Get Owning Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwningExpression()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_OWNING_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(4)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getOwningExpression() {
		try {
			return (Expression)GET_OWNING_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getOwningClass() <em>Get Owning Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwningClass()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_OWNING_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(5)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SapClass getOwningClass() {
		try {
			return (SapClass)GET_OWNING_CLASS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #addNamedValuesWithNewNames(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Add Named Values With New Names</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #addNamedValuesWithNewNames(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ADD_NAMED_VALUES_WITH_NEW_NAMES_ELIST_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.IN_SCOPE.getEOperations().get(0)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedValue> addNamedValuesWithNewNames(EList<NamedValue> inner, EList<NamedValue> outer) {
		try {
			return (EList<NamedValue>)ADD_NAMED_VALUES_WITH_NEW_NAMES_ELIST_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{inner, outer}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExpressionStatement((ExpressionStatement)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInitExpressionFor((NamedValueWithOptionalInitExpression)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetActualObjectParameter((ActualObjectParameter)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__ARGUMENT_OF:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetArgumentOf((WithArgument)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLeftOfEquals((Equals)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRightOfEquals((Equals)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__CONDITIONAL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConditional((Conditional)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCollectionExpression((CollectionExpression)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInIterator((Iterate)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConditionOfOqlQuery((OqlQuery)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFromClause((FromClause)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__TEMPLATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTemplate((StringTemplate)otherEnd, msgs);
			case ExpressionsPackage.EXPRESSION__ALL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAll((All)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT:
				return basicSetExpressionStatement(null, msgs);
			case ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR:
				return basicSetInitExpressionFor(null, msgs);
			case ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER:
				return basicSetActualObjectParameter(null, msgs);
			case ExpressionsPackage.EXPRESSION__ARGUMENT_OF:
				return basicSetArgumentOf(null, msgs);
			case ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS:
				return basicSetLeftOfEquals(null, msgs);
			case ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS:
				return basicSetRightOfEquals(null, msgs);
			case ExpressionsPackage.EXPRESSION__CONDITIONAL:
				return basicSetConditional(null, msgs);
			case ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION:
				return basicSetCollectionExpression(null, msgs);
			case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
				return basicSetInIterator(null, msgs);
			case ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY:
				return basicSetConditionOfOqlQuery(null, msgs);
			case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
				return basicSetFromClause(null, msgs);
			case ExpressionsPackage.EXPRESSION__TEMPLATE:
				return basicSetTemplate(null, msgs);
			case ExpressionsPackage.EXPRESSION__ALL:
				return basicSetAll(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT:
				return eInternalContainer().eInverseRemove(this, ActionsPackage.EXPRESSION_STATEMENT__EXPRESSION, ExpressionStatement.class, msgs);
			case ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR:
				return eInternalContainer().eInverseRemove(this, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION, NamedValueWithOptionalInitExpression.class, msgs);
			case ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER:
				return eInternalContainer().eInverseRemove(this, ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE, ActualObjectParameter.class, msgs);
			case ExpressionsPackage.EXPRESSION__ARGUMENT_OF:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.WITH_ARGUMENT__ARGUMENT, WithArgument.class, msgs);
			case ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.EQUALS__LEFT, Equals.class, msgs);
			case ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.EQUALS__RIGHT, Equals.class, msgs);
			case ExpressionsPackage.EXPRESSION__CONDITIONAL:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.CONDITIONAL__CONDITION, Conditional.class, msgs);
			case ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION:
				return eInternalContainer().eInverseRemove(this, CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE, CollectionExpression.class, msgs);
			case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
				return eInternalContainer().eInverseRemove(this, CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION, Iterate.class, msgs);
			case ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY:
				return eInternalContainer().eInverseRemove(this, QueryPackage.OQL_QUERY__CONDITION, OqlQuery.class, msgs);
			case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
				return eInternalContainer().eInverseRemove(this, QueryPackage.FROM_CLAUSE__FROM_EXPRESSION, FromClause.class, msgs);
			case ExpressionsPackage.EXPRESSION__TEMPLATE:
				return eInternalContainer().eInverseRemove(this, TemplatesPackage.STRING_TEMPLATE__EXPRESSIONS, StringTemplate.class, msgs);
			case ExpressionsPackage.EXPRESSION__ALL:
				return eInternalContainer().eInverseRemove(this, persistence.expressions.ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER, All.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT:
				return getExpressionStatement();
			case ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR:
				return getInitExpressionFor();
			case ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER:
				return getActualObjectParameter();
			case ExpressionsPackage.EXPRESSION__ARGUMENT_OF:
				return getArgumentOf();
			case ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS:
				return getLeftOfEquals();
			case ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS:
				return getRightOfEquals();
			case ExpressionsPackage.EXPRESSION__CONDITIONAL:
				return getConditional();
			case ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION:
				return getCollectionExpression();
			case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
				return getInIterator();
			case ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY:
				return getConditionOfOqlQuery();
			case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
				return getFromClause();
			case ExpressionsPackage.EXPRESSION__TEMPLATE:
				return getTemplate();
			case ExpressionsPackage.EXPRESSION__ALL:
				return getAll();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT:
				setExpressionStatement((ExpressionStatement)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR:
				setInitExpressionFor((NamedValueWithOptionalInitExpression)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER:
				setActualObjectParameter((ActualObjectParameter)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__ARGUMENT_OF:
				setArgumentOf((WithArgument)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS:
				setLeftOfEquals((Equals)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS:
				setRightOfEquals((Equals)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__CONDITIONAL:
				setConditional((Conditional)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION:
				setCollectionExpression((CollectionExpression)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
				setInIterator((Iterate)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY:
				setConditionOfOqlQuery((OqlQuery)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
				setFromClause((FromClause)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__TEMPLATE:
				setTemplate((StringTemplate)newValue);
				return;
			case ExpressionsPackage.EXPRESSION__ALL:
				setAll((All)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT:
				setExpressionStatement((ExpressionStatement)null);
				return;
			case ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR:
				setInitExpressionFor((NamedValueWithOptionalInitExpression)null);
				return;
			case ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER:
				setActualObjectParameter((ActualObjectParameter)null);
				return;
			case ExpressionsPackage.EXPRESSION__ARGUMENT_OF:
				setArgumentOf((WithArgument)null);
				return;
			case ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS:
				setLeftOfEquals((Equals)null);
				return;
			case ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS:
				setRightOfEquals((Equals)null);
				return;
			case ExpressionsPackage.EXPRESSION__CONDITIONAL:
				setConditional((Conditional)null);
				return;
			case ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION:
				setCollectionExpression((CollectionExpression)null);
				return;
			case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
				setInIterator((Iterate)null);
				return;
			case ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY:
				setConditionOfOqlQuery((OqlQuery)null);
				return;
			case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
				setFromClause((FromClause)null);
				return;
			case ExpressionsPackage.EXPRESSION__TEMPLATE:
				setTemplate((StringTemplate)null);
				return;
			case ExpressionsPackage.EXPRESSION__ALL:
				setAll((All)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT:
				return getExpressionStatement() != null;
			case ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR:
				return getInitExpressionFor() != null;
			case ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER:
				return getActualObjectParameter() != null;
			case ExpressionsPackage.EXPRESSION__ARGUMENT_OF:
				return getArgumentOf() != null;
			case ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS:
				return getLeftOfEquals() != null;
			case ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS:
				return getRightOfEquals() != null;
			case ExpressionsPackage.EXPRESSION__CONDITIONAL:
				return getConditional() != null;
			case ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION:
				return getCollectionExpression() != null;
			case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
				return getInIterator() != null;
			case ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY:
				return getConditionOfOqlQuery() != null;
			case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
				return getFromClause() != null;
			case ExpressionsPackage.EXPRESSION__TEMPLATE:
				return getTemplate() != null;
			case ExpressionsPackage.EXPRESSION__ALL:
				return getAll() != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpressionImpl
