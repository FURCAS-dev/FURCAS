package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;


/**
 * The NavigationStepDebugHelper provides additional functionalities, 
 * which can be used to debug NavigationStep structures.
 * 
 * @author Manuel Holzleitner (d049667)
 */
public class NavigationStepDebugHelper {
    
    public static void printGraphFile(NavigationStep step, String path){
	IConfigurationElement[] configuredElements = Platform.getExtensionRegistry().getConfigurationElementsFor("de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.navigationStepDebugHelper");
	
	for (IConfigurationElement element : configuredElements) {
	    NavigationStepDebugHelperExtension extension = null;

	    extension = getDebugHelperExtension(element, extension);

	    extension.printGraph(step, path);
	}
	
	if(configuredElements.length == 0)
	    System.out.println("No debug helper extension found. The project de.hpi.sam.bp2009.solution.impactAnalyzer.debug must be found in order to print a GraphML file.");

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
