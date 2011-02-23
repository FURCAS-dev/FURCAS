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
 * $Id: AbstractDelegatingEssentialOCLCSVisitor.java,v 1.5 2011/02/15 10:37:29 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.essentialocl.util;

/**
 * An AbstractDelegatingEssentialOCLCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingEssentialOCLCSVisitor<R, C, D extends EssentialOCLCSVisitor<R, C>>
	extends org.eclipse.ocl.examples.xtext.base.util.AbstractDelegatingBaseCSVisitor<R, C, D>
	implements EssentialOCLCSVisitor<R, C>
{
    protected AbstractDelegatingEssentialOCLCSVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitBinaryOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS object) {
		return delegate.visitBinaryOperatorCS(object);
	}

	public R visitBooleanLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS object) {
		return delegate.visitBooleanLiteralExpCS(object);
	}

	public R visitCollectionLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS object) {
		return delegate.visitCollectionLiteralExpCS(object);
	}

	public R visitCollectionLiteralPartCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS object) {
		return delegate.visitCollectionLiteralPartCS(object);
	}

	public R visitCollectionTypeCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS object) {
		return delegate.visitCollectionTypeCS(object);
	}

	public R visitContextCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS object) {
		return delegate.visitContextCS(object);
	}

	public R visitDecoratedNamedExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS object) {
		return delegate.visitDecoratedNamedExpCS(object);
	}

	public R visitExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS object) {
		return delegate.visitExpCS(object);
	}

	public R visitExpConstraintCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS object) {
		return delegate.visitExpConstraintCS(object);
	}

	public R visitIfExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS object) {
		return delegate.visitIfExpCS(object);
	}

	public R visitIndexExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS object) {
		return delegate.visitIndexExpCS(object);
	}

	public R visitInfixExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS object) {
		return delegate.visitInfixExpCS(object);
	}

	public R visitInvalidLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS object) {
		return delegate.visitInvalidLiteralExpCS(object);
	}

	public R visitLetExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS object) {
		return delegate.visitLetExpCS(object);
	}

	public R visitLetVariableCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS object) {
		return delegate.visitLetVariableCS(object);
	}

	public R visitLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS object) {
		return delegate.visitLiteralExpCS(object);
	}

	public R visitNameExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS object) {
		return delegate.visitNameExpCS(object);
	}

	public R visitNavigatingArgCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS object) {
		return delegate.visitNavigatingArgCS(object);
	}

	public R visitNavigatingExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS object) {
		return delegate.visitNavigatingExpCS(object);
	}

	public R visitNavigationOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS object) {
		return delegate.visitNavigationOperatorCS(object);
	}

	public R visitNestedExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS object) {
		return delegate.visitNestedExpCS(object);
	}

	public R visitNullLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS object) {
		return delegate.visitNullLiteralExpCS(object);
	}

	public R visitNumberLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS object) {
		return delegate.visitNumberLiteralExpCS(object);
	}

	public R visitOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS object) {
		return delegate.visitOperatorCS(object);
	}

	public R visitPrefixExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS object) {
		return delegate.visitPrefixExpCS(object);
	}

	public R visitPrimitiveLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS object) {
		return delegate.visitPrimitiveLiteralExpCS(object);
	}

	public R visitSelfExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS object) {
		return delegate.visitSelfExpCS(object);
	}

	public R visitStringLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS object) {
		return delegate.visitStringLiteralExpCS(object);
	}

	public R visitTupleLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS object) {
		return delegate.visitTupleLiteralExpCS(object);
	}

	public R visitTupleLiteralPartCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS object) {
		return delegate.visitTupleLiteralPartCS(object);
	}

	public R visitTypeLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS object) {
		return delegate.visitTypeLiteralExpCS(object);
	}

	public R visitTypeNameExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS object) {
		return delegate.visitTypeNameExpCS(object);
	}

	public R visitUnaryOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS object) {
		return delegate.visitUnaryOperatorCS(object);
	}

	public R visitUnlimitedNaturalLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS object) {
		return delegate.visitUnlimitedNaturalLiteralExpCS(object);
	}

	public R visitVariableCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS object) {
		return delegate.visitVariableCS(object);
	}
}
