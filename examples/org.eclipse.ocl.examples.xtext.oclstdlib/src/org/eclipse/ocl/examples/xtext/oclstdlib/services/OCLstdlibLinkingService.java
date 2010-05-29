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
 * $Id: OCLstdlibLinkingService.java,v 1.7 2010/05/29 15:30:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.services;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.scoping.BaseScopeProvider;
import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
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
	private static int depth = -1;
	
	@Inject
	private IValueConverterService valueConverterService;
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, AbstractNode node) throws IllegalNodeException {
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
			ScopeAdapter scopeAdapter = ElementUtil.getScopeAdapter(context);
			if (scopeAdapter.isUnresolvable()) {
				if (traceLookup) {
					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " already unresolvable");
				}
				return Collections.emptyList();
			}
			IScope scope = getScope(context, ref);
			if (scope instanceof ScopeView) {
				if (traceLookup) {
//					EObject target = ((ScopeView)scope).getTarget();
//					String inString = target instanceof ElementCS ? ((ElementCS)target).getSignature() : target.toString();
//					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " in " + inString);
					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text);
				}
				IEObjectDescription eObjectDescription = scope.getContentByName(text);
				if (eObjectDescription != null) {
					EObject eObjectOrProxy = eObjectDescription.getEObjectOrProxy();
					if (traceLookup) {
						if (eObjectOrProxy instanceof ElementCS) {
							BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " => " + ((ElementCS)eObjectOrProxy).getSignature());
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
				//					eObjectDescription = scope.getContentByName(text);	// FIXME conditionalise this retry for debug
			}
			scopeAdapter.setUnresolvable();
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
