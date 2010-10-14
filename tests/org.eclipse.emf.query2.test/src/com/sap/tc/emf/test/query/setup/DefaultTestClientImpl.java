package com.sap.tc.emf.test.query.setup;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class DefaultTestClientImpl implements TestClient {

	private ResourceSet resourceSet;

	private String parentDirectory = ""; //$NON-NLS-1$

	public DefaultTestClientImpl() {
		this.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		parentDirectory = System.getProperty("java.io.tmpdir");
	}
	
	@Override
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
		return res;
	}

	@Override
	public boolean deleteResourceStable(String name) {
		boolean ret = false;

		URI uri = URI.createFileURI(this.parentDirectory + "/" + name);
		Resource res = this.getResourceSet().getResource(uri, false);
		if (res == null) {
			// create resource if it does not already exist in the resource set (no need to load it)
			res = this.resourceSet.createResource(uri);
		}
		if (res != null) {
			try {
				res.delete(null);
				ret = true;
			} catch (IOException e) {
			}
		}

		return ret;
	}

	@Override
	public ResourceSet getResourceSet() {

		if (this.resourceSet == null) {
			this.resourceSet = new ResourceSetImpl();
		}

		return this.resourceSet;
	}

	public void clear() {

		new File(this.parentDirectory).delete();
	}

	@Override
	public void saveAll() throws IOException {

		for (Resource r : this.getResourceSet().getResources()) {
			r.save(Collections.emptyMap());
		}
	}

	@Override
	public Resource getResource(URI uri) {

		return this.getResourceSet().getResource(uri, false);
	}

}
