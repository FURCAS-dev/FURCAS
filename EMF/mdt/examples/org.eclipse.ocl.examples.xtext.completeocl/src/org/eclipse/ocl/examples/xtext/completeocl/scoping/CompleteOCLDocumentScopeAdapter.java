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
 * $Id: CompleteOCLDocumentScopeAdapter.java,v 1.8 2011/02/08 17:53:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.StandardDocumentScopeAdapter;

public class CompleteOCLDocumentScopeAdapter extends StandardDocumentScopeAdapter<CompleteOCLDocumentCS, org.eclipse.ocl.examples.pivot.Package>
{
	public CompleteOCLDocumentScopeAdapter(TypeManager typeManager, CompleteOCLDocumentCS csElement) {
		super(typeManager, csElement, org.eclipse.ocl.examples.pivot.Package.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
//		if (environmentView.accepts(PivotPackage.Literals.NAMESPACE)) {
			for (ImportCS anImport : getTarget().getOwnedImport()) {
				if (anImport.getName() == null) {
					Namespace namespace = anImport.getNamespace();
					if (namespace instanceof org.eclipse.ocl.examples.pivot.Package) {
						for (org.eclipse.ocl.examples.pivot.Package rootPackage : ((org.eclipse.ocl.examples.pivot.Package)namespace).getNestedPackages()) {
							environmentView.addNamedElement(rootPackage);		// FIXME Rationmalize root of pivot model
							environmentView.addNamedElements(rootPackage.getNestedPackages());
							environmentView.addNamedElements(rootPackage.getOwnedTypes());
						}
					}
				}
				else {
					environmentView.addElement(anImport.getName(), anImport.getNamespace());
				}
			}
//		}
		return null;
	}
}
