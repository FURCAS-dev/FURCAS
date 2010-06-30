/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.util;

import com.sap.emf.ocl.oclwithhiddenopposites.OclwithhiddenoppositesPackage;

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
public class OclwithhiddenoppositesXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclwithhiddenoppositesXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		OclwithhiddenoppositesPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the OclwithhiddenoppositesResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new OclwithhiddenoppositesResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new OclwithhiddenoppositesResourceFactoryImpl());
		}
		return registrations;
	}

} //OclwithhiddenoppositesXMLProcessor
