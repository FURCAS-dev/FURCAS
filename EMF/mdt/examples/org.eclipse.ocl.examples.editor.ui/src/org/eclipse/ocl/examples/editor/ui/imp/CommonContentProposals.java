/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonContentProposals.java,v 1.1 2010/03/11 14:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lpg.runtime.ErrorToken;
import lpg.runtime.IToken;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonParseController.TokenKind;
import org.eclipse.ocl.examples.parser.environment.IHasName;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.DerivedPrsStream;
import org.eclipse.swt.graphics.Image;

public class CommonContentProposals
{
	public static TracingOption proposalDebug = new TracingOption(OCLExamplesEditorPlugin.PLUGIN_ID, "proposal/debug");

	protected final ICommonParseResult parseResult;
	protected final int offset;
	protected final Map<Object, ICommonProposal> map;
	protected CSTNode cstRoot;
	protected IToken tokenAtOffset;
	protected String prefixAtOffset;
	
	public CommonContentProposals(ICommonParseResult parseResult, int offset) {
		this.parseResult = parseResult;
		this.offset = offset;
		this.map = new HashMap<Object, ICommonProposal>();
	}

	/**
	 * Accumulate the candidate if it represents a suitable proposal.
	 * @param cstNode 
	 */
	protected void addIdentifierProposalCandidate(Map<EClassifier, List<EStructuralFeature>> usages, EObject proposal, CSTNode cstNode) {
		if (checkName(usages, proposal, cstNode) && checkType(usages, proposal, cstNode) && !map.containsKey(proposal)) {
			ILabelProvider labelProvider = parseResult.getParseController().getLabelProvider();
			String newText = getProposalReplacementText(proposal);
			String displayText = getProposalDisplayText(labelProvider, proposal, newText);
			Image image = getProposalDisplayImage(labelProvider, proposal);
			String oldText = getTokenAtOffsetString();
			map.put(proposal, new CommonProposal(displayText, tokenAtOffset.getStartOffset(), newText, oldText, offset, image));
		}
	}

	protected void addIdentifierProposals(CSTNode cstNode) {
		Object astNode = getAst(cstNode);
		if (astNode == null) {
			map.put(null, new CommonNonProposal("Internal error: no AST node to select completion proposal for " + cstNode.getClass().getSimpleName(), "", offset));
			return;
		}
		if (proposalDebug.isActive())
			proposalDebug.println("Proposal for '" + prefixAtOffset + "' " + cstNode.getClass().getSimpleName() + " " + astNode.getClass().getSimpleName());
		if (astNode instanceof EObject) {
			Map<EClassifier, List<EStructuralFeature>> usages = computeUsage((EObject) astNode);
			for (Resource resource : getResources(usages, (EObject) astNode))
				for (TreeIterator<EObject> i = resource.getAllContents(); i.hasNext(); )
					addIdentifierProposalCandidate(usages, i.next(), cstNode);
		}
	}

	protected void addIdentifierKeywordProposals(CSTNode cstNode) {
		for (ICommonKeyword keyword : parseResult.getKeywords()) {
			if (keyword.isIdentifier(cstNode)) {
				String keywordText = keyword.getText();
				if (offset < tokenAtOffset.getStartOffset())
					map.put(keyword, new CommonProposal(keywordText, offset, keywordText, "", offset, null));
				else if (keywordText.startsWith(prefixAtOffset))
					map.put(keyword, new CommonProposal(keywordText, tokenAtOffset.getStartOffset(), keywordText, getTokenAtOffsetString(), offset, null));
			}
		}
	}

	protected void addKeywordProposals() {
		for (ICommonKeyword keyword : parseResult.getKeywords()) {
			String keywordText = keyword.getText();
			if (offset < tokenAtOffset.getStartOffset())
				map.put(keyword, new CommonProposal(keywordText, offset, keywordText, "", offset, null));
			else if (keywordText.startsWith(prefixAtOffset))
				map.put(keyword, new CommonProposal(keywordText, tokenAtOffset.getStartOffset(), keywordText, getTokenAtOffsetString(), offset, null));
		}
	}

	protected void addStringProposals() {
		Collection<Resource> resources = parseResult.getResourcesVisibleAt(null);
		for (Resource resource : resources)
			for (TreeIterator<EObject> i = resource.getAllContents(); i.hasNext(); )
				addStringProposalCandidate(i.next());
	}

	protected void addStringProposalCandidate(EObject candidate) {
		if (candidate instanceof StringLiteralExp<?>) {
			String string = ((StringLiteralExp<?>)candidate).getStringSymbol();
			if (!map.containsKey(string) && string.startsWith(prefixAtOffset.length() > 0 ? prefixAtOffset.substring(1) : "")) {
				String newText = "'" + string + "'";
				String displayText = string;
//				ILabelProvider labelProvider = commonParseController.getLabelProvider();
				Image image = null; // FIXME labelProvider.geImage(string);
				map.put(string, new CommonProposal(displayText, tokenAtOffset.getStartOffset(), newText, getTokenAtOffsetString(), offset, image));
			}
		}
	}

	/**
	 * Add the usage of the target of feature from source to the map of all usages.
	 * 
	 * @param usages
	 * @param source
	 * @param feature
	 */
	protected void addUsage(Map<EClassifier, List<EStructuralFeature>> usages, EObject source, EStructuralFeature feature) {
		EClassifier type = EcoreUtils.getEType(source, feature);	// Resolves type parameters
		List<EStructuralFeature> usageList = usages.get(type);
		if (usageList == null) {
			usageList = new ArrayList<EStructuralFeature>();
			usages.put(type, usageList);
		}
		if (!usageList.contains(feature))
			usageList.add(feature);
	}

	/**
	 * Return true if the name of eObject is suitable for the usages with prefixAtOffset.
	 */
	protected boolean checkName(Map<EClassifier, List<EStructuralFeature>> usages, EObject eObject, CSTNode cstNode) {
		String name = getName(eObject);
		if (name == null)
			return false;
		return name.startsWith(prefixAtOffset);
	}

	/**
	 * Return true if the type of eObject is suitable as the target of the usages.
	 */
	protected boolean checkType(Map<EClassifier, List<EStructuralFeature>> usages, EObject eObject, CSTNode cstNode) {
		if (usages.isEmpty())
			return false;
		for (Map.Entry<EClassifier, List<EStructuralFeature>> requiredUsage : usages.entrySet()) {
			EClassifier requiredType = requiredUsage.getKey();
			Set<EClass> completableClasses = getCompletableTypes(requiredType, cstNode);
			if (completableClasses == null)
				return false;
			EClass eClass = eObject.eClass();
			boolean completable = false;
			for (EClass completableClass : completableClasses) {
				if ((eClass == completableClass) || completableClass.isSuperTypeOf(eClass)) {
					completable = true;
					break;
				}
			}
			if (!completable)
				return false;
		}
		return true;
	}

	public void computeProposals() {
		cstRoot = parseResult.getCST();
		if (cstRoot == null) {
			if (proposalDebug.isActive())
				proposalDebug.println("No CST");
			map.put(null, new CommonNonProposal("no info available due to Syntax error(s)", "", offset));
			return;
		}
		tokenAtOffset = getToken();
		prefixAtOffset = getPrefix();
		TokenKind tokenKind = parseResult.getTokenKind(tokenAtOffset.getKind());
		switch (tokenKind) {
			case IDENTIFIER: {
				ISourcePositionLocator locator = parseResult.getSourcePositionLocator();
				CSTNode node = (CSTNode) locator.findNode(cstRoot, tokenAtOffset.getStartOffset(), tokenAtOffset.getEndOffset());
				if (node == null) {
					if (proposalDebug.isActive())
						proposalDebug.println("No CST node");
					map.put(null, new CommonNonProposal("no info available due to Syntax error(s)", "", offset));
				}
				else {
					addIdentifierProposals(node);
					addIdentifierKeywordProposals(node);
					if (map.isEmpty()) {
						Object astNode = getAst(node);
						if (astNode != null)						// Fix for Bug 277746
							map.put(null, new CommonNonProposal("no completion exists for '" + prefixAtOffset + "' " + node.getClass().getSimpleName() + " " + astNode.getClass().getSimpleName(), "", offset));
						else
							map.put(null, new CommonNonProposal("no completion exists for '" + prefixAtOffset + "' " + node.getClass().getSimpleName(), "", offset));
					}
				}
				break;
			}
			case ERROR: {
				ISourcePositionLocator locator = parseResult.getSourcePositionLocator();
				CSTNode node = (CSTNode) locator.findNode(cstRoot, tokenAtOffset.getStartOffset(), tokenAtOffset.getEndOffset());
				addIdentifierProposals(node);
				addIdentifierKeywordProposals(node);
				addKeywordProposals();
				if (map.isEmpty())
					map.put(null, new CommonNonProposal("no completion exists for keyword: " + prefixAtOffset, "", offset));
				break;
			}
			case KEYWORD: {
				ISourcePositionLocator locator = parseResult.getSourcePositionLocator();
				CSTNode node = (CSTNode) locator.findNode(cstRoot, tokenAtOffset.getStartOffset(), tokenAtOffset.getEndOffset());
				if ((node instanceof IHasName) || (node instanceof SimpleNameCS)) {
					addIdentifierProposals(node);
					addIdentifierKeywordProposals(node);
				}
				else
					addKeywordProposals();
				if (map.isEmpty())
					map.put(null, new CommonNonProposal("no completion exists for keyword: " + prefixAtOffset, "", offset));
				break;
			}
			case STRING: {
				addStringProposals();
				if (map.isEmpty())
					map.put(null, new CommonNonProposal("no completion exists for string: " + prefixAtOffset, "", offset));
				break;
			}
			default: {
				map.put(null, new CommonNonProposal("no completion exists for " + tokenKind + ": " + prefixAtOffset, "", offset));
			}
		}
	}

	/**
	 * Return the feature target types for which astNode is or could be the target.
	 * The return value is a map of which the keys are probably all that is useful.
	 * The list of features that require that key provides an opportunity to filter
	 * the usages, noting that the features may well involve generic types, which
	 * have been resolved for use as a key. 
	 */
	protected Map<EClassifier, List<EStructuralFeature>> computeUsage(EObject astNode) {
		Map<EClassifier, List<EStructuralFeature>> usages = new HashMap<EClassifier, List<EStructuralFeature>>();
		Object rootAst = cstRoot.getAst();
		Resource resource = rootAst instanceof Resource ? (Resource)rootAst : null;
		if (resource == null)
			resource = astNode.eResource();
		Collection<EStructuralFeature.Setting> settings = EcoreUtil.UsageCrossReferencer.find(astNode, resource);
		for (EStructuralFeature.Setting setting : settings)
			addUsage(usages, setting.getEObject(), setting.getEStructuralFeature());
		EStructuralFeature containingFeature = astNode.eContainingFeature();
		if ((containingFeature == null) && (astNode instanceof EPackage))			// Provide a plausible containment feature
			containingFeature = EcorePackage.Literals.EPACKAGE__ESUBPACKAGES;		//  for nodes at the root of the resource 
		if (containingFeature != null)
			addUsage(usages, astNode.eContainer(), containingFeature);
		return usages;
	}

	protected Object getAst(CSTNode cstNode) {
		if (cstNode == null)
			return null;
		Object astNode = cstNode.getAst();
		if ((astNode == null) && ((cstNode instanceof SimpleNameCS) || (cstNode instanceof PathNameCS))) {
			astNode = ((CSTNode) cstNode.eContainer()).getAst();
			if ((astNode != null) && proposalDebug.isActive())
				proposalDebug.println("Missing astNode deduced for " + astNode.getClass().getSimpleName());
		}
		return astNode;
	}

	public Set<EClass> getCompletableTypes(EClassifier requiredType, CSTNode cstNode) {
		Set<EClass> completableClasses = new HashSet<EClass>();
		if (requiredType instanceof EClass)
			completableClasses.add((EClass)requiredType);
		return completableClasses;
	}

	protected String getName(EObject eObject) {
		if (eObject instanceof ENamedElement)
			return ((ENamedElement) eObject).getName();
		else if (eObject instanceof IHasName)
			return ((IHasName)eObject).getName(); 
		else
			return null;
	}

	protected String getPrefix() {
		if (parseResult.isCompleteable(tokenAtOffset.getKind()))
			if ((tokenAtOffset.getStartOffset() <= offset) && (offset <= tokenAtOffset.getEndOffset() + 1))
				return getTokenAtOffsetString().substring(0, offset - tokenAtOffset.getStartOffset());
		return "";
	}

	/**
	 * Return the image to appear in the list of proposals for proposal.
	 * 
	 * @param labelProvider
	 * @param proposal
	 * @return
	 */
	protected Image getProposalDisplayImage(ILabelProvider labelProvider, EObject proposal) {
		return labelProvider.getImage(proposal);
	}

	/**
	 * Return the text to appear in the list of proposals for proposal for which newText is the replacement.
	 * 
	 * @param labelProvider
	 * @param proposal
	 * @param newText
	 * @return
	 */
	protected String getProposalDisplayText(ILabelProvider labelProvider, EObject proposal, String newText) {
		EObject container = proposal.eContainer();
		String containerText = EcoreUtils.qualifiedNameFor(container);
//		String containerText = labelProvider.getText(container);
		return newText + " - " + containerText;
	}

	/**
	 * Return the replacement text for proposal.
	 * 
	 * @param labelProvider
	 * @param proposal
	 * @return
	 */
	protected String getProposalReplacementText(EObject proposal) {
		return EcoreUtils.simpleNameFor(proposal);
	}

	/**
	 * Return the resources that may provide definitions to use in place of astNode
	 * as the target of requiredUsage.
	 */
	protected Collection<Resource> getResources(Map<EClassifier, List<EStructuralFeature>> usages, EObject astNode) {
		return parseResult.getResourcesVisibleAt(astNode);
	}
	
	protected IToken getToken() {
		AbstractParser parser = parseResult.getParser();
		DerivedPrsStream stream = parser.getIPrsStream();
		IToken errorToken = stream.getErrorTokenAtCharacter(offset);
		if (errorToken != null)
			return errorToken;
		int index = stream.getTokenIndexAtCharacter(offset);
		int tokenIndex = (index < 0 ? -(index - 1) : index);
		IToken token = stream.getIToken(tokenIndex);
		int previousIndex = stream.getPrevious(tokenIndex);
		IToken previousToken = stream.getIToken(previousIndex);
		int previousIndexKind = previousToken.getKind();
		boolean isIdentifier = parseResult.isIdentifier(previousIndexKind);
		boolean isKeyword = parseResult.isKeyword(previousIndexKind);
		boolean atEnd = offset == previousToken.getEndOffset() + 1;
		return ((isIdentifier || isKeyword) && atEnd) ? previousToken : token;
	}

	protected String getTokenAtOffsetString() {
		return tokenAtOffset instanceof ErrorToken ? "" : tokenAtOffset.toString();
	}

	/**
	 * Sort the computed proposals into the order in which they appear to the user.
	 */
	public ICompletionProposal[] sortProposals() {
		List<ICommonProposal> list = new ArrayList<ICommonProposal>(map.values());
		Collections.sort(list);
		return list.toArray(new ICommonProposal[list.size()]);
	}
}