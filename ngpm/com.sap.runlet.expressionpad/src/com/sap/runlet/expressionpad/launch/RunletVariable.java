package com.sap.runlet.expressionpad.launch;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import com.sap.runlet.abstractinterpreter.AbstractObjectFormatter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.expressionpad.Activator;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;

public class RunletVariable extends DebugElement implements IVariable {
    private String name;
    private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value;
    private final AbstractObjectFormatter<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation> formatter;
    
    public RunletVariable(String name, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value, RunletDebugTarget debugTarget, AbstractObjectFormatter<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation> formatter) {
	super(debugTarget);
	this.name = name;
	this.value = value;
	this.formatter = formatter;
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
	return formatter.formatType(value);
    }

    @Override
    public IValue getValue() {
	return new RunletValue(value, getDebugTarget(), formatter);
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
