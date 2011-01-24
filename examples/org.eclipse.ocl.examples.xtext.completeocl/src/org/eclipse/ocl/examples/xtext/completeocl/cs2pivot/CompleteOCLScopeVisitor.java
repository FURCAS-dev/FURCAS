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
 * $Id: CompleteOCLScopeVisitor.java,v 1.2 2011/01/24 21:08:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.EmptyCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.scoping.ClassifierContextScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.scoping.CompleteOCLDocumentScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.scoping.DefScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.scoping.OperationContextScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.scoping.PackageDeclarationScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.scoping.PostScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.scoping.PropertyContextScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.util.AbstractExtendingDelegatingCompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLScopeVisitor;

public class CompleteOCLScopeVisitor
	extends AbstractExtendingDelegatingCompleteOCLCSVisitor<ScopeCSAdapter, TypeManager, EssentialOCLScopeVisitor>
{
	public CompleteOCLScopeVisitor(TypeManager context) {
		super(new EssentialOCLScopeVisitor(context), context);
	}

	@Override
	public ScopeCSAdapter visitBodyCS(BodyCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitClassifierContextDeclCS(ClassifierContextDeclCS eObject) {
		return new ClassifierContextScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitCompleteOCLDocumentCS(CompleteOCLDocumentCS eObject) {
		return new CompleteOCLDocumentScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitDefCS(DefCS eObject) {
		return new DefScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitDerCS(DerCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitInitCS(InitCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitInvCS(InvCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitOperationContextDeclCS(OperationContextDeclCS eObject) {
		return new OperationContextScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitPackageDeclarationCS(PackageDeclarationCS eObject) {
		return new PackageDeclarationScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitPostCS(PostCS eObject) {
		return new PostScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitPreCS(PreCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

//	@Override
//	public ScopeCSAdapter visitPreExpCS(PreExpCS eObject) {
//		return new PreExpCSScopeAdapter(context, eObject);
//	}

	@Override
	public ScopeCSAdapter visitPropertyContextDeclCS(PropertyContextDeclCS eObject) {
		return new PropertyContextScopeAdapter(context, eObject);
	}
}