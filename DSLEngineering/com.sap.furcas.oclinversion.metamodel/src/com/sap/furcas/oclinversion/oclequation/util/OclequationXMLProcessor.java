/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.oclequation.util;

import com.sap.furcas.oclinversion.oclequation.OclequationPackage;

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
public class OclequationXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclequationXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        OclequationPackage.eINSTANCE.eClass();
    }
    
    /**
     * Register for "*" and "xml" file extensions the OclequationResourceFactoryImpl factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (registrations == null) {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new OclequationResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new OclequationResourceFactoryImpl());
        }
        return registrations;
    }

} //OclequationXMLProcessor
