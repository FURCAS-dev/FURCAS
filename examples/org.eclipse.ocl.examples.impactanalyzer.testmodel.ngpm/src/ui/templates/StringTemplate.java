/**
 * <copyright>
 * </copyright>
 *
 * $Id: StringTemplate.java,v 1.1 2011/02/07 16:58:52 auhl Exp $
 */
package ui.templates;

import data.classes.FunctionSignatureImplementation;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ui.templates.StringTemplate#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see ui.templates.TemplatesPackage#getStringTemplate()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL expressionMustBeSideEffectFree='self.expressions->forAll( e | e.isSideEffectFree() )'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='expressionMustBeSideEffectFree'"
 * @generated
 */
public interface StringTemplate extends FunctionSignatureImplementation {
	/**
     * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
     * The list contents are of type {@link dataaccess.expressions.Expression}.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getTemplate <em>Template</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Expressions</em>' containment reference list.
     * @see ui.templates.TemplatesPackage#getStringTemplate_Expressions()
     * @see dataaccess.expressions.Expression#getTemplate
     * @model opposite="template" containment="true" resolveProxies="true"
     * @generated
     */
	EList<Expression> getExpressions();

} // StringTemplate
