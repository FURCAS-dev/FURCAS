package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

public class AssociationNavigationStep extends AbstractNavigationStep {
    private static Logger logger = Logger.getLogger(AssociationNavigationStep.class.getName());
    private final AssociationEnd toEnd;
    public AssociationNavigationStep(MofClass sourceType, MofClass targetType, AssociationEnd toEnd, OclExpressionInternal debugInfo) {
	super(sourceType, targetType, debugInfo);
	this.toEnd = toEnd;
    }
    
    @Override
    protected Set<AnnotatedRefObjectImpl> navigate(CoreConnection conn, AnnotatedRefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache, Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting) {
	Set<AnnotatedRefObjectImpl> result;

	Association assoc = (Association) ((AssociationEndInternal) toEnd).getContainer(conn);
	SpiJmiHelper jmiHelper = conn.getCoreJmiHelper();
	RefAssociationImpl refAssoc = (RefAssociationImpl) jmiHelper.getRefAssociationForAssociation(conn.getSession(),
		assoc);
	JmiListImpl<RefObject> objectOrCollection = (JmiListImpl<RefObject>) refAssoc.refQuery(conn,
		((AssociationEndInternal) toEnd).otherEnd(conn), fromObject.getElement());
	result = new LinkedHashSet<AnnotatedRefObjectImpl>(objectOrCollection.size(conn.getSession()));
	for (Iterator<RefObject> i = objectOrCollection.iterator(conn); i.hasNext();) {
	    RefObjectImpl next = (RefObjectImpl) i.next();
	    if (next == null) {
		logger.warning("Got null from a JmiList; probably dangling reference after refDelete()? Skipping element in OCL Instance Scope Impact Analysis");
	    } else {
		result.add(annotateRefObject(conn, fromObject, next));
	    }
	}
	return result;
    }

    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	return toEnd.getName();
    }
}
