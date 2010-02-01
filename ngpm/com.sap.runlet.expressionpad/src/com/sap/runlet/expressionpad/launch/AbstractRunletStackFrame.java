package com.sap.runlet.expressionpad.launch;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

import com.sap.runlet.abstractinterpreter.AbstractObjectFormatter;
import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.expressionpad.Activator;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public abstract class AbstractRunletStackFrame<LinkEndMetaObject, TypeUsage, ClassUsage extends TypeUsage, SignatureImplementationType> extends DebugElement implements IStackFrame {
    private StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> stackFrame;
    private RunletThread runletThread;
    private AbstractObjectFormatter<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> formatter;
    
    protected AbstractObjectFormatter<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> getFormatter() {
        return formatter;
    }

    public AbstractRunletStackFrame(RunletThread runletThread, RunletDebugTarget debugTarget,
	    StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> stackFrame, AbstractObjectFormatter<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> formatter) {
	super(debugTarget);
	this.runletThread = runletThread;
	this.stackFrame = stackFrame;
	this.formatter = formatter;
    }
    
    public int hashCode() {
	return getStackFrame().hashCode();
    }
    
    public boolean equals(Object o) {
	boolean result = false;
	if (o instanceof AbstractRunletStackFrame<?, ?, ?, ?>) {
	    result = getStackFrame().equals(((AbstractRunletStackFrame<?, ?, ?, ?>) o).getStackFrame());
	}
	return result;
    }

    @Override
    public int getCharEnd() {
	// TODO good gracious... this is about finding the "source location" in some concrete syntax corresponding to the current stack frame; this suggests we need more information about "where we are" in a StackFrame element
	return 0;
    }

    @Override
    public int getCharStart(){
	// TODO see getCharEnd()
	return 0;
    }

    @Override
    public int getLineNumber() {
	// TODO see getCharEnd()
	return 0;
    }

    @Override
    public String getName() {
	StringBuilder result = new StringBuilder();
	StackFrame<?, ?, ?, SignatureImplementationType> frame = getStackFrame();
	if (frame.getCurrentlyExecutingImplementation() != null) {
	    result.append(getFormatter().formatSignatureOfImpl(frame.getCurrentlyExecutingImplementation()));
	    result.append(' ');
	}
	result.append('[');
	RefObject currentlyEvaluating = getStackFrame().getCurrentlyEvaluating();
	if (currentlyEvaluating != null) {
	    result.append(getFormatter().formatCurrentlyEvaluatingRefObject(currentlyEvaluating));
	}
	result.append(']');
	return result.toString();
    }

    /**
     * Runlet doesn't have registers
     */
    @Override
    public IRegisterGroup[] getRegisterGroups() {
	return new IRegisterGroup[0];
    }

    @Override
    public IThread getThread() {
	return runletThread;
    }

    @Override
    public IVariable[] getVariables() {
	StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> frame = getStackFrame();
	List<IVariable> result = new LinkedList<IVariable>();
	Map<String, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> allVisibleVariables = frame.getAllVisibleVariableValues();
	for (String varName : allVisibleVariables.keySet()) {
	    result.add(createVariable(allVisibleVariables, varName));
	}
	return result.toArray(new IVariable[result.size()]);
    }

    protected abstract RunletVariable createVariable(
	    Map<String, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> allVisibleVariables, String varName);

    @Override
    public boolean hasRegisterGroups() {
	return false;
    }

    @Override
    public boolean hasVariables() {
	return getVariables().length > 0;
    }

    @Override
    public RunletDebugTarget getDebugTarget() {
	return (RunletDebugTarget) super.getDebugTarget();
    }

    @Override
    public String getModelIdentifier() {
	return Activator.PLUGIN_ID;
    }

    /**
     * Stepping into is possible if this is the top frame.
     */
    @Override
    public boolean canStepInto() {
	return getStackFrame() == getDebugTarget().getInterpreter().getCallstack().peek();
    }

    @Override
    public boolean canStepOver() {
	return true;
    }

    @Override
    public boolean canStepReturn() {
	return true;
    }

    @Override
    public boolean isStepping() {
	return getThread().isStepping();
    }

    @Override
    public void stepInto() throws DebugException {
	getThread().stepInto();
    }

    @Override
    public void stepOver() throws DebugException {
	getThread().stepOver();
    }

    @Override
    public void stepReturn() throws DebugException {
	getThread().stepReturn();
    }

    @Override
    public boolean canResume() {
	return getThread().canResume();
    }

    @Override
    public boolean canSuspend() {
	return getThread().canSuspend();
    }

    @Override
    public boolean isSuspended() {
	return getThread().isSuspended();
    }

    @Override
    public void resume() throws DebugException {
	getThread().resume();
    }

    @Override
    public void suspend() throws DebugException {
	getThread().suspend();
    }

    @Override
    public boolean canTerminate() {
	return getThread().canTerminate();
    }

    @Override
    public boolean isTerminated() {
	return getThread().isTerminated();
    }

    @Override
    public void terminate() throws DebugException {
    	getThread().terminate();
    }

    private StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> getStackFrame() {
        return stackFrame;
    }

}
