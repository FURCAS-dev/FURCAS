package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.omg.ocl.expressions.__impl.AssociationEndCallExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

public class AssociationEndCallExpTracer extends AbstractTracer<AssociationEndCallExpImpl> {
    public AssociationEndCallExpTracer(CoreConnection conn, AssociationEndCallExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s, Classifier context) {
	Association assoc = (Association) (((AssociationEndImpl) getExpression().getReferredAssociationEnd(
		getConnection()))).getContainer(getConnection());
	Classifier sourceType = InstanceScopeAnalysis.getType(getConnection(), getExpression().getSource(getConnection()));
	SpiJmiHelper jmiHelper = getConnection().getCoreJmiHelper();
	RefAssociationImpl refAssoc = (RefAssociationImpl) jmiHelper.getRefAssociationForAssociation(getConnection().getSession(), assoc);
	JmiListImpl<RefObject> sourceObjects = (JmiListImpl<RefObject>) refAssoc.refQuery(getConnection(),
		getExpression().getReferredAssociationEnd(getConnection()), s);
	Set<RefObjectImpl> result = new HashSet<RefObjectImpl>();
	Tracer sourceTracer = InstanceScopeAnalysis.getTracer(getConnection(), getExpression().getSource(getConnection()));
	for (Iterator<RefObject> i=sourceObjects.iterator(getConnection()); i.hasNext(); ) {
	    RefObjectImpl next = (RefObjectImpl) i.next();
	    if (next.refIsInstanceOf(getConnection().getSession(), sourceType, /* considerSubtypes */ true)) {
		result.addAll(sourceTracer.traceback(next, context));
	    }
	}
	return result;
    }

}
