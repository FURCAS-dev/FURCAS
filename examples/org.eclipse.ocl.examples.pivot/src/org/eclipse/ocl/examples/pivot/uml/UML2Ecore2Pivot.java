/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: UML2Ecore2Pivot.java,v 1.3 2011/05/14 06:55:41 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.UML2EcoreConverter;

public class UML2Ecore2Pivot extends Ecore2Pivot
{
//	private static final Logger logger = Logger.getLogger(UML2Ecore2Pivot.class);

	// FIXME this is a prehistoric value
//	private static final String OCL_STANDARD_LIBRARY_NS_URI = "http://www.eclipse.org/ocl/1.1.0/oclstdlib.uml"; //$NON-NLS-1$

	public static UML2Ecore2Pivot getAdapter(Resource resource, TypeManager typeManager) {
		if (resource == null) {
			return null;
		}
		List<Adapter> eAdapters = resource.eAdapters();
		UML2Ecore2Pivot adapter = PivotUtil.getAdapter(UML2Ecore2Pivot.class, resource);
		if (adapter != null) {
			return adapter;
		}
		adapter = new UML2Ecore2Pivot(resource, typeManager);
		eAdapters.add(adapter);
		return adapter;
	}

	/**
	 * Convert an (annotated) Ecore resource to a Pivot Model.
	 * @param alias 
	 * 
	 * @param ecoreResource the annotated Ecore resource
	 * 
	 * @return the Pivot root package
	 */
	public static org.eclipse.ocl.examples.pivot.Package importFromUML(TypeManager typeManager, String alias, Resource umlResource) {
		if (umlResource == null) {
			return null;
		}
		UML2Ecore2Pivot conversion = getAdapter(umlResource, typeManager);
		return conversion.getPivotRoot();
	}

	/**
	 * Initialize registries to support OCL and UML usage. This method is
	 * intended for initialization of standalone behaviors for which plugin extension
	 * registrations have not been applied.
	 *<p> 
	 * A null resourceSet may be provided to initialize the global package registry
	 * and global URI mapping registry.
	 *<p> 
	 * A non-null resourceSet may be provided to identify specific package
	 * and global URI mapping registries.
	 *<p> 
	 * The locations of the org.eclipse.ocl.uml and org.eclipse.uml2.uml.resources
	 * plugins must be identified by the correspondingly named Java properties.
	 * A standalone application command line might do this by incorporating
	 * 
	 * <p><tt>-Dorg.eclipse.ocl.uml=C:/Eclipse/plugins/org.eclipse.ocl.uml</tt>
	 * <br><tt>-Dorg.eclipse.uml2.uml.resources=C:/Eclipse/plugins/org.eclipse.uml2.uml.resources</tt>
	 * <p>
	 * This method is used to configure the ResourceSet used to load the OCL Standard Library.

	 * @param resourceSet to be initialized or null for global initialization
	 * @return a failure reason, null if successful
	 */
	public static String initialize(ResourceSet resourceSet) {
//		String oclLocation = System.getProperty("org.eclipse.ocl.uml"); //$NON-NLS-1$
//		if (oclLocation == null)
//			return "'org.eclipse.ocl.uml' property not defined; use the launch configuration to define it"; //$NON-NLS-1$
		String resourcesLocation = System.getProperty("org.eclipse.uml2.uml.resources"); //$NON-NLS-1$
		if (resourcesLocation == null)
			return "'org.eclipse.uml2.uml.resources' property not defined; use the launch configuration to define it"; //$NON-NLS-1$
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet != null
			? resourceSet.getResourceFactoryRegistry()
			: Resource.Factory.Registry.INSTANCE;
		resourceFactoryRegistry.getExtensionToFactoryMap().put(
			UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		Map<URI, URI> uriMap = resourceSet != null
			? resourceSet.getURIConverter().getURIMap()
			: URIConverter.URI_MAP;		
// FIXME try something like classpath:/org/eclipse/ocl/examples/xtext/essentialocl/EssentialOCL.xmi
//		uriMap.put(URI.createURI(OCL_STANDARD_LIBRARY_NS_URI), URI.createFileURI(oclLocation + "/model/oclstdlib.uml")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), URI.createFileURI(resourcesLocation + "/profiles/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), URI.createFileURI(resourcesLocation + "/metamodels/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), URI.createFileURI(resourcesLocation + "/libraries/")); //$NON-NLS-1$
		return null;
	}

	public static boolean isUML(Resource resource) {
		List<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			if (content instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Convert an (annotated) Ecore object to a pivot element. 
	 * 
	 * @param eObject the annotated Ecore object
	 * 
	 * @return the pivot element
	 *
	public static Element importFromUML(TypeManager typeManager, String alias, EObject eObject) {
		if (eObject == null) {
			return null;
		}
		Resource ecoreResource = eObject.eResource();
		UML2Ecore2Pivot conversion = getAdapter(ecoreResource, typeManager);
		org.eclipse.ocl.examples.pivot.Package pivotRoot = conversion.getPivotRoot();
		if (pivotRoot == null) {
			return null;
		}
		return conversion.createMap.get(eObject);
	} */
	
	protected final Resource umlResource;					// Set via eAdapters.add()
	private UML2EcoreConverter uml2EcoreConverter = null;
	private Map<String, String> options = null;

	public UML2Ecore2Pivot(Resource umlResource, TypeManager typeManager) {
		super(typeManager.getExternalResourceSet().createResource(umlResource.getURI().appendFileExtension(".ecore")), typeManager);
		this.umlResource = umlResource;
		typeManager.addExternalResource(this);
	}

	@Override
	public <T extends Element> T getCreated(Class<T> requiredClass, EObject eObject) {
		EObject ecoreObject = (EObject) uml2EcoreConverter.doSwitch(eObject);
		if (ecoreObject == null) {
			ecoreObject = eObject;
		}
		return super.getCreated(requiredClass, ecoreObject);
	}

	public <T extends Element> T getPivotOfUML(Class<T> requiredClass, EObject eObject) {
		EObject ecoreObject = (EObject) uml2EcoreConverter.doSwitch(eObject);
		return getPivotOfEcore(requiredClass, ecoreObject);
	}

	@Override
	public Package getPivotRoot() {
		if (pivotRoot == null) {
			List<EObject> contents = umlResource.getContents();
			if (options == null) {
				options = new HashMap<String, String>();
				options.put(UML2EcoreConverter.OPTION__ECORE_TAGGED_VALUES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__REDEFINING_OPERATIONS, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__REDEFINING_PROPERTIES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__SUBSETTING_PROPERTIES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__UNION_PROPERTIES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DERIVED_FEATURES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATIONS, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__SUPER_CLASS_ORDER, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__ANNOTATION_DETAILS, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__INVARIANT_CONSTRAINTS, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__OPERATION_BODIES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__COMMENTS,  UMLUtil.OPTION__PROCESS);
			}
			if (uml2EcoreConverter == null) {
				uml2EcoreConverter = new UML2EcoreConverter();
			}
			Collection<? extends EObject> ecoreContents = uml2EcoreConverter.convert(contents, options, null, null);
			ecoreResource.getContents().addAll(ecoreContents);
		}
		return super.getPivotRoot();
	}

	@Override
	public Resource getResource() {
		return umlResource;
	}

	@Override
	public Notifier getTarget() {
		return umlResource;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == UML2Ecore2Pivot.class;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		assert (newTarget == null) || (newTarget == umlResource);
	}
}