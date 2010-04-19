package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.omg.ocl.expressions.ATypeOclExpression;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.__impl.ATypeOclExpressionImpl;
import org.omg.ocl.expressions.__impl.AttributeCallExpImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.eclipse.ocl.ecore.TupleType;

import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;

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
			BasicEList<VariableDeclaration> tupleParts = (BasicEList<VariableDeclaration>) ((TupleLiteralExp) ((BasicEList<OCLExpression>) ((ATypeOclExpressionImpl) getConnection()
					.getAssociation(ATypeOclExpression.ASSOCIATION_DESCRIPTOR)).getOclExpression(type))
					.iterator().next()).getTuplePart();
			for (Iterator<VariableDeclaration> i = tupleParts.iterator(); i.hasNext();) {
				VariableDeclaration tuplePart = i.next();
				if (tuplePart.getName().equals(referredAttributeName)) {
					sourceExpression = ((VariableDeclarationImpl) tuplePart).getInitExpression();
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
