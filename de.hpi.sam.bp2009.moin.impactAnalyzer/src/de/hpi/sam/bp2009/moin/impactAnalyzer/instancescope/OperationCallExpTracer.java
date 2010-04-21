package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.EcoreOCLStandardLibrary;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.utilities.PredefinedType;
import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpInternal;

import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;

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
    
    public OperationCallExpTracer(OperationCallExp expression) {
    	super(expression);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	NavigationStep result;
	OperationBodyDefinitionImpl a = (OperationBodyDefinitionImpl) getConnection().getAssociation(
		OperationBodyDefinition.ASSOCIATION_DESCRIPTOR);
	OCLExpression body = a.getBody(getConnection(), getExpression().getReferredOperation(getConnection()));
	if (body != null) {
	    // an OCL-specified operation; trace back using the body expression
	    result = pathCache.getPathForNode(body);
	    if (result == null) {
		IndirectingStep bodyStep = pathCache.createIndirectingStepFor(body);
		Tracer bodyTracer = InstanceScopeAnalysis.getTracer(getConnection(), body);
		NavigationStep actualStep = bodyTracer.traceback(context, pathCache, classScopeAnalyzer);
		bodyStep.setActualStep(actualStep);
		result = bodyStep;
	    }
	} else {
	    String opName = getExpression().getReferredOperation(getConnection()).getName();
	    if (opName.equals(PredefinedType.OCL_AS_TYPE_NAME)) {
		OclExpression argument = ((JmiListImpl<OclExpression>) getExpression().getArguments(getConnection()))
			.get(getConnection().getSession(), 0);
		if (argument instanceof TypeExp) {
		    Classifier type = ((TypeExpImpl) argument).getReferredType(getConnection());
		    IdentityNavigationStep identityStep = new IdentityNavigationStep(getConnection(), (MofClass) getExpression().getType(getConnection()),
			    (MofClass) type, (OclExpressionInternal) getExpression());
		    NavigationStep sourceStep = pathCache.getOrCreateNavigationPath(getConnection(),
			    getExpression().getSource(getConnection()), context, classScopeAnalyzer);
		    result = pathCache.navigationStepFromSequence(getConnection(), getExpression(), identityStep, sourceStep);
		} else {
		    throw new RuntimeException("What else could be the argument of oclAsType if not a TypeExp? "
			    + ((MofClass) argument.refMetaObject()).getName());
		}
	    } else if (sourcePassThroughStdLibOpNames.contains(opName)) {
		// FIXME handle product
		NavigationStep sourcePath = pathCache.getOrCreateNavigationPath(getConnection(), getExpression()
			.getSource(getConnection()), context, classScopeAnalyzer);
		if (argumentPassThroughStdLibOpNames.contains(opName)) {
		    OclExpression argument = ((JmiListImpl<OclExpression>) getExpression()
			    .getArguments(getConnection())).get(getConnection().getSession(), 0);
		    NavigationStep argumentPath = pathCache.getOrCreateNavigationPath(getConnection(), argument, context, classScopeAnalyzer);
		    result = new BranchingNavigationStep(getConnection(), getInnermostElementType(getExpression().getType(
			        getConnection())), context, getExpression(), sourcePath, argumentPath);
		} else {
		    result = sourcePath;
		}
	    } else if (opName.equals(PredefinedType.ALL_INSTANCES_NAME)) {
		// the object from where to trace back later in the navigate method may not
		// conform to the type on which allInstances() is invoked here; for example, the
		// expression may navigate from the result of allInstances() across an association
		// defined on a superclass of the one on which allInstances() was invoked. Therefore,
		// ensure that the typing of the AllInstancesNavigationStep is correct.
		MofClass classifier = (MofClass) ((TypeExpInternal) getExpression().getSource(getConnection()))
			.getReferredType(getConnection());
		result = new AllInstancesNavigationStep(classifier, context, getExpression()); // non-absolute
	    } else {
		result = new EmptyResultNavigationStep(getExpression()); // hope, we didn't forget stdlib operations that pass on
							  // source or argument values into their result
	    }
	}
	return result;
    }

}
