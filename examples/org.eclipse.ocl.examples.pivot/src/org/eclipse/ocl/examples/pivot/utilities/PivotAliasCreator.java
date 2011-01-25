/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotAliasCreator.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Package;

public class PivotAliasCreator extends AliasAdapter.AbstractCreator
{
	public static PivotAliasCreator INSTANCE = new PivotAliasCreator();

	public static void refreshPackageAliases(Resource resource) {
		INSTANCE.refreshAliases(resource);
	}

	public String getAlias(EObject eObject) {
		if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
			Package pivotPackage = (org.eclipse.ocl.examples.pivot.Package)eObject;
			String nsPrefix = pivotPackage.getNsPrefix();
			return nsPrefix != null ? nsPrefix : pivotPackage.getName();		// FIXME NsPrefix
		}
		return null;
	}
}