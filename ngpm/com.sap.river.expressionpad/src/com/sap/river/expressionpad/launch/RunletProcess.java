package com.sap.river.expressionpad.launch;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

import com.sap.river.expressionpad.Activator;

public class RunletProcess extends DebugElement implements IProcess {
    public RunletProcess(IDebugTarget target) {
	super(target);
	fireCreationEvent();
    }
    
    public int hashCode() {
	return getDebugTarget().hashCode();
    }
    
    public boolean equals(Object o) {
	boolean result = false;
	if (o instanceof RunletProcess) {
	    result = ((RunletProcess) o).getDebugTarget().equals(getDebugTarget());
	}
	return result;
    }
    
    protected void started() {
	fireResumeEvent(DebugEvent.CLIENT_REQUEST);
    }

    @Override
    public String getAttribute(String key) {
	return null;
    }

    @Override
    public int getExitValue() {
	return 0;
    }

    @Override
    public String getLabel() {
	return "Runlet process";
    }

    @Override
    public IStreamsProxy getStreamsProxy() {
	return null;
    }

    @Override
    public void setAttribute(String key, String value) {
    }

    @Override
    public boolean canTerminate() {
	return getDebugTarget().canTerminate();
    }

    @Override
    public boolean isTerminated() {
	return getDebugTarget().isTerminated();
    }

    @Override
    public void terminate() throws DebugException {
	getDebugTarget().terminate();
	fireTerminateEvent();
    }

    @Override
    public String getModelIdentifier() {
	return Activator.PLUGIN_ID;
    }

}
