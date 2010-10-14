package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.extraction;

import java.util.ArrayList;
import java.util.Set;

import y.base.Node;
import y.base.NodeList;
import y.view.LineType;
import y.view.ShapeNodeRealizer;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AbstractNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStepSequence;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.GraphContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.NavigationStepDebugHelperImpl;


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
	
	applyBeginNodeStyle(graphContext, newNode);

	parentNodeList.clear();

	if (precedingNode != null) {	    
	    graphContext.connectNodes(precedingNode, newNode);
	}

	for (NavigationStep step : this.getNavigationStep().getSteps()) {
	    if (step instanceof AbstractNavigationStep) {

		GraphExtractor extractor = NavigationStepDebugHelperImpl.createGraphExtractorForNavigationStep(step);
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
	
	applyEndNodeStyle(graphContext, endNode);

	if (!resultingNodes.isEmpty()) {
	    graphContext.connectNodes(resultingNodes.get(resultingNodes.size() - 1), endNode);
	} else {
	    graphContext.connectNodes(newNode, endNode);
	}

	return endNode;
    }

    private void applyEndNodeStyle(GraphContext graphContext, Node endNode) {
	ShapeNodeRealizer nodeRealizer = new ShapeNodeRealizer();
	nodeRealizer.setShapeType(ShapeNodeRealizer.HEXAGON);
	nodeRealizer.setLineType(LineType.DASHED_1);
	graphContext.changeNodeStyle(endNode, nodeRealizer);
	graphContext.setLabelTextForNode("/" + this.getNodeName(), "", endNode);
    }

    private void applyBeginNodeStyle(GraphContext graphContext, Node newNode) {
	ShapeNodeRealizer nodeRealizer = new ShapeNodeRealizer();
	nodeRealizer.setShapeType(ShapeNodeRealizer.HEXAGON);
	nodeRealizer.setLineType(LineType.DASHED_1);
	graphContext.changeNodeStyle(newNode, nodeRealizer);
	graphContext.setLabelTextForNode(this.getNodeName(), "", newNode);
    }

    @Override
    public String getNodeName() {
	return "sequence";
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
