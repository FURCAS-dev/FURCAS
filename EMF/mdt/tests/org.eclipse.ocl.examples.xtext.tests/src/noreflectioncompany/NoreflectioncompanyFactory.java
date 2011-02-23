/**
 * <copyright>
 * </copyright>
 *
 * $Id: NoreflectioncompanyFactory.java,v 1.1 2011/01/30 10:58:03 ewillink Exp $
 */
package noreflectioncompany;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see noreflectioncompany.NoreflectioncompanyPackage
 * @generated
 */
public interface NoreflectioncompanyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NoreflectioncompanyFactory eINSTANCE = noreflectioncompany.impl.NoreflectioncompanyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Company</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Company</em>'.
	 * @generated
	 */
	Company createCompany();

	/**
	 * Returns a new object of class '<em>Employee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Employee</em>'.
	 * @generated
	 */
	Employee createEmployee();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NoreflectioncompanyPackage getNoreflectioncompanyPackage();

} //NoreflectioncompanyFactory
