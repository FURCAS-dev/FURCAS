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
 * $Id: NameExpCSScopeAdapter.java,v 1.3 2011/02/08 17:44:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;

public class NameExpCSScopeAdapter extends ExpCSScopeAdapter<NameExpCS, OclExpression>
{
	private static final class NoOperations implements EnvironmentView.Filter
	{
		public int compareMatches(EObject match1, Map<TemplateParameter, ParameterableElement> bindings1, EObject match2, Map<TemplateParameter, ParameterableElement> bindings2) {
			return 0;
		}

		public boolean matches(EnvironmentView environmentView, EObject eObject) {
			return !(eObject instanceof Operation);
		}
	}

/*	private static final class OperationsOnly implements EnvironmentView.Filter
	{
		public int compareMatches(EObject reference, EObject candidate) {
			return PivotUtil.compareOperationMatches(reference, candidate);
		}

		public boolean matches(EnvironmentView environmentView, EObject eObject) {
			return eObject instanceof Operation;
		}
	} */

	private static EnvironmentView.Filter noOperationsFilter = new NoOperations();
//	private static EnvironmentView.Filter operationsOnlyFilter = new OperationsOnly();
	
	public NameExpCSScopeAdapter(TypeManager typeManager, NameExpCS csElement) {
		super(typeManager, csElement, OclExpression.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSTPackage.Literals.NAME_EXP_CS__ELEMENT) {
			List<Namespace> namespaces = target.getNamespace();
			int namespaceCount = namespaces.size();
			if (namespaceCount > 0) {
				ScopeAdapter scopeAdapter = getScopeAdapter(typeManager, namespaces.get(namespaceCount-1));
				if (scopeAdapter != null) {
					return scopeAdapter.computeLookup(environmentView, scopeView);
				}				
				return null;
			}
			EObject eContainer = target.eContainer();
			if (eContainer instanceof NavigatingExpCS) {
//				environmentView.addFilter(operationsOnlyFilter);
			}
			else {	// FIXME IndexedExpCS fpor Associations
				environmentView.addFilter(noOperationsFilter);
			}
		}
		return scopeView.getOuterScope();
	}
}
