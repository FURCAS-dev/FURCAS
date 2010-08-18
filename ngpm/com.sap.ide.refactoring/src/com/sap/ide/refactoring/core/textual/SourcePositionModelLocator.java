package com.sap.ide.refactoring.core.textual;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.jface.text.source.ISourceViewer;

import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.ide.cts.parser.incremental.IncrementalParser.TextBlocksTarjanTreeContentProvider;
import com.sap.ide.cts.parser.incremental.util.TarjansLCA;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;

/**
 * Helper to access the underlying domain model through the textblocks model.
 * Works based on the current cursor position and text selection.
 *
 * @author D049157
 *
 */
public class SourcePositionModelLocator {

    private final TextBlocksModel textBlockModel;
    private final ISourceViewer sourceViewer;

    public SourcePositionModelLocator(RefactoringEditorFacade facade) {
	this(facade.getTextBlocksModel(), facade.getSourceViewer());
    }

    SourcePositionModelLocator(TextBlocksModel model, ISourceViewer viewer) {
	textBlockModel = model;
	sourceViewer = viewer;
    }

    public Collection<DocumentNode> findSelecetedTextBlocks() {;
	int offsetFrom = sourceViewer.getSelectedRange().x;
	int offsetTo = offsetFrom + sourceViewer.getSelectedRange().y;

	DocumentNode leftMostSelectedNode = textBlockModel.getFloorTokenInRoot(offsetFrom);
	DocumentNode rightMostSelectedNode = textBlockModel.getFloorTokenInRoot(offsetTo);

	// Handle special case that the user has exactly selected a  whole textblock.
	// We use this LCA shortcut as it is (much) faster than #getNodesBetweenAsRootSet.
	TarjansLCA<DocumentNode> lca = new TarjansLCA<DocumentNode>(new TextBlocksTarjanTreeContentProvider());
	DocumentNode commonAncestor = lca.lcaSearch(textBlockModel.getRoot(), leftMostSelectedNode, rightMostSelectedNode);

	DocumentNode leftMostAncestorNode = TbNavigationUtil.firstToken(commonAncestor); // could be BOS token
	DocumentNode rightMostAncestorNode = TbNavigationUtil.lastToken(commonAncestor); // could be EOS token

	// special case handling is for omitted BOS/EOS token
	boolean equalLeftMostToken = leftMostAncestorNode.equals(leftMostSelectedNode) || leftMostAncestorNode instanceof Bostoken &&
		TbNavigationUtil.getNextInSubTree(leftMostAncestorNode).equals(leftMostSelectedNode);
	boolean equalRightMostToken = rightMostAncestorNode.equals(rightMostSelectedNode)  || rightMostAncestorNode instanceof Eostoken &&
		TbNavigationUtil.getPreviousInSubTree(rightMostAncestorNode).equals(rightMostSelectedNode);

	if (equalLeftMostToken && equalRightMostToken) {
	    return Collections.singletonList(commonAncestor);
	} else {
	    return textBlockModel.getNodesBetweenAsRootSet(textBlockModel.getRoot(), offsetFrom, offsetTo);
	}
    }

    /**
     * Find the corresponding ModelElements of the current selection.
     *
     * It may happen that only TextBlocks are selected which do not contain any
     * corresponding ModelElements. In this case the the algorithm moves up the
     * TextBlocks hierarchy level after level. Once there is a level reached where
     * atleast one of the TextBlocks (parents of our original selected TextBlocks)
     * has defined a corresponding ModelElement, all known corresponding ModelElements
     * on this level are returned.
     */
    public Collection<RefObject> findSelectedCorrespondingModelElements() {
	Collection<DocumentNode> selectedTextBlocks = findSelecetedTextBlocks();
        Collection<RefObject> selectedElements = new HashSet<RefObject>();

        while (selectedElements.isEmpty()) {
            for (DocumentNode node : selectedTextBlocks) {
                selectedElements.addAll(node.getCorrespondingModelElements());
            }
            if (selectedElements.isEmpty()) {
        	selectedTextBlocks = getNodeParents(selectedTextBlocks);
            }
            if (selectedTextBlocks.isEmpty()) {
        	break; // root node reached
            }
        }
        return selectedElements;
    }


    private Collection<DocumentNode> getNodeParents(Collection<DocumentNode> selectedTextBlocks) {
	Collection<DocumentNode> parentNodes = new HashSet<DocumentNode>();
	for (DocumentNode node : selectedTextBlocks) {
	    DocumentNode parent = TbNavigationUtil.getParentBlock(node);
	    if (parent != null) {
		parentNodes.add(parent);
	    }
	}
	return parentNodes;
    }

    /**
     * Finds the referenced elements within the current selection.
     * Does NOT move up the TextBlocks hierarchy.
     */
    public Collection<RefObject> findSelectedReferencedModelElements() {
	Collection<DocumentNode> selectedTextBlocks = findSelecetedTextBlocks();

        Collection<RefObject> selectedElements = new HashSet<RefObject>();
        for (DocumentNode node : selectedTextBlocks) {
            selectedElements.addAll(node.getReferencedElements());
        }
        return selectedElements;
    }


}
