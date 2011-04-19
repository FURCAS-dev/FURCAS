package org.eclipse.emf.query.index.ui.view.tree.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 *
 */
public class EObjectsGroup {

	private List<EObjectDescriptor> eObjectsGroup;

	public EObjectsGroup() {
		eObjectsGroup = new ArrayList<EObjectDescriptor>();
	}

	public List<EObjectDescriptor> getEObjectsGroup() {
		return eObjectsGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eObjectsGroup == null) ? 0 : eObjectsGroup.hashCode());
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
		EObjectsGroup other = (EObjectsGroup) obj;
		if (eObjectsGroup == null) {
			if (other.eObjectsGroup != null)
				return false;
		} else if (!eObjectsGroup.equals(other.eObjectsGroup))
			return false;
		return true;
	}

	
}
