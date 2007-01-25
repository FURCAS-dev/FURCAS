/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeType.java,v 1.1 2007/01/25 18:24:36 cdamus Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.TypeType#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.types.TypesPackage#getTypeType()
 * @model
 * @generated
 */
public interface TypeType<C, O> extends PredefinedType<O> {
    String SINGLETON_NAME = "OclType"; //$NON-NLS-1$
    
	/**
     * Returns the value of the '<em><b>Referred Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Type</em>' reference.
     * @see org.eclipse.ocl.types.TypesPackage#getTypeType_ReferredType()
     * @model required="true" transient="true" changeable="false"
     * @generated
     */
	C getReferredType();

} // TypeType
