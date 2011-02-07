/**
 * <copyright>
 * </copyright>
 *
 * $Id: AddLinkImpl.java,v 1.1 2011/02/07 16:47:39 auhl Exp $
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.AddLink;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AddLinkImpl extends LinkManipulationStatementImpl implements AddLink {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AddLinkImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.ADD_LINK;
    }

} //AddLinkImpl
