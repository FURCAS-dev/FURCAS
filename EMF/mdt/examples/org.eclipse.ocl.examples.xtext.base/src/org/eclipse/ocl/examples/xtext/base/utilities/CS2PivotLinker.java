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
 * $Id: CS2PivotLinker.java,v 1.5 2011/02/11 20:00:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.lazy.LazyLinker;

/**
 * CS2PivotLinker ensures that the CS 2 Pivot mappings are refreshed after
 * and CS Resource modification is committed.
 */
public class CS2PivotLinker extends LazyLinker
{
	@Override
	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		Resource eResource = model.eResource();		// FIXME Try to do a narrower refresh
//		System.out.println(Thread.currentThread().getName() + " afterModelLinked " + getClass().getSimpleName() + "@" + hashCode()
//			+ " " + eResource.getClass().getSimpleName() + "@" + eResource.hashCode() + " " + eResource.getURI());		
		if ((eResource instanceof BaseCSResource) && eResource.getErrors().isEmpty()) {
//			System.out.println("Starting to refreshPivotMappings for " + eResource.getURI());
			BaseCSResource csResource = (BaseCSResource) eResource;
			CS2PivotResourceAdapter resourceAdapter = CS2PivotResourceAdapter.getAdapter(csResource, null);
			for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Pivotable) {	// FIXME try to keep pivots
					((Pivotable)eObject).resetPivot();
				}
				
			}
			resourceAdapter.refreshPivotMappings();
//			System.out.println("Finished refreshPivotMappings for " + eResource.getURI());
		}
	}
}