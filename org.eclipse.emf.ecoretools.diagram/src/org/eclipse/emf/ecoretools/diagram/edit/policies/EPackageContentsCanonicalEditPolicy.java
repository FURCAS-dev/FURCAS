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
 * $Id: EPackageContentsCanonicalEditPolicy.java,v 1.5 2009/02/02 08:39:06 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataType2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnum2EditPart;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramUpdater;
import org.eclipse.emf.ecoretools.diagram.part.EcoreNodeDescriptor;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EPackageContentsCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = EcoreDiagramUpdater.getEPackageContents_5003SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((EcoreNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		if (view.getEAnnotation("Shortcut") != null) {//$NON-NLS-1$
			return EcoreDiagramUpdater.isShortcutOrphaned(view);
		}
		int visualID = EcoreVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case EClass2EditPart.VISUAL_ID:
		case EDataType2EditPart.VISUAL_ID:
		case EEnum2EditPart.VISUAL_ID:
			return !semanticChildren.contains(view.getElement()) || visualID != EcoreVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(EcorePackage.eINSTANCE.getEPackage_EClassifiers());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#refreshSemantic()
	 */
	@Override
	protected void refreshSemantic() {
		deleteOrphanedViews();
	}

	/**
	 * Delete orphaned views
	 */
	protected void deleteOrphanedViews() {

		// Don't try to refresh children if the semantic element
		// cannot be resolved.
		if (resolveSemanticElement() == null) {
			return;
		}

		// Current views
		List viewChildren = getViewChildren();
		List semanticChildren = new ArrayList(getSemanticChildrenList());

		List orphaned = cleanCanonicalSemanticChildren(viewChildren, semanticChildren);
		boolean changed = false;

		// Delete all the remaining oprphaned views
		if (!orphaned.isEmpty()) {
			changed = deleteViews(orphaned.iterator());
		}
	}
}
