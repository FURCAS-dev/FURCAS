package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.expressions.OCLExpression;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

public class AssociationNavigationStep extends AbstractNavigationStep {
    private final AssociationEnd toEnd;

    public AssociationNavigationStep(EClass sourceType, EClass targetType, AssociationEnd toEnd, OCLExpression<EClassifier> debugInfo) {
	super(sourceType, targetType, debugInfo);
	this.toEnd = toEnd;
    }

    @Override
    protected Set<EObject> navigate(EObject fromObject, Map<Map<NavigationStep, EObject>, Set<EObject>> cache) {
	Set<EObject> result;

	Association assoc = (Association) ((AssociationEndInternal) toEnd).getContainer(conn);
	SpiJmiHelper jmiHelper = conn.getCoreJmiHelper();
	RefAssociationImpl refAssoc = (RefAssociationImpl) jmiHelper.getRefAssociationForAssociation(conn.getSession(),
		assoc);
	EList<EObject> objectOrCollection = (EList<EObject>) refAssoc.refQuery(conn,
		((AssociationEndInternal) toEnd).otherEnd(conn), fromObject);
	result = new LinkedHashSet<EObject>(objectOrCollection.size(conn.getSession()));
	for (Iterator<EObject> i = objectOrCollection.iterator(conn); i.hasNext();) {
	    result.add((EObject) i.next());
	}
	return result;
    }

    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	return toEnd.getName();
    }
}
