/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.debug.extraction;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.ocl.examples.impactanalyzer.debug.GraphContext;
import org.eclipse.ocl.examples.impactanalyzer.debug.NavigationStepDebugHelperImpl;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.AbstractNavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.BranchingNavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStep;

import y.base.Node;
import y.base.NodeList;
import y.view.LineType;
import y.view.ShapeNodeRealizer;



public class BranchingNavigationStepGraphExtractor extends AbstractGraphExtractor {

    public BranchingNavigationStepGraphExtractor(BranchingNavigationStep navigationStep){
	super(navigationStep);
    }
    
    public BranchingNavigationStep getNavigationStep(){
	return (BranchingNavigationStep)getNavigationStepDelegate();
    }

    
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
	applyBeginNodeStyle(graphContext, newPrecedingNode);

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
	applyEndNodeStyle(graphContext, endNode);
	parentNodeList.add(endNode);
	graphContext.getHierarchyManager().groupSubgraph(parentNodeList, newParentNode);

	// Draw edges to end Node
	for (Node branchEndNode : resultingNodeList) {
	    graphContext.connectNodes(branchEndNode, endNode);
	}

	return endNode;
    }

    private void applyEndNodeStyle(GraphContext graphContext, Node endNode) {
	ShapeNodeRealizer nodeRealizer = new ShapeNodeRealizer();
	nodeRealizer.setShapeType(ShapeNodeRealizer.TRAPEZOID_2);
	nodeRealizer.setLineType(LineType.DASHED_1);
	graphContext.changeNodeStyle(endNode, nodeRealizer);
	graphContext.setLabelTextForNode("/" + this.getNodeName(), "", endNode);
    }

    private void applyBeginNodeStyle(GraphContext graphContext, Node newPrecedingNode) {
	ShapeNodeRealizer nodeRealizer = new ShapeNodeRealizer();
	nodeRealizer.setShapeType(ShapeNodeRealizer.TRAPEZOID);
	nodeRealizer.setLineType(LineType.DASHED_1);
	graphContext.changeNodeStyle(newPrecedingNode, nodeRealizer);
	graphContext.setLabelTextForNode(this.getNodeName(), "", newPrecedingNode);
    }
    
    
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
