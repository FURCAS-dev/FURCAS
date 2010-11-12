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
 * $Id: CollectionLiteralExpScopeAdapter.java,v 1.4 2010/05/21 20:12:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

public class CollectionLiteralExpScopeAdapter extends ExpScopeAdapter<CollectionLiteralExpCS>
{
	private ClassifierCS type = null;
	
	public CollectionLiteralExpScopeAdapter(CollectionLiteralExpCS csElement) {
		super(csElement);
	}
	
	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		if (type == null) {
			CollectionLiteralExpCS target = getTarget();
			CollectionTypeCS collectionTypeCS = target.getTypeCS();
			ClassifierCS elementTypeCS = null;
			for (CollectionLiteralPartCS partCS : target.getCollectionLiteralParts()) {
				ExpCS expressionCS = partCS.getExpressionCS();
				ScopeAdapter expressionScopeAdapter = getScopeAdapter(expressionCS);
				ClassifierCS partElementTypeCS = expressionScopeAdapter.getSynthesizedType(bindings);
				if (elementTypeCS == null) {
					elementTypeCS = partElementTypeCS;
				}
				else {
					elementTypeCS = commonConformantType(elementTypeCS, partElementTypeCS);
				}
			}
			type = getLibraryAdapter().getLibraryType(collectionTypeCS.getName(), elementTypeCS);
		}
		return type;
	}
}
