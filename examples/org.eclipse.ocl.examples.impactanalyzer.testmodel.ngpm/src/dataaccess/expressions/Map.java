/**
 * <copyright>
 * </copyright>
 *
 * $Id: Map.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A map expression operates on a (multi-)object (therefore it is an ObjectBaseExpression) and subjects each element of this (multi-)object as argument to the function expected as argument (therefore, it is an ExpressionWithArgument). The single multiplicity of the object expression must conform to the single input argument of the function signature of the FunctionSignatureTypeDefinition defining the type of the argument.
 * <!-- end-model-doc -->
 *
 *
 * @see dataaccess.expressions.ExpressionsPackage#getMap()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ObjectTypeMustConformToFunctionArgument='let fstd:data::classes::TypeDefinition = self.argument.getType() in\r\n  let sig:data::classes::Signature = fstd.oclAsType(data::classes::FunctionSignatureTypeDefinition).signature in\r\n  let t:data::classes::TypeDefinition = self.object.getType() in\r\n  let argT:data::classes::TypeDefinition = sig.input->at(1).getType() in\r\n  -- if multiplicities match including multiplicities, that\'s ok\r\n  t.conformsTo(argT) or\r\n  -- otherwise, pick single multiplicity from object and try again\r\n  t.conformsToIgnoringMultiplicity(argT) or\r\n  (t.oclIsKindOf(data::classes::NestedTypeDefinition) and t.oclAsType(data::classes::NestedTypeDefinition).type.conformsTo(argT))' ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput='let fstd:data::classes::TypeDefinition = self.argument.getType() in\r\n  fstd.oclIsKindOf(data::classes::FunctionSignatureTypeDefinition) and\r\n  (let sig:data::classes::Signature = fstd.oclAsType(data::classes::FunctionSignatureTypeDefinition).signature in\r\n  (sig.output->notEmpty() and\r\n  sig.input->size() = 1))' MapFunctionMustBeSideEffectFree='self.argument.getType().oclAsType(data::classes::FunctionSignatureTypeDefinition).signature.sideEffectFree'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ObjectTypeMustConformToFunctionArgument ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput MapFunctionMustBeSideEffectFree'"
 * @generated
 */
public interface Map extends ExpressionWithArgument, ObjectBasedExpression {
} // Map
