/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;

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
public interface Expression extends TypedElement, InScope
{
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
   * @model kind="operation" dataType="primitivetypes.Boolean"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='let parametersAndSignatureAreSideEffectFree:Boolean =    self.oclIsKindOf(SignatureCallExpression) implies      (self.oclAsType(SignatureCallExpression).parameters->forAll(p|p.isSideEffectFree())       and self.oclAsType(SignatureCallExpression).getSignature().sideEffectFree)  in  if self.oclIsKindOf(ObjectBasedExpression) then    self.oclAsType(ObjectBasedExpression).object.isSideEffectFree() and    if self.oclIsKindOf(SignatureCallExpression) then      parametersAndSignatureAreSideEffectFree    else      if self.oclIsKindOf(Replace) then        self.oclAsType(Replace).with.isSideEffectFree()      else        if self.oclIsKindOf(ExpressionWithArgument) and self.oclAsType(ExpressionWithArgument).argument->notEmpty() then          self.oclAsType(ExpressionWithArgument).argument.isSideEffectFree()        else          true        endif      endif    endif  else if self.oclIsKindOf(FunctionCallExpression) then    parametersAndSignatureAreSideEffectFree and self.oclAsType(FunctionCallExpression).calledBlock.isSideEffectFree()  else if self.oclIsKindOf(Equals) then    self.oclAsType(Equals).left.isSideEffectFree() and self.oclAsType(Equals).right.isSideEffectFree()  else if self.oclIsKindOf(ObjectCreationExpression) then    self.oclAsType(ObjectCreationExpression).classToInstantiate.valueType  else if self.oclIsKindOf(DimensionExpression) then    self.oclAsType(DimensionExpression).dimension.ownerSignature.sideEffectFree  else if self.oclIsKindOf(Ternary) then    self.oclAsType(Ternary).condition.isSideEffectFree() and    self.oclAsType(Ternary).trueExpr.isSideEffectFree() and    self.oclAsType(Ternary).falseExpr.isSideEffectFree()  else if self.oclIsKindOf(CollectionExpression) then    self.oclAsType(CollectionExpression).source.isSideEffectFree() and    if self.oclIsKindOf(Iterate) then      (self.oclAsType(Iterate).accumulator.initExpression->notEmpty() implies         self.oclAsType(Iterate).accumulator.initExpression.isSideEffectFree()) and      self.oclAsType(Iterate).iteratorExpression.isSideEffectFree()    else      true    endif  else if self.oclIsKindOf(ObjectLiteral) then    self.oclAsType(ObjectLiteral).propertyValues.value->forAll(v|v.isSideEffectFree())  else if self.oclIsKindOf(All) or self.oclIsKindOf(Replace) or self.oclIsKindOf(This) or self.oclIsKindOf(VariableExpression) or  self.oclIsKindOf(Literal) or self.oclIsKindOf(AnonymousFunctionExpr) then    true  else if self.oclIsKindOf(Selection) then    self.oclAsType(Selection).object.isSideEffectFree()  else    false  endif  endif  endif  endif  endif  endif  endif  endif  endif  endif'"
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
   * @model dataType="primitivetypes.Boolean"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='if self=e then    true  else  if self.oclIsKindOf(NumberLiteral) and e.oclIsKindOf(NumberLiteral) then    self.oclAsType(NumberLiteral).literal=e.oclAsType(NumberLiteral).literal  else    if self.oclIsKindOf(StringLiteral) and e.oclIsKindOf(StringLiteral) then      self.oclAsType(StringLiteral).literal=e.oclAsType(StringLiteral).literal    else      if self.oclIsKindOf(ObjectLiteral) and e.oclIsKindOf(ObjectLiteral) then        self.oclAsType(ObjectLiteral).isEqualTo(e.oclAsType(ObjectLiteral))      else        if self.oclIsKindOf(VariableExpression) and e.oclIsKindOf(VariableExpression) then          self.oclAsType(VariableExpression).variable = e.oclAsType(VariableExpression).variable        else          false        endif      endif    endif  endif  endif'"
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
   *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.oclIsKindOf(VariableExpression) then    if self.oclAsType(VariableExpression).variable.oclIsKindOf(Iterator) then      self.oclAsType(VariableExpression).variable.oclAsType(Iterator)->select(i | i.fromClause->notEmpty())->asSet()    else      Set{}    endif  else    if self.oclIsKindOf(Replace) then      self.oclAsType(Replace).object.getUsedAliases()->union(      self.oclAsType(Replace).steps.filterFunction.getUsedAliases()->flatten()->asSet())->union(      self.oclAsType(Replace).with.getUsedAliases())    else      if self.oclIsKindOf(Selection) then        self.oclAsType(Selection).object.getUsedAliases()->union(        self.oclAsType(Selection).selectionExpr.getUsedAliases())      else        if self.oclIsKindOf(ObjectBasedExpression) then          let objectAliases = self.oclAsType(ObjectBasedExpression).object.getUsedAliases() in          if self.oclIsKindOf(MethodCallExpression) then            objectAliases->union(self.oclAsType(MethodCallExpression).parameters.getUsedAliases()->flatten()->asSet())          else            objectAliases          endif        else          if self.oclIsKindOf(Equals) then            self.oclAsType(Equals).left.getUsedAliases()->union(self.oclAsType(Equals).right.getUsedAliases())          else            if self.oclIsKindOf(FunctionCallExpression) then              self.oclAsType(FunctionCallExpression).calledBlock.getUsedAliases()->union(                           self.oclAsType(FunctionCallExpression).parameters.getUsedAliases()->flatten()->asSet())            else              if self.oclIsKindOf(Ternary) then                let sat = self.oclAsType(Ternary) in                sat.condition.getUsedAliases()->union(sat.trueExpr.getUsedAliases())->union(sat.falseExpr.getUsedAliases())             else                 if self.oclIsKindOf(CollectionExpressionWithArgument) then                  self.oclAsType(CollectionExpressionWithArgument).argument.getUsedAliases()->union(                  self.oclAsType(CollectionExpressionWithArgument).source.getUsedAliases())                else                  if self.oclIsKindOf(Iterate) then                    self.oclAsType(Iterate).iteratorExpression.getUsedAliases()->union(                    self.oclAsType(Iterate).accumulator.initExpression.getUsedAliases())->union(                    self.oclAsType(Iterate).source.getUsedAliases())                  else                    if self.oclIsKindOf(OqlQuery) then                      self.oclAsType(OqlQuery).fromClauses.fromExpression.getUsedAliases()->flatten()->asSet()->union(                      self.oclAsType(OqlQuery).condition.getUsedAliases())                    else                      Set{}                    endif                  endif                endif              endif            endif          endif        endif      endif    endif  endif'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  Iterator getUsedAliases();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='self.addNamedValuesWithNewNames(  -- First, collect those NamedValues defined immediately for this expression:  -- an iterate\'s body expression sees the iterators and the accumulator  let accumulator:Set(NamedValue)=self.inIterator.accumulator->asSet() in  let iterators:Set(NamedValue)=self.inIterator.iterators->asSet() in  -- an OQL \"from\" clause sees all aliases left of it  let oqlAliases:Set(NamedValue)=(if self.fromClause->notEmpty() then    let fromClauses = self.fromClause.fromClauseOfOqlQuery.fromClauses in    let fcIndex = fromClauses->indexOf(self.fromClause) in      Sequence{1..-1+fcIndex}->collect(i | fromClauses->at(i).alias)->asSet()  else    Set{}  endif)->union(  -- an OQL \"where\" clause sees all aliases defined by any of the OQL expression\'s \"from\" entries  self.conditionOfOqlQuery.fromClauses.alias->asSet()) in  -- a Selection defines an implicit iterator for its filter expression  let selectionIterator:Set(NamedValue)=self.selection.iterator->asSet() in  -- a GroupBy\'s mapExpression sees all dimension iterators and the groupedFacts iterator  let groupByMapExpressionIterators:Set(NamedValue)=self.mapExpressionOfGroupBy.groupedFacts->asSet()->union(                                                    self.mapExpressionOfGroupBy.dimensions.iterator->asSet()) in  -- a GroupBy\'s dimension expression sees the facts iterator  let groupByDimensionFactIterator:Set(NamedValue)=self.dimension.groupBy.fact->asSet() in  accumulator->union(iterators)->union(oqlAliases)->union(selectionIterator)->union(groupByMapExpressionIterators)->  union(groupByDimensionFactIterator),  -- Then, add those defined by owning structures such as owning statements or owning expressions  -- an expression that is used by an ExpressionStatement or as condition in a Conditional sees all named values that the statement sees  if self.actualObjectParameter.owningClassTypeDefinition->notEmpty() then    self.actualObjectParameter.owningClassTypeDefinition.getNamedValuesInScope()  else    if self.initExpressionFor.namedValueDeclaration->notEmpty() then      self.initExpressionFor.namedValueDeclaration.getNamedValuesInScope()    else      if self.expressionStatement->notEmpty() then        self.expressionStatement.getNamedValuesInScope()      else        if self.conditional->notEmpty() then          if self.conditional.oclIsKindOf(ConditionalStatement) then            self.conditional.oclAsType(ConditionalStatement).getNamedValuesInScope()          else            self.conditional.oclAsType(ConditionalExpression).getNamedValuesInScope()          endif        else          if self.argumentOf->notEmpty() and self.argumentOf.oclIsKindOf(StatementWithArgument) then            self.argumentOf.oclAsType(StatementWithArgument).getNamedValuesInScope()          else            -- add all variables in scope for owning expressions            let oe = self.getOwningExpression() in              if oe->isEmpty() then                Set{}              else                oe.getNamedValuesInScope()              endif          endif        endif      endif    endif  endif  )'"
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
   *        annotation="http://de.hpi.sam.bp2009.OCL body='let objectBasedExpressions:Set(Expression)=self.objectBasedExpression->asSet() in  let argumentsOf:Set(Expression)=self.argumentOf->select(ao | ao.oclIsKindOf(Expression)).oclAsType(ExpressionWithArgument)->asSet() in  let equals:Set(Expression)=Set{}->union(self.leftOfEquals->asSet())->union(self.rightOfEquals->asSet()) in  let blocksOfFunctionCallExpression:Set(Expression)=self.blockOfFunctionCallExpression->asSet() in  let signatureCalls:Set(Expression)=self.usedAsArgumentInSignatureCall->asSet() in  let creationExpression:Set(Expression)=if self.oclIsKindOf(MethodCallExpression) then    self.oclAsType(MethodCallExpression).creationExpression->asSet()  else    Set{}  endif in  let ternary:Set(Expression)=self.trueOfTernary->asSet()->union(self.falseOfTernary->asSet()) in  let conditional:Set(Expression)=if self.conditional->notEmpty() and self.conditional.oclIsKindOf(ConditionalExpression) then    self.conditional.oclAsType(ConditionalExpression)->asSet()  else    Set{}  endif in  let replace:Set(Expression)=self.withOfReplace->asSet()->union(self.navigationStep.replace->asSet()) in  let oqlQuery:Set(Expression)=self.conditionOfOqlQuery->asSet()->union(self.fromClause.fromClauseOfOqlQuery->asSet()) in  let selection:Set(Expression)=self.selection->asSet() in  let objectLiteral:Set(Expression)=self.valueInit.objectLiteral->asSet() in  let iterator:Set(Expression)=self.inIterator->asSet() in  let collectionExpression:Set(Expression)=self.collectionExpression->asSet() in  let all:Set(Expression)=self.all->asSet() in  let valueInitInObjectLiteral:Set(Expression)=self.valueInit.objectLiteral->asSet() in  let dimensionExpression:Set(Expression)=self.cellSetOfDimensionExpression->asSet()->union(                                                                   self.factsOfDimensionExpression->asSet()) in  let groupByExpression:Set(Expression)=self.dimension.groupBy->asSet()->union(                                                                   self.mapExpressionOfGroupBy->asSet()) in  objectBasedExpressions->union(argumentsOf)->union(equals)->union(blocksOfFunctionCallExpression)->union(  signatureCalls)->union(creationExpression)->union(ternary)->union(conditional)->union(replace)->union(  oqlQuery)->union(selection)->union(objectLiteral)->union(iterator)->union(collectionExpression)->union(  all)->union(valueInitInObjectLiteral)->union(dimensionExpression)->union(groupByExpression)->any(true)'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  Expression getOwningExpression();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='let oe = self.getOwningExpression() in  if oe->notEmpty() then    oe.getOwningClass()  else    if self.expressionStatement->notEmpty() then      self.expressionStatement.getOwningClass()    else      if self.conditional->notEmpty() and self.conditional.oclIsKindOf(Statement) then        self.conditional.oclAsType(ConditionalStatement).getOwningClass()      else        if self.argumentOf->notEmpty() and self.argumentOf.oclIsKindOf(StatementWithArgument) then          self.argumentOf.oclAsType(StatementWithArgument).getOwningClass()        else          if self.initExpressionFor.namedValueDeclaration->notEmpty() then            self.initExpressionFor.namedValueDeclaration.getOwningClass()          else            null          endif        endif      endif    endif  endif'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  SapClass getOwningClass();

} // Expression
