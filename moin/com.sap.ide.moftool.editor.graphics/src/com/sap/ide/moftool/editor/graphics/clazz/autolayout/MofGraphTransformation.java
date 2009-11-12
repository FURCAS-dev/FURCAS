package com.sap.ide.moftool.editor.graphics.clazz.autolayout;

import java.awt.Insets;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import y.base.DataProvider;
import y.base.Edge;
import y.base.EdgeMap;
import y.base.Node;
import y.base.NodeMap;
import y.layout.DefaultLayoutGraph;
import y.layout.LayoutGraph;
import y.layout.PortConstraintKeys;
import y.layout.grouping.GroupingKeys;
import y.layout.orthogonal.DirectedOrthogonalLayouter;
import y.util.DataProviderAdapter;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationEndMultiplicityFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationEndNameFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationNameFeature;
import com.sap.mi.gfw.autolayout.ILayoutStructureProvider;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.internal.autolayout.DefaultGraphTransformation;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Polyline;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.mm.pictograms.Text;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PeUtil;

public class MofGraphTransformation extends DefaultGraphTransformation {
	


    private String targetEdgeGroupID = "GeneralizationGroup"; //$NON-NLS-1$

	

    public MofGraphTransformation(IFeatureProvider featureProvider, ILayoutStructureProvider layoutStructureProvider) {
        super(featureProvider, layoutStructureProvider);
    }



	@Override
	public LayoutGraph createLayoutGraph() {
		// create default layout graph
		DefaultLayoutGraph graph = new DefaultLayoutGraph();
		// set data provider for edge type "generalization" (directed layout)
        DataProvider directedDP = new DataProviderAdapter() {
    		public boolean getBool(Object obj) {
    			    if (obj instanceof Edge) {
    			    	Object modelElement = ((Edge)obj).getGraph().getDataProvider(PROVIDER_EDGE_TO_MODEL_REFERENCE).get(obj);
    			    	if (modelElement instanceof Connection) {
    			    		if (PeUtil.getProperty((Connection)modelElement, "generalization") != null) { //$NON-NLS-1$
    			    			return true;
    			    		}
    			    	}
    			    }
    			    return false;
    		}
        };
        graph.addDataProvider(DirectedOrthogonalLayouter.DIRECTED_EDGE_DPKEY, directedDP);
        // set data provider for edge bundling at target
  	    EdgeMap egMap = graph.createEdgeMap();
        graph.addDataProvider(PortConstraintKeys.TARGET_GROUPID_KEY, egMap);
        // create nodes and edges for this graph
		graph = super.createDefaultLayoutGraph(graph);

		return graph;
	}

	@Override
	protected Node createNodes(DefaultLayoutGraph graph,
			PictogramElement pictogramElement, Set allConnections) {
        // get casted data-providers of the graph
        NodeMap nodeToShape = (NodeMap) graph.getDataProvider(GroupingKeys.NODE_ID_DPKEY);
        NodeMap nodeToParentShape = (NodeMap) graph.getDataProvider(GroupingKeys.PARENT_NODE_ID_DPKEY);
        NodeMap nodeHasChildren = (NodeMap) graph.getDataProvider(GroupingKeys.GROUP_DPKEY);
        NodeMap nodeToInsets = (NodeMap) graph.getDataProvider(GroupingKeys.GROUP_NODE_INSETS_DPKEY);
        SimpleDataProvider shapeToNode = (SimpleDataProvider) graph.getDataProvider(PROVIDER_SHAPE_TO_NODE);

        Shape shape = (Shape) pictogramElement;
        Node node = graph.createNode();
        nodeToShape.set(node, shape);
        shapeToNode.set(shape, node);

        IDimension gaSize = GaUtil.calculateSizeOfGraphicsAlgorithm(pictogramElement.getGraphicsAlgorithm(), false);
        graph.setSize(node, gaSize.getWidth(), gaSize.getHeight());

        // additional handling for parents with children
        nodeHasChildren.setBool(node, false);

        // determine insets
        Insets insets = new Insets(0, 0, 0, 0);// getInsets(containerShape.get);
        nodeToInsets.set(node, insets);

        if (pictogramElement instanceof Diagram) {
	        PictogramElement[] children = getLayoutStructureProvider().getChildren(pictogramElement);
	
	        if (children != null) {
	            for (int i = 0; i < children.length; i++) {
	
	                Node childNode = createNodes(graph, children[i], allConnections);
	                if (childNode != null) {
	                    nodeToParentShape.set(childNode, shape);
	                }
	            }
	
	        }
        }

        return node;
	}
	
	@Override
	protected void createEdges(DefaultLayoutGraph graph,
			PictogramElement sourcePE) {
        ILayoutStructureProvider layoutProvider = getLayoutStructureProvider();
        Node sourceNode = getNodeForPE(graph, sourcePE);
        // SimpleDataProvider modelReferenceToOldPoints = (SimpleDataProvider) graph
        // .getDataProvider(PROVIDER_MODEL_REFERENCE_TO_OLD_POINTS);

        EdgeMap edgeToModelReference = (EdgeMap) graph.getDataProvider(PROVIDER_EDGE_TO_MODEL_REFERENCE);

        Connection[] connections = layoutProvider.getOutgoingConnections(sourcePE);
        // for every target -> create connection
        for (int i = 0; i < connections.length; i++) {

            PictogramElement target = layoutProvider.getTarget(connections[i]);

            Node targetNode = getNodeForPE(graph, target);

            Edge edge = graph.createEdge(sourceNode, targetNode);

            if (connections[i].getGraphicsAlgorithm() instanceof Polyline) {
                List<com.sap.mi.gfw.mm.datatypes.Point> pointList = ((Polyline) connections[i].getGraphicsAlgorithm()).getPoints();
                pointList.clear();

                Point points[] = new Point[pointList.size()];
                for (int j = 0; j < points.length; j++) {
                    com.sap.mi.gfw.mm.datatypes.Point gfwPoint = ((com.sap.mi.gfw.mm.datatypes.Point) pointList.get(j));
                    points[j] = new Point(gfwPoint.getX(), gfwPoint.getY());

                    pointList.add(gfwPoint);
                }
                // modelReferenceToOldPoints.set(connections[i], points);

            }

            edgeToModelReference.set(edge, connections[i]);
            
    		if (PeUtil.getProperty(connections[i], "generalization") != null) { //$NON-NLS-1$
    			((EdgeMap)graph.getDataProvider(PortConstraintKeys.TARGET_GROUPID_KEY)).set(edge, targetEdgeGroupID);
    		}


        }

        // Only if the children can be arranged in the parents content-pane
        // (e.g. XYLayout) they are treated as own Nodes.

        PictogramElement[] children = layoutProvider.getChildren(sourcePE);
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                createEdges(graph, children[i]);
            }
        }
	}
	
	public void performLayoutGraph(LayoutGraph graph) {
		// perform auto layout
		super.performLayoutGraph(graph);
		
		// adjust labels (association ends and multiplicities)
		EdgeMap edgeToModelReference = (EdgeMap) graph.getDataProvider(PROVIDER_EDGE_TO_MODEL_REFERENCE);
        Edge[] allEdges = graph.getEdgeArray();

        for (int i = 0; i < allEdges.length; i++) {
            Edge edge = allEdges[i];
            Connection connection = (Connection) edgeToModelReference.get(edge);
            // <pg211108> perform decorator layout independently of update
            performLayoutConnectionDecorators(connection);
        }       

        
	}
	
	// <pg211108> perform decorator layout independently of update
    public static void performLayoutConnectionDecorators(Connection connection) {
    	if (connection == null) {
    		return;
    	}
		Iterator<ConnectionDecorator> it = connection.getConnectionDecorators().iterator();
		ConnectionDecorator deco = null;
		while (it.hasNext()) {
			deco = it.next();
			if (deco != null) {
				GraphicsAlgorithm ga = deco.getGraphicsAlgorithm();
				if (ga != null && ga instanceof Text) {
					int offsetX = 0;
					int offsetY = 0;
					Text text = (Text)ga;
					if (LinkUtil.hasLinkProperty(deco, MOFToolConstants.ASSOCIATION_END_NAME)){
						offsetX = UpdateAssociationEndNameFeature.calculateOffsetX(deco, text);
						offsetY = UpdateAssociationEndNameFeature.calculateOffsetY(deco, text);
						GaUtil.setLocationAndSizeOfGraphicsAlgorithm(text, offsetX, offsetY, 15, 10);
					} else if (LinkUtil.hasLinkProperty(deco, MOFToolConstants.MULTIPLICITY)) {
						offsetX = UpdateAssociationEndMultiplicityFeature.calculateOffsetX(deco, text);
						offsetY = UpdateAssociationEndMultiplicityFeature.calculateOffsetY(deco, text);
						GaUtil.setLocationAndSizeOfGraphicsAlgorithm(text, offsetX, offsetY, 15, 10);							
					} else if (LinkUtil.hasLinkProperty(deco, MOFToolConstants.ASSOCIATION_NAME)) {
						offsetX = UpdateAssociationNameFeature.calculateOffsetX(deco, text);
						offsetY = UpdateAssociationNameFeature.calculateOffsetY(deco, text);
						GaUtil.setLocationAndSizeOfGraphicsAlgorithm(text, offsetX, offsetY, 15, 10);
					}						
				}
			}
			
		}        	
    }
	

	
}
