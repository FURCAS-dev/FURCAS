package com.sap.tc.moin.ocl.ia.instancescope.debug.extraction;

import java.util.Set;

import y.base.Edge;
import y.base.Node;
import y.base.NodeList;

import com.sap.tc.moin.ocl.ia.instancescope.AbstractNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.IndirectingStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.debug.GraphContext;
import com.sap.tc.moin.ocl.ia.instancescope.debug.NavigationStepDebugHelperImpl;

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

	    graphContext.setLabelTextForNode("<< " + this.getNodeName() + ">>", newNode);

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
