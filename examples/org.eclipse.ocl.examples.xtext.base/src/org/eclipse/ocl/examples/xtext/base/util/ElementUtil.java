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
 * $Id: ElementUtil.java,v 1.2 2010/05/16 19:18:04 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.util;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

public class ElementUtil
{
	public static boolean conformsTo(EStructuralFeature eStructuralFeature, EClassifier contentType) {
		if (eStructuralFeature == null) {			// Wildcard match all
			return true;
		}
		EClassifier targetType = eStructuralFeature.getEType();
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return ((EClass) targetType).isSuperTypeOf((EClass) contentType);
	}

	public static String getCollectionTypeName(TypedElementCS csTypedElement) {
		String multiplicity = csTypedElement.getMultiplicity();
		if (multiplicity != null) {
			if ("?".equals(multiplicity)) { //$NON-NLS-1$
				return null;
			}
		}
		else {
			int upper = csTypedElement.getUpper();
			if (upper == 1) {
				return null;
			}
		}
		EList<String> qualifiers = csTypedElement.getQualifiers();
		boolean isOrdered = true;
		boolean isUnique = true;
		if (qualifiers.contains("!ordered")) { //$NON-NLS-1$
			isOrdered = false;
		}
		else if (qualifiers.contains("ordered")) { //$NON-NLS-1$
			isOrdered = true;
		}
		if (qualifiers.contains("!unique")) { //$NON-NLS-1$
			isUnique = false;
		}
		else if (qualifiers.contains("unique")) { //$NON-NLS-1$
			isUnique = true;
		}
		if (isOrdered) {
			return isUnique ? "OrderedSet" : "Sequence"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			return isUnique ? "Set" : "Bag"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public static <T extends NamedElementCS> T getNamedElementCS(Collection<T> namedElements, String name) {
		for (T namedElement : namedElements) {
			if (name.equals(namedElement.getName())) {
				return namedElement;
			}
		}
		return null;
	}

	public static CompositeNode getParserNode(EObject eObject) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(eObject);
		return nodeAdapter != null ? nodeAdapter.getParserNode() : null;
	}

	public static ScopeAdapter getScopeAdapter(EObject element) {
		return AbstractScopeAdapter.getScopeAdapter(element);
	}
	
/*	public static List<String> getTexts(EObject eObject) {
		CompositeNode compositeNode = getParserNode(eObject);
		if (compositeNode == null) {
			return Collections.emptyList();
		}
		List<LeafNode> leafNodes = compositeNode.getLeafNodes();
		int size = leafNodes.size();
		List<String> strings = new ArrayList<String>(size);
		for (LeafNode leaf : leafNodes) {
			if (!leaf.isHidden()) {
				strings.add(leaf.getText());
			}
		}
		return strings;
	} */
	
	public static boolean isValidIdentifier(String value) {
		int iMax = value.length();
		for (int i = 0; i < iMax; i++) {
			char c = value.charAt(i);
			if (('A' <= c) && (c <= 'Z')) {					
			}
			else if (('a' <= c) && (c <= 'z')) {					
			}
			else if (c == '_') {					
			}
			else if (('0' <= c) && (c <= '9') && (i > 0)) {					
			}
			else {
				return false;
			}
		}
		return true;
	}
}
