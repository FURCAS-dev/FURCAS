/**
 * <copyright>
 * </copyright>
 *
 * $Id: Choice.java,v 1.1 2011/02/07 16:57:58 auhl Exp $
 */
package integration.xsd;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.Choice#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends Containable {
	/**
     * Returns the value of the '<em><b>Children</b></em>' reference list.
     * The list contents are of type {@link integration.xsd.Containable}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Children</em>' reference list.
     * @see integration.xsd.XsdPackage#getChoice_Children()
     * @model
     * @generated
     */
	EList<Containable> getChildren();

} // Choice
