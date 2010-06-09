package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AbstractNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.extraction.GraphExtractor;

import y.base.Edge;
import y.base.Node;
import y.view.EdgeLabel;
import y.view.EdgeRealizer;
import y.view.Graph2D;
import y.view.NodeLabel;

/**
 * After the graph structure is build by the {@link GraphExtractor} additional information can be added
 * to the graph such like node coloring or annotating nodes with OCL expressions.
 * 
 * @author Manuel Holzleitner (d049667)
 */
public class GraphInformationApplicator {
    GraphContext context;
    private Map<Node, Double> nodeNavigationPercentageList = new HashMap<Node, Double>();
    private Map<Node, NodeLabel> nodeInformationLabelList = new HashMap<Node, NodeLabel>();
    
    public GraphInformationApplicator(GraphContext context){
	this.context = context;
    }
    
    public void applyAllEdgeLabels() {
	Edge edgeArray[] = context.getGraph().getEdgeArray();

	for (Edge edge : edgeArray) {
	    String targetType = getTargetTypeStringOfNode(edge.source());
	    String sourceType = getSourceTypeStringOfNode(edge.target());
	    
	    if(hasEndNode(edge.source())){
		targetType = getSourceTypeStringOfNode(edge.source());
	    }
	    
	    if(isEndNode(edge.target())){
		sourceType = getTargetTypeStringOfNode(edge.source());
	    }
	    
	    setEdgeText(edge, targetType, sourceType);
	}
    }
    
    private boolean isEndNode(Node target) {
	return context.getReverseVisitedEndNodes().containsKey(target);
    }

    public boolean hasEndNode(Node node){
	NavigationStep step = context.getReverseVisitedNodes().get(node);
	return step != null && context.getVisitedEndNodes().containsKey(step);
    }
    
    public String getTargetTypeStringOfNode(Node node) {
	String result = "null";
	NavigationStep step = getNavigationStepOfNode(node);

	if (step != null && step.getTargetType() != null) {
	    result = step.getTargetType().getName();
	}

	return result;
    }

    public String getSourceTypeStringOfNode(Node node) {
	String result = "null";
	NavigationStep step = getNavigationStepOfNode(node);

	if (step != null && step.getSourceType() != null) {
	    result = step.getSourceType().getName();
	}

	return result;
    }
    
    private NavigationStep getNavigationStepOfNode(Node node) {
	NavigationStep step = null;
	if (context.getReverseVisitedNodes().containsKey(node)) {
	    step = context.getReverseVisitedNodes().get(node);

	} else if (context.getReverseVisitedEndNodes().containsKey(node)) {
	    step = context.getReverseVisitedEndNodes().get(node);
	}

	if (step == null) {
	    throw new RuntimeException("Can't get step of node");
	}

	return step;
    }
    
/*    public void applyOclInformation(CoreConnection conn) {
	Node[] nodeArray = context.getGraph().getNodeArray();

	for (Node node : nodeArray) {
	    AbstractNavigationStep navigationStep = (AbstractNavigationStep) context.getReverseVisitedNodes().get(node);

	    if (navigationStep != null) {
		applyOclForNode(navigationStep, node, conn);
	    } else {
		if (context.getVisitedEndNodes().containsValue(node)) {
		    AbstractNavigationStep navigationStepEndNode = (AbstractNavigationStep) context.getReverseVisitedEndNodes().get(node);
		    applyOclForNode(navigationStepEndNode, node, conn);
		}
	    }
	}
    }
    
    private void applyOclForNode(AbstractNavigationStep step, Node node, CoreConnection conn) {
	try {
	    if (conn != null) {

		String singleOclText = OclSerializer.getInstance(conn).serialize((OclExpression) step.getDebugInfo(),
			new RefPackage[0]);
		String rootOclInfo = "\nin root expression\n";
		StringBuffer rootOclExpression = new StringBuffer();

		rootOclExpression.append(OclSerializer.getInstance(conn).serializeAndHighlight(
			getRootExpression((RefObjectImpl) step.getDebugInfo(), conn), (OclExpression) step.getDebugInfo(),
			new RefPackage[0]));

		context.getNodeDescription().set(node, singleOclText + rootOclInfo + rootOclExpression.toString());
	    }
	} catch (OclSerializationException e) {
	    e.printStackTrace();
	}
    }
*/
    
    
    public void applyNavigationCountColoring(NavigationStep firstLevelNavigationStep) {
	createNavigationPercentageList(firstLevelNavigationStep);
	applyColoringBasedOnNavigationPercentageList();
    }

    private void createNavigationPercentageList(NavigationStep firstLevelNavigationStep) {
	Node[] nodeArray = context.getGraph().getNodeArray();

	GraphExtractor extractor = NavigationStepDebugHelperImpl.createGraphExtractorForNavigationStep(firstLevelNavigationStep);
	int navigationCountAll = extractor.getSumOfNavigateCounter();

	for (Node node : nodeArray) {
	    AbstractNavigationStep navigationStep = (AbstractNavigationStep) context.getReverseVisitedNodes().get(node);

	    if (navigationStep != null) {

		if (navigationCountAll != 0) {
		    double navigationPercentage = ((double) navigationStep.getNavigateCounter() / (double) navigationCountAll);

		    nodeNavigationPercentageList.put(node, new Double(navigationPercentage));

		    setInfoTextToNode(node, navigationStep);
		}

		if (navigationStep.isAlwaysEmpty()) {
		    applyIsAlwaysEmpty(node);
		}

	    } else {
		if (context.getVisitedEndNodes().containsValue(node)) {
		    AbstractNavigationStep navigationStepEndNode = (AbstractNavigationStep) context.getReverseVisitedEndNodes().get(node);
		    Node beginNode = context.getVistedNodes().get(navigationStepEndNode);

		    double navigationPercentage = 0.0;
		    if (nodeNavigationPercentageList.size() > 0)
			navigationPercentage = nodeNavigationPercentageList.get(beginNode);

		    nodeNavigationPercentageList.put(node, new Double(navigationPercentage));
		    
		    setInfoTextToNode(node, navigationStepEndNode);

		} else if (!context.getGroupNodeLog().contains(node)) {
		    throw new RuntimeException("One Node has no NavigationStep assigned:" + node);
		}
	    }
	}
    }

    private void setInfoTextToNode(Node node, AbstractNavigationStep navigationStep) {
	appendInfoTextToNode(node, "nc", String.valueOf(navigationStep.getNavigateCounter()));
	appendInfoTextToNode(node, "r", String.valueOf(navigationStep.getResultObjectsCounter()));
    }
    
    private void applyColoringBasedOnNavigationPercentageList() {
	// get maximum percentage to be able to create a color range between 0.0
	// and 1.0
	double result = 0;
	double maxValue = 0;
	for (Double d : nodeNavigationPercentageList.values()) {
	    if (d.doubleValue() > maxValue)
		maxValue = d.doubleValue();

	    result = result + d;
	}

	for (Node node : nodeNavigationPercentageList.keySet()) {
	    double navigationPercentage = nodeNavigationPercentageList.get(node);

	    applyNodeColorInRange(node, navigationPercentage / maxValue);
	}
    }
    
    private void appendInfoTextToNode(Node node, String label, String value) {
	if(nodeInformationLabelList.containsKey(node)){
	    NodeLabel oldLabel = nodeInformationLabelList.get(node);
	    oldLabel.setText(oldLabel.getText() + "\n" + label + ": " + value);
	}else{
	    NodeLabel infoTextLabel = ((Graph2D)context.getGraph()).getRealizer(node).createNodeLabel();
	    infoTextLabel.setModel(NodeLabel.EIGHT_POS);
	    infoTextLabel.setPosition(NodeLabel.E);
	    infoTextLabel.setText(label + ": " + value);
	    infoTextLabel.setFontSize(10);
	    ((Graph2D)context.getGraph()).getRealizer(node).addLabel(infoTextLabel);
	    nodeInformationLabelList.put(node, infoTextLabel);
	}
	
	context.refreshNodeStyle(node);
    }
    
    private void applyIsAlwaysEmpty(Node node) {
	((Graph2D) context.getGraph()).getRealizer(node).setLineColor(Color.RED);
    }

    private void applyNodeColorInRange(Node node, double d) {
	if (d > 0) {
	    Color c = new Color((float) d, (float) (1 - d), 0f);
	    ((Graph2D) context.getGraph()).getRealizer(node).setFillColor(c);
	}
    }
    
    public void setEdgeText(Edge e, String source, String target) {
	EdgeRealizer realizer = ((Graph2D) context.getGraph()).getRealizer(e);

	if (realizer.labelCount() == 2) {
	    realizer.removeLabel(realizer.getLabel());
	    realizer.removeLabel(realizer.getLabel());
	}

	EdgeLabel elSource = realizer.createEdgeLabel();
	realizer.addLabel(elSource);
	elSource.setModel(EdgeLabel.SIX_POS);
	elSource.setPosition(EdgeLabel.SHEAD);
	elSource.setText(source);
	elSource.setFontSize(10);

	EdgeLabel elTarget = realizer.createEdgeLabel();
	realizer.addLabel(elTarget);
	elTarget.setModel(EdgeLabel.SIX_POS);
	elTarget.setPosition(EdgeLabel.THEAD);
	elTarget.setText(target);
	elTarget.setFontSize(10);
    }
    
    /* Disabled Code block, because feature to annotate graphs with OCL expression is not possible yet
     * 

    protected OclExpression getRootExpression(RefObjectImpl x, CoreConnection conn) {
	RefObjectImpl parent = getLogicalImmediateComposite(x, conn);
	while (parent != null) {
	    x = parent;
	    parent = getLogicalImmediateComposite(x, conn);
	}
	return (OclExpression) x;
    }

    private RefObjectImpl getLogicalImmediateComposite(RefObjectImpl x, CoreConnection conn) {
	RefObjectImpl result = (RefObjectImpl) x.refImmediateComposite(conn.getSession());
	if (result == null) {
	    if (x instanceof VariableDeclaration) {
		// maybe this is a tuplePart of a TupleLiteralExp
		ATuplePartTupleLiteralExpImpl a = (ATuplePartTupleLiteralExpImpl) conn
			.getAssociation(ATuplePartTupleLiteralExp.ASSOCIATION_DESCRIPTOR);
		JmiListImpl<TupleLiteralExp> tupleLiteralCollection = ((JmiListImpl<TupleLiteralExp>) a.getTupleLiteralExp(conn,
			(VariableDeclaration) x));
		result = ((TupleLiteralExpImpl) tupleLiteralCollection.iterator(conn).next());
	    } else {
		// check if x is the expression defining a collection item in a
		// collection literal expression
		AItemCollectionItemImpl a = (AItemCollectionItemImpl) conn
			.getAssociation(AItemCollectionItem.ASSOCIATION_DESCRIPTOR);
		result = (RefObjectImpl) a.getCollectionItem(conn, (OclExpression) x);
		if (result == null) {
		    // check if x is the "first" or "last" expression in a
		    // CollectionRange
		    AFirstCollectionRangeImpl firstAssoc = (AFirstCollectionRangeImpl) conn
			    .getAssociation(AFirstCollectionRange.ASSOCIATION_DESCRIPTOR);
		    result = (RefObjectImpl) firstAssoc.getCollectionRange(conn, (OclExpression) x);
		    if (result == null) {
			ALastCollectionRangeImpl lastAssoc = (ALastCollectionRangeImpl) conn
				.getAssociation(ALastCollectionRange.ASSOCIATION_DESCRIPTOR);
			result = (RefObjectImpl) lastAssoc.getCollectionRange(conn, (OclExpression) x);
		    }
		}
		if (result != null && result instanceof CollectionLiteralPart) {
		    // walk right through to the collection literal expression
		    APartsCollectionLiteralExpImpl cleAssoc = (APartsCollectionLiteralExpImpl) conn
			    .getAssociation(APartsCollectionLiteralExp.ASSOCIATION_DESCRIPTOR);
		    result = (RefObjectImpl) ((JmiListImpl<CollectionLiteralExp>) cleAssoc.getCollectionLiteralExp(conn,
			    (CollectionLiteralPart) result)).iterator(conn).next();
		}
	    }
	}
	return result;
    }
    */
    
}
