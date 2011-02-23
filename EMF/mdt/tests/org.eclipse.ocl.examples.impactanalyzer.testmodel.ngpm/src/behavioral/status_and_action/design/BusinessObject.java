/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinessObject.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action.design;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.BusinessObject#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.design.DesignPackage#getBusinessObject()
 * @model
 * @generated
 */
public interface BusinessObject extends EObject {
	/**
     * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action.design.BusinessObjectNode}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Nodes</em>' containment reference list.
     * @see behavioral.status_and_action.design.DesignPackage#getBusinessObject_Nodes()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='businessObject'"
     * @generated
     */
	EList<BusinessObjectNode> getNodes();

} // BusinessObject
