package com.sap.furcas.runtime.textblocks;

import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getParentBlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;



public class TbUtil {

    /**
     * Computes the absolute offset of the given {@link DocumentNode} by traversing all transitive
     * parents recursively.
     *
     *
     * @param node
     * @return the absolute offset of the given {@link DocumentNode}
     */
    public static int getAbsoluteOffset(DocumentNode node) {
	// implementation without isOffsetRelative
	/*
	 *
	 * int absoluteOffset = node.getOffset(); TextBlock parent =
	 * TbNavigationUtil.getParentBlock(node); while (parent != null) { absoluteOffset +=
	 * parent.getOffset(); parent = parent.getParentBlock(); }
	 *
	 * return absoluteOffset;
	 */

	if (node.isOffsetRelative()) {
	    if (node instanceof TextBlock) {
		if (((TextBlock) node).getParent() != null) {
		    return getAbsoluteOffset(((TextBlock) node).getParent())
			    + node.getOffset();
		} else {
		    return node.getOffset();
		}
	    } else if (node instanceof AbstractToken) {
		int parentOffset = getAbsoluteOffset(((AbstractToken) node).getParent());
		return parentOffset + node.getOffset();
	    } else {
		throw new RuntimeException(
			"No other classes than AbstractToken or TextBlock are supported!");
	    }
	} else {
	    return node.getOffset();
	}

    }

    /**
     * Searches the newest version of the textblock starting from CURRENT, then PREVIOUS else
     * REFERENCE
     *
     * @param tb
     * @return
     */
    public static DocumentNode getNewestVersion(DocumentNode tb) {
	// TODO is it possible that there is already a CURRENT version?
	if (Version.CURRENT.equals(tb.getVersion())) {
		return tb;
	}
	for (DocumentNode tbv : tb.getOtherVersions()) {
	    if (tbv.getVersion().equals(Version.CURRENT)) {
		return tbv;
	    } else if (tbv.getVersion().equals(Version.PREVIOUS)) {
		tb = tbv;
	    }
	}
	return tb;
    }

    /**
     * Creates a new copy of the given {@link DocumentNode} having the given newVersion set as
     * version. THe whole containment structure will also be copied. The new version will also added
     * to the <code>otherVersions</code> reference and vice versa.
     *
     * @param node
     *                the rootBlock that should be copied, make sure that it has the correct
     *                version, as only this version of the whole tree will be copied. All other
     *                elements will only be referenced by the new version.
     * @param newVersion
     * 			The target version that will be created.
     * @param manifestValues
     * 			If set to true all token values will be manifested using the {@link ShortPrettyPrinter}.
     * 			This means that if the given input tb model s a flyweight it will be turned into a complete
     * 			editable representation.
     * @param shortPrettyPrinter
     * 			The pretty printer used for the manifestation of token values. If <code>manifestValues</code>
     * 			is set to false this may be <code>null</code>;
     * @return the copied version of <code>rootBlock</code>
     */
	public static DocumentNode createNewCopy(DocumentNode node,
			final Version newVersion, boolean manifestValues,
			ShortPrettyPrinter shortPrettyPrinter) {
		final Map<EObject, EObject> copiedElements = new HashMap<EObject, EObject>();
		Copier copier = new EcoreUtil.Copier(true, true) {

			/**
		 * 
		 */
			private static final long serialVersionUID = 1L;

			@Override
			public EObject copy(EObject eObject) {
				EObject copied = super.copy(eObject);
				copiedElements.put(eObject, copied);
				((DocumentNode) copied).setVersion(newVersion);
				return copied;
			}
		};
		DocumentNode newCopy = (DocumentNode) copier.copy(node);
		copier.copyReferences();
		if (manifestValues) {
			if (newCopy instanceof LexedToken) {
				((LexedToken) newCopy).setValue(shortPrettyPrinter
						.resynchronizeToEditableState((AbstractToken) newCopy));
			}
		}
		// as the original already had a reference to its other
		// versions these would be duplicated, therefore clear this
		// association before referencing again
		// TODO this could be improved if deepCopy would allow separate
		// handling of specific references
		// Collection<DocumentNode> referencingNodes =
		// ((TextblocksPackage)
		// copiedNode
		// .refImmediatePackage())
		// .getDocumentNodeHasDocumentNodeVersions().getDocumentNode(
		// copiedNode);
		// TODO: this is only need because obviously deepCopy also
		// duplicates references from "outside"
		// to elements that are being copied, this leads to duplicated
		// version references if
		// // referenceVersions is called
		// for (DocumentNode referencingNode : new
		// ArrayList<DocumentNode>(
		// referencingNodes)) {
		// referencingNode.getOtherVersions().remove(copiedNode);
		// }
		// copiedNode.getOtherVersions().clear();
		for (EObject original : copiedElements.keySet()) {
			referenceVersions((DocumentNode) original, 
					(DocumentNode) copiedElements.get(original));
		}
		
		// per default assign to the same partition
		// FIXME: how are we supposed to handle this? 
		if (((EObject) node).eResource() != null) {
		    ((EObject) node).eResource().getContents().add(newCopy);
		}

		return newCopy;
	}

    /**
     * References the versions of <code>n1</code> and <code>n2</code> with each other. Also
     * previously existing other versions of <code>n1</code> and <code>n2</code> will be
     * referenced by this.
     *
     * @param n1
     * @param n2
     */
    public static void referenceVersions(DocumentNode n1, DocumentNode n2) {
	if (n1.equals(n2)) {
	    return;
	}

	if (n1.getOtherVersions().size() > 0) {
	    // Also add reference to other existing versions
	    for (DocumentNode existingVersion : n1.getOtherVersions()) {
		if (!n2.getOtherVersions().contains(existingVersion)) {
		    if (n2 != existingVersion) {
			existingVersion.getOtherVersions().add(n2);
			n2.getOtherVersions().add(existingVersion);
		    }
		}
	    }
	}
	if (n2.getOtherVersions().size() > 0) {
	    // Also add reference to other existing versions
	    for (DocumentNode existingVersion : n2.getOtherVersions()) {
		if (!n1.getOtherVersions().contains(existingVersion)) {
		    if (n1 != existingVersion) {
			existingVersion.getOtherVersions().add(n1);
			n1.getOtherVersions().add(existingVersion);
		    }
		}
	    }
	}
	if (!n1.getOtherVersions().contains(n2)) {
		n1.getOtherVersions().add(n2);
	}
	if (!n2.getOtherVersions().contains(n1)) {
		n2.getOtherVersions().add(n1);
	}

    }

    /**
     * Helper function that returns teh sublist without the leading bos and trailing eos tokens.
     * Throws IllegalArgumentExceptions, if bos or eos is not found in the right place.
     *
     * @param nodes
     *                nodes list to trim
     * @return nodes list without leading eos and trailing bos tokens
     */
    public static List<? extends DocumentNode> withoutBosEos(List<? extends DocumentNode> nodes) {
	if (nodes.size() < 2) {
	    throw new IllegalArgumentException("nodes do not contain both bos and eos");
	}
	if (!(nodes.get(0) instanceof Bostoken)) {
	    throw new IllegalArgumentException("first token not bos");
	}

	if (!(nodes.get(nodes.size() - 1) instanceof Eostoken)) {
	    throw new IllegalArgumentException("last token not eos");
	}

	return nodes.subList(1, nodes.size() - 1);
    }

    /**
     * Helper function that creates a map with the node and all hierarchical parents mapped to their
     * hierarchy level
     *
     * @param node
     *                DocumentNode to start at
     * @param level
     *                hierarchy level of the node
     * @return filled node level map
     */
    public static Map<Integer, DocumentNode> createNodeLevelMap(DocumentNode node, int level) {
	Map<Integer, DocumentNode> levelMap = new HashMap<Integer, DocumentNode>();
	levelMap.put(level, node);

	TextBlock parent = getParentBlock(node);
	Integer curParentLevel = level - 1;
	while (parent != null) {
	    levelMap.put(curParentLevel, parent);
	    parent = parent.getParent();
	    curParentLevel--;
	}

	return levelMap;
    }

    /**
     * Returns the relative offset (position) of the absoluteOffset in relation to the start offset
     * of the given node.
     *
     * @param absoluteOffset
     *                offset absolute to the beginning of the document text
     * @param node
     *                node to find relative offset to
     * @return relative offset to the node start
     */
    public static int getRelativeOffsetFromNode(int absoluteOffset, DocumentNode node) {
	return absoluteOffset - getAbsoluteOffset(node);
    }


    /**
     * returns true if node has a parent in parent hierarchy which is parentBlock
     *
     * @param parentBlock
     * @param documentNode
     * @return
     */
    public static boolean isAncestorOf(TextBlock parentBlock, DocumentNode node) {
	if (node == null) {
	    return false;
	}

	TextBlock loopParentBlock = TbNavigationUtil.getParentBlock(node);

	while (loopParentBlock != null) {
	    // could be infinite loop with cylces, but model prevents cycles
	    if (loopParentBlock.equals(parentBlock)) {
		return true;
	    }
	    loopParentBlock = loopParentBlock.getParent();
	}
	return false;
    }

    public static void dereferenceVersions(DocumentNode v1, DocumentNode v2) {
	v1.getOtherVersions().remove(v2);
	v2.getOtherVersions().remove(v1);
	// also remove from any remaining versions
	for (DocumentNode otherVersion : v1.getOtherVersions()) {
	    otherVersion.getOtherVersions().remove(v2);
	}
	for (DocumentNode otherVersion : v2.getOtherVersions()) {
	    otherVersion.getOtherVersions().remove(v1);
	}
    }

    public static void referenceVersions(DocumentNode nodeToAddVersionsTo,
	    List<DocumentNode> otherVersions) {
	for (DocumentNode otherVersion : otherVersions) {
	    referenceVersions(nodeToAddVersionsTo, otherVersion);
	}

    }

    /**
     * Searches in the {@link DocumentNode#getCorrespondingModelElements()} of the given TextBlock
     * for an element that matches the {@link QualifiedNamedElement#getMetaReference()} of the
     * template that was used to create the textblock. This is not a hundred percent guarantee, as
     * multiple elements may reside in the corresponding model elements.
     *
     * @param parentBlock
     * @return The element from {@link DocumentNode#getCorrespondingModelElements()} that was most
     *         probably created using the template of the {@link TextBlock}. <code>null</code> if
     *         no element matches this criterion.
     */
    public static EObject getCreatedElement(TextBlock parentBlock) {
	for (EObject ro : parentBlock.getCorrespondingModelElements()) {
	    if (parentBlock.getType() != null && parentBlock.getType().getParseRule() != null) {
		if (ro.eClass().equals(parentBlock.getType().getParseRule().getMetaReference())) {
		    return ro;
		}
	    }
	}
	return null;
    }


    /**
     * Gives the absolute offset of the first token that is not an {@link OmittedToken} and that is still
     * transitively contained in parentBlock.
     *
     * @param parentBlock
     * @return
     */
	public static int getAbsoluteOffsetWithoutBlanks(TextBlock parentBlock) {
		AbstractToken leadingTok = TbNavigationUtil.firstTokenWithoutBOS(parentBlock);
		while(leadingTok instanceof OmittedToken && TbUtil.isAncestorOf(parentBlock, leadingTok)){
			leadingTok = TbNavigationUtil.nextToken(leadingTok);
		}
		return TbUtil.getAbsoluteOffset(leadingTok);
	}

	/**
     * Gives the length of the block starting from first token that is not an {@link OmittedToken} and that is still
     * transitively contained in parentBlock.
     *
     * @param parentBlock
     * @return
     */
	public static int getLengthWithoutStartingBlanks(TextBlock parentBlock) {
		int absoluteOffsetTok = getAbsoluteOffsetWithoutBlanks(parentBlock);
		return parentBlock.getLength() - (absoluteOffsetTok  - TbUtil.getAbsoluteOffset(parentBlock));
	}

	public static boolean isTextBlockOfType(ClassTemplate rootTemplate,
    	    TextBlock block) {
        	return block.getType() != null
    			&& block.getType().getParseRule() != null
    			&& block.getType().getParseRule().equals(rootTemplate);
        }

	public static boolean isEmpty(TextBlock oldVersion) {
		if (TbNavigationUtil.firstToken(oldVersion) == null) {
			return true;
		}
		if (TbNavigationUtil.firstToken(oldVersion) instanceof Bostoken
			&& (TbNavigationUtil.nextToken(TbNavigationUtil.firstToken(oldVersion)) == null || TbNavigationUtil
				.nextToken(TbNavigationUtil.firstToken(oldVersion)) instanceof Eostoken)) {
			return true;
		}
		if (TbNavigationUtil.getSubNodesSize(oldVersion) > 2) {
			return false;
		} else if (TbNavigationUtil.getSubNodesSize(oldVersion) < 2
			&& TbNavigationUtil.getSubNodesSize(oldVersion) > 0) {
			return false;
		} else if (TbNavigationUtil.getSubNodesSize(oldVersion) == 2) {
			return TbNavigationUtil.getSubNodeAt(oldVersion, 0) instanceof Bostoken
				&& TbNavigationUtil.getSubNodeAt(oldVersion, 1) instanceof Eostoken;
		} else {
			return true;
		}
	}

        public static Collection<TextBlock> filterVersionedTextBlockForNewest(
            Collection<TextBlock> tbs) {
            for (TextBlock textBlock : new ArrayList<TextBlock>(tbs)) {
        	if (textBlock == null) {
        	    System.out.println("WTF tb was null");
        	    tbs.remove(null);
        	    continue;
        	}
                if(!textBlock.equals(TbUtil.getNewestVersion(textBlock))) {
                    tbs.remove(textBlock);
                }
            }
            return tbs;
        }

        public static void addForEachContext(TextBlock contextBlock, EObject sourceModelElement,
            EObject currentForEachElement, ForeachPredicatePropertyInit sequenceElement, EObject resultElement) {
            boolean forEachContextExists = false;
            for (ForEachContext forEachContext : contextBlock.getForEachContext()) {
                if(forEachContext.getForeachPedicatePropertyInit().equals(sequenceElement)) {
                    if(forEachContext.getSourceModelElement().equals(sourceModelElement)) {
                        if(!forEachContext.getContextElement().contains(currentForEachElement)) {
                            forEachContext.getContextElement().add(currentForEachElement);
                            forEachContext.setResultModelElement(resultElement);
                        }
                        forEachContextExists = true;
                    }
                }
            }
            if(!forEachContextExists) {
                ForEachContext newContext = TextblocksFactory.eINSTANCE.createForEachContext();
                newContext.setForeachPedicatePropertyInit(sequenceElement);
                newContext.setSourceModelElement(sourceModelElement);
                newContext.getContextElement().add(currentForEachElement);
                newContext.setResultModelElement(resultElement);
                contextBlock.getForEachContext().add(newContext);
            }

        }

}