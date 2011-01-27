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
 * $Id: NavigatingExpCSScopeAdapter.java,v 1.3 2011/01/27 07:01:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.BaseScopeView;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
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
		if ((fromArgument instanceof NavigatingArgCS) && (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.EXPRESSION)) {
			CallExp pivot = getPivot();
			if (pivot instanceof LoopExp) {
				for (Variable iterator : ((LoopExp)pivot).getIterators()) {
					if ((environmentView.addNamedElement(iterator) > 0) && (environmentView.getName() != null)) {
						return null;
					}
					environmentView.addElementsOfScope(typeManager, iterator.getType(), scopeView);
					if ((environmentView.getSize() > 0) && (environmentView.getName() != null)) {
						return null;
					}
				}
			}
			if (pivot instanceof IterateExp) {
				Variable result = ((IterateExp)pivot).getResult();
				if ((environmentView.addNamedElement(result) > 0)  && (environmentView.getName() != null)) {
					return null;
				}
				environmentView.addElementsOfScope(typeManager, result.getType(), scopeView);
				if ((environmentView.getSize() > 0)  && (environmentView.getName() != null)) {
					return null;
				}
			}
		}
		else {
			// Note that we only need to find the feature, which can be identified
			// from the enclosing type. The correct source object is resolved later.
			for (NavigatingArgCS csArgument : target.getArgument()) {
				if (csArgument.getRole() == NavigationRole.EXPRESSION) {
					break;
				}
				Element pivot = csArgument.getPivot();
				if (pivot instanceof Variable) {
					if (environmentView.addNamedElement((Variable) pivot) > 0) {
						return null;
					}
					Type type = ((Variable)pivot).getType();
					environmentView.addElementsOfScope(typeManager, type, scopeView);
					if ((environmentView.getSize() > 0) && (environmentView.getName() != null)) {
						return null;
					}
					if (type instanceof CollectionType) {		// FIXME use navigation operator dependent semantics
						environmentView.addElementsOfScope(typeManager, ((CollectionType)type).getElementType(), scopeView);
						if ((environmentView.getSize() > 0) && (environmentView.getName() != null)) {
							return null;
						}
					}
				}
				if (csArgument == fromArgument) {
					break;
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
					OclExpression source = (OclExpression)csSource.getPivot();
					Type sourceType = source != null ? source.getType() : null;
					if (PivotConstants.COLLECTION_NAVIGATION_OPERATOR.equals(csOperator.getName()) && !(sourceType instanceof CollectionType)) {
						Type setType = typeManager.getSetType();				// Implicit set
						environmentView.addElementsOfScope(typeManager, setType, scopeView);
					}
					else {														// Normal dot navigation
						return new BaseScopeView(scopeAdapter, target, PivotPackage.Literals.OPERATION_CALL_EXP__ARGUMENT, null);
					}
				}
			}
		}
		return getOuterScopeView(null);
	}
}
