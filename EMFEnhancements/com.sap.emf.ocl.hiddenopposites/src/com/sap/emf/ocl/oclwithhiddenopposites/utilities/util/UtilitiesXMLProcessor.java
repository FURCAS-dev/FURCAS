/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.utilities.util;

import com.sap.emf.ocl.oclwithhiddenopposites.utilities.UtilitiesPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UtilitiesXMLProcessor extends XMLProcessor {

	/**
         * Public constructor to instantiate the helper.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public UtilitiesXMLProcessor() {
                super((EPackage.Registry.INSTANCE));
                UtilitiesPackage.eINSTANCE.eClass();
        }
	
	/**
         * Register for "*" and "xml" file extensions the UtilitiesResourceFactoryImpl factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
                if (registrations == null) {
                        super.getRegistrations();
                        registrations.put(XML_EXTENSION, new UtilitiesResourceFactoryImpl());
                        registrations.put(STAR_EXTENSION, new UtilitiesResourceFactoryImpl());
                }
                return registrations;
        }

} //UtilitiesXMLProcessor
