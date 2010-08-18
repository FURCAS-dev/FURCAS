package com.sap.ide.refactoring.core.textual;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbUtil;


public class TextBlockInChangeCalculator {

    public static class ModelElementTextBlockTuple {

	public final EObject modelElement;
	public final TextBlock textBlock;

	public ModelElementTextBlockTuple(EObject modelElement, TextBlock textBlock) {
	    this.modelElement = modelElement;
	    this.textBlock = textBlock;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((modelElement == null) ? 0 : modelElement.hashCode());
	    result = prime * result + ((textBlock == null) ? 0 : textBlock.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    ModelElementTextBlockTuple other = (ModelElementTextBlockTuple) obj;
	    if (modelElement == null) {
		if (other.modelElement != null)
		    return false;
	    } else if (!modelElement.equals(other.modelElement))
		return false;
	    if (textBlock == null) {
		if (other.textBlock != null)
		    return false;
	    } else if (!textBlock.equals(other.textBlock))
		return false;
	    return true;
	}
    }

    private Map<EObject, List<ModelElementTextBlockTuple>> correspondingTextBlocksPerRootObject = new HashMap<EObject, List<ModelElementTextBlockTuple>>();
    private Map<EObject, List<ModelElementTextBlockTuple>> referencingTextBlocksPerRootObject = new HashMap<EObject, List<ModelElementTextBlockTuple>>();


    public void add(EObject modelElement) {
	for (EObject decoratedDomainRootObject : findDecoratedDomainRootObjects(modelElement)) {

	    for (DocumentNode tbToAdd : findCorrespondingTextBlocks(modelElement)) {
		if (!isValidTextBlock(tbToAdd)) {
		    continue;
		}
		mergeTextBlockIntoList(modelElement, tbToAdd, getCorrespondingTextBlockListOfComposite(decoratedDomainRootObject));
	    }

	    for (DocumentNode tbToAdd : findReferencedTextBlocks(modelElement)) {
		if (!isValidTextBlock(tbToAdd)) {
		    continue;
		}
		mergeTextBlockIntoList(modelElement, tbToAdd, getReferencingTextBlockListOfComposite(decoratedDomainRootObject));
	    }
	}
    }

    private boolean isValidTextBlock(DocumentNode tbToAdd) {
	if (!TbUtil.getNewestVersion(tbToAdd).equals(tbToAdd)) {
	    System.out.println("Skipping TB because it was of an older version");
	    return false;
	}
	return true;
    }

    private void mergeTextBlockIntoList(EObject modelElement, DocumentNode tbToAdd, List<ModelElementTextBlockTuple> textBlocks) {
	int insertPosition = findInsertPosition(tbToAdd, textBlocks);
	if (insertPosition >= 0) {
	    removeChildBlocks(insertPosition, tbToAdd, textBlocks);
	    TextBlock textBlock = tbToAdd instanceof TextBlock ? (TextBlock) tbToAdd : TbNavigationUtil.getParentBlock(tbToAdd);
	    textBlocks.add(insertPosition, new ModelElementTextBlockTuple(modelElement, textBlock));
	} else {
	    // No need to add tbToAdd. We have already stored a parent Block.
	}
    }

    private int findInsertPosition(DocumentNode tbToAdd, List<ModelElementTextBlockTuple> textBlocks) {
	ListIterator<ModelElementTextBlockTuple> iter = textBlocks.listIterator();
	int insertPosition = 0;
	while (iter.hasNext()) {
	    insertPosition = iter.nextIndex();
	    DocumentNode currentTb = iter.next().textBlock;
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
		    DocumentNode tbLeftOfInsertPosition = iter.previous().textBlock;
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

    private void removeChildBlocks(int insertPosition, DocumentNode tbToAdd, List<ModelElementTextBlockTuple> textBlocks) {
	if (insertPosition == textBlocks.size()) {
	    // insert at the end, so there is nothing behind us and therefore
	    // nothing to delete.
	} else {
	    ListIterator<ModelElementTextBlockTuple> iter = textBlocks.listIterator(insertPosition);
	    while (iter.hasNext()) {
		DocumentNode tbRightOfInsertPosition = iter.next().textBlock;
		int coveredRange = tbRightOfInsertPosition.getOffset() + tbRightOfInsertPosition.getLength();
		if (coveredRange <= tbToAdd.getOffset() + tbToAdd.getLength()) {
		    // tbToAdd is a superBlock of tbRightOfInsertPosition. We can delete it.
		    iter.remove();
		}
	    }
	}
    }

    private Collection<EObject> findDecoratedDomainRootObjects(EObject modelElement) {
	ResourceSet co = modelElement.get___Connection();
	DocumentNodeReferencesCorrespondingModelElement assoc = co.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR).getDocumentNodeReferencesCorrespondingModelElement();
	Set<EObject> roots = new HashSet<EObject>();
	for (DocumentNode node : assoc.getDocumentNode(modelElement)) {
	    DocumentNode tbRootNode = TbNavigationUtil.getUltraRoot(node);
	    roots.addAll(assoc.getCorrespondingModelElements(tbRootNode));
	}
	return roots;
    }

    private List<ModelElementTextBlockTuple> getCorrespondingTextBlockListOfComposite(EObject decoratedDomainRootObject) {
	if (!correspondingTextBlocksPerRootObject.containsKey(decoratedDomainRootObject)) {
	    correspondingTextBlocksPerRootObject.put(decoratedDomainRootObject, new LinkedList<ModelElementTextBlockTuple>());
	}
	return correspondingTextBlocksPerRootObject.get(decoratedDomainRootObject);
    }

    private List<ModelElementTextBlockTuple> getReferencingTextBlockListOfComposite(EObject decoratedDomainRootObject) {
	if (!referencingTextBlocksPerRootObject.containsKey(decoratedDomainRootObject)) {
	    referencingTextBlocksPerRootObject.put(decoratedDomainRootObject, new LinkedList<ModelElementTextBlockTuple>());
	}
	return referencingTextBlocksPerRootObject.get(decoratedDomainRootObject);
    }

    private Collection<DocumentNode> findCorrespondingTextBlocks(EObject modelElement) {
	ResourceSet co = modelElement.get___Connection();
	DocumentNodeReferencesCorrespondingModelElement assoc = co.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR).getDocumentNodeReferencesCorrespondingModelElement();
	return assoc.getDocumentNode(modelElement);
    }

    private Collection<DocumentNode> findReferencedTextBlocks(EObject modelElement) {
	ResourceSet co = modelElement.get___Connection();
	DocumentNodeReferencedElement assoc = co.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR).getDocumentNodeReferencedElement();
	return assoc.getDocumentNode(modelElement);
    }

    public Map<EObject, List<ModelElementTextBlockTuple>> getTextBlocksNeedingPrettyPrinting() {
	Map<EObject, List<ModelElementTextBlockTuple>> cpy = new HashMap<EObject, List<ModelElementTextBlockTuple>>(correspondingTextBlocksPerRootObject);
	for (Entry<EObject, List<ModelElementTextBlockTuple>> entry : cpy.entrySet()) {
	    cpy.put(entry.getKey(), new LinkedList<ModelElementTextBlockTuple>(entry.getValue()));
	}
	return cpy;

    }

    public Map<EObject, List<ModelElementTextBlockTuple>> getTextBlocksNeedingShortPrettyPrinting() {
	Map<EObject, List<ModelElementTextBlockTuple>> cpy = new HashMap<EObject, List<ModelElementTextBlockTuple>>(referencingTextBlocksPerRootObject);
	for (Entry<EObject, List<ModelElementTextBlockTuple>> entry : cpy.entrySet()) {
	    cpy.put(entry.getKey(), new LinkedList<ModelElementTextBlockTuple>(entry.getValue()));
	}
	return cpy;
    }


}
