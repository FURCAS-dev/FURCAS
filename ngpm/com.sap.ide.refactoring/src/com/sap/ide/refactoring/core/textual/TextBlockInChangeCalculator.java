package com.sap.ide.refactoring.core.textual;

import static com.sap.ide.refactoring.core.textual.TextBlockRefactoringUtil.findCorrespondingTextBlocks;
import static com.sap.ide.refactoring.core.textual.TextBlockRefactoringUtil.findReferencedTextBlocks;
import static com.sap.ide.refactoring.core.textual.TextBlockRefactoringUtil.findTextBlockRootDomainRootObjectTuples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import textblocks.AbstractToken;
import textblocks.DocumentNode;
import textblocks.TextBlock;

import com.sap.ide.refactoring.core.textual.ModelElementDocumentNodeChangeDescriptor.ChangeType;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * For a set of changed model elements, determines the minimal TextBlock trees that need
 * to be pretty printed.
 * 
 * We are interested in a minimal tree because a) we want to retain formatting
 * as far as possible and b) it does not make sense to e.g. re-print a TextBlock if we already
 * pretty printed it's composite parent.
 * 
 * See {@link TextBlocksNeedingPrettyPrintChangeListener}
 * 
 * TODO: Refactor this class. Looks like we can drop the whole root tuple handling
 * and can just use the rootblock instead. Should kill some looping.
 * 
 * @author Stephan Erb (d049157)
 * 
 */
public class TextBlockInChangeCalculator {

    private final Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> correspondingTextBlocksPerRootObject = new HashMap<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>>();
    private final Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> referencingTextBlocksPerRootObject = new HashMap<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>>();

    public void add(RefObject modelElement, ChangeType changeType) {
	if (modelElement instanceof DocumentNode) {
	    // this is a shortcut. We only care about real model elements that
	    // changed, but about no events
	    // related to textblocks that happened during pretty printing
	    return;
	}

	if (changeType.equals(ChangeType.CREATED)) {
	    // TODO: If a new element is created and it is a root element, we
	    // might want to automatically
	    // generate a TB tree. Otherwise now preview is shown and the TB
	    // model will only be created if an editor is hopened.
	} else {
	    addCorrespondingTextBlocks(modelElement, changeType);
	    addReferencedTextBlocks(modelElement, changeType);
	}
    }

    private void addCorrespondingTextBlocks(RefObject modelElement, ChangeType changeType) {
	for (DocumentNode tbToAdd : findCorrespondingTextBlocks(modelElement)) {
	    if (!isValidTextBlock(tbToAdd)) {
		continue;
	    }
	    // FIXME: looks like fetching the rootobject tuples is not needed. 
	    for (RootElementTextBlockTuple rootTuple : findTextBlockRootDomainRootObjectTuples(tbToAdd)) {
		if (tbToAdd instanceof AbstractToken) {
		    // Individual tokens cannot be pretty printed. Add their
		    // parent instead.
		    addParentTextBlockForToken(modelElement, changeType, rootTuple);
		} else {
		    assert tbToAdd instanceof TextBlock;
		    mergeTextBlockIntoList(modelElement, tbToAdd, changeType, getCorrespondingTextBlockListOfComposite(rootTuple));
		}
	    }
	}
    }

    private void addParentTextBlockForToken(RefObject modelElement, ChangeType changeType, RootElementTextBlockTuple rootTuple) {
	// The following is just a heuristic and could probably be improved.
	// (it might happen that we pretty print to much)
	RefObject parent = findParentWithCorrespondingTextBlocks(modelElement, rootTuple);
	for (DocumentNode documentNode : findCorrespondingTextBlocks(parent)) {
	    // filter AbstractTokens to prevent recursion
	    if (documentNode instanceof TextBlock) {
		mergeTextBlockIntoList(parent, documentNode, changeType, getCorrespondingTextBlockListOfComposite(rootTuple));
	    }
	}
    }

    private void addReferencedTextBlocks(RefObject modelElement, ChangeType changeType) {
	for (DocumentNode tbToAdd : findReferencedTextBlocks(modelElement)) {
	    if (!isValidTextBlock(tbToAdd)) {
		continue;
	    }
	    // FIXME: looks like fetching the rootobject tuples is not needed. 
	    for (RootElementTextBlockTuple rootTuple : findTextBlockRootDomainRootObjectTuples(tbToAdd)) {
		mergeTextBlockIntoList(modelElement, tbToAdd, changeType, getReferencingTextBlockListOfComposite(rootTuple));
	    }
	}
    }

    private boolean isValidTextBlock(DocumentNode tbToAdd) {
	if (!TbUtil.getNewestVersion(tbToAdd).equals(tbToAdd)) {
	    return false;
	}
	return true;
    }

    private void mergeTextBlockIntoList(RefObject modelElement, DocumentNode tbToAdd, ChangeType changeType,
	    List<ModelElementDocumentNodeChangeDescriptor> textBlocks) {
	int insertPosition = findInsertPosition(tbToAdd, textBlocks);
	if (insertPosition >= 0) {
	    removeChildBlocks(insertPosition, tbToAdd, textBlocks);
	    textBlocks.add(insertPosition, new ModelElementDocumentNodeChangeDescriptor(modelElement, tbToAdd, changeType));
	} else {
	    // No need to add tbToAdd. We have already stored a parent Block.
	}
    }

    private int findInsertPosition(DocumentNode tbToAdd, List<ModelElementDocumentNodeChangeDescriptor> textBlocks) {
	ListIterator<ModelElementDocumentNodeChangeDescriptor> iter = textBlocks.listIterator();
	int insertPosition = 0;
	while (iter.hasNext()) {
	    insertPosition = iter.nextIndex();
	    DocumentNode currentTb = iter.next().documentNode;
	    if (currentTb.getAbsoluteOffset() < tbToAdd.getAbsoluteOffset()) {
		// currentTb is left of our insert position
		// If iter.hasNext() is false we will spring out of the while
		// lopp in the next run.
		// In this special case the following incrementation is
		// required, because we want to insert
		// behind the last element, not before.
		insertPosition++;
		continue;
	    } else {
		// found the insert position
		break;
	    }
	}
	// Check if the block really needs to be added
	if (iter.hasPrevious()) {
	    DocumentNode tbLeftOfInsertPosition = iter.previous().documentNode;
	    int coveredRange = tbLeftOfInsertPosition.getAbsoluteOffset() + tbLeftOfInsertPosition.getLength();
	    if (coveredRange >= tbToAdd.getAbsoluteOffset() + tbToAdd.getLength()) {
		// tbToAdd is a subBlock of tbLeftOfInsertPosition. No need to
		// add tbToAdd
		return -1;
	    } else {
		return insertPosition;
	    }
	} else {
	    assert insertPosition == 0 : "Only the first element cannot have a previous element.";
	    return 0;
	}
    }

    private void removeChildBlocks(int insertPosition, DocumentNode tbToAdd,
	    List<ModelElementDocumentNodeChangeDescriptor> textBlocks) {
	if (insertPosition == textBlocks.size()) {
	    // insert at the end, so there is nothing behind us and therefore
	    // nothing to delete.
	} else {
	    ListIterator<ModelElementDocumentNodeChangeDescriptor> iter = textBlocks.listIterator(insertPosition);
	    while (iter.hasNext()) {
		DocumentNode tbRightOfInsertPosition = iter.next().documentNode;
		int coveredRange = tbRightOfInsertPosition.getAbsoluteOffset() + tbRightOfInsertPosition.getLength();
		if (coveredRange <= tbToAdd.getAbsoluteOffset() + tbToAdd.getLength()) {
		    // tbToAdd is a superBlock of tbRightOfInsertPosition. We
		    // can delete it.
		    iter.remove();
		}
	    }
	}
    }

    /**
     * Find a suitable parent for pretty printing (this implies that the parent
     * has corresponding ModelElements)
     */
    private RefObject findParentWithCorrespondingTextBlocks(RefObject modelElement, RootElementTextBlockTuple rootTuple) {
	RefObject parent = (RefObject) modelElement.refImmediateComposite();
	while (parent != null) {
	    for (DocumentNode parentBlock : findCorrespondingTextBlocks(parent)) {
		if (TbNavigationUtil.getUltraRoot(parentBlock).equals(rootTuple.textBlock)) {
		    return parent;
		}
	    }
	    parent = (RefObject) parent.refImmediateComposite();
	}
	return rootTuple.modelElement; // fallback if we did not return earlier
    }

    private List<ModelElementDocumentNodeChangeDescriptor> getCorrespondingTextBlockListOfComposite(
	    RootElementTextBlockTuple rootTuple) {
	if (!correspondingTextBlocksPerRootObject.containsKey(rootTuple)) {
	    correspondingTextBlocksPerRootObject.put(rootTuple, new LinkedList<ModelElementDocumentNodeChangeDescriptor>());
	}
	return correspondingTextBlocksPerRootObject.get(rootTuple);
    }

    private List<ModelElementDocumentNodeChangeDescriptor> getReferencingTextBlockListOfComposite(
	    RootElementTextBlockTuple rootTuple) {
	if (!referencingTextBlocksPerRootObject.containsKey(rootTuple)) {
	    referencingTextBlocksPerRootObject.put(rootTuple, new LinkedList<ModelElementDocumentNodeChangeDescriptor>());
	}
	return referencingTextBlocksPerRootObject.get(rootTuple);
    }

    public Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> getTextBlocksNeedingPrettyPrinting() {
	Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> cpy = new HashMap<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>>(
		correspondingTextBlocksPerRootObject);
	for (Entry<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> entry : cpy.entrySet()) {
	    cpy.put(entry.getKey(), new LinkedList<ModelElementDocumentNodeChangeDescriptor>(entry.getValue()));
	}
	return cpy;
    }

    public Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> getTextBlocksNeedingShortPrettyPrinting() {
	Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> cpy = new HashMap<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>>(
		referencingTextBlocksPerRootObject);
	for (Entry<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> entry : cpy.entrySet()) {
	    cpy.put(entry.getKey(), new LinkedList<ModelElementDocumentNodeChangeDescriptor>(entry.getValue()));
	}
	return cpy;
    }

}
