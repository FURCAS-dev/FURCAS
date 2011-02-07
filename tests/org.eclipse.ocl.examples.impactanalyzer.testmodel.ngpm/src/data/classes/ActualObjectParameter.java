/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActualObjectParameter.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.classes;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Object Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.ActualObjectParameter#getFormalObjectParameter <em>Formal Object Parameter</em>}</li>
 *   <li>{@link data.classes.ActualObjectParameter#getClassTypeDefinitions <em>Class Type Definitions</em>}</li>
 *   <li>{@link data.classes.ActualObjectParameter#getValue <em>Value</em>}</li>
 *   <li>{@link data.classes.ActualObjectParameter#getOwningClassTypeDefinition <em>Owning Class Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getActualObjectParameter()
 * @model
 * @generated
 */
public interface ActualObjectParameter extends EObject {
	/**
     * Returns the value of the '<em><b>Formal Object Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formal Object Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Formal Object Parameter</em>' reference.
     * @see #setFormalObjectParameter(Parameter)
     * @see data.classes.ClassesPackage#getActualObjectParameter_FormalObjectParameter()
     * @model required="true"
     * @generated
     */
	Parameter getFormalObjectParameter();

	/**
     * Sets the value of the '{@link data.classes.ActualObjectParameter#getFormalObjectParameter <em>Formal Object Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Formal Object Parameter</em>' reference.
     * @see #getFormalObjectParameter()
     * @generated
     */
	void setFormalObjectParameter(Parameter value);

	/**
     * Returns the value of the '<em><b>Class Type Definitions</b></em>' reference list.
     * The list contents are of type {@link data.classes.ClassTypeDefinition}.
     * It is bidirectional and its opposite is '{@link data.classes.ClassTypeDefinition#getObjectParameters <em>Object Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Type Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Class Type Definitions</em>' reference list.
     * @see data.classes.ClassesPackage#getActualObjectParameter_ClassTypeDefinitions()
     * @see data.classes.ClassTypeDefinition#getObjectParameters
     * @model opposite="objectParameters"
     * @generated
     */
	EList<ClassTypeDefinition> getClassTypeDefinitions();

	/**
     * Returns the value of the '<em><b>Value</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getActualObjectParameter <em>Actual Object Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' containment reference.
     * @see #setValue(Expression)
     * @see data.classes.ClassesPackage#getActualObjectParameter_Value()
     * @see dataaccess.expressions.Expression#getActualObjectParameter
     * @model opposite="actualObjectParameter" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getValue();

	/**
     * Sets the value of the '{@link data.classes.ActualObjectParameter#getValue <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
	void setValue(Expression value);

	/**
     * Returns the value of the '<em><b>Owning Class Type Definition</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.ClassTypeDefinition#getOwnedObjectParameters <em>Owned Object Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class Type Definition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owning Class Type Definition</em>' container reference.
     * @see #setOwningClassTypeDefinition(ClassTypeDefinition)
     * @see data.classes.ClassesPackage#getActualObjectParameter_OwningClassTypeDefinition()
     * @see data.classes.ClassTypeDefinition#getOwnedObjectParameters
     * @model opposite="ownedObjectParameters" required="true"
     * @generated
     */
	ClassTypeDefinition getOwningClassTypeDefinition();

	/**
     * Sets the value of the '{@link data.classes.ActualObjectParameter#getOwningClassTypeDefinition <em>Owning Class Type Definition</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owning Class Type Definition</em>' container reference.
     * @see #getOwningClassTypeDefinition()
     * @generated
     */
	void setOwningClassTypeDefinition(ClassTypeDefinition value);

} // ActualObjectParameter
