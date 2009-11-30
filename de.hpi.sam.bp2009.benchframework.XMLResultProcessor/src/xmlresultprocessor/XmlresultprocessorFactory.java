/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package xmlresultprocessor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see xmlresultprocessor.XmlresultprocessorPackage
 * @generated
 */
public interface XmlresultprocessorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XmlresultprocessorFactory eINSTANCE = xmlresultprocessor.impl.XmlresultprocessorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XML Result Processor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XML Result Processor</em>'.
	 * @generated
	 */
	XMLResultProcessor createXMLResultProcessor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XmlresultprocessorPackage getXmlresultprocessorPackage();

} //XmlresultprocessorFactory
