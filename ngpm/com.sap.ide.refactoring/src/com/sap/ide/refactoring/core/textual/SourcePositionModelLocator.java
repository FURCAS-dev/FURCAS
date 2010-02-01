package com.sap.ide.refactoring.core.textual;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.jface.text.source.ISourceViewer;

import textblocks.DocumentNode;
import textblocks.TextBlock;

import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Helper to access the underlying domain model through the textblocks model
 * 
 * @author D049157
 *
 */
public class SourcePositionModelLocator {
    
    private final TextBlocksModel textBlockModel;
    private final ISourceViewer sourceViewer;
    
    public SourcePositionModelLocator(TextBlocksModel model, ISourceViewer sourceViewer) {
	this.textBlockModel= model;
	this.sourceViewer = sourceViewer;
    }
    
    public Collection<DocumentNode> findSelecetedTextBlocks() {;
	int offsetFrom = sourceViewer.getSelectedRange().x;
	int offsetTo = offsetFrom + sourceViewer.getSelectedRange().y;
	
	List<DocumentNode> selectedTextBlocks = textBlockModel.getNodesBetweenAsRootSet(textBlockModel.getRoot(), offsetFrom, offsetTo);
	
	boolean isFirst = TbNavigationUtil.isFirstInSubTree(selectedTextBlocks.get(0));
	boolean isLast = TbNavigationUtil.isLastInSubTree(selectedTextBlocks.get(selectedTextBlocks.size()-1));
	TextBlock parentBlock = TbNavigationUtil.getParentBlock(selectedTextBlocks.get(0));
	
	if (isFirst && isLast && parentBlock != null) {
	    // there is a common ParentBlock containing exactly the selected elements
	    return Collections.singletonList((DocumentNode) parentBlock);
	} else {
	    return selectedTextBlocks;
	}
    }
    
    /**
     * Find the corresponding ModelElements of the current selection.
     * Moves up the TextBlocks hierarchy to find the innermost corresponding elements.
     */
    public Collection<RefObject> findSelectedCorrespondingModelElements() {
	Collection<DocumentNode> selectedTextBlocks = findSelecetedTextBlocks();
	
        Collection<RefObject> selectedElements = new HashSet<RefObject>();
        for (DocumentNode node : selectedTextBlocks) {
            selectedElements.addAll(findCorrespondingModelElements(node));
        }
        return selectedElements;
    }
    
    private Collection<RefObject> findCorrespondingModelElements(DocumentNode node) {
	Collection<RefObject> decoratedElements = node.getCorrespondingModelElements();
	if (decoratedElements.isEmpty()) {
	    TextBlock parentBlock = TbNavigationUtil.getParentBlock(node);
	    while (parentBlock != null && decoratedElements.isEmpty()) {
		decoratedElements = parentBlock.getCorrespondingModelElements();
		parentBlock = parentBlock.getParentBlock();
	    }
	}
	return decoratedElements;
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
