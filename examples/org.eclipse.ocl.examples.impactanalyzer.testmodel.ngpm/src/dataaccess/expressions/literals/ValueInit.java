/**
 * <copyright>
 * </copyright>
 *
 * $Id: ValueInit.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions.literals;

import data.classes.AssociationEnd;

import dataaccess.expressions.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Provides an initialization value for an association end whose other end is attached to a value class. The expression's type must conform to the association end's type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.literals.ValueInit#getForEnd <em>For End</em>}</li>
 *   <li>{@link dataaccess.expressions.literals.ValueInit#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.literals.LiteralsPackage#getValueInit()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ValueInitTypeConforms='self.value.getType().conformsTo(self.forEnd.type)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValueInitTypeConforms'"
 * @generated
 */
public interface ValueInit extends EObject {
	/**
     * Returns the value of the '<em><b>For End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>For End</em>' reference.
     * @see #setForEnd(AssociationEnd)
     * @see dataaccess.expressions.literals.LiteralsPackage#getValueInit_ForEnd()
     * @model required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='valueInit'"
     * @generated
     */
	AssociationEnd getForEnd();

	/**
     * Sets the value of the '{@link dataaccess.expressions.literals.ValueInit#getForEnd <em>For End</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>For End</em>' reference.
     * @see #getForEnd()
     * @generated
     */
	void setForEnd(AssociationEnd value);

	/**
     * Returns the value of the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' containment reference.
     * @see #setValue(Expression)
     * @see dataaccess.expressions.literals.LiteralsPackage#getValueInit_Value()
     * @model containment="true" resolveProxies="true" required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='valueInit'"
     * @generated
     */
	Expression getValue();

	/**
     * Sets the value of the '{@link dataaccess.expressions.literals.ValueInit#getValue <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
	void setValue(Expression value);

} // ValueInit
