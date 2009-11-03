package com.sap.river.expressionpad.launch;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.river.expressionpad.Activator;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.FunctionFromMethodObject;
import com.sap.river.interpreter.objects.RiverObject;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.LinkTraversal;
import data.classes.MethodSignature;
import data.classes.SapClass;
import data.classes.TypeDefinition;

public class RunletValue extends DebugElement implements IValue {
    private RiverObject value;

    public RunletValue(RiverObject value, RunletDebugTarget debugTarget) {
	super(debugTarget);
	this.value = value;
    }

    public int hashCode() {
	return value.hashCode();
    }
    
    public boolean equals(Object o) {
	boolean result = false;
	if (o instanceof RunletValue) {
	    result = value.equals(((RunletValue) o).value);
	}
	return result;
    }

    @Override
    public String getReferenceTypeName() {
	return StringFormatter.toString(value.getType());
    }

    @Override
    public String getValueString() {
	return value.toString();
    }

    /**
     * If {@link #value} has a many-multiplicity, the "variables" are the individual objects that result
     * from iterating the value. Otherwise, all attaching association ends navigable away from the
     * value are determined, as well as all no-arg side effect-free operations available on the class.
     */
    @Override
    public IVariable[] getVariables() {
	List<IVariable> result = new LinkedList<IVariable>();
	TypeDefinition td = value.getType();
	if (td.isMany()) {
	    // stable order?
	    int i=0; // for "naming" the variables
	    for (RiverObject single : value) {
		result.add(new RunletVariable(""+i, single, getDebugTarget()));
	    }
	} else {
	    if (!value.isEmpty() && td instanceof ClassTypeDefinition) {
		result = getVariablesFromClassTypedObject();
	    }
	}
	return result.toArray(new IVariable[result.size()]);
    }

    private List<IVariable> getVariablesFromClassTypedObject() {
	List<IVariable> result = new LinkedList<IVariable>();
	SapClass c = ((ClassTypeDefinition) value.getType()).getClazz();
	for (AssociationEnd ae : c.getConformsToAssociationEnds()) {
	    AssociationEnd oe = ae.otherEnd();
	    if (oe.isNavigable()) {
		RiverObject endValue = getDebugTarget().getInterpreter().navigate(
			(ClassTypedObject) value, oe);
		RunletVariable var = new RunletVariable(oe.getName() + " (from " + ae.getName()
			+ ")", endValue, getDebugTarget());
		result.add(var);
	    }
	}
	for (MethodSignature sig : c.allSignatures()) {
	    if (sig.getInput().size() == 0 && sig.getOutput() != null && sig.isSideEffectFree() &&
		    // filter out the link traversals; those we have already from
		    // the association ends handled above
		    !(sig.getImplementation() instanceof LinkTraversal)) {
		FunctionFromMethodObject ffmo = new FunctionFromMethodObject(
		/* type definition not needed for simple invocation */null, sig
			.getImplementation(), (ClassTypedObject) value);
		try {
		    RiverInterpreter methodEvalInterpreter = getDebugTarget().getInterpreter().spawn();
		    StackFrame evalFrame = new StackFrame();
		    methodEvalInterpreter.push(evalFrame);
		    RiverObject methodCallResult = ffmo.evaluate(methodEvalInterpreter);
		    result.add(new RunletVariable(sig.getName() + "()", methodCallResult,
			    getDebugTarget()));
		} catch (Exception e) {
		    result.add(new RunletVariable(sig.getName() + "()", new EmptyObject(sig
			    .getOutput()), getDebugTarget()));
		}
	    }
	}
	return result;
    }

    @Override
    public boolean hasVariables() {
	return getVariables().length > 0;
    }

    @Override
    public boolean isAllocated() {
	return true;
    }

    @Override
    public RunletDebugTarget getDebugTarget() {
	return (RunletDebugTarget) super.getDebugTarget();
    }

    @Override
    public String getModelIdentifier() {
	return Activator.PLUGIN_ID;
    }

}
