/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionCallExpression.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
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
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ResultType='let fstd:data::classes::FunctionSignatureTypeDefinition = self.calledBlock.getType().getInnermost().oclAsType(data::classes::FunctionSignatureTypeDefinition) in\r\n\r\n  if fstd.isMany() then\r\n    -- calling multiple functions; test is somewhat fuzzy because it doesn\'t test condormance of nesting structure exactly\r\n    self.getType().isMany() and not self.getType().unique and\r\n    fstd.signature.output.getInnermost().conformsTo(self.getType().getInnermost()) and\r\n    (fstd.lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))\r\n  else\r\n    -- calling a single function\r\n    fstd.signature.output.conformsTo(self.getType()) and \r\n    (fstd.lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))\r\n  endif' CalledBlockMustBeFunction='self.calledBlock.getType().getInnermost().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ResultType CalledBlockMustBeFunction'"
 * @generated
 */
public interface FunctionCallExpression extends SignatureCallExpression {
	/**
     * Returns the value of the '<em><b>Called Block</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getBlockOfFunctionCallExpression <em>Block Of Function Call Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Called Block</em>' containment reference.
     * @see #setCalledBlock(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getFunctionCallExpression_CalledBlock()
     * @see dataaccess.expressions.Expression#getBlockOfFunctionCallExpression
     * @model opposite="blockOfFunctionCallExpression" containment="true" resolveProxies="true" required="true"
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
