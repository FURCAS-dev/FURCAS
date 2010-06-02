/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
 * @model annotation="http://de.hpi.sam.bp2009.OCL ObjectTypeMustConformToFunctionArgument='let fstd:data::classes::TypeDefinition = self.argument.getType() in\n  let sig:data::classes::Signature = fstd.oclAsType(data::classes::FunctionSignatureTypeDefinition).signature in\n  let t:data::classes::TypeDefinition = self.object.getType() in\n  let argT:data::classes::TypeDefinition = sig.input->at(1).getType() in\n  -- if multiplicities match including multiplicities, that\'s ok\n  t.conformsTo(argT) or\n  -- otherwise, pick single multiplicity from object and try again\n  t.conformsToIgnoringMultiplicity(argT) or\n  (t.oclIsKindOf(data::classes::NestedTypeDefinition) and t.oclAsType(data::classes::NestedTypeDefinition).type.conformsTo(argT))' ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput='let fstd:TypeDefinition = self.argument.getType() in\n  fstd.oclIsKindOf(data::classes::FunctionSignatureTypeDefinition) and\n  (let sig:Signature = fstd.oclAsType(data::classes::FunctionSignatureTypeDefinition).signature in\n  (sig.output->notEmpty() and\n  sig.input->size() = 1))' MapFunctionMustBeSideEffectFree='self.argument.getType().oclAsType(data::classes::FunctionSignatureTypeDefinition).signature.sideEffectFree'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ObjectTypeMustConformToFunctionArgument ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput MapFunctionMustBeSideEffectFree'"
 * @generated
 */
public interface Map extends ExpressionWithArgument, ObjectBasedExpression {
} // Map
