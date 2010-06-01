/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.fp;

import data.classes.FunctionSignatureImplementation;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Anonymous Function Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The type of expression of this type is a FunctionSignatureTypeDefinition. The value of this expression can be invoked which results in an invocation of the assoicated block.
 * 
 * The expression must own a FunctionSignatureTypeDefinition in the role ownedTypeDefinition that has a valid implementation for its FunctionSignature.
 * 
 * Note that there can be other expressions that evaluate to a function, such as an access to a variable that has a FunctionSignatureTypeDefinition as its type. AnonymousFunctionExpr really is the constructor for a function with implementation. This expression may then, e.g., be bound to variables or passed as parameter or returned by a method or function.
 * <!-- end-model-doc -->
 *
 *
 * @see dataaccess.expressions.fp.FpPackage#getAnonymousFunctionExpr()
 * @model annotation="http://de.hpi.sam.bp2009.OCL TypeMustBeSignatureTypeDefinitionWithImplementation='self.getType().oclIsKindOf(FunctionSignatureTypeDefinition) and\n  self.getType().oclAsType(FunctionSignatureTypeDefinition).signature.oclAsType(FunctionSignature).implementation->notEmpty()' HasToOwnSignatureTypeDefinition='self.ownedTypeDefinition->notEmpty()' SignatureMustBeFunctionSignature='self.ownedTypeDefinition.oclAsType(FunctionSignatureTypeDefinition).signature.oclIsKindOf(FunctionSignature)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TypeMustBeSignatureTypeDefinitionWithImplementation HasToOwnSignatureTypeDefinition SignatureMustBeFunctionSignature'"
 * @generated
 */
public interface AnonymousFunctionExpr extends Expression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines the Block implementing the function to which this expression evaluates by navigating to the FunctionSignatureTypeDefinition that tells this expression's type, and from there obtaining the signature's implementation.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='self.ownedTypeDefinition.oclAsType(FunctionSignatureTypeDefinition).signature.oclAsType(FunctionSignature).implementation'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	FunctionSignatureImplementation getImplementation();

} // AnonymousFunctionExpr
