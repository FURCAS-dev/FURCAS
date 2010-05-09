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
 * $Id: QualifiedTypeRefScopeAdapter.java,v 1.4 2010/05/09 17:08:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;

public class QualifiedTypeRefScopeAdapter extends AbstractScopeAdapter<QualifiedTypeRefCS>
{
	public QualifiedTypeRefScopeAdapter(QualifiedTypeRefCS csElement) {
		super(csElement);
	}

	@Override
	public boolean computeInheritedEnvironmentView(EnvironmentView environmentView, EStructuralFeature containmentFeature) {
		if (containmentFeature == BaseCSTPackage.Literals.QUALIFIED_TYPE_REF_CS__TYPE) {
			QualifiedTypeRefCS target = getTarget();
			AbstractScopeAdapter<?> scopeAdapter = AbstractScopeAdapter.getScopeAdapter(target.getNamespace());
			if (scopeAdapter != null) {
//				return 
				scopeAdapter.getInclusiveInheritedContents(environmentView);
			}
			else {
				return true;
			}
		}
		return true;
	}
}
