package com.sap.tc.moin.ocl.ia.instancescope.debug.extraction;

import java.util.ArrayList;
import java.util.Set;

import y.base.Node;
import y.base.NodeList;

import com.sap.tc.moin.ocl.ia.instancescope.AbstractNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.BranchingNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.debug.GraphContext;
import com.sap.tc.moin.ocl.ia.instancescope.debug.NavigationStepDebugHelperImpl;

public class BranchingNavigationStepGraphExtractor extends AbstractGraphExtractor {

    public BranchingNavigationStepGraphExtractor(BranchingNavigationStep navigationStep){
	super(navigationStep);
    }
    
    public BranchingNavigationStep getNavigationStep(){
	return (BranchingNavigationStep)getNavigationStepDelegate();
    }

    @Override
    public Node buildGraph(GraphContext graphContext, Node parentGroupNode, Node precedingNode) {
	NodeList parentNodeList = new NodeList();
	ArrayList<Node> resultingNodeList = new ArrayList<Node>();

	Node newParentNode;
	if (graphContext.isNestingActive()) {
	    newParentNode = graphContext.createGroupNode(getNavigationStep(), parentGroupNode, parentNodeList);
	    graphContext.setLabelTextForGroupNode("Branch Container", newParentNode);
	} else {
	    newParentNode = parentGroupNode;
	}

	Node newPrecedingNode = graphContext.createNode(getNavigationStep());
	graphContext.setLabelTextForNode("<< " + this.getNodeName() + ">> Begin", newPrecedingNode);

	parentNodeList.add(newPrecedingNode);
	graphContext.getHierarchyManager().groupSubgraph(parentNodeList, newParentNode);

	if (precedingNode != null) {  
	    graphContext.connectNodes(precedingNode, newPrecedingNode);
	}

	for (NavigationStep step : getNavigationStep().getSteps()) {
	    if (step instanceof AbstractNavigationStep) {
		
		GraphExtractor extractor = NavigationStepDebugHelperImpl.createGraphExtractorForNavigationStep(step);
		resultingNodeList.add(extractor.buildGraph(graphContext, newParentNode, newPrecedingNode));

	    } else {
		throw new GraphBuildFailedException();
	    }
	}

	Node endNode = graphContext.createEndNode(getNavigationStep());
	graphContext.setLabelTextForNode("<< " + this.getNodeName() + ">> End", endNode);
	parentNodeList.add(endNode);
	graphContext.getHierarchyManager().groupSubgraph(parentNodeList, newParentNode);

	// Draw edges to end Node
	for (Node branchEndNode : resultingNodeList) {
	    graphContext.connectNodes(branchEndNode, endNode);
	}

	return endNode;
    }
    
    @Override
    public String getNodeName() {
	return "branch";
    }
    
    @Override
    public int getSumOfNavigateCounter(Set<NavigationStep> visited) {
	int result = 0;
	if (!visited.contains(getNavigationStep())){
	    visited.add(getNavigationStep());
	    for(NavigationStep step : getNavigationStep().getSteps()){
		GraphExtractor extractor = NavigationStepDebugHelperImpl.createGraphExtractorForNavigationStep(step);
		
		result += extractor.getSumOfNavigateCounter(visited);
	    }
	    
	    result += ((AbstractNavigationStep)getNavigationStep()).getNavigateCounter();
	}
	
	return result;
    }
}
