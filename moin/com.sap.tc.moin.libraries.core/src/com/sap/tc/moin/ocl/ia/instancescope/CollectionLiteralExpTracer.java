package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.__impl.CollectionItemImpl;
import org.omg.ocl.expressions.__impl.CollectionLiteralExpImpl;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public class CollectionLiteralExpTracer extends AbstractTracer<CollectionLiteralExpImpl> {
    public CollectionLiteralExpTracer(CoreConnection conn, CollectionLiteralExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public NavigationStep traceback(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	JmiListImpl<CollectionLiteralPart> parts = (JmiListImpl<CollectionLiteralPart>) getExpression().getParts(
		getConnection());
	Set<NavigationStep> steps = new HashSet<NavigationStep>();
	for (Iterator<CollectionLiteralPart> i = parts.iterator(getConnection()); i.hasNext();) {
	    CollectionLiteralPart part = i.next();
	    if (part instanceof CollectionItem) {
		steps.add(pathCache.getOrCreateNavigationPath(getConnection(), ((CollectionItemImpl) part)
			.getItem(getConnection()), context, classScopeAnalyzer));
	    }
	}
	MofClass innermostType = getInnermostElementType(getExpression().getType(getConnection()));
	return new BranchingNavigationStep(getConnection(), innermostType, context, getExpression(), pathCache, steps.toArray(new NavigationStep[0]));
    }

}
