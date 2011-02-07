/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationEndNavigationExpression.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.expressions;

import data.classes.AssociationEnd;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End Navigation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Navigates from the "object" across the "toEnd"'s association to the "toEnd". The expression evaluates to the objects at the "toEnd" that are associated with the "object" based on the end's association.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.AssociationEndNavigationExpression#getToEnd <em>To End</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getAssociationEndNavigationExpression()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ObjectTypeMustMatch='self.object.getType().conformsToIgnoringMultiplicity(self.toEnd.otherEnd().type)' ResultType='self.getType() = self.toEnd.type' EndMustBeNavigable='self.toEnd.navigable'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ObjectTypeMustMatch ResultType EndMustBeNavigable'"
 * @generated
 */
public interface AssociationEndNavigationExpression extends ObjectBasedExpression {
	/**
     * Returns the value of the '<em><b>To End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>To End</em>' reference.
     * @see #setToEnd(AssociationEnd)
     * @see dataaccess.expressions.ExpressionsPackage#getAssociationEndNavigationExpression_ToEnd()
     * @model required="true"
     * @generated
     */
	AssociationEnd getToEnd();

	/**
     * Sets the value of the '{@link dataaccess.expressions.AssociationEndNavigationExpression#getToEnd <em>To End</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>To End</em>' reference.
     * @see #getToEnd()
     * @generated
     */
	void setToEnd(AssociationEnd value);

} // AssociationEndNavigationExpression
