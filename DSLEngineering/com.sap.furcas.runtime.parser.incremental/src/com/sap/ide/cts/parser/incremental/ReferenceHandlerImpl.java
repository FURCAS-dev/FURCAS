package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.ide.cts.parser.Activator;

public class ReferenceHandlerImpl implements ReferenceHandler {

	protected final ObservableInjectingParser batchParser;
	private final ITextBlocksTokenStream tbtokenStream;
	private final Collection<AbstractToken> tokensForReferenceResolving = new ArrayList<AbstractToken>();
	private final Collection<DelayedReference> newlyResolvableReferences = new ArrayList<DelayedReference>();

	public ReferenceHandlerImpl(ObservableInjectingParser batchParser,
		ITextBlocksTokenStream tbtokenStream) {
		super();
		this.batchParser = batchParser;
		this.tbtokenStream = tbtokenStream;
	}

	@Override
	public Object getFeatureValue(EObject modelElement, String featureName) {
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
			EObject modelElement = oldVersion.getCorrespondingModelElements()
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
										.eContainer() instanceof ClassTemplate || seqEl
										.getElementSequence()
										.eContainer() instanceof FunctionTemplate)) {
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

							EStructuralFeature feat = init.getPropertyReference()
									.getStrucfeature();
							modelElement.eGet(feat);
							List<Object> value = proxy.getAttributeMap().get(
								feat);
							if (value != null && value.size() > 0) {
								batchParser.getInjector().set(modelElement,
										feat.getName(), value.iterator().next());
							} else {
								batchParser.getInjector().unset(modelElement,
										feat.getName(), null);
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
	@Override
	public void resolveRemainingReferences() {
		for (DelayedReference ref : new ArrayList<DelayedReference>(batchParser
				.getUnresolvedReferences())) {
			AbstractToken refToken = tbtokenStream
					.getTokenModelElementForParserToken(ref.getToken());
			ref.setTextBlock(refToken.getParent());
			boolean resolveNewlyFromToken = tokensForReferenceResolving
					.contains(tbtokenStream
							.getTokenModelElementForParserToken(ref.getToken()));
			boolean newlyResolve = newlyResolvableReferences.contains(ref);
			if(ref.getType() == DelayedReference.TYPE_SEMANTIC_PREDICATE && refToken != null){
				if(TbVersionUtil.getOtherVersion(tbtokenStream
						.getTokenModelElementForParserToken(ref.getToken())
						.getParent(), Version.REFERENCE) != null) {
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
						EObject existingElement = TbUtil
								.getCreatedElement(refToken.getParent());
						((ModelElementProxy) proxy)
								.setRealObject(existingElement);
					}
				}
				if (resolveNewlyFromToken) {
					// delete old reference first
					// TODO use reflective call on association proxy instead
					EObject modelElement = null;
					if (ref.getModelElement() instanceof IModelElementProxy) {
						modelElement = (EObject) ((IModelElementProxy) ref
								.getModelElement()).getRealObject();
					} else {
						modelElement = (EObject) ref.getModelElement();
					}
					if (ref.getLookIn() != null) {
						// a lookIn means that the result was added to the
						// parent textblock.
						EModelElement me;
						boolean propertyIsAssocEnd = false;
						me = EcoreHelper.lookupElementExtended(
								modelElement.eClass(),
								ref.getPropertyName());
						if (me instanceof EStructuralFeature) {
							EStructuralFeature feature = (EStructuralFeature) me;
							for (EObject actualValue : refToken
									.getParent()
									.getReferencedElements()) {
								try {
									if (feature.getEType().isInstance(actualValue)) {
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
						if (propertyIsAssocEnd) {
						//TODO check for hiddenOpposite?
						// try to find the association end and check there
						// if the correspondingmodelelement
						// is the correct one.
						}
					} else {
						if (refToken.getReferencedElements().size() > 0) {
							for (EObject value : refToken
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
				ref.getRealValue() != null && ref.getRealValue() instanceof EObject) {
				((LexedToken) tbtokenStream
						.getTokenModelElementForParserToken(ref.getToken()))
						.getParent().getCorrespondingModelElements().add(
								(EObject) ref.getRealValue());
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
