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
 * $Id: OCLinEcoreCrossReferenceSerializer.java,v 1.6 2010/05/09 09:51:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractDocumentScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.xtext.parsetree.reconstr.impl.CrossReferenceSerializer;

public class OCLinEcoreCrossReferenceSerializer extends CrossReferenceSerializer
{
//	private final SimpleAttributeResolver<EObject, String> aliasResolver;

	public OCLinEcoreCrossReferenceSerializer() {
		super();
//		aliasResolver = SimpleAttributeResolver.newResolver(String.class, "alias");
	}

	@Override
	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		if ((reference == BaseCSTPackage.Literals.IMPORT_CS__NAMESPACE) && (context instanceof ImportCS))
			return ((ImportCS) context).getUri();
		if ((reference == BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE) && (context instanceof TypedTypeRefCS)) {
			AbstractDocumentScopeAdapter<?> documentScopeAdapter = AbstractScopeAdapter.getDocumentScopeAdapter((ElementCS)context);
			List<String> contextPath = getPath(documentScopeAdapter, context);
			List<String> objectPath = getPath(documentScopeAdapter, object);
			return divergentPath(objectPath, contextPath);					// FIXME Check cast
		}
		if ((reference == BaseCSTPackage.Literals.REFERENCE_CS_REF__REF) && (context instanceof ReferenceCSRef))
			return ((ReferenceCS) object).getName();
		if ((reference == BaseCSTPackage.Literals.MODEL_ELEMENT_CS_REF__REF) && (context instanceof ModelElementCSRef))
			return ((NamedElementCS) object).getName();
//		if ((reference == OCLinEcoreCSTPackage.Literals.NAMED_ELEMENT_CS__NAME) && (context instanceof TypeCS))
//			return "::" + ((TypeCS) object).getName();
		return super.getUnconvertedLinkText(object, reference, context);
	}

	private String divergentPath(List<String> objectPath, List<String> contextPath) {
		StringBuffer s = new StringBuffer();
		int i = 0;
		int iSize = objectPath.size();
		int iMax = Math.min(iSize, contextPath.size());
		for ( ; i < iMax; i++) {
			String objectElement = objectPath.get(i);
			String contextElement = contextPath.get(i);
			if (!objectElement.equals(contextElement)) {
				break;
			}
		}
		for ( ; i < iSize; i++) {
			if (s.length() > 0){
				s.append("::");
			}
			s.append(objectPath.get(i));
		}
		return s.toString();
	}

	private List<String> getPath(AbstractDocumentScopeAdapter<?> documentScopeAdapter, EObject eObject) {
		if (eObject instanceof PackageCS) {
			String alias = documentScopeAdapter.getAlias((PackageCS)eObject);
			if (alias != null) {
				List<String> result = new ArrayList<String>();
				result.add(alias);
				return result;
			}
		}
		EObject eContainer = eObject.eContainer();
		if (eContainer == null) {
			return new ArrayList<String>();
		}
		List<String> result = getPath(documentScopeAdapter, eContainer);
		if (eObject instanceof ENamedElement) {
			result.add(((ENamedElement)eObject).getName());
		}
		else if (eObject instanceof NamedElementCS) {
			result.add(((NamedElementCS)eObject).getName());
		}
		return result;
	}

}
