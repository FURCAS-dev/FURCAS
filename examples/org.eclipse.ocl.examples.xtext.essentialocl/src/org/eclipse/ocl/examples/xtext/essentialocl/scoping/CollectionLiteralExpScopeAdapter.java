/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: CollectionLiteralExpScopeAdapter.java,v 1.2 2010/05/09 10:32:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;

public class CollectionLiteralExpScopeAdapter extends EssentialOCLScopeAdapter<CollectionLiteralExpCS>
{
	private TypeCS type = null;
	
	public CollectionLiteralExpScopeAdapter(CollectionLiteralExpCS csElement) {
		super(csElement);
	}
	
	@Override
	public TypeCS getType() {
		if (type == null) {
			CollectionTypeCS typeCS = getTarget().getTypeCS();
			String text = typeCS.getName();
			type = getLibType(text);
		}
		return type;
	}
}
