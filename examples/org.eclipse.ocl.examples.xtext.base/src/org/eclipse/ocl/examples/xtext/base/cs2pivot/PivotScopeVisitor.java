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
 * $Id: PivotScopeVisitor.java,v 1.6 2011/04/20 19:02:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.ClassScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.EmptyScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.EnumerationScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.ExpressionInOclScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.IterateExpScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.IteratorExpScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.LetExpScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.OperationCallExpScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.OperationScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.PackageScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.RootPackageScopeAdapter;

public class PivotScopeVisitor extends AbstractExtendingVisitor<ScopeAdapter, TypeManager> implements PivotConstants
{	
	public PivotScopeVisitor(TypeManager context) {
		super(context);
		assert context != null;
	}
	
	@Override
	public ScopeAdapter visitClass(org.eclipse.ocl.examples.pivot.Class pivotElement) {
		return new ClassScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitConstraint(Constraint pivotElement) {
		return new EmptyScopeAdapter(context, pivotElement);
	}
	
	@Override
	public ScopeAdapter visitDataType(DataType pivotElement) {
		Type behavioralType = pivotElement.getBehavioralType();
		if (behavioralType != null) {
			return AbstractScopeAdapter.getScopeAdapter(context, behavioralType);
		}
		else {
			return super.visitDataType(pivotElement);
		}
	}

	@Override
	public ScopeAdapter visitEnumeration(org.eclipse.ocl.examples.pivot.Enumeration pivotElement) {
		return new EnumerationScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitExpressionInOcl(ExpressionInOcl pivotElement) {
		return new ExpressionInOclScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitIfExp(IfExp pivotElement) {
		return new EmptyScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitInvalidLiteralExp(InvalidLiteralExp pivotElement) {
		return new EmptyScopeAdapter(context, pivotElement);		// FIXME
	}

	@Override
	public ScopeAdapter visitIterateExp(IterateExp pivotElement) {
		return new IterateExpScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitIteratorExp(IteratorExp pivotElement) {
		return new IteratorExpScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitLetExp(LetExp pivotElement) {
		return new LetExpScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitOperation(Operation pivotElement) {
		return new OperationScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitOperationCallExp(OperationCallExp pivotElement) {
		return new OperationCallExpScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitPackage(org.eclipse.ocl.examples.pivot.Package pivotElement) {
		if (pivotElement.eContainer() == null) {
			return new RootPackageScopeAdapter(context, pivotElement);
		}
		else {
			return new PackageScopeAdapter(context, pivotElement);
		}
	}

	@Override
	public ScopeAdapter visitProperty(Property pivotElement) {
		return new EmptyScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitPropertyCallExp(PropertyCallExp pivotElement) {
		return new EmptyScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitTemplateSignature(TemplateSignature pivotElement) {
		return new EmptyScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitTypeTemplateParameter(TypeTemplateParameter pivotElement) {
		return new EmptyScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitUnspecifiedType(UnspecifiedType pivotElement) {
		return AbstractScopeAdapter.getScopeAdapter(context, pivotElement.getLowerBound());
	}

	@Override
	public ScopeAdapter visitVariable(Variable pivotElement) {
		return new EmptyScopeAdapter(context, pivotElement);
	}

	@Override
	public ScopeAdapter visitVariableExp(VariableExp pivotElement) {
		return new EmptyScopeAdapter(context, pivotElement);
	}

	public ScopeAdapter visiting(Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for PivotScopeVisitor");
	}	
}
