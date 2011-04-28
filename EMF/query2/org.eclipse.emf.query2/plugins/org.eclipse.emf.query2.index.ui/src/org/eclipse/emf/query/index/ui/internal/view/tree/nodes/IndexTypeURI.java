package org.eclipse.emf.query.index.ui.internal.view.tree.nodes;

import org.eclipse.emf.common.util.URI;

public class IndexTypeURI {

	URI uri;

	public IndexTypeURI(URI uri) {
		this.uri = uri;
	}
	
	public URI getURI() {
		return uri;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndexTypeURI other = (IndexTypeURI) obj;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

}
