package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.NavigationStepDebugHelperExtension;

public class NavigationStepDebugHelperExtensionImpl implements NavigationStepDebugHelperExtension {

    public NavigationStepDebugHelperExtensionImpl() {

    }

    @Override
    public void printGraph(NavigationStep step, String path) {
	NavigationStepDebugHelperImpl.printGraphFile(step, path);

    }

}
