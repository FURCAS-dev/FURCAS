package org.eclipse.emf.query.index.ui.view.legends.impl;

import org.eclipse.emf.query.index.ui.images.IndexUIImageRegistry;
import org.eclipse.emf.query.index.ui.view.legends.ILegend;
import org.eclipse.emf.query.index.ui.view.legends.ILegendManager;
import org.eclipse.emf.query.index.ui.view.legends.Legend;

public class IndexViewLegendManager implements ILegendManager {

	@Override
	public ILegend[] getLegends() {
		ILegend headerlegend = new Legend(null, "Index Descriptors"); //$NON-NLS-1$
		ILegend resourceIndexGroupLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.RESOURCEGROUP_ICON), "Resource Index Group"); //$NON-NLS-1$
		ILegend resourceDescLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.RESOURCE_ICON), "Resource Descriptor"); //$NON-NLS-1$
		ILegend eObjectGroupLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.EOBJECTGROUP_ICON), "EObjects Group"); //$NON-NLS-1$
		ILegend eObjectDescLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.EOBJECT_ICON), "EObject Descriptor"); //$NON-NLS-1$
		ILegend linkLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.LINK_ICON), "Incoming Links, Outgoing Links"); //$NON-NLS-1$
		ILegend incomingLinkLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.INCOMINGLINKSGROUP_ICON), "Incoming Links Group"); //$NON-NLS-1$
		ILegend outgoingLinkLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.OUTGOINGLINKSGROUP_ICON), "Outgoing Links Group"); //$NON-NLS-1$
		ILegend typesLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.TYPES_ICON), "Resource Type Group"); //$NON-NLS-1$
		ILegend typeLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.TYPE_ICON), "Resource Type"); //$NON-NLS-1$

		return new ILegend[] { headerlegend, resourceIndexGroupLegend, resourceDescLegend, eObjectGroupLegend, eObjectDescLegend, incomingLinkLegend, outgoingLinkLegend,
				linkLegend, typesLegend, typeLegend };
	}

}
