/**
 * <copyright>
 * </copyright>
 *
 * $Id: BagTypeImpl.java,v 1.1 2007/01/25 18:24:34 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bag Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BagTypeImpl<C, O> extends CollectionTypeImpl<C, O> implements BagType<C, O> {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BagTypeImpl() {
        super();
    }
	
	protected BagTypeImpl(C elementType) {
		super(elementType);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TypesPackage.Literals.BAG_TYPE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CollectionKind getKind() {
		return CollectionKind.BAG_LITERAL;
	}

} //BagTypeImpl
