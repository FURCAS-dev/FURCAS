/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase;

import de.ikv.medini.qvt.qvt.QvtVisitor;
import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.bridge.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Rule#getDomain <em>Domain</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Rule#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Rule#getOverriden <em>Overriden</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Rule#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference list.
	 * The list contents are of type {@link de.ikv.medini.qvt.model.qvtbase.Domain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getRule_Domain()
	 * @model type="de.ikv.medini.qvt.model.qvtbase.Domain" containment="true"
	 * @generated
	 */
	EList getDomain();

	/**
	 * Returns the value of the '<em><b>Overrides</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtbase.Rule#getOverriden <em>Overriden</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overrides</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overrides</em>' reference.
	 * @see #setOverrides(Rule)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getRule_Overrides()
	 * @see de.ikv.medini.qvt.model.qvtbase.Rule#getOverriden
	 * @model opposite="overriden"
	 * @generated
	 */
	Rule getOverrides();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Rule#getOverrides <em>Overrides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overrides</em>' reference.
	 * @see #getOverrides()
	 * @generated
	 */
	void setOverrides(Rule value);

	/**
	 * Returns the value of the '<em><b>Overriden</b></em>' reference list.
	 * The list contents are of type {@link de.ikv.medini.qvt.model.qvtbase.Rule}.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtbase.Rule#getOverrides <em>Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overriden</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overriden</em>' reference list.
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getRule_Overriden()
	 * @see de.ikv.medini.qvt.model.qvtbase.Rule#getOverrides
	 * @model type="de.ikv.medini.qvt.model.qvtbase.Rule" opposite="overrides"
	 * @generated
	 */
	EList getOverriden();

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(Transformation)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getRule_Transformation()
	 * @see de.ikv.medini.qvt.model.qvtbase.Transformation#getRule
	 * @model opposite="rule" required="true" transient="false"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Rule#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

} // Rule
