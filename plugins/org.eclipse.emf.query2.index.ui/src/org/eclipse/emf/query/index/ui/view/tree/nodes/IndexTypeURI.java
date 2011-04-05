package org.eclipse.emf.query.index.ui.view.tree.nodes;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.ui.properties.IndexTypeURIProperties;
import org.eclipse.ui.views.properties.IPropertySource;

public class IndexTypeURI implements IAdaptable {

	URI uri;

	public IndexTypeURI(URI uri) {
		this.uri = uri;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySource.class)
			return new IndexTypeURIProperties(this);
		return null;
	}

	public URI getURI() {
		return uri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		IndexTypeURI other = (IndexTypeURI) obj;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

}
