/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypedElement.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
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
     * @model opposite="ownerTypedElement" containment="true" resolveProxies="true"
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
     * @model unique="false" required="true" ordered="false" typedElementUnique="false" typedElementRequired="true" typedElementOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self = typedElement or\n  self.getType().conformsTo(typedElement.getType())'"
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
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.ownedTypeDefinition->notEmpty() then\n    self.ownedTypeDefinition\n  else\n    if self.oclIsKindOf(behavioral::actions::Variable) then\n      self.oclAsType(behavioral::actions::Variable).initExpression.getType()\n    else if self.oclIsKindOf(behavioral::actions::Constant) then\n      if self.oclAsType(behavioral::actions::Constant).initExpression->notEmpty() then\n        self.oclAsType(behavioral::actions::Constant).initExpression.getType()\n      else\n         if self.oclAsType(behavioral::actions::Constant)._iterate->notEmpty() then\n           self.oclAsType(behavioral::actions::Constant)._iterate.iteratorExpression.getType()\n         else\n           null\n         endif\n      endif\n    else if self.oclIsKindOf(behavioral::actions::Iterator) then\n      if self.oclAsType(behavioral::actions::Iterator).boundToFor->notEmpty() then\n        if self.oclAsType(behavioral::actions::Iterator).boundToFor.collection.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then\n          -- if the selection\'s object has a nested type definition, un-nest by one level\n          self.oclAsType(behavioral::actions::Iterator).boundToFor.collection.getType().oclAsType(data::classes::NestedTypeDefinition).type\n        else\n          -- the tool should infer a better match; this as a better default than \"null\"\n          self.oclAsType(behavioral::actions::Iterator).boundToFor.collection.getType()\n        endif\n      else\n        let selection:Set(dataaccess::expressions::Expression)=self.oclAsType(behavioral::actions::Iterator).selection.object->asSet() in\n        let groupby:Set(dataaccess::expressions::Expression)=self.oclAsType(behavioral::actions::Iterator).factOfGroupBy.object->asSet() in\n        let iterateexp:Set(dataaccess::expressions::Expression)=self.oclAsType(behavioral::actions::Iterator)._iterate.source->asSet() in\n        let iteratesource:Set(dataaccess::expressions::Expression)=selection->union(groupby)->union(iterateexp) in\n        if iteratesource->notEmpty() then\n          if iteratesource->any(true).getType().oclIsKindOf(data::classes::NestedTypeDefinition) then\n            -- if the Selection\'s/GroupBy\'s object has a nested type definition, un-nest by one level\n            iteratesource->any(true).getType().oclAsType(data::classes::NestedTypeDefinition).type\n          else\n            -- In this case the tool should create a cloned tpye definition with multiplicities set to 1;\n            -- Just in case the tool doesn\'t do this and for the case where the object has upper\n            -- multiplicity 1, use the object\'s type as the default for the \"self\" iterator\n            iteratesource->any(true).getType()\n          endif\n        else\n          if self.oclAsType(behavioral::actions::Iterator).groupedFactsOfGroupBy->notEmpty() then\n            -- the groups of a group-by expression can re-used the facts type\n            self.oclAsType(behavioral::actions::Iterator).factOfGroupBy.object.getType()\n          else\n            if self.oclAsType(behavioral::actions::Iterator).dimension->notEmpty() then\n              -- the DimensionDefinition\'s expression defines the dimension iterator\'s type\n              self.oclAsType(behavioral::actions::Iterator).dimension.expression.getType()\n            else\n              -- Then we have no idea how to infer the Iterator\'s type\n              null\n            endif\n          endif\n        endif\n      endif\n    else if self.oclIsKindOf(dataaccess::expressions::collectionexpressions::Including) or self.oclIsKindOf(dataaccess::expressions::collectionexpressions::Excluding) then\n      self.oclAsType(dataaccess::expressions::collectionexpressions::CollectionExpression).source.getType()\n    else if self.oclIsKindOf(dataaccess::expressions::collectionexpressions::Iterate) then\n      self.oclAsType(dataaccess::expressions::collectionexpressions::Iterate).iteratorExpression.getType()\n    else if self.oclIsKindOf(Parameter) then\n      if self.oclAsType(Parameter).defaultValue->notEmpty() then\n        self.oclAsType(Parameter).defaultValue.getType()\n      else\n        if self.oclAsType(Parameter).ownerSignature.oclIsKindOf(MethodSignature) and\n        self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation->notEmpty() and\n        self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation.oclIsKindOf(AssociationEndSignatureImplementation) then\n  \tlet impl:AssociationEndSignatureImplementation = self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation.oclAsType(AssociationEndSignatureImplementation) in\n            impl.end.type\n        else\n          if self.oclAsType(Parameter).ownerSignature.oclIsKindOf(FunctionSignature) then\n            if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).dimension->notEmpty() then\n              self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).dimension.cellSet.factsType\n            else\n              if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForValueFunction->notEmpty() then\n                self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForValueFunction.factsType\n              else\n                if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction->notEmpty() then\n                  if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.valueFunction->notEmpty() then\n                    self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.valueFunction.output\n                  else\n                    self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.factsType\n                  endif\n                else\n                  if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclIsKindOf(dataaccess::analytics::CellSet) then\n                    let pos:Integer = self.oclAsType(Parameter).ownerSignature.input->indexOf(self.oclAsType(Parameter)) in\n                    if pos = 1 then\n                      self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclAsType(dataaccess::analytics::CellSet).factsType\n                    else\n                      self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclAsType(dataaccess::analytics::CellSet).\n                          dimensions->at(-1+pos).characteristicFunction.output\n                    endif\n                  else\n                    null\n                  endif\n                endif\n              endif\n            endif\n          else\n            null\n          endif\n        endif\n      endif\n    else if self.oclIsKindOf(dataaccess::analytics::DimensionExpression) then\n      -- TODO Here, the multiplicity would have to be forced to 0..*\n      self.oclAsType(dataaccess::analytics::DimensionExpression).dimensionParameter.getType()\n    else if self.oclIsKindOf(dataaccess::expressions::VariableExpression) then\n      self.oclAsType(dataaccess::expressions::VariableExpression).variable.getType()\n    else if self.oclIsKindOf(dataaccess::expressions::SignatureCallExpression) then\n      self.oclAsType(dataaccess::expressions::SignatureCallExpression).getSignature().output\n    else if self.oclIsKindOf(dataaccess::expressions::AssociationEndNavigationExpression) then\n      self.oclAsType(dataaccess::expressions::AssociationEndNavigationExpression).toEnd.type\n    else if self.oclIsKindOf(dataaccess::expressions::Replace) then\n      self.oclAsType(dataaccess::expressions::Replace).object.getType()\n    else if self.oclIsKindOf(dataaccess::expressions::Ternary) then\n      -- Find the \"least\" TypeDefinition to which both, trueExpr.getType() and falseExpr.getType() conform.\n      -- We determine the more general of the two types; we cannot synthesize a new TypeDefinition in OCL.\n      -- Doing so would have to be done by explicit typing, setting the ownedTypeDefinition explicitly\n      if self.oclAsType(dataaccess::expressions::Ternary).trueExpr.getType().conformsTo(self.oclAsType(dataaccess::expressions::Ternary).falseExpr.getType()) then\n        self.oclAsType(dataaccess::expressions::Ternary).falseExpr.getType()\n      else\n        self.oclAsType(dataaccess::expressions::Ternary).trueExpr.getType()\n      endif\n    else if self.oclIsKindOf(dataaccess::query::Selection) then\n      self.oclAsType(dataaccess::query::Selection).object.getType()\n    else\n      null\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	TypeDefinition getType();

} // TypedElement
