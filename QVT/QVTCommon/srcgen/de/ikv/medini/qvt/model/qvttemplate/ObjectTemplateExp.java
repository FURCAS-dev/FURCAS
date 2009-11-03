/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp#getRefferedClass <em>Reffered Class</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getObjectTemplateExp()
 * @model
 * @generated
 */
public interface ObjectTemplateExp extends TemplateExp {
	/**
	 * Returns the value of the '<em><b>Reffered Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reffered Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reffered Class</em>' reference.
	 * @see #setRefferedClass(Classifier)
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getObjectTemplateExp_RefferedClass()
	 * @model required="true"
	 * @generated
	 */
	Classifier getRefferedClass();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp#getRefferedClass <em>Reffered Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reffered Class</em>' reference.
	 * @see #getRefferedClass()
	 * @generated
	 */
	void setRefferedClass(Classifier value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem}.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getObjectTemplateExp_Part()
	 * @see de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getObjContainer
	 * @model type="de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem" opposite="objContainer" containment="true"
	 * @generated
	 */
	EList getPart();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // ObjectTemplateExp
