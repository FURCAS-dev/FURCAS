/**
 * <copyright>
 * </copyright>
 *
 * $Id: SequenceTypeImpl.java,v 1.1 2007/01/25 18:24:35 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SequenceTypeImpl<C, O> extends CollectionTypeImpl<C, O> implements SequenceType<C, O> {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SequenceTypeImpl() {
        super();
    }
	
	protected SequenceTypeImpl(C elementType) {
		super(elementType);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TypesPackage.Literals.SEQUENCE_TYPE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CollectionKind getKind() {
		return CollectionKind.SEQUENCE_LITERAL;
	}

} //SequenceTypeImpl
