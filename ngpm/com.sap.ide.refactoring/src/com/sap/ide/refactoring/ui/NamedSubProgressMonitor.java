package com.sap.ide.refactoring.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

/**
 * Workaround: Setting a taskname in a SubProgressManager does not update
 * the task name of its parent progress monitor. 
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class NamedSubProgressMonitor extends SubProgressMonitor {

    public NamedSubProgressMonitor(IProgressMonitor monitor, int ticks) {
	super(monitor, ticks, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
    }
    
    @Override
    public void beginTask(String name, int totalWork) {
        super.beginTask(name, totalWork);
        getWrappedProgressMonitor().subTask(name);
    }
    
}
