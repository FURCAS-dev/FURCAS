/**
 * <copyright>
 * </copyright>
 *
 * $Id: Delegation.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.classes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delegation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Exposes all features (operations and exposed association ends) of the class to which the opposite of the "from" end is attached as features of the "from" end's class. In particular, this makes the "from" class conform to the type of the "to" association end.
 * 
 * The lower and upper multiplicity of the "from" opposite's association end must be 1 because a single instance is required in order to the "from" type to be able to delegate to it.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.Delegation#isAllFeatures <em>All Features</em>}</li>
 *   <li>{@link data.classes.Delegation#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getDelegation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ToEndMustHaveMultiplicityOfOne='self.from.otherEnd().type.lowerMultiplicity = 1 and\r\n  self.from.otherEnd().type.upperMultiplicity = 1'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ToEndMustHaveMultiplicityOfOne'"
 * @generated
 */
public interface Delegation extends EObject {
	/**
     * Returns the value of the '<em><b>All Features</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Features</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>All Features</em>' attribute.
     * @see #setAllFeatures(boolean)
     * @see data.classes.ClassesPackage#getDelegation_AllFeatures()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isAllFeatures();

	/**
     * Sets the value of the '{@link data.classes.Delegation#isAllFeatures <em>All Features</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>All Features</em>' attribute.
     * @see #isAllFeatures()
     * @generated
     */
	void setAllFeatures(boolean value);

	/**
     * Returns the value of the '<em><b>From</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.AssociationEnd#getDelegation <em>Delegation</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' container reference.
     * @see #setFrom(AssociationEnd)
     * @see data.classes.ClassesPackage#getDelegation_From()
     * @see data.classes.AssociationEnd#getDelegation
     * @model opposite="delegation" required="true"
     * @generated
     */
	AssociationEnd getFrom();

	/**
     * Sets the value of the '{@link data.classes.Delegation#getFrom <em>From</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>From</em>' container reference.
     * @see #getFrom()
     * @generated
     */
	void setFrom(AssociationEnd value);

} // Delegation
