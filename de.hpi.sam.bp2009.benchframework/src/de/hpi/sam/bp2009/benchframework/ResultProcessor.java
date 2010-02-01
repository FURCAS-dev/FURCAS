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
 * A representation of the model object '<em><b>Result Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Subclasses are responsible for rendering testrun result processing
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.ResultProcessor#getResultPage <em>Result Page</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.ResultProcessor#getTestrun <em>Testrun</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultProcessor()
 * @model interface="true" abstract="true"
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
	 * Returns the value of the '<em><b>Testrun</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testrun</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testrun</em>' reference.
	 * @see #setTestrun(TestRun)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultProcessor_Testrun()
	 * @model
	 * @generated
	 */
	TestRun getTestrun();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.ResultProcessor#getTestrun <em>Testrun</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testrun</em>' reference.
	 * @see #getTestrun()
	 * @generated
	 */
	void setTestrun(TestRun value);

} // ResultProcessor
