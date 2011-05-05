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
 * $Id: NavigatingExpCSScopeAdapter.java,v 1.10 2011/05/02 09:31:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.BaseScopeView;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;

public class NavigatingExpCSScopeAdapter extends ExpCSScopeAdapter<NavigatingExpCS, CallExp>
{
	public NavigatingExpCSScopeAdapter(TypeManager typeManager, NavigatingExpCS eObject) {
		super(typeManager, eObject, CallExp.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EObject fromArgument = scopeView.getChild();
		if (fromArgument instanceof NavigatingArgCS) {
			if (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.EXPRESSION) {
				CallExp pivot = getPivot();
				if (pivot instanceof LoopExp) {				// FIXME This is null for nested iteration
					for (Variable iterator : ((LoopExp)pivot).getIterators()) {
						environmentView.addNamedElement(iterator);
						if (environmentView.hasFinalResult()) {
							return null;
						}
						environmentView.addElementsOfScope(iterator.getType(), scopeView);
						if (environmentView.hasFinalResult()) {
							return null;
						}
					}
					if (pivot instanceof IterateExp) {
						Variable result = ((IterateExp)pivot).getResult();
						environmentView.addNamedElement(result);
						if (environmentView.hasFinalResult()) {
							return null;
						}
						environmentView.addElementsOfScope(result.getType(), scopeView);
						if (environmentView.hasFinalResult()) {
							return null;
						}
					}
				}
				else if (pivot == null) {
					OperatorCS csParent = target.getParent();
					if (csParent instanceof NavigationOperatorCS) {
						NavigationOperatorCS csNavigationOperator = (NavigationOperatorCS)csParent;
						ExpCS csSource = csNavigationOperator.getSource();
						OclExpression source = PivotUtil.getPivot(OclExpression.class, csSource);
						if (source != null) {
							Type type = source.getType();
							if (csNavigationOperator.getName().equals(PivotConstants.COLLECTION_NAVIGATION_OPERATOR)) {
								if (type instanceof CollectionType) {		// collection->collection-operation(name...
									environmentView.addElementsOfScope(((CollectionType)type).getElementType(), scopeView);
								}
							}
						}
					}
				}
			}
			else if (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.ITERATOR) {			// Happens during save
				CallExp pivot = getPivot();
				if (pivot instanceof LoopExp) {
					environmentView.addNamedElements(((LoopExp)pivot).getIterators());
				}
			}
			else if (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.ACCUMULATOR) {
				CallExp pivot = getPivot();
				if (pivot instanceof IterateExp) {
					environmentView.addNamedElement(((IterateExp)pivot).getResult());
				}
			}
			EnvironmentView.Filter filter = ContextCSScopeAdapter.NoImplicitProperties.INSTANCE;
			try {
				environmentView.addFilter(filter);
				BaseScopeView baseScopeView = new BaseScopeView(typeManager, getParent(), target, PivotPackage.Literals.OPERATION_CALL_EXP__ARGUMENT, null);
				environmentView.computeLookups(baseScopeView);
				return null;
			}
			finally {
				environmentView.removeFilter(filter);
			}
		}
		else {
			ExpCS explicitSource = null;
			ScopeAdapter scopeAdapter = null;	// Note that parent is null during PreOrder namespace resolution
			if (target.eContainer() instanceof InfixExpCS) {
				OperatorCS csOperator = target.getParent();
				if (csOperator != null) {
					ExpCS csSource = csOperator.getSource();
					if (csSource != target) {
						scopeAdapter = getScopeCSAdapter(csOperator);
						explicitSource = csSource;
					}
				}
			}
			if (scopeAdapter == null) {
				scopeAdapter = getParent();
			}
			Type type = null;
			if (explicitSource != null) {
				OclExpression source = PivotUtil.getPivot(OclExpression.class, explicitSource);
				if (source != null) {
					type = source.getType();
				}
			}
			EnvironmentView.Filter filter = new OperationFilter(typeManager, type, target);
			try {
				environmentView.addFilter(filter);
				BaseScopeView baseScopeView = new BaseScopeView(typeManager, scopeAdapter, target, PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, null);
				environmentView.computeLookups(baseScopeView);
				return null;
			}
			finally {
				environmentView.removeFilter(filter);
			}
		}
	}
}
