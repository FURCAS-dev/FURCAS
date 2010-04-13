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
 * $Id: OCLinEcoreLinkingService.java,v 1.1 2010/04/13 06:44:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;

import com.google.inject.Inject;

public class OCLinEcoreLinkingService extends DefaultLinkingService
{
	private static final Logger log = Logger.getLogger(OCLinEcoreLinkingService.class);

	@Inject
	private IValueConverterService valueConverterService;
	
//	@Inject
//	private OCLinEcoreGrammarAccess grammarAccess;
	
	// FIXME Use Scopes, retarct mappings when deleted
	private Map<String, EPackage> modelNameMap = new HashMap<String, EPackage>();

	private List<EObject> getLinkedClassifier(EClassifierCSRef context, EReference ref, LeafNode text) throws IllegalNodeException {
		String alias = context.getModelName();
		if (alias == null) {
			alias = "";
		}
		EClassifier eClassifier = null;
		EPackage ePackage = modelNameMap.get(alias);
		if (ePackage != null) {
			eClassifier = ePackage.getEClassifier(text.getText());
		}
		if (eClassifier != null) {
			return Collections.<EObject>singletonList(eClassifier);
		}
		return Collections.emptyList();
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, AbstractNode node) throws IllegalNodeException {
		if ((ref == OCLinEcoreCSTPackage.Literals.IMPORT_CS__EPACKAGE) && (context instanceof ImportCS))
			return getPackage((ImportCS)context, (LeafNode) node);
		if ((ref == OCLinEcoreCSTPackage.Literals.ECLASSIFIER_CS_REF__REF) && (context instanceof EClassifierCSRef))
			return getLinkedClassifier((EClassifierCSRef)context, ref, (LeafNode) node);
		return super.getLinkedObjects(context, ref, node);
	}

	private String getMetamodelNsURI(LeafNode text) {
		try {
			return (String) valueConverterService.toValue(text.getText(), getLinkingHelper().getRuleNameFrom(text
					.getGrammarElement()), text);
		} catch (ValueConverterException e) {
			log.debug("Exception on leaf '" + text.getText() + "'", e);
			return null;
		}
	}

/*	private List<EObject> getPackage(String nsUri, Grammar grammar, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar))
			return null;
		for(AbstractMetamodelDeclaration declaration: grammar.getMetamodelDeclarations()) {
			EPackage pack = declaration.getEPackage();
			if (pack != null && nsUri.equals(pack.getNsURI()))
				return Collections.<EObject>singletonList(pack);
		}
		for (Grammar usedGrammar: grammar.getUsedGrammars()) {
			List<EObject> result = getPackage(nsUri, usedGrammar, visitedGrammars);
			if (result != null)
				return result;
		}
		return null;
	} */

	private List<EObject> getPackage(ImportCS context, LeafNode text) {
		String nsUri = getMetamodelNsURI(text);
		if (nsUri == null)
			return Collections.emptyList();
/*		Grammar grammar = grammarAccess.getGrammar();
		Set<Grammar> visitedGrammars = new HashSet<Grammar>();
		for (Grammar usedGrammar: grammar.getUsedGrammars()) {
			List<EObject> result = getPackage(nsUri, usedGrammar, visitedGrammars);
			if (result != null)
				return result;
		} */
		EPackage pack = loadEPackage(nsUri, context.eResource().getResourceSet());
		if (pack != null) {
			String alias = context.getAlias();
			if (alias == null) {
				alias = "";
			}
			modelNameMap.put(alias, pack);
			return Collections.<EObject>singletonList(pack);
		}
		return Collections.emptyList();
	}

	private EPackage loadEPackage(String resourceOrNsURI, ResourceSet resourceSet) {
		if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
			return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		try {
			URI uri = URI.createURI(resourceOrNsURI);
			if (uri.fragment() == null) {
				Resource resource = resourceSet.getResource(uri, true);
				EPackage result = (EPackage) resource.getContents().get(0);
				return result;
			}
			EPackage result = (EPackage) resourceSet.getEObject(uri, true);
			return result;

		} catch(RuntimeException ex) {
			log.trace("Cannot load package with URI '" + resourceOrNsURI + "'", ex);
			return null;
		}
	}
}
