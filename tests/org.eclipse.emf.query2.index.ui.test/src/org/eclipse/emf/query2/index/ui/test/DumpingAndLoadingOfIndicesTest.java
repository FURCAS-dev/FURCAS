package org.eclipse.emf.query2.index.ui.test;

import junit.framework.Assert;

import org.junit.Test;

public class DumpingAndLoadingOfIndicesTest extends Assert {

	@Test
	private void testIndexesDumpedAndLoadedOnProperShutdownOfIDE() {
//		Index index = IndexFactory.getInstance();
//		ResourceSet rs = new ResourceSetImpl();
//
//		List<URI> resourceURIs = new ArrayList<URI>();
//
//		System.out.print("Creating resources");
//		long time = System.currentTimeMillis();
//
//		IPath directoryLocationForSave = Activator.getDefault().getStateLocation();
//		Resource r1 = rs.createResource(URI.createFileURI(directoryLocationForSave + "/r1.xmi"));
//
//		Resource r2 = rs.createResource(URI.createFileURI(directoryLocationForSave + "/r2.xmi"));
//
//		resourceURIs.add(r1.getURI());
//		resourceURIs.add(r2.getURI());
//
//		EClass eClass1 = EcoreFactory.eINSTANCE.createEClass();
//		eClass1.setName("EClass1");
//		EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
//		eClass2.setName("EClass2");
//		r1.getContents().add(eClass1);
//		r2.getContents().add(eClass2);
//		eClass1.getESuperTypes().add(eClass2);
//
//		EClass eClass1_2 = EcoreFactory.eINSTANCE.createEClass();
//		eClass1_2.setName("EClass1_2");
//		EClass eClass2_2 = EcoreFactory.eINSTANCE.createEClass();
//		eClass2_2.setName("EClass2_2");
//		r1.getContents().add(eClass1_2);
//		r2.getContents().add(eClass2_2);
//
//		r1.save(null);
//		r2.save(null);
//		r1.unload();
//		r2.unload();
//
//		time = System.currentTimeMillis() - time;
//		System.out.println(time);
//
//		index.save();
//
//		index = new PageableIndexImpl(getOptions());
//		index.load();
//
//		index.executeQueryCommand(new QueryCommand() {
//
//			public void execute(QueryExecutor queryExecutor) {
//				EObjectQuery<EObjectDescriptor> query = IndexQueryFactory.createEObjectQuery();
//				QueryResult<EObjectDescriptor> result = queryExecutor.execute(query);
//				int size = 0;
//				for (EObjectDescriptor eob : result) {
//					System.out.println(eob.getResourceURI() + "#" + eob.getFragment());
//					size++;
//				}
//				assertEquals(5, size);
//			}
//
//		});
//
//		this.deleteResources(Arrays.asList(r.getURI(), r2.getURI()), index);
//
//		r.delete(null);
//		r2.delete(null);
	}

}
