/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionSignatureImplementation.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Signature Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.FunctionSignatureImplementation#getFunctionSignature <em>Function Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getFunctionSignatureImplementation()
 * @model
 * @generated
 */
public interface FunctionSignatureImplementation extends SignatureImplementation {
	/**
     * Returns the value of the '<em><b>Function Signature</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.FunctionSignature#getImplementation <em>Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Signature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Function Signature</em>' container reference.
     * @see #setFunctionSignature(FunctionSignature)
     * @see data.classes.ClassesPackage#getFunctionSignatureImplementation_FunctionSignature()
     * @see data.classes.FunctionSignature#getImplementation
     * @model opposite="implementation"
     * @generated
     */
	FunctionSignature getFunctionSignature();

	/**
     * Sets the value of the '{@link data.classes.FunctionSignatureImplementation#getFunctionSignature <em>Function Signature</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Function Signature</em>' container reference.
     * @see #getFunctionSignature()
     * @generated
     */
	void setFunctionSignature(FunctionSignature value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsKindOf(behavioral::actions::Block) then\n    self.oclAsType(behavioral::actions::Block).localIsSideEffectFree()\n  else\n    if self.oclIsKindOf(dataaccess::analytics::CellSet) then\n      self.oclAsType(dataaccess::analytics::CellSet).localIsSideEffectFree()\n    else\n      false\n    endif\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean isSideEffectFree();

} // FunctionSignatureImplementation
