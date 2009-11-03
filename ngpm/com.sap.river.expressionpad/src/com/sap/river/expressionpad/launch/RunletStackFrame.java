package com.sap.river.expressionpad.launch;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.river.expressionpad.Activator;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.RiverObject;

import data.classes.Signature;

public class RunletStackFrame extends DebugElement implements IStackFrame {
    private StackFrame stackFrame;
    private RunletThread runletThread;
    
    public RunletStackFrame(RunletThread runletThread, RunletDebugTarget debugTarget, StackFrame stackFrame) {
	super(debugTarget);
	this.runletThread = runletThread;
	this.stackFrame = stackFrame;
    }
    
    public int hashCode() {
	return getStackFrame().hashCode();
    }
    
    public boolean equals(Object o) {
	boolean result = false;
	if (o instanceof RunletStackFrame) {
	    result = getStackFrame().equals(((RunletStackFrame) o).getStackFrame());
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
	if (getStackFrame().getCurrentlyExecutingImplementationOf() != null) {
	    result.append(StringFormatter.toString(getStackFrame().getCurrentlyExecutingImplementationOf()));
	    result.append(' ');
	}
	result.append('[');
	RefObject currentlyEvaluating = getStackFrame().getCurrentlyEvaluating();
	if (currentlyEvaluating != null) {
	    if (currentlyEvaluating instanceof Signature) {
		result.append(StringFormatter.toString((Signature) currentlyEvaluating));
	    } else {
		Method getName;
		try {
		    getName = currentlyEvaluating.getClass().getMethod("getName");
		    if (getName != null) {
			result.append(getName.invoke(currentlyEvaluating));
		    }
		} catch (Exception e) {
		    // just don't add result of getName() then...
		}
		result.append(':');
		result.append(((MofClass) currentlyEvaluating.refMetaObject()).getName());
	    }
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
	StackFrame frame = getStackFrame();
	List<IVariable> result = new LinkedList<IVariable>();
	Map<String, RiverObject> allVisibleVariables = frame.getAllVisibleVariableValues();
	for (String varName : allVisibleVariables.keySet()) {
	    result.add(new RunletVariable(varName, allVisibleVariables.get(varName), getDebugTarget()));
	}
	return result.toArray(new IVariable[result.size()]);
    }

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

    private StackFrame getStackFrame() {
        return stackFrame;
    }

}
