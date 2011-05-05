package org.eclipse.emf.query.index.ui.internal.view.legends.impl;

import org.eclipse.emf.query.index.ui.internal.Messages;
import org.eclipse.emf.query.index.ui.internal.images.IndexUIImageRegistry;
import org.eclipse.emf.query.index.ui.internal.view.legends.ILegend;
import org.eclipse.emf.query.index.ui.internal.view.legends.ILegendManager;
import org.eclipse.emf.query.index.ui.internal.view.legends.Legend;

public class IndexViewLegendManager implements ILegendManager {

	public ILegend[] getLegends() {
		ILegend headerlegend = new Legend(null, Messages.Query2IndexUI_IndexViewLegendManager_IndexDescriptors); 
		ILegend resourceIndexGroupLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.RESOURCEGROUP_ICON), Messages.Query2IndexUI_IndexViewLegendManager_ResourceIndexGroup); 
		ILegend resourceDescLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.RESOURCE_ICON), Messages.Query2IndexUI_IndexViewLegendManager_ResourceDescriptor); 
		ILegend eObjectGroupLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.EOBJECTGROUP_ICON), Messages.Query2IndexUI_IndexViewLegendManager_EObjectsGroup); 
		ILegend eObjectDescLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.EOBJECT_ICON), Messages.Query2IndexUI_IndexViewLegendManager_EObjectDescriptor); 
		ILegend linkLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.LINK_ICON), Messages.Query2IndexUI_IndexViewLegendManager_Links); 
		ILegend incomingLinkLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.INCOMINGLINKSGROUP_ICON), Messages.Query2IndexUI_IndexViewLegendManager_IncomingLinksGroup); 
		ILegend outgoingLinkLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.OUTGOINGLINKSGROUP_ICON), Messages.Query2IndexUI_IndexViewLegendManager_OutgoingLinksGroup); 
		ILegend typesLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.TYPES_ICON), Messages.Query2IndexUI_IndexViewLegendManager_ResourceTypeGroup); 
		ILegend typeLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.TYPE_ICON), Messages.Query2IndexUI_IndexViewLegendManager_ResourceType);
		ILegend userDataGroupLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.USERDATA_GROUPICON),Messages.Query2IndexUI_IndexViewTreeLabelProvider_UserDataTable);
		ILegend userDataKeyLegend = new Legend(IndexUIImageRegistry.getImage(IndexUIImageRegistry.USERDATA_SINGLEICON),Messages.Query2IndexUI_IndexViewLegendManager_userData);

		return new ILegend[] { headerlegend, resourceIndexGroupLegend, resourceDescLegend, eObjectGroupLegend, eObjectDescLegend, incomingLinkLegend, outgoingLinkLegend,
				linkLegend, typesLegend, typeLegend,userDataGroupLegend,userDataKeyLegend };
	}

}
