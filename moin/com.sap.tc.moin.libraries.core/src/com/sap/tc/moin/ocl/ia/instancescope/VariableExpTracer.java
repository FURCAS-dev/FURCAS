package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.omg.ocl.expressions.AReferredOperationOperationCallExp;
import org.omg.ocl.expressions.AVariableLetExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.__impl.AReferredOperationOperationCallExpImpl;
import org.omg.ocl.expressions.__impl.AVariableLetExpImpl;
import org.omg.ocl.expressions.__impl.IterateExpImpl;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.PropertyCallExpInternal;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableExpImpl;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;

public class VariableExpTracer extends AbstractTracer<VariableExpImpl> {
    public VariableExpTracer(CoreConnection conn, VariableExpImpl expression) {
	super(conn, expression);
    }

    private VariableDeclarationImpl getVariableDeclaration() {
	return (VariableDeclarationImpl) getExpression().getReferredVariable(getConnection());
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s) {
	Set<RefObjectImpl> result;
	if (isSelf()) {
	    result = tracebackSelf(s);
	} else if (isIteratorVariable()) {
	    result = tracebackIteratorVariable(s);
	} else if (isIterateResultVariable()) {
	    result = tracebackIterateResultVariable(s);
	} else if (isLetVariable()) {
	    result = tracebackLetVariable(s);
	} else if (isOperationParameter()) {
	    result = tracebackOperationParameter(s);
	} else if (isNull()) {
	    result = Collections.emptySet();
	} else {
	    throw new RuntimeException("Unknown variable expression that is neither an iterator variable "
		    + "nor an iterate result variable nor an operation parameter nor a let variable nor self: "
		    + getExpression().getReferredVariable(getConnection()).getName());
	}
	return result;
    }

    private boolean isNull() {
	return getVariableDeclaration().getName().equals("null");
    }

    private Set<RefObjectImpl> tracebackLetVariable(RefObjectImpl s) {
	Tracer sourceTracer = InstanceScopeAnalysis.getTracer(getConnection(), getVariableDeclaration()
		.getInitExpression(getConnection()));
	return sourceTracer.traceback(s);
    }

    private boolean isLetVariable() {
	return ((AVariableLetExpImpl) getConnection().getAssociation(AVariableLetExp.ASSOCIATION_DESCRIPTOR))
		.getLetExp(getConnection(), getVariableDeclaration()) != null;
    }

    private Set<RefObjectImpl> tracebackOperationParameter(RefObjectImpl s) {
	OclExpression rootExpression = getRootExpression();
	OperationImpl op = InstanceScopeAnalysis.getDefines(getConnection(), rootExpression);
	String variableName = getVariableDeclaration().getName();
	// determine position of formal IN_DIR parameter named variableName
	int pos = 0;
	for (ModelElement p : op.getContents(getConnection())) {
	    if (p instanceof Parameter && ((Parameter) p).getDirection() == DirectionKindEnum.IN_DIR) {
		if (variableName.equals(((Parameter) p).getName())) {
		    break;
		} else {
		    pos++;
		}
	    }
	}
	Set<RefObjectImpl> result = new HashSet<RefObjectImpl>();
	for (OperationCallExp call : getCallsOf(op)) {
	    Tracer actualParameterExpressionTracer = InstanceScopeAnalysis.getTracer(getConnection(),
		    ((JmiListImpl<OclExpression>) ((OperationCallExpImpl) call).getArguments(getConnection())).
		    get(getConnection().getSession(), pos));
	    result.addAll(actualParameterExpressionTracer.traceback(s));
	}
	return result;
    }

    private boolean isOperationParameter() {
	OclExpression rootExpression = getRootExpression();
	OperationImpl op = InstanceScopeAnalysis.getDefines(getConnection(), rootExpression);
	String variableName = getVariableDeclaration().getName();
	for (ModelElement p : op.getContents(getConnection())) {
	    if (p instanceof Parameter && ((Parameter) p).getDirection() == DirectionKindEnum.IN_DIR
		    && variableName.equals(((Parameter) p).getName())) {
		return true;
	    }
	}
	return false;
    }

    private Set<RefObjectImpl> tracebackIterateResultVariable(RefObjectImpl s) {
	Tracer initTracer = InstanceScopeAnalysis.getTracer(getConnection(), getVariableDeclaration()
		.getInitExpression(getConnection()));
	Tracer bodyTracer = InstanceScopeAnalysis.getTracer(getConnection(), ((IterateExpImpl) getVariableDeclaration()
		.getBaseExp(getConnection())).getBody(getConnection()));
	Set<RefObjectImpl> result = new HashSet<RefObjectImpl>();
	result.addAll(initTracer.traceback(s));
	result.addAll(bodyTracer.traceback(s));
	return result;
    }

    private boolean isIterateResultVariable() {
	return getVariableDeclaration().getBaseExp(getConnection()) != null;
    }

    private Set<RefObjectImpl> tracebackIteratorVariable(RefObjectImpl s) {
	Tracer sourceTracer = InstanceScopeAnalysis.getTracer(getConnection(),
		((PropertyCallExpInternal) getVariableDeclaration().getLoopExpr(getConnection()))
			.getSource(getConnection()));
	return sourceTracer.traceback(s);
    }

    private boolean isIteratorVariable() {
	return getVariableDeclaration().getLoopExpr(getConnection()) != null;
    }

    private boolean isSelf() {
	return getVariableDeclaration().getName().startsWith("self(") || getVariableDeclaration().getName().equals("self");
    }

    private Collection<OperationCallExp> getCallsOf(OperationImpl operation) {
	AReferredOperationOperationCallExpImpl a = (AReferredOperationOperationCallExpImpl) getConnection()
		.getAssociation(AReferredOperationOperationCallExp.ASSOCIATION_DESCRIPTOR);
	Set<OperationCallExp> result = new HashSet<OperationCallExp>();
	for (Iterator<OperationCallExp> i = ((JmiListImpl<OperationCallExp>) a.getOperationCallExp(getConnection(),
		operation)).iterator(getConnection()); i.hasNext();) {
	    result.add(i.next());
	}
	// FIXME Due to what seems to be a bug in the MOIN implementation, elements from transient partitions in the metamodel data area are not found; add them here explicitly
	ModelPartition extentPartition = ((Partitionable) this.getConnection().getPackage(
		ModelPackage.PACKAGE_DESCRIPTOR)).get___Partition();
	for (Partitionable p : extentPartition.getElements()) {
	    if (p instanceof OperationCallExp) {
		if (((OperationCallExpImpl) p).getReferredOperation(getConnection()).refMofId().equals(
			    operation.refMofId())) {
		    result.add((OperationCallExp) p);
		}
	    }
	}
	return result;
    }

    private Set<RefObjectImpl> tracebackSelf(RefObjectImpl s) {
	Set<RefObjectImpl> result = new HashSet<RefObjectImpl>();
	OperationImpl op = InstanceScopeAnalysis.getDefines(getConnection(), getRootExpression());
	if (op != null) {
	    // in an operation, self needs to be traced back to all source expressions of
	    // calls to that operation
	    Collection<OperationCallExp> calls = getCallsOf(op);
	    for (OperationCallExp call : calls) {
		OclExpression callSource = ((OperationCallExpImpl) call).getSource(getConnection());
		Tracer sourceTracer = InstanceScopeAnalysis.getTracer(getConnection(), callSource);
		result.addAll(sourceTracer.traceback(s));
	    }
	} else {
	    // self occurred outside of an operation; it evaluates to s for s being the context
	    result.add(s);
	}
	return result;
    }

}
