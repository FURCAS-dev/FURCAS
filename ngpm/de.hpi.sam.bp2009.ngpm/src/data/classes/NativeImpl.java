/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Native Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.NativeImpl#getPlatformSpecificImplementaiton <em>Platform Specific Implementaiton</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getNativeImpl()
 * @model
 * @generated
 */
public interface NativeImpl extends SignatureImplementation {
	/**
     * Returns the value of the '<em><b>Platform Specific Implementaiton</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.PlatformSpecificImplementation}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform Specific Implementaiton</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Platform Specific Implementaiton</em>' containment reference list.
     * @see data.classes.ClassesPackage#getNativeImpl_PlatformSpecificImplementaiton()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
	EList<PlatformSpecificImplementation> getPlatformSpecificImplementaiton();

} // NativeImpl
