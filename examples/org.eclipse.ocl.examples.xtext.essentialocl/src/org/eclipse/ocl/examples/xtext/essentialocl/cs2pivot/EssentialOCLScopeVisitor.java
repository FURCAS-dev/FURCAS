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
 * $Id: EssentialOCLScopeVisitor.java,v 1.2 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot;

import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BaseScopeVisitor;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.EmptyCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.ContextCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.ExpCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.LetExpCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.NameExpCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.NavigatingExpCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.NavigationOperatorCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.TupleLiteralExpCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.TypeNameExpCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.VariableCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingDelegatingEssentialOCLCSVisitor;

public class EssentialOCLScopeVisitor
	extends AbstractExtendingDelegatingEssentialOCLCSVisitor<ScopeCSAdapter, TypeManager, BaseScopeVisitor>
{
	public EssentialOCLScopeVisitor(TypeManager context) {
		super(new BaseScopeVisitor(context), context);
	}
	
	@Override
	public ScopeCSAdapter visitBinaryOperatorCS(BinaryOperatorCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitCollectionLiteralExpCS(CollectionLiteralExpCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitCollectionLiteralPartCS(CollectionLiteralPartCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitCollectionTypeCS(CollectionTypeCS object) {
		return new EmptyCSScopeAdapter(context, object);
	}

	@Override
	public ScopeCSAdapter visitContextCS(ContextCS object) {
		return new ContextCSScopeAdapter(context, object);
	}

	@Override
	public ScopeCSAdapter visitExpCS(ExpCS eObject) {
		return new ExpCSScopeAdapter<ExpCS, OclExpression>(context, eObject, OclExpression.class);
	}

	@Override
	public ScopeCSAdapter visitInfixExpCS(InfixExpCS object) {
		return new EmptyCSScopeAdapter(context, object);
	}

	@Override
	public LetExpCSScopeAdapter visitLetExpCS(LetExpCS eObject) {
		return new LetExpCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitNameExpCS(NameExpCS eObject) {
		return new NameExpCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitNavigatingArgCS(NavigatingArgCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);		// FIXME iterators
	}

	@Override
	public ScopeCSAdapter visitNavigatingExpCS(NavigatingExpCS eObject) {
		return new NavigatingExpCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitNavigationOperatorCS(NavigationOperatorCS eObject) {
		return new NavigationOperatorCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitSelfExpCS(SelfExpCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTupleLiteralExpCS(TupleLiteralExpCS eObject) {
		return new TupleLiteralExpCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTupleLiteralPartCS(TupleLiteralPartCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTypeNameExpCS(TypeNameExpCS eObject) {
		return new TypeNameExpCSScopeAdapter(context, eObject);
	}
	
	@Override
	public ScopeCSAdapter visitUnaryOperatorCS(UnaryOperatorCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitVariableCS(VariableCS eObject) {
		return new VariableCSScopeAdapter(context, eObject);
	}
}