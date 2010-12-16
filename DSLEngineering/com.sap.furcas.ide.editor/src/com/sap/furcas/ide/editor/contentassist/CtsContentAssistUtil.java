package com.sap.furcas.ide.editor.contentassist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;


public class CtsContentAssistUtil {

	static Image keywordImage = null;
	static Image propertyImage = null;
	static Image propValueImage = null;
	static Image templateImage = null;
	static ITextViewer imageHostViewer = null;

	public static ICompletionProposal createProposal(String displayString,
			String replacementString, Image img, ITextViewer viewer, int line,
			int charPositionInLine, Token token) {

		int cursorPosition = getOffset(viewer, line, charPositionInLine);
		int replacementOffset = cursorPosition;
		int replacementLength = 0;

		if (token != null) {

			if (isInToken(line, charPositionInLine, token)) {
				replacementOffset = getOffset(viewer, getLine(token),
						getCharPositionInLine(token));

				replacementLength = Math.min(displayString.length(), Math.min(
						getLength(token), getCommonPrefix(token.getText(),
								replacementString).length()));
			} else {

				// TODO workaround because ANTRL will not create error token
				// for unlexed characters
				// TODO this assumes languages with standard whitespaces
				// filter by currently un-tokenized non-whitespace prefix

				int stopOffset = -1;

				// stop at end of last valid token
				if (getCharPositionInLine(token) != -1) {
					try {
						stopOffset = viewer.getDocument().getLineInformation(
								getLine(token)).getOffset()
								+ getCharPositionInLine(token);
					} catch (BadLocationException e) {
						// do nothing
					}
				}

				String prefix = "";

				try {
					prefix = computeNonWhitespacePrefix(viewer.getDocument()
							.get(), viewer.getDocument().getLineInformation(
							line).getOffset()
							+ charPositionInLine, stopOffset);
				} catch (BadLocationException e) {
					// do nothing
				}

				if (!prefix.isEmpty()) {

					replacementOffset = cursorPosition - prefix.length();
					replacementLength = Math.min(displayString.length(), Math
							.min(prefix.length(), getCommonPrefix(prefix,
									replacementString).length()));

				}

				// end workaround

			}

		}

		return new CompletionProposal(replacementString, replacementOffset,
				replacementLength, replacementString.length(), img,
				displayString, null, null);

	}

	/**
	 * computes the non-whitespace-prefix starting at the offset and going back
	 * until reaching stopOffset
	 * 
	 * @param documentContents
	 * @param offset
	 * @param stopOffset
	 * @return
	 */
	public static String computeNonWhitespacePrefix(String documentContents,
			int offset, int stopOffset) {

		String result = "";
		int curOffset = offset - 1;
		while (curOffset >= 0 && !(curOffset == stopOffset)
				&& !isWhitespace(documentContents.charAt(curOffset))) {
			result = documentContents.charAt(curOffset) + result;
			curOffset--;
		}

		return result;
	}

	private static boolean isWhitespace(char c) {
		return (c == ' ' || c == '\n' || c == '\r' || c == '\t');
	}

	public static String getCommonPrefix(String a, String b) {
		int prefixLength = 0;
		while (prefixLength < a.length() && prefixLength < b.length()) {
			if (a.regionMatches(0, b, 0, prefixLength + 1)) {
				prefixLength++;
			} else {
				break;
			}
		}
		return a.substring(0, prefixLength);
	}

	public static Image getKeywordImage(ITextViewer currentViewer) {
		if (imageHostViewer != currentViewer || keywordImage == null) {
			imageHostViewer = currentViewer;
			keywordImage = new Image(imageHostViewer.getTextWidget()
					.getDisplay(), CtsContentAssistUtil.class
					.getResourceAsStream("img/keyword.gif"));
		}

		return keywordImage;
	}

	public static Image getPropertyImage(ITextViewer currentViewer) {
		if (imageHostViewer != currentViewer || propertyImage == null) {
			imageHostViewer = currentViewer;
			propertyImage = new Image(imageHostViewer.getTextWidget()
					.getDisplay(), CtsContentAssistUtil.class
					.getResourceAsStream("img/property.gif"));
		}

		return propertyImage;
	}

	public static Image getPropValueImage(ITextViewer currentViewer) {
		if (imageHostViewer != currentViewer || propValueImage == null) {
			imageHostViewer = currentViewer;
			propValueImage = new Image(imageHostViewer.getTextWidget()
					.getDisplay(), CtsContentAssistUtil.class
					.getResourceAsStream("img/propValue.gif"));
		}

		return propValueImage;
	}

	public static Image getTemplateImage(ITextViewer currentViewer) {
		if (imageHostViewer != currentViewer || templateImage == null) {
			imageHostViewer = currentViewer;
			templateImage = new Image(imageHostViewer.getTextWidget()
					.getDisplay(), CtsContentAssistUtil.class
					.getResourceAsStream("img/template.gif"));
		}

		return templateImage;
	}

	public static ICompletionProposal createKeywordProposal(
			String displayString, String replacementString, ITextViewer viewer,
			int line, int charPositionInLine, Token token) {

		Image img = null;
		if (viewer != null && viewer.getTextWidget() != null) {
			img = getKeywordImage(viewer);
		}

		return createProposal(displayString, replacementString, img, viewer,
				line, charPositionInLine, token);
	}

	public static ICompletionProposal createPropValueProposal(
			String displayString, String replacementString, ITextViewer viewer,
			int line, int charPositionInLine, Token token) {

		Image img = null;
		if (viewer != null && viewer.getTextWidget() != null) {
			img = getPropValueImage(viewer);
		}

		return createProposal(displayString, replacementString, img, viewer,
				line, charPositionInLine, token);
	}

	public static ICompletionProposal createTemplateProposal(
			String displayString, String replacementString, ITextViewer viewer,
			int line, int charPositionInLine, Token token) {

		Image img = null;
		if (viewer != null && viewer.getTextWidget() != null) {
			img = getTemplateImage(viewer);
		}

		return createProposal(displayString, replacementString, img, viewer,
				line, charPositionInLine, token);
	}

	public static ICompletionProposal createPropertyProposal(
			String displayString, String replacementString, ITextViewer viewer,
			int line, int charPositionInLine, Token token) {

		Image img = null;
		if (viewer != null && viewer.getTextWidget() != null) {
			img = getPropertyImage(viewer);
		}

		return createProposal(displayString, replacementString, img, viewer,
				line, charPositionInLine, token);
	}

	public static List<ICompletionProposal> createFirstPossibleProposals(
			ConcreteSyntax syntax,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			ITextViewer viewer, int line, int charPositionInLine, Token token,
			TextBlocksModel tbModel) {
		List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();

		for (SequenceElement atomic : TcsUtil
				.getMainTemplatePossibleFirstAtomicSequenceElements(syntax,
						classTemplateMap)) {
			results.addAll(createProposalsFromAtomicSequenceElement(syntax,
					classTemplateMap, atomic, viewer, line, charPositionInLine,
					token, tbModel));
		}

		return results;
	}

	public static List<ICompletionProposal> createFollowProposalsFromContext(
			ConcreteSyntax syntax, CtsContentAssistContext context,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			ITextViewer viewer, int line, int charPositionInLine, Token token,
			TextBlocksModel tbModel) {
		List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();

		if (context == null) {
			return results;
		}

		for (SequenceElement atomic : TcsUtil.getPossibleAtomicFollows(context
				.getSequenceElement(), context.getParentFunctionCallStack(),
				classTemplateMap, context.getParentPropertyStack(), context
						.isOperator(), syntax)) {

			results.addAll(createProposalsFromAtomicSequenceElement(syntax,
					classTemplateMap, atomic, viewer, line, charPositionInLine,
					token, tbModel));
		}

		return results;
	}

	static int getOffset(ITextViewer viewer, int line, int charPositionInLine) {

		if (viewer != null) {

			try {
				return viewer.getDocument().getLineOffset(line)
						+ charPositionInLine;
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	static Template getParentTemplate(SequenceElement e, ConcreteSyntax syntax) {

		EObject parent = e.eContainer();
		while (parent != null && !(parent instanceof ConcreteSyntax)) {
			if (parent instanceof ClassTemplate
					|| parent instanceof OperatorTemplate
					|| parent instanceof FunctionTemplate) {
				return (Template) parent;
			} else {
				if (parent instanceof EObject) {
					EObject r = parent;
					parent = r.eContainer();
				} else {
					parent = null;
				}
			}
		}

		return TcsUtil.getMainClassTemplate(syntax);

	}

	static Alternative getParentAlternative(SequenceElement e) {

		EObject parent = e.eContainer();
		while (parent != null && !(parent instanceof ConcreteSyntax)) {
			if (parent instanceof Alternative) {
				return (Alternative) parent;
			} else {
				if (parent instanceof EObject) {
					EObject r = parent;
					parent = r.eContainer();
				} else {
					parent = null;
				}
			}
		}

		return null;

	}

	static boolean isContained(SequenceElement e,
			Set<SequenceElement> templateFirstAtomicSet) {
		if (e != null) {
			return templateFirstAtomicSet.contains(e);
		}

		return false;
	}

	private static Sequence getSequence(Template t) {
		if (t instanceof ClassTemplate) {
			ClassTemplate ct = (ClassTemplate) t;
			return ct.getTemplateSequence();
		}
		if (t instanceof OperatorTemplate) {
			OperatorTemplate ot = (OperatorTemplate) t;
			return ot.getOtSequence();
		}

		if (t instanceof FunctionTemplate) {
			FunctionTemplate ft = (FunctionTemplate) t;
			return ft.getFunctionSequence();
		}

		return null;
	}

	public static List<ICompletionProposal> createProposalsFromAtomicSequenceElement(
			ConcreteSyntax syntax,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			SequenceElement e, ITextViewer viewer, int line,
			int charPositionInLine, Token token, TextBlocksModel tbModel) {

		List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();

		if (e != null && syntax != null) {

			List<String> templateStrings = new ArrayList<String>();

			Template parentTemplate = getParentTemplate(e, syntax);
			Sequence parentSequence = getSequence(parentTemplate);
			Set<SequenceElement> templateFirstAtomicSet = new HashSet<SequenceElement>(
					TcsUtil.getPossibleFirstAtomicSequenceElements(
							parentSequence, classTemplateMap,
							new HashSet<Template>(), syntax));

			if (isContained(e, templateFirstAtomicSet)) {
				// add template proposals starting at the parent template
				templateStrings.addAll(generateFollowTemplateProposalStrings(
						parentSequence, classTemplateMap, syntax,
						new HashSet<Template>()));
			}

			Alternative parentAlternative = getParentAlternative(e);
			if (parentAlternative != null) {
				Set<SequenceElement> alternativeFirstAtomicSet = new HashSet<SequenceElement>(
						TcsUtil.getPossibleFirstAtomicSequenceElements(
								parentAlternative, classTemplateMap,
								new HashSet<Template>(), syntax));

				if (isContained(e, alternativeFirstAtomicSet)) {
					// add template proposals starting at each alternative
					for (Sequence s : parentAlternative.getSequences()) {
						templateStrings
								.addAll(generateFollowTemplateProposalStrings(
										s, classTemplateMap, syntax,
										new HashSet<Template>()));
					}
				}

			}

			for (String templateString : templateStrings) {
				// check if we actually have a template proposal and not
				// just a single keyword
				if (templateString.contains(" ")) {
					String displayString = templateString;
					String replacementString = displayString;
					results.add(createTemplateProposal(displayString,
							replacementString, viewer, line,
							charPositionInLine, token));
				}
			}

		}

		if (e instanceof LiteralRef) {
			LiteralRef lit = (LiteralRef) e;
			if (lit.getReferredLiteral() != null) {
				String literalValue = lit.getReferredLiteral().getValue();
				String displayString = literalValue;
				String replacementString = displayString;
				results.add(createKeywordProposal(displayString,
						replacementString, viewer, line, charPositionInLine,
						token));
			}
		} else if (e instanceof Property) {
			Property prop = (Property) e;

			assert (TcsUtil.isAtomic(prop, classTemplateMap));

			if (TcsUtil.isEnumeration(prop)) {
				// propose the enum values

				for (EnumLiteralMapping mapping : TcsUtil
						.getEnumTemplateForType(syntax, prop
								.getPropertyReference().getStrucfeature()
								.getEType())) {

					LiteralRef ref = (LiteralRef) mapping.getElement();
					if (ref.getReferredLiteral() != null) {
						String displayString = ref.getReferredLiteral()
								.getValue();
						String replacementString = displayString;
						results.add(createPropValueProposal(displayString,
								replacementString, viewer, line,
								charPositionInLine, token));
					}
				}
			}

			RefersToPArg refersToArg = TcsUtil.getRefersToPArg(prop);
			FilterPArg filterArg = TcsUtil.getFilterPArg(prop);
			QueryPArg queryArg = TcsUtil.getQueryPArg(prop);

			if (filterArg != null) {
				if (queryArg != null) {
					// first execute query, then apply invert OCL expression to
					// each result to generate proposal strings

					String invert = filterArg.getInvert();
					if (invert != null) {
						// if invert is null, we don't really know how to derive
						// the proposal string as the filter could be any OCL
						// expression using the ? placeholder

						List<EObject> oclElements = getQueryResult(viewer,
								line, charPositionInLine, tbModel, prop,
								queryArg);

						for (EObject refObj : oclElements) {
							String displayString = null;
							try {
								Object result = TcsUtil.executeOclQuery(refObj,
										invert, null, null, null);
								if (result instanceof String) {
									displayString = (String) result;
								}
							} catch (Exception e1) {
//								System.out
//										.println("Error executing invert-query: "
//												+ e1.getMessage());
							    //this is not necessarily an error
							    //as we investigate whether the current property fits the element
							    //if this is not the case this caught exception may occur
							}

							if (displayString != null) {
								String replacementString = displayString;
								results
										.add(createPropValueProposal(
												displayString,
												replacementString, viewer,
												line, charPositionInLine, token));
							}
						}
					}
				}
			}

			if (refersToArg != null) {

				if (queryArg != null) {
					// first execute query, then use refersTo property name to
					// generate proposal strings

					List<EObject> oclElements = getQueryResult(viewer, line,
							charPositionInLine, tbModel, prop, queryArg);

					for (EObject refObj : oclElements) {
						String displayString = refObj.eGet(refObj.eClass().getEStructuralFeature(
								refersToArg.getPropertyName())).toString();
						String replacementString = displayString;
						results.add(createPropValueProposal(displayString,
								replacementString, viewer, line,
								charPositionInLine, token));
					}

				} else {
					// propose referenced feature of model elements queried by
					// type
					EStructuralFeature propFeature = TcsUtil
							.getStructuralFeature(prop);
					if (propFeature != null) {
						String featureName = TcsUtil.getRefersToPArg(prop)
								.getPropertyName();
						List<String> propValues = TcsUtil.queryPropertyValues(
								propFeature.getEType(), featureName,
								prop.eResource().getResourceSet());

						for (String propValue : propValues) {
							String displayString = propValue;
							String replacementString = displayString;
							results.add(createPropValueProposal(displayString,
									replacementString, viewer, line,
									charPositionInLine, token));
						}

					}
				}
			}

			if (TcsUtil.isMultiValued(prop)) {
				// we have a multivalued primitive types property
				// name is likely to be plural so we add Entry to make the
				// proposal singular

				String displayString = TcsUtil.getPropertyName(prop
						.getPropertyReference())
						+ "Entry";
				String replacementString = displayString;
				results.add(createPropertyProposal(displayString,
						replacementString, viewer, line, charPositionInLine,
						token));
			} else {
				String displayString = TcsUtil.getPropertyName(prop
						.getPropertyReference());
				String replacementString = displayString;
				results.add(createPropertyProposal(displayString,
						replacementString, viewer, line, charPositionInLine,
						token));
			}

		}

		return results;
	}

	private static List<EObject> getQueryResult(ITextViewer viewer, int line,
			int charPositionInLine, TextBlocksModel textBlocksModel, Property prop,
			QueryPArg queryArg) {
	        TextBlocksModel currentTbModel = textBlocksModel;
		List<EObject> oclElements = new ArrayList<EObject>();
		TextBlock currentVersion = TbVersionUtil.getOtherVersion(currentTbModel.getRoot(),Version.CURRENT);
		if(currentVersion != null) {
                    currentTbModel = new TextBlocksModel(currentVersion, null);
		}
		// currentTbModel is non-null at this point
		if (currentTbModel.getRoot() != null) {
			AbstractToken floorToken = currentTbModel.getFloorTokenInRoot(getOffset(
					viewer, line, charPositionInLine));
			TextBlock parentBlock = floorToken.getParent();
			while (parentBlock != null
					&& parentBlock.getCorrespondingModelElements().size() < 1) {
				parentBlock = parentBlock.getParent();
			}

			if (parentBlock != null) {
				// we found a parent block with attached model
				// element(s)

				EObject element = parentBlock.getCorrespondingModelElements()
						.get(0);
				EObject contextElement = getContextElement(element,
						parentBlock, TcsUtil.getContextTag(queryArg.getQuery()));
				EObject foreachObject = getForeachElement(TcsUtil.getContextTag(queryArg.getQuery()));

				Object oclResult = null;

				try {
					// prefix is null as refersTo/query does not use
					// ? in query
					oclResult = TcsUtil.executeOclQuery(element, queryArg
							.getQuery(), contextElement, foreachObject, null);

				} catch (Exception e1) {
					System.out.println("Error executing ocl query: "
							+ e1.getMessage());
					// do nothing, just omit proposals
				}

				// create proposals for each returned element using
				// the refersTo structural feature
				if (oclResult instanceof EObject) {
					oclElements.add((EObject) oclResult);
				}
				if (oclResult instanceof Collection) {
					for (Object o : (Collection<?>) oclResult) {
						if (o instanceof EObject) {
							oclElements.add((EObject) o);
						}
					}
				}
			}
		}
		return oclElements;
	}

	private static EObject getForeachElement(String contextTag) {
	    // currently the ForeachElement is only used in queries of model elements without
		// syntactical elements and is thus currently irrelevant for content assist
		
		// once this changes a new testcase needs to be created and this implementation
		// can be derived from getContextElement()
		
		// do nothing
	    return null;
	}

	private static EObject getContextElement(EObject element,
			TextBlock parentBlock, String tag) {
		TextBlock curBlock = parentBlock;
		while (curBlock != null
				&& curBlock.getCorrespondingModelElements().size() > 0) {
			Template t = curBlock.getType().getParseRule();
			if (t instanceof ClassTemplate) {
				ClassTemplate ct = (ClassTemplate) t;
				if (TcsUtil.matchesContext(ct, tag)) {
					return curBlock.getCorrespondingModelElements().get(0);
				}
			}

			if (t instanceof OperatorTemplate) {
				OperatorTemplate ot = (OperatorTemplate) t;
				if (TcsUtil.matchesContext(ot, tag)) {
					return curBlock.getCorrespondingModelElements().get(0);
				}
			}

			curBlock = curBlock.getParent();
		}

		return null;
	}

	/**
	 * generate all possible template strings of this sequence
	 * 
	 * @param s
	 * @return
	 */
	static List<String> generateFollowTemplateProposalStrings(Sequence s,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			ConcreteSyntax syntax, HashSet<Template> visitedTemplates) {

		List<String> results = new ArrayList<String>();

		if (s == null) {
			return results;
		}

		results.add("");

		for (SequenceElement e : s.getElements()) {
			List<String> newResults = new ArrayList<String>();
			for (String result : results) {
				for (String templateProposal : generateFollowTemplateProposalStrings(
						e, classTemplateMap, syntax, new HashSet<Template>(
								visitedTemplates))) {
					String newResult = result + " " + templateProposal;
					newResults.add(newResult.trim());
				}
			}
			if (!newResults.isEmpty()) {
				results = newResults;
			}
		}

		return results;

	}

	/**
	 * generate all possible template strings of this sequence element
	 * 
	 * @param e
	 * @return
	 */
	static List<String> generateFollowTemplateProposalStrings(
			SequenceElement e,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			ConcreteSyntax syntax, HashSet<Template> visitedTemplates) {
		List<String> results = new ArrayList<String>();

		if (e == null) {
			results.add("");
			return results;
		}

		List<SequenceElement> firstElements = TcsUtil
				.getPossibleFirstAtomicSequenceElements(e, classTemplateMap,
						new HashSet<Template>(), syntax);
		if (!firstElements.contains(null)) {
			// we have a required SequenceElement

			// special handling of container sequence elements
			if (e instanceof Alternative) {
				Alternative alt = (Alternative) e;
				for (Sequence s : alt.getSequences()) {
					results.addAll(generateFollowTemplateProposalStrings(s,
							classTemplateMap, syntax, new HashSet<Template>(
									visitedTemplates)));
				}

				return results;
			}

			if (e instanceof ConditionalElement) {
				ConditionalElement cond = (ConditionalElement) e;
				results.addAll(generateFollowTemplateProposalStrings(cond
						.getThenSequence(), classTemplateMap, syntax,
						new HashSet<Template>(visitedTemplates)));
				results.addAll(generateFollowTemplateProposalStrings(cond
						.getElseSequence(), classTemplateMap, syntax,
						new HashSet<Template>(visitedTemplates)));

				return results;
			}

			if (e instanceof Block) {
				Block b = (Block) e;
				return generateFollowTemplateProposalStrings(b
						.getBlockSequence(), classTemplateMap, syntax,
						visitedTemplates);
			}

			if (e instanceof FunctionCall) {
				FunctionCall call = (FunctionCall) e;
				FunctionTemplate func = call.getCalledFunction();
				if (!visitedTemplates.contains(func)) {
					visitedTemplates.add(func);
					return generateFollowTemplateProposalStrings(func
							.getFunctionSequence(), classTemplateMap, syntax,
							visitedTemplates);
				}
			}

			if (e instanceof Property) {
				Property p = (Property) e;
				if (!TcsUtil.isAtomic(p, classTemplateMap)) {
					for (ClassTemplate ct : TcsUtil.getClassTemplates((EClass) TcsUtil
							.getType(p), TcsUtil.getMode(p), classTemplateMap,
							p.eResource().getResourceSet())) {
						HashSet<Template> subVisited = new HashSet<Template>(
								visitedTemplates);
						if (!subVisited.contains(ct)) {
							subVisited.add(ct);
							results
									.addAll(generateFollowTemplateProposalStrings(
											ct.getTemplateSequence(),
											classTemplateMap, syntax,
											subVisited));
						}
					}

					return results;
				}
			}

			// no composite
			String firstElemDisplayString = "";
			if (e instanceof LiteralRef) {
				LiteralRef ref = (LiteralRef) e;
				if (ref.getReferredLiteral() != null) {
					firstElemDisplayString = ref.getReferredLiteral()
							.getValue();
				}

			} else if (e instanceof Property) {
				Property prop = (Property) e;

				if (TcsUtil.isMultiValued(prop)) {
					firstElemDisplayString = TcsUtil.getPropertyName(prop
							.getPropertyReference())
							+ "Entry";

				} else {
					firstElemDisplayString = TcsUtil.getPropertyName(prop
							.getPropertyReference());
				}
			}

			results.add(firstElemDisplayString);

		}

		return results;
	}

	public static List<String> collectDisplayStrings(
			List<ICompletionProposal> proposals) {
		List<String> results = new ArrayList<String>();
		if (proposals != null) {

			for (ICompletionProposal p : proposals) {
				results.add(p.getDisplayString());
			}
		}
		return results;
	}

	public static List<String> collectDisplayStrings(
			ICompletionProposal[] proposals) {
		List<String> results = new ArrayList<String>();
		if (proposals != null) {

			for (ICompletionProposal p : proposals) {
				results.add(p.getDisplayString());
			}
		}

		return results;
	}

	static boolean isInToken(int line, int charPositionInLine, Token t) {
		if (line != getLine(t)) {
			return false;
		}

		if (charPositionInLine < getCharPositionInLine(t)) {
			return false;
		}

		if (charPositionInLine > getCharPositionInLine(t) + getLength(t)) {
			return false;
		}

		return true;
	}

	static int getAbsoluteOffset(ITextViewer viewer, int line,
			int charPositionInLine) throws BadLocationException {
		return viewer.getDocument().getLineInformation(line).getOffset()
				+ charPositionInLine;
	}

	static String getDocumentContents(ITextViewer viewer) {
		return viewer.getDocument().get();
	}

	static int getCharPositionInLine(Token token) {
		// ANTRL line positions start at 0
		return token.getCharPositionInLine();
	}

	static int getLine(Token token) {
		// ANTRL lines start at 1
		return token.getLine() - 1;
	}

	static int getLength(Token token) {
		int length = 0;
		if (token.getText() != null) {
			length = token.getText().length();
		}
		return length;
	}
	
	static boolean isContextAtWhitespace(ITextViewer viewer, CtsContentAssistContext context) throws BadLocationException {
		if (context != null) {
			if (context.getToken() != null) {
				String contents = getDocumentContents(viewer);
				int offset = getAbsoluteOffset(viewer, getLine(context.getToken()), getCharPositionInLine(context.getToken()));
				
				char c = contents.charAt(offset);
				if (isWhitespace(c)) {
					return true;
				}
			}
		}
		
		return false;
	}

	static void fixTokenText(ITextViewer viewer, Token t)
			throws BadLocationException {
		// assumes the tokens line and charPositionInLine point to its start
		// location

		String contents = getDocumentContents(viewer);
		int curOffset = CtsContentAssistUtil.getAbsoluteOffset(viewer,
				getLine(t), getCharPositionInLine(t));

		String newText = "";

		boolean firstWhitespace = true;

		while (curOffset < contents.length()) {
			char c = contents.charAt(curOffset);
			if (!isWhitespace(c)) {
				firstWhitespace = false;
				newText += c;
			} else {
				if (!firstWhitespace) {
					break;
				}

				// move token to the right or down
				if (c == ' ' || c == '\t') {
					t.setCharPositionInLine(t.getCharPositionInLine() + 1);
				}
				if (c == '\n') {
					t.setLine(t.getLine() + 1);
				}
			}
			curOffset++;
		}

		t.setText(newText);
	}

	/**
	 * 
	 * @param viewer
	 * @param offset
	 *            0..n-1
	 * @return
	 * @throws BadLocationException
	 */
	static int getLine(ITextViewer viewer, int offset)
			throws BadLocationException {
		return viewer.getDocument().getLineOfOffset(offset);
	}

	static boolean isAtEndOfToken(int line, int charPositionInLine, Token t) {
		if (line != getLine(t)) {
			return false;
		}

		if (charPositionInLine == getCharPositionInLine(t) + getLength(t)) {
			return true;
		}

		return false;
	}
}
