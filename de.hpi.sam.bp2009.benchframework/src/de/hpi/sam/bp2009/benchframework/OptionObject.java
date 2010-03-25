/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardPage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The base class of all option objects for an operator, should be subclasses to support specific concepts.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.OptionObject#getWizardPage <em>Wizard Page</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getOptionObject()
 * @model abstract="true"
 * @generated
 */
public interface OptionObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Wizard Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wizard Page</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * used for eclipse wizard based option entering
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wizard Page</em>' attribute.
	 * @see #setWizardPage(WizardPage)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getOptionObject_WizardPage()
	 * @model dataType="de.hpi.sam.bp2009.benchframework.WizardPage" transient="true"
	 * @generated
	 */
	WizardPage getWizardPage();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.OptionObject#getWizardPage <em>Wizard Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wizard Page</em>' attribute.
	 * @see #getWizardPage()
	 * @generated
	 */
	void setWizardPage(WizardPage value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="de.hpi.sam.bp2009.benchframework.CloneNotSupportedException"
	 * @generated
	 */
	OptionObject clone() throws CloneNotSupportedException;

} // OptionObject
