package org.eclipse.emf.query.index.ui.internal.view.tree;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.internal.Messages;
import org.eclipse.emf.query.index.ui.internal.images.IndexUIImageRegistry;
import org.eclipse.emf.query.index.ui.internal.properties.IndexViewProperty;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.EObjectsGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IncomingLinksGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IndexTypeURI;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.OutgoingLinksGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceIndexGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceType;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.TypeIndexGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.UserData;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class IndexViewTreeLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof ResourceIndexGroup) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.RESOURCEGROUP_ICON);
		} else if (element instanceof TypeIndexGroup) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.TYPES_ICON);
		} else if (element instanceof ResourceDescriptor) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.RESOURCE_ICON);
		} else if (element instanceof EObjectsGroup) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.EOBJECTGROUP_ICON);
		} else if (element instanceof IncomingLinksGroup) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.INCOMINGLINKSGROUP_ICON);
		} else if (element instanceof OutgoingLinksGroup) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.OUTGOINGLINKSGROUP_ICON);
		} else if (element instanceof EObjectDescriptor) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.EOBJECT_ICON);
		} else if (element instanceof EReferenceDescriptor) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.LINK_ICON);
		} else if (element instanceof ResourceType) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.TYPE_ICON);
		} else if (element instanceof IndexTypeURI) {
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.RESOURCE_ICON);
		} else if(element instanceof UserData){
			return IndexUIImageRegistry.getImage(IndexUIImageRegistry.USERDATA_GROUPICON);
		} else if(element instanceof IndexViewProperty){
			return  IndexUIImageRegistry.getImage(IndexUIImageRegistry.USERDATA_SINGLEICON);
		}
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ResourceIndexGroup) {
			return Messages.Query2IndexUI_IndexViewTreeLabelProvider_ResourceIndex;
		} else if (element instanceof TypeIndexGroup) {
			return Messages.Query2IndexUI_IndexViewTreeLabelProvider_TypeIndex;
		} else if (element instanceof ResourceDescriptor) {
			URI resourceURI = ((ResourceDescriptor) element).getURI();
			return resourceURI.toString();
		} else if (element instanceof EObjectsGroup) {
			return Messages.Query2IndexUI_IndexViewTreeLabelProvider_EObjectTable;
		} else if (element instanceof IncomingLinksGroup) {
			return Messages.Query2IndexUI_IndexViewTreeLabelProvider_IncomingLinksTable;
		} else if (element instanceof OutgoingLinksGroup) {
			return Messages.Query2IndexUI_IndexViewTreeLabelProvider_OutgoingLinksTable;
		} else if (element instanceof EObjectDescriptor) {
			EObjectDescriptor eObjectDescriptor = (EObjectDescriptor) element;
			String eClassURI = eObjectDescriptor.getEClassURI() + eObjectDescriptor.getFragment();
			return eClassURI;
		} else if (element instanceof EReferenceDescriptor) {
			EReferenceDescriptor referenceDescriptor = (EReferenceDescriptor) element;
			String referenceURI = referenceDescriptor.getEReferenceURI();
			return referenceURI;
		} else if (element instanceof ResourceType) {
			Object elementType = ((ResourceType) element).getElementType();
			return elementType.toString();
		} else if(element instanceof IndexTypeURI){
			URI indexTypeUri = ((IndexTypeURI)element).getURI();
			return indexTypeUri.toString();
		}else if(element instanceof UserData){
			return Messages.Query2IndexUI_IndexViewTreeLabelProvider_UserDataTable;
		} else if(element instanceof IndexViewProperty){
			String userData = ((IndexViewProperty)element).getProperty() + "-->" + ((IndexViewProperty)element).getValue();//$NON-NLS-1$
			if(userData.length() >20)
				userData = userData.subSequence(0,20) + "..."; //$NON-NLS-1$
		    return userData;	
		}
		return super.getText(element);
	}

}
