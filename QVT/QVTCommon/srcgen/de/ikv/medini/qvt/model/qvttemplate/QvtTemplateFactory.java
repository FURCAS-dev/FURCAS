/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage
 * @generated
 */
public interface QvtTemplateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QvtTemplateFactory eINSTANCE = de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Colletion Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Colletion Template Exp</em>'.
	 * @generated
	 */
	ColletionTemplateExp createColletionTemplateExp();

	/**
	 * Returns a new object of class '<em>Object Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Template Exp</em>'.
	 * @generated
	 */
	ObjectTemplateExp createObjectTemplateExp();

	/**
	 * Returns a new object of class '<em>Property Template Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Template Item</em>'.
	 * @generated
	 */
	PropertyTemplateItem createPropertyTemplateItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QvtTemplatePackage getQvtTemplatePackage();

} //QvtTemplateFactory
