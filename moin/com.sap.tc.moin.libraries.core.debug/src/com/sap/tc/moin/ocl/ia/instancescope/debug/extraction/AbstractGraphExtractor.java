package com.sap.tc.moin.ocl.ia.instancescope.debug.extraction;

import java.util.HashSet;
import java.util.Set;

import y.base.Node;

import com.sap.tc.moin.ocl.ia.instancescope.AbstractNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.debug.GraphContext;

public abstract class AbstractGraphExtractor implements GraphExtractor {
    private NavigationStep navigationStepDelegate;

    public AbstractGraphExtractor(NavigationStep delegate) {
	this.navigationStepDelegate = delegate;
    }

    protected NavigationStep getNavigationStepDelegate() {
	return navigationStepDelegate;
    }

    @Override
    public Node buildGraph(GraphContext graphContext) {
	// Create a new root group node
	return buildGraph(graphContext, graphContext.createRootNode(), null);
    }

    @Override
    public boolean hasBeenNavigated() {
	if (((AbstractNavigationStep) getNavigationStepDelegate()).getNavigateCounter() > 0) {
	    return true;
	} else {
	    return false;
	}
    }
    
    public int getSumOfNavigateCounter(){
	Set<NavigationStep> visited = new HashSet<NavigationStep>();
	return visited.contains(this) ? 0 : getSumOfNavigateCounter(visited);
    }
    
    public int getSumOfNavigateCounter(Set<NavigationStep> visited){
	return ((AbstractNavigationStep)getNavigationStepDelegate()).getNavigateCounter();
    }
}
