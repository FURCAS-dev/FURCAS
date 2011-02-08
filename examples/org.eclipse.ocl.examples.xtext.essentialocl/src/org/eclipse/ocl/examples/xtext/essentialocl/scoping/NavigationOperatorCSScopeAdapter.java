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
 * $Id: NavigationOperatorCSScopeAdapter.java,v 1.3 2011/02/08 17:44:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;

public class NavigationOperatorCSScopeAdapter extends ExpCSScopeAdapter<NavigationOperatorCS, CallExp>
{
	public NavigationOperatorCSScopeAdapter(TypeManager typeManager, NavigationOperatorCS eObject) {
		super(typeManager, eObject, CallExp.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EObject child = scopeView.getChild();
		if (child == target.getArgument()) {
			OclExpression csSource = PivotUtil.getPivot(OclExpression.class, target.getSource());
			if (csSource instanceof TypeExp) {
				environmentView.addElementsOfScope(typeManager, ((TypeExp)csSource).getReferredType(), scopeView);
			}
			else {
				Type type = csSource.getType();
				EnvironmentView.Filter filter = null;
				try {
					if (target.getArgument() instanceof NavigatingExpCS) {
						filter = new OperationFilter(typeManager, (NavigatingExpCS)target.getArgument());
						environmentView.addFilter(filter);
					}
					if (target.getName().equals(PivotConstants.COLLECTION_NAVIGATION_OPERATOR)) {
						if (type instanceof CollectionType) {		// collection->collection-operation
							environmentView.addElementsOfScope(typeManager, type, scopeView);
						}
						else {										// object.oclAsSet()->collection-operation
							Type setType = typeManager.getSetType(type);
							environmentView.addElementsOfScope(typeManager, setType, scopeView);
						}
					}
					else {
						environmentView.addElementsOfScope(typeManager, type, scopeView);					
						if (type instanceof CollectionType) {
							environmentView.addElementsOfScope(typeManager, ((CollectionType)type).getElementType(), scopeView);
						}
					}
				}
				finally {
					if (filter != null) {
						environmentView.removeFilter(filter);
					}
				}
			}
//			return typeScopeAdapter.compute Lookup(environmentView, typeScopeAdapter.getInnerScopeView(null));
//			return getScopeCSAdapter(parent).getOuterScopeView(null);
			return scopeView.getOuterScope();
		}
		else {
			ExpCS parent = target.getParent();
			return getScopeAdapter(parent != null ? parent : (ModelElementCS)target.eContainer()).getOuterScopeView(null);
		}
	}
}
