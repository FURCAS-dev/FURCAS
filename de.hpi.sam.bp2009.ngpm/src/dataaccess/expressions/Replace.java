/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An abstract-syntactical convenience to construct a value from an existing one, replacing a component somewhere in the possibly deep structure that the value has.
 * 
 * The replacement always produces a value of the same type as the source value. It can provide a navigation path, following associations, staying withing values, with the last path component being allowed to end at an entity or a value class. Each path segment may add a constraint which makes sense specifically for multiplicities greater than one.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.Replace#getSteps <em>Steps</em>}</li>
 *   <li>{@link dataaccess.expressions.Replace#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getReplace()
 * @model annotation="http://de.hpi.sam.bp2009.OCL SourceObjectIsOfValueType='self.object.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  self.object.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType' WithTypeConformsToLastStepsType='self.with.getType().conformsTo(self.steps->at(self.steps->size()).to.type)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SourceObjectIsOfValueType WithTypeConformsToLastStepsType'"
 * @generated
 */
public interface Replace extends ObjectBasedExpression {
	/**
     * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
     * The list contents are of type {@link dataaccess.expressions.NavigationStep}.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.NavigationStep#getReplace <em>Replace</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Steps</em>' containment reference list.
     * @see dataaccess.expressions.ExpressionsPackage#getReplace_Steps()
     * @see dataaccess.expressions.NavigationStep#getReplace
     * @model opposite="replace" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	EList<NavigationStep> getSteps();

	/**
     * Returns the value of the '<em><b>With</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>With</em>' containment reference.
     * @see #setWith(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getReplace_With()
     * @model containment="true" resolveProxies="true" required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='withOfReplace'"
     * @generated
     */
	Expression getWith();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Replace#getWith <em>With</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>With</em>' containment reference.
     * @see #getWith()
     * @generated
     */
	void setWith(Expression value);

} // Replace
