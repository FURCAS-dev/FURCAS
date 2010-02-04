package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.omg.ocl.expressions.AVariableLetExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.__impl.AVariableLetExpImpl;
import org.omg.ocl.expressions.__impl.IterateExpImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.PropertyCallExpInternal;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableExpImpl;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;

public class VariableExpTracer extends AbstractTracer<VariableExpImpl> {
    public VariableExpTracer(CoreConnection conn, VariableExpImpl expression) {
	super(conn, expression);
    }

    private VariableDeclarationImpl getVariableDeclaration() {
	return (VariableDeclarationImpl) getExpression().getReferredVariable(getConnection());
    }

    private boolean isNull() {
	return getVariableDeclaration().getName().equals("null");
    }

    private boolean isLetVariable() {
	return ((AVariableLetExpImpl) getConnection().getAssociation(AVariableLetExp.ASSOCIATION_DESCRIPTOR))
		.getLetExp(getConnection(), getVariableDeclaration()) != null;
    }

    private boolean isOperationParameter() {
	OclExpression rootExpression = getRootExpression();
	OperationImpl op = InstanceScopeAnalysis.getDefines(getConnection(), rootExpression);
	String variableName = getVariableDeclaration().getName();
	JmiListImpl<ModelElement> pList = (JmiListImpl<ModelElement>) op.getContents(getConnection());
	for (Iterator<ModelElement> i=pList.iterator(getConnection()); i.hasNext(); ) {
	    ModelElement p = i.next();
	    if (p instanceof Parameter && ((Parameter) p).getDirection() == DirectionKindEnum.IN_DIR
		    && variableName.equals(((Parameter) p).getName())) {
		return true;
	    }
	}
	return false;
    }

    private boolean isIterateResultVariable() {
	return getVariableDeclaration().getBaseExp(getConnection()) != null;
    }

    private boolean isIteratorVariable() {
	return getVariableDeclaration().getLoopExpr(getConnection()) != null;
    }

    private boolean isSelf() {
	return getVariableDeclaration().getVarName().equals(OclConstants.VAR_SELF);
    }

    @Override
    public NavigationStep traceback(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	NavigationStep result;
	if (isSelf()) {
	    result = tracebackSelf(context, pathCache, classScopeAnalyzer);
	} else if (isIteratorVariable()) {
	    result = tracebackIteratorVariable(context, pathCache, classScopeAnalyzer);
	} else if (isIterateResultVariable()) {
	    result = tracebackIterateResultVariable(context, pathCache, classScopeAnalyzer);
	} else if (isLetVariable()) {
	    result = tracebackLetVariable(context, pathCache, classScopeAnalyzer);
	} else if (isOperationParameter()) {
	    result = tracebackOperationParameter(context, pathCache, classScopeAnalyzer);
	} else if (isNull()) {
	    result = new EmptyResultNavigationStep(getExpression());
	} else {
	    throw new RuntimeException("Unknown variable expression that is neither an iterator variable "
		    + "nor an iterate result variable nor an operation parameter nor a let variable nor self: "
		    + getExpression().getReferredVariable(getConnection()).getName());
	}
	return result;
    }

    private NavigationStep tracebackOperationParameter(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	OclExpression rootExpression = getRootExpression();
	OperationImpl op = InstanceScopeAnalysis.getDefines(getConnection(), rootExpression);
	int pos = getParameterPosition(op);
	List<NavigationStep> stepsPerCall = new ArrayList<NavigationStep>();
	IndirectingStep indirectingStep = pathCache.createIndirectingStepFor(getExpression());
	for (OperationCallExp call : classScopeAnalyzer.getCallsOf((OclExpressionInternal) rootExpression)) {
	    OclExpression argumentExpression = ((JmiListImpl<OclExpression>) ((OperationCallExpImpl) call).getArguments(getConnection())).
	    	get(getConnection().getSession(), pos);
	    stepsPerCall.add(pathCache.getOrCreateNavigationPath(getConnection(), argumentExpression, context, classScopeAnalyzer));
	}
	indirectingStep.setActualStep(new BranchingNavigationStep(getConnection(),
		(MofClass) getExpression().getType(getConnection()), context, (OclExpressionInternal) getExpression(), stepsPerCall.toArray(new NavigationStep[0])));
	return indirectingStep;
    }

    /**
     * Determines the position of the parameter of operation <tt>op</tt> that is named like
     * the variable referred to by this tracer's {@link #getExpression() variable expression). 
     */
    private int getParameterPosition(OperationImpl op) {
	String variableName = getVariableDeclaration().getName();
	// determine position of formal IN_DIR parameter named variableName
	int pos = 0;
	JmiListImpl<ModelElement> pList = (JmiListImpl<ModelElement>) op.getContents(getConnection());
	for (Iterator<ModelElement> i=pList.iterator(getConnection()); i.hasNext(); ) {
	    ModelElement p = i.next();
	    if (p instanceof Parameter && ((Parameter) p).getDirection() == DirectionKindEnum.IN_DIR) {
		if (variableName.equals(((Parameter) p).getName())) {
		    break;
		} else {
		    pos++;
		}
	    }
	}
	return pos;
    }

    private NavigationStep tracebackLetVariable(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	return pathCache.getOrCreateNavigationPath(getConnection(), getVariableDeclaration()
		.getInitExpression(getConnection()), context, classScopeAnalyzer);
    }

    private NavigationStep tracebackIterateResultVariable(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	NavigationStep stepForInitExpression = pathCache.getOrCreateNavigationPath(getConnection(), getVariableDeclaration()
		.getInitExpression(getConnection()), context, classScopeAnalyzer);
	NavigationStep stepForBodyExpression = pathCache.getOrCreateNavigationPath(getConnection(), ((IterateExpImpl) getVariableDeclaration()
		.getBaseExp(getConnection())).getBody(getConnection()), context, classScopeAnalyzer);
	return new BranchingNavigationStep(getConnection(),
		(MofClass) getExpression().getType(getConnection()), context, (OclExpressionInternal) getExpression(), stepForInitExpression, stepForBodyExpression);
    }

    private NavigationStep tracebackIteratorVariable(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	return pathCache.getOrCreateNavigationPath(getConnection(), ((PropertyCallExpInternal) getVariableDeclaration()
		.getLoopExpr(getConnection())).getSource(getConnection()), context, classScopeAnalyzer);
    }

    private NavigationStep tracebackSelf(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	NavigationStep result;
	OperationImpl op = InstanceScopeAnalysis.getDefines(getConnection(), getRootExpression());
	if (op != null) {
	    // in an operation, self needs to be traced back to all source expressions of
	    // calls to that operation
	    Collection<OperationCallExp> calls = classScopeAnalyzer.getCallsOf((OclExpressionInternal) getRootExpression());
	    IndirectingStep indirectingStep = pathCache.createIndirectingStepFor(getExpression());
	    List<NavigationStep> stepsForCalls = new ArrayList<NavigationStep>();
	    for (OperationCallExp call : calls) {
		OclExpression callSource = ((OperationCallExpImpl) call).getSource(getConnection());
		stepsForCalls.add(pathCache.getOrCreateNavigationPath(getConnection(), callSource, context, classScopeAnalyzer));
	    }
	    indirectingStep.setActualStep(new BranchingNavigationStep(
		    getConnection(),
		    (MofClass) getExpression().getType(getConnection()), context, (OclExpressionInternal) getExpression(), stepsForCalls.toArray(new NavigationStep[0])));
	    result = indirectingStep;
	} else {
	    // self occurred outside of an operation; it evaluates to s for s being the context
	    result = new IdentityNavigationStep(getConnection(), (MofClass) getExpression().getType(getConnection()),
		    (MofClass) getExpression().getType(getConnection()), (OclExpressionInternal) getExpression());
	}
	return result;
    }

}
