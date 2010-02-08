/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.util;

import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerPackage;

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
public class ModifiedOclOptimizerXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedOclOptimizerXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ModifiedOclOptimizerPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the ModifiedOclOptimizerResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ModifiedOclOptimizerResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ModifiedOclOptimizerResourceFactoryImpl());
		}
		return registrations;
	}

} //ModifiedOclOptimizerXMLProcessor
