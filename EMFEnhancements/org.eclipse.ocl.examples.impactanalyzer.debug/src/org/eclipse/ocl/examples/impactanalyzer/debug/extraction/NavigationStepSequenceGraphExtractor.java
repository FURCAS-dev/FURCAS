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
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStepSequence;

import y.base.Node;
import y.base.NodeList;
import y.view.LineType;
import y.view.ShapeNodeRealizer;




public class NavigationStepSequenceGraphExtractor extends AbstractGraphExtractor {
    
    public NavigationStepSequenceGraphExtractor(NavigationStepSequence navigationStep){
	super(navigationStep);
    }
    
    public NavigationStepSequence getNavigationStep(){
	return (NavigationStepSequence)getNavigationStepDelegate();
    }
    
    
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
