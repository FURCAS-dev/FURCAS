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
public interface TypedElement extends EObject {
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
	 * @model annotation="http://de.hpi.sam.bp2009.OCL body='self = typedElement or\n  self.getType().conformsTo(typedElement.getType())'"
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
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.ownedTypeDefinition->notEmpty() then\n    self.ownedTypeDefinition\n  else\n    if self.oclIsKindOf(Variable) then\n      self.oclAsType(Variable).initExpression.getType()\n    else if self.oclIsKindOf(Constant) then\n      if self.oclAsType(Constant).initExpression->notEmpty() then\n        self.oclAsType(Constant).initExpression.getType()\n      else\n         if self.oclAsType(Constant).\"iterate\"[dataaccess::expressions::collectionExpressions::IterateAccumulator]->notEmpty() then\n           if self.oclAsType(Constant).initExpression->notEmpty() then\n             self.oclAsType(Constant).initExpression.getType()\n           else\n             self.oclAsType(Constant).\"iterate\"[dataaccess::expressions::collectionExpressions::IterateAccumulator].iteratorExpression.getType()\n           endif\n         else\n           null\n         endif\n      endif\n    else if self.oclIsKindOf(Iterator) then\n      if self.oclAsType(Iterator).boundToFor->notEmpty() then\n        if self.oclAsType(Iterator).boundToFor.collection.getType().oclIsKindOf(NestedTypeDefinition) then\n          -- if the selection\'s object has a nested type definition, un-nest by one level\n          self.oclAsType(Iterator).boundToFor.collection.getType().oclAsType(NestedTypeDefinition).type\n        else\n          -- the tool should infer a better match; this as a better default than \"null\"\n          self.oclAsType(Iterator).boundToFor.collection.getType()\n        endif\n      else\n        let selection:Set(Expression)=self.oclAsType(Iterator).selection.object->asSet() in\n        let groupby:Set(Expression)=self.oclAsType(Iterator).factOfGroupBy.object->asSet() in\n        let iterateexp:Set(Expression)=self.oclAsType(Iterator).\"iterate\".source->asSet() in\n        let iteratesource:Set(Expression)=selection->union(groupby)->union(iterateexp) in\n        if iteratesource->notEmpty() then\n          if iteratesource->any(true).getType().oclIsKindOf(NestedTypeDefinition) then\n            -- if the Selection\'s/GroupBy\'s object has a nested type definition, un-nest by one level\n            iteratesource->any(true).getType().oclAsType(NestedTypeDefinition).type\n          else\n            -- In this case the tool should create a cloned tpye definition with multiplicities set to 1;\n            -- Just in case the tool doesn\'t do this and for the case where the object has upper\n            -- multiplicity 1, use the object\'s type as the default for the \"self\" iterator\n            iteratesource->any(true).getType()\n          endif\n        else\n          if self.oclAsType(Iterator).groupedFactsOfGroupBy->notEmpty() then\n            -- the groups of a group-by expression can re-used the facts type\n            self.oclAsType(Iterator).factOfGroupBy.object.getType()\n          else\n            if self.oclAsType(Iterator).dimension->notEmpty() then\n              -- the DimensionDefinition\'s expression defines the dimension iterator\'s type\n              self.oclAsType(Iterator).dimension.expression.getType()\n            else\n              -- Then we have no idea how to infer the Iterator\'s type\n              null\n            endif\n          endif\n        endif\n      endif\n    else if self.oclIsKindOf(Including) or self.oclIsKindOf(Excluding) then\n      self.oclAsType(CollectionExpression).source.getType()\n    else if self.oclIsKindOf(Iterate) then\n      self.oclAsType(Iterate).iteratorExpression.getType()\n    else if self.oclIsKindOf(Parameter) then\n      if self.oclAsType(Parameter).defaultValue->notEmpty() then\n        self.oclAsType(Parameter).defaultValue.getType()\n      else\n        if self.oclAsType(Parameter).ownerSignature.oclIsKindOf(MethodSignature) and\n        self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation->notEmpty() and\n        self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation.oclIsKindOf(AssociationEndSignatureImplementation) then\n  \tlet impl:AssociationEndSignatureImplementation = self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation.oclAsType(AssociationEndSignatureImplementation) in\n            impl.end.type\n        else\n          if self.oclAsType(Parameter).ownerSignature.oclIsKindOf(FunctionSignature) then\n            if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).dimension->notEmpty() then\n              self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).dimension.cellSet.factsType\n            else\n              if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForValueFunction->notEmpty() then\n                self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForValueFunction.factsType\n              else\n                if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction->notEmpty() then\n                  if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.valueFunction->notEmpty() then\n                    self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.valueFunction.output\n                  else\n                    self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.factsType\n                  endif\n                else\n                  if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclIsKindOf(CellSet) then\n                    let pos:Integer = self.oclAsType(Parameter).ownerSignature.input->indexOf(self.oclAsType(Parameter)) in\n                    if pos = 1 then\n                      self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclAsType(CellSet).factsType\n                    else\n                      self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclAsType(CellSet).\n                          dimensions->at(-1+pos).characteristicFunction.output\n                    endif\n                  else\n                    null\n                  endif\n                endif\n              endif\n            endif\n          else\n            null\n          endif\n        endif\n      endif\n    else if self.oclIsKindOf(DimensionExpression) then\n      -- TODO Here, the multiplicity would have to be forced to 0..*\n      self.oclAsType(DimensionExpression).dimension.getType()\n    else if self.oclIsKindOf(VariableExpression) then\n      self.oclAsType(VariableExpression).variable.getType()\n    else if self.oclIsKindOf(SignatureCallExpression) then\n      self.oclAsType(SignatureCallExpression).getSignature().output\n    else if self.oclIsKindOf(AssociationEndNavigationExpression) then\n      self.oclAsType(AssociationEndNavigationExpression).toEnd.type\n    else if self.oclIsKindOf(Replace) then\n      self.oclAsType(Replace).object.getType()\n    else if self.oclIsKindOf(Ternary) then\n      -- Find the \"least\" TypeDefinition to which both, trueExpr.getType() and falseExpr.getType() conform.\n      -- We determine the more general of the two types; we cannot synthesize a new TypeDefinition in OCL.\n      -- Doing so would have to be done by explicit typing, setting the ownedTypeDefinition explicitly\n      if self.oclAsType(Ternary).trueExpr.getType().conformsTo(self.oclAsType(Ternary).falseExpr.getType()) then\n        self.oclAsType(Ternary).falseExpr.getType()\n      else\n        self.oclAsType(Ternary).trueExpr.getType()\n      endif\n    else if self.oclIsKindOf(Selection) then\n      self.oclAsType(Selection).object.getType()\n    else\n      null\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n  endif'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	TypeDefinition getType();

} // TypedElement
