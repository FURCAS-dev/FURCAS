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
 * $Id: OCLinEcoreCrossReferenceSerializer.java,v 1.10 2010/05/21 20:13:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.DocumentScopeAdapter;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.CrossReferenceSerializer;

import com.google.inject.Inject;

public class OCLinEcoreCrossReferenceSerializer extends CrossReferenceSerializer
{
	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private ILinkingService linkingService;

	@Inject
	private IValueConverterService valueConverter;

	public OCLinEcoreCrossReferenceSerializer() {
		super();
	}

	protected String getConvertedLinkText(EObject object, EReference reference, EObject context) {
		if ((reference == BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE) && (context instanceof TypedTypeRefCS)) {
			DocumentScopeAdapter documentScopeAdapter = AbstractScopeAdapter.getDocumentScopeAdapter(context);
			List<String> contextPath = getPath(documentScopeAdapter, context);
			List<String> objectPath = getPath(documentScopeAdapter, object);
			return getDivergentPath(objectPath, contextPath);
		}
		else {
			return null;
		}
	}

	private String getDivergentPath(List<String> objectPath, List<String> contextPath) {
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
		StringBuffer s = new StringBuffer();
		for ( ; i < iSize-1; i++) {
			s.append(valueConverter.toString(objectPath.get(i), "ID"));
			s.append("::");
		}
		if (iSize > 0) {
			s.append(valueConverter.toString(objectPath.get(iSize-1), "ID"));
		}
		return s.toString();
	}

	private List<String> getPath(DocumentScopeAdapter documentScopeAdapter, EObject eObject) {
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

	@Override
	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		if ((reference == BaseCSTPackage.Literals.IMPORT_CS__NAMESPACE) && (context instanceof ImportCS))
			return ((ImportCS) context).getUri();
		else if ((reference == BaseCSTPackage.Literals.REFERENCE_CS_REF__REF) && (context instanceof ReferenceCSRef))
			return ((ReferenceCS) object).getName();
		else if ((reference == BaseCSTPackage.Literals.MODEL_ELEMENT_CS_REF__REF) && (context instanceof ModelElementCSRef))
			return ((NamedElementCS) object).getName();
		else {
			return super.getUnconvertedLinkText(object, reference, context);
		}
	}

	@Override
	public String serializeCrossRef(EObject context, CrossReference grammarElement, EObject target, AbstractNode node) {
		final EReference ref = GrammarUtil.getReference(grammarElement, context.eClass());
		String text = null;
		if (node != null) {
			List<EObject> objects = linkingService.getLinkedObjects(context, ref, node);
			if (objects.contains(target))
				return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		}
		text = getConvertedLinkText(target, ref, context);
		if (text != null) {
			return text;
		}
		text = getUnconvertedLinkText(target, ref, context);
		if (text != null) {
			return getConvertedValue(text, grammarElement);
		}
		if (node != null) {
			return linkingHelper.getCrossRefNodeAsString(node, false);
		}
		return null;
	}

}
