/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: Pivot2Ecore.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

public class Pivot2Ecore extends AbstractConversion
{
	public static final Logger logger = Logger.getLogger(Pivot2Ecore.class);

	public static List<EObject> createResource(TypeManager typeManager, Resource pivotResource) {
		List<EObject> pivotRoots = pivotResource.getContents();
		Pivot2Ecore converter = new Pivot2Ecore(typeManager);
		return converter.convertAll(pivotRoots);
	}

	/**
	 * Mapping of pivot elements to the resulting E elements.
	 */
	private Map<Element, EModelElement> createMap = new HashMap<Element, EModelElement>();

	/**
	 * Mapping of all E elements created during pass 1 that require further work
	 * with respect to the corresponding CS element in pass 2.
	 */
	Set<Element> deferMap = new HashSet<Element>();
	
	private List<Resource.Diagnostic> errors = null;
	
	protected final Pivot2EcoreDeclarationVisitor pass1 = new Pivot2EcoreDeclarationVisitor(this);	
	protected final Pivot2EcoreReferenceVisitor pass2 = new Pivot2EcoreReferenceVisitor(this);
	
	protected final TypeManager typeManager;
//	protected final ResourceSet resourceSet;
//	protected final Resource csResource;
//	protected final XMLResource eResource;
	

	public Pivot2Ecore(TypeManager typeManager/*ResourceSet resourceSet, Resource csResource, URI ecoreURI*/) {
		this.typeManager = typeManager;
//		this.resourceSet = resourceSet;
//		this.csResource = csResource;
//		this.eResource = (XMLResource) new EcoreResourceFactoryImpl().createResource(ecoreURI);
	}
	
	protected EObject convert(Element pivotObject) {
		EObject eObject = pass1.safeVisit(pivotObject);
		for (Element eKey : deferMap) {
			pass2.safeVisit(eKey);
		}
		return eObject;
	}

	protected List<EObject> convertAll(List<? extends EObject> pivotObjects) {
		List<EObject> eObjects = new ArrayList<EObject>();
		for (EObject pivotObject : pivotObjects) {
			if (pivotObject instanceof Element) {
				eObjects.add(pass1.safeVisit((Visitable) pivotObject));
			}
		}
		for (Element eKey : deferMap) {
			pass2.safeVisit(eKey);
		}
		return eObjects;
	}

	protected void error(String message) {
		if (errors == null) {
			errors = new ArrayList<Resource.Diagnostic>();
		}
		errors.add(new XMIException(message));
	}

/*	public XMLResource exportToEcore() {
		OCLinEcoreDocumentCS document = (OCLinEcoreDocumentCS) csResource.getContents().get(0);
		Collection<? extends EObject> ecoreContents = convertAll(document.getPackages());
		eResource.getContents().addAll(ecoreContents);
		if (errors != null) {
			eResource.getErrors().addAll(errors);
		}
		return eResource;
	} */

	public void defer(Element pivotElement) {
		deferMap.add(pivotElement);
	}

	public <T extends EObject> T getCreated(Class<T> requiredClass, Element pivotElement) {
		EModelElement eModelElement = createMap.get(pivotElement);
		if (eModelElement == null) {
			return null;
		}
		if (!requiredClass.isAssignableFrom(eModelElement.getClass())) {
			logger.error("Ecore " + eModelElement.getClass().getName() + "' element is not a '" + requiredClass.getName() + "'"); //$NON-NLS-1$
			return null;
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) eModelElement;
		return castElement;
	}
	
	public TypeManager getTypeManager() {
		return typeManager;
	}

	public void putCreated(Element pivotElement, EModelElement eModelElement) {
		EModelElement old = createMap.put(pivotElement, eModelElement);
		assert old == null;
	}
}