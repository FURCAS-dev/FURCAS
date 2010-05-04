/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.TypedElement#getOwnedTypeDefinition <em>Owned Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface TypedElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Owned Type Definition</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link data.classes.TypeDefinition#getOwnerTypedElement <em>Owner Typed Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Type Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Type Definition</em>' containment reference.
   * @see #setOwnedTypeDefinition(TypeDefinition)
   * @see data.classes.ClassesPackage#getTypedElement_OwnedTypeDefinition()
   * @see data.classes.TypeDefinition#getOwnerTypedElement
   * @model opposite="ownerTypedElement" containment="true"
   * @generated
   */
  TypeDefinition getOwnedTypeDefinition();

  /**
   * Sets the value of the '{@link data.classes.TypedElement#getOwnedTypeDefinition <em>Owned Type Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Type Definition</em>' containment reference.
   * @see #getOwnedTypeDefinition()
   * @generated
   */
  void setOwnedTypeDefinition(TypeDefinition value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A typed element consisting of a type with a multiplicity conforms to another typed element if this typed element's type conforms to the other type element's type, and this type element's multiplicity "conforms" to the other type element's multiplicity. In particular, equal multiplicities conform to each other.
   * 
   * TODO: decide if and how non-equal multiplicites may still conform; for example, a single element may implicitly conform to a collection of elements of conforming type; however, additions to the single element would not be possible.
   * <!-- end-model-doc -->
   * @model dataType="primitivetypes.Boolean"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='self = typedElement or  self.getType().conformsTo(typedElement.getType())'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  boolean conformsTo(TypedElement typedElement);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Determined the type of the element. If the element owns a type definition, that one is assumed to be the result. Otherwise, "polymorphically" (we will refactor this once we can defined OCL method bodies polymorphically) we determine the type of the respective element.
   * 
   * TODO the inference for Iterator elements used in an Iterate expression needs to resolve NestedTypeDefinitions; for non-NestedTypeDefinition type definitions it needs to reduce the multiplicity to exactly 1.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.ownedTypeDefinition->notEmpty() then    self.ownedTypeDefinition  else    if self.oclIsKindOf(Variable) then      self.oclAsType(Variable).initExpression.getType()    else if self.oclIsKindOf(Constant) then      if self.oclAsType(Constant).initExpression->notEmpty() then        self.oclAsType(Constant).initExpression.getType()      else         if self.oclAsType(Constant).\"iterate\"[dataaccess::expressions::collectionExpressions::IterateAccumulator]->notEmpty() then           if self.oclAsType(Constant).initExpression->notEmpty() then             self.oclAsType(Constant).initExpression.getType()           else             self.oclAsType(Constant).\"iterate\"[dataaccess::expressions::collectionExpressions::IterateAccumulator].iteratorExpression.getType()           endif         else           null         endif      endif    else if self.oclIsKindOf(Iterator) then      if self.oclAsType(Iterator).boundToFor->notEmpty() then        if self.oclAsType(Iterator).boundToFor.collection.getType().oclIsKindOf(NestedTypeDefinition) then          -- if the selection\'s object has a nested type definition, un-nest by one level          self.oclAsType(Iterator).boundToFor.collection.getType().oclAsType(NestedTypeDefinition).type        else          -- the tool should infer a better match; this as a better default than \"null\"          self.oclAsType(Iterator).boundToFor.collection.getType()        endif      else        let selection:Set(Expression)=self.oclAsType(Iterator).selection.object->asSet() in        let groupby:Set(Expression)=self.oclAsType(Iterator).factOfGroupBy.object->asSet() in        let iterateexp:Set(Expression)=self.oclAsType(Iterator).\"iterate\".source->asSet() in        let iteratesource:Set(Expression)=selection->union(groupby)->union(iterateexp) in        if iteratesource->notEmpty() then          if iteratesource->any(true).getType().oclIsKindOf(NestedTypeDefinition) then            -- if the Selection\'s/GroupBy\'s object has a nested type definition, un-nest by one level            iteratesource->any(true).getType().oclAsType(NestedTypeDefinition).type          else            -- In this case the tool should create a cloned tpye definition with multiplicities set to 1;            -- Just in case the tool doesn\'t do this and for the case where the object has upper            -- multiplicity 1, use the object\'s type as the default for the \"self\" iterator            iteratesource->any(true).getType()          endif        else          if self.oclAsType(Iterator).groupedFactsOfGroupBy->notEmpty() then            -- the groups of a group-by expression can re-used the facts type            self.oclAsType(Iterator).factOfGroupBy.object.getType()          else            if self.oclAsType(Iterator).dimension->notEmpty() then              -- the DimensionDefinition\'s expression defines the dimension iterator\'s type              self.oclAsType(Iterator).dimension.expression.getType()            else              -- Then we have no idea how to infer the Iterator\'s type              null            endif          endif        endif      endif    else if self.oclIsKindOf(Including) or self.oclIsKindOf(Excluding) then      self.oclAsType(CollectionExpression).source.getType()    else if self.oclIsKindOf(Iterate) then      self.oclAsType(Iterate).iteratorExpression.getType()    else if self.oclIsKindOf(Parameter) then      if self.oclAsType(Parameter).defaultValue->notEmpty() then        self.oclAsType(Parameter).defaultValue.getType()      else        if self.oclAsType(Parameter).ownerSignature.oclIsKindOf(MethodSignature) and        self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation->notEmpty() and        self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation.oclIsKindOf(AssociationEndSignatureImplementation) then  \tlet impl = self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation.oclAsType(AssociationEndSignatureImplementation) in            impl.end.type        else          if self.oclAsType(Parameter).ownerSignature.oclIsKindOf(FunctionSignature) then            if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).dimension->notEmpty() then              self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).dimension.cellSet.factsType            else              if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForValueFunction->notEmpty() then                self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForValueFunction.factsType              else                if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction->notEmpty() then                  if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.valueFunction->notEmpty() then                    self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.valueFunction.output                  else                    self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.factsType                  endif                else                  if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclIsKindOf(CellSet) then                    let pos:Integer = self.oclAsType(Parameter).ownerSignature.input->indexOf(self.oclAsType(Parameter)) in                    if pos = 1 then                      self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclAsType(CellSet).factsType                    else                      self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclAsType(CellSet).                          dimensions->at(-1+pos).characteristicFunction.output                    endif                  else                    null                  endif                endif              endif            endif          else            null          endif        endif      endif    else if self.oclIsKindOf(DimensionExpression) then      -- TODO Here, the multiplicity would have to be forced to 0..*      self.oclAsType(DimensionExpression).dimension.getType()    else if self.oclIsKindOf(VariableExpression) then      self.oclAsType(VariableExpression).variable.getType()    else if self.oclIsKindOf(SignatureCallExpression) then      self.oclAsType(SignatureCallExpression).getSignature().output    else if self.oclIsKindOf(AssociationEndNavigationExpression) then      self.oclAsType(AssociationEndNavigationExpression).toEnd.type    else if self.oclIsKindOf(Replace) then      self.oclAsType(Replace).object.getType()    else if self.oclIsKindOf(Ternary) then      -- Find the \"least\" TypeDefinition to which both, trueExpr.getType() and falseExpr.getType() conform.      -- We determine the more general of the two types; we cannot synthesize a new TypeDefinition in OCL.      -- Doing so would have to be done by explicit typing, setting the ownedTypeDefinition explicitly      if self.oclAsType(Ternary).trueExpr.getType().conformsTo(self.oclAsType(Ternary).falseExpr.getType()) then        self.oclAsType(Ternary).falseExpr.getType()      else        self.oclAsType(Ternary).trueExpr.getType()      endif    else if self.oclIsKindOf(Selection) then      self.oclAsType(Selection).object.getType()    else      null    endif    endif    endif    endif    endif    endif    endif    endif    endif    endif    endif    endif    endif  endif'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  TypeDefinition getType();

} // TypedElement
