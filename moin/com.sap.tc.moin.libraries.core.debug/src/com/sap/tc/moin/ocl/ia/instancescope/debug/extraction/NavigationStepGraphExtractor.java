package com.sap.tc.moin.ocl.ia.instancescope.debug.extraction;

import y.base.Node;
import y.base.NodeList;

import com.sap.tc.moin.ocl.ia.instancescope.AllInstancesNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.AssociationNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.EmptyResultNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.IdentityNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.RefImmediateCompositeNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.debug.GraphContext;


/**
 * This class extracts the data out of a NavigationStep and provides the functionality for building a Graph
 * based on the yFiles API.
 * 
 * @author Manuel Holzleitner (d049667)
 */
public class NavigationStepGraphExtractor extends AbstractGraphExtractor {
    
    public NavigationStepGraphExtractor(NavigationStep navigationStep){
	super(navigationStep);
    }
    
    public NavigationStep getNavigationStep(){
	return (NavigationStep)getNavigationStepDelegate();
    }
    
    @Override
    public Node buildGraph(GraphContext graphContext, Node parentGroupNode, Node precedingNode) {
	NodeList nl = new NodeList();

	// Create node as subnode of parent node
	Node newNode = graphContext.createNode(this.getNavigationStep());
	nl.add(newNode);
	graphContext.getHierarchyManager().groupSubgraph(nl, parentGroupNode);

	graphContext.setLabelTextForNode("<< " + this.getNodeName() + ">>", newNode);

	if (precedingNode != null) {
	    graphContext.connectNodes(precedingNode, newNode);
	}

	return newNode;
    }

    @Override
    public String getNodeName() {
	if(getNavigationStep() instanceof AllInstancesNavigationStep){
	    return "allInstances";
	}else if(getNavigationStep() instanceof AssociationNavigationStep){
	    return "associationNavigation";
	}else if(getNavigationStep() instanceof EmptyResultNavigationStep){
	    return "empty";
	}else if(getNavigationStep() instanceof IdentityNavigationStep){
	    return "identityNavigation";
	}else if(getNavigationStep() instanceof RefImmediateCompositeNavigationStep){
	    return "immediateCompositeNavigation";
	}else{
	    throw new RuntimeException("The name of a simple NavigationStep was not defined in NavigationStepGraphExtractor");
	}
    }
}
