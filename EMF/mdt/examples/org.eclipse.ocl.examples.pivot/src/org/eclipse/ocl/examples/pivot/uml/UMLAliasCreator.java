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
 * $Id: UMLAliasCreator.java,v 1.2 2011/01/24 20:47:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.utilities.AliasAdapter;

public class UMLAliasCreator extends AliasAdapter.AbstractCreator
{
	public static UMLAliasCreator INSTANCE = new UMLAliasCreator();

	public static void refreshPackageAliases(Resource resource) {
		INSTANCE.refreshAliases(resource);
	}

	public String getAlias(EObject eObject) {
		if (eObject instanceof org.eclipse.uml2.uml.Package) {
//			return ((org.eclipse.uml2.uml.Package)eObject).getNsPrefix();
		}
		return null;
	}
}