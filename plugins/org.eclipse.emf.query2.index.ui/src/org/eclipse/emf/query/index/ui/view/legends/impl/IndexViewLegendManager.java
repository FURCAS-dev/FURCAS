package org.eclipse.emf.query.index.ui.view.legends.impl;

import org.eclipse.emf.query.index.ui.images.IndexUIImageRegistry;
import org.eclipse.emf.query.index.ui.view.legends.ILegend;
import org.eclipse.emf.query.index.ui.view.legends.ILegendManager;
import org.eclipse.emf.query.index.ui.view.legends.Legend;

public class IndexViewLegendManager implements ILegendManager {

	public ILegend[] getLegends() {
		ILegend headerlegend = new Legend(null, "Index Descriptors"); 
		ILegend resourceIndexGroupLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.RESOURCEGROUP_ICON), "Resource Index Group"); 
		ILegend resourceDescLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.RESOURCE_ICON), "Resource Descriptor"); 
		ILegend eObjectGroupLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.EOBJECTGROUP_ICON), "EObjects Group"); 
		ILegend eObjectDescLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.EOBJECT_ICON), "EObject Descriptor"); 
		ILegend linkLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.LINK_ICON), "Incoming Links, Outgoing Links"); 
		ILegend incomingLinkLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.INCOMINGLINKSGROUP_ICON), "Incoming Links Group"); 
		ILegend outgoingLinkLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.OUTGOINGLINKSGROUP_ICON), "Outgoing Links Group"); 
		ILegend typesLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.TYPES_ICON), "Resource Type Group"); 
		ILegend typeLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.TYPE_ICON), "Resource Type"); 

		return new ILegend[] { headerlegend, resourceIndexGroupLegend, resourceDescLegend, eObjectGroupLegend, eObjectDescLegend, incomingLinkLegend, outgoingLinkLegend,
				linkLegend, typesLegend, typeLegend };
	}

}
