/**
 * <copyright>
 * </copyright>
 *
 * $Id: NavigationStep.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package dataaccess.expressions;

import data.classes.AssociationEnd;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.NavigationStep#getReplace <em>Replace</em>}</li>
 *   <li>{@link dataaccess.expressions.NavigationStep#getTo <em>To</em>}</li>
 *   <li>{@link dataaccess.expressions.NavigationStep#getFilterFunction <em>Filter Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getNavigationStep()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL FromEndAttachesToOutputOfPreviousStep='let i:Integer = self.replace.steps->indexOf(self) in\r\n  let t:data::classes::ClassTypeDefinition = if i=1 then\r\n      self.replace.object.getType().oclAsType(data::classes::ClassTypeDefinition)\r\n    else\r\n      self.replace.steps->at(-1 + i).to.type\r\n    endif\r\n  in\r\n\r\n  self.to.otherEnd().type.clazz.conformsTo(t.clazz)' FilterFunctionExpressionHasFunctionType='self.filterFunction->notEmpty() implies self.filterFunction.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)' FromEndMustBeEqualityRelevant='to.otherEnd().contributesToEquality'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='FromEndAttachesToOutputOfPreviousStep FilterFunctionExpressionHasFunctionType FromEndMustBeEqualityRelevant'"
 * @generated
 */
public interface NavigationStep extends EObject {
	/**
     * Returns the value of the '<em><b>Replace</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Replace#getSteps <em>Steps</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replace</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Replace</em>' container reference.
     * @see #setReplace(Replace)
     * @see dataaccess.expressions.ExpressionsPackage#getNavigationStep_Replace()
     * @see dataaccess.expressions.Replace#getSteps
     * @model opposite="steps" required="true"
     * @generated
     */
	Replace getReplace();

	/**
     * Sets the value of the '{@link dataaccess.expressions.NavigationStep#getReplace <em>Replace</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Replace</em>' container reference.
     * @see #getReplace()
     * @generated
     */
	void setReplace(Replace value);

	/**
     * Returns the value of the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' reference.
     * @see #setTo(AssociationEnd)
     * @see dataaccess.expressions.ExpressionsPackage#getNavigationStep_To()
     * @model required="true"
     * @generated
     */
	AssociationEnd getTo();

	/**
     * Sets the value of the '{@link dataaccess.expressions.NavigationStep#getTo <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' reference.
     * @see #getTo()
     * @generated
     */
	void setTo(AssociationEnd value);

	/**
     * Returns the value of the '<em><b>Filter Function</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Filter Function</em>' containment reference.
     * @see #setFilterFunction(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getNavigationStep_FilterFunction()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='navigationStep'"
     * @generated
     */
	Expression getFilterFunction();

	/**
     * Sets the value of the '{@link dataaccess.expressions.NavigationStep#getFilterFunction <em>Filter Function</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Filter Function</em>' containment reference.
     * @see #getFilterFunction()
     * @generated
     */
	void setFilterFunction(Expression value);

} // NavigationStep
