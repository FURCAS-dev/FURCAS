package org.eclipse.emf.query.index.ui.internal.view.tree.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class OutgoingLinksGroup {

	private List<EReferenceDescriptor> outgoingLinksGroup;

	public OutgoingLinksGroup() {
		outgoingLinksGroup = new ArrayList<EReferenceDescriptor>();
	}

	public List<EReferenceDescriptor> getOutgoingLinksGroup() {
		return outgoingLinksGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outgoingLinksGroup == null) ? 0 : outgoingLinksGroup.hashCode());
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
		OutgoingLinksGroup other = (OutgoingLinksGroup) obj;
		if (outgoingLinksGroup == null) {
			if (other.outgoingLinksGroup != null)
				return false;
		} else if (!outgoingLinksGroup.equals(other.outgoingLinksGroup))
			return false;
		return true;
	}

	
}
