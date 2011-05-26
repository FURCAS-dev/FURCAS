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
 * $Id: BaseReferenceFinder.java,v 1.1 2011/05/15 20:22:17 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.findrefs;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.DefaultReferenceFinder;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.base.Predicate;
import com.google.inject.Inject;


@SuppressWarnings("restriction")
public class BaseReferenceFinder extends DefaultReferenceFinder
{
	@Inject
	public BaseReferenceFinder(IResourceDescriptions index) {
		super(index);
	}

	@Override
	protected Map<EObject, URI> createExportedElementsMap(Resource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		CS2Pivot cs2Pivot = CS2Pivot.findAdapter(resourceSet);
		if (cs2Pivot != null) {
			for (Resource csResource : cs2Pivot.getCSResources()) {
				if (resource == cs2Pivot.getPivotResource(csResource)) {
					return super.createExportedElementsMap(csResource);
				}
			}
		}
		return super.createExportedElementsMap(resource);
	}

	@Override
	public void findLocalReferences(Set<? extends EObject> targets,
			IAcceptor<IReferenceDescription> acceptor,
			Predicate<IReferenceDescription> filter, IProgressMonitor monitor) {
		Set<EObject> csTargets = new HashSet<EObject>(targets);
		for (EObject target : targets) {			
			if (target instanceof MonikeredElement) {
				target = ElementUtil.getCsElement((MonikeredElement) target);
				if (target != null) {
					csTargets.add(target);
				}
			}
			else if (target instanceof Pivotable) {
				target = ((Pivotable) target).getPivot();
				if (target != null) {
					csTargets.add(target);
				}
			}
		}
		super.findLocalReferences(csTargets, acceptor, filter, monitor);
	}
}
