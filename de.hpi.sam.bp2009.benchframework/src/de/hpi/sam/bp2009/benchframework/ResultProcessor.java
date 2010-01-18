/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jface.wizard.WizardPage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.ResultProcessor#getResultPage <em>Result Page</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultProcessor()
 * @model abstract="true"
 * @generated
 */
public interface ResultProcessor extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Page</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Page</em>' attribute.
	 * @see #setResultPage(WizardPage)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultProcessor_ResultPage()
	 * @model dataType="de.hpi.sam.bp2009.benchframework.WizardPage"
	 * @generated
	 */
	WizardPage getResultPage();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.ResultProcessor#getResultPage <em>Result Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Page</em>' attribute.
	 * @see #getResultPage()
	 * @generated
	 */
	void setResultPage(WizardPage value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="de.hpi.sam.bp2009.benchframework.WizardPage" resultObjectsMany="false"
	 * @generated
	 */
	WizardPage showResults(EList<ResultObject> resultObjects);

} // ResultProcessor
