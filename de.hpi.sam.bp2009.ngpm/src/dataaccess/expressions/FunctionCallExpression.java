/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression that is computed by first evaluating "calledBlock" and invoking the resulting block passing the "argument" expression. The value returned by the block constitutes the value of this expression. If the block terminates with a fault, the evaluation of this expression terminates with this fault.
 * 
 * The type of the object computed by the "parameters" expression must conform to the input parameter types of the signature called.
 * 
 * If the calledBock evaluates to more than one callable function, all functions will be called. Invocation ordering depends on the side effect-freeness of the signatures called.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.FunctionCallExpression#getCalledBlock <em>Called Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getFunctionCallExpression()
 * @model annotation="http://de.hpi.sam.bp2009.OCL ResultType='let fstd:FunctionSignatureTypeDefinition = self.calledBlock.getType().getInnermost().oclAsType(FunctionSignatureTypeDefinition) in\n\n  if fstd.isMany() then\n    -- calling multiple functions; test is somewhat fuzzy because it doesn\'t test condormance of nesting structure exactly\n    self.getType().isMany() and not self.getType().unique and\n    fstd.signature.output.getInnermost().conformsTo(self.getType().getInnermost()) and\n    (fstd.lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))\n  else\n    -- calling a single function\n    fstd.signature.output.conformsTo(self.getType()) and \n    (fstd.lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))\n  endif' CalledBlockMustBeFunction='self.calledBlock.getType().getInnermost().oclIsKindOf(FunctionSignatureTypeDefinition)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ResultType CalledBlockMustBeFunction'"
 * @generated
 */
public interface FunctionCallExpression extends SignatureCallExpression {
	/**
	 * Returns the value of the '<em><b>Called Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Block</em>' containment reference.
	 * @see #setCalledBlock(Expression)
	 * @see dataaccess.expressions.ExpressionsPackage#getFunctionCallExpression_CalledBlock()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='blockOfFunctionCallExpression'"
	 * @generated
	 */
	Expression getCalledBlock();

	/**
	 * Sets the value of the '{@link dataaccess.expressions.FunctionCallExpression#getCalledBlock <em>Called Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Block</em>' containment reference.
	 * @see #getCalledBlock()
	 * @generated
	 */
	void setCalledBlock(Expression value);

} // FunctionCallExpression
