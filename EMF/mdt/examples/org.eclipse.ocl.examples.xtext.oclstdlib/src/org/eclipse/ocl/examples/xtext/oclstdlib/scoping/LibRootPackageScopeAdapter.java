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
 * $Id: LibRootPackageScopeAdapter.java,v 1.1 2011/02/15 10:37:09 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.RootPackageCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.MetaTypeName;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTFactory;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;

public class LibRootPackageScopeAdapter extends RootPackageCSScopeAdapter
{
	private static List<MetaTypeName> metaTypeNames = null;
	
	public LibRootPackageScopeAdapter(TypeManager typeManager, RootPackageCS csElement) {
		super(typeManager, csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		ScopeView outerScope = super.computeLookup(environmentView, scopeView);
		if (!environmentView.hasFinalResult()) {
			if (environmentView.getReference() == OCLstdlibCSTPackage.Literals.LIB_CLASS_CS__META_TYPE_NAME) {
				if (metaTypeNames == null) {
					metaTypeNames = new ArrayList<MetaTypeName>();
					for (EClassifier eClassifier : PivotPackage.eINSTANCE.getEClassifiers()) {
						if (eClassifier instanceof EClass) {
							if (PivotPackage.Literals.CLASS.isSuperTypeOf((EClass) eClassifier)) {
								MetaTypeName metaTypeName = OCLstdlibCSTFactory.eINSTANCE.createMetaTypeName();
								metaTypeName.setName(eClassifier.getName());
								metaTypeNames.add(metaTypeName);
							}
						}
					}
				}
				environmentView.addElements(metaTypeNames);
			}
		}
		return outerScope;
	}
}
