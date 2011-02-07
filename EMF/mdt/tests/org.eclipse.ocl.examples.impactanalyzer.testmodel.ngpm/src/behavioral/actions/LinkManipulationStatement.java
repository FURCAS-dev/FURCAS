/**
 * <copyright>
 * </copyright>
 *
 * $Id: LinkManipulationStatement.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package behavioral.actions;

import data.classes.Association;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Manipulation Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.LinkManipulationStatement#getAt <em>At</em>}</li>
 *   <li>{@link behavioral.actions.LinkManipulationStatement#getAssociation <em>Association</em>}</li>
 *   <li>{@link behavioral.actions.LinkManipulationStatement#getObjects <em>Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getLinkManipulationStatement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ObjectsMustConformToEndTypes='Sequence{1..self.objects->size()}->forAll(i:Integer |\r\n    objects->at(i).getType().conformsTo(association.ends->at(i).type))' BlockMustNotImplementSideEffectFreeSignature='self.block.getImplementedSignature()->notEmpty() implies\r\n  not self.block.getImplementedSignature().sideEffectFree' NoValueMustBeModified='self.association.ends->forAll(ae:data::classes::AssociationEnd |\r\n    ae.type.clazz.valueType implies not ae.contributesToEquality)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ObjectsMustConformToEndTypes BlockMustNotImplementSideEffectFreeSignature NoValueMustBeModified'"
 * @generated
 */
public interface LinkManipulationStatement extends Statement {
	/**
     * Returns the value of the '<em><b>At</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * An optional position specification which will be ignored for associations with no ordered ends. If not set for an association with ordered ends, a reasonable default will be chosen.
     * <!-- end-model-doc -->
     * @return the value of the '<em>At</em>' attribute.
     * @see #setAt(int)
     * @see behavioral.actions.ActionsPackage#getLinkManipulationStatement_At()
     * @model unique="false" ordered="false"
     * @generated
     */
	int getAt();

	/**
     * Sets the value of the '{@link behavioral.actions.LinkManipulationStatement#getAt <em>At</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>At</em>' attribute.
     * @see #getAt()
     * @generated
     */
	void setAt(int value);

	/**
     * Returns the value of the '<em><b>Association</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Association</em>' reference.
     * @see #setAssociation(Association)
     * @see behavioral.actions.ActionsPackage#getLinkManipulationStatement_Association()
     * @model required="true"
     * @generated
     */
	Association getAssociation();

	/**
     * Sets the value of the '{@link behavioral.actions.LinkManipulationStatement#getAssociation <em>Association</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Association</em>' reference.
     * @see #getAssociation()
     * @generated
     */
	void setAssociation(Association value);

	/**
     * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
     * The list contents are of type {@link dataaccess.expressions.Expression}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Objects</em>' containment reference list.
     * @see behavioral.actions.ActionsPackage#getLinkManipulationStatement_Objects()
     * @model containment="true" resolveProxies="true" lower="2" upper="2"
     * @generated
     */
	EList<Expression> getObjects();

} // LinkManipulationStatement
