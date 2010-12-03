/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TextblocksXMLProcessor extends XMLProcessor {

        /**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TextblocksXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		TextblocksPackage.eINSTANCE.eClass();
	}
        
        /**
	 * Register for "*" and "xml" file extensions the TextblocksResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new TextblocksResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new TextblocksResourceFactoryImpl());
		}
		return registrations;
	}

} //TextblocksXMLProcessor
