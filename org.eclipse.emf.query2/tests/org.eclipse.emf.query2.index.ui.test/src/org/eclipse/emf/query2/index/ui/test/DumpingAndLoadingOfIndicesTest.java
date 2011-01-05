package org.eclipse.emf.query2.index.ui.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.Activator;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;
import org.junit.Test;
import org.osgi.framework.BundleContext;

public class DumpingAndLoadingOfIndicesTest extends Assert {

	@Test
	public void testIndexesDumpedAndLoadedOnProperShutdownOfIDE() throws Exception {
		Index index = IndexFactory.getInstance();
		ResourceSet rs = new ResourceSetImpl();

		List<URI> resourceURIs = new ArrayList<URI>();

		System.out.print("Creating resources"); //$NON-NLS-1$
		long time = System.currentTimeMillis();

		final Resource r1 = rs.createResource(URI.createFileURI(getDirectoryToDumpIndices() + "/r1.xmi")); //$NON-NLS-1$

		final Resource r2 = rs.createResource(URI.createFileURI(getDirectoryToDumpIndices() + "/r2.xmi")); //$NON-NLS-1$

		resourceURIs.add(r1.getURI());
		resourceURIs.add(r2.getURI());

		EClass eClass1 = EcoreFactory.eINSTANCE.createEClass();
		eClass1.setName("EClass1"); //$NON-NLS-1$
		EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2.setName("EClass2"); //$NON-NLS-1$
		r1.getContents().add(eClass1);
		r2.getContents().add(eClass2);
		eClass1.getESuperTypes().add(eClass2);

		EClass eClass1_2 = EcoreFactory.eINSTANCE.createEClass();
		eClass1_2.setName("EClass1_2"); //$NON-NLS-1$
		EClass eClass2_2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2_2.setName("EClass2_2"); //$NON-NLS-1$
		r1.getContents().add(eClass1_2);
		r2.getContents().add(eClass2_2);

		r1.save(null);
		r2.save(null);

		this.resourceChanged(index, r1, r2);

		r1.unload();
		r2.unload();

		time = System.currentTimeMillis() - time;
		System.out.println(time);

		BundleContext bundleContext = Activator.getDefault().getBundle().getBundleContext();
		Activator.getDefault().stop(bundleContext);

		boolean indexFileExists = index.isDumpExists();
		assertTrue(indexFileExists);

		IndexFactory.loadIndexes();

		index.executeQueryCommand(new QueryCommand() {

			public void execute(QueryExecutor queryExecutor) {
				ResourceQuery<ResourceDescriptor> query = IndexQueryFactory.createResourceQuery();
				QueryResult<ResourceDescriptor> result = queryExecutor.execute(query);
				int size = 0;
				for (ResourceDescriptor eob : result) {
					if (eob.getURI().equals(r1.getURI()) || eob.getURI().equals(r2.getURI())) {
						size++;
					}
				}
				assertEquals(2, size);
			}

		});

		r1.delete(null);
		r2.delete(null);
		
	}

	private static String getDirectoryToDumpIndices() {
		IPath baseDirectory = Activator.getDefault().getStateLocation().addTrailingSeparator();

		IPath indexDirectoryPath = new Path(baseDirectory.toString() + Path.SEPARATOR + "index" + Path.SEPARATOR); //$NON-NLS-1$
		File indexDir = new File(indexDirectoryPath.toString());
		if (!indexDir.exists()) {
			indexDir.mkdir();
		}
		return indexDirectoryPath.toString();
	}

	private void resourceChanged(Index index, final Resource... r) {
		index.executeUpdateCommand(new UpdateCommandAdapter() {

			public void execute(IndexUpdater updater) {
				new ResourceIndexer() {

					@Override
					protected Map<String, String> getResourceUserData(Resource res) {
						Map<String, String> result = new HashMap<String, String>();
						result.put("key", "abcd"); //$NON-NLS-1$ //$NON-NLS-2$
						return result;
					}

					@Override
					protected Map<String, String> getEObjectUserData(EObject element) {
						Map<String, String> result = new HashMap<String, String>();
						result.put("key", "wxyz"); //$NON-NLS-1$ //$NON-NLS-2$
						return result;
					}
				}.resourceChanged(updater, r);
			}

		});
	}

}
