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
 * $Id: EcoreAliasCreator.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.utilities.AliasAdapter;

public class EcoreAliasCreator extends AliasAdapter.AbstractCreator
{
	public static EcoreAliasCreator INSTANCE = new EcoreAliasCreator();

	public static void refreshPackageAliases(Resource resource) {
		INSTANCE.refreshAliases(resource);
	}

	public String getAlias(EObject eObject) {
		if (eObject instanceof EPackage) {
			return ((EPackage)eObject).getNsPrefix();
		}
		return null;
	}
}