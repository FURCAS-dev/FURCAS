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
 * $Id: CompleteOCLPostOrderVisitor.java,v 1.9 2011/05/20 19:51:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasePostOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ContextConstraintCSImpl;
import org.eclipse.ocl.examples.xtext.completeocl.util.AbstractExtendingDelegatingCompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.completeocl.utilities.CompleteOCLCS2MonikerVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPostOrderVisitor;

public class CompleteOCLPostOrderVisitor
	extends AbstractExtendingDelegatingCompleteOCLCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPostOrderVisitor>
{
	public static final CS2PivotConversion.CacheKey<Map<NamedElement, List<ContextConstraintCS>>> rulesKey = new CS2PivotConversion.CacheKey<Map<NamedElement, List<ContextConstraintCS>>>("rules");
	
/*	public static class ContextConstraintCSCompletion extends SingleContinuation<ContextConstraintCS>
	{
		public ContextConstraintCSCompletion(CS2PivotConversion context, ContextConstraintCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			context.visitLeft2Right(Constraint.class, csElement);
			return null;
		}
	} */
	
	protected static class DefCSCompletion extends SingleContinuation<DefCS>
	{
		public DefCSCompletion(CS2PivotConversion context, DefCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			if (csElement.isOperation()) {
				context.visitLeft2Right(Operation.class, csElement);
			}
			else {
				context.visitLeft2Right(Property.class, csElement);
			}
			return null;
		}
	}
	
	protected static class DocumentCSCompletion extends SingleContinuation<CompleteOCLDocumentCS>
	{
		public DocumentCSCompletion(CS2PivotConversion context, CompleteOCLDocumentCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Map<NamedElement, List<ContextConstraintCS>> intermediate = context.getIntermediate(rulesKey);
			if (intermediate != null) {
				for (NamedElement pivot : intermediate.keySet()) {
					List<ContextConstraintCS> constraints = intermediate.get(pivot);
					context.refreshList(Constraint.class, pivot.getOwnedRules(), constraints);
				}
			}
			return null;
		}
	}
	
	public CompleteOCLPostOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPostOrderVisitor(context), context);
	}

	@Override
	public Continuation<?> visitCompleteOCLDocumentCS(CompleteOCLDocumentCS csDocument) {
		return new DocumentCSCompletion(context, csDocument);
	}

	@Override
	public Continuation<?> visitContextDeclCS(ContextDeclCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitContextConstraintCS(ContextConstraintCS csNewConstraint) {
		NamedElement constrainedPivot = PivotUtil.getPivot(NamedElement.class, csNewConstraint.getContextDecl());
		if ((constrainedPivot == null) || constrainedPivot.eIsProxy()) {
			return null;
		}
		String newStereotype = csNewConstraint.getStereotype();
		String stereotype = CompleteOCLCS2MonikerVisitor.getStereotype(newStereotype);
		String newName = csNewConstraint.getName();
		int index = 0;
		List<ContextConstraintCS> csConstraints = null;
		Map<NamedElement, List<ContextConstraintCS>> intermediate = context.getIntermediate(rulesKey);
		if (intermediate != null) {
			csConstraints = intermediate.get(constrainedPivot);
			if (csConstraints != null) {
				for (ContextConstraintCS csOldConstraint : csConstraints) {
					if (csOldConstraint == csNewConstraint) {
						break;
					}
					String oldStereotype = csOldConstraint.getStereotype();
					if ((oldStereotype != null) && oldStereotype.equals(newStereotype)) {
						String oldName = csOldConstraint.getName();
						if (newName != oldName) {
							if ((newName == null) || !newName.equals(oldName)) {
								break;
							}
						}
						index++;
					}
				}
			}
			else {
				csConstraints = new ArrayList<ContextConstraintCS>();
				intermediate.put(constrainedPivot, csConstraints);
			}
		}
		else {
			intermediate = new HashMap<NamedElement, List<ContextConstraintCS>>();
			context.putIntermediate(rulesKey, intermediate);
			csConstraints = new ArrayList<ContextConstraintCS>();
			intermediate.put(constrainedPivot, csConstraints);
		}
		csConstraints.add(csNewConstraint);
		StringBuffer s = new StringBuffer();
		s.append(constrainedPivot.getMoniker());
		s.append(PivotConstants.MONIKER_SCOPE_SEPARATOR);
		s.append(stereotype);
		s.append(PivotConstants.MONIKER_OPERATOR_SEPARATOR);
		if (newName != null) {
			s.append(newName);
		}
		if (index != 0) {
			s.append(PivotConstants.MONIKER_OPERATOR_SEPARATOR);
			s.append(index);
		}
		String moniker = s.toString();
		((ContextConstraintCSImpl)csNewConstraint).setMoniker(moniker);
		Constraint pivotElement = context.refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, csNewConstraint);
//		context.installPivotElement(csNewConstraint, pivotElement);
//		context.refreshName(pivotElement, csNewConstraint.getName());
//		context.refreshComments(pivotElement, csNewConstraint);
		pivotElement.setStereotype(stereotype);
		if (csNewConstraint.getSpecification() != null) {
			return new BasePostOrderVisitor.ConstraintCSCompletion(context, csNewConstraint);
		}
		else {
			return null;
		}
	}

	@Override
	public Continuation<?> visitDefCS(DefCS csDef) {
		if (csDef.getSpecification() != null) {
			return new DefCSCompletion(context, csDef);
		}
		else {
			return null;
		}
	}

	@Override
	public Continuation<?> visitIncludeCS(IncludeCS object) {
		return null;
	}
}