/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate;

import org.oslo.ocl20.semantics.OclVisitor;
import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.oslo.ocl20.semantics.bridge.Element;
import org.oslo.ocl20.semantics.bridge.Property;

import org.oslo.ocl20.semantics.model.expressions.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Template Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getValue <em>Value</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getPropertyTemplateItem()
 * @model
 * @generated
 */
public interface PropertyTemplateItem extends Element {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OclExpression)
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getPropertyTemplateItem_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getValue();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getPropertyTemplateItem_ReferredProperty()
	 * @model required="true"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Obj Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj Container</em>' container reference.
	 * @see #setObjContainer(ObjectTemplateExp)
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getPropertyTemplateItem_ObjContainer()
	 * @see de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp#getPart
	 * @model opposite="part" required="true" transient="false"
	 * @generated
	 */
	ObjectTemplateExp getObjContainer();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj Container</em>' container reference.
	 * @see #getObjContainer()
	 * @generated
	 */
	void setObjContainer(ObjectTemplateExp value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // PropertyTemplateItem
