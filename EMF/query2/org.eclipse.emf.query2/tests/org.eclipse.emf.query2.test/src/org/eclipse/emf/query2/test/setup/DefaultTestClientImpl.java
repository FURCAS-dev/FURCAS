package org.eclipse.emf.query2.test.setup;

import java.io.File;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.query.index.DirtyResourceFactory;

public class DefaultTestClientImpl implements TestClient {

	private ResourceSet resourceSet;

	private String parentDirectory = ""; //$NON-NLS-1$

	public DefaultTestClientImpl() {
		this.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		parentDirectory = System.getProperty("java.io.tmpdir");
	}
	
	
	public Resource getOrCreateResourceStable(String name) {

		URI uri = URI.createFileURI(this.parentDirectory + "/" + name);
		Resource res = null;
		res = this.getResourceSet().getResource(uri, false);
		if (res == null) {
			res = this.getResourceSet().createResource(uri);
			try {
				res.load(null);
			} catch (Throwable t) {
				//Assert.fail(t.getLocalizedMessage());
			}
		}
		
		if (!res.isTrackingModification()) {
			res.setTrackingModification(true);
		}
		res.eAdapters().add(DirtyResourceFactory.getInstance());
		return res;
	}

	
	public boolean deleteResourceStable(String name) {
		boolean ret = false;

		URI uri = URI.createFileURI(this.parentDirectory + "/" + name);
		Resource res = this.getResourceSet().getResource(uri, false);
		if (res == null) {
			// create resource if it does not already exist in the resource set (no need to load it)
			res = this.resourceSet.createResource(uri);
		}
		res.eAdapters().remove(DirtyResourceFactory.getInstance());
		if (res != null) {
			try {
				res.delete(null);
				ret = true;
			} catch (IOException e) {
			}
		}

		return ret;
	}

	
	public ResourceSet getResourceSet() {

		if (this.resourceSet == null) {
			this.resourceSet = new ResourceSetImpl();

		}

		return this.resourceSet;
	}

	public void clear() {

		new File(this.parentDirectory).delete();
	}

	
	public void saveAll() throws IOException {

		for (Resource r : this.getResourceSet().getResources()) {
			r.save(Collections.emptyMap());
		}
	}

	
	public Resource getResource(URI uri) {

		return this.getResourceSet().getResource(uri, false);
	}

}
