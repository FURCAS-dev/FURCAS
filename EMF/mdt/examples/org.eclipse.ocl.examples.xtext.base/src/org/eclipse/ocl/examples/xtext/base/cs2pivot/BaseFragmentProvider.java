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
 * $Id: BaseFragmentProvider.java,v 1.4 2011/03/01 08:47:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.xtext.resource.DefaultFragmentProvider;

public class BaseFragmentProvider extends DefaultFragmentProvider
{
	@Override
	public EObject getEObject(Resource resource, String fragment, Fallback fallback) {
		if (fragment.startsWith("//@ownedNestedPackage")) {
			return super.getEObject(resource, fragment, fallback);
		}
		try {
			CS2PivotResourceAdapter converter = CS2PivotResourceAdapter.findAdapter((BaseCSResource)resource);
			if (converter != null) {
				Resource pivotResource = converter.getPivotResource(resource);
				if (pivotResource != null) {
					EObject eObject = pivotResource.getEObject(fragment);
					if (eObject != null) {
						return eObject;
					}
				}
			}
		}
		catch (IllegalArgumentException e) {
			// Maybe it's a CS URI after all.
		}
		return super.getEObject(resource, fragment, fallback);
	}
}
