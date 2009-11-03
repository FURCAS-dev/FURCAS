package com.sap.ide.cts.editor.deepcopy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.dnd.IModelTransferTarget;
import com.sap.mi.fwk.ui.dnd.ModelClipboard;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class DeepCopyHelper {

    /**
     * Find all AssociationEnds that have as type the element's type or a
     * supertype.
     * 
     * @param element
     * @return the AssociationEnds whose type is equal or a supertype of the
     *         element's type
     */
    public static Collection<AssociationEnd> getAssociationEnds(Connection co, RefObject element) {
	return co.getJmiHelper().getAssociationEnds((MofClass) (element.refMetaObject()), true);
    }

    /**
     * Returns all elements that are linked to a RefObject via a RefAssociation
     * at an AssociationEnd
     * 
     * @param actualAssoc
     * @param elemAssocEnd
     * @param originalElement
     * @return
     */
    public static Collection<RefObject> getElementsForRefAssociation(Connection co, RefAssociation actualAssoc,
	    AssociationEnd elemAssocEnd, RefObject originalElement) {
	try {
	    Collection<RefObject> links = actualAssoc.refQuery(elemAssocEnd.getName(), originalElement);
	    Collection<RefObject> result = new ArrayList<RefObject>(links.size());
	    for (RefObject element : links) {
		if (element != null) { // only consider non-dangling links
		    result.add(element);
		}
	    }
	    return result;
	} catch (UnresolvableException e) {
	    // can happen if we mix unwrapped elements from different connections
	    return null;
	}
    }

    /**
     * Find the non-derived association element for an AssociationEnd.
     * 
     * @param associationEnd
     * @return
     */
    public static RefAssociation getRefAssociationForEnd(Connection co, AssociationEnd associationEnd) {
	RefAssociation associationForElement = null;
	if (associationEnd != null) {
	    Association ass = (Association) associationEnd.getContainer();
	    if (!ass.isDerived()) {
		associationForElement = co.getJmiHelper().getRefAssociationForAssociation(ass);
	    }
	}
	return associationForElement;
    }

    /**
     * Find the non-derived association element for an Association.
     * 
     * @param associationEnd
     * @return
     */
    public static RefAssociation getRefAssociationForAssoc(Connection co, Association ass) {
	RefAssociation associationForElement = null;
	if (!ass.isDerived()) {
	    associationForElement = co.getJmiHelper().getRefAssociationForAssociation(ass);
	}
	return associationForElement;
    }

    /**
     * Returns all immediate composite children of a RefObject.
     * 
     * @param element
     *            The parent element
     * @return All immediate composite children of a RefObject
     */
    public static Collection<RefObject> getCompositeChildrenImmediate(Connection co, RefObject element) {
	return co.getJmiHelper().getCompositeChildren(element, false);
    }

    /**
     * Returns the immediate composite parent of a RefObject.
     * 
     * @param element
     *            The child element
     * @return the immediate composite parent or null if there is not any
     */
    public static RefObject getCompositeParent(Connection co, RefObject element) {
	return (RefObject) element.refImmediateComposite();
    }

    /**
     * Returns all elements that are linked to a RefObject, but not composite
     * children. Note that dangling links return a null!
     * 
     * @param element
     *            The original element
     * @return All linked elements
     */
    public static Collection<RefObject> getAllLinkedElements(Connection co, RefObject element) {
	Set<RefObject> linkedElements = new HashSet<RefObject>();
	RefAssociation actualAssoc;
	for (AssociationEnd elemAssocEnd : getAssociationEnds(co, element)) {
	    if (!(elemAssocEnd.getAggregation().equals(AggregationKindEnum.COMPOSITE))) {
		actualAssoc = getRefAssociationForEnd(co, elemAssocEnd);
		// actualAssoc can be null when derived
		if (actualAssoc != null) {
		    Collection<RefObject> elements = getElementsForRefAssociation(co, actualAssoc, elemAssocEnd, element);
		    if (elements != null) {
			linkedElements.addAll(elements);
		    }
		}
	    }
	}
	return linkedElements;
    }

    /**
     * Establish a link between the composite parent of a source object and its
     * copy. 
     * 
     * Before you call this method you might want to rename the copy in
     * order to avoid name clashes within the new formed composite.
     * 
     * @see GenericModelCopyStrategy#prepareLinkingToCompositeParent(String, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject)
     * @see ModelClipboard#addToCompositeParent(RefObject, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject[], Association, com.sap.mi.fwk.ui.dnd.IModelTransferLog)
     * 
     * @param newRoot
     * @return
     */
    public static void linkToCompositeParent(Connection co, RefObject source, RefObject copy) {
	RefObject parent = getCompositeParent(co, source);
	JmiHelper helper = co.getJmiHelper();

	for (Association assoc : helper.getCompositeAssociations((MofClass) parent.refMetaObject(), (MofClass) source
		.refMetaObject())) {

	    RefAssociation refAssoc = getRefAssociationForAssoc(co, assoc);
	    AssociationEnd compAssocEnd = co.getJmiHelper().getCompositeAssociationEnd(assoc);

	    if (helper.isFirstAssociationEnd(assoc, compAssocEnd) && refAssoc.refLinkExists(parent, source)) {
		refAssoc.refAddLink(parent, copy);
	    } else if (helper.isFirstAssociationEnd(assoc, compAssocEnd.otherEnd()) && refAssoc.refLinkExists(source, parent)) {
		refAssoc.refAddLink(copy, parent);
	    }

	}
    }

    public static IModelTransferTarget getTransferTarget(RefObject root) {
	IModelTransferTarget target = ModelAdapterUI.getInstance().adaptObject(root, IModelTransferTarget.class);
	if (target == null) {
	    return new GenericModelCopyStrategy();
	}
	return target;
    }
}
