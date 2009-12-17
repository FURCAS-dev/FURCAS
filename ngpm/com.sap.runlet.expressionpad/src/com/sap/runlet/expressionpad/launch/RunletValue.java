package com.sap.runlet.expressionpad.launch;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import com.sap.runlet.abstractinterpreter.AbstractObjectFormatter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.expressionpad.Activator;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.objects.FunctionFromMethodObject;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.LinkTraversal;
import data.classes.MethodSignature;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;

public class RunletValue extends DebugElement implements IValue {
    private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value;
    private final AbstractObjectFormatter<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation> formatter;

    public RunletValue(RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value,
	    RunletDebugTarget debugTarget,
	    AbstractObjectFormatter<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation> formatter) {
	super(debugTarget);
	this.value = value;
	this.formatter = formatter;
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
	return formatter.formatType(value);
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
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> single : value) {
		result.add(new RunletVariable(""+i, single, getDebugTarget(), formatter));
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
		RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> endValue = ((RunletInterpreter) getDebugTarget().getInterpreter()).navigate(
			(ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) value, oe);
		RunletVariable var = new RunletVariable(oe.getName() + " (from " + ae.getName()
			+ ")", endValue, getDebugTarget(), formatter);
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
			.getImplementation(), (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) value);
		try {
		    RunletInterpreter methodEvalInterpreter = (RunletInterpreter) getDebugTarget().getInterpreter().spawn();
		    com.sap.runlet.interpreter.RunletStackFrame evalFrame = new com.sap.runlet.interpreter.RunletStackFrame();
		    methodEvalInterpreter.push(evalFrame);
		    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> methodCallResult = ffmo.evaluate(methodEvalInterpreter);
		    result.add(new RunletVariable(sig.getName() + "()", methodCallResult,
			    getDebugTarget(), formatter));
		} catch (Exception e) {
		    result.add(new RunletVariable(sig.getName() + "()", new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(sig
			    .getOutput(), ((RunletInterpreter) getDebugTarget().getInterpreter()).getModelAdapter()), getDebugTarget(), formatter));
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
