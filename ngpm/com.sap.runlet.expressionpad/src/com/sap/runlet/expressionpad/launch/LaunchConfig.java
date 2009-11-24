package com.sap.runlet.expressionpad.launch;

import java.util.Arrays;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.expressionpad.RunletEvaluator;
import com.sap.runlet.interpreter.RunletObjectFormatter;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.TypeDefinition;

public class LaunchConfig implements ILaunchConfigurationDelegate {
    private static Logger log = Logger.getLogger(LaunchConfig.class.getName());

    @Override
    public void launch(final ILaunchConfiguration configuration, String mode, ILaunch launch,
	    IProgressMonitor monitor) throws CoreException {
	final RunletEvaluator main = new RunletEvaluator(configuration.getAttribute(RunletMainTab.PROJECT_ATTRIBUTE,
		RunletMainTab.NGPM_STDLIB));
	if (mode.equals("debug")) {
	    RunletDebugTarget debugTarget = new RunletDebugTarget(main, launch, configuration
		    .getName(), new RunletObjectFormatter());
	    launch.addDebugTarget(debugTarget);
	    launch.addProcess(debugTarget.getProcess());
	    // TODO for testing, request to suspend immediately
	    debugTarget.suspend();
	    //debugSession.suspend(main.getInterpreter());
	}
	new Thread(mode + " Runlet " + configuration.getName()) {
	    public void run() {
		try {
		    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.evaluate(configuration.getAttribute(
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
