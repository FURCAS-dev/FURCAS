package com.sap.ide.treeprovider.internal.explorer;

import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class ModelElementViewerSorter extends ViewerSorter {

    public ModelElementViewerSorter() {
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
	if (e1 instanceof GenericRefObjectNode && e2 instanceof GenericRefObjectNode) {
	    GenericRefObjectNode n1 = (GenericRefObjectNode) e1;
	    GenericRefObjectNode n2 = (GenericRefObjectNode) e2;
	    if (n1.getParent() instanceof GenericRefObjectNode) {
		GenericRefObjectNode p = (GenericRefObjectNode) n1.getParent();
		RefObject n1RO = n1.getValue();
		RefObject n2RO = n2.getValue();
		RefObject pRO = p.getValue();
		JmiHelper jmiHelper = pRO.get___Connection().getJmiHelper();
		RefAssociation a1 = findCompositeAssoc(n1RO, pRO, jmiHelper);
		RefAssociation a2 = findCompositeAssoc(n2RO, pRO, jmiHelper);
		if (a1 != a2) {
		    // n1 and n2 in different composite associations; sort by
		    // association
		    return a1.refMetaObject().getName().compareTo(a2.refMetaObject().getName());
		} else if (a1 != null) { // then a2 != null as well
		    Collection<RefObject> l = a1.refQuery(jmiHelper.getCompositeAssociationEnd(a1
			    .refMetaObject()), pRO);
		    if (l instanceof List<?>) {
			return ((List<?>) l).indexOf(n1RO) - ((List<?>) l).indexOf(n2RO);
		    }
		}
	    }
	}
	return super.compare(viewer, e1, e2);
    }

    private RefAssociation findCompositeAssoc(RefObject child, RefObject parent, JmiHelper jmiHelper) {
	// find a composite association with ordered child end where p/n1 is a link
	for (AssociationEnd ae : jmiHelper.getAssociationEnds((Classifier) parent.refMetaObject(), /* includeSupertypes */true)) {
	    if (ae.getAggregation().equals(AggregationKindEnum.COMPOSITE)) {
		RefAssociation assoc = jmiHelper.getRefAssociationForAssociation((Association) ae.getContainer());
		RefObject first1;
		RefObject second1;
		if (jmiHelper.isFirstAssociationEnd((Association) ae.getContainer(), ae)) {
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
