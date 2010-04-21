package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;

public class AttributeCallExpTracer extends AbstractTracer<PropertyCallExp> {
	public AttributeCallExpTracer(PropertyCallExp expression) {
		super(expression);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
		NavigationStep result;
		OCLExpression source = (OCLExpression) getExpression().getSource();
		EClassifier type = source.getType();
		OCLExpression sourceExpression = null;
		if (type instanceof TupleType) {
			String referredAttributeName = getExpression().getReferredProperty().getName();
			BasicEList<Variable> tupleParts = (BasicEList<Variable>) ((TupleLiteralExp) ((BasicEList<OCLExpression>) ((ATypeOclExpressionImpl) getConnection()
					.getAssociation(ATypeOclExpression.ASSOCIATION_DESCRIPTOR)).getOclExpression(type))
					.iterator().next()).getTuplePart();
			for (Iterator<Variable> i = tupleParts.iterator(); i.hasNext();) {
				Variable tuplePart = i.next();
				if (tuplePart.getName().equals(referredAttributeName)) {
					sourceExpression = (OCLExpression) tuplePart.getInitExpression();
					break;
				}
			}
			if (sourceExpression == null) {
				throw new RuntimeException("Internal error. Couldn't find tuple part named " + referredAttributeName);
			}
			result = pathCache.getOrCreateNavigationPath(sourceExpression, context, classScopeAnalyzer);
		} else {
			sourceExpression = (OCLExpression) getExpression().getSource();
			result = pathCache.navigationStepFromSequence(
					getExpression(),
					new RefImmediateCompositeNavigationStep(
							(EClass) getExpression().getType(),
							(EClass) type, (OCLExpression)getExpression()),
					pathCache.getOrCreateNavigationPath(sourceExpression, context, classScopeAnalyzer));
		}
		return result;
	}

}
