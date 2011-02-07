/**
 * <copyright>
 * </copyright>
 *
 * $Id: StatusValueImpl.java,v 1.1 2011/02/07 16:48:24 auhl Exp $
 */
package behavioral.status_and_action.design.impl;

import behavioral.status_and_action.design.DesignPackage;
import behavioral.status_and_action.design.StatusValue;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StatusValueImpl extends AbstractStatusValueImpl implements StatusValue {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected StatusValueImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return DesignPackage.Literals.STATUS_VALUE;
    }

} //StatusValueImpl
