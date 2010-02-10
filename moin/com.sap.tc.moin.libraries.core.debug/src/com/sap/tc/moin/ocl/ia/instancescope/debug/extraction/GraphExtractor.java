package com.sap.tc.moin.ocl.ia.instancescope.debug.extraction;


import java.util.Set;

import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.debug.GraphContext;

import y.base.Node;

/**
 * A GraphExtractor is responsible for building a graph structure with all Nodes and Edges out of a NavigationStep and its
 * substeps.
 */
public interface GraphExtractor {
    public Node buildGraph(GraphContext graphContext, Node parent, Node precedingNode);
    
    public Node buildGraph(GraphContext graphContext);
    
    public String getNodeName();

    public boolean hasBeenNavigated();
    
    public int getSumOfNavigateCounter();
    
    public int getSumOfNavigateCounter(Set<NavigationStep> visited);
}
