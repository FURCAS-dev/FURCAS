/**
 * <copyright>
 * </copyright>
 *
 * $Id: DummyImpl.java,v 1.1 2011/02/07 17:21:38 auhl Exp $
 */
package ui.data_binding.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import ui.data_binding.Data_bindingPackage;
import ui.data_binding.Dummy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dummy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DummyImpl extends EObjectImpl implements Dummy {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DummyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Data_bindingPackage.Literals.DUMMY;
    }

} //DummyImpl
