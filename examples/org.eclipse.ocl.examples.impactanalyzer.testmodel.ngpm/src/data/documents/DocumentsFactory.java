/**
 * <copyright>
 * </copyright>
 *
 * $Id: DocumentsFactory.java,v 1.1 2011/02/07 16:49:09 auhl Exp $
 */
package data.documents;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see data.documents.DocumentsPackage
 * @generated
 */
public interface DocumentsFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	DocumentsFactory eINSTANCE = data.documents.impl.DocumentsFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Dummy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Dummy</em>'.
     * @generated
     */
	Dummy createDummy();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	DocumentsPackage getDocumentsPackage();

} //DocumentsFactory
