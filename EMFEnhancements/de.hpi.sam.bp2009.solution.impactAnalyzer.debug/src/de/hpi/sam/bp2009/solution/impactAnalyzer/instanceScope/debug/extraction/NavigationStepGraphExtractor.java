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
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.extraction;

import y.base.Node;
import y.base.NodeList;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AbstractNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AllInstancesNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AssociationNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.EmptyResultNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.IdentityNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.OppositePropertyNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PredicateCheckNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.RefImmediateCompositeNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.GraphContext;


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
	return getNavigationStepDelegate();
    }

    @Override
    public Node buildGraph(GraphContext graphContext, Node parentGroupNode, Node precedingNode) {
	NodeList nl = new NodeList();

	// Create node as subnode of parent node
	Node newNode = graphContext.createNode(this.getNavigationStep());

	nl.add(newNode);
	graphContext.getHierarchyManager().groupSubgraph(nl, parentGroupNode);

	String contentString = "";
	if(getNavigationStep() instanceof AssociationNavigationStep || getNavigationStep() instanceof IdentityNavigationStep){
	    contentString = ((AbstractNavigationStep)this.getNavigationStep()).contentToString(null, 0);
	}
	graphContext.setLabelTextForNode(this.getNodeName(), contentString, newNode);

	if (precedingNode != null) {
	    graphContext.connectNodes(precedingNode, newNode);
	}

	return newNode;
    }

    @Override
    public String getNodeName() {
	if(getNavigationStep() instanceof AllInstancesNavigationStep)
	    return "allInstances";
	else if(getNavigationStep() instanceof AssociationNavigationStep)
	    return "associationNavigation";
	else if(getNavigationStep() instanceof EmptyResultNavigationStep)
	    return "empty";
	else if(getNavigationStep() instanceof IdentityNavigationStep)
	    return "identityNavigation";
	else if(getNavigationStep() instanceof RefImmediateCompositeNavigationStep)
	    return "immediateCompositeNavigation";
	else if(getNavigationStep() instanceof PredicateCheckNavigationStep)
	    return "predicateCheckNavigation";
	else if(getNavigationStep() instanceof OppositePropertyNavigationStep)
	    return "oppositePropertyNavigationStep";
	else
	    throw new RuntimeException("The name " + getNavigationStep().getClass() + " of a simple NavigationStep was not defined in NavigationStepGraphExtractor");
    }
}
