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
 * $Id: LibraryScopeAdapter.java,v 1.1 2011/05/20 15:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.ValidationDiagnostic;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class LibraryScopeAdapter extends MonikeredElementCSScopeAdapter<LibraryCS, org.eclipse.ocl.examples.pivot.Package>
{
	private URI uri = null;
	private Element importedElement = null;
	private Throwable throwable = null;
	
	public LibraryScopeAdapter(TypeManager typeManager, LibraryCS csElement) {
		super(typeManager, csElement, org.eclipse.ocl.examples.pivot.Package.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EReference targetReference = scopeView.getTargetReference();
		if (targetReference == BaseCSTPackage.Literals.LIBRARY_CS__PACKAGE) {
			String name = environmentView.getName();
			if (name != null) {
				importLibrary(environmentView);
			}
			if (importedElement != null) {
				Resource importedResource = importedElement.eResource();
				List<Resource.Diagnostic> errors = importedResource.getErrors();
				if (errors.size() == 0) {
					environmentView.addElement(name, importedElement);
//					typeManager.loadLibrary(importedResource);
				}
			}
			return null;
		}
		else {
			EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
			if (containmentFeature == null) {
				environmentView.addElementsOfScope(importedElement, scopeView);
			}
			else {
				environmentView.addElementsOfScope(importedElement, scopeView);
			}
			return scopeView.getOuterScope();
		}
	}

	public String getMessage() {
		return throwable != null ? throwable.getMessage() : null;
	}

	protected void importLibrary(EnvironmentView environmentView) {
		String name = environmentView.getName();
		if (name == null) {
			return;
		}
		StandardLibraryContribution contribution = StandardLibraryContribution.REGISTRY.get(name);
		if (contribution != null) {
			Resource resource = contribution.getResource();
			typeManager.loadLibrary(resource);
			environmentView.addElement(name, resource.getContents().get(0));
			return;
		}
		BaseCSResource csResource = (BaseCSResource) target.eResource();
		try {
			URI newURI = URI.createURI(name);
			newURI = csResource.resolve(newURI);
			if (newURI.equals(uri)) {
				return;
			}
			uri = newURI;					// Lock out recursive attempt from EcoreUtil.resolveProxy
			importedElement = null;
			throwable = null;
		} catch (WrappedException e) {
			throwable = e.exception();
			return;
		} catch (Exception e) {
			throwable = e;
			return;
		}
		List<EObject> importedElements = new ArrayList<EObject>();
		typeManager.setDefaultStandardLibraryURI(null);
		ResourceSet csResourceSet = csResource.getResourceSet();
		TypeManagerResourceSetAdapter.getAdapter(csResourceSet, typeManager);
		try {
			BaseCSResource importedResource = (BaseCSResource)csResourceSet.getResource(uri, true);
			List<EObject> contents = importedResource.getContents();
			if (contents.size() > 0) {
				for (EObject content : contents) {
					if (content instanceof Pivotable) {
						Element pivot = ((Pivotable)content).getPivot();
						importedElements.add(pivot);
						if (importedElement == null) {
							importedElement = pivot;		// FIXME Use a single RootElement
						}
					}
				}
			}
			List<Resource.Diagnostic> warnings = importedResource.getWarnings();
			if (warnings.size() > 0) {
				INode node = NodeModelUtils.getNode(target);
				String errorMessage = PivotUtil.formatResourceDiagnostics(warnings, "Warnings in '" + uri + "'", "\n\t");
				Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
				csResource.getWarnings().add(resourceDiagnostic);
			}
			List<Resource.Diagnostic> errors = importedResource.getErrors();
			if (errors.size() > 0) {
				INode node = NodeModelUtils.getNode(target);
				String errorMessage = PivotUtil.formatResourceDiagnostics(errors, "Errors in '" + uri + "'", "\n\t");
				Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
				csResource.getErrors().add(resourceDiagnostic);
			}
		} catch (WrappedException e) {
			throwable = e.exception();
		} catch (Exception e) {
			throwable = e;
		}
	}
}
