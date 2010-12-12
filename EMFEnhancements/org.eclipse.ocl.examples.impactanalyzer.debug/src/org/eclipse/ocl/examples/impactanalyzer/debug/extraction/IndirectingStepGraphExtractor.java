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

import java.util.Set;

import org.eclipse.ocl.examples.impactanalyzer.debug.GraphContext;
import org.eclipse.ocl.examples.impactanalyzer.debug.NavigationStepDebugHelperImpl;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.AbstractNavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.IndirectingStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStep;

import y.base.Edge;
import y.base.Node;
import y.base.NodeList;



public class IndirectingStepGraphExtractor extends AbstractGraphExtractor {
    
    public IndirectingStepGraphExtractor(IndirectingStep navigationStep){
	super(navigationStep);
    }
    
    public IndirectingStep getNavigationStep(){
	return (IndirectingStep)getNavigationStepDelegate();
    }
    
    @Override
    public Node buildGraph(GraphContext graphContext, Node parentGroupNode, Node precedingNode) {
	
	
	NodeList nl = new NodeList();

	boolean wasVisitedBefore = graphContext.stepIsVisited(this.getNavigationStep());

	// Create node as subnode of parent node
	Node newNode = graphContext.createNode(this.getNavigationStep());

	if (!wasVisitedBefore) {
	    nl.add(newNode);
	    graphContext.getHierarchyManager().groupSubgraph(nl, parentGroupNode);

	    graphContext.setLabelTextForNode(this.getNodeName(), "", newNode);

	    if (this.getNavigationStep().getActualStep() instanceof AbstractNavigationStep) {
		if (!graphContext.stepIsVisited(this.getNavigationStep().getActualStep())) {
		    GraphExtractor extractor = NavigationStepDebugHelperImpl.createGraphExtractorForNavigationStep(this.getNavigationStep().getActualStep());
		    extractor.buildGraph(graphContext, parentGroupNode, newNode);

		    Edge edgeList[] = graphContext.getGraph().getEdgeArray();
		    for (Edge edge : edgeList) {
			if (edge.source().equals(newNode) && edge.target().equals(graphContext.getVistedNodes().get(this.getNavigationStep().getActualStep())))
			    graphContext.applyDashedEdge(edge);
		    }

		} else {
		    Edge e = graphContext.connectNodes(newNode, graphContext.getVistedNodes().get(this.getNavigationStep().getActualStep()));
		    graphContext.applyDashedEdge(e);
		}
	    } else {
		throw new GraphBuildFailedException();
	    }
	}

	if (precedingNode != null)
	    graphContext.connectNodes(precedingNode, newNode);

	return newNode;
    }
        
    @Override
    public String getNodeName() {
	return "indirecting";
    }

    
    @Override
    public int getSumOfNavigateCounter(Set<NavigationStep> visited) {
        int result = 0;
        if(!visited.contains(getNavigationStep())){
            visited.add(getNavigationStep());
            
            GraphExtractor extractor = NavigationStepDebugHelperImpl.createGraphExtractorForNavigationStep((AbstractNavigationStep)getNavigationStep().getActualStep());
		         
            result += extractor.getSumOfNavigateCounter(visited);
            
            result += getNavigationStep().getNavigateCounter();
        }
        return result;
    }
    
    
}
