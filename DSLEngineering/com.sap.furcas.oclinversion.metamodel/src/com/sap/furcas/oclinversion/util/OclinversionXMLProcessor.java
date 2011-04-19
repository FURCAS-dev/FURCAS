/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.util;

import com.sap.furcas.oclinversion.OclinversionPackage;

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
public class OclinversionXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclinversionXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        OclinversionPackage.eINSTANCE.eClass();
    }
    
    /**
     * Register for "*" and "xml" file extensions the OclinversionResourceFactoryImpl factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (registrations == null) {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new OclinversionResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new OclinversionResourceFactoryImpl());
        }
        return registrations;
    }

} //OclinversionXMLProcessor
