package com.sap.ide.cts.parser.incremental;

import static com.sap.ide.cts.parser.incremental.IncrementalParsingUtil.checkIsDefinedOptional;
import static com.sap.ide.cts.parser.incremental.IncrementalParsingUtil.deleteCorrespondingModelElements;
import static com.sap.ide.cts.parser.incremental.IncrementalParsingUtil.getOriginalVersion;

import java.util.ArrayList;
import java.util.Collection;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.ocl.utilities.TypedElement;

import com.sap.furcas.metamodel.TCS.Alternative;
import com.sap.furcas.metamodel.TCS.AndExp;
import com.sap.furcas.metamodel.TCS.AtomExp;
import com.sap.furcas.metamodel.TCS.ConditionalElement;
import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;
import com.sap.furcas.runtime.parser.textblocks.TextBlockFactory;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;
import com.sap.furcas.runtime.parser.textblocks.observer.TokenRelocationUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.ide.cts.parser.Activator;

/**
 * @see TextBlockReuseStrategy
 * @author C5106462
 * 
 */
public class TextBlockReuseStrategyImpl implements TextBlockReuseStrategy {

	private TextBlockFactory tbFactory;
	private ReferenceHandler referenceHandler;
	private final Lexer lexer;
	private ShortPrettyPrinter shortPrettyPrinter;
	private Collection<TextBlock> changedBlocks = new ArrayList<TextBlock>();

	public TextBlockReuseStrategyImpl(Lexer lexer, IModelElementInvestigator mi) {
		setModelElementInvestigator(mi);
		this.lexer = lexer;
	}

	public void setModelElementInvestigator(IModelElementInvestigator mi) {
		this.shortPrettyPrinter = new ShortPrettyPrinter(mi);
	}

	@Override
	public void setTextBlockFactory(TextBlockFactory factory) {
		tbFactory = factory;
	}

	@Override
	public void setReferenceHandler(ReferenceHandler handler) {
		this.referenceHandler = handler;
	}

	@Override
	public TbBean reuseTextBlock(TextBlock oldVersion, TextBlockProxy newVersion) {
		return reusetextBlockInteral(TbVersionUtil.getOtherVersion(oldVersion,
			Version.CURRENT), newVersion);
	}

	private TbBean reusetextBlockInteral(TextBlock oldVersion, TextBlockProxy newVersion) {

		// now check if textblock was changed
		if (TcsUtil.isReferenceOnly(newVersion.getTemplate())) {
			return handleReferenceOnlyTemplate(oldVersion, newVersion);
		} else if (isTBEqual(oldVersion, newVersion)) {
			//first see if different alternatives were chosen.
			handleAlternativeChoices(oldVersion, newVersion);
			int endIndex = 0;
			if (TbNavigationUtil.isUltraRoot(oldVersion)
				&& !(newVersion.getSubNodes().get(0) instanceof Bostoken)) {
				// need to add to index because ultra root has additinal
				// BOS token which might not be present in newVersion
				endIndex++;
			}
			// TODO check if this can be removed:
			referenceHandler.reEvaluatePropertyInits(oldVersion, newVersion);
			boolean valueChanged = false;
			for (Object subNode : newVersion.getSubNodes()) {
				if (subNode instanceof TextBlockProxy) {
					// check for subBlock if it can be re-used
					TextBlock original = getOriginalVersion(
						(TextBlockProxy) subNode, oldVersion);
					TbBean subNodeResult = reusetextBlockInteral(original,
						(TextBlockProxy) subNode);
					if (subNodeResult.isNew) {
						addToBlockAt(oldVersion, endIndex,
							subNodeResult.textBlock);
						// if the sub result is new then we have to add the
						// corresponding model elements
						// to the appropriate feature of the original
						// corresponding model element
						SetNewFeatureBean newFeatureBean = IncrementalParsingUtil
							.setFeatureWithNewValue(
								(TextBlockProxy) subNode,
								oldVersion);
						if (subNodeResult.reuseType
							.equals(ReuseType.DELETE)) {
							// Delete all blocks that are empty now
							Collection<EObject> affectedModelElements = IncrementalParsingUtil
								.deleteEmptyBlocksIncludingAdjecentBlocks(original);
							// delete all affected modelelements
							for (EObject refObject : affectedModelElements) {
								if (refObject.is___Alive()
									&& !isFromReferenceOnlyTemplate(subNodeResult.textBlock)) {
									refObject.refDelete();
								}
							}
							// this block
							// is under our control and therefore need
							// to be
							// deleted in this case
							// otherwise the client has to be
							// responsible for
							// dealing with these elements
							if (((EObject) original).is___Alive()
								&& TbNavigationUtil
									.getSubNodesSize(original) == 0) {
								// delete only if original subblock
								// is empty now
								deleteCorrespondingModelElements(
									newFeatureBean.parentRefObject,
									newFeatureBean.property,
									original, referenceHandler);
							}
						}
						IncrementalParsingUtil
							.deleteEmptyBlocksIncludingAdjecentBlocks(oldVersion);
						deleteElementsForRemovedSubBlocks(oldVersion);
						// ensure offset and length are correctly computed
						// for
						// the new node
						TokenRelocationUtil
							.makeRelativeOffsetRecursively(oldVersion);

						TbValidationUtil
							.assertTextBlockConsistency(oldVersion);

						if (newFeatureBean != null) {
							// it might be null in the case of operator
							// templates?
							referenceHandler
								.setNewFeature(
									newFeatureBean,
									TcsUtil
										.isReferenceOnly(subNodeResult.textBlock
											.getType()
											.getParseRule()));
						}
					}
				} else if (subNode instanceof AbstractToken) {
					// if it is an additional token it has to be added to the
					// reused textblock
					AbstractToken token = (AbstractToken) subNode;
					boolean wasReUsed = wasReUsed(token);

					valueChanged = valueChanged(token);
					if (!wasReUsed || valueChanged) {
						referenceHandler
							.registerTokenForReferenceResolving(token);
						referenceHandler.setNewPrimitiveFeature(newVersion,
							oldVersion, token);
					}
					if (!oldVersion.equals((token).getParent())) {
						// parent needs to be changed so move it to the new
						// block
						TokenRelocationUtil.relocateToken(token, endIndex,
							oldVersion);
					}
				}
				endIndex++;
			}

			for (DocumentNode node : TbNavigationUtil.getSubNodes(getOtherVersion(
				oldVersion, Version.REFERENCE))) {
				if (node instanceof LexedToken
					&& getOtherVersion(node, Version.PREVIOUS) == null
					&& (checkIsDefinedOptional((AbstractToken) node) || checkIsInAlternative((AbstractToken) node))) {
					// if the token was deleted a primitive value depending on
					// this value needs to be updated
					referenceHandler.setNewPrimitiveFeature(newVersion,
						oldVersion, (AbstractToken) node);
				}
			}
			if (oldVersion.getParent() != null) {
				// delete any non existent siblings
				IncrementalParsingUtil
					.deleteEmptyBlocksIncludingAdjecentBlocks(oldVersion
						.getParent());
				deleteElementsForRemovedSubBlocks(oldVersion.getParent());
			}
			IncrementalParsingUtil.deleteEmptyBlocksIncludingAdjecentBlocks(oldVersion);

			deleteElementsForRemovedSubBlocks(oldVersion);

			resolveProxies(oldVersion, newVersion);
			
			handleContextElements(oldVersion, newVersion);

			return new TbBean(oldVersion, false, ReuseType.COMPLETE);
		}
		// return new TbBean(tbCreator.createNewTextBlock(newVersion), true,
		// getReuseType(oldVersion, newVersion));
		TextBlock tb = tbFactory
			.createNewTextBlock(newVersion, oldVersion.getParent());
		changedBlocks.add(tb);
		if (!TbUtil.isEmpty(oldVersion)) {
			// old version still there to this was an insert case
			return new TbBean(tb, true, ReuseType.INSERT);
		} else {
			// old version is empty now so this was a delete case
			return new TbBean(tb, true, ReuseType.DELETE);
		}

	}

	/**
	 * Synchronizes the elements that reside in the #context of the {@link TextBlock}s.
	 * 
	 * @param oldVersion
	 * @param newVersion
	 */
	private void handleContextElements(TextBlock oldVersion, TextBlockProxy newVersion) {
	    // clear context
            oldVersion.getElementsInContext().clear();
            //add all elements that exists in the new version
            for (Object element : newVersion.getContextElements()) {
                if (element instanceof IModelElementProxy) {
                    element = ((IModelElementProxy) element).getRealObject();
                }
                if (element instanceof EObject) {
                    oldVersion.getElementsInContext().add((EObject) element);
                }
            }
	}

	private void handleAlternativeChoices(TextBlock oldVersion, TextBlockProxy newVersion) {
		// TODO Auto-generated method stub
		
	}

	private TbBean handleReferenceOnlyTemplate(TextBlock oldVersion, TextBlockProxy newVersion) {
		for (EObject ro : new ArrayList<EObject>(oldVersion.getParent()
			.getCorrespondingModelElements())) {
			for (EObject value : new ArrayList<EObject>(oldVersion
				.getReferencedElements())) {
				try {
					SetNewFeatureBean bean = new SetNewFeatureBean(ro,
						((Property) oldVersion.getSequenceElement())
							.getPropertyReference().getStrucfeature()
							.getName(), value, 0);
					referenceHandler.unsetFeature(bean);
					oldVersion.getReferencedElements().remove(ro);
				} catch (Exception e) {
					continue;
				}
			}
		}
		TextBlock tb = tbFactory
			.createNewTextBlock(newVersion, oldVersion.getParent());
		changedBlocks.add(tb);
		if (!TbUtil.isEmpty(oldVersion)) {
			// old version still there to this was an insert case
			return new TbBean(tb, true, ReuseType.INSERT);
		} else {
			// old version is empty now so this was a delete case
			return new TbBean(tb, true, ReuseType.DELETE);
		}
	}

	private boolean isFromReferenceOnlyTemplate(TextBlock textBlock) {
		if (textBlock.getType() != null && textBlock.getType().getParseRule() != null) {
			Template parseRule = textBlock.getType().getParseRule();
			return TcsUtil.isReferenceOnly(parseRule);
		}
		return false;
	}

	private boolean valueChanged(AbstractToken token) {
		boolean valueChanged;
		AbstractToken referenceVersion = TbVersionUtil.getOtherVersion(token,
			Version.REFERENCE);
		valueChanged = referenceVersion == null
			|| !getSynchronizedValue(referenceVersion).equals(
				getSynchronizedValue(token));
		return valueChanged;
	}

	/**
	 * Checks whether the given model element token could be re-used.
	 * 
	 * @param nextToken
	 * @return
	 */
	public boolean canBeReUsed(AbstractToken candidate, Object lexerToken) {
	        if(!Version.PREVIOUS.equals(candidate.getVersion())) {
	            throw new IllegalArgumentException("Candidate token has to be in PREVIOUS Version but was: " + candidate.getVersion());
	        }
		Token nextToken = (Token) lexerToken;
		boolean typeEquals = nextToken.getType() == candidate.getType();
		if (!typeEquals) {
			// if the type is not equal the token may still be part of
			// an isDefined Alternative which qualifies for reuse
			typeEquals = checkIsDefinedAlternative(candidate, nextToken);
		}
		// AbstractToken reference = TbVersionUtil.getOtherVersion(candidate,
		// Version.REFERENCE);
		boolean contentEquals = compareContentForReuse(candidate, lexerToken);// nextToken.getText().equals(reference.getValue());
		boolean stateEquals = true; // TODO antlr has no explicit states, so
		// what to do here?
		boolean multipleReusePossibilityCheck = true;
		String candidateValue = getSynchronizedValue(candidate);
		if (candidateValue.indexOf(nextToken.getText()) != candidateValue
			.lastIndexOf(nextToken.getText())) {
			// ok now we have a problem. The value that could be reused occurs
			// more than once within the changed PREVIOUS token.
			// TODO Which one are we going to re-use?
			// Current heuristic:
			// Reuse the last possible one
			multipleReusePossibilityCheck = ((ANTLR3LocationToken) nextToken)
				.getStartIndex() == candidateValue.lastIndexOf(nextToken.getText());
		}

		return typeEquals && contentEquals && stateEquals && multipleReusePossibilityCheck;
	}

	/**
	 * Checks the case if an alternative from then-->else (or vice-versa) was done for the given
	 * <tt>candidate</tt>.
	 * 
	 * E.g.: ...(isDefined(output) ? output {{ ownedTypeDefinitions = lookIn('output') }}
	 * :"void") ... Change from "String" (1st alternative) to "void" 2nd alternative.
	 * 
	 * Will result in true if the <tt>nextToken</tt> is a valid alternative to the given
	 * <tt>candidate</tt>.
	 * 
	 * @param candidate
	 * @param nextToken
	 * @return
	 */
	private boolean checkIsDefinedAlternative(AbstractToken candidate, Token nextToken) {
		if (candidate instanceof LexedToken) {
			LexedToken lexedToken = (LexedToken) candidate;
			SequenceElement se = lexedToken.getSequenceElement();
			if (se != null) {
				// now check if it is contained within a isDefined clause
				// TODO maybe this has to be done recursively ascending?
				SequenceElement parent = TcsUtil.getContainerSequenceElement(se);
				if (parent != null) {
					if (parent instanceof ConditionalElement) {
						ConditionalElement conditional = (ConditionalElement) parent;
						SequenceElement otherAlternative = null;
						if (conditional.getThenSequence().getElements()
							.contains(se)) {
							if (conditional.getElseSequence() != null
								&& conditional.getElseSequence()
									.getElements().size() > 0) {
								otherAlternative = conditional
									.getElseSequence()
									.getElements().iterator()
									.next();
							}
						} else {
							otherAlternative = conditional
								.getThenSequence().getElements()
								.iterator().next();
						}
						if (otherAlternative instanceof LiteralRef) {
							LiteralRef literalRef = (LiteralRef) otherAlternative;
							Token literalToken = createLexerToken(literalRef
								.getReferredLiteral().getValue());
							return literalToken.getType() == nextToken
								.getType();
						} else if (otherAlternative instanceof Property) {
							if (conditional.getCondition() instanceof AndExp) {
								AtomExp first = ((AndExp) conditional
									.getCondition())
									.getExpressions()
									.iterator().next();
								// Reuse the token if it was used as
								// within an
								// isDefined alternative where the
								// argument
								// of isDefined is the same the
								// referred
								// property.
								return ((Property) otherAlternative)
									.getPropertyReference()
									.getStrucfeature()
									.equals(
										first
											.getPropertyReference()
											.getStrucfeature());
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 *TODO this is only an initial version and needs to be improved currently a tb is
	 * considered to be re-used if all tokens were in the same tb before
	 */
	private boolean isTBEqual(TextBlock oldVersion, TextBlockProxy newVersion) {
		if (oldVersion != null && oldVersion.getType() != null
			&& oldVersion.getType().getParseRule() != null) {
			if (newVersion.getTemplate() != null) {
				// ensure templates were the same
				if (newVersion.getTemplate().equals(
					oldVersion.getType().getParseRule())) {
					if (newVersion.getTemplate().getMetaReference() instanceof StructureType) {
						// a structure type has no identity so we have to
						// re-create it every time
						return false;
					}
					// if(TcsUtil.isReferenceOnly(newVersion.getTemplate())) {
					// //a reference only textblock does not need to be retained
					// return false;
					// }
					// // if there is a difference in token size the tb has
					// // changed!
					// if (TbNavigationUtil.getSubNodesSize(oldVersion) !=
					// newVersion
					// .getSubNodes().size()) {
					// // TODO check only non omitted token here!
					// return false;
					// }
					boolean canBeReused = true;
					ArrayList<LexedToken> newTokens = new ArrayList<LexedToken>();
					boolean containsTokens = false;
					for (Object subNode : newVersion.getSubNodes()) {
						if (subNode instanceof LexedToken) {
							containsTokens = true;
							LexedToken lexedToken = (LexedToken) subNode;
							// IF there is a token that was not there
							// before
							if (TbVersionUtil.getOtherVersion(
								lexedToken, Version.REFERENCE) == null) {
								// if the token is not an optional
								// token
								// the textblock changed
								newTokens.add(lexedToken);
								if (lexedToken.getSequenceElement() != null) {
									canBeReused &= checkIsDefinedOptional(lexedToken)
										|| checkIsInCollectionFeature(lexedToken)
										|| isSeparator(lexedToken)
										|| checkIsInAlternative(lexedToken);
								} else {
									Activator
										.logWarning("Token "
											+ lexedToken
											+ " has no referrenced"
											+ " SequenceElement set. Incremental parsing might not work correctly!"
											+ "Check for inconsistent parser & mapping model for language:"
											+ newVersion
												.getTemplate()
												.getConcreteSyntax()
												.getName());
								}
							}
						}
					}
					ArrayList<LexedToken> oldTokens = new ArrayList<LexedToken>();
					if (getOtherVersion(oldVersion, Version.REFERENCE) != null) {
						for (Object subNode : getOtherVersion(oldVersion,
							Version.REFERENCE).getSubNodes()) {
							if (subNode instanceof LexedToken) {
								// IF there is a token that was
								// there before
								if (TbVersionUtil.getOtherVersion(
									(AbstractToken) subNode,
									Version.CURRENT) == null) {
									// if the token is not an
									// optional token
									// the textblock changed
									oldTokens
										.add((LexedToken) subNode);
									canBeReused &= checkIsDefinedOptional((AbstractToken) subNode)
										|| checkIsInCollectionFeature((AbstractToken) subNode)
										|| isSeparator((AbstractToken) subNode)
										|| checkIsInAlternative((AbstractToken) subNode);
								}
							}
						}
					}
					if (!containsTokens) {
						// The TB does not have any tokens itself, so make
						// its reuse dependent on its inner TBs.
						canBeReused = false;
						for (Object subNode : newVersion.getSubNodes()) {
							if (subNode instanceof TextBlockProxy) {
								TextBlock original = getOriginalVersion(
									(TextBlockProxy) subNode,
									oldVersion);
								canBeReused |= isTBEqual(original,
									(TextBlockProxy) subNode);
							}

						}

					}
					if (newTokens.size() == getTokenSize(newVersion)
						&& getTokenSize(oldVersion) > newTokens.size()) {
						// there are ONLY new tokens in the new block AND
						// there are still tokens in the oldVersion block
						// so oldVersion block will be reused later and a
						// newVersion block should be considered as new
						return false;
					}
					if (!canBeReused) {
					        if(oldTokens.size() > 0) {
        						// if only tokens were replaced by new ones that
        						// have the
        						// same referenced SequenceElement the TextBlock can
        						// be reused
        						boolean sequenceElementsEqual = true;
        						int i = 0;
        						for (LexedToken oldToken : oldTokens) {
        							if (i < newTokens.size()) {
        								LexedToken newTok = newTokens
        									.get(i);
        								if(newTok.isOperator() && oldToken.isOperator()) {
        								    //both are operators of the same operator template
        								    //reuse should be no problem here.
        								    sequenceElementsEqual &= true;
        								} else {
        								    sequenceElementsEqual &= newTok
        									.getSequenceElement() != null
        									&& newTok
        										.getSequenceElement()
        										.equals(
        											oldToken
        												.getSequenceElement());
        								}
        							} else {
        								sequenceElementsEqual = false;
        								break;
        							}
        							i++;
        						}
        						return sequenceElementsEqual;
					        } else {
					            return false;
					        }
					} else {
						return true;
					}
				}
			}
		}// if the templates do not match
		// the tb changed!
		return false;
	}

	private int getTokenSize(TextBlockProxy newVersion) {
		int size = 0;
		for (Object subNode : newVersion.getSubNodes()) {
			if (subNode instanceof LexedToken) {
				size++;
			}
		}
		return size;
	}
	
	private int getTokenSize(TextBlock tb) {
		int size = 0;
		for (Object subNode : tb.getTokens()) {
			if (subNode instanceof LexedToken) {
				size++;
			}
		}
		return size;
	}

	/**
	 * Separators never contribute to equality. So this will return true if the given token was
	 * created from a separator sequence element.
	 * 
	 * @param lexedToken
	 * @return
	 */
	private boolean isSeparator(AbstractToken candidate) {
		if (candidate instanceof LexedToken) {
			LexedToken lexedToken = (LexedToken) candidate;
			SequenceElement se = lexedToken.getSequenceElement();
			if (se != null && se instanceof LiteralRef) {
				return se.getElementSequence().getSeparatorContainer() != null;
			}
		}
		return false;
	}

	private boolean checkIsInAlternative(AbstractToken candidate) {
		if (candidate instanceof LexedToken) {
			LexedToken lexedToken = (LexedToken) candidate;
			SequenceElement se = lexedToken.getSequenceElement();
			if (se != null) {
				// now check if it is contained within a isDefined clause
				// TODO maybe this has to be done recursively ascending?
				SequenceElement parent = TcsUtil.getContainerSequenceElement(se);
				if (parent != null) {
					// TODO check if original element waas in other alternative
					if (parent instanceof Alternative) {
						return true;
					} else if (parent instanceof ConditionalElement) {
						SequenceElement parentParent = TcsUtil
							.getContainerSequenceElement(parent);
						if (parentParent instanceof Alternative) {
							return true;
						}
					}
				}
			}
			return false;
		}
		return false;
	}

	/**
	 * Checks whether the given token refers to a sequence element which is a {@link Property}
	 * and that refers to a 0..1, 0..n or 1..n property. That indicates that the token may
	 * represent an additional element in this list.
	 * 
	 * @param candidate
	 * @return
	 */
	private boolean checkIsInCollectionFeature(AbstractToken candidate) {
		if (candidate instanceof LexedToken) {
			LexedToken lexedToken = (LexedToken) candidate;
			SequenceElement se = lexedToken.getSequenceElement();
			if (se != null) {
				if (se instanceof Property
					&& ((Property) se).getPropertyReference() != null
					&& ((Property) se).getPropertyReference().getStrucfeature() != null) {
					ETypedElement te = ((Property) se).getPropertyReference()
						.getStrucfeature();
					if (te instanceof EReference) {
						return ((EReference) te).getLowerBound() == 0
							|| ((EReference) te).getUpperBound() > 1;
					} else if (te instanceof EStructuralFeature) {
						return ((EStructuralFeature) te).getLowerBound() == 0
							|| ((EStructuralFeature) te)
								.getUpperBound()> 1;
					}
				}
			}
		}
		return false;
	}

	private boolean compareContentForReuse(AbstractToken candidate, Object lexerToken) {
		// TODO Improve Heuristic: If the old text is still contained within the
		// token and the current lexerToken has a different value
		// consider it not reuseable as this meant an insert before and a later
		// lexerToken may come that matches this part better.
		// However, this might not always work. Find those cases and add
		// additional heuristics for them
		AbstractToken reference = TbVersionUtil.getOtherVersion(candidate,
			Version.REFERENCE);

		String candidateValue = getSynchronizedValue(candidate);
		String referenceValue = getSynchronizedValue(reference);
		if (candidateValue.contains(((Token) lexerToken).getText())) {
			if (reference == null) {
				// no reference version so it can always be reused
				return true;
			}
			if (referenceValue.equals(((Token) lexerToken).getText())) {
				// reference value and new value correspond so re-use
				return true;
			}
			Token nextToken = createLexerToken(candidateValue);
			while (!nextToken.equals(Token.EOF_TOKEN)) {
				// subtokens.add(nextToken);
				if (nextToken.getText().equals(referenceValue)) {
					// reference value still contained in token so wait until we
					// get there
					return false;
				}
				nextToken = lexer.nextToken();
			}
			// reference value not contained in token so this was a rename
			return true;
		} else {
			// this is the case when the whole token value was replaced by a
			// different value
			return true;
		}
	}

	private String getSynchronizedValue(AbstractToken candidate) {
		if (candidate == null) {
			return null;
		}
		String candidateValue = candidate.getValue();
		if (candidateValue == null) {
			candidateValue = shortPrettyPrinter.resynchronizeToEditableState(candidate);
		}
		return candidateValue;
	}

	private Token createLexerToken(String value) {
		lexer.reset();
		lexer.setCharStream(new ANTLRStringStream(value));
		// Collection<Token> subtokens = new ArrayList<Token>();
		Token nextToken = lexer.nextToken();
		return nextToken;
	}

	/**
	 * Assuming that the oldVersion will be reused and therefore all elements within
	 * {@link DocumentNode#getCorrespondingModelElements()} have their correspondents within
	 * {@link TextBlockProxy#getCorrespondingModelElementProxies()} of the new version. Therefore the
	 * proxies will be set resolved with the elements from the old version.
	 * 
	 * The same applies for the {@link TextBlock#getReferencedModelElements() {
	 * @link TextBlockProxy#getReferencedElements()()}
	 * 
	 * @param oldVersion
	 * @param newVersion
	 */
	private void resolveProxies(TextBlock oldVersion, TextBlockProxy newVersion) {
		int i = 0;
		for (EObject ro : oldVersion.getCorrespondingModelElements()) {
			if (newVersion.getCorrespondingModelElementProxies().size() >= i + 1) {
				ModelElementProxy proxy = (ModelElementProxy) newVersion
					.getCorrespondingModelElementProxies().get(i);
				proxy.setRealObject(ro);
			} else {
				break;
			}
			i++;
		}
		i = 0;
		for (EObject ro : oldVersion.getReferencedElements()) {
			if (newVersion.getReferencedElementProxies().size() >= i + 1) {
				ModelElementProxy proxy = (ModelElementProxy) newVersion
					.getReferencedElementProxies().get(i);
				proxy.setRealObject(ro);
			} else {
				break;
			}
			i++;
		}
	}

        /**
         * Delete if there is no current version and the template was not reference
         * only.
         * 
         * @param oldVersion
         */
        private void deleteElementsForRemovedSubBlocks(TextBlock oldVersion) {
            if (oldVersion.is___Alive()) {
                TextBlock reference = TbVersionUtil.getOtherVersion(oldVersion,
                        Version.REFERENCE);
                if (reference != null) {
                    for (TextBlock tb : reference.getSubBlocks()) {
                        // delete if there is no current version and the template
                        // was
                        // not reference only
                        if (TbVersionUtil.getOtherVersion(tb, Version.CURRENT) == null) {
                            deleteElementsForRemovedSubBlocks(tb);
                            if (tb.getReferencedElements().size() > 0
                                    && tb.getSequenceElement() instanceof Property) {
                                for (EObject ro : new ArrayList<EObject>(tb
                                        .getCorrespondingModelElements())) {
                                    for (EObject value : new ArrayList<EObject>(
                                            tb.getReferencedElements())) {
                                        try {
                                            SetNewFeatureBean bean = new SetNewFeatureBean(
                                                    ro, ((Property) oldVersion
                                                            .getSequenceElement())
                                                            .getPropertyReference()
                                                            .getStrucfeature()
                                                            .getName(), value, 0);
                                            referenceHandler.unsetFeature(bean);
                                        } catch (Exception ex) {
                                            // do nothing just try next
                                            // element
                                        }
                                    }
                                }
                            }
                            if (tb.getType() != null
                                    && tb.getType().getParseRule() != null) {
                                if (!TcsUtil.isReferenceOnly(tb.getType()
                                        .getParseRule())) {
                                    // FIXME: Delete only the first element as
                                    // this is
                                    // the one the tb is responsible for
                                    // However, this should be separated by
                                    // having a
                                    // separate assoc for
                                    // responsible elements and such elements
                                    // that were
                                    // resolved from somewhere else,
                                    // such as property inits
                                    for (EObject ro : new ArrayList<EObject>(tb
                                            .getCorrespondingModelElements())) {
                                        if (((EObject) ro).is___Alive()) {
                                            ro.refDelete();
                                        }
                                    }
                                } else {
                                    // Only unset features that are at the
                                    // boundary to referenceOnly elements
                                    if (!TcsUtil.isReferenceOnly(reference
                                            .getType().getParseRule())) {
    
                                    }
                                }
                            }
                        }
                    }
                    for (AbstractToken tb : reference.getTokens()) {
                        // unset the corresponding value of the token if there is no
                        // current
                        // version
                        if (tb instanceof LexedToken
                                && TbVersionUtil.getOtherVersion(tb,
                                        Version.CURRENT) == null) {
                            LexedToken lt = (LexedToken) tb;
                            if (lt.getCorrespondingModelElements().size() > 0
                                    && lt.getSequenceElement() instanceof Property) {
                                referenceHandler.unsetPrimitiveFeature(oldVersion,
                                        lt);
                            }
                            if (lt.getReferencedElements().size() > 0
                                    && lt.getSequenceElement() instanceof Property) {
                                referenceHandler.unsetPrimitiveFeature(oldVersion,
                                        lt);
                            }
                        }
                    }
                }
            }
        }

	/**
	 * Cheks whether the token was reused or not.
	 * 
	 * @param subNode
	 * @param oldVersion
	 * @return
	 */
	private boolean wasReUsed(AbstractToken subNode) {
		AbstractToken refVersion = TbVersionUtil.getOtherVersion(subNode,
			Version.REFERENCE);
		if (refVersion != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void notifyTokenReuse(AbstractToken token) {
		if (!wasReUsed(token) || valueChanged(token)) {
			// register for references that may target the token
			this.referenceHandler.registerTokenForReferenceResolving(token);
		}
	}

	@Override
	public void clearChangedBlocksList() {
		changedBlocks.clear();
	}

	@Override
	public Collection<TextBlock> getChangedBlocks() {
		return changedBlocks;
	}

}
