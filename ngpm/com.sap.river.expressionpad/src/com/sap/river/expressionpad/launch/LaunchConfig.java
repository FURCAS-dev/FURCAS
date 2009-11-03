package com.sap.river.expressionpad.launch;

import java.util.Arrays;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import com.sap.river.expressionpad.Main;
import com.sap.river.interpreter.objects.RiverObject;

public class LaunchConfig implements ILaunchConfigurationDelegate {
    private static Logger log = Logger.getLogger(LaunchConfig.class.getName());

    @Override
    public void launch(final ILaunchConfiguration configuration, String mode, ILaunch launch,
	    IProgressMonitor monitor) throws CoreException {
	final Main main = new Main(configuration.getAttribute(RunletMainTab.PROJECT_ATTRIBUTE,
		RunletMainTab.NGPM_STDLIB));
	if (mode.equals("debug")) {
	    RunletDebugTarget debugTarget = new RunletDebugTarget(main, launch, configuration
		    .getName());
	    launch.addDebugTarget(debugTarget);
	    launch.addProcess(debugTarget.getProcess());
	    // TODO for testing, request to suspend immediately
	    debugTarget.suspend();
	    //debugSession.suspend(main.getInterpreter());
	}
	new Thread(mode + " Runlet " + configuration.getName()) {
	    public void run() {
		try {
		    RiverObject[] result = main.evaluate(configuration.getAttribute(
			    RunletMainTab.EXPRESSION_ATTRIBUTE, "")); //$NON-NLS-1$
		    main.getInterpreter().terminate();
		    log.info(Messages.LaunchConfig_1 + Arrays.asList(result));
		} catch (Exception e) {
		    log.throwing(getClass().getName(), "launch", e); //$NON-NLS-1$
		}
	    }
	}.start();
    }
}
