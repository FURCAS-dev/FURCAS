package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.impl.TypeExpImpl;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

public class OperationCallExpTracer extends AbstractTracer<OperationCallExp> {
    private static final Set<String> sourcePassThroughStdLibOpNames;
    private static final Set<String> argumentPassThroughStdLibOpNames;
    static {
        sourcePassThroughStdLibOpNames = new HashSet<String>();
        sourcePassThroughStdLibOpNames.add(PredefinedType.ANY_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AS_BAG_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AS_SET_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AS_ORDERED_SET_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AS_SEQUENCE_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AT_NAME);
        //	 sourcePassThroughStdLibOpNames.add(PredefinedType.ATRPRE_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.EXCLUDING_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.FIRST_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.FLATTEN_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.INCLUDING_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.INSERT_AT_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.APPEND_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.INTERSECTION_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.OCL_AS_TYPE_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.UNION_NAME);

        argumentPassThroughStdLibOpNames = new HashSet<String>();
        argumentPassThroughStdLibOpNames.add(PredefinedType.INCLUDING_NAME);
        argumentPassThroughStdLibOpNames.add(PredefinedType.INSERT_AT_NAME);
        argumentPassThroughStdLibOpNames.add(PredefinedType.APPEND_NAME);
        argumentPassThroughStdLibOpNames.add(PredefinedType.UNION_NAME);
        // TODO what about "product"?
    }

    private final EAnnotationOCLParser annotationParser;
    
    public OperationCallExpTracer(OperationCallExp expression, String[] tuplePartNames) {
        super(expression, tuplePartNames);
        annotationParser = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
        NavigationStep result;

        OCLExpression body = annotationParser.getExpressionFromAnnotationsOf(getExpression().getReferredOperation(), "body");
        if (body != null) {
            // the operation body may lead to a recursion; to avoid a recursion we first create an
            // indirecting step here and insert it into the path cache so it will be found instead
            // of recurring
            IndirectingStep bodyStep = pathCache.createIndirectingStepFor(getExpression(), getTupleLiteralPartNamesToLookFor());
            // an OCL-specified operation; trace back using the body expression
            NavigationStep actualStep = pathCache.getOrCreateNavigationPath(body, context, filterSynthesizer, getTupleLiteralPartNamesToLookFor());
            bodyStep.setActualStep(actualStep);
            result = bodyStep;
        } else {
            String opName = getExpression().getReferredOperation().getName();
            if (opName.equals(PredefinedType.OCL_AS_TYPE_NAME)) {
                OCLExpression argument = (OCLExpression) (getExpression().getArgument()).get(0);
                if (argument instanceof TypeExp) {
                    EClassifier type = ((TypeExpImpl) argument).getReferredType();
                    IdentityNavigationStep identityStep = new IdentityNavigationStep((EClass) getExpression().getType(), (EClass) type,
                            getExpression());
                    NavigationStep sourceStep = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getSource(),
                            context, filterSynthesizer, getTupleLiteralPartNamesToLookFor());
                    result = pathCache.navigationStepFromSequence(getExpression(), getTupleLiteralPartNamesToLookFor(), identityStep, sourceStep);
                } else {
                    throw new RuntimeException("What else could be the argument of oclAsType if not a TypeExp? "
                            + (argument.eClass()).getName());
                }
            } else if (sourcePassThroughStdLibOpNames.contains(opName)) {
                // FIXME handle product
                NavigationStep sourcePath = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression()
                        .getSource(), context, filterSynthesizer, getTupleLiteralPartNamesToLookFor());
                if (argumentPassThroughStdLibOpNames.contains(opName)) {
                    int paramPos = 0;
                    if (opName.equals(PredefinedType.INSERT_AT_NAME)) {
                        // "insertAt" takes two arguments, the index and the object to add. 
                        // The OCL spec says the index comes first, so getting the first argument makes no sense in this case.
                        paramPos = 1;
                    }
                    OCLExpression argument = (OCLExpression) (getExpression().getArgument()).get(paramPos);
                    NavigationStep argumentPath = pathCache.getOrCreateNavigationPath(argument, context, filterSynthesizer, getTupleLiteralPartNamesToLookFor());
                    result = pathCache.navigationStepForBranch(
                            getInnermostElementType(getExpression().getType()),
                            context,
                            getExpression(),
                            getTupleLiteralPartNamesToLookFor(),
                            sourcePath,
                            argumentPath);
                } else {
                    result = sourcePath;
                }
            } else if (opName.equals(PredefinedType.ALL_INSTANCES_NAME)) {
                // the object from where to trace back later in the navigate method may not
                // conform to the type on which allInstances() is invoked here; for example, the
                // expression may navigate from the result of allInstances() across an association
                // defined on a superclass of the one on which allInstances() was invoked. Therefore,
                // ensure that the typing of the AllInstancesNavigationStep is correct.
                EClass classifier = (EClass) ((TypeExp) getExpression().getSource())
                .getReferredType();
                result = new AllInstancesNavigationStep(classifier, context, getExpression(), pathCache.getOppositeEndFinder()); // non-absolute
            } else {
                result = new EmptyResultNavigationStep(getExpression()); 
                // hope, we didn't forget stdlib operations that pass on
                // source or argument values into their result
            }
        }
        return result;
    }

}
