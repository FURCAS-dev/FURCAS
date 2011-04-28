package org.eclipse.emf.query.index.ui.internal.view.tree.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class ResourceIndexGroup {

	private List<ResourceDescriptor> resourceIndexGroup;

	public ResourceIndexGroup() {
		resourceIndexGroup = new ArrayList<ResourceDescriptor>();
	}

	public List<ResourceDescriptor> getResourceIndexGroup() {
		return resourceIndexGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resourceIndexGroup == null) ? 0 : resourceIndexGroup.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceIndexGroup other = (ResourceIndexGroup) obj;
		if (resourceIndexGroup == null) {
			if (other.resourceIndexGroup != null)
				return false;
		} else if (!resourceIndexGroup.equals(other.resourceIndexGroup))
			return false;
		return true;
	}

	

}
