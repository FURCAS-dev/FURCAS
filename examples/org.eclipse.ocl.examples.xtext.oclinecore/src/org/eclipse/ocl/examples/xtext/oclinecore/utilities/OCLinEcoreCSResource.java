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
 * $Id: OCLinEcoreCSResource.java,v 1.3 2011/01/24 22:28:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot.OCLinEcoreCS2Pivot;

public class OCLinEcoreCSResource extends EssentialOCLCSResource
{
	@Override
	public CS2Pivot createCS2Pivot(
			Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			TypeManager typeManager) {
		return new OCLinEcoreCS2Pivot(cs2pivotResourceMap, typeManager);
	}
}
