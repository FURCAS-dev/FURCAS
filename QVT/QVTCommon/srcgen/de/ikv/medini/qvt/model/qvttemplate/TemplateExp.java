/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate;

import de.ikv.medini.qvt.qvt.QvtVisitor;
import org.oslo.ocl20.semantics.model.expressions.LiteralExp;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.TemplateExp#getBindsTo <em>Binds To</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.TemplateExp#getWhere <em>Where</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getTemplateExp()
 * @model abstract="true"
 * @generated
 */
public interface TemplateExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Binds To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds To</em>' reference.
	 * @see #setBindsTo(VariableDeclaration)
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getTemplateExp_BindsTo()
	 * @model
	 * @generated
	 */
	VariableDeclaration getBindsTo();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvttemplate.TemplateExp#getBindsTo <em>Binds To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binds To</em>' reference.
	 * @see #getBindsTo()
	 * @generated
	 */
	void setBindsTo(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' containment reference.
	 * @see #setWhere(OclExpression)
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getTemplateExp_Where()
	 * @model containment="true"
	 * @generated
	 */
	OclExpression getWhere();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvttemplate.TemplateExp#getWhere <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where</em>' containment reference.
	 * @see #getWhere()
	 * @generated
	 */
	void setWhere(OclExpression value);

} // TemplateExp
