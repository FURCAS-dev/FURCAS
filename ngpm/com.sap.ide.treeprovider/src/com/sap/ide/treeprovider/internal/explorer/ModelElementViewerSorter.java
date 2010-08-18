package com.sap.ide.treeprovider.internal.explorer;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import com.sap.ide.treeprovider.GenericRefObjectNode;

public class ModelElementViewerSorter extends ViewerSorter {

    public ModelElementViewerSorter() {
    }

    public int compare(Viewer viewer, EObject e1, EObject e2) {
	if (e1 instanceof GenericRefObjectNode && e2 instanceof GenericRefObjectNode) {
	    GenericRefObjectNode n1 = (GenericRefObjectNode) e1;
	    GenericRefObjectNode n2 = (GenericRefObjectNode) e2;
	    if (n1.getParent() instanceof GenericRefObjectNode) {
		GenericRefObjectNode p = (GenericRefObjectNode) n1.getParent();
		EObject n1RO = n1.getValue();
		EObject n2RO = n2.getValue();
		EObject pRO = p.getValue();
		JmiHelper jmiHelper = pRO.get___Connection().getJmiHelper();
		EReference a1 = findCompositeAssoc(n1RO, pRO, jmiHelper);
		EReference a2 = findCompositeAssoc(n2RO, pRO, jmiHelper);
		if (a1 != a2) {
		    // n1 and n2 in different composite associations; sort by
		    // association
		    return a1.refMetaObject().getName().compareTo(a2.refMetaObject().getName());
		} else if (a1 != null) { // then a2 != null as well
		    Collection<EObject> l = a1.refQuery(jmiHelper.getCompositeAssociationEnd(a1
			    .refMetaObject()), pRO);
		    if (l instanceof List<?>) {
			return ((List<?>) l).indexOf(n1RO) - ((List<?>) l).indexOf(n2RO);
		    }
		}
	    }
	}
	return super.compare(viewer, e1, e2);
    }

    private EReference findCompositeAssoc(EObject child, EObject parent, JmiHelper jmiHelper) {
	// find a composite association with ordered child end where p/n1 is a link
	for (EReference ae : jmiHelper.getAssociationEnds((EClassifier) parent.refMetaObject(), /* includeSupertypes */true)) {
	    if (ae.getAggregation().equals(EEnum.COMPOSITE)) {
		EReference assoc = jmiHelper.getRefAssociationForAssociation((EReference) ae.eContainer());
		EObject first1;
		EObject second1;
		if (jmiHelper.isFirstAssociationEnd((EReference) ae.eContainer(), ae)) {
		    first1 = parent;
		    second1 = child;
		} else {
		    first1 = child;
		    second1 = parent;
		}
		if (first1.refIsInstanceOf(jmiHelper.getAssociationEnds(assoc.refMetaObject()).get(0).getType(),
		/* considerSubtypes */true)
			&& second1.refIsInstanceOf(jmiHelper.getAssociationEnds(assoc.refMetaObject()).get(1).getType(),
			/* considerSubtypes */true) && assoc.refLinkExists(first1, second1)) {
		    return assoc;
		}
	    }
	}
	return null;
    }

}
