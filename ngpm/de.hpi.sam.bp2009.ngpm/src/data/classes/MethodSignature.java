/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import behavioral.events.EventProducer;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * a signature of a method defined in a class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.MethodSignature#getProducer <em>Producer</em>}</li>
 *   <li>{@link data.classes.MethodSignature#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link data.classes.MethodSignature#getOwner <em>Owner</em>}</li>
 *   <li>{@link data.classes.MethodSignature#getConverter <em>Converter</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getMethodSignature()
 * @model
 * @generated
 */
public interface MethodSignature extends Signature, NamedElement {
	/**
     * Returns the value of the '<em><b>Producer</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.events.EventProducer#getNotificationSignatures <em>Notification Signatures</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Producer</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Producer</em>' container reference.
     * @see #setProducer(EventProducer)
     * @see data.classes.ClassesPackage#getMethodSignature_Producer()
     * @see behavioral.events.EventProducer#getNotificationSignatures
     * @model opposite="notificationSignatures"
     * @generated
     */
	EventProducer getProducer();

	/**
     * Sets the value of the '{@link data.classes.MethodSignature#getProducer <em>Producer</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Producer</em>' container reference.
     * @see #getProducer()
     * @generated
     */
	void setProducer(EventProducer value);

	/**
     * Returns the value of the '<em><b>Implementation</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.classes.SignatureImplementation#getImplements_ <em>Implements </em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Implementation</em>' containment reference.
     * @see #setImplementation(SignatureImplementation)
     * @see data.classes.ClassesPackage#getMethodSignature_Implementation()
     * @see data.classes.SignatureImplementation#getImplements_
     * @model opposite="implements_" containment="true" resolveProxies="true"
     * @generated
     */
	SignatureImplementation getImplementation();

	/**
     * Sets the value of the '{@link data.classes.MethodSignature#getImplementation <em>Implementation</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Implementation</em>' containment reference.
     * @see #getImplementation()
     * @generated
     */
	void setImplementation(SignatureImplementation value);

	/**
     * Returns the value of the '<em><b>Owner</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SignatureOwner#getOwnedSignatures <em>Owned Signatures</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owner</em>' container reference.
     * @see #setOwner(SignatureOwner)
     * @see data.classes.ClassesPackage#getMethodSignature_Owner()
     * @see data.classes.SignatureOwner#getOwnedSignatures
     * @model opposite="ownedSignatures"
     * @generated
     */
	SignatureOwner getOwner();

	/**
     * Sets the value of the '{@link data.classes.MethodSignature#getOwner <em>Owner</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owner</em>' container reference.
     * @see #getOwner()
     * @generated
     */
	void setOwner(SignatureOwner value);

	/**
     * Returns the value of the '<em><b>Converter</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.classes.ConverterBetweenParametrizations#getConversionMethod <em>Conversion Method</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Converter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Converter</em>' reference.
     * @see #setConverter(ConverterBetweenParametrizations)
     * @see data.classes.ClassesPackage#getMethodSignature_Converter()
     * @see data.classes.ConverterBetweenParametrizations#getConversionMethod
     * @model opposite="conversionMethod"
     * @generated
     */
	ConverterBetweenParametrizations getConverter();

	/**
     * Sets the value of the '{@link data.classes.MethodSignature#getConverter <em>Converter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Converter</em>' reference.
     * @see #getConverter()
     * @generated
     */
	void setConverter(ConverterBetweenParametrizations value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.implementation->isEmpty()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean isAbstract();

} // MethodSignature
