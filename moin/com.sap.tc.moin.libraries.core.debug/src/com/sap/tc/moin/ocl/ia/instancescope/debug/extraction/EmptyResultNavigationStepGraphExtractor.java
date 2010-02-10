package com.sap.tc.moin.ocl.ia.instancescope.debug.extraction;

import y.base.Node;

import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.debug.GraphContext;

public class EmptyResultNavigationStepGraphExtractor extends NavigationStepGraphExtractor{

    public EmptyResultNavigationStepGraphExtractor(NavigationStep navigationStep) {
	super(navigationStep);
    }
    
    @Override
    public Node buildGraph(GraphContext graphContext, Node parentGroupNode, Node precedingNode) {
        Node result = super.buildGraph(graphContext, parentGroupNode, precedingNode);
        graphContext.applyEmptyNodeColor(result);
        return result;
    }

}
