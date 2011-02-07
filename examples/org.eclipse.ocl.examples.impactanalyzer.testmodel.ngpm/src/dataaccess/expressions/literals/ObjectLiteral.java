/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectLiteral.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions.literals;

import data.classes.SapClass;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.literals.ObjectLiteral#getValueClass <em>Value Class</em>}</li>
 *   <li>{@link dataaccess.expressions.literals.ObjectLiteral#getPropertyValues <em>Property Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.literals.LiteralsPackage#getObjectLiteral()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ObjectLiteralsForValueClassesOnly='self.valueClass.valueType' ObjectLiteralPropertiesOnRightClass='self.propertyValues->forAll(vi|vi.forEnd.otherEnd().type.clazz = self.valueClass)' ValuesMustBeProvidedForAllMandatoryProperties='self.valueClass.getEqualityRelevantAssociationEnds()->select(ae | ae.otherEnd().type.lowerMultiplicity > 0)->forAll(ae |\r\n      self.propertyValues->exists(pv | pv.forEnd.otherEnd() = ae))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ObjectLiteralsForValueClassesOnly ObjectLiteralPropertiesOnRightClass ValuesMustBeProvidedForAllMandatoryProperties'"
 * @generated
 */
public interface ObjectLiteral extends Expression {
	/**
     * Returns the value of the '<em><b>Value Class</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value Class</em>' reference.
     * @see #setValueClass(SapClass)
     * @see dataaccess.expressions.literals.LiteralsPackage#getObjectLiteral_ValueClass()
     * @model required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='objectLiteral'"
     * @generated
     */
	SapClass getValueClass();

	/**
     * Sets the value of the '{@link dataaccess.expressions.literals.ObjectLiteral#getValueClass <em>Value Class</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Class</em>' reference.
     * @see #getValueClass()
     * @generated
     */
	void setValueClass(SapClass value);

	/**
     * Returns the value of the '<em><b>Property Values</b></em>' containment reference list.
     * The list contents are of type {@link dataaccess.expressions.literals.ValueInit}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Property Values</em>' containment reference list.
     * @see dataaccess.expressions.literals.LiteralsPackage#getObjectLiteral_PropertyValues()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='objectLiteral'"
     * @generated
     */
	EList<ValueInit> getPropertyValues();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.valueClass = o.valueClass and\n  self.propertyValues->size() = o.propertyValues->size() and\n  self.propertyValues->forAll(pv | o.propertyValues->exists(opv | opv.forEnd = pv.forEnd and opv.value.evaluatesToEqualAs(pv.value)))'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean isEqualTo(ObjectLiteral o);

} // ObjectLiteral
