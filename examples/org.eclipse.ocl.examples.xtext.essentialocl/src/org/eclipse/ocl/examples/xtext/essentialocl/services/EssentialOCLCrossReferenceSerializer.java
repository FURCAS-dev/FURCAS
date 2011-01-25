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
 * $Id: EssentialOCLCrossReferenceSerializer.java,v 1.3 2011/01/25 07:18:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.AliasAnalysis;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.CrossReferenceSerializer;

import com.google.inject.Inject;

public class EssentialOCLCrossReferenceSerializer extends CrossReferenceSerializer
{
	private class PathElement
	{
		public final String name;
		public final EObject element;
		
		public PathElement(String name, EObject element) {
			super();
			this.name = name;
			this.element = element;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private ILinkingService linkingService;

	@Inject
	private IValueConverterService valueConverter;

	public EssentialOCLCrossReferenceSerializer() {
		super();
	}

	protected String getConvertedLinkText(EObject object, EReference reference, EObject context) {
		if ((reference == BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE) && (context instanceof TypedTypeRefCS)) {
			if (object instanceof PrimitiveType) {
				return ((PrimitiveType)object).getName();
			}
			TypeRefCS csRef = (TypedTypeRefCS) context;
			while (csRef.eContainer() instanceof TypeRefCS) {
				csRef = (TypeRefCS) csRef.eContainer();
			}
			ModelElementCS csContext = (ModelElementCS) csRef.eContainer();
			Element pivot = csContext.getPivot();
			AliasAnalysis aliasAnalysis = AliasAnalysis.getAdapter(csContext.eResource());
			List<PathElement> contextPath = getPath(aliasAnalysis, pivot);
			List<PathElement> objectPath = getPath(aliasAnalysis, (Element)object);
			return getDivergentPath(objectPath, contextPath);
		}
		else {
			return null;
		}
	}

	private String getDivergentPath(List<PathElement> objectPath, List<PathElement> contextPath) {
		int i = 0;
		int iSize = objectPath.size();
		int iMax = Math.min(iSize, contextPath.size());
		//
		//	Skip the common path elements
		//
		for ( ; i < iMax; i++) {
			EObject objectElement = objectPath.get(i).element;
			EObject contextElement = contextPath.get(i).element;
			if (!objectElement.equals(contextElement)) {
				break;
			}
		}
		//
		//	Serialize the divergent elements
		//
		StringBuffer s = new StringBuffer();
		for ( ; i < iSize-1; i++) {
			PathElement objectPathElement = objectPath.get(i);
			String objectName = objectPathElement.name;
			if (s.length() == 0) {
				EObject objectElement = objectPathElement.element;
				EObject contextElement = contextPath.get(i).element;
				//
				//	Use the name rather than the alias if within the same resource
				//
				Resource objectResource = objectElement.eResource();
				TypeManager typeManager = TypeManager.findAdapter(objectResource.getResourceSet());
				Resource orphanage = typeManager.getOrphanPackage().eResource();
				Resource contextResource = contextElement.eResource();
				if ((objectResource == contextResource) || (contextResource == orphanage)) {
					objectName = ((NamedElement)objectElement).getName();
				}
			}
			s.append(valueConverter.toString(objectName, "ID"));
			s.append("::");
		}
		if (iSize > 0) {
			s.append(valueConverter.toString(objectPath.get(iSize-1).name, "ID"));
		}
//		System.out.println(objectPath + " | " + contextPath + " => " + s.toString());
		return s.toString();
	}

	private List<PathElement> getPath(AliasAnalysis aliasAnalysis, Element eObject) {
//		if (eObject instanceof Pivotable) {
//			eObject = ((Pivotable)eObject).getPivot();
//		}
		if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
			String alias = aliasAnalysis.getAlias(eObject);
			if (alias != null) {
				List<PathElement> result = new ArrayList<PathElement>();
				result.add(new PathElement(alias, eObject));
				return result;
			}
		}
		EObject eContainer = eObject.eContainer();
		if (eContainer == null) {
			return new ArrayList<PathElement>();
		}
		List<PathElement> result = getPath(aliasAnalysis, (Element) eContainer);
		if (eObject instanceof NamedElement) {
			result.add(new PathElement(((NamedElement)eObject).getName(), eObject));
		}
		else if (eObject instanceof ENamedElement) {
			result.add(new PathElement(((ENamedElement)eObject).getName(), eObject));
		}
		else if (eObject instanceof NamedElementCS) {
			result.add(new PathElement(((NamedElementCS)eObject).getName(), eObject));
		}
		return result;
	}

	@Override
	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		if ((reference == BaseCSTPackage.Literals.IMPORT_CS__NAMESPACE) && (context instanceof ImportCS))
			return ((ImportCS) context).getUri();
		else if ((reference == BaseCSTPackage.Literals.REFERENCE_CS_REF__REF) && (context instanceof ReferenceCSRef))
			return ((Property) object).getName();
		else if ((reference == BaseCSTPackage.Literals.MODEL_ELEMENT_CS_REF__REF) && (context instanceof ModelElementCSRef))
			return ((NamedElementCS) object).getName();
		else {
			return super.getUnconvertedLinkText(object, reference, context);
		}
	}

	@Override
	public String serializeCrossRef(EObject context, CrossReference grammarElement, EObject target, INode node) {
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
