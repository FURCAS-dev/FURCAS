/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: NavigatorContentProvider.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * This Content Provider displays contents of model and diagrams. For the model,
 * this provider delegates contents computing to the model content provider.
 * <br>
 * creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class NavigatorContentProvider implements ITreeContentProvider {

	private static final Object[] NO_CHILDREN = new Object[0];

	private ITreeContentProvider delegatedModelProvider;

	private IDiagramGraphicalViewer diagramViewer;

	private AdditionalResources resources;

	/**
	 * Constructor
	 * 
	 * @param viewer
	 *            the editor
	 * @param delegatedProvider
	 *            the delegated content provider
	 */
	public NavigatorContentProvider(IDiagramGraphicalViewer viewer, ITreeContentProvider delegatedProvider) {
		delegatedModelProvider = delegatedProvider;
		diagramViewer = viewer;

		resources = new AdditionalResources(getCurrentDiagram().eResource().getResourceSet());
	}

	/**
	 * Return the current Diagram element associated with the viewer
	 * 
	 * @return Diagram
	 */
	protected Diagram getCurrentDiagram() {
		return (Diagram) diagramViewer.getContents().getModel();
	}

	/**
	 * Returns the additional resources node
	 * 
	 * @return the node
	 */
	protected AdditionalResources getAdditionalResources() {
		return resources;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parentElement) {
		// Only display diagram (no graphNodes or graphEdges)
		if (parentElement instanceof Diagram) {
			return NO_CHILDREN;
		}

		if (parentElement instanceof AdditionalResources) {
			return ((AdditionalResources) parentElement).getResources().toArray();
		}

		// Model children
		List<Object> children = new ArrayList<Object>();
		Object[] modelChildren = delegatedModelProvider.getChildren(parentElement);
		// children = Arrays.asList(modelChildren);
		for (int i = 0; i < modelChildren.length; i++) {
			Object child = modelChildren[i];
			children.add(child);
		}

		// For the model objects, retrieves model children and merges result
		// with diagrams associated with this element
		if (parentElement instanceof EObject || parentElement instanceof IWrapperItemProvider || parentElement instanceof FeatureMap.Entry) {
			children.addAll(findAllExistingDiagram(getCurrentDiagram().eResource(), (EObject) AdapterFactoryEditingDomain.unwrap(parentElement)));
		}

		return children.toArray();
	}

	private Collection<Diagram> findAllExistingDiagram(Resource diagramResource, EObject modelObject) {
		List<Diagram> diagrams = new ArrayList<Diagram>();
		if (diagramResource != null) {
			for (EObject content : diagramResource.getContents()) {
				if (content instanceof Diagram) {
					if (modelObject.equals(((Diagram) content).getElement())) {
						diagrams.add((Diagram) content);
					}
				}
			}
		}
		return diagrams;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		// The parent of a diagram is the model object that contains it.
		if (element instanceof Diagram) {
			return ((Diagram) element).getElement();
		}

		// Delegates
		if (element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry || element instanceof EObject) {
			return delegatedModelProvider.getParent(element);
		}

		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof Diagram) {
			return false;
		}

		return getChildren(element).length > 0;
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Resource) {
			List<Object> children = new ArrayList<Object>(((Resource) inputElement).getContents());
			children.add(resources);
			return children.toArray();
		}
		return NO_CHILDREN;
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		delegatedModelProvider.dispose();
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		delegatedModelProvider.inputChanged(viewer, oldInput, newInput);
	}

}