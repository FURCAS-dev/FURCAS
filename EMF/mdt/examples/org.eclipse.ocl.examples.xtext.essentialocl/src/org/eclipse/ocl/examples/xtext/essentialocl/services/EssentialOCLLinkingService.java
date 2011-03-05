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
 * $Id: EssentialOCLLinkingService.java,v 1.4 2011/03/04 13:54:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.services;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.BaseScopeProvider;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ImportScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2Moniker;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;

public class EssentialOCLLinkingService extends DefaultLinkingService
{
	private static int depth = -1;
	
	@Inject
	private IValueConverterService valueConverterService;

	@Inject
	private IGlobalScopeProvider globalScopeProvider;

	protected List<EObject> getLinkedImport(ModelElementCS context, INode node) {
		ScopeAdapter scopeAdapter = ElementUtil.getScopeAdapter(context);
		String text = getText(node);
		if ((scopeAdapter instanceof ImportScopeAdapter) && (text != null)) {
			BaseCSResource csResource = (BaseCSResource) context.eResource();
			URI uri = URI.createURI(text);
			uri = csResource.resolve(uri);
			ImportScopeAdapter importScopeAdapter = (ImportScopeAdapter)scopeAdapter;
			URI oldURI = importScopeAdapter.getURI();
			Element importedElement;				
			if (uri.equals(oldURI)) {
				importedElement = importScopeAdapter.getImportedElement();
			}
			else {
				TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.getAdapter(csResource, null);
				TypeManager typeManager = adapter.getTypeManager();
				importedElement = typeManager.loadResource(uri, ((ImportCS)context).getName());				
				importScopeAdapter.setImportedElement(uri, importedElement);
			}
			if (importedElement != null) {
				return Collections.<EObject>singletonList(importedElement);
			}
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		if ((ref == BaseCSTPackage.Literals.IMPORT_CS__NAMESPACE) && (context instanceof ImportCS)) {
			return getLinkedImport((ModelElementCS)context, node);
		}
		try {
			depth++;
			String text = getText(node);
			boolean traceLookup = BaseScopeProvider.LOOKUP.isActive();
			if (text == null) {			
				if (traceLookup) {
					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup null");
				}
				return Collections.emptyList();
			}
			ScopeCSAdapter scopeAdapter = null;
			IScope scope = null;
			String uri = TypesPackage.eNS_URI;
//			if (ref.getEReferenceType().getEPackage() == TypesPackage.eINSTANCE) {	// FIXME this is costly; don't inflict it when not needed
			if (ref.getEReferenceType().getEPackage().getNsURI().equals(uri)) {
				scope = globalScopeProvider.getScope(context.eResource(), ref, null);
			}
			else {
				scopeAdapter = ElementUtil.getScopeCSAdapter((ElementCS) context);
				if (scopeAdapter.isUnresolvable()) {
					if (traceLookup) {
						BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " already unresolvable");
					}
					return Collections.emptyList();
				}
				scope = getScope(context, ref);
				if (traceLookup) {
//					EObject target = ((ScopeView)scope).getTarget();
//					String inString = target instanceof ElementCS ? ((ElementCS)target).getSignature() : target.toString();
//					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " in " + inString);
					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text);
				}
			}
			QualifiedName qualifiedName = QualifiedName.create(text);	// FIXME use IQualifiedNameConverter
			IEObjectDescription eObjectDescription = scope.getSingleElement(qualifiedName);
			if (eObjectDescription != null) {
				EObject eObjectOrProxy = eObjectDescription.getEObjectOrProxy();
				if (traceLookup) {
					if (eObjectOrProxy instanceof MonikeredElementCS) {
						BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " => " + CS2Moniker.toString((MonikeredElementCS)eObjectOrProxy));
					}
					else {
						BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " => " + eObjectOrProxy);									
					}
				}
				return Collections.singletonList(eObjectOrProxy);
			}
			if (traceLookup) {
				BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " failed");
			}
			eObjectDescription = scope.getSingleElement(qualifiedName);	// FIXME conditionalise this retry for debug
//			}
			if (scopeAdapter != null) {
				scopeAdapter.setUnresolvable();
			}
			return Collections.emptyList();
		}
		finally {
			depth--;
		}
	}

	@Override
	protected IScope getScope(EObject context, EReference reference) {
		IScopeProvider scopeProvider = getScopeProvider();
		if (scopeProvider == null)
			throw new IllegalStateException("scopeProvider must not be null.");
//		try {
//			registerImportedNamesAdapter(context);
			return scopeProvider.getScope(context, reference);
//		} finally {
//			unRegisterImportedNamesAdapter();
//		}
	}

	public String getText(INode node) {
		ILeafNode leafNode = ElementUtil.getLeafNode(node);
		if (leafNode == null) {
			return null;
		}
		EObject grammarElement = leafNode.getGrammarElement();
		String ruleName = getLinkingHelper().getRuleNameFrom(grammarElement);
		return (String) valueConverterService.toValue(leafNode.getText(), ruleName, leafNode);
	}
}
