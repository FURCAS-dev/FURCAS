package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.TupleType;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class PropertyCallExpTracer extends AbstractTracer<PropertyCallExp> {
    public PropertyCallExpTracer(PropertyCallExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        super(expression, tuplePartNames, oclFactory);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        /*
         * In ECore AssociationEndCallExp and AttributeCallExp are both mapped to PropertyCallExp. That's why we need to check
         * what the PropertyCall refers to and create different NavigationSteps for each case.
         *
         * It can happen that an expression contains multiple AssociationEndCallExp for the same association end but with
         * different source expressions with different types. Example: cellSetForAggregationFunction.valueFunction.output versus
         * x.someMethodSignature.output. Navigating back from "output" yields a MethodSignature to which the valueFunction
         * association end cannot connect because it connects to FunctionSignature.
         *
         * The issue is caused by association ends being "polymorphic" in the sense that elements of subclasses of the end's type
         * can be used at that end. Formally, the problem can be explained with a little example. Let's assume we have classes A,
         * B, C and D. C is subclass of B. Let's assume they are connected by association X with ends a:A and c:C, and association
         * Y with ends b:B and d:D, respectively. In ASCII arts:
         *
         * b Y d B ---------- D ^ / \ --- | | | a X c | A ---------- C
         *
         * Let's further assume that there is an OCL expression
         *
         * context B inv: self.d->notEmpty() and self.a.c.d->notEmpty()
         *
         * This expression contains two AssociationEndCallExp for association end d:D, one with static source type B (the self
         * context object), one with static source type C (self.a.c). Now, if a link change event for the Y association occurs,
         * we'll try to trace back the source object to the possible values for self. The source object may be of dynamic type B
         * or C. If it is of type B, it cannot have been the result of self.a.c which is statically of type C which is a subclass
         * of B and hence B doesn't conform to C. We can therefore skip the self.a.c.d path.
         *
         * In concrete terms this means that if backwards-navigating the association referred by the association end call
         * expression handled by this tracer starting from s yields an object that does not conform to the source expression's
         * static type, no further tracing back to self is attempted for that case.
         *
         * This procedure avoids ill-typed association queries downstream, such as in the example, where we would try to navigate
         * X from c to a with a B in hand that is not a C. Therefore, querying the X association would fail with an exception.
         */
        NavigationStep result;
        EStructuralFeature refProp = getExpression().getReferredProperty();

        if (refProp instanceof EReference) {
            result = handleAssociationCall(context, pathCache, operationBodyToCallMapper);
        } else if (refProp instanceof EAttribute) {
            result = handleAttributeCall(context, pathCache, operationBodyToCallMapper);
        } else {
	    throw new RuntimeException(
                    "Unhandled subclass of EStructuralFeature. Revisit PropertyCallExpTracer to implement specific behaviour.");
        }
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

    private NavigationStep handleAssociationCall(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        OCLExpression sourceExp = (OCLExpression) getExpression().getSource();
        EClassifier sourceType = sourceExp.getType();

        if (sourceType instanceof TupleType)
	    return getNavigationStepForTuplePartAccess(context, pathCache, operationBodyToCallMapper, sourceExp);
	else {
            NavigationStep sourceStep = pathCache.getOrCreateNavigationPath(sourceExp, context, operationBodyToCallMapper,
                    getTupleLiteralPartNamesToLookFor(), oclFactory);
            EReference forwardRef = (EReference) getExpression().getReferredProperty();
            NavigationStep reverseTraversal;
            if (forwardRef.getEOpposite() != null) {
                reverseTraversal = new AssociationNavigationStep(getInnermostElementType(getExpression().getType()),
                        getInnermostElementType(sourceType), forwardRef.getEOpposite(), getExpression());
            } else if (forwardRef.isContainment()) {
                /*
                 * opposite of an EContainment Reference is the EContainer
                 */
                reverseTraversal = new RefImmediateCompositeNavigationStep(getInnermostElementType(getExpression().getType()),
                        getInnermostElementType(sourceType), getExpression());
            } else {
                reverseTraversal = new OppositePropertyNavigationStep(forwardRef.getEReferenceType(), (EClass) getExpression()
                        .getSource().getType(), forwardRef, getExpression(), pathCache.getOppositeEndFinder());
            }
            return pathCache.navigationStepFromSequence(getExpression(), getTupleLiteralPartNamesToLookFor(), reverseTraversal,
                    sourceStep);
        }

    }

    private NavigationStep getNavigationStepForTuplePartAccess(EClass context, PathCache pathCache,
            OperationBodyToCallMapper operationBodyToCallMapper, OCLExpression sourceExp) {
        String referredAttributeName = getExpression().getReferredProperty().getName();
        return pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getSource(), context, operationBodyToCallMapper,
                getExtendedListOfTuplePartNames(referredAttributeName), oclFactory);
    }

    private NavigationStep handleAttributeCall(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        OCLExpression sourceExp = (OCLExpression) getExpression().getSource();
        EClassifier sourceType = sourceExp.getType();
        if (sourceType instanceof TupleType)
	    return getNavigationStepForTuplePartAccess(context, pathCache, operationBodyToCallMapper, sourceExp);
	else
	    return pathCache.navigationStepFromSequence(getExpression(), getTupleLiteralPartNamesToLookFor(),
                    new RefImmediateCompositeNavigationStep((EClass) getExpression().getType(), (EClass) sourceType,
                            getExpression()), pathCache.getOrCreateNavigationPath(sourceExp, context, operationBodyToCallMapper,
                            getTupleLiteralPartNamesToLookFor(), oclFactory));
    }
}
