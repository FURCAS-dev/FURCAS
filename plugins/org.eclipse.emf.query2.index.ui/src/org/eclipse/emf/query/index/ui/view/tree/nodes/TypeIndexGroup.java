package org.eclipse.emf.query.index.ui.view.tree.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class TypeIndexGroup {
	private List<ResourceType> typeIndexGroup;

	public TypeIndexGroup() {
		typeIndexGroup = new ArrayList<ResourceType>();
	}

	public List<ResourceType> getTypeIndexGroup() {
		return typeIndexGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeIndexGroup == null) ? 0 : typeIndexGroup.hashCode());
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
		TypeIndexGroup other = (TypeIndexGroup) obj;
		if (typeIndexGroup == null) {
			if (other.typeIndexGroup != null)
				return false;
		} else if (!typeIndexGroup.equals(other.typeIndexGroup))
			return false;
		return true;
	}

	
}
