/**
 * <copyright>
 * </copyright>
 *
 * $Id: SchemaElementImpl.java,v 1.1 2011/02/07 16:43:33 auhl Exp $
 */
package behavioral.status_and_action.assembly.impl;

import behavioral.status_and_action.assembly.AssemblyPackage;
import behavioral.status_and_action.assembly.SchemaElement;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schema Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class SchemaElementImpl extends NamedElementImpl implements SchemaElement {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SchemaElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AssemblyPackage.Literals.SCHEMA_ELEMENT;
    }

} //SchemaElementImpl
