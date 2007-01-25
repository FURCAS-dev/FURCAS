/**
 * <copyright>
 * </copyright>
 *
 * $Id: TupleType.java,v 1.1 2007/01/25 18:24:36 cdamus Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.types.TypesPackage#getTupleType()
 * @model
 * @generated
 */
public interface TupleType<O, P> extends PredefinedType<O> {
	String SINGLETON_NAME = "Tuple"; //$NON-NLS-1$

	/**
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @model type="java.lang.Object"
     * @generated
     */
	EList<P> oclProperties();

} // TupleType
