/**
 * <copyright>
 * </copyright>
 *
 * $Id: OrderedSetTypeImpl.java,v 1.1 2007/01/25 18:24:34 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordered Set Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrderedSetTypeImpl<C, O> extends CollectionTypeImpl<C, O> implements OrderedSetType<C, O> {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OrderedSetTypeImpl() {
        super();
    }
	
	protected OrderedSetTypeImpl(C elementType) {
		super(elementType);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TypesPackage.Literals.ORDERED_SET_TYPE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CollectionKind getKind() {
		return CollectionKind.ORDERED_SET_LITERAL;
	}

} //OrderedSetTypeImpl
