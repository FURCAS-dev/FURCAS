////////////////////////////////////
// moved to PropertyCallExpTracer //
////////////////////////////////////
//
//package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;
//
//import java.util.Iterator;
//
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EClassifier;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.ocl.ecore.PropertyCallExp;
//import org.eclipse.ocl.ecore.TupleLiteralExp;
//import org.eclipse.ocl.ecore.TupleType;
//import org.eclipse.ocl.expressions.OCLExpression;
//import org.eclipse.ocl.expressions.TupleLiteralPart;
//
//import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;
//
//public class AttributeCallExpTracer extends AbstractTracer<PropertyCallExp> {
//	public AttributeCallExpTracer(PropertyCallExp expression) {
//		super(expression);
//	}
//
//	@Override
//	public NavigationStep traceback(EClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
//		NavigationStep result;
//		OCLExpression<EClassifier> source = getExpression().getSource();
//		EClassifier sourcetype = source.getType();
//		OCLExpression<EClassifier> sourceExpression = null;
//		if (sourcetype instanceof TupleType) {
//			String referredAttributeName = getExpression().getReferredProperty().getName();
////			EList<Variable> tupleParts = (EList<Variable>) ((TupleLiteralExp) ((BasicEList<OCLExpression>) ((ATypeOclExpressionImpl) getConnection()
////					.getAssociation(ATypeOclExpression.ASSOCIATION_DESCRIPTOR)).getOclExpression(type))
////					.iterator().next()).getTuplePart();
//			EList<TupleLiteralPart<EClassifier, EStructuralFeature>> tupleParts = ((TupleLiteralExp)source).getPart();
//			for (Iterator<TupleLiteralPart<EClassifier, EStructuralFeature>> i = tupleParts.iterator(); i.hasNext();) {
//				TupleLiteralPart<EClassifier, EStructuralFeature> tuplePart = i.next();
//				if (tuplePart.getName().equals(referredAttributeName)) {
//					sourceExpression = tuplePart.getValue();
//					break;
//				}
//			}
//			if (sourceExpression == null) {
//				throw new RuntimeException("Internal error. Couldn't find tuple part named " + referredAttributeName);
//			}
//			result = pathCache.getOrCreateNavigationPath(sourceExpression, context, classScopeAnalyzer);
//		} else {
//			sourceExpression = getExpression().getSource();
//			result = pathCache.navigationStepFromSequence(
//			                sourceExpression,
//					new RefImmediateCompositeNavigationStep(
//							(EClass) getExpression().getType(),
//							(EClass) sourcetype,
//							getExpression()),
//					pathCache.getOrCreateNavigationPath(sourceExpression, context, classScopeAnalyzer));
//		}
//		return result;
//	}
//
//}
