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
 * $Id: BaseScopeProvider.java,v 1.6 2010/05/24 08:59:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedPackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.util.BaseCSTSwitch;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.DocumentScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class BaseScopeProvider extends AbstractDeclarativeScopeProvider
{
	public static final TracingOption LOOKUP = new TracingOption("org.eclipse.ocl.examples.xtext.base", "lookup");  //$NON-NLS-1$//$NON-NLS-2$

	static {
		AbstractScopeAdapter.addSwitch(BaseCSTPackage.eINSTANCE, new BaseScopeSwitch());
	}
	
	public static class BaseScopeSwitch 
		extends BaseCSTSwitch<ScopeAdapter>
		implements ScopeAdapter.Switch
	{
		@Override
		public ScopeAdapter caseBoundClassifierCS(BoundClassifierCS eObject) {
			return new BoundClassifierScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseImportCS(ImportCS eObject) {
			return new ImportScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseParameterCS(ParameterCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseQualifiedClassifierRefCS(QualifiedClassifierRefCS eObject) {
			return new QualifiedRefScopeAdapter<QualifiedClassifierRefCS>(eObject);
		}

		@Override
		public ScopeAdapter caseQualifiedOperationRefCS(QualifiedOperationRefCS eObject) {
			return new QualifiedRefScopeAdapter<QualifiedOperationRefCS>(eObject);
		}

		@Override
		public ScopeAdapter caseQualifiedPackageRefCS(QualifiedPackageRefCS eObject) {
			return new QualifiedRefScopeAdapter<QualifiedPackageRefCS>(eObject);
		}

		@Override
		public ScopeAdapter caseQualifiedStructuralFeatureRefCS(QualifiedStructuralFeatureRefCS eObject) {
			return new QualifiedRefScopeAdapter<QualifiedStructuralFeatureRefCS>(eObject);
		}

		@Override
		public ScopeAdapter caseQualifiedTypeRefCS(QualifiedTypeRefCS eObject) {
			return new QualifiedRefScopeAdapter<QualifiedTypeRefCS>(eObject);
		}

		@Override
		public ScopeAdapter caseReferenceCSRef(ReferenceCSRef eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseSimpleClassifierRefCS(SimpleClassifierRefCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseSimpleOperationRefCS(SimpleOperationRefCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseSimplePackageRefCS(SimplePackageRefCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseSimpleStructuralFeatureRefCS(SimpleStructuralFeatureRefCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseTypeParameterCS(TypeParameterCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseTypedTypeRefCS(TypedTypeRefCS eObject) {
			return new TypedTypeRefScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter defaultCase(EObject eObject) {
			return new DefaultScopeAdapter(eObject);
		}

		public ScopeAdapter doInPackageSwitch(EObject eObject) {
			return doSwitch(eObject.eClass(), eObject);
		}
	}

	@Override
	public ScopeView getScope(EObject context, EReference reference) {
		ScopeAdapter scopeAdapter = ElementUtil.getScopeAdapter(context);
		if (scopeAdapter == null) {
			return null;
		}
		TypeBindingsCS bindings = BaseCSTFactory.eINSTANCE.createTypeBindingsCS();
		DocumentScopeAdapter documentScopeAdapter = scopeAdapter.getDocumentScopeAdapter();
		bindings.setBoundDocument(documentScopeAdapter.getBoundDocument());
		return scopeAdapter.getOuterScopeView(reference, bindings);
	}
}
