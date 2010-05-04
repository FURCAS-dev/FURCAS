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
 * $Id: OCLinEcoreCrossReferenceSerializer.java,v 1.3 2010/05/04 21:35:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.services;

import java.util.ArrayList;
import java.util.HashSet;
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
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.parser.antlr.internal.InternalOCLinEcoreParser;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultCrossReferenceSerializer;

import com.google.inject.Inject;

public class OCLinEcoreCrossReferenceSerializer extends DefaultCrossReferenceSerializer
{
	@Inject
	private IValueConverterService valueConverter;

	public OCLinEcoreCrossReferenceSerializer() {
		super();
	}

	@Override
	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		if ((reference == BaseCSTPackage.Literals.IMPORT_CS__NAMESPACE) && (context instanceof ImportCS))
			return ((ImportCS) context).getUri();
		if ((reference == BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE) && (context instanceof TypedTypeRefCS)) {
			List<String> contextPath = getPath(context);
			List<String> objectPath = getPath(object);
			return divergentPath(objectPath, contextPath);					// FIXME Check cast
		}
		if ((reference == BaseCSTPackage.Literals.REFERENCE_CS_REF__REF) && (context instanceof ReferenceCSRef))
			return ((ReferenceCS) object).getName();
		if ((reference == BaseCSTPackage.Literals.MODEL_ELEMENT_CS_REF__REF) && (context instanceof ModelElementCSRef))
			return ((NamedElementCS) object).getName();
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
			s.append(valueConverter.toString(objectPath.get(i), "Identifier"));
		}
		if ((s.length() <= 0) && (iSize > 0)) {
			s.append(valueConverter.toString(objectPath.get(iSize-1), "Identifier"));
		}
		return s.toString();
	}

	public String convertIdentifier(String convertMe) {
		return valueConverter.toString(convertMe, "Identifier");
	}

	private List<String> getPath(EObject eObject) {
		EObject eContainer = eObject.eContainer();
		if (eContainer == null) {
			return new ArrayList<String>();
		}
		List<String> result = getPath(eContainer);
		if (eObject instanceof ENamedElement) {
			result.add(((ENamedElement)eObject).getName());
		}
		else if (eObject instanceof PackageCS) {
			AbstractDocumentScopeAdapter<?> documentScopeAdapter = AbstractScopeAdapter.getDocumentScopeAdapter((PackageCS)eObject);
			result.add(documentScopeAdapter.getAlias((PackageCS)eObject));
		}
		else if (eObject instanceof NamedElementCS) {
			result.add(((NamedElementCS)eObject).getName());
		}
		return result;
	}

}
