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
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStep;



import y.base.Node;

/**
 * A GraphExtractor is responsible for building a graph structure with all Nodes and Edges out of a NavigationStep and its
 * substeps.
 */
public interface GraphExtractor {
    public Node buildGraph(GraphContext graphContext, Node parent, Node precedingNode);
    
    public Node buildGraph(GraphContext graphContext);
    
    public String getNodeName();

    public boolean hasBeenNavigated();
    
    public int getSumOfNavigateCounter();
    
    public int getSumOfNavigateCounter(Set<NavigationStep> visited);
}
