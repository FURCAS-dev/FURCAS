package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Iterator;

import org.omg.ocl.expressions.ATypeOclExpression;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.__impl.ATypeOclExpressionImpl;
import org.omg.ocl.expressions.__impl.AttributeCallExpImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.types.TupleType;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public class AttributeCallExpTracer extends AbstractTracer<AttributeCallExpImpl> {
    public AttributeCallExpTracer(CoreConnection conn, AttributeCallExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public NavigationStep traceback(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	NavigationStep result;
	OclExpression source = getExpression().getSource(getConnection());
	Classifier type = ((OclExpressionInternal) source).getType(getConnection());
	OclExpression sourceExpression = null;
	if (type instanceof TupleType) {
	    String referredAttributeName = getExpression().getReferredAttribute(getConnection()).getName();
	    JmiListImpl<VariableDeclaration> tupleParts = (JmiListImpl<VariableDeclaration>) ((TupleLiteralExpImpl) ((JmiListImpl<OclExpression>) ((ATypeOclExpressionImpl) getConnection()
		    .getAssociation(ATypeOclExpression.ASSOCIATION_DESCRIPTOR)).getOclExpression(getConnection(), type))
		    .iterator(getConnection()).next()).getTuplePart(getConnection());
	    for (Iterator<VariableDeclaration> i = tupleParts.iterator(getConnection()); i.hasNext();) {
		VariableDeclaration tuplePart = i.next();
		if (tuplePart.getName().equals(referredAttributeName)) {
		    sourceExpression = ((VariableDeclarationImpl) tuplePart).getInitExpression(getConnection());
		    break;
		}
	    }
	    if (sourceExpression == null) {
		throw new RuntimeException("Internal error. Couldn't find tuple part named " + referredAttributeName);
	    }
	    result = pathCache.getOrCreateNavigationPath(getConnection(), sourceExpression, context, classScopeAnalyzer);
	} else {
	    sourceExpression = getExpression().getSource(getConnection());
	    result = pathCache.navigationStepFromSequence(
		    getConnection(),
		    getExpression(), new RefImmediateCompositeNavigationStep((MofClass) getExpression().getType(getConnection()), (MofClass) type, (OclExpressionInternal) getExpression()), pathCache.getOrCreateNavigationPath(getConnection(), sourceExpression, context, classScopeAnalyzer));
	}
	return result;
    }

}
