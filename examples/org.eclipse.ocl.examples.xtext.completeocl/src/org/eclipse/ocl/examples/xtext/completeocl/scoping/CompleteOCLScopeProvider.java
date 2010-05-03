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
 * $Id: CompleteOCLScopeProvider.java,v 1.2 2010/05/03 05:58:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.DefaultScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.EmptyScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
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
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.util.CompleteOCLCSTSwitch;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class CompleteOCLScopeProvider extends EssentialOCLScopeProvider
{
	static {
		EssentialOCLScopeAdapter.addSwitch(CompleteOCLCSTPackage.eINSTANCE, new CompleteOCLScopeSwitch());
	}
	
	public static class CompleteOCLScopeSwitch 
	extends CompleteOCLCSTSwitch<AbstractScopeAdapter<? extends EObject>>
	implements AbstractScopeAdapter.ISwitch
	{
		@Override
		public AbstractScopeAdapter<? extends EObject> caseBodyCS(BodyCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public EssentialOCLScopeAdapter<? extends EObject> caseClassifierContextDeclCS(ClassifierContextDeclCS eObject) {
			return new ClassifierContextScopeAdapter(eObject);
		}
	
		@Override
		public AbstractScopeAdapter<? extends EObject> caseCompleteOCLDocumentCS(CompleteOCLDocumentCS eObject) {
			return new CompleteOCLDocumentScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseDefCS(DefCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseDerCS(DerCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseInitCS(InitCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseInvCS(InvCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public EssentialOCLScopeAdapter<? extends EObject> caseOperationContextDeclCS(OperationContextDeclCS eObject) {
			return new OperationContextScopeAdapter(eObject);
		}

		@Override
		public EssentialOCLScopeAdapter<? extends EObject> casePackageDeclarationCS(PackageDeclarationCS eObject) {
			return new PackageDeclarationScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> casePostCS(PostCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> casePreCS(PreCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public EssentialOCLScopeAdapter<? extends EObject> casePropertyContextDeclCS(PropertyContextDeclCS eObject) {
			return new PropertyContextScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<?> defaultCase(EObject eObject) {
			return new DefaultScopeAdapter((ElementCS) eObject);
		}

		public AbstractScopeAdapter<?> doInPackageSwitch(EObject eObject) {
			return doSwitch(eObject.eClass(), eObject);
		}
	}
}
