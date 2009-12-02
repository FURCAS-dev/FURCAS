/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.xmlresultprocessor.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.benchframework.xmlresultprocessor.XMLResultProcessor;
import de.hpi.sam.bp2009.benchframework.xmlresultprocessor.XmlresultprocessorFactory;
import de.hpi.sam.bp2009.benchframework.xmlresultprocessor.XmlresultprocessorPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XmlresultprocessorPackageImpl extends EPackageImpl implements XmlresultprocessorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlResultProcessorEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.hpi.sam.bp2009.benchframework.xmlresultprocessor.XmlresultprocessorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XmlresultprocessorPackageImpl() {
		super(eNS_URI, XmlresultprocessorFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link XmlresultprocessorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XmlresultprocessorPackage init() {
		if (isInited) return (XmlresultprocessorPackage)EPackage.Registry.INSTANCE.getEPackage(XmlresultprocessorPackage.eNS_URI);

		// Obtain or create and register package
		XmlresultprocessorPackageImpl theXmlresultprocessorPackage = (XmlresultprocessorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XmlresultprocessorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XmlresultprocessorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theXmlresultprocessorPackage.createPackageContents();

		// Initialize created meta-data
		theXmlresultprocessorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXmlresultprocessorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XmlresultprocessorPackage.eNS_URI, theXmlresultprocessorPackage);
		return theXmlresultprocessorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMLResultProcessor() {
		return xmlResultProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmlresultprocessorFactory getXmlresultprocessorFactory() {
		return (XmlresultprocessorFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xmlResultProcessorEClass = createEClass(XML_RESULT_PROCESSOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BenchframeworkPackage theBenchframeworkPackage = (BenchframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(BenchframeworkPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xmlResultProcessorEClass.getESuperTypes().add(theBenchframeworkPackage.getResultProcessor());

		// Initialize classes and features; add operations and parameters
		initEClass(xmlResultProcessorEClass, XMLResultProcessor.class, "XMLResultProcessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //XmlresultprocessorPackageImpl
