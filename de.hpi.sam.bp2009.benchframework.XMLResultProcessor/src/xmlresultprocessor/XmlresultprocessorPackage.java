/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package xmlresultprocessor;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see xmlresultprocessor.XmlresultprocessorFactory
 * @model kind="package"
 * @generated
 */
public interface XmlresultprocessorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xmlresultprocessor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.benchframework.xmlresultprocessor";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.xmlresultprocessor";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XmlresultprocessorPackage eINSTANCE = xmlresultprocessor.impl.XmlresultprocessorPackageImpl.init();

	/**
	 * The meta object id for the '{@link xmlresultprocessor.impl.XMLResultProcessorImpl <em>XML Result Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmlresultprocessor.impl.XMLResultProcessorImpl
	 * @see xmlresultprocessor.impl.XmlresultprocessorPackageImpl#getXMLResultProcessor()
	 * @generated
	 */
	int XML_RESULT_PROCESSOR = 0;

	/**
	 * The number of structural features of the '<em>XML Result Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_RESULT_PROCESSOR_FEATURE_COUNT = BenchframeworkPackage.RESULT_PROCESSOR_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link xmlresultprocessor.XMLResultProcessor <em>XML Result Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XML Result Processor</em>'.
	 * @see xmlresultprocessor.XMLResultProcessor
	 * @generated
	 */
	EClass getXMLResultProcessor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XmlresultprocessorFactory getXmlresultprocessorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link xmlresultprocessor.impl.XMLResultProcessorImpl <em>XML Result Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmlresultprocessor.impl.XMLResultProcessorImpl
		 * @see xmlresultprocessor.impl.XmlresultprocessorPackageImpl#getXMLResultProcessor()
		 * @generated
		 */
		EClass XML_RESULT_PROCESSOR = eINSTANCE.getXMLResultProcessor();

	}

} //XmlresultprocessorPackage
