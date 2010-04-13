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
 * $Id: EReferencesContentProvider.java,v 1.3 2008/04/28 08:41:19 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.internal.views;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Returns references to an EClass and the associated StructuralFeatures
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class EReferencesContentProvider implements ITreeContentProvider {

	private EClass selectedEClass;

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object element) {
		if (element instanceof WrappedEClass) {
			EClass eClass = ((WrappedEClass) element).getWrappedEClass();
			List<EReference> result = new ArrayList<EReference>();
			for (EStructuralFeature.Setting setting : EcoreUtil.UsageCrossReferencer.find(selectedEClass, eClass)) {
				if (setting.getEObject() instanceof EReference && !isContained(result, (EReference) setting.getEObject())) {
					result.add((EReference) setting.getEObject());
				}
			}
			return result.toArray();
		}
		return new Object[0];
	}

	private boolean isContained(List<EReference> l, EReference eRef) {
		boolean found = false;
		Iterator<EReference> it = l.iterator();
		while (it.hasNext() && !found) {
			EReference contained = it.next();
			if (contained.equals(eRef)) {
				found = true;
			}
		}
		return found;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		return element instanceof WrappedEClass;
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof EClass) {
			EClass eClass = (EClass) inputElement;
			List<WrappedEClass> result = new ArrayList<WrappedEClass>();
			// Search for all the EClass that have an EReference to the selected
			// EClass
			for (EStructuralFeature.Setting setting : EcoreUtil.UsageCrossReferencer.find(eClass, eClass.eResource())) {
				if (setting.getEObject() instanceof EReference && setting.getEObject().eContainer() instanceof EClass) {
					EClass eClass2 = (EClass) setting.getEObject().eContainer();
					if (!isContained(result, eClass2)) {
						// We need to wrap the EClass to avoid an infinite loop
						// for self EReferences
						result.add(new WrappedEClass(eClass2));
					}
				}
			}
			return result.toArray();
		}

		return getChildren(inputElement);
	}

	/**
	 * Search whether the given EClass is already wrapped into a WrappedEClass
	 * in the given list.
	 * 
	 * @param l
	 *            a list of WrappedEClass
	 * @param eClass
	 *            the EClass to look for
	 * @return true whether the given EClass is already wrapped into a
	 *         WrappedEClass
	 */
	private boolean isContained(List<WrappedEClass> l, EClass eClass) {
		boolean found = false;
		Iterator<WrappedEClass> it = l.iterator();
		while (it.hasNext() && !found) {
			WrappedEClass contained = it.next();
			if (contained.getWrappedEClass().equals(eClass)) {
				found = true;
			}
		}
		return found;
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// Do nothing
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof EClass) {
			this.selectedEClass = (EClass) newInput;
		}
	}

	/**
	 * Define a wrapper for an EClass. This is used to distinguish the current
	 * selected EClass (from which we are searching EReferences) from the same
	 * EClass that may be represented in the view in the case of a self
	 * reference.
	 */
	protected class WrappedEClass {

		private EClass wrappedEClass;

		/**
		 * Constructor
		 * 
		 * @param eClassToWrap
		 */
		public WrappedEClass(EClass eClassToWrap) {
			this.wrappedEClass = eClassToWrap;
		}

		/**
		 * @return the wrappedEClass
		 */
		public EClass getWrappedEClass() {
			return wrappedEClass;
		}
	}

}
