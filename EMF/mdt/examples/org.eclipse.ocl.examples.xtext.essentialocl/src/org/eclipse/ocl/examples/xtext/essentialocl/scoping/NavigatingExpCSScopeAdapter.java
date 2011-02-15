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
 * $Id: NavigatingExpCSScopeAdapter.java,v 1.6 2011/02/15 10:37:29 ewillink Exp $
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
						environmentView.addElementsOfScope(typeManager, iterator.getType(), scopeView);
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
						environmentView.addElementsOfScope(typeManager, result.getType(), scopeView);
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
						Type type = source.getType();
						if (csNavigationOperator.getName().equals(PivotConstants.COLLECTION_NAVIGATION_OPERATOR)) {
							if (type instanceof CollectionType) {		// collection->collection-operation(name...
								environmentView.addElementsOfScope(typeManager, ((CollectionType)type).getElementType(), scopeView);
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
		}
//		EObject csParent = getParent().getTarget();
		EObject csParent = target.eContainer();
		if (csParent instanceof InfixExpCS) {
			OperatorCS csOperator = target.getParent();
			if (csOperator != null) {
				ScopeAdapter scopeAdapter = getScopeAdapter(csOperator);
				ExpCS csSource = csOperator.getSource();
				if (target == csSource) {									// Implicit source
					return new BaseScopeView(scopeAdapter, target, PivotPackage.Literals.CALL_EXP__SOURCE, null);
				} else {
					return new BaseScopeView(scopeAdapter, target, PivotPackage.Literals.OPERATION_CALL_EXP__ARGUMENT, null);
				}
			}
		}
		return getOuterScopeView(null);
	}
}
