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
 * @model annotation="http://de.hpi.sam.bp2009.OCL ObjectTypeMustConformToFunctionArgument='let fstd = self.argument.getType() in\r\n  let sig = fstd.oclAsType(FunctionSignatureTypeDefinition).signature in\r\n  let t = self.object.getType() in\r\n  let argT = sig.input->at(1).getType() in\r\n  -- if multiplicities match including multiplicities, that\'s ok\r\n  t.conformsTo(argT) or\r\n  -- otherwise, pick single multiplicity from object and try again\r\n  t.conformsToIgnoringMultiplicity(argT) or\r\n  (t.oclIsKindOf(NestedTypeDefinition) and t.oclAsType(NestedTypeDefinition).type.conformsTo(argT))' ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput='let fstd = self.argument.getType() in\r\n  fstd.oclIsKindOf(FunctionSignatureTypeDefinition) and\r\n  (let sig = fstd.oclAsType(FunctionSignatureTypeDefinition).signature in\r\n  (sig.output->notEmpty() and\r\n  sig.input->size() = 1))' MapFunctionMustBeSideEffectFree='self.argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.sideEffectFree'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ObjectTypeMustConformToFunctionArgument ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput MapFunctionMustBeSideEffectFree'"
 * @generated
 */
public interface Map extends ExpressionWithArgument, ObjectBasedExpression
{
} // Map
