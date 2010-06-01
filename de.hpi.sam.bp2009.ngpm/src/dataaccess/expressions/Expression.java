/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;

import behavioral.actions.ExpressionStatement;
import behavioral.actions.Iterator;

import data.classes.InScope;
import data.classes.NamedValue;
import data.classes.SapClass;
import data.classes.TypedElement;

import dataaccess.expressions.collectionexpressions.Iterate;

import dataaccess.query.FromClause;

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
 *   <li>{@link dataaccess.expressions.Expression#getInIterator <em>In Iterator</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getFromClause <em>From Clause</em>}</li>
 *   <li>{@link dataaccess.expressions.Expression#getTemplate <em>Template</em>}</li>
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if this expression is side effect-free. An expression has a side effect if it invokes a method or a function that is not described as side effect-free. It is important to note that this has to be checked recursively for nested expressions.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='let parametersAndSignatureAreSideEffectFree:Boolean =\n    self.oclIsKindOf(SignatureCallExpression) implies\n      (self.oclAsType(SignatureCallExpression).parameters->forAll(p|p.isSideEffectFree())\n       and self.oclAsType(SignatureCallExpression).getSignature().sideEffectFree)\n  in\n  if self.oclIsKindOf(ObjectBasedExpression) then\n    self.oclAsType(ObjectBasedExpression).object.isSideEffectFree() and\n    if self.oclIsKindOf(SignatureCallExpression) then\n      parametersAndSignatureAreSideEffectFree\n    else\n      if self.oclIsKindOf(Replace) then\n        self.oclAsType(Replace).with.isSideEffectFree()\n      else\n        if self.oclIsKindOf(ExpressionWithArgument) and self.oclAsType(ExpressionWithArgument).argument->notEmpty() then\n          self.oclAsType(ExpressionWithArgument).argument.isSideEffectFree()\n        else\n          true\n        endif\n      endif\n    endif\n  else if self.oclIsKindOf(FunctionCallExpression) then\n    parametersAndSignatureAreSideEffectFree and self.oclAsType(FunctionCallExpression).calledBlock.isSideEffectFree()\n  else if self.oclIsKindOf(Equals) then\n    self.oclAsType(Equals).left.isSideEffectFree() and self.oclAsType(Equals).right.isSideEffectFree()\n  else if self.oclIsKindOf(ObjectCreationExpression) then\n    self.oclAsType(ObjectCreationExpression).classToInstantiate.valueType\n  else if self.oclIsKindOf(DimensionExpression) then\n    self.oclAsType(DimensionExpression).dimension.ownerSignature.sideEffectFree\n  else if self.oclIsKindOf(Ternary) then\n    self.oclAsType(Ternary).condition.isSideEffectFree() and\n    self.oclAsType(Ternary).trueExpr.isSideEffectFree() and\n    self.oclAsType(Ternary).falseExpr.isSideEffectFree()\n  else if self.oclIsKindOf(CollectionExpression) then\n    self.oclAsType(CollectionExpression).source.isSideEffectFree() and\n    if self.oclIsKindOf(Iterate) then\n      (self.oclAsType(Iterate).accumulator.initExpression->notEmpty() implies\n         self.oclAsType(Iterate).accumulator.initExpression.isSideEffectFree()) and\n      self.oclAsType(Iterate).iteratorExpression.isSideEffectFree()\n    else\n      true\n    endif\n  else if self.oclIsKindOf(ObjectLiteral) then\n    self.oclAsType(ObjectLiteral).propertyValues.value->forAll(v|v.isSideEffectFree())\n  else if self.oclIsKindOf(All) or self.oclIsKindOf(Replace) or self.oclIsKindOf(This) or self.oclIsKindOf(VariableExpression) or\n  self.oclIsKindOf(Literal) or self.oclIsKindOf(AnonymousFunctionExpr) then\n    true\n  else if self.oclIsKindOf(Selection) then\n    self.oclAsType(Selection).object.isSideEffectFree()\n  else\n    false\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif\n  endif'"
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
	 * @model annotation="http://de.hpi.sam.bp2009.OCL body='if self=e then\n    true\n  else\n  if self.oclIsKindOf(NumberLiteral) and e.oclIsKindOf(NumberLiteral) then\n    self.oclAsType(NumberLiteral).literal=e.oclAsType(NumberLiteral).literal\n  else\n    if self.oclIsKindOf(StringLiteral) and e.oclIsKindOf(StringLiteral) then\n      self.oclAsType(StringLiteral).literal=e.oclAsType(StringLiteral).literal\n    else\n      if self.oclIsKindOf(ObjectLiteral) and e.oclIsKindOf(ObjectLiteral) then\n        self.oclAsType(ObjectLiteral).isEqualTo(e.oclAsType(ObjectLiteral))\n      else\n        if self.oclIsKindOf(VariableExpression) and e.oclIsKindOf(VariableExpression) then\n          self.oclAsType(VariableExpression).variable = e.oclAsType(VariableExpression).variable\n        else\n          false\n        endif\n      endif\n    endif\n  endif\n  endif'"
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
	 * @model kind="operation"
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.oclIsKindOf(VariableExpression) then\n    if self.oclAsType(VariableExpression).variable.oclIsKindOf(Iterator) then\n      self.oclAsType(VariableExpression).variable.oclAsType(Iterator)->select(i | i.fromClause->notEmpty())->asSet()\n    else\n      Set{}\n    endif\n  else\n    if self.oclIsKindOf(Replace) then\n      self.oclAsType(Replace).object.getUsedAliases()->union(\n      self.oclAsType(Replace).steps.filterFunction.getUsedAliases()->flatten()->asSet())->union(\n      self.oclAsType(Replace).with.getUsedAliases())\n    else\n      if self.oclIsKindOf(Selection) then\n        self.oclAsType(Selection).object.getUsedAliases()->union(\n        self.oclAsType(Selection).selectionExpr.getUsedAliases())\n      else\n        if self.oclIsKindOf(ObjectBasedExpression) then\n          let objectAliases:Set(Iterator) = self.oclAsType(ObjectBasedExpression).object.getUsedAliases() in\n          if self.oclIsKindOf(MethodCallExpression) then\n            objectAliases->union(self.oclAsType(MethodCallExpression).parameters.getUsedAliases()->flatten()->asSet())\n          else\n            objectAliases\n          endif\n        else\n          if self.oclIsKindOf(Equals) then\n            self.oclAsType(Equals).left.getUsedAliases()->union(self.oclAsType(Equals).right.getUsedAliases())\n          else\n            if self.oclIsKindOf(FunctionCallExpression) then\n              self.oclAsType(FunctionCallExpression).calledBlock.getUsedAliases()->union(\n                           self.oclAsType(FunctionCallExpression).parameters.getUsedAliases()->flatten()->asSet())\n            else\n              if self.oclIsKindOf(Ternary) then\n                let sat:Ternary = self.oclAsType(Ternary) in\n                sat.condition.getUsedAliases()->union(sat.trueExpr.getUsedAliases())->union(sat.falseExpr.getUsedAliases())\n             else\n                 if self.oclIsKindOf(CollectionExpressionWithArgument) then\n                  self.oclAsType(CollectionExpressionWithArgument).argument.getUsedAliases()->union(\n                  self.oclAsType(CollectionExpressionWithArgument).source.getUsedAliases())\n                else\n                  if self.oclIsKindOf(Iterate) then\n                    self.oclAsType(Iterate).iteratorExpression.getUsedAliases()->union(\n                    self.oclAsType(Iterate).accumulator.initExpression.getUsedAliases())->union(\n                    self.oclAsType(Iterate).source.getUsedAliases())\n                  else\n                    if self.oclIsKindOf(OqlQuery) then\n                      self.oclAsType(OqlQuery).fromClauses.fromExpression.getUsedAliases()->flatten()->asSet()->union(\n                      self.oclAsType(OqlQuery).condition.getUsedAliases())\n                    else\n                      Set{}\n                    endif\n                  endif\n                endif\n              endif\n            endif\n          endif\n        endif\n      endif\n    endif\n  endif'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	Iterator getUsedAliases();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='self.addNamedValuesWithNewNames(\n\n  -- First, collect those NamedValues defined immediately for this expression:\n  -- an iterate\'s body expression sees the iterators and the accumulator\n  let accumulator:Set(NamedValue)=self.inIterator.accumulator->asSet() in\n  let iterators:Set(NamedValue)=self.inIterator.iterators->asSet() in\n  -- an OQL \"from\" clause sees all aliases left of it\n  let oqlAliases:Set(NamedValue)=(if self.fromClause->notEmpty() then\n    let fromClauses:OrderedSet(FromClause) = self.fromClause.fromClauseOfOqlQuery.fromClauses in\n    let fcIndex:Integer = fromClauses->indexOf(self.fromClause) in\n      Sequence{1..-1+fcIndex}->collect(i | fromClauses->at(i).alias)->asSet()\n  else\n    Set{}\n  endif)->union(\n  -- an OQL \"where\" clause sees all aliases defined by any of the OQL expression\'s \"from\" entries\n  self.conditionOfOqlQuery.fromClauses.alias->asSet()) in\n  -- a Selection defines an implicit iterator for its filter expression\n  let selectionIterator:Set(NamedValue)=self.selection.iterator->asSet() in\n  -- a GroupBy\'s mapExpression sees all dimension iterators and the groupedFacts iterator\n  let groupByMapExpressionIterators:Set(NamedValue)=self.mapExpressionOfGroupBy.groupedFacts->asSet()->union(\n                                                    self.mapExpressionOfGroupBy.dimensions.iterator->asSet()) in\n  -- a GroupBy\'s dimension expression sees the facts iterator\n  let groupByDimensionFactIterator:Set(NamedValue)=self.dimension.groupBy.fact->asSet() in\n\n  accumulator->union(iterators)->union(oqlAliases)->union(selectionIterator)->union(groupByMapExpressionIterators)->\n  union(groupByDimensionFactIterator),\n\n  -- Then, add those defined by owning structures such as owning statements or owning expressions\n  -- an expression that is used by an ExpressionStatement or as condition in a Conditional sees all named values that the statement sees\n  if self.actualObjectParameter.owningClassTypeDefinition->notEmpty() then\n    self.actualObjectParameter.owningClassTypeDefinition.getNamedValuesInScope()\n  else\n    if self.initExpressionFor.namedValueDeclaration->notEmpty() then\n      self.initExpressionFor.namedValueDeclaration.getNamedValuesInScope()\n    else\n      if self.expressionStatement->notEmpty() then\n        self.expressionStatement.getNamedValuesInScope()\n      else\n        if self.conditional->notEmpty() then\n          if self.conditional.oclIsKindOf(ConditionalStatement) then\n            self.conditional.oclAsType(ConditionalStatement).getNamedValuesInScope()\n          else\n            self.conditional.oclAsType(ConditionalExpression).getNamedValuesInScope()\n          endif\n        else\n          if self.argumentOf->notEmpty() and self.argumentOf.oclIsKindOf(StatementWithArgument) then\n            self.argumentOf.oclAsType(StatementWithArgument).getNamedValuesInScope()\n          else\n            -- add all variables in scope for owning expressions\n            let oe:Expression = self.getOwningExpression() in\n              if oe->isEmpty() then\n                Set{}\n              else\n                oe.getNamedValuesInScope()\n              endif\n          endif\n        endif\n      endif\n    endif\n  endif\n  )'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	NamedValue getNamedValuesInScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this expression is composed by another expression, determines the composing expression. Otherwise, an empty result is returned.
	 * 
	 * The issue with this operation is that each time a new inbound composite relatioship is added to Expression, this operation needs to be extended accordingly.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='let objectBasedExpressions:Set(Expression)=self.objectBasedExpression->asSet() in\n  let argumentsOf:Set(Expression)=self.argumentOf->select(ao | ao.oclIsKindOf(Expression)).oclAsType(ExpressionWithArgument)->asSet() in\n  let equals:Set(Expression)=Set{}->union(self.leftOfEquals->asSet())->union(self.rightOfEquals->asSet()) in\n  let blocksOfFunctionCallExpression:Set(Expression)=self.blockOfFunctionCallExpression->asSet() in\n  let signatureCalls:Set(Expression)=self.usedAsArgumentInSignatureCall->asSet() in\n  let creationExpression:Set(Expression)=if self.oclIsKindOf(MethodCallExpression) then\n    self.oclAsType(MethodCallExpression).creationExpression->asSet()\n  else\n    Set{}\n  endif in\n  let ternary:Set(Expression)=self.trueOfTernary->asSet()->union(self.falseOfTernary->asSet()) in\n  let conditional:Set(Expression)=if self.conditional->notEmpty() and self.conditional.oclIsKindOf(ConditionalExpression) then\n    self.conditional.oclAsType(ConditionalExpression)->asSet()\n  else\n    Set{}\n  endif in\n  let replace:Set(Expression)=self.withOfReplace->asSet()->union(self.navigationStep.replace->asSet()) in\n  let oqlQuery:Set(Expression)=self.conditionOfOqlQuery->asSet()->union(self.fromClause.fromClauseOfOqlQuery->asSet()) in\n  let selection:Set(Expression)=self.selection->asSet() in\n  let objectLiteral:Set(Expression)=self.valueInit.objectLiteral->asSet() in\n  let iterator:Set(Expression)=self.inIterator->asSet() in\n  let collectionExpression:Set(Expression)=self.collectionExpression->asSet() in\n  let all:Set(Expression)=self.all->asSet() in\n  let valueInitInObjectLiteral:Set(Expression)=self.valueInit.objectLiteral->asSet() in\n  let dimensionExpression:Set(Expression)=self.cellSetOfDimensionExpression->asSet()->union(\n                                                                   self.factsOfDimensionExpression->asSet()) in\n  let groupByExpression:Set(Expression)=self.dimension.groupBy->asSet()->union(\n                                                                   self.mapExpressionOfGroupBy->asSet()) in\n\n  objectBasedExpressions->union(argumentsOf)->union(equals)->union(blocksOfFunctionCallExpression)->union(\n  signatureCalls)->union(creationExpression)->union(ternary)->union(conditional)->union(replace)->union(\n  oqlQuery)->union(selection)->union(objectLiteral)->union(iterator)->union(collectionExpression)->union(\n  all)->union(valueInitInObjectLiteral)->union(dimensionExpression)->union(groupByExpression)->any(true)'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	Expression getOwningExpression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='let oe:Expression = self.getOwningExpression() in\n  if oe->notEmpty() then\n    oe.getOwningClass()\n  else\n    if self.expressionStatement->notEmpty() then\n      self.expressionStatement.getOwningClass()\n    else\n      if self.conditional->notEmpty() and self.conditional.oclIsKindOf(Statement) then\n        self.conditional.oclAsType(ConditionalStatement).getOwningClass()\n      else\n        if self.argumentOf->notEmpty() and self.argumentOf.oclIsKindOf(StatementWithArgument) then\n          self.argumentOf.oclAsType(StatementWithArgument).getOwningClass()\n        else\n          if self.initExpressionFor.namedValueDeclaration->notEmpty() then\n            self.initExpressionFor.namedValueDeclaration.getOwningClass()\n          else\n            null\n          endif\n        endif\n      endif\n    endif\n  endif'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	SapClass getOwningClass();

} // Expression
