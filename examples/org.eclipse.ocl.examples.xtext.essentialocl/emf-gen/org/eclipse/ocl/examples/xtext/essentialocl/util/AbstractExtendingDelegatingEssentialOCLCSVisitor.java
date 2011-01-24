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
 * This code is auto-generated
 * from: /org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: AbstractExtendingDelegatingEssentialOCLCSVisitor.java,v 1.2 2011/01/24 21:31:48 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.essentialocl.util;

import org.eclipse.ocl.examples.xtext.base.util.AbstractDelegatingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

/**
 * An AbstractExtendingDelegatingEssentialOCLCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingEssentialOCLCSVisitor<R, C, D extends BaseCSVisitor<R, C>>
	extends AbstractDelegatingBaseCSVisitor<R, C, D>
	implements EssentialOCLCSVisitor<R, C>
{
    protected AbstractExtendingDelegatingEssentialOCLCSVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitBinaryOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS object) {
		return visitOperatorCS(object);
	}

	public R visitBooleanLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public R visitCollectionLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public R visitCollectionLiteralPartCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS object) {
		return delegate.visitMonikeredElementCS(object);
	}

	public R visitCollectionTypeCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitContextCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitDecoratedNamedExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS object) {
		return visitExpCS(object);
	}

	public R visitExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS object) {
		return delegate.visitMonikeredElementCS(object);
	}

	public R visitExpConstraintCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS object) {
		return delegate.visitConstraintCS(object);
	}

	public R visitIfExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS object) {
		return visitExpCS(object);
	}

	public R visitIndexExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS object) {
		return visitDecoratedNamedExpCS(object);
	}

	public R visitInfixExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS object) {
		return visitExpCS(object);
	}

	public R visitInvalidLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public R visitLetExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS object) {
		return visitExpCS(object);
	}

	public R visitLetVariableCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS object) {
		return visitVariableCS(object);
	}

	public R visitLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS object) {
		return visitExpCS(object);
	}

	public R visitNameExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS object) {
		return visitExpCS(object);
	}

	public R visitNavigatingArgCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitNavigatingExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS object) {
		return visitDecoratedNamedExpCS(object);
	}

	public R visitNavigationOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS object) {
		return visitBinaryOperatorCS(object);
	}

	public R visitNestedExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS object) {
		return visitExpCS(object);
	}

	public R visitNullLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public R visitNumberLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public R visitOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitPrefixExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS object) {
		return visitExpCS(object);
	}

	public R visitPrimitiveLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public R visitSelfExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS object) {
		return visitExpCS(object);
	}

	public R visitStringLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public R visitTupleLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public R visitTupleLiteralPartCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS object) {
		return visitVariableCS(object);
	}

	public R visitTypeLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public R visitTypeNameExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS object) {
		return delegate.visitTypedRefCS(object);
	}

	public R visitUnaryOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS object) {
		return visitOperatorCS(object);
	}

	public R visitUnlimitedNaturalLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public R visitVariableCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS object) {
		return delegate.visitNamedElementCS(object);
	}
}
