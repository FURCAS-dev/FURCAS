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
package org.eclipse.ocl.examples.impactanalyzer.debug;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.ocl.examples.impactanalyzer.instanceScope.AbstractNavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStep;

import y.base.Edge;
import y.base.Graph;
import y.base.Node;
import y.base.NodeList;
import y.base.NodeMap;
import y.view.Arrow;
import y.view.Graph2D;
import y.view.LineType;
import y.view.NodeLabel;
import y.view.NodeRealizer;
import y.view.hierarchy.HierarchyManager;

/**
 * The GraphContext is a context within the process of building the graph structure. Therefore it holds the graph object of
 * the yFiles API which is needed to create nodes and edges of the graph. 
 * By traversing the NavigationStep object tree the GraphContext is e.g. used to create new nodes only if the
 * NavigationStep was not visited before. Therefore the context holds a list of visited steps and the according nodes.
 * 
 * @author Manuel Holzleitner (d049667)
 */
public class GraphContext {
    private Graph graph = new Graph2D();
    private Map<NavigationStep, Node> visitedNodes = new HashMap<NavigationStep, Node>();
    private Map<Node, NavigationStep> reverseVisitedNodes = new HashMap<Node, NavigationStep>();

    private Map<NavigationStep, Node> visitedEndNodes = new HashMap<NavigationStep, Node>();
    private Map<Node, NavigationStep> reverseVisitedEndNodes = new HashMap<Node, NavigationStep>();

    private ArrayList<Node> groupNodeLog = new ArrayList<Node>();
    
    private NodeMap nodeDescription = graph.createNodeMap();
    private HierarchyManager hierarchyManager = new HierarchyManager(graph);

    private boolean nestingActive = true;

    public void setHierarchyManager(HierarchyManager hierachyManager) {
	this.hierarchyManager = hierachyManager;
    }

    public HierarchyManager getHierarchyManager() {
	return hierarchyManager;
    }

    public void setVisitedNodes(Map<NavigationStep, Node> vistedNodes) {
	this.visitedNodes = vistedNodes;
    }

    public Map<NavigationStep, Node> getVistedNodes() {
	return visitedNodes;
    }

    public void setGraph(Graph graph) {
	this.graph = graph;
    }

    public Graph getGraph() {
	return graph;
    }

    public Graph2D getGraph2D() {
	return (Graph2D)graph;
    }
    
    public Map<Node, NavigationStep> getReverseVisitedNodes() {
	return reverseVisitedNodes;
    }

    public void setReverseVisitedNodes(Map<Node, NavigationStep> reverseVisitedNodes) {
	this.reverseVisitedNodes = reverseVisitedNodes;
    }

    public boolean stepIsVisited(NavigationStep step) {
	return visitedNodes.containsKey(step);
    }

    public Node createGroupNode(NavigationStep navStep, Node parent, NodeList parentNodeList) {
	Node newNode = hierarchyManager.createGroupNode(parent);
	this.groupNodeLog.add(newNode);

	return newNode;
    }

    public Node createRootNode() {
	Node node = hierarchyManager.createGroupNode(graph);
	groupNodeLog.add(node);
	return node;
    }

    public Node createNode(NavigationStep navStep) {
	Node newNode;
	if (!visitedNodes.containsKey(navStep)) {
	    newNode = graph.createNode();
	    visitedNodes.put(navStep, newNode);
	    reverseVisitedNodes.put(newNode, navStep);

	    if (visitedNodes.size() != reverseVisitedNodes.size()) {
		throw new RuntimeException(
			"Invariant broken: A node must not have multiple steps and a step must not have multiple nodes.");
	    }

	    setIdToNode(newNode, ((AbstractNavigationStep)navStep).getId());
	    setDebugInfoToNode(newNode, navStep.getDebugInfo().toString());
	    
	    refreshNodeStyle(newNode);
	} else {
	    newNode = visitedNodes.get(navStep);
	}

	return newNode;
    }
    
    /**
     * Adjusts width of node according to label text width
     * 
     * @param node
     */
    public void refreshNodeStyle(Node node) {
	((Graph2D) graph).getRealizer(node).setWidth(((Graph2D) graph).getRealizer(node).getLabel().getWidth() + 20);
    }
    
    public void setIdToNode(Node node, int id){
	    NodeLabel idLabel = ((Graph2D)graph).getRealizer(node).createNodeLabel();
	    idLabel.setModel(NodeLabel.EIGHT_POS);
	    idLabel.setPosition(NodeLabel.W);
	    idLabel.setText(String.valueOf(id));
	    idLabel.setFontSize(10);
	    ((Graph2D)graph).getRealizer(node).addLabel(idLabel);
    }
    
    private void setDebugInfoToNode(Node newNode, String debugInfo) {
	getNodeDescription().set(newNode, debugInfo);
    }


    public Node createEndNode(NavigationStep navStep) {
	Node newNode;
	if (!getVisitedEndNodes().containsKey(navStep)) {
	    newNode = graph.createNode();
	    getVisitedEndNodes().put(navStep, newNode);
	    getReverseVisitedEndNodes().put(newNode, navStep);

	    if (getVisitedEndNodes().size() != getReverseVisitedEndNodes().size()) {
		throw new RuntimeException(
			"Invariant broken: A node must not have multiple steps and a step must not have multiple nodes.");
	    }

	    setIdToNode(newNode, ((AbstractNavigationStep)navStep).getId());
	    
	    refreshNodeStyle(newNode);
	} else {
	    newNode = getVisitedEndNodes().get(navStep);
	}

	return newNode;
    }
    
    public void addSideLabelToNode(Node node, String text){
	    NodeLabel nodeLabel = ((Graph2D)graph).getRealizer(node).createNodeLabel(); 
	    nodeLabel.setModel(NodeLabel.EIGHT_POS);
	    nodeLabel.setPosition(NodeLabel.W);
	    nodeLabel.setText(text);
	    ((Graph2D)graph).getRealizer(node).addLabel(nodeLabel);
    }
    
    public void changeNodeStyle(Node node, NodeRealizer nodeRealizer){
	NodeRealizer oldRealizer = ((Graph2D)graph).getRealizer(node);
	for(int i=0; i<oldRealizer.labelCount(); i++){
	    nodeRealizer.addLabel(oldRealizer.getLabel(i));
	}
	
	((Graph2D)graph).setRealizer(node, nodeRealizer);
    }

    public void setLabelTextForNode(String steptype, String text, Node node) {
	if(steptype.equals("")){
	    ((Graph2D) graph).getRealizer(node).setLabelText(text);
	}else{
	    ((Graph2D) graph).getRealizer(node).setLabelText("<html><b>&lt;"+steptype+"&gt;</b><br><center><font size=\"4\">" + text + "</font></center></html>");
	}
	
	refreshNodeStyle(node);
    }

    public void setLabelTextForGroupNode(String text, Node node) {
	((Graph2D) graph).getRealizer(node).setLabelText(text);
    }

    public Edge connectNodes(Node source, Node target) {
	for (Edge e : graph.getEdgeArray()) {
	    if (e.target().equals(target) && e.source().equals(source)) {
		return e;
	    }
	}

	return createEdge(source, target);
    }


    public void applyDashedEdge(Edge edge) {
	((Graph2D) graph).getRealizer(edge).setLineType(LineType.DASHED_1);
    }

    public void applyEmptyNodeColor(Node node) {
	((Graph2D) graph).getRealizer(node).setFillColor(Color.LIGHT_GRAY);
    }

    private Edge createEdge(Node source, Node target) {
	Edge edge = graph.createEdge(source, target);

	((Graph2D) graph).getRealizer(edge).setTargetArrow(Arrow.STANDARD);

	return edge;
    }

    public void setNestingActive(boolean nestingActive) {
	this.nestingActive = nestingActive;
    }

    public boolean isNestingActive() {
	return nestingActive;
    }

    public void setVisitedEndNodes(Map<NavigationStep, Node> visitedEndNodes) {
	this.visitedEndNodes = visitedEndNodes;
    }

    public Map<NavigationStep, Node> getVisitedEndNodes() {
	return visitedEndNodes;
    }

    public void setReverseVisitedEndNodes(Map<Node, NavigationStep> reverseVisitedEndNodes) {
	this.reverseVisitedEndNodes = reverseVisitedEndNodes;
    }

    public Map<Node, NavigationStep> getReverseVisitedEndNodes() {
	return reverseVisitedEndNodes;
    }


    public NodeMap getNodeDescription() {
        return nodeDescription;
    }

    public ArrayList<Node> getGroupNodeLog() {
        return groupNodeLog;
    }

}
