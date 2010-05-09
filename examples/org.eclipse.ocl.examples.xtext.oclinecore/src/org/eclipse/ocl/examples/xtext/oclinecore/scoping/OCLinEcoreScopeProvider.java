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
 * $Id: OCLinEcoreScopeProvider.java,v 1.5 2010/05/09 14:28:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.DefaultScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.EmptyScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeProvider;
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
		extends OCLinEcoreCSTSwitch<AbstractScopeAdapter<? extends EObject>>
		implements EssentialOCLScopeAdapter.ISwitch
	{
		@Override
		public AbstractScopeAdapter<? extends EObject> caseConstraintCS(ConstraintCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public EmptyScopeAdapter caseDataTypeCS(DataTypeCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public EssentialOCLScopeAdapter<? extends EObject> caseEnumCS(EnumCS eObject) {
			return new EnumScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseOCLinEcoreAttributeCS(OCLinEcoreAttributeCS eObject) {
			return new EmptyScopeAdapter(eObject);
		}

		@Override
		public EssentialOCLScopeAdapter<? extends EObject> caseOCLinEcoreClassCS(OCLinEcoreClassCS eObject) {
			return new ClassScopeAdapter(eObject);
		}

		@Override
		public OCLinEcoreDocumentScopeAdapter caseOCLinEcoreDocumentCS(OCLinEcoreDocumentCS eObject) {
			return new OCLinEcoreDocumentScopeAdapter(eObject);
		}

		@Override
		public EssentialOCLScopeAdapter<? extends EObject> caseOCLinEcoreOperationCS(OCLinEcoreOperationCS eObject) {
			return new OperationScopeAdapter(eObject);
		}

		@Override
		public EssentialOCLScopeAdapter<? extends EObject> caseOCLinEcorePackageCS(OCLinEcorePackageCS eObject) {
			return new OCLinEcorePackageScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseOCLinEcoreReferenceCS(OCLinEcoreReferenceCS eObject) {
			return new OCLinEcoreReferenceScopeAdapter(eObject);
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
