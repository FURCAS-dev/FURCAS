package com.sap.tc.moin.ocl.ia.instancescope.debug;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.repository.core.CoreConnection;


/**
 * The NavigationStepDebugHelper provides additional functionalities, 
 * which can be used to debug NavigationStep structures.
 * 
 * @author Manuel Holzleitner (d049667)
 */
public class NavigationStepDebugHelper {
    
    public static void printGraphFile(NavigationStep step, CoreConnection conn, String path){
	IConfigurationElement[] configuredElements = Platform.getExtensionRegistry().getConfigurationElementsFor("com.sap.tc.moin.repository.core.navigationStepDebugHelper");
	
	for (IConfigurationElement element : configuredElements) {
	    NavigationStepDebugHelperExtension extension = null;

	    extension = getDebugHelperExtension(element, extension);

	    extension.printGraph(step, conn, path);
	}
	
	if(configuredElements.length == 0)
	    System.out.println("No debug helper extension found. The project com.sap.tc.libraries.core.debug must be found in order to print a GraphML file.");
	

    }

    private static NavigationStepDebugHelperExtension getDebugHelperExtension(IConfigurationElement element, NavigationStepDebugHelperExtension extension) {
	try {
	    extension = (NavigationStepDebugHelperExtension) element.createExecutableExtension("helper");
	} catch (CoreException e) {
	    System.out.println("Graph file cannot be printed because of an exception by calling the debug extension");
	}
	return extension;
    }
}
