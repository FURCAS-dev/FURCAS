/**
 * <copyright>
 * </copyright>
 *
 * $Id: Expression.java,v 1.2 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions;

import behavioral.actions.ExpressionStatement;
import behavioral.actions.Iterator;

import behavioral.actions.NamedValueWithOptionalInitExpression;
import data.classes.ActualObjectParameter;
import data.classes.InScope;
import data.classes.NamedValue;
import data.classes.SapClass;
import data.classes.TypedElement;

import dataaccess.analytics.DimensionDefinition;
import dataaccess.analytics.DimensionExpression;
import dataaccess.analytics.GroupBy;
import dataaccess.expressions.collectionexpressions.CollectionExpression;
import dataaccess.expressions.collectionexpressions.Iterate;

import dataaccess.query.FromClause;

import dataaccess.query.OqlQuery;
import org.eclipse.emf.common.util.EList;
import persistence.expressions.All;
import ui.templates.StringTemplate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression that evaluates to an object.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.Expression#getExpressionStatement <em>Expression Statement</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getInitExpressionFor <em>Init Expression For</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getActualObjectParameter <em>Actual Object Parameter</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getObjectBasedExpression <em>Object Based Expression</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getArgumentOf <em>Argument Of</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getBlockOfFunctionCallExpression <em>Block Of Function Call Expression</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getLeftOfEquals <em>Left Of Equals</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getUsedAsArgumentInSignatureCall <em>Used As Argument In Signature Call</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getRightOfEquals <em>Right Of Equals</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getConditional <em>Conditional</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getCollectionExpression <em>Collection Expression</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getInIterator <em>In Iterator</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getConditionOfOqlQuery <em>Condition Of Oql Query</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getFromClause <em>From Clause</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getCellSetOfDimensionExpression <em>Cell Set Of Dimension Expression</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getFactsOfDimensionExpression <em>Facts Of Dimension Expression</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getDimension <em>Dimension</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getMapExpressionOfGroupBy <em>Map Expression Of Group By</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getTemplate <em>Template</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getAll <em>All</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends TypedElement, InScope {
	/**
     * Returns the value of the '<em><b>Expression Statement</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.ExpressionStatement#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Statement</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Expression Statement</em>' container reference.
     * @see #setExpressionStatement(ExpressionStatement)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_ExpressionStatement()
     * @see behavioral.actions.ExpressionStatement#getExpression
     * @model opposite="expression"
     * @generated
     */
	ExpressionStatement getExpressionStatement();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getExpressionStatement <em>Expression Statement</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression Statement</em>' container reference.
     * @see #getExpressionStatement()
     * @generated
     */
	void setExpressionStatement(ExpressionStatement value);

	/**
     * Returns the value of the '<em><b>Init Expression For</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.NamedValueWithOptionalInitExpression#getInitExpression <em>Init Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Init Expression For</em>' container reference.
     * @see #setInitExpressionFor(NamedValueWithOptionalInitExpression)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_InitExpressionFor()
     * @see behavioral.actions.NamedValueWithOptionalInitExpression#getInitExpression
     * @model opposite="initExpression"
     * @generated
     */
	NamedValueWithOptionalInitExpression getInitExpressionFor();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getInitExpressionFor <em>Init Expression For</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Init Expression For</em>' container reference.
     * @see #getInitExpressionFor()
     * @generated
     */
	void setInitExpressionFor(NamedValueWithOptionalInitExpression value);

	/**
     * Returns the value of the '<em><b>Actual Object Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.ActualObjectParameter#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Object Parameter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Actual Object Parameter</em>' container reference.
     * @see #setActualObjectParameter(ActualObjectParameter)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_ActualObjectParameter()
     * @see data.classes.ActualObjectParameter#getValue
     * @model opposite="value"
     * @generated
     */
	ActualObjectParameter getActualObjectParameter();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getActualObjectParameter <em>Actual Object Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Actual Object Parameter</em>' container reference.
     * @see #getActualObjectParameter()
     * @generated
     */
	void setActualObjectParameter(ActualObjectParameter value);

	/**
     * Returns the value of the '<em><b>Object Based Expression</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.ObjectBasedExpression#getObject <em>Object</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Based Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Object Based Expression</em>' container reference.
     * @see #setObjectBasedExpression(ObjectBasedExpression)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_ObjectBasedExpression()
     * @see dataaccess.expressions.ObjectBasedExpression#getObject
     * @model opposite="object"
     * @generated
     */
	ObjectBasedExpression getObjectBasedExpression();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getObjectBasedExpression <em>Object Based Expression</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Object Based Expression</em>' container reference.
     * @see #getObjectBasedExpression()
     * @generated
     */
	void setObjectBasedExpression(ObjectBasedExpression value);

	/**
     * Returns the value of the '<em><b>Argument Of</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.WithArgument#getArgument <em>Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument Of</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Argument Of</em>' container reference.
     * @see #setArgumentOf(WithArgument)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_ArgumentOf()
     * @see dataaccess.expressions.WithArgument#getArgument
     * @model opposite="argument"
     * @generated
     */
	WithArgument getArgumentOf();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getArgumentOf <em>Argument Of</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Argument Of</em>' container reference.
     * @see #getArgumentOf()
     * @generated
     */
	void setArgumentOf(WithArgument value);

	/**
     * Returns the value of the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.FunctionCallExpression#getCalledBlock <em>Called Block</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Of Function Call Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Block Of Function Call Expression</em>' container reference.
     * @see #setBlockOfFunctionCallExpression(FunctionCallExpression)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_BlockOfFunctionCallExpression()
     * @see dataaccess.expressions.FunctionCallExpression#getCalledBlock
     * @model opposite="calledBlock"
     * @generated
     */
	FunctionCallExpression getBlockOfFunctionCallExpression();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getBlockOfFunctionCallExpression <em>Block Of Function Call Expression</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Block Of Function Call Expression</em>' container reference.
     * @see #getBlockOfFunctionCallExpression()
     * @generated
     */
	void setBlockOfFunctionCallExpression(FunctionCallExpression value);

	/**
     * Returns the value of the '<em><b>Left Of Equals</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Equals#getLeft <em>Left</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Of Equals</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Left Of Equals</em>' container reference.
     * @see #setLeftOfEquals(Equals)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_LeftOfEquals()
     * @see dataaccess.expressions.Equals#getLeft
     * @model opposite="left"
     * @generated
     */
	Equals getLeftOfEquals();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getLeftOfEquals <em>Left Of Equals</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Left Of Equals</em>' container reference.
     * @see #getLeftOfEquals()
     * @generated
     */
	void setLeftOfEquals(Equals value);

	/**
     * Returns the value of the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.SignatureCallExpression#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used As Argument In Signature Call</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Used As Argument In Signature Call</em>' container reference.
     * @see #setUsedAsArgumentInSignatureCall(SignatureCallExpression)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_UsedAsArgumentInSignatureCall()
     * @see dataaccess.expressions.SignatureCallExpression#getParameters
     * @model opposite="parameters"
     * @generated
     */
	SignatureCallExpression getUsedAsArgumentInSignatureCall();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getUsedAsArgumentInSignatureCall <em>Used As Argument In Signature Call</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Used As Argument In Signature Call</em>' container reference.
     * @see #getUsedAsArgumentInSignatureCall()
     * @generated
     */
	void setUsedAsArgumentInSignatureCall(SignatureCallExpression value);

	/**
     * Returns the value of the '<em><b>Right Of Equals</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Equals#getRight <em>Right</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Of Equals</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Right Of Equals</em>' container reference.
     * @see #setRightOfEquals(Equals)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_RightOfEquals()
     * @see dataaccess.expressions.Equals#getRight
     * @model opposite="right"
     * @generated
     */
	Equals getRightOfEquals();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getRightOfEquals <em>Right Of Equals</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Right Of Equals</em>' container reference.
     * @see #getRightOfEquals()
     * @generated
     */
	void setRightOfEquals(Equals value);

	/**
     * Returns the value of the '<em><b>Conditional</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Conditional#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditional</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Conditional</em>' container reference.
     * @see #setConditional(Conditional)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_Conditional()
     * @see dataaccess.expressions.Conditional#getCondition
     * @model opposite="condition"
     * @generated
     */
	Conditional getConditional();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getConditional <em>Conditional</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Conditional</em>' container reference.
     * @see #getConditional()
     * @generated
     */
	void setConditional(Conditional value);

	/**
     * Returns the value of the '<em><b>Collection Expression</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.collectionexpressions.CollectionExpression#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Collection Expression</em>' container reference.
     * @see #setCollectionExpression(CollectionExpression)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_CollectionExpression()
     * @see dataaccess.expressions.collectionexpressions.CollectionExpression#getSource
     * @model opposite="source"
     * @generated
     */
	CollectionExpression getCollectionExpression();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getCollectionExpression <em>Collection Expression</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Collection Expression</em>' container reference.
     * @see #getCollectionExpression()
     * @generated
     */
	void setCollectionExpression(CollectionExpression value);

	/**
     * Returns the value of the '<em><b>In Iterator</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.collectionexpressions.Iterate#getIteratorExpression <em>Iterator Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Iterator</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>In Iterator</em>' container reference.
     * @see #setInIterator(Iterate)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_InIterator()
     * @see dataaccess.expressions.collectionexpressions.Iterate#getIteratorExpression
     * @model opposite="iteratorExpression"
     * @generated
     */
	Iterate getInIterator();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getInIterator <em>In Iterator</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>In Iterator</em>' container reference.
     * @see #getInIterator()
     * @generated
     */
	void setInIterator(Iterate value);

	/**
     * Returns the value of the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.query.OqlQuery#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Of Oql Query</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Condition Of Oql Query</em>' container reference.
     * @see #setConditionOfOqlQuery(OqlQuery)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_ConditionOfOqlQuery()
     * @see dataaccess.query.OqlQuery#getCondition
     * @model opposite="condition"
     * @generated
     */
	OqlQuery getConditionOfOqlQuery();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getConditionOfOqlQuery <em>Condition Of Oql Query</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition Of Oql Query</em>' container reference.
     * @see #getConditionOfOqlQuery()
     * @generated
     */
	void setConditionOfOqlQuery(OqlQuery value);

	/**
     * Returns the value of the '<em><b>From Clause</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.query.FromClause#getFromExpression <em>From Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Clause</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>From Clause</em>' container reference.
     * @see #setFromClause(FromClause)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_FromClause()
     * @see dataaccess.query.FromClause#getFromExpression
     * @model opposite="fromExpression"
     * @generated
     */
	FromClause getFromClause();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getFromClause <em>From Clause</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>From Clause</em>' container reference.
     * @see #getFromClause()
     * @generated
     */
	void setFromClause(FromClause value);

	/**
     * Returns the value of the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.DimensionExpression#getCellSet <em>Cell Set</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Set Of Dimension Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Cell Set Of Dimension Expression</em>' container reference.
     * @see #setCellSetOfDimensionExpression(DimensionExpression)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_CellSetOfDimensionExpression()
     * @see dataaccess.analytics.DimensionExpression#getCellSet
     * @model opposite="cellSet"
     * @generated
     */
	DimensionExpression getCellSetOfDimensionExpression();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getCellSetOfDimensionExpression <em>Cell Set Of Dimension Expression</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cell Set Of Dimension Expression</em>' container reference.
     * @see #getCellSetOfDimensionExpression()
     * @generated
     */
	void setCellSetOfDimensionExpression(DimensionExpression value);

	/**
     * Returns the value of the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.DimensionExpression#getFacts <em>Facts</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facts Of Dimension Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Facts Of Dimension Expression</em>' container reference.
     * @see #setFactsOfDimensionExpression(DimensionExpression)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_FactsOfDimensionExpression()
     * @see dataaccess.analytics.DimensionExpression#getFacts
     * @model opposite="facts"
     * @generated
     */
	DimensionExpression getFactsOfDimensionExpression();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getFactsOfDimensionExpression <em>Facts Of Dimension Expression</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Facts Of Dimension Expression</em>' container reference.
     * @see #getFactsOfDimensionExpression()
     * @generated
     */
	void setFactsOfDimensionExpression(DimensionExpression value);

	/**
     * Returns the value of the '<em><b>Dimension</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.DimensionDefinition#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Dimension</em>' container reference.
     * @see #setDimension(DimensionDefinition)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_Dimension()
     * @see dataaccess.analytics.DimensionDefinition#getExpression
     * @model opposite="expression"
     * @generated
     */
	DimensionDefinition getDimension();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getDimension <em>Dimension</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dimension</em>' container reference.
     * @see #getDimension()
     * @generated
     */
	void setDimension(DimensionDefinition value);

	/**
     * Returns the value of the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.GroupBy#getMapExpression <em>Map Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Expression Of Group By</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Map Expression Of Group By</em>' container reference.
     * @see #setMapExpressionOfGroupBy(GroupBy)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_MapExpressionOfGroupBy()
     * @see dataaccess.analytics.GroupBy#getMapExpression
     * @model opposite="mapExpression"
     * @generated
     */
	GroupBy getMapExpressionOfGroupBy();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getMapExpressionOfGroupBy <em>Map Expression Of Group By</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Map Expression Of Group By</em>' container reference.
     * @see #getMapExpressionOfGroupBy()
     * @generated
     */
	void setMapExpressionOfGroupBy(GroupBy value);

	/**
     * Returns the value of the '<em><b>Template</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link ui.templates.StringTemplate#getExpressions <em>Expressions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Template</em>' container reference.
     * @see #setTemplate(StringTemplate)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_Template()
     * @see ui.templates.StringTemplate#getExpressions
     * @model opposite="expressions"
     * @generated
     */
	StringTemplate getTemplate();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getTemplate <em>Template</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Template</em>' container reference.
     * @see #getTemplate()
     * @generated
     */
	void setTemplate(StringTemplate value);

	/**
     * Returns the value of the '<em><b>All</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link persistence.expressions.All#getSnapshotIdentifier <em>Snapshot Identifier</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>All</em>' container reference.
     * @see #setAll(All)
     * @see dataaccess.expressions.ExpressionsPackage#getExpression_All()
     * @see persistence.expressions.All#getSnapshotIdentifier
     * @model opposite="snapshotIdentifier"
     * @generated
     */
	All getAll();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Expression#getAll <em>All</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>All</em>' container reference.
     * @see #getAll()
     * @generated
     */
	void setAll(All value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Tells if this expression is side effect-free. An expression has a side effect if it invokes a method or a function that is not described as side effect-free. It is important to note that this has to be checked recursively for nested expressions.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let parametersAndSignatureAreSideEffectFree:Boolean =\n    self.oclIsKindOf(SignatureCallExpression) implies\n      (self.oclAsType(SignatureCallExpression).parameters->forAll(p|p.isSideEffectFree())\n       and self.oclAsType(SignatureCallExpression).getSignature().sideEffectFree)\n  in\n  if self.oclIsKindOf(ObjectBasedExpression) then\n    self.oclAsType(ObjectBasedExpression).object.isSideEffectFree() and\n    if self.oclIsKindOf(SignatureCallExpression) then\n      parametersAndSignatureAreSideEffectFree\n    else\n      if self.oclIsKindOf(Replace) then\n        self.oclAsType(Replace).with.isSideEffectFree()\n      else\n        if self.oclIsKindOf(ExpressionWithArgument) and self.oclAsType(ExpressionWithArgument).argument->notEmpty() then\n          self.oclAsType(ExpressionWithArgument).argument.isSideEffectFree()\n        else\n          true\n        endif\n      endif\n    endif\n  else if self.oclIsKindOf(FunctionCallExpression) then\n    parametersAndSignatureAreSideEffectFree and self.oclAsType(FunctionCallExpression).calledBlock.isSideEffectFree()\n  else if self.oclIsKindOf(Equals) then\n    self.oclAsType(Equals).left.isSideEffectFree() and self.oclAsType(Equals).right.isSideEffectFree()\n  else if self.oclIsKindOf(ObjectCreationExpression) then\n    self.oclAsType(ObjectCreationExpression).classToInstantiate.valueType\n  else if self.oclIsKindOf(dataaccess::analytics::DimensionExpression) then\n    self.oclAsType(dataaccess::analytics::DimensionExpression).dimensionParameter.ownerSignature.sideEffectFree\n  else if self.oclIsKindOf(Ternary) then\n    self.oclAsType(Ternary).condition.isSideEffectFree() and\n    self.oclAsType(Ternary).trueExpr.isSideEffectFree() and\n    self.oclAsType(Ternary).falseExpr.isSideEffectFree()\n  else if self.oclIsKindOf(dataaccess::expressions::collectionexpressions::CollectionExpression) then\n    self.oclAsType(dataaccess::expressions::collectionexpressions::CollectionExpression).source.isSideEffectFree() and\n    if self.oclIsKindOf(dataaccess::expressions::collectionexpressions::Iterate) then\n      (self.oclAsType(dataaccess::expressions::collectionexpressions::Iterate).accumulator.initExpression->notEmpty() implies\n         self.oclAsType(dataaccess::expressions::collectionexpressions::Iterate).accumulator.initExpression.isSideEffectFree()) and\n      self.oclAsType(dataaccess::expressions::collectionexpressions::Iterate).iteratorExpression.isSideEffectFree()\n    else\n      true\n    endif\n  else if self.oclIsKindOf(dataaccess::expressions::literals::ObjectLiteral) then\n    self.oclAsType(dataaccess::expressions::literals::ObjectLiteral).propertyValues.value->forAll(v|v.isSideEffectFree())\n  else if self.oclIsKindOf(persistence::expressions::All) or self.oclIsKindOf(Replace) or self.oclIsKindOf(This) or self.oclIsKindOf(VariableExpression) or\n  self.oclIsKindOf(dataaccess::expressions::literals::Literal) or self.oclIsKindOf(dataaccess::expressions::fp::AnonymousFunctionExpr) then\n    true\n  else if self.oclIsKindOf(dataaccess::query::Selection) then\n    self.oclAsType(dataaccess::query::Selection).object.isSideEffectFree()\n  else\n    false\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean isSideEffectFree();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A conservative estimation that returns true if provably this and the passed expression will evaluate to equal objects. false means that the two expressions may evaluate to different results, not excluding that they can still have equal results; it's just not (yet) provable here.
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false" eUnique="false" eRequired="true" eOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self=e then\n    true\n  else\n  if self.oclIsKindOf(dataaccess::expressions::literals::NumberLiteral) and e.oclIsKindOf(dataaccess::expressions::literals::NumberLiteral) then\n    self.oclAsType(dataaccess::expressions::literals::NumberLiteral).literal=e.oclAsType(dataaccess::expressions::literals::NumberLiteral).literal\n  else\n    if self.oclIsKindOf(dataaccess::expressions::literals::StringLiteral) and e.oclIsKindOf(dataaccess::expressions::literals::StringLiteral) then\n      self.oclAsType(dataaccess::expressions::literals::StringLiteral).literal=e.oclAsType(dataaccess::expressions::literals::StringLiteral).literal\n    else\n      if self.oclIsKindOf(dataaccess::expressions::literals::ObjectLiteral) and e.oclIsKindOf(dataaccess::expressions::literals::ObjectLiteral) then\n        self.oclAsType(dataaccess::expressions::literals::ObjectLiteral).isEqualTo(e.oclAsType(dataaccess::expressions::literals::ObjectLiteral))\n      else\n        if self.oclIsKindOf(VariableExpression) and e.oclIsKindOf(VariableExpression) then\n          self.oclAsType(VariableExpression).variable = e.oclAsType(VariableExpression).variable\n        else\n          false\n        endif\n      endif\n    endif\n  endif\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean evaluatesToEqualAs(Expression e);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Computes the Iterator objects that are defined by a FromClause of an OqlQuery and that are used in a VariableExpression somewhere inside this expression. Needs to handle all side effect-free expression types. By the current definition, this excludes, e.g., ObjectCreationExpression and therefore its initializers method call expressions.
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsKindOf(VariableExpression) then\n    if self.oclAsType(VariableExpression).variable.oclIsKindOf(behavioral::actions::Iterator) then\n      self.oclAsType(VariableExpression).variable.oclAsType(behavioral::actions::Iterator)->select(i | i.fromClause->notEmpty())->asSet()\n    else\n      Set{}\n    endif\n  else\n    if self.oclIsKindOf(Replace) then\n      self.oclAsType(Replace).object.getUsedAliases()->union(\n      self.oclAsType(Replace).steps.filterFunction.getUsedAliases()->flatten()->asSet())->union(\n      self.oclAsType(Replace).with.getUsedAliases())\n    else\n      if self.oclIsKindOf(dataaccess::query::Selection) then\n        self.oclAsType(dataaccess::query::Selection).object.getUsedAliases()->union(\n        self.oclAsType(dataaccess::query::Selection).selectionExpr.getUsedAliases())\n      else\n        if self.oclIsKindOf(ObjectBasedExpression) then\n          let objectAliases:Set(behavioral::actions::Iterator) = self.oclAsType(ObjectBasedExpression).object.getUsedAliases() in\n          if self.oclIsKindOf(MethodCallExpression) then\n            objectAliases->union(self.oclAsType(MethodCallExpression).parameters.getUsedAliases()->flatten()->asSet())\n          else\n            objectAliases\n          endif\n        else\n          if self.oclIsKindOf(Equals) then\n            self.oclAsType(Equals).left.getUsedAliases()->union(self.oclAsType(Equals).right.getUsedAliases())\n          else\n            if self.oclIsKindOf(FunctionCallExpression) then\n              self.oclAsType(FunctionCallExpression).calledBlock.getUsedAliases()->union(\n                           self.oclAsType(FunctionCallExpression).parameters.getUsedAliases()->flatten()->asSet())\n            else\n              if self.oclIsKindOf(Ternary) then\n                let sat:Ternary = self.oclAsType(Ternary) in\n                sat.condition.getUsedAliases()->union(sat.trueExpr.getUsedAliases())->union(sat.falseExpr.getUsedAliases())\n             else\n                 if self.oclIsKindOf(dataaccess::expressions::collectionexpressions::CollectionExpressionWithArgument) then\n                  self.oclAsType(dataaccess::expressions::collectionexpressions::CollectionExpressionWithArgument).argument.getUsedAliases()->union(\n                  self.oclAsType(dataaccess::expressions::collectionexpressions::CollectionExpressionWithArgument).source.getUsedAliases())\n                else\n                  if self.oclIsKindOf(dataaccess::expressions::collectionexpressions::Iterate) then\n                    self.oclAsType(dataaccess::expressions::collectionexpressions::Iterate).iteratorExpression.getUsedAliases()->union(\n                    self.oclAsType(dataaccess::expressions::collectionexpressions::Iterate).accumulator.initExpression.getUsedAliases())->union(\n                    self.oclAsType(dataaccess::expressions::collectionexpressions::Iterate).source.getUsedAliases())\n                  else\n                    if self.oclIsKindOf(dataaccess::query::OqlQuery) then\n                      self.oclAsType(dataaccess::query::OqlQuery).fromClauses.fromExpression.getUsedAliases()->flatten()->asSet()->union(\n                      self.oclAsType(dataaccess::query::OqlQuery).condition.getUsedAliases())\n                    else\n                      Set{}\n                    endif\n                  endif\n                endif\n              endif\n            endif\n          endif\n        endif\n      endif\n    endif\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<Iterator> getUsedAliases();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.addNamedValuesWithNewNames(\n\n  -- First, collect those NamedValues defined immediately for this expression:\n  -- an iterate\'s body expression sees the iterators and the accumulator\n  let accumulator:Set(data::classes::NamedValue)=self.inIterator.accumulator->asSet() in\n  let iterators:Set(data::classes::NamedValue)=self.inIterator.iterators->asSet() in\n  -- an OQL \"from\" clause sees all aliases left of it\n  let oqlAliases:Set(data::classes::NamedValue)=(if self.fromClause->notEmpty() then\n    let fromClauses:OrderedSet(dataaccess::query::FromClause) = self.fromClause.fromClauseOfOqlQuery.fromClauses in\n    let fcIndex:Integer = fromClauses->indexOf(self.fromClause) in\n      Sequence{1..-1+fcIndex}->collect(i | fromClauses->at(i).alias)->asSet()\n  else\n    Set{}\n  endif)->union(\n  -- an OQL \"where\" clause sees all aliases defined by any of the OQL expression\'s \"from\" entries\n  self.conditionOfOqlQuery.fromClauses.alias->asSet()) in\n  -- a Selection defines an implicit iterator for its filter expression\n  let selectionIterator:Set(data::classes::NamedValue)=self.selection.iterator->asSet() in\n  -- a GroupBy\'s mapExpression sees all dimension iterators and the groupedFacts iterator\n  let groupByMapExpressionIterators:Set(data::classes::NamedValue)=self.mapExpressionOfGroupBy.groupedFacts->asSet()->union(\n                                                    self.mapExpressionOfGroupBy.dimensions.iterator->asSet()) in\n  -- a GroupBy\'s dimension expression sees the facts iterator\n  let groupByDimensionFactIterator:Set(data::classes::NamedValue)=self.dimension.groupBy.fact->asSet() in\n\n  accumulator->union(iterators)->union(oqlAliases)->union(selectionIterator)->union(groupByMapExpressionIterators)->\n  union(groupByDimensionFactIterator),\n\n  -- Then, add those defined by owning structures such as owning statements or owning expressions\n  -- an expression that is used by an ExpressionStatement or as condition in a Conditional sees all named values that the statement sees\n  if self.actualObjectParameter.owningClassTypeDefinition->notEmpty() then\n    self.actualObjectParameter.owningClassTypeDefinition.getNamedValuesInScope()\n  else\n    if self.initExpressionFor.namedValueDeclaration->notEmpty() then\n      self.initExpressionFor.namedValueDeclaration.getNamedValuesInScope()\n    else\n      if self.expressionStatement->notEmpty() then\n        self.expressionStatement.getNamedValuesInScope()\n      else\n        if self.conditional->notEmpty() then\n          if self.conditional.oclIsKindOf(behavioral::actions::ConditionalStatement) then\n            self.conditional.oclAsType(behavioral::actions::ConditionalStatement).getNamedValuesInScope()\n          else\n            self.conditional.oclAsType(ConditionalExpression).getNamedValuesInScope()\n          endif\n        else\n          if self.argumentOf->notEmpty() and self.argumentOf.oclIsKindOf(behavioral::actions::StatementWithArgument) then\n            self.argumentOf.oclAsType(behavioral::actions::StatementWithArgument).getNamedValuesInScope()\n          else\n            -- add all variables in scope for owning expressions\n            let oe:Expression = self.getOwningExpression() in\n              if oe->isEmpty() then\n                Set{}\n              else\n                oe.getNamedValuesInScope()\n              endif\n          endif\n        endif\n      endif\n    endif\n  endif\n  )'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<NamedValue> getNamedValuesInScope();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * If this expression is composed by another expression, determines the composing expression. Otherwise, an empty result is returned.
     * 
     * The issue with this operation is that each time a new inbound composite relatioship is added to Expression, this operation needs to be extended accordingly.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let objectBasedExpressions:Set(Expression)=self.objectBasedExpression->asSet() in\n  let argumentsOf:Set(Expression)=self.argumentOf->select(ao | ao.oclIsKindOf(Expression)).oclAsType(ExpressionWithArgument)->asSet() in\n  let equals:Set(Expression)=self.leftOfEquals->asSet()->union(self.rightOfEquals->asSet()) in\n  let blocksOfFunctionCallExpression:Set(Expression)=self.blockOfFunctionCallExpression->asSet() in\n  let signatureCalls:Set(Expression)=self.usedAsArgumentInSignatureCall->asSet() in\n  let creationExpression:Set(Expression)=if self.oclIsKindOf(MethodCallExpression) then\n    self.oclAsType(MethodCallExpression).creationExpression->asSet()\n  else\n    Set{}\n  endif in\n  let ternary:Set(Expression)=self.trueOfTernary->asSet()->union(self.falseOfTernary->asSet()) in\n  let conditional:Set(Expression)=if self.conditional->notEmpty() and self.conditional.oclIsKindOf(ConditionalExpression) then\n    self.conditional.oclAsType(ConditionalExpression)->asSet()\n  else\n    Set{}\n  endif in\n  let replace:Set(Expression)=self.withOfReplace->asSet()->union(self.navigationStep.replace->asSet()) in\n  let oqlQuery:Set(Expression)=self.conditionOfOqlQuery->asSet()->union(self.fromClause.fromClauseOfOqlQuery->asSet()) in\n  let selection:Set(Expression)=self.selection->asSet() in\n  let objectLiteral:Set(Expression)=self.valueInit.objectLiteral->asSet() in\n  let iterator:Set(Expression)=self.inIterator->asSet() in\n  let collectionExpression:Set(Expression)=self.collectionExpression->asSet() in\n  let all:Set(Expression)=self.all->asSet() in\n  let valueInitInObjectLiteral:Set(Expression)=self.valueInit.objectLiteral->asSet() in\n  let dimensionExpression:Set(Expression)=self.cellSetOfDimensionExpression->asSet()->union(\n                                                                   self.factsOfDimensionExpression->asSet()) in\n  let groupByExpression:Set(Expression)=self.dimension.groupBy->asSet()->union(\n                                                                   self.mapExpressionOfGroupBy->asSet()) in\n\n  objectBasedExpressions->union(argumentsOf)->union(equals)->union(blocksOfFunctionCallExpression)->union(\n  signatureCalls)->union(creationExpression)->union(ternary)->union(conditional)->union(replace)->union(\n  oqlQuery)->union(selection)->union(objectLiteral)->union(iterator)->union(collectionExpression)->union(\n  all)->union(valueInitInObjectLiteral)->union(dimensionExpression)->union(groupByExpression)->any(true)'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	Expression getOwningExpression();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let oe:Expression = self.getOwningExpression() in\n  if oe->notEmpty() then\n    oe.getOwningClass()\n  else\n    if self.expressionStatement->notEmpty() then\n      self.expressionStatement.getOwningClass()\n    else\n      if self.conditional->notEmpty() and self.conditional.oclIsKindOf(behavioral::actions::Statement) then\n        self.conditional.oclAsType(behavioral::actions::ConditionalStatement).getOwningClass()\n      else\n        if self.argumentOf->notEmpty() and self.argumentOf.oclIsKindOf(behavioral::actions::StatementWithArgument) then\n          self.argumentOf.oclAsType(behavioral::actions::StatementWithArgument).getOwningClass()\n        else\n          if self.initExpressionFor.namedValueDeclaration->notEmpty() then\n            self.initExpressionFor.namedValueDeclaration.getOwningClass()\n          else\n            null\n          endif\n        endif\n      endif\n    endif\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	SapClass getOwningClass();

} // Expression
