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
 * $Id: OCLstdlibLinkingService.java,v 1.1 2010/05/03 05:30:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.services;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;

public class OCLstdlibLinkingService extends DefaultLinkingService
{
//	private static final Logger log = Logger.getLogger(OCLstdlibLinkingService.class);

	@Inject
	private IValueConverterService valueConverterService;
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, AbstractNode node) throws IllegalNodeException {
		String text = getText(node);
		if (text != null) {			
			IScope scope = getScope(context, ref);
			if (scope != null) {
				IEObjectDescription eObjectDescription = scope.getContentByName(text);
				if (eObjectDescription != null) {
					EObject eObjectOrProxy = eObjectDescription.getEObjectOrProxy();
					return Collections.singletonList(eObjectOrProxy);
				}
			}
		}
		return Collections.emptyList();
	}

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

	public String getText(AbstractNode node) {
		LeafNode leafNode = null;
		if (node instanceof LeafNode) {
			leafNode = (LeafNode) node;
		}
		else {
			for (LeafNode lNode : node.getLeafNodes()) {
				if (!lNode.isHidden()) {
					leafNode = lNode;
					break;
				}
			}
		}
		if (leafNode == null) {
			return null;
		}
		EObject grammarElement = leafNode.getGrammarElement();
		String ruleName = getLinkingHelper().getRuleNameFrom(grammarElement);
		return (String) valueConverterService.toValue(leafNode.getText(), ruleName, leafNode);
	}
}
