/**
 * <copyright>
 * </copyright>
 *
 * $Id: TemplatesFactory.java,v 1.1 2011/02/07 16:58:52 auhl Exp $
 */
package ui.templates;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ui.templates.TemplatesPackage
 * @generated
 */
public interface TemplatesFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TemplatesFactory eINSTANCE = ui.templates.impl.TemplatesFactoryImpl.init();

	/**
     * Returns a new object of class '<em>String Template</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>String Template</em>'.
     * @generated
     */
	StringTemplate createStringTemplate();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	TemplatesPackage getTemplatesPackage();

} //TemplatesFactory
