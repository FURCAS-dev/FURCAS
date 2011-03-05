/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractTypeImpl.java,v 1.2 2011/03/05 21:37:36 auhl Exp $
 */
package integration.xsd.impl;

import integration.xsd.AbstractType;
import integration.xsd.XsdPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AbstractTypeImpl extends NamedElementImpl implements AbstractType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XsdPackage.Literals.ABSTRACT_TYPE;
	}

} //AbstractTypeImpl
