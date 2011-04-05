package org.eclipse.emf.query.index.ui.view.tree.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 *
 */
public class IncomingLinksGroup {

	private List<EReferenceDescriptor> incomingLinksGroup;

	public IncomingLinksGroup() {
		incomingLinksGroup = new ArrayList<EReferenceDescriptor>();
	}

	public List<EReferenceDescriptor> getIncomingLinksGroup() {
		return incomingLinksGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((incomingLinksGroup == null) ? 0 : incomingLinksGroup.hashCode());
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
		IncomingLinksGroup other = (IncomingLinksGroup) obj;
		if (incomingLinksGroup == null) {
			if (other.incomingLinksGroup != null)
				return false;
		} else if (!incomingLinksGroup.equals(other.incomingLinksGroup))
			return false;
		return true;
	}
	
	
}
