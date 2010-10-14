package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.extraction;

import y.base.Node;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.GraphContext;

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
