/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.util;

import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

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
public class TCSXMLProcessor extends XMLProcessor {

        /**
         * Public constructor to instantiate the helper.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public TCSXMLProcessor() {
                super((EPackage.Registry.INSTANCE));
                TCSPackage.eINSTANCE.eClass();
        }
        
        /**
         * Register for "*" and "xml" file extensions the TCSResourceFactoryImpl factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected Map<String, Resource.Factory> getRegistrations() {
                if (registrations == null) {
                        super.getRegistrations();
                        registrations.put(XML_EXTENSION, new TCSResourceFactoryImpl());
                        registrations.put(STAR_EXTENSION, new TCSResourceFactoryImpl());
                }
                return registrations;
        }

} //TCSXMLProcessor
