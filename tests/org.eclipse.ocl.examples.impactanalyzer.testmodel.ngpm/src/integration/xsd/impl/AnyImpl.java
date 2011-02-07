/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnyImpl.java,v 1.1 2011/02/07 17:21:37 auhl Exp $
 */
package integration.xsd.impl;

import integration.xsd.Any;
import integration.xsd.XsdPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AnyImpl extends ContainableImpl implements Any {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AnyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return XsdPackage.Literals.ANY;
    }

} //AnyImpl
