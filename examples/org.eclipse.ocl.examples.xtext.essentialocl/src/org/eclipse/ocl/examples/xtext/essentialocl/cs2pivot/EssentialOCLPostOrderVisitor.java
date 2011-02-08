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
 * $Id: EssentialOCLPostOrderVisitor.java,v 1.3 2011/02/08 17:44:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasePostOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingDelegatingEssentialOCLCSVisitor;

public class EssentialOCLPostOrderVisitor
	extends AbstractExtendingDelegatingEssentialOCLCSVisitor<Continuation<?>, CS2PivotConversion, BasePostOrderVisitor>
{
	static final Logger logger = Logger.getLogger(EssentialOCLPostOrderVisitor.class);

	protected static class ContextCSCompletion extends SingleContinuation<ContextCS>
	{
		public ContextCSCompletion(CS2PivotConversion context, ContextCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			context.visitLeft2Right(csElement);
			return null;
		}
	}
	
	public EssentialOCLPostOrderVisitor(CS2PivotConversion context) {
		super(new BasePostOrderVisitor(context), context);
	}
	  
	@Override
	public Continuation<?> visitBinaryOperatorCS(BinaryOperatorCS csBinaryOperator) {
		csBinaryOperator.setArgument(null);		// FIXME now done by resetPivot
		return super.visitBinaryOperatorCS(csBinaryOperator);
	}

	@Override
	public Continuation<?> visitCollectionTypeCS(CollectionTypeCS csCollectionType) {
		// FIXME untemplated collections need type deduction here
/*		TypeManager typeManager = context.getTypeManager();
		TypedRefCS csElementType = csCollectionType.getOwnedType();
		Type type;
		if (csElementType != null) {
			Type elementType = PivotUtil.getPivot(Type.class, csElementType);
			type = typeManager.getLibraryType(csCollectionType.getName(), Collections.singletonList(elementType));
		}
		else {
			type = typeManager.getLibraryType(csCollectionType.getName());
		}
		context.reusePivotElement(csCollectionType, type);
*/		return null;
	}

	@Override
	public Continuation<?> visitContextCS(ContextCS csContext) {
		ExpCS ownedExpression = csContext.getOwnedExpression();
		if (ownedExpression != null) {
			return new ContextCSCompletion(context, csContext);
		}
		else {
			return null;
		}
	}

	@Override
	public Continuation<?> visitExpCS(ExpCS csExp) {
		csExp.setParent(null);		// FIXME now done by resetPivot
		return null;
	}

/*	@Override
	public Continuation<?> visitExpConstraintCS(ExpConstraintCS csLibConstraint) {
		Continuation<?> continuation = super.visitExpConstraintCS(csLibConstraint);
		ExpCS ownedExpression = csLibConstraint.getOwnedExpression();
		if (ownedExpression == null) {
			return continuation;
		}
		return Continuations.combine(continuation, new ExpConstraintCSCompletion(context, csLibConstraint));
	} */

	@Override
	public Continuation<?> visitNavigatingExpCS(NavigatingExpCS csNavigatingExp) {
		List<NavigatingArgCS> csArguments = csNavigatingExp.getArgument();
		if (csArguments.size() > 0) {
			// Last argument is always an expression
			//	then preceding initialized terms are accumulators
			//	 then preceding terms are iterators
			NavigationRole role = NavigationRole.EXPRESSION;
			for (int i = csArguments.size()-1; i >= 0; i--) {
				NavigatingArgCS csArgument = csArguments.get(i);
				switch (role) {
					case EXPRESSION: {
						csArgument.setRole(NavigationRole.EXPRESSION);
						if ("|".equals(csArgument.getPrefix())) {
							role = NavigationRole.ACCUMULATOR;
						}
						break;
					}
					case ACCUMULATOR: {
						if (csArgument.getInit() != null) {
							csArgument.setRole(NavigationRole.ACCUMULATOR);
							if (";".equals(csArgument.getPrefix())) {
								role = NavigationRole.ITERATOR;
							}
						}
						else {
							role = NavigationRole.ITERATOR;
							csArgument.setRole(NavigationRole.ITERATOR);
						}
						break;
					}
					case ITERATOR: {
						csArgument.setRole(NavigationRole.ITERATOR);
						break;
					}
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitOperatorCS(OperatorCS csOperator) {
		csOperator.setSource(null);		// FIXME now done by resetPivot
		csOperator.setParent(null);		// FIXME now done by resetPivot
		return null;
	}

	@Override
	public Continuation<?> visitVariableCS(VariableCS csVariable) {
		return null;
	}	
}