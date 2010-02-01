package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

public class AssociationNavigationStep extends AbstractNavigationStep {
    private final AssociationEnd toEnd;

    public AssociationNavigationStep(MofClass sourceType, MofClass targetType, AssociationEnd toEnd, OclExpressionInternal debugInfo) {
	super(sourceType, targetType, debugInfo);
	this.toEnd = toEnd;
    }

    @Override
    protected Collection<RefObjectImpl> navigate(CoreConnection conn, RefObjectImpl fromObject) {
	Collection<RefObjectImpl> result;

	Association assoc = (Association) ((AssociationEndInternal) toEnd).getContainer(conn);
	SpiJmiHelper jmiHelper = conn.getCoreJmiHelper();
	RefAssociationImpl refAssoc = (RefAssociationImpl) jmiHelper.getRefAssociationForAssociation(conn.getSession(),
		assoc);
	JmiListImpl<RefObject> objectOrCollection = (JmiListImpl<RefObject>) refAssoc.refQuery(conn,
		((AssociationEndInternal) toEnd).otherEnd(conn), fromObject);
	result = new ArrayList<RefObjectImpl>(objectOrCollection.size(conn.getSession()));
	for (Iterator<RefObject> i = objectOrCollection.iterator(conn); i.hasNext();) {
	    result.add((RefObjectImpl) i.next());
	}
	return result;
    }

    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int[] maxId, int indent) {
	return toEnd.getName();
    }
}
