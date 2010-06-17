package com.sap.mi.textual.parsing.textblocks;

import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getParentBlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import tcs.ClassTemplate;
import tcs.ContextTags;
import tcs.ContextTemplate;
import tcs.ForeachPredicatePropertyInit;
import tcs.QualifiedNamedElement;
import textblocks.AbstractToken;
import textblocks.Bostoken;
import textblocks.DocumentNode;
import textblocks.Eostoken;
import textblocks.ForeachContext;
import textblocks.LexedToken;
import textblocks.OmittedToken;
import textblocks.TextBlock;
import textblocks.Version;
import textblocks.VersionEnum;

import com.sap.mi.textual.common.implementation.ResolvedModelElementProxy;
import com.sap.mi.textual.grammar.impl.ContextBuilder;
import com.sap.mi.textual.textblocks.model.ShortPrettyPrinter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyMap;
import com.sap.tc.moin.repository.DeepCopyPolicy;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.DeepCopyPolicy.DeepCopyPolicyOption;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

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
		if (((TextBlock) node).getParentBlock() != null) {
		    return getAbsoluteOffset(((TextBlock) node).getParentBlock())
			    + node.getOffset();
		} else {
		    return node.getOffset();
		}
	    } else if (node instanceof AbstractToken) {
		int parentOffset = getAbsoluteOffset(((AbstractToken) node).getParentBlock());
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
	if (VersionEnum.CURRENT.equals(tb.getVersion())) {
		return tb;
	}
	for (DocumentNode tbv : tb.getOtherVersions()) {
	    if (tbv.getVersion().equals(VersionEnum.CURRENT)) {
		return tbv;
	    } else if (tbv.getVersion().equals(VersionEnum.PREVIOUS)) {
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
    public static DocumentNode createNewCopy(DocumentNode node, Version newVersion, boolean manifestValues, ShortPrettyPrinter shortPrettyPrinter) {
	Connection conn = ((Partitionable) node).get___Connection();
	DeepCopyResultSet result = conn.deepCopy(Collections.singleton((RefObject) node),
		new TextBlockDeepCopyPolicyHandler(node.getVersion()), false);
	// iterate and set and connect versions to each other
	for (RefObject copy : result.getCopiedElements()) {
	    if(copy instanceof DocumentNode) {
                DocumentNode original = (DocumentNode) conn.getElement(result
                        .getInverseMriMappingTable().get(
                                ((Partitionable) copy).get___Mri()));
                DocumentNode copiedNode = ((DocumentNode) copy);
                copiedNode.setVersion(newVersion);
                if (manifestValues) {
                    if (copiedNode instanceof LexedToken) {
                        ((LexedToken) copiedNode)
                                .setValue(shortPrettyPrinter
                                        .resynchronizeToEditableState((AbstractToken) copiedNode));
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
                referenceVersions(original, copiedNode);
                // per default assign to the same partition
            }
	}
	DocumentNode newCopy = (DocumentNode) result.getMappingTable().get(node).getMappingTarget();
	((Partitionable) node).get___Partition().assignElementIncludingChildren(newCopy);

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
     * this is the deep copy policy for textblock versions Only the given
     * <code>versionToBeCopied</code> is copied, all other elements and document node versions
     * will not be copied but only referenced by the copied version
     *
     * @author C5106462
     *
     */
    private static class TextBlockDeepCopyPolicyHandler implements DeepCopyPolicyHandler {
	private final Version versionToBeCopied;

	public TextBlockDeepCopyPolicyHandler(Version versionToBeCopied) {
	    this.versionToBeCopied = versionToBeCopied;
	}

	private final DeepCopyPolicy fullPolicy = new DeepCopyPolicy(
		DeepCopyPolicyOption.FULL_COPY, null);
	private final DeepCopyPolicy refPolicy = new DeepCopyPolicy(DeepCopyPolicyOption.REF_COPY,
		null);

	@Override
		public DeepCopyPolicy getDeepCopyingPolicy(RefObject sourceElement,
				DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
			if (sourceElement instanceof DocumentNode) {
				DocumentNode node = (DocumentNode) sourceElement;
				if (node.getVersion() != null
						&& node.getVersion().equals(versionToBeCopied)) {
					return fullPolicy;
				}
			} else if(sourceElement instanceof ForeachContext) {
			    return fullPolicy;
			}

			return refPolicy;

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
	    parent = parent.getParentBlock();
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
     * Checks, weather a RefObject has been deleted.
     *
     * Calls a function and checks, if InvalidObjectException is thrown.
     *
     * @param o
     *                RefObject to check
     * @return true, if RefObject was deleted, false otherwise
     */
    public static boolean isDeleted(RefObject o) {
	try {
	    o.refMofId();
	} catch (InvalidObjectException e) {
	    return true;
	}

	return false;
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
	    loopParentBlock = loopParentBlock.getParentBlock();
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

    public static void checkTokenIds(TextBlock rootBlock) {
	// TODO Auto-generated method stub

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
    public static RefObject getCreatedElement(TextBlock parentBlock) {
	for (RefObject ro : parentBlock.getCorrespondingModelElements()) {
	    if (parentBlock.getType() != null && parentBlock.getType().getParseRule() != null) {
		if (ro.refIsInstanceOf(parentBlock.getType().getParseRule().getMetaReference(),
			false)) {
		    return ro;
		}
	    }
	}
	return null;
    }

    /**
     * Starting at the text block <tt>fromHereOutwards</tt> constructs a context stack using the
     * <tt>contextBuilder</tt>. Ascends the text block structure, and each block that was created
     * by a "context" template will add a context using the <tt>contextBuilder</tt>. The context
     * contents created by <tt>addToContext</tt> templates will <em>not</em> be added to these
     * contexts here.
     *
     * @param fromHereOutwards
     * @param contextBuilder
     */
    public static void constructContext(DocumentNode fromHereOutwards, ContextBuilder contextBuilder) {
	TextBlock parentBlock = getParentBlock(fromHereOutwards);
	Stack<TextBlock> contextStack = new Stack<TextBlock>();
	while (parentBlock != null) {
	    if (parentBlock.getType() != null) {
		tcs.Template template = parentBlock.getType().getParseRule();
		if ((template instanceof ContextTemplate && ((ContextTemplate) template).isContext())) {
		    contextStack.push(parentBlock);
		}
	    }
	    parentBlock = parentBlock.getParentBlock();
	}
	while (!contextStack.isEmpty()) {
	    TextBlock t = contextStack.pop();
	    ContextTags tags = null;
	    tcs.Template template = t.getType().getParseRule();
	    if (template instanceof ContextTemplate) {
		tags = ((ContextTemplate) template).getContextTags();
	    }
	    if (tags != null) {
		for (RefObject element : t.getCorrespondingModelElements()) {
		    contextBuilder.addContext(new ResolvedModelElementProxy(element), tags.getTags()
				.toArray(new String[0]));
		}
	    } else {
		for (RefObject element : t.getCorrespondingModelElements()) {
		 // FIXME I saw a case where the iterator did not produce any elements!
			contextBuilder.addContext(new ResolvedModelElementProxy(element));
		}
	    }
	    for (RefObject elementInContext : t.getElementsInContext()) {
		contextBuilder.addToCurrentContext(new ResolvedModelElementProxy(elementInContext));
	    }
	}
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

        public static void addForEachContext(TextBlock contextBlock, RefObject sourceModelElement,
            RefObject currentForEachElement, ForeachPredicatePropertyInit sequenceElement, RefObject resultElement, Connection connection) {
            boolean forEachContextExists = false;
            for (ForeachContext forEachContext : contextBlock.getForeachContext()) {
                if(forEachContext.getForeachPredicatePropertyInit().equals(sequenceElement)) {
                    if(forEachContext.getSourceModelelement().equals(sourceModelElement)) {
                        if(!forEachContext.getContextElement().contains(currentForEachElement)) {
                            forEachContext.getContextElement().add(currentForEachElement);
                            forEachContext.setResultModelElement(resultElement);
                        }
                        forEachContextExists = true;
                    }
                }
            }
            if(!forEachContextExists) {
                ForeachContext newContext = (ForeachContext) connection.getClass(ForeachContext.CLASS_DESCRIPTOR).refCreateInstance();
                newContext.setForeachPredicatePropertyInit(sequenceElement);
                newContext.setSourceModelelement(sourceModelElement);
                newContext.getContextElement().add(currentForEachElement);
                newContext.setResultModelElement(resultElement);
                contextBlock.getForeachContext().add(newContext);
            }

        }

}