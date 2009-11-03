package com.sap.river.expressionpad.launch;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.river.expressionpad.Activator;
import com.sap.river.interpreter.objects.RiverObject;

public class RunletVariable extends DebugElement implements IVariable {
    private String name;
    private RiverObject value;
    
    public RunletVariable(String name, RiverObject value, RunletDebugTarget debugTarget) {
	super(debugTarget);
	this.name = name;
	this.value = value;
    }

    public int hashCode() {
	return getName().hashCode() ^ getValue().hashCode();
    }
    
    public boolean equals(Object o) {
	boolean result = false;
	if (o instanceof RunletVariable) {
	    result = getName().equals(((RunletVariable) o).getName()) &&
	    		getValue().equals(((RunletVariable) o).getValue());
	}
	return result;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getReferenceTypeName() {
	return StringFormatter.toString(value.getType());
    }

    @Override
    public IValue getValue() {
	return new RunletValue(value, getDebugTarget());
    }

    @Override
    public boolean hasValueChanged() {
	// TODO support RunletVariable.hasValueChanged
	return false;
    }

    @Override
    public RunletDebugTarget getDebugTarget() {
	return (RunletDebugTarget) super.getDebugTarget();
    }

    @Override
    public String getModelIdentifier() {
	return Activator.PLUGIN_ID;
    }

    @Override
    public void setValue(String expression) {
	// TODO Auto-generated method stub

    }

    @Override
    public void setValue(IValue value) {
	// TODO Auto-generated method stub

    }

    @Override
    public boolean supportsValueModification() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean verifyValue(String expression) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean verifyValue(IValue value) {
	// TODO Auto-generated method stub
	return false;
    }

}
