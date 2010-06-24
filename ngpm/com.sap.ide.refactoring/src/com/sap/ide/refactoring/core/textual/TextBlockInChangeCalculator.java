package com.sap.ide.refactoring.core.textual;

import static com.sap.ide.refactoring.core.textual.TextBlockRefactoringUtil.findCorrespondingTextBlocks;
import static com.sap.ide.refactoring.core.textual.TextBlockRefactoringUtil.findReferencedTextBlocks;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import textblocks.AbstractToken;
import textblocks.DocumentNode;
import textblocks.DocumentNodeReferencesCorrespondingModelElement;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.refactoring.core.textual.ModelElementDocumentNodeChangeDescriptor.ChangeType;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * See {@link TextBlocksNeedingPrettyPrintChangeListener}
 * 
 * @author D049157
 *
 */
public class TextBlockInChangeCalculator {

    private Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> correspondingTextBlocksPerRootObject = new HashMap<RefObject, List<ModelElementDocumentNodeChangeDescriptor>>();
    private Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> referencingTextBlocksPerRootObject = new HashMap<RefObject, List<ModelElementDocumentNodeChangeDescriptor>>();


    public void add(RefObject modelElement, ChangeType changeType) {
	if (modelElement instanceof DocumentNode) {
	    // this is a shortcut. We only care about real model elements that changed, but about no events
	    // related to textblocks that happened during pretty printing
	    return;
	}
	
	if (changeType.equals(ChangeType.CREATED)) {
	    // If a new element is created and it is a root element, we need special handling here
	    // TODO
	} else {
	    for (RefObject decoratedDomainRootObject : findDecoratedDomainRootObjects(modelElement)) {
		addCorrespondingTextBlocks(modelElement, changeType, decoratedDomainRootObject);
		addReferencedTextBlocks(modelElement, changeType, decoratedDomainRootObject);
	    }
	}
    }

    private void addCorrespondingTextBlocks(RefObject modelElement, ChangeType changeType, RefObject decoratedDomainRootObject) {
	for (DocumentNode tbToAdd : findCorrespondingTextBlocks(modelElement)) {
	    if (!isValidTextBlock(tbToAdd)) {
		continue;
	    }
	    if (tbToAdd instanceof AbstractToken) {
		// Individual tokens cannot be pretty printed. Add their parent instead.
		addParentTextBlockForToken(modelElement, changeType, decoratedDomainRootObject, tbToAdd);
	    } else {
		assert tbToAdd instanceof TextBlock;
		mergeTextBlockIntoList(modelElement, tbToAdd, changeType, getCorrespondingTextBlockListOfComposite(decoratedDomainRootObject));
	    }
	}
    }

    private void addParentTextBlockForToken(RefObject modelElement, ChangeType changeType,
	    RefObject decoratedDomainRootObject, DocumentNode tbToAdd) {
	// The following is just a heuristic and could probably be improved.
	// (it might happen that we pretty print to much)
	RefObject parent = findParentWithCorrespondingTextBlocks(modelElement, tbToAdd, decoratedDomainRootObject);
	for (DocumentNode documentNode : findCorrespondingTextBlocks(parent)) {
	    // filter AbstractTokens to prevent recursion
	    if (documentNode instanceof TextBlock) {
		mergeTextBlockIntoList(parent, documentNode, changeType, getCorrespondingTextBlockListOfComposite(decoratedDomainRootObject));
		mergeTextBlockIntoList(parent, documentNode, changeType, getReferencingTextBlockListOfComposite(decoratedDomainRootObject));
	    }
	}
    }

    private void addReferencedTextBlocks(RefObject modelElement, ChangeType changeType, RefObject decoratedDomainRootObject) {
	for (DocumentNode tbToAdd : findReferencedTextBlocks(modelElement)) {
	    if (isValidTextBlock(tbToAdd)) {
		mergeTextBlockIntoList(modelElement, tbToAdd, changeType, getReferencingTextBlockListOfComposite(decoratedDomainRootObject));
	    }
	}
    }

    private boolean isValidTextBlock(DocumentNode tbToAdd) {
	if (!TbUtil.getNewestVersion(tbToAdd).equals(tbToAdd)) {
	    return false;
	}
	return true;
    }

    private void mergeTextBlockIntoList(RefObject modelElement, DocumentNode tbToAdd, ChangeType changeType, List<ModelElementDocumentNodeChangeDescriptor> textBlocks) {
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
	    if (currentTb.getOffset() < tbToAdd.getOffset()) {
		// currentTb is left of our insert position
		// If iter.hasNext() is false we will spring out of the while lopp in the next run.
		// In this special case the following incrementation is required, because we want to insert
		// behind the last element, not before.
		insertPosition++;
		continue;
	    } else {
		// currentTb is right of our insert position
		if (iter.hasPrevious()) {
		    DocumentNode tbLeftOfInsertPosition = iter.previous().documentNode;
		    int coveredRange = tbLeftOfInsertPosition.getOffset() + tbLeftOfInsertPosition.getLength();
		    if (coveredRange >= tbToAdd.getOffset() + tbToAdd.getLength()) {
			// tbToAdd is a subBlock of tbLeftOfInsertPosition. No need to add tbToAdd
			return -1;
		    } else {
			return insertPosition;
		    }
		} else {
		    assert insertPosition == 0 : "Only the first element cannot have a previous element.";
		    return 0;
		}
	    }
	}
	assert insertPosition == 0 || insertPosition == textBlocks.size();
	return insertPosition;
    }

    private void removeChildBlocks(int insertPosition, DocumentNode tbToAdd, List<ModelElementDocumentNodeChangeDescriptor> textBlocks) {
	if (insertPosition == textBlocks.size()) {
	    // insert at the end, so there is nothing behind us and therefore
	    // nothing to delete.
	} else {
	    ListIterator<ModelElementDocumentNodeChangeDescriptor> iter = textBlocks.listIterator(insertPosition);
	    while (iter.hasNext()) {
		DocumentNode tbRightOfInsertPosition = iter.next().documentNode;
		int coveredRange = tbRightOfInsertPosition.getOffset() + tbRightOfInsertPosition.getLength();
		if (coveredRange <= tbToAdd.getOffset() + tbToAdd.getLength()) {
		    // tbToAdd is a superBlock of tbRightOfInsertPosition. We can delete it.
		    iter.remove();
		}
	    }
	}
    }

    private Collection<RefObject> findDecoratedDomainRootObjects(RefObject modelElement) {
	Connection co = modelElement.get___Connection();
	DocumentNodeReferencesCorrespondingModelElement assoc = co.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR).getDocumentNodeReferencesCorrespondingModelElement();
	Set<RefObject> roots = new HashSet<RefObject>();
	for (DocumentNode node : assoc.getDocumentNode(modelElement)) {
	    DocumentNode tbRootNode = TbNavigationUtil.getUltraRoot(node);
	    roots.addAll(assoc.getCorrespondingModelElements(tbRootNode));
	}
	return roots;
    }
    
    /** 
     * Find a suitable parent for pretty printing (this implies that the parent has corresponding ModelElements)  
     */
    private RefObject findParentWithCorrespondingTextBlocks(RefObject modelElement, DocumentNode tbToAdd, RefObject decoratedDomainRootObject) {
	RefObject parent = (RefObject) modelElement.refImmediateComposite();
	while (parent != null) {
	    for (DocumentNode parentBlock : findCorrespondingTextBlocks(parent)) {
		if (TbNavigationUtil.getUltraRoot(parentBlock).equals(TbNavigationUtil.getUltraRoot(tbToAdd))) {
		    return parent;
		}
	    }
	    parent = (RefObject) parent.refImmediateComposite();
	}
	return decoratedDomainRootObject; //fallback if we did not return earlier
    }

    private List<ModelElementDocumentNodeChangeDescriptor> getCorrespondingTextBlockListOfComposite(RefObject decoratedDomainRootObject) {
	if (!correspondingTextBlocksPerRootObject.containsKey(decoratedDomainRootObject)) {
	    correspondingTextBlocksPerRootObject.put(decoratedDomainRootObject, new LinkedList<ModelElementDocumentNodeChangeDescriptor>());
	}
	return correspondingTextBlocksPerRootObject.get(decoratedDomainRootObject);
    }

    private List<ModelElementDocumentNodeChangeDescriptor> getReferencingTextBlockListOfComposite(RefObject decoratedDomainRootObject) {
	if (!referencingTextBlocksPerRootObject.containsKey(decoratedDomainRootObject)) {
	    referencingTextBlocksPerRootObject.put(decoratedDomainRootObject, new LinkedList<ModelElementDocumentNodeChangeDescriptor>());
	}
	return referencingTextBlocksPerRootObject.get(decoratedDomainRootObject);
    }

    public Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> getTextBlocksNeedingPrettyPrinting() {
	Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> cpy = new HashMap<RefObject, List<ModelElementDocumentNodeChangeDescriptor>>(correspondingTextBlocksPerRootObject);
	for (Entry<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> entry : cpy.entrySet()) {
	    cpy.put(entry.getKey(), new LinkedList<ModelElementDocumentNodeChangeDescriptor>(entry.getValue()));
	}
	return cpy;
    }

    public Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> getTextBlocksNeedingShortPrettyPrinting() {
	Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> cpy = new HashMap<RefObject, List<ModelElementDocumentNodeChangeDescriptor>>(referencingTextBlocksPerRootObject);
	for (Entry<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> entry : cpy.entrySet()) {
	    cpy.put(entry.getKey(), new LinkedList<ModelElementDocumentNodeChangeDescriptor>(entry.getValue()));
	}
	return cpy;
    }


}
