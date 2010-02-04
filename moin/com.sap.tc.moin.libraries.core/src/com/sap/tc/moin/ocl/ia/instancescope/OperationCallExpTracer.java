package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.HashSet;
import java.util.Set;

import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpInternal;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public class OperationCallExpTracer extends AbstractTracer<OperationCallExpImpl> {
    private static final Set<String> sourcePassThroughStdLibOpNames;
    private static final Set<String> argumentPassThroughStdLibOpNames;
    static {
	 sourcePassThroughStdLibOpNames = new HashSet<String>();
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_ANY);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_ASBAG);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_ASSET);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_ASORDEREDSET);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_ASSEQUENCE);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_AT);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_ATRPRE);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_EXCLUDING);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_FIRST);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_FLATTEN);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_INCLUDING);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_INSERTAT);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_APPEND);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_INTERSECTION);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_OCLASTYPE);
	 sourcePassThroughStdLibOpNames.add(OclConstants.OP_UNION);

	 argumentPassThroughStdLibOpNames = new HashSet<String>();
	 argumentPassThroughStdLibOpNames.add(OclConstants.OP_INCLUDING);
	 argumentPassThroughStdLibOpNames.add(OclConstants.OP_INSERTAT);
	 argumentPassThroughStdLibOpNames.add(OclConstants.OP_APPEND);
	 argumentPassThroughStdLibOpNames.add(OclConstants.OP_UNION);
	 // TODO what about "product"?
    }
    
    public OperationCallExpTracer(CoreConnection conn, OperationCallExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public NavigationStep traceback(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	NavigationStep result;
	OperationBodyDefinitionImpl a = (OperationBodyDefinitionImpl) getConnection().getAssociation(
		OperationBodyDefinition.ASSOCIATION_DESCRIPTOR);
	OclExpression body = a.getBody(getConnection(), getExpression().getReferredOperation(getConnection()));
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
	    if (opName.equals(OclConstants.OP_OCLASTYPE)) {
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
	    } else if (opName.equals(OclConstants.OP_ALLINSTANCES)) {
		// the object from where to trace back later in the navigate method may not
		// conform to the type on which allInstances() is invoked here; for example, the
		// expression may navigate from the result of allInstances() across an association
		// defined on a superclass of the one on which allInstances() was invoked. Therefore,
		// ensure that the typing of the AllInstancesNavigationStep is correct. The
		// AllInstancesNavigationStep 
		MofClass classifier = (MofClass) ((TypeExpInternal) getExpression().getSource(getConnection()))
			.getReferredType(getConnection());
		result = new AllInstancesNavigationStep(classifier, classifier, getExpression()); // non-absolute
	    } else {
		result = new EmptyResultNavigationStep(getExpression()); // hope, we didn't forget stdlib operations that pass on
							  // source or argument values into their result
	    }
	}
	return result;
    }

}
