package com.sap.mi.gfw.autolayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * a default implementation of an ILayoutProvider which assumes that all children of container shapes should be layouted.
 */
public class DefaultLayoutStructureProvider implements ILayoutStructureProvider {

	private final ContainerShape root;

	/**
	 * Instantiates a new default layout structure provider.
	 * 
	 * @param root
	 *            the root
	 */
	public DefaultLayoutStructureProvider(ContainerShape root) {
		this.root = root;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.autolayout.ILayoutStructureProvider#getChildren(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public PictogramElement[] getChildren(PictogramElement parent) {

		if (parent instanceof ContainerShape) {
			List children = ((ContainerShape) parent).getChildren();
			ArrayList<PictogramElement> retList = new ArrayList<PictogramElement>();
			for (Object child : children) {
				if (child instanceof PictogramElement) {
					PictogramElement childPe = (PictogramElement) child;
					if (childPe.isActive()) {
						retList.add(childPe);
					}
				}
			}
			return retList.toArray(new PictogramElement[retList.size()]);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.autolayout.ILayoutStructureProvider#getRoot()
	 */
	public ContainerShape getRoot() {

		return root;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.autolayout.ILayoutStructureProvider#getOutgoingConnections(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public Connection[] getOutgoingConnections(PictogramElement sourceNode) {

		List<Connection> connections = new ArrayList<Connection>();
		if (sourceNode instanceof AnchorContainer) {
			AnchorContainer anchorContainer = (AnchorContainer) sourceNode;
			Collection anchors = anchorContainer.getAnchors();
			for (Iterator<Anchor> anchorIterator = anchors.iterator(); anchorIterator.hasNext();) {
				Anchor anchor = anchorIterator.next();
				connections.addAll(anchor.getOutgoingConnections());

			}

		}

		return connections.toArray(new Connection[connections.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.autolayout.ILayoutStructureProvider#getTarget(com.sap.mi.gfw.mm.pictograms.Connection)
	 */
	public PictogramElement getTarget(Connection connection) {
		return connection.getEnd().getParent();
	}
}