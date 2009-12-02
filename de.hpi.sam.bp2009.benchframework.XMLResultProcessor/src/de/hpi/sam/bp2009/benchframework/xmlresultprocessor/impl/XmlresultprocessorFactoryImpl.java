/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.xmlresultprocessor.impl;

import de.hpi.sam.bp2009.benchframework.xmlresultprocessor.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XmlresultprocessorFactoryImpl extends EFactoryImpl implements XmlresultprocessorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XmlresultprocessorFactory init() {
		try {
			XmlresultprocessorFactory theXmlresultprocessorFactory = (XmlresultprocessorFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.benchframework.xmlresultprocessor"); 
			if (theXmlresultprocessorFactory != null) {
				return theXmlresultprocessorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XmlresultprocessorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmlresultprocessorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XmlresultprocessorPackage.XML_RESULT_PROCESSOR: return createXMLResultProcessor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLResultProcessor createXMLResultProcessor() {
		XMLResultProcessorImpl xmlResultProcessor = new XMLResultProcessorImpl();
		return xmlResultProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmlresultprocessorPackage getXmlresultprocessorPackage() {
		return (XmlresultprocessorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XmlresultprocessorPackage getPackage() {
		return XmlresultprocessorPackage.eINSTANCE;
	}

} //XmlresultprocessorFactoryImpl
