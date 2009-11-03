/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import org.oslo.ocl20.semantics.OclVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Namespace</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Namespace#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getNamespace()
 * @model
 * @generated
 */
public interface Namespace extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Namespace</em>' reference.
	 * @see #setNamespace(Namespace)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getNamespace_Namespace()
	 * @model required="true"
	 * @generated
	 */
	Namespace getNamespace();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.Namespace#getNamespace
	 * <em>Namespace</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Namespace</em>' reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(Namespace value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 * @generated
	 */
	Environment getEnvironmentWithoutParents();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tif (this.getNamespace() == null) {\n\t\t\treturn null;\n\t\t} else {\n\t\t\tEnvironment result = getEnvironmentWithoutParents();\n\t\t\tresult.setParent(this.getNamespace().getEnvironmentWithParents());\n\t\t\treturn result;\n\t\t}'"
	 * @generated
	 */
	Environment getEnvironmentWithParents();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	ModelElement lookupOwnedElement(String name);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tif (getNamespace() == null)\n\t\t    return getName();\n\t\treturn getNamespace().getFullName(sep)+sep+getName();'"
	 * @generated
	 */
	String getFullName(String sep);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Namespace
