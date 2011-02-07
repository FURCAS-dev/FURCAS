/**
 * <copyright>
 * </copyright>
 *
 * $Id: StoreImpl.java,v 1.1 2011/02/07 16:43:30 auhl Exp $
 */
package persistence.actions.impl;

import org.eclipse.emf.ecore.EClass;

import persistence.actions.ActionsPackage;
import persistence.actions.Store;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StoreImpl extends StatementWithEntityArgumentImpl implements Store {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected StoreImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.STORE;
    }

} //StoreImpl
