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
 * $Id: EssentialOCLCSVisitor.java,v 1.4 2011/02/11 20:59:22 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.essentialocl.util;

/**
 */
public interface EssentialOCLCSVisitor<R, C> extends org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor<R, C>
{
	R visitBinaryOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS object);
	R visitBooleanLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS object);
	R visitCollectionLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS object);
	R visitCollectionLiteralPartCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS object);
	R visitCollectionTypeCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS object);
	R visitContextCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS object);
	R visitDecoratedNamedExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS object);
	R visitExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS object);
	R visitExpConstraintCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS object);
	R visitIfExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS object);
	R visitIndexExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS object);
	R visitInfixExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS object);
	R visitInvalidLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS object);
	R visitLetExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS object);
	R visitLetVariableCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS object);
	R visitLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS object);
	R visitNameExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS object);
	R visitNavigatingArgCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS object);
	R visitNavigatingExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS object);
	R visitNavigationOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS object);
	R visitNestedExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS object);
	R visitNullLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS object);
	R visitNumberLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS object);
	R visitOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS object);
	R visitPrefixExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS object);
	R visitPrimitiveLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS object);
	R visitSelfExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS object);
	R visitStringLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS object);
	R visitTupleLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS object);
	R visitTupleLiteralPartCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS object);
	R visitTypeLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS object);
	R visitTypeNameExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS object);
	R visitUnaryOperatorCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS object);
	R visitUnlimitedNaturalLiteralExpCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS object);
	R visitVariableCS(org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS object);
}
