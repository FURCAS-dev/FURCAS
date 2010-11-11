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
