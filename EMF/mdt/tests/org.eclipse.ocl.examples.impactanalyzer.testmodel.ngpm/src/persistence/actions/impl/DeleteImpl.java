/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeleteImpl.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package persistence.actions.impl;

import org.eclipse.emf.ecore.EClass;

import persistence.actions.ActionsPackage;
import persistence.actions.Delete;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DeleteImpl extends StatementWithEntityArgumentImpl implements Delete {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DeleteImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.DELETE;
    }

} //DeleteImpl
