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
 * $Id: OCLinEcoreScopeProvider.java,v 1.9 2010/08/17 06:51:08 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.DefaultScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.EmptyScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeProvider;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreAttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.util.OCLinEcoreCSTSwitch;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class OCLinEcoreScopeProvider extends EssentialOCLScopeProvider
{
	static {
		EssentialOCLScopeAdapter.addSwitch(OCLinEcoreCSTPackage.eINSTANCE, new OCLinEcoreScopeSwitch());
	}
	
	public static class OCLinEcoreScopeSwitch 
		extends OCLinEcoreCSTSwitch<ScopeAdapter>
		implements ScopeAdapter.Switch
	{
		@Override
		public ScopeAdapter caseAnnotationCS(AnnotationCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseConstraintCS(ConstraintCS eObject) {
			return new ConstraintScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseDataTypeCS(DataTypeCS eObject) {
			return new DataTypeScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseEnumCS(EnumCS eObject) {
			return new EnumScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseOCLinEcoreAttributeCS(OCLinEcoreAttributeCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseOCLinEcoreClassCS(OCLinEcoreClassCS eObject) {
			return new ClassScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseOCLinEcoreDocumentCS(OCLinEcoreDocumentCS eObject) {
			return new OCLinEcoreDocumentScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseOCLinEcoreOperationCS(OCLinEcoreOperationCS eObject) {
			return new OperationScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseOCLinEcorePackageCS(OCLinEcorePackageCS eObject) {
			return new OCLinEcorePackageScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseOCLinEcoreReferenceCS(OCLinEcoreReferenceCS eObject) {
			return new OCLinEcoreReferenceScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter defaultCase(EObject eObject) {
			return new DefaultScopeAdapter(eObject);
		}

		public ScopeAdapter doInPackageSwitch(EObject eObject) {
			return doSwitch(eObject.eClass(), eObject);
		}
	}
}
