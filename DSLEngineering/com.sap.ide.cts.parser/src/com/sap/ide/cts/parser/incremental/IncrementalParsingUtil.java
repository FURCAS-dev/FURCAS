package com.sap.ide.cts.parser.incremental;

import static com.sap.furcas.runtime.textblocks.TbVersionUtil.getOtherVersion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import tcs.AndExp;
import tcs.AtomExp;
import tcs.ConditionalElement;
import tcs.OperatorTemplate;
import tcs.Property;
import tcs.PropertyReference;
import tcs.SequenceElement;
import tcs.Template;
import textblocks.AbstractToken;
import textblocks.DocumentNode;
import textblocks.LexedToken;
import textblocks.OmittedToken;
import textblocks.TextBlock;
import textblocks.VersionEnum;

import com.sap.furcas.parsing.textblocks.observer.TextBlockProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.IModelInjector;
import com.sap.furcas.runtime.parser.exceptions.ModelCreationOntheFlyRuntimeException;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.TbVersionUtil;
import com.sap.ide.cts.parser.incremental.TextBlockReuseStrategy.ReuseType;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.textual.moinadapter.adapter.AdapterJMIHelper;
import com.sap.tc.moin.textual.moinadapter.adapter.AdapterJMIHelper.AssociationBean;

public class IncrementalParsingUtil {

	public static class CompositeRefAssociationBean {
	
		public CompositeRefAssociationBean(RefAssociation refAssoc,
				boolean isParentFirstEnd) {
			compositeFeatureAssoc = refAssoc;
			this.isParentFirstEnd = isParentFirstEnd;
		}
	
		public RefAssociation compositeFeatureAssoc;
		public boolean isParentFirstEnd;
	}

	/**
	 * Computes the re-use type relationship between the given {@link TextBlock oldVersion} and
	 * {@link TextBlockProxy newVersion} which may either be INSERT, MERGE, COMPLETE or DELETE.
	 * 
	 * @param oldVersion
	 * @param newVersion
	 * @return
	 */
	static ReuseType getReuseType(TextBlock oldVersion, TextBlockProxy newVersion) {
		ReuseType type = ReuseType.INSERT;
		boolean oldInbetween = false;
		for (Object subNode : newVersion.getSubNodes()) {
			if (subNode instanceof LexedToken) {
				if (TbVersionUtil.getOtherVersion((AbstractToken) subNode,
					VersionEnum.REFERENCE) != null) {
					oldInbetween = true;
				}
			} else if (subNode instanceof TextBlockProxy) {
				ReuseType subType = getReuseType(oldVersion,
					(TextBlockProxy) subNode);
				if (subType.equals(ReuseType.MERGE)
					|| subType.equals(ReuseType.COMPLETE)) {
					oldInbetween = true;
				}
			}
		}
		if (oldInbetween) {
			type = ReuseType.MERGE;
		}
		return type;
	}

	/**
	 *TODO this is only an initial version and needs to be improved currently a tb is
	 * considered to be re-used if all tokens were in the same tb before
	 */
	static boolean isTBEqual(TextBlock oldVersion, TextBlockProxy newVersion) {
		if (oldVersion != null && oldVersion.getType() != null
			&& oldVersion.getType().getParseRule() != null) {
			if (newVersion.getTemplate() != null) {
				// ensure templates were the same
				if (newVersion.getTemplate().equals(
					oldVersion.getType().getParseRule())) {
					// // if there is a difference in token size the tb has
					// // changed!
					// if (TbNavigationUtil.getSubNodesSize(oldVersion) !=
					// newVersion
					// .getSubNodes().size()) {
					// // TODO check only non omitted token here!
					// return false;
					// }
					for (Object subNode : newVersion.getSubNodes()) {
						if (subNode instanceof LexedToken) {
							// IF there is a token that was not there
							// before
							// the tb changed!
							if (TbVersionUtil.getOtherVersion(
								(AbstractToken) subNode,
								VersionEnum.REFERENCE) == null) {
								return false;
							}
						}
					}
					if (getOtherVersion(oldVersion, VersionEnum.REFERENCE) != null) {
						for (Object subNode : getOtherVersion(oldVersion,
							VersionEnum.REFERENCE).getSubNodes()) {
							if (subNode instanceof LexedToken) {
								// IF there is a token that was
								// there before and
								// was deleted
								// the tb changed!
								if (TbVersionUtil.getOtherVersion(
									(AbstractToken) subNode,
									VersionEnum.CURRENT) == null) {
									return false;
								}
							}
						}
					}
					return true;
				}
			}
		}// if the templates do not match
		// the tb changed!
		return false;
	}

	static AbstractToken firstToken(Object node) {
		while (!isToken(node) && node != null) {
			node = getSubNodeAt(((TextBlockProxy) node), 0);
		}
		return (AbstractToken) node;
	}

	static AbstractToken lastToken(Object node) {
		while (!isToken(node) && node != null) {
			node = getSubNodeAt(((TextBlockProxy) node), ((TextBlockProxy) node)
				.getSubNodes().size() - 1);
		}
		return (AbstractToken) node;
	}

	static Object getSubNodeAt(TextBlockProxy textBlockProxy, int i) {
		return textBlockProxy.getSubNodes().get(i);
	}

	static boolean isToken(Object node) {
		return node instanceof AbstractToken;
	}

	/**
	 * Sets the feature that holds the corresponding value of the elements that are stored in
	 * the correspondingmodel elements of the <code>newVersion</code> using the parent Element
	 * taken from the given <code>parentTextBlock</code>.
	 * 
	 * @param newVersion
	 * @param parentTextBlock
	 * @param modelInjector
	 * @return
	 */
	static SetNewFeatureBean setFeatureWithNewValue(TextBlockProxy newVersion,
		TextBlock parentTextBlock) {
		if (newVersion.getParent() != null) {
			int indexInCorrespondingElements = 0;
			for (IModelElementProxy parentProxy : newVersion.getParent()
				.getCorrespondingModelElementProxies()) {
				// first find corresponding attribute within parent proxy
				for (String key : ((ModelElementProxy) parentProxy)
					.getAttributeMap().keySet()) {
					int valueIndex = 0;
					for (Object value : ((ModelElementProxy) parentProxy)
						.getAttributeMap().get(key)) {
						for (IModelElementProxy proxy : newVersion
							.getCorrespondingModelElementProxies()) {
							if (proxy.equals(value)) {
								// found element to be replaced
								RefObject parentRefObject = getCorrespondingElement(
									newVersion.getParent(),
									proxy,
									key,
									indexInCorrespondingElements,
									parentTextBlock);
								if (parentRefObject != null) {
									return new SetNewFeatureBean(
										parentRefObject,
										key,
										proxy
											.getRealObject(),
										valueIndex);
								}
							}
						}
						for (IModelElementProxy proxy : newVersion
							.getReferencedElementProxies()) {
							if (proxy.equals(value)) {
								// found element to be replaced
								RefObject parentRefObject = getCorrespondingElement(
									newVersion.getParent(),
									proxy,
									key,
									indexInCorrespondingElements,
									parentTextBlock);
								if (parentRefObject != null) {
									return new SetNewFeatureBean(
										parentRefObject,
										key,
										proxy
											.getRealObject(),
										valueIndex);
								}
							}
						}
						valueIndex++;
					}
				}
				indexInCorrespondingElements++;
			}
		}
		return null;
	}

    static RefObject getCorrespondingElement(TextBlockProxy textblock, IModelElementProxy proxy, String propertyName,
	    int i, TextBlock parentBlock) {
	// TODO this is an initial implementation which might not be perfect
	// as it just takes the type of the element
	Collection<Classifier> metaClasses = new ArrayList<Classifier>();
	metaClasses.add(textblock.getTemplate().getMetaReference());
	for (Template additionalTempl : textblock.getAdditionalTemplates()) {
	    metaClasses.add(additionalTempl.getMetaReference());
	}

	for (RefObject element : parentBlock.getCorrespondingModelElements()) {
	    for (Classifier classifier : metaClasses) {
		if (element.refIsInstanceOf(classifier, true)) {
		    try {
			((MofClass) element.refMetaObject()).lookupElementExtended(propertyName);
			return element;
		    } catch (JmiException e) {
			continue;
		    } catch (NameNotFoundException e) {
			// not a reference or attribute; check for unexposed association end
			AssociationBean associationBean = AdapterJMIHelper.findAssociation(element, propertyName,
				element.get___Connection().getJmiHelper());
			if (associationBean == null) {
			    continue;
			} else {
			    return element;
			}
		    }
		}
	    }
	}
	return null;
    }

	static TextBlock getOriginalVersion(TextBlockProxy newVersion, TextBlock parent) {
		AbstractToken firstToken = firstToken(newVersion);
		AbstractToken tok = firstToken;
		AbstractToken lastToken = lastToken(newVersion);
		while (tok instanceof OmittedToken && !tok.equals(lastToken)) {
			tok = TbNavigationUtil.nextToken(tok);
		}
		if (tok instanceof OmittedToken) {
			throw new RuntimeException(
				"Found textblock with nothing but omitted tokens in it. This should never happen!");
		}
		TextBlock candidate = tok.getParentBlock();
		TextBlock result = candidate;
		;
		boolean onOffsetRange = TbUtil.getAbsoluteOffset(TbNavigationUtil
			.firstToken(candidate)) >= TbUtil.getAbsoluteOffset(firstToken(newVersion));
		while (candidate != null && onOffsetRange && !parent.equals(candidate)) {
			result = candidate;
			candidate = candidate.getParentBlock();
			onOffsetRange = TbUtil.getAbsoluteOffset(TbNavigationUtil
				.firstToken(candidate)) >= TbUtil
				.getAbsoluteOffset(firstToken(newVersion));
		}
		return result;
	}

	public static void setNewFeature(SetNewFeatureBean newFeatureBean, IModelInjector injector,
		boolean assignToPartition) {
		injector.set(newFeatureBean.parentRefObject, newFeatureBean.property,
			newFeatureBean.value, newFeatureBean.valueIndex);
		// as default assign elements to the same partition as parents
		if (newFeatureBean.value instanceof Partitionable && assignToPartition) {
			((Partitionable) newFeatureBean.parentRefObject).get___Partition()
				.assignElementIncludingChildren(
					(Partitionable) newFeatureBean.value);
		}
	}

	public static void setNewPrimitiveFeature(TextBlockProxy newVersion, TextBlock oldVersion,
		AbstractToken subNode, IModelInjector injector) {
		int i = 0;
		TypedElement compareToProperty = null;
		if (subNode instanceof LexedToken) {
	                if(((LexedToken) subNode).isOperator()) {
		                PropertyReference storeOperatorTo = ((OperatorTemplate) newVersion.getTemplate()).getStoreOperatorTo();
                                if(storeOperatorTo != null) {
                                    compareToProperty = storeOperatorTo.getStrucfeature();
                                } else {
                                    return;
                                }
	                } else if (((LexedToken) subNode).getSequenceElement() != null && checkIsDefinedOptional(subNode)) {
				// if the subNode is responsible for a property that is set through
				// an isDefined clause
				// then the value to which the token's valuen should be compared is
				// not the value of the attribute
				// but rather the value so the property is defined in the parent
				// isDefined clause
				SequenceElement parent = TcsUtil
					.getContainerSequenceElement(((LexedToken) subNode)
						.getSequenceElement());
				if (!(parent instanceof ConditionalElement)
					|| !(((ConditionalElement) parent).getCondition() instanceof AndExp)
					|| !(((AndExp) ((ConditionalElement) parent).getCondition())
						.getExpressions().size() == 1)) {
					throw new IllegalStateException(
						"isDefined expression expected but got:"
							+ parent.refMetaObject()
								.refGetValue("name"));
				} else {
					AndExp andExp = (AndExp) ((ConditionalElement) parent)
						.getCondition();
					AtomExp conditionExpression = andExp.getExpressions()
						.iterator().next();
					compareToProperty = conditionExpression
						.getPropertyReference().getStrucfeature();
				}

			} else {
				if (!(((LexedToken) subNode).getSequenceElement() instanceof Property)) {
					// nothing to do for now
					// TODO check if there are other scenarios where we have to
					// do something
					return;
				}
				compareToProperty = ((Property) ((LexedToken) subNode)
					.getSequenceElement()).getPropertyReference()
					.getStrucfeature();
			}
			for (RefObject ro : oldVersion.getCorrespondingModelElements()) {
				if (newVersion.getCorrespondingModelElementProxies().size() >= i + 1) {
					ModelElementProxy correspondingProxy = (ModelElementProxy) newVersion
						.getCorrespondingModelElementProxies().get(i);
					List<Object> values = correspondingProxy.getAttributeMap()
						.get(compareToProperty.getName());
					if (values == null) {
						// may be deferred reference, so do nothing here
						i++;
						continue;
					}
					if (values.size() > 1) {
						// throw new
						// RuntimeException("Incremental updating of multi valued primitive attributes is currently not supported");
						if (!(values.get(0) instanceof IModelElementProxy)) {
							// if its a proxy its not a primitive value!
							injector.set(ro, compareToProperty
								.getName(), values.get(0));
						}
						// TODO log warning
					} else {
						if (!(values.get(0) instanceof IModelElementProxy)) {
							// if its a proxy its not a primitive value!
							injector.set(ro, compareToProperty
								.getName(), values.get(0));
						}
					}
				} else {
					break;
				}

				i++;
			}
		}
	}

	/**
	 * Checks the case if a token represents an optional sequence element
	 * 
	 * E.g.: ...(isDefined(isValueType) ? "value") ... Will result in true if the
	 * <tt>nextToken</tt> represents the "value" token which is optional.
	 * 
	 * @param nextToken
	 * @return
	 */
	public static boolean checkIsDefinedOptional(AbstractToken candidate) {
		LexedToken lexedToken = (LexedToken) candidate;
		SequenceElement se = lexedToken.getSequenceElement();
		if (se != null) {
			// now check if it is contained within a isDefined clause
			// TODO maybe this has to be done recursively ascending?
			SequenceElement parent = TcsUtil.getContainerSequenceElement(se);
			if (parent != null) {
				if (parent instanceof ConditionalElement) {
					ConditionalElement conditional = (ConditionalElement) parent;
					return conditional.getThenSequence().getElements()
						.contains(se);
				}
			}
		}
		return false;
	}

	public static Collection<? extends RefObject> deletePreviousEmptyBlocks(TextBlock original) {
		if (original != null) {
			TextBlock previous = TbNavigationUtil.previousBlockInSubTree(original);
			if (previous != null) {
				Collection<RefObject> affectedModelElements = new ArrayList<RefObject>();
				Collection<TextBlock> deleteTB = new ArrayList<TextBlock>();
				for (TextBlock subBlock : previous.getSubBlocks()) {
					affectedModelElements
						.addAll(deletePreviousEmptyBlocks(subBlock));
					deleteTB.add(subBlock);
				}
				for (TextBlock textBlock : deleteTB) {
					affectedModelElements.addAll(deleteEmptyBlocks(textBlock));
				}
				return affectedModelElements;
			}
		}
		return Collections.emptyList();
	}

	public static Collection<? extends RefObject> deleteNextEmptyBlocks(TextBlock original) {
		if (original != null && original.is___Alive()) {
			TextBlock next = TbNavigationUtil.nextBlockInSubTree(original);
			if (next != null) {
				Collection<RefObject> affectedModelElements = new ArrayList<RefObject>();
				Collection<TextBlock> deleteTB = new ArrayList<TextBlock>();
				for (TextBlock subBlock : new ArrayList<TextBlock>(next
					.getSubBlocks())) {
					affectedModelElements
						.addAll(deleteNextEmptyBlocks(subBlock));
					deleteTB.add(subBlock);
				}
				for (TextBlock textBlock : deleteTB) {
					affectedModelElements.addAll(deleteEmptyBlocks(textBlock));
				}
				return affectedModelElements;
			}
		}
		return Collections.emptyList();
	}

	public static Collection<? extends RefObject> deleteEmptyBlocks(TextBlock original) {
		TextBlock tbDeletionCandidate = original;
		Collection<RefObject> affectedModelElements = new ArrayList<RefObject>();
		if (((Partitionable) original).is___Alive()) {
                    for (TextBlock subBlock : new ArrayList<TextBlock>(original.getSubBlocks())) {
                            affectedModelElements.addAll(deleteEmptyBlocks(subBlock));
                    }
                }
		if (((Partitionable) original).is___Alive()  && TbNavigationUtil.firstToken(tbDeletionCandidate) == null
	                    // this may be the case if there are any empty blocks before
	                    // remaining tokens
	                    // inside the block
	                    && tbDeletionCandidate.getTokens().size() == 0) {
                        TextBlock deleteTB = tbDeletionCandidate;
                        if (deleteTB.getCorrespondingModelElements().size() > 0) {
                                affectedModelElements.addAll(deleteTB
                                        .getCorrespondingModelElements());
                        }
                        deleteTB.refDelete();
               
		}
		return affectedModelElements;
	}

	public static void deleteCorrespondingModelElements(RefObject parentRefObject,
		String propertyToDeleteFrom, TextBlock oldVersion,
		ReferenceHandler referenceHandler) {
		Collection<RefObject> correspondingModelElements = new ArrayList<RefObject>(
			oldVersion.getCorrespondingModelElements());
		for (RefObject oldModelElement : correspondingModelElements) {
			// TODO: What if the property is a non referenced association end?
			// -->search the association and do the check there
			Object value = referenceHandler.getFeatureValue(parentRefObject,
				propertyToDeleteFrom);
			if (value instanceof Collection<?>) {
				if (((Collection<?>) value).contains(oldModelElement)) {
					oldModelElement.refDelete();
				}
			} else if (value instanceof RefObject) {
				if (value.equals(oldModelElement)) {
					oldModelElement.refDelete();
				}
			}
		}
		// TODO also delete modelelements of tokens?
	}

	/**
	 * Deletes the given {@link TextBlock} <tt>block</tt> including any empty blocks that are
	 * adjecent to it.
	 * 
	 * @param original
	 */
	public static Collection<RefObject> deleteEmptyBlocksIncludingAdjecentBlocks(
		TextBlock original) {
		Collection<RefObject> affectedModelElements = new ArrayList<RefObject>();
		affectedModelElements.addAll(deletePreviousEmptyBlocks(original));
		affectedModelElements.addAll(deleteNextEmptyBlocks(original));
		affectedModelElements.addAll(deleteEmptyBlocks(original));
		affectedModelElements.addAll(deleteEmptyParentBlocks(original));
		return affectedModelElements;
	}

	private static Collection<? extends RefObject> deleteEmptyParentBlocks(
            TextBlock original) {
	    Collection<RefObject> affectedModelElements = new ArrayList<RefObject>();
	    TextBlock tbDeletionCandidate = original;
	    while (tbDeletionCandidate != null && tbDeletionCandidate.is___Alive()
                    && TbNavigationUtil.firstToken(tbDeletionCandidate) == null
                    // this may be the case if there are any empty blocks before
                    // remaining tokens
                    // inside the block
                    && tbDeletionCandidate.getTokens().size() == 0) {
                    TextBlock deleteTB = tbDeletionCandidate;
                    if (deleteTB.getCorrespondingModelElements().size() > 0) {
                            affectedModelElements.addAll(deleteTB
                                    .getCorrespondingModelElements());
                    }
                    tbDeletionCandidate = tbDeletionCandidate.getParentBlock();
                    deleteTB.refDelete();
            }
	    return affectedModelElements;
	}

    public static void unsetPrimitiveFeature(TextBlock oldVersion, LexedToken lt,
		IModelInjector injector) {
		if (oldVersion.getCorrespondingModelElements().size() > 0
			&& lt.getSequenceElement() != null
			&& lt.getSequenceElement() instanceof Property) {
			for (RefObject ro : oldVersion.getCorrespondingModelElements()) {
				try {
					Collection<RefObject> elements = new ArrayList<RefObject>(
						lt.getReferencedElements());
					elements.addAll(lt.getCorrespondingModelElements());
					injector.unset(ro,
						((Property) lt.getSequenceElement())
							.getPropertyReference().getStrucfeature()
							.getName(), elements);
				} catch (ModelCreationOntheFlyRuntimeException e) {
					// do nothing just try next element
				}
			}

		}
	}

	/**
	 * Returns a {@link SetNewFeatureBean} for the corresponding AND referenced elements of the
	 * given <tt>newVersion</tt> {@link TextBlock}. The element for which the value is to be set
	 * is derived from the corresponding model elements of the oldVersion's parent
	 * {@link TextBlock}.
	 * 
	 * @param newVersion
	 * @param oldVersion
	 * @param before
	 *                tells whether to add the value before or after the index of the
	 *                oldVersion's index within its parent block.
	 * @return
	 */
	public static SetNewFeatureBean insertFeatureValue(TextBlock newVersion,
		TextBlock oldVersion, boolean before) {
		// newVersion proxy has no parent so use the element from the CURRENT
		// version of the given parentTextBlock
		if (oldVersion != null && oldVersion.getSequenceElement() != null
			&& oldVersion.getSequenceElement() instanceof Property) {
			int index = oldVersion.getParentBlock().getSubBlocks().indexOf(oldVersion);
			if (!before) {
				index += 1;
			}
			if (oldVersion.getParentBlock().getCorrespondingModelElements().size() > 1) {
				throw new IncrementalParsingException(
					"Tried to set a value for multiple parent elements:"
						+ new ArrayList<RefObject>(oldVersion
							.getParentBlock()
							.getCorrespondingModelElements())
						+ "\nDon't know how to handle this.");
			}
			RefObject parentRefObject = oldVersion.getParentBlock()
				.getCorrespondingModelElements().iterator().next();
			if (parentRefObject != null) {
				List<RefObject> values = new ArrayList<RefObject>(newVersion
					.getCorrespondingModelElements());
				values.addAll(newVersion.getReferencedElements());
				Object value = null;
				if (values.size() == 1) {
					value = values.get(0);
				} else {
					value = values;
				}

				return new SetNewFeatureBean(
					parentRefObject,
					((Property) oldVersion.getSequenceElement())
						.getPropertyReference().getStrucfeature().getName(),
					value, index);
			}
		}
		return null;
	}

	static void copyAttributes(TextBlock oldVersion, TextBlock result) {
		result.setLength(oldVersion.getLength());
		result.setOffsetRelative(oldVersion.isOffsetRelative());
		result.setOffset(oldVersion.getOffset());
		List<DocumentNode> otherVersions = new ArrayList<DocumentNode>(
				oldVersion.getOtherVersions());
		for (DocumentNode otherVersion : otherVersions) {
			oldVersion.getOtherVersions().remove(otherVersion);
			TbUtil.dereferenceVersions(oldVersion, otherVersion);
		}
		TbUtil.referenceVersions(result, otherVersions.get(0));
	}

	/**
	 * Finds the {@link RefAssociation} that is the containment relation between
	 * <code>parent</code> and <code>child</code>;
	 * 
	 * @param parent
	 * @param child
	 * @param connection the {@link Connection} to use for navigating the model.
	 * @return
	 */
	public static IncrementalParsingUtil.CompositeRefAssociationBean findComposingFeature(RefObject parent,
			RefObject child, Connection connection) {
		IncrementalParsingUtil.CompositeRefAssociationBean bean = null;
		if (parent != null && child != null) {
			Collection<Association> compositeAssociations = connection
					.getJmiHelper().getCompositeAssociations(
							(MofClass) parent.refMetaObject(),
							(MofClass) child.refMetaObject());
			for (Association association : compositeAssociations) {
				// as defined in the MOF Spec the immediate composite of an
				// association is always a
				// package
				RefAssociation refAssoc = connection.getJmiHelper()
						.getRefAssociationForAssociation(association);
				if (IncrementalParsingUtil.typesMatch(association, parent.refMetaObject(), child
						.refMetaObject(), connection)
						&& refAssoc.refLinkExists(parent, child)) {
					bean = new IncrementalParsingUtil.CompositeRefAssociationBean(refAssoc, true);
					break; // the first valid association is the correct one as
					// there may only be
					// one composite relationship between
					// two elements
				} else if (IncrementalParsingUtil.typesMatch(association, child.refMetaObject(),
						parent.refMetaObject(), connection)
						&& refAssoc.refLinkExists(child, parent)) {
					bean = new IncrementalParsingUtil.CompositeRefAssociationBean(refAssoc, false);
					break; // the first valid association is the correct one as
					// there may only be
					// one composite relationship between
					// two elements
				}
			}
		}
		return bean;
	}

	/**
	 * Checks whether the types of the given refObjects match the types of the
	 * association ends of the given association.
	 * 
	 * @param association
	 * @param refMetaObject
	 * @param refMetaObject2
	 * @param Connection the connection to get things like the {@link JmiHelper} from.
	 * @return
	 */
	static boolean typesMatch(Association association,
			RefObject refMetaObject, RefObject refMetaObject2, Connection connection) {
		List<AssociationEnd> associationEnds = connection.getJmiHelper()
				.getAssociationEnds(association);
		Classifier firstEndType = associationEnds.get(0).getType();
		Classifier secondEndType = associationEnds.get(1).getType();
		if (firstEndType.equals(refMetaObject)
				|| connection.getJmiHelper().getAllSubtypes(firstEndType)
						.contains(refMetaObject)) {
			// first end matches, so check second end
			if (secondEndType.equals(refMetaObject2)
					|| connection.getJmiHelper().getAllSubtypes(secondEndType)
							.contains(refMetaObject2)) {
				return true;
			}
		}
		return false;
	}

	static boolean isInTransientPartition(RefObject correspondingNewElement) {
		boolean isInTransientPartition = false;
		Connection connection = correspondingNewElement.get___Connection();
		for (ModelPartition part : connection.getTransientPartitions()) {
			if (correspondingNewElement.get___Partition().getPri().equals(
					part.getPri())) {
				isInTransientPartition = true;
			}
		}
		if (correspondingNewElement.get___Partition().getPri().equals(
				connection.getNullPartition().getPri())) {
			isInTransientPartition = true;
		}
		return isInTransientPartition;
	}

}
