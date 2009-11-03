/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.NamedElement#getMayBeImplicit <em>May Be Implicit
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.NamedElement#getName <em>Name</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.NamedElement#getReferredElement <em>Referred Element
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getNamedElement()
 * @model
 * @generated
 */
public interface NamedElement extends Element {
	/**
	 * Returns the value of the '<em><b>May Be Implicit</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>May Be Implicit</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>May Be Implicit</em>' attribute.
	 * @see #setMayBeImplicit(Boolean)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getNamedElement_MayBeImplicit()
	 * @model dataType="org.oslo.ocl20.semantics.Boolean" required="true" transient="true"
	 * @generated
	 */
	Boolean getMayBeImplicit();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.NamedElement#getMayBeImplicit
	 * <em>May Be Implicit</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>May Be Implicit</em>' attribute.
	 * @see #getMayBeImplicit()
	 * @generated
	 */
	void setMayBeImplicit(Boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getNamedElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.NamedElement#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Referred Element</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Referred Element</em>' reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referred Element</em>' reference.
	 * @see #setReferredElement(ModelElement)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getNamedElement_ReferredElement()
	 * @model required="true"
	 * @generated
	 */
	ModelElement getReferredElement();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.bridge.NamedElement#getReferredElement
	 * <em>Referred Element</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Referred Element</em>' reference.
	 * @see #getReferredElement()
	 * @generated
	 */
	void setReferredElement(ModelElement value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\t\t\tif (referredElement instanceof org.oslo.ocl20.semantics.model.expressions.VariableDeclaration)\n\t\t\t\t\treturn ((org.oslo.ocl20.semantics.model.expressions.VariableDeclaration) referredElement).getType();\n\t\t\t\tif (referredElement instanceof Classifier)\n\t\t\t\t\treturn (Classifier) referredElement;\n\t\t\t\t//if (referredElement instanceof IState)\n\t\t\t\t//    return ???\n\t\t\t\treturn null;'"
	 * @generated
	 */
	Classifier getType();

} // NamedElement
