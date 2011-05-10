package org.eclipse.emf.query.index.ui.internal.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.internal.properties.EObjectDescriptorProperties;
import org.eclipse.emf.query.index.ui.internal.properties.IndexTypeURIProperties;
import org.eclipse.emf.query.index.ui.internal.properties.IndexViewProperty;
import org.eclipse.emf.query.index.ui.internal.properties.ReferenceDescriptorProperties;
import org.eclipse.emf.query.index.ui.internal.properties.ResourceIndexProperties;
import org.eclipse.emf.query.index.ui.internal.properties.ResourceTypeIndexProperties;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IndexTypeURI;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.PropertyCategory;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceType;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class IndexViewTableContentProvider implements ITreeContentProvider {

	
	public void dispose() {

	}

	
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	
	public Object[] getElements(Object inputElement) {
		List<PropertyCategory> categories = new ArrayList<PropertyCategory>();
		PropertyCategory category = new PropertyCategory();
		category.setParent(inputElement);
		categories.add(category);
		return categories.toArray();

	}

	
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof PropertyCategory) {
			if (((PropertyCategory) parentElement).getParent() instanceof ResourceDescriptor) {
				ResourceDescriptor resDesc = (ResourceDescriptor) ((PropertyCategory) parentElement).getParent();
				ResourceIndexProperties properties = new ResourceIndexProperties(resDesc);
				return properties.getProperties().toArray();
			} else if (((PropertyCategory) parentElement).getParent() instanceof EObjectDescriptor) {
				EObjectDescriptor objDesc = (EObjectDescriptor) ((PropertyCategory) parentElement).getParent();
				EObjectDescriptorProperties properties = new EObjectDescriptorProperties(objDesc);
				return properties.getProperties().toArray();
			} else if (((PropertyCategory) parentElement).getParent() instanceof EReferenceDescriptor) {
				EReferenceDescriptor refDesc = (EReferenceDescriptor) ((PropertyCategory) parentElement).getParent();
				ReferenceDescriptorProperties properties = new ReferenceDescriptorProperties(refDesc);
				return properties.getProperties().toArray();
			} else if (((PropertyCategory) parentElement).getParent() instanceof ResourceType) {
				ResourceType resType = (ResourceType) ((PropertyCategory) parentElement).getParent();
				ResourceTypeIndexProperties properties = new ResourceTypeIndexProperties(resType);
				return properties.getProperties().toArray();
			} else if (((PropertyCategory) parentElement).getParent() instanceof IndexTypeURI) {
				IndexTypeURI indexType = (IndexTypeURI) ((PropertyCategory) parentElement).getParent();
				IndexTypeURIProperties properties = new IndexTypeURIProperties(indexType);
				return properties.getProperties().toArray();
			}else if(((PropertyCategory) parentElement).getParent() instanceof IndexViewProperty){
				IndexViewProperty property = (IndexViewProperty) ((PropertyCategory) parentElement).getParent();
				List<IndexViewProperty> properties = new ArrayList<IndexViewProperty>();
				properties.add(property);
				return properties.toArray();
				
			}

		}
		return null;
	}

	
	public Object getParent(Object element) {
		return null;
	}

	
	public boolean hasChildren(Object element) {
		if (element instanceof PropertyCategory)
			return true;
		return false;
	}

}
