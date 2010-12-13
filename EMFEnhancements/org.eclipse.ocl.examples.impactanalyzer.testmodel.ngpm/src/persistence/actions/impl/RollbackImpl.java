/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package persistence.actions.impl;

import behavioral.actions.impl.StatementImpl;

import org.eclipse.emf.ecore.EClass;

import persistence.actions.ActionsPackage;
import persistence.actions.Rollback;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rollback</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RollbackImpl extends StatementImpl implements Rollback {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected RollbackImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.ROLLBACK;
    }

} //RollbackImpl
