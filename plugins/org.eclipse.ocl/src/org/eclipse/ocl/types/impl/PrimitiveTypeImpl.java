/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimitiveTypeImpl.java,v 1.1 2007/01/25 18:24:35 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveTypeImpl<O> extends EObjectImpl implements PrimitiveType<O> {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PrimitiveTypeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TypesPackage.Literals.PRIMITIVE_TYPE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
        return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<O> oclOperations() {
        throw new UnsupportedOperationException();
	}

} //PrimitiveTypeImpl
