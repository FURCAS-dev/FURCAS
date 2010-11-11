package com.sap.ide.cts.editor.deepcopy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;



public class DeepCopyHelper {

    /**
     * Find all AssociationEnds that have as type the element's type or a
     * supertype.
     * 
     * @param element
     * @return the AssociationEnds whose type is equal or a supertype of the
     *         element's type
     */
    public static Collection<EReference> getAssociationEnds(ResourceSet co, EObject element) {
	return co.getJmiHelper().getAssociationEnds((EClass) (element.refMetaObject()), true);
    }

    /**
     * Returns all elements that are linked to a EObject via a EReference
     * at an EReference
     * 
     * @param actualAssoc
     * @param elemAssocEnd
     * @param originalElement
     * @return
     */
    public static Collection<EObject> getElementsForRefAssociation(ResourceSet co, EReference actualAssoc,
	    EReference elemAssocEnd, EObject originalElement) {
	try {
	    Collection<EObject> links = actualAssoc.refQuery(elemAssocEnd.getName(), originalElement);
	    Collection<EObject> result = new ArrayList<EObject>(links.size());
	    for (EObject element : links) {
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
     * Find the non-derived association element for an EReference.
     * 
     * @param associationEnd
     * @return
     */
    public static EReference getRefAssociationForEnd(ResourceSet co, EReference associationEnd) {
	EReference associationForElement = null;
	if (associationEnd != null) {
	    EReference ass = (EReference) associationEnd.getContainer();
	    if (!ass.isDerived()) {
		associationForElement = co.getJmiHelper().getRefAssociationForAssociation(ass);
	    }
	}
	return associationForElement;
    }

    /**
     * Find the non-derived association element for an EReference.
     * 
     * @param associationEnd
     * @return
     */
    public static EReference getRefAssociationForAssoc(ResourceSet co, EReference ass) {
	EReference associationForElement = null;
	if (!ass.isDerived()) {
	    associationForElement = co.getJmiHelper().getRefAssociationForAssociation(ass);
	}
	return associationForElement;
    }

    /**
     * Returns all immediate composite children of a EObject.
     * 
     * @param element
     *            The parent element
     * @return All immediate composite children of a EObject
     */
    public static Collection<EObject> getCompositeChildrenImmediate(ResourceSet co, EObject element) {
	return co.getJmiHelper().getCompositeChildren(element, false);
    }

    /**
     * Returns the immediate composite parent of a EObject.
     * 
     * @param element
     *            The child element
     * @return the immediate composite parent or null if there is not any
     */
    public static EObject getCompositeParent(ResourceSet co, EObject element) {
	return (EObject) element.refImmediateComposite();
    }

    /**
     * Returns all elements that are linked to a EObject, but not composite
     * children. Note that dangling links return a null!
     * 
     * @param element
     *            The original element
     * @return All linked elements
     */
    public static Collection<EObject> getAllLinkedElements(ResourceSet co, EObject element) {
	Set<EObject> linkedElements = new HashSet<EObject>();
	EReference actualAssoc;
	for (EReference elemAssocEnd : getAssociationEnds(co, element)) {
	    if (!(elemAssocEnd.getAggregation().equals(AggregationKindEnum.COMPOSITE))) {
		actualAssoc = getRefAssociationForEnd(co, elemAssocEnd);
		// actualAssoc can be null when derived
		if (actualAssoc != null) {
		    Collection<EObject> elements = getElementsForRefAssociation(co, actualAssoc, elemAssocEnd, element);
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
     * @see ModelClipboard#addToCompositeParent(EObject, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject[], EReference, com.sap.mi.fwk.ui.dnd.IModelTransferLog)
     * 
     * @param newRoot
     * @return
     */
    public static void linkToCompositeParent(ResourceSet co, EObject source, EObject copy) {
	EObject parent = getCompositeParent(co, source);
	JmiHelper helper = co.getJmiHelper();

	for (EReference assoc : helper.getCompositeAssociations((EClass) parent.refMetaObject(), (EClass) source
		.refMetaObject())) {

	    EReference refAssoc = getRefAssociationForAssoc(co, assoc);
	    EReference compAssocEnd = co.getJmiHelper().getCompositeAssociationEnd(assoc);

	    if (helper.isFirstAssociationEnd(assoc, compAssocEnd) && refAssoc.refLinkExists(parent, source)) {
		refAssoc.refAddLink(parent, copy);
	    } else if (helper.isFirstAssociationEnd(assoc, compAssocEnd.otherEnd()) && refAssoc.refLinkExists(source, parent)) {
		refAssoc.refAddLink(copy, parent);
	    }

	}
    }

    public static IModelTransferTarget getTransferTarget(EObject root) {
	IModelTransferTarget target = ModelAdapterUI.getInstance().adaptObject(root, IModelTransferTarget.class);
	if (target == null) {
	    return new GenericModelCopyStrategy();
	}
	return target;
    }
}
