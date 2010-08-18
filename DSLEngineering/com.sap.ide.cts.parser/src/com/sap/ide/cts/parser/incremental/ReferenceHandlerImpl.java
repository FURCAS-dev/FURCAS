package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import tcs.Alternative;
import tcs.ClassTemplate;
import tcs.ConditionalElement;
import tcs.FunctionTemplate;
import tcs.InjectorAction;
import tcs.InjectorActionsBlock;
import tcs.PrimitivePropertyInit;
import tcs.SequenceElement;
import textblocks.AbstractToken;
import textblocks.LexedToken;
import textblocks.TextBlock;
import textblocks.VersionEnum;

import com.sap.ide.cts.parser.Activator;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.ModelElementProxy;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.TbVersionUtil;
import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class ReferenceHandlerImpl implements ReferenceHandler {

	protected ObservableInjectingParser batchParser;
	private ITextBlocksTokenStream tbtokenStream;
	private Collection<AbstractToken> tokensForReferenceResolving = new ArrayList<AbstractToken>();
	private Collection<DelayedReference> newlyResolvableReferences = new ArrayList<DelayedReference>();

	public ReferenceHandlerImpl(ObservableInjectingParser batchParser,
		ITextBlocksTokenStream tbtokenStream) {
		super();
		this.batchParser = batchParser;
		this.tbtokenStream = tbtokenStream;
	}

	@Override
	public Object getFeatureValue(RefObject modelElement, String featureName) {
		try {
			return batchParser.getInjector().getModelAdapter().get(
					modelElement, featureName);
		} catch (ModelAdapterException e) {
			// TODO really log this error?
			Activator.logError(e);
			return null;
		}
	}

	@Override
	public void addNewlyResolvableReferences(DelayedReference delayedRef) {
		newlyResolvableReferences.add(delayedRef);
	}
	
	/**
	 * Registers tokens that might have an impact on the resolving of
	 * references.
	 */
	@Override
	public void registerTokenForReferenceResolving(AbstractToken subNode) {
		tokensForReferenceResolving.add(subNode);
	}
	
	@Override
	public void reset() {
		tokensForReferenceResolving.clear();
		newlyResolvableReferences.clear();
	}

	@Override
	public void setNewFeature(SetNewFeatureBean newFeatureBean,
			boolean assignToPartition) {
		IncrementalParsingUtil.setNewFeature(newFeatureBean, batchParser
				.getInjector(), assignToPartition);
	}

	@Override
	public void unsetFeature(SetNewFeatureBean featureBean) {
		batchParser.getInjector().unset(featureBean.parentRefObject,
				featureBean.property, featureBean.value);
	}

	@Override
	public void setNewPrimitiveFeature(TextBlockProxy newVersion,
			TextBlock oldVersion, AbstractToken subNode) {
		IncrementalParsingUtil.setNewPrimitiveFeature(newVersion, oldVersion,
				subNode, batchParser.getInjector());
	}

	@Override
	public void unsetPrimitiveFeature(TextBlock oldVersion, LexedToken lt) {
		IncrementalParsingUtil.unsetPrimitiveFeature(oldVersion, lt,
				batchParser.getInjector());
	}
	
	@Override
        public void unsetFeature(TextBlock oldVersion, TextBlock tb) {
                IncrementalParsingUtil.unsetFeature(oldVersion, tb,
                                batchParser.getInjector());
        }

	@Override
	public void reEvaluatePropertyInits(TextBlock oldVersion,
			TextBlockProxy newVersion) {
		if (oldVersion.getCorrespondingModelElements().size() > 0) {
			RefObject modelElement = oldVersion.getCorrespondingModelElements()
					.iterator().next();
			if (newVersion.getCorrespondingModelElementProxies().size() > 0) {
				ModelElementProxy proxy = (ModelElementProxy) newVersion
						.getCorrespondingModelElementProxies().iterator().next();
				// first find out which alternatives have been chosen by
				// walking through all tokens and getting the alternatives
				// from the attached sequence elements
				HashSet<InjectorActionsBlock> actionBlocks = new HashSet<InjectorActionsBlock>();
				for (Object subNode : newVersion.getSubNodes()) {
					if (subNode instanceof LexedToken) {
						LexedToken lexedToken = (LexedToken) subNode;
						SequenceElement seqEl = lexedToken.getSequenceElement();
						while (seqEl != null
								&& !(seqEl.getElementSequence()
										.refImmediateComposite() instanceof ClassTemplate || seqEl
										.getElementSequence()
										.refImmediateComposite() instanceof FunctionTemplate)) {
							SequenceElement parentSequenceElement = TcsUtil
									.getContainerSequenceElement(seqEl);
							if (parentSequenceElement instanceof Alternative
									|| parentSequenceElement instanceof ConditionalElement) {
								actionBlocks.addAll(TcsUtil
										.getInjectorActions(seqEl
												.getElementSequence()));
								seqEl = parentSequenceElement;
							} else {
								break;
							}
						}
					}
				}
				for (InjectorActionsBlock injectorActionsBlock : actionBlocks) {
					for (InjectorAction injectorAction : injectorActionsBlock
							.getInjectorActions()) {
						if (injectorAction instanceof PrimitivePropertyInit) {
							PrimitivePropertyInit init = (PrimitivePropertyInit) injectorAction;

							String name = init.getPropertyReference()
									.getStrucfeature().getName();
							try {
								modelElement.refGetValue(name);
								List<Object> value = proxy.getAttributeMap().get(
									name);
								if (value != null && value.size() > 0) {
									batchParser.getInjector().set(modelElement,
											name, value.iterator().next());
								} else {
									batchParser.getInjector().unset(modelElement,
											name, null);
								}
							} catch(InvalidCallException ex) {
								//do nothing just try to continue with next element.
							}
							
						}
					}
				}
			}
		}
	}
	
	/**
	 * Only resolve those references that were affected by this parse run. This
	 * may either by because they are contained in a new text block or the token
	 * that contains the value that was used to do the initial resolving
	 * changed.
	 */
	public void resolveRemainingReferences() {
		for (DelayedReference ref : new ArrayList<DelayedReference>(batchParser
				.getUnresolvedReferences())) {
			AbstractToken refToken = tbtokenStream
					.getTokenModelElementForParserToken(ref.getToken());
			ref.setTextBlock(refToken.getParentBlock());
			boolean resolveNewlyFromToken = tokensForReferenceResolving
					.contains(tbtokenStream
							.getTokenModelElementForParserToken(ref.getToken()));
			boolean newlyResolve = newlyResolvableReferences.contains(ref);
			if(ref.getType() == DelayedReference.TYPE_SEMANTIC_PREDICATE && refToken != null){
				if(TbVersionUtil.getOtherVersion(tbtokenStream
						.getTokenModelElementForParserToken(ref.getToken())
						.getParentBlock(), VersionEnum.REFERENCE) != null) {
					batchParser.removeUnresolvedReference(ref);
				}
			}
			else if (!newlyResolve && !resolveNewlyFromToken) {
				batchParser.removeUnresolvedReference(ref);
			} else {
				if (ref.getModelElement() instanceof IModelElementProxy) {
					IModelElementProxy proxy = (IModelElementProxy) ref
							.getModelElement();
					if (proxy.getRealObject() == null) {
						// proxy not resolved yet, this means that
						// only the reference changed and not the containing
						// model element
						// therefore re-use the old element from the textblock
						RefObject existingElement = TbUtil
								.getCreatedElement(refToken.getParentBlock());
						((ModelElementProxy) proxy)
								.setRealObject(existingElement);
					}
				}
				if (resolveNewlyFromToken) {
					// delete old reference first
					// TODO use reflective call on association proxy instead
					RefObject modelElement = null;
					if (ref.getModelElement() instanceof IModelElementProxy) {
						modelElement = (RefObject) ((IModelElementProxy) ref
								.getModelElement()).getRealObject();
					} else {
						modelElement = (RefObject) ref.getModelElement();
					}
					if (ref.getLookIn() != null) {
						// a lookIn means that the result was added to the
						// parent textblock.
						ModelElement me;
						boolean propertyIsAssocEnd = false;
						try {
							me = ((MofClass) modelElement.refMetaObject())
									.lookupElementExtended(ref
											.getPropertyName());
							if (me instanceof TypedElement) {
								TypedElement feature = (TypedElement) me;
								for (RefObject actualValue : refToken
										.getParentBlock()
										.getReferencedElements()) {
									try {
										if (actualValue.refIsInstanceOf(feature
												.getType(), true)) {
											batchParser.getInjector().unset(
													modelElement,
													ref.getPropertyName(),
													actualValue);
										}
									} catch (Exception ex) {
										// TODO find out which corresponding
										// element was the correct one
										// instead of trying this here
									}
								}
							}
						} catch (JmiException e) {
							propertyIsAssocEnd = true;
						} catch (NameNotFoundException e) {
							propertyIsAssocEnd = true;
						}
						if (propertyIsAssocEnd) {
							// try to find the association end and check there
							// if the correspondingmodelelement
							// is the correct one.
						}
					} else {
						if (refToken.getReferencedElements().size() > 0) {
							for (RefObject value : refToken
									.getReferencedElements()) {
							    try {
								batchParser.getInjector().unset(modelElement,
										ref.getPropertyName(), value);
							    } catch(Exception ex) {
							        // TODO find out which corresponding
                                                                // element was the correct one
                                                                // instead of trying this here
							    }
							}
						}
					}
				}
			}
		}
		List<DelayedReference> tmpUnresovedReferences = new ArrayList<DelayedReference>(batchParser.getUnresolvedReferences());
		batchParser.setDelayedReferencesAfterParsing();
		Iterator<DelayedReference> newRefIt = tmpUnresovedReferences
				.iterator();
		while (newRefIt.hasNext()) {
			DelayedReference ref = newRefIt.next();
			if (ref.getType() == DelayedReference.TYPE_SEMANTIC_PREDICATE &&
				ref.getRealValue() != null && ref.getRealValue() instanceof RefObject) {
				((LexedToken) tbtokenStream
						.getTokenModelElementForParserToken(ref.getToken()))
						.getParentBlock().getCorrespondingModelElements().add(
								(RefObject) ref.getRealValue());
			}
		}

		// for (DelayedReference ref : batchParser.getUnresolvedReferences()) {
		// GlobalDelayedReferenceResolver.getInstance()
		// .registerReferenceForIncrementalEvaluation(
		// ref,
		// (LexedToken) tbtokenStream
		// .getTokenModelElementForParserToken(ref
		// .getToken()), connection);
		// }
		// now all that is left to do is to resolve the proxy of the reference
		// to the previously
		// existing element!!!!
		// if(!batchParser.setDelayedReferencesAfterParsing()){
		// for (DelayedReference ref : batchParser.getUnresolvedReferences()) {
		// //
		// GlobalDelayedReferenceResolver.getInstance().registerUnresolvedReference(ref,
		// (LexedToken) tbtokenStream
		// // .getTokenModelElementForParserToken(ref.getToken()), true);
		// }
		// }
	}



}
