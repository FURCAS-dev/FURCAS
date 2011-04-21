package org.eclipse.emf.query.index.ui.internal.view.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.internal.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.internal.impl.PagingResourceDescriptorMap;
import org.eclipse.emf.query.index.internal.maps.LeanMap;
import org.eclipse.emf.query.index.internal.maps.MapEntry;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.internal.properties.IndexViewProperty;
import org.eclipse.emf.query.index.ui.internal.view.IndexView;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.EObjectsGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IncomingLinksGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IndexTypeURI;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.OutgoingLinksGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceIndexGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceType;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.TypeIndexGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.UserData;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.deferred.DeferredContentProvider;

/**
 * 
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class IndexViewTreeContentProvider extends DeferredContentProvider implements ITreeContentProvider {

	private PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resourceIndex;

	@SuppressWarnings("rawtypes")
	public IndexViewTreeContentProvider(Comparator sortOrder) {
		super(sortOrder);
	}

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	public boolean hasChildren(Object element) {
		if (element instanceof ResourceIndexGroup) {
			return true;
		} else if (element instanceof TypeIndexGroup) {
			return true;
		} else if (element instanceof ResourceDescriptor) {
			return true;
		} else if (element instanceof EObjectsGroup) {
			return true;
		} else if (element instanceof IncomingLinksGroup) {
			return true;
		} else if (element instanceof OutgoingLinksGroup) {
			return true;
		} else if (element instanceof ResourceType) {
			return true;
		}
		else if(element instanceof UserData){
			if(((UserData)element).getUserData()!=null){
				return ((UserData)element).getUserData().size()>0;
			}
			return false;
		} else if(element instanceof EObjectDescriptor){
			if(IndexView.isUserDataTableChecked())
				return true;
			else
				return false;
		}
		return false;
	}

	public Object getParent(Object element) {
		return null;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof GlobalTables) {
			ResourceIndexGroup resourceIndices = new ResourceIndexGroup();

			resourceIndex = ((GlobalTables) inputElement).resourceIndex;
			Object[] resourceMap = resourceIndex.getResourceMap();
			List<Object> resources = new ArrayList<Object>();
			for (Object object : resourceMap) {
				if (object != null && object instanceof ResourceDescriptor) {
					if (!((ResourceDescriptor) object).getURI().isEmpty()) {
						resourceIndices.getResourceIndexGroup().add((ResourceDescriptor) object);
					}
				}
			}
			resources.add(resourceIndices);

			TypeIndexGroup typeIndices = new TypeIndexGroup();
			LeanMap<String, URI> elementTypeIndex = ((GlobalTables) inputElement).elementTypeIndex;
			Object[] typeMap = elementTypeIndex.getUnderlyingMapTable();
			for (Object object : typeMap) {
				if (object != null) {
					Object keyType = new Object();
					List<IndexTypeURI> valuesForKeyType = new ArrayList<IndexTypeURI>();
					IndexTypeURI indexTypeUri = null;
					Object[] typesArray = (Object[]) object;
					for (int i = 0; i < typesArray.length; i++) {
						if (i == 0) {
							keyType = typesArray[i];
						} else {
							if (typesArray[i] != null && typesArray[i] instanceof URI) {
								indexTypeUri = new IndexTypeURI((URI) typesArray[i]);
								valuesForKeyType.add(indexTypeUri);
							}
						}
					}
					ResourceType type = new ResourceType(keyType);
					type.getResourceDescriptors().addAll(valuesForKeyType);
					typeIndices.getTypeIndexGroup().add(type);
				}
			}
			resources.add(typeIndices);

			return resources.toArray();
		}
		return null;
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ResourceIndexGroup) {
			List<ResourceDescriptor> resourceIndices = ((ResourceIndexGroup) parentElement).getResourceIndexGroup();
			return resourceIndices.toArray();

		} else if (parentElement instanceof TypeIndexGroup) {
			List<ResourceType> typeIndices = ((TypeIndexGroup) parentElement).getTypeIndexGroup();
			return typeIndices.toArray();
		} else if (parentElement instanceof ResourceDescriptor) {
			resourceIndex.acquire(((ResourceDescriptor) parentElement).getURI());
			List<Object> localTables = new ArrayList<Object>();
			if (IndexView.isActionEObjectTableChecked()) {
				Object[] eObjectTable = ((ResourceDescriptor) parentElement).getEObjectTable();
				EObjectsGroup eObjectGroup = new EObjectsGroup();
				if (eObjectTable != null) {
					for (Object eObjectDescriptor : eObjectTable) {
						if (eObjectDescriptor != null && eObjectDescriptor instanceof EObjectDescriptor) {
							if (!((EObjectDescriptor) eObjectDescriptor).getFragment().isEmpty()) {
								eObjectGroup.getEObjectsGroup().add((EObjectDescriptor) eObjectDescriptor);
							}
						}
					}
				}
				localTables.add(eObjectGroup);
			}
			if (IndexView.isActionIncomingLinksTableChecked()) {
				Object[] incomingLinksMaps = ((ResourceDescriptor) parentElement).getIncomingLinksTable();
				IncomingLinksGroup incomingLinkGroup = new IncomingLinksGroup();
				if (incomingLinksMaps != null) {
					for (Object incomingLinkMap : incomingLinksMaps) {
						if (incomingLinkMap != null) {
							MapEntry[] mapEntries = (MapEntry[]) incomingLinkMap;
							for (MapEntry mapEntry : mapEntries) {
								if (mapEntry instanceof EReferenceDescriptor) {
									incomingLinkGroup.getIncomingLinksGroup().add((EReferenceDescriptor) mapEntry);
								}
							}
						}
					}
				}
				localTables.add(incomingLinkGroup);
			}
			if (IndexView.isActionOutgoingLinksTableChecked()) {
				Object[] outgoingLinkMaps = ((ResourceDescriptor) parentElement).getOutgoingLinkTable();
				OutgoingLinksGroup outgoingLinkGroup = new OutgoingLinksGroup();
				if (outgoingLinkMaps != null) {
					for (Object outgoingLinkMap : outgoingLinkMaps) {
						if (outgoingLinkMap != null) {
							MapEntry[] mapEntries = (MapEntry[]) outgoingLinkMap;
							for (MapEntry mapEntry : mapEntries) {
								if (mapEntry instanceof EReferenceDescriptor) {
									outgoingLinkGroup.getOutgoingLinksGroup().add((EReferenceDescriptor) mapEntry);
								}
							}
						}
					}
				}
				localTables.add(outgoingLinkGroup);
			}
			
			if(IndexView.isUserDataTableChecked()){
				UserData userData = new UserData(parentElement);
				if( ((ResourceDescriptor) parentElement).getUserData()!=null){
					ArrayList<IndexViewProperty> userDataProperties = new ArrayList<IndexViewProperty>();
					Iterator<Entry<String, String>> itr = ((ResourceDescriptor) parentElement).getUserData().entrySet().iterator();
					while(itr.hasNext()){
						Map.Entry<String, String> entry = itr.next();
						IndexViewProperty property = new IndexViewProperty(entry.getKey(),entry.getValue());
						property.setParent(parentElement);
						userDataProperties.add(property);
					}
					userData.getUserData().addAll(userDataProperties);
				}
			localTables.add(userData);
			}
			resourceIndex.release((PageableResourceDescriptorImpl) parentElement);
			return localTables.toArray();
		} else if (parentElement instanceof EObjectsGroup) {
			List<EObjectDescriptor> eObjectsGroup = ((EObjectsGroup) parentElement).getEObjectsGroup();
			return eObjectsGroup.toArray();
		} else if (parentElement instanceof IncomingLinksGroup) {
			List<EReferenceDescriptor> incomingLinksGroup = ((IncomingLinksGroup) parentElement).getIncomingLinksGroup();
			return incomingLinksGroup.toArray();
		} else if (parentElement instanceof OutgoingLinksGroup) {
			List<EReferenceDescriptor> outgoingLinksGroup = ((OutgoingLinksGroup) parentElement).getOutgoingLinksGroup();
			return outgoingLinksGroup.toArray();
		} else if (parentElement instanceof ResourceType) {
			List<IndexTypeURI> resourceDescriptors = ((ResourceType) parentElement).getResourceDescriptors();
			return resourceDescriptors.toArray();
		}else if(parentElement instanceof EObjectDescriptor){
			if(IndexView.isUserDataTableChecked()){
				List<Object> localTables = new ArrayList<Object>();
				UserData userdata = new UserData(parentElement);
				if(((EObjectDescriptor)parentElement).getEObjectUserData()!=null){
					ArrayList<IndexViewProperty> userDataProperties = new ArrayList<IndexViewProperty>();
					Iterator<Entry<String, String>> itr = ((EObjectDescriptor) parentElement).getEObjectUserData().entrySet().iterator();
					while(itr.hasNext()){
						Map.Entry<String, String> entry = itr.next();
						IndexViewProperty property = new IndexViewProperty(entry.getKey(),entry.getValue());
						property.setParent(parentElement);
						userDataProperties.add(property);
					}
					userdata.getUserData().addAll(userDataProperties);
				}
				localTables.add(userdata);
				return localTables.toArray();
			}
		}
		else if(parentElement instanceof UserData){
			return ((UserData)parentElement).getUserData().toArray();
		}
		return null;
	}
}

