package com.sap.tc.moin.ocl.ia.instancescope.debug.extraction;

import java.util.ArrayList;
import java.util.Set;

import y.base.Node;
import y.base.NodeList;

import com.sap.tc.moin.ocl.ia.instancescope.AbstractNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStepSequence;
import com.sap.tc.moin.ocl.ia.instancescope.debug.GraphContext;
import com.sap.tc.moin.ocl.ia.instancescope.debug.NavigationStepDebugHelper;


public class NavigationStepSequenceGraphExtractor extends AbstractGraphExtractor {
    
    public NavigationStepSequenceGraphExtractor(NavigationStepSequence navigationStep){
	super(navigationStep);
    }
    
    public NavigationStepSequence getNavigationStep(){
	return (NavigationStepSequence)getNavigationStepDelegate();
    }
    
    @Override
    public Node buildGraph(GraphContext graphContext, Node parentGroupNode, Node precedingNode) {
	NodeList parentNodeList = new NodeList();
	ArrayList<Node> resultingNodes = new ArrayList<Node>();

	Node newParentNode;
	if (graphContext.isNestingActive()) {
	    newParentNode = graphContext.createGroupNode(this.getNavigationStep(), parentGroupNode, parentNodeList);
	    graphContext.setLabelTextForGroupNode("Navigation Sequence", newParentNode);
	} else {
	    newParentNode = parentGroupNode;
	}

	Node newNode = graphContext.createNode(this.getNavigationStep());
	parentNodeList.add(newNode);
	graphContext.getHierarchyManager().groupSubgraph(parentNodeList, newParentNode);
	graphContext.setLabelTextForNode("<< " + this.getNodeName() + ">> Begin", newNode);

	parentNodeList.clear();

	if (precedingNode != null) {	    
	    graphContext.connectNodes(precedingNode, newNode);
	}

	for (NavigationStep step : this.getNavigationStep().getSteps()) {
	    if (step instanceof AbstractNavigationStep) {

		GraphExtractor extractor = NavigationStepDebugHelper.createGraphExtractorForNavigationStep(step);
		if (resultingNodes.size() > 0) {
		    resultingNodes.add(extractor.buildGraph(graphContext, newParentNode, resultingNodes.get(resultingNodes.size() - 1)));
		} else {
		    resultingNodes.add(extractor.buildGraph(graphContext, newParentNode, newNode));
		}
		
	    } else {
		throw new GraphBuildFailedException();
	    }
	}

	Node endNode = graphContext.createEndNode(this.getNavigationStep());
	parentNodeList.add(endNode);
	graphContext.getHierarchyManager().groupSubgraph(parentNodeList, newParentNode);
	graphContext.setLabelTextForNode("<< " + this.getNodeName() + ">> End", endNode);

	if (!resultingNodes.isEmpty()) {
	    graphContext.connectNodes(resultingNodes.get(resultingNodes.size() - 1), endNode);
	} else {
	    graphContext.connectNodes(newNode, endNode);
	}

	return endNode;
    }

    @Override
    public String getNodeName() {
	return "navigation";
    }
    
    @Override
    public int getSumOfNavigateCounter(Set<NavigationStep> visited) {
	int result = 0;
	if (!visited.contains(getNavigationStep())){
	    visited.add(getNavigationStep());
	    for(NavigationStep step : getNavigationStep().getSteps()){
		GraphExtractor extractor = NavigationStepDebugHelper.createGraphExtractorForNavigationStep(step);
		
		result += extractor.getSumOfNavigateCounter(visited);
	    }
	    
	    result += ((AbstractNavigationStep)getNavigationStep()).getNavigateCounter();
	}
	
	return result;
    }
}
